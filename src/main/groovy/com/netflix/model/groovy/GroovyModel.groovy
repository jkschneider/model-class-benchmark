package com.netflix.model.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@TupleConstructor
@EqualsAndHashCode
@ToString
class GroovyModel {
    Integer integer
    List<String> list
    String str1
    String str2
    String str3
    String str4
    String str5
    String str6
    Double doub
}
