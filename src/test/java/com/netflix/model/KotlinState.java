package com.netflix.model;

import com.netflix.model.kotlin.KotlinModel;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;

@State(Scope.Benchmark)
public class KotlinState {
    KotlinModel m;
    KotlinModel m2;

    @Setup
    public void prepare() {
        m = new KotlinModel(1, Arrays.asList("1", "2", "3", "4", "5"), "1","2","3","4","5","6", 1.0);
        m2 = new KotlinModel(1, Arrays.asList("1", "2", "3", "4", "5"), "1","2","3","4","5","6", 1.5);
    }
}