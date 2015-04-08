package com.netflix.model.java;

import java.util.List;

public class JavaModel {
    private Integer integer;
    private List<String> list;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private Double doub;

    public JavaModel(Integer integer, List<String> list, String str1, String str2, String str3, String str4, String str5, String str6, Double doub) {
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

    public Double getDoub() {
        return doub;
    }

    public void setDoub(Double doub) {
        this.doub = doub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaModel javaModel = (JavaModel) o;

        if (integer != null ? !integer.equals(javaModel.integer) : javaModel.integer != null) return false;
        if (list != null ? !list.equals(javaModel.list) : javaModel.list != null) return false;
        if (str1 != null ? !str1.equals(javaModel.str1) : javaModel.str1 != null) return false;
        if (str2 != null ? !str2.equals(javaModel.str2) : javaModel.str2 != null) return false;
        if (str3 != null ? !str3.equals(javaModel.str3) : javaModel.str3 != null) return false;
        if (str4 != null ? !str4.equals(javaModel.str4) : javaModel.str4 != null) return false;
        if (str5 != null ? !str5.equals(javaModel.str5) : javaModel.str5 != null) return false;
        if (str6 != null ? !str6.equals(javaModel.str6) : javaModel.str6 != null) return false;
        return !(doub != null ? !doub.equals(javaModel.doub) : javaModel.doub != null);

    }

    @Override
    public int hashCode() {
        int result = integer != null ? integer.hashCode() : 0;
        result = 31 * result + (list != null ? list.hashCode() : 0);
        result = 31 * result + (str1 != null ? str1.hashCode() : 0);
        result = 31 * result + (str2 != null ? str2.hashCode() : 0);
        result = 31 * result + (str3 != null ? str3.hashCode() : 0);
        result = 31 * result + (str4 != null ? str4.hashCode() : 0);
        result = 31 * result + (str5 != null ? str5.hashCode() : 0);
        result = 31 * result + (str6 != null ? str6.hashCode() : 0);
        result = 31 * result + (doub != null ? doub.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JavaModel{" +
                "integer=" + integer +
                ", list=" + list +
                ", str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", str3='" + str3 + '\'' +
                ", str4='" + str4 + '\'' +
                ", str5='" + str5 + '\'' +
                ", str6='" + str6 + '\'' +
                ", doub=" + doub +
                '}';
    }
}
