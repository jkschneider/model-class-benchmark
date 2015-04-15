package com.netflix.model.generated;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class AutoValueModel {
    public static AutoValueModel create(Integer integer, List<String> list, String str1, String str2, String str3,
                                    String str4, String str5, String str6, Double doub) {
        return new AutoValue_AutoValueModel(integer, list, str1, str2, str3, str4, str5, str6, doub);
    }

    abstract Integer integer();
    abstract List<String> list();
    abstract String str1();
    abstract String str2();
    abstract String str3();
    abstract String str4();
    abstract String str5();
    abstract String str6();
    abstract Double doub();
}
