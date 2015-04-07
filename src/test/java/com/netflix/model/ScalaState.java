package com.netflix.model;

import com.netflix.model.scala.ScalaModel;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import scala.collection.JavaConverters;

import java.util.Arrays;

@State(Scope.Benchmark)
public class ScalaState {
    ScalaModel m;
    ScalaModel m2;

    @Setup
    public void prepare() {
        m = ScalaModel.apply(1, JavaConverters.collectionAsScalaIterableConverter(Arrays.asList("1", "2", "3", "4", "5")).asScala(),
                "1","2","3","4","5","6", 1.0);
        m2 = ScalaModel.apply(1, JavaConverters.collectionAsScalaIterableConverter(Arrays.asList("1", "2", "3", "4", "5")).asScala(),
                "1","2","3","4","5","6", 1.5);
    }
}