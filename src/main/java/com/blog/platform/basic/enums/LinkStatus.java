package com.blog.platform.basic.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LinkStatus {

    SHOW("显示"),
    HIDDEN("隐藏"),

    ;

    private String desc;
}
