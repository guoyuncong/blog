package com.blog.platform.basic.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LinkType {

    HOME("首页"),

    ;

    private String desc;
}
