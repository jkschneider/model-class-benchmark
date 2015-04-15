package com.netflix.model;

import com.google.common.base.Predicate;
import objectexplorer.MemoryMeasurer;
import objectexplorer.ObjectGraphMeasurer;

import java.util.Arrays;
import java.util.List;


public class ModelMeasurer {
    public static void main(String[] args) {
        List<String> models = Arrays.asList("intellij", "eclipse", "groovy", "staticgroovy", "lombok", "scala", "kotlin", "autovalue");
        for (String model : models) {
            Object m = ModelFactory.create(model);
            Predicate<Object> predicate = new Predicate<Object>() {
                @Override
                public boolean apply(Object input) {
                    return input == null || !input.getClass().getCanonicalName().equals("groovy.lang.MetaClassImpl");
                }
            };
            long bytes = MemoryMeasurer.measureBytes(m, predicate);
            ObjectGraphMeasurer.Footprint footprint = ObjectGraphMeasurer.measure(m, predicate);
            System.out.println(model + " : " + bytes + " bytes, " + footprint);
        }
    }
}
