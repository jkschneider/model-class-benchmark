package com.netflix.model;

import com.netflix.model.generated.AutoValueModel;
import com.netflix.model.generated.LombokModel;
import com.netflix.model.groovy.GroovyModel;
import com.netflix.model.groovy.StaticGroovyModel;
import com.netflix.model.ide.EclipseModel;
import com.netflix.model.ide.IntelliJModel;
import com.netflix.model.kotlin.KotlinModel;
import com.netflix.model.scala.ScalaModel;
import scala.collection.JavaConverters;

import java.util.Arrays;
import java.util.List;

public final class ModelFactory {
    public static Object create(String model) {
        return create(model, 1);
    }

    public static Object create(String model, Integer integer) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        switch (model) {
            case "intellij":
                return new IntelliJModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "eclipse":
                return new EclipseModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "groovy":
                return new GroovyModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "staticgroovy":
                return new StaticGroovyModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "lombok":
                return new LombokModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "scala":
                return ScalaModel.apply(integer, JavaConverters.collectionAsScalaIterableConverter(list).asScala(),
                        "1", "2", "3", "4", "5", "6", 1.0);
            case "kotlin":
                return new KotlinModel(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "autovalue":
                return AutoValueModel.create(integer, list, "1", "2", "3", "4", "5", "6", 1.0);
            default:
                throw new IllegalArgumentException("Unknown model " + model);
        }
    }

}
