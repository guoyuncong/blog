package com.blog.platform.basic.event.log;

import com.blog.platform.basic.enums.LoginLogType;
import com.blog.platform.basic.util.ServletUtils;
import com.blog.platform.security.LoginUser;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 保存日志
 */
@Getter
public class LogEvent extends ApplicationEvent {

    private String userId;

    private String uri;

    public LogEvent(Object source) {
        super(source);
    }

    public LogEvent(Object source, LoginUser loginUser, LoginLogType loginLogType) {
        super(source);
        this.uri = ServletUtils.getRequest().getRequestURI();
    }
}
