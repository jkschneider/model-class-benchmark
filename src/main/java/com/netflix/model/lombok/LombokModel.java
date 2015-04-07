package com.netflix.model.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(doNotUseGetters = true)
public class LombokModel {
    Integer integer;
    List<String> list;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    Double doub;
}
