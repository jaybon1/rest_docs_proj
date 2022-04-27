package com.example.rest_docs_proj;

import lombok.Getter;

@Getter
public enum YNEnum {
    // valid 시 value 있어도 되고 없어도 됨 (필수 아님);

    Y("Y"),
    N("N");

    private String tempValue;

    YNEnum(String tempValue) {
        this.tempValue = tempValue;
    }
}
