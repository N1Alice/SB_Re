package com.ll.sb_re231120.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
    //미완성 시켜라, T는 정해진것이 아닌 임의
}

