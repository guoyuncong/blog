package com.blog.platform.basic.aop.aspect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.OperateStatus;
import com.blog.platform.basic.util.IpUtils;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.basic.util.ServletUtils;
import com.blog.platform.model.entity.OperateLog;
import com.blog.platform.service.OperateLogService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 操作日志记录处理
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Aspect
@Component
@AllArgsConstructor
public class LogAspect {

    private final OperateLogService operateLogService;

    /**
     * 织入点
     */
    @Pointcut("@annotation(com.blog.platform.basic.annotation.Log)")
    public void logPointCut() {
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     */
    @AfterThrowing(value = "logPointCut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
        handleLog(joinPoint, ex, null);
    }

    /**
     * 处理日志信息
     *
     * @param joinPoint
     * @param ex
     * @param jsonObject
     */
    private void handleLog(JoinPoint joinPoint, Exception ex, Object jsonObject) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Class<?> aClass = joinPoint.getTarget().getClass();
        Object[] args = joinPoint.getArgs();
        Log log = method.getAnnotation(Log.class);
        OperateLog operateLog = combineOperateLog(log, method, aClass, args);
        operateLog.setStatus(OperateStatus.SUCCESS.ordinal());
        if (ex != null) {
            operateLog.setStatus(OperateStatus.FAILURE.ordinal());
            operateLog.setErrorMsg(StrUtil.sub(ex.getMessage(), 0, 2000));
        }
        operateLog.setResult(JSON.toJSONString(jsonObject));
        operateLogService.save(operateLog);
    }


    /**
     * 组合操作日志bean
     *
     * @param log    Log
     * @param method 方法
     * @param aClass 类
     * @param args   参数
     * @return bean
     */
    private OperateLog combineOperateLog(Log log, Method method, Class<?> aClass, Object[] args) {
        HttpServletRequest request = ServletUtils.getRequest();
        String loginUserId = SecurityUtil.getLoginUserId();
        OperateLog operateLog = new OperateLog();
        operateLog.setModule(log.module());
        operateLog.setBusinessType(log.businessType().name());
        String className = aClass.getName();
        operateLog.setMethod(className + "." + method.getName());
        String requestWay = ServletUtils.getRequest().getMethod();
        operateLog.setWay(requestWay);
        operateLog.setUserId(loginUserId);
        operateLog.setUri(request.getRequestURI());
        operateLog.setIp(IpUtils.getHostIp());
        if (log.saveParam()) {
            operateLog.setParam(handleRequestParam(args, requestWay));
        }
        operateLog.setCreateBy(loginUserId);
        return operateLog;
    }

    /**
     * 处理请求参数
     *
     * @param args       参数
     * @param requestWay 请求方式
     * @return String
     */
    private String handleRequestParam(Object[] args, String requestWay) {
        if (HttpMethod.PUT.name().equals(requestWay) || HttpMethod.POST.name().equals(requestWay)) {
            return argsToString(args);
        } else {
            Map<?, ?> paramsMap = (Map<?, ?>) ServletUtils.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            return StrUtil.sub(paramsMap.toString(), 0, 2000);
        }
    }


    /**
     * 请求参数拼接
     *
     * @param paramsArray 请求参数
     * @return String
     */
    private String argsToString(Object[] paramsArray) {
        StringBuilder params = new StringBuilder();
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
                if (!isFilterObject(paramsArray[i])) {
                    Object jsonObj = JSON.toJSON(paramsArray[i]);
                    params.append(jsonObj.toString()).append(" ");
                }
            }
        }
        return params.toString().trim();
    }

    /**
     * 判断是否需要过滤的对象
     *
     * @param obj bean
     * @return boolean
     */
    public boolean isFilterObject(final Object obj) {
        return obj instanceof MultipartFile || obj instanceof HttpServletRequest || obj instanceof HttpServletResponse;
    }
}
