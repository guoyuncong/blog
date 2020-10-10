package com.blog.platform.model.entity;

import com.blog.platform.basic.enums.AttachmentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 附件表
 */
@Getter
@Setter
@ToString
public class Attachment extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String attachmentId;

    /**
     * 附件名称
     */
    private String attachmentName;

    /**
     * 附件类型
     */
    private AttachmentType attachmentType;

    /**
     * 附件大小
     */
    private Long attachmentSize;

    /**
     * 附件高度
     */
    private Integer attachmentHeight;

    /**
     * 附件宽度
     */
    private Integer attachmentWidth;

    /**
     * 附件后缀
     */
    private String attachmentSuffix;

    /**
     * 附件地址
     */
    private String attachmentPath;

}
