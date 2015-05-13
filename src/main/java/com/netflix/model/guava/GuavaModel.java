package com.netflix.model.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Using Guava recommendations for equals, hashCode and toString
 */
public class GuavaModel {
    Integer integer;
    List<String> list;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    Double doub;

    public GuavaModel(Integer integer, List<String> list, String str1, String str2, String str3, String str4, String str5, String str6, Double doub) {
        this.integer = integer;
        this.list = list;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
        this.doub = doub;
    }

    public Double getDoub() {
        return doub;
    }

    public void setDoub(Double doub) {
        this.doub = doub;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4;
    }

    public String getStr5() {
        return str5;
    }

    public void setStr5(String str5) {
        this.str5 = str5;
    }

    public String getStr6() {
        return str6;
    }

    public void setStr6(String str6) {
        this.str6 = str6;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("GuavaModel")
                .add("integer", integer)
                .add("list", list)
                .add("str1", str1)
                .add("str2", str2)
                .add("str3", str3)
                .add("str4", str4)
                .add("str5", str5)
                .add("str6", str6)
                .add("doub", doub)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(integer, list, str1, str2, str3, str4, str5, str6, doub);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final GuavaModel other = (GuavaModel) obj;
        return Objects.equal(this.integer, other.integer)
                && Objects.equal(this.list, other.list)
                && Objects.equal(this.str1, other.str1)
                && Objects.equal(this.str2, other.str2)
                && Objects.equal(this.str3, other.str3)
                && Objects.equal(this.str4, other.str4)
                && Objects.equal(this.str5, other.str5)
                && Objects.equal(this.str6, other.str6)
                && Objects.equal(this.doub, other.doub);
    }
}
