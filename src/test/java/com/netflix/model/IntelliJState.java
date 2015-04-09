package com.netflix.model;

import com.netflix.model.ide.IntelliJModel;
import com.netflix.model.java.JavaModel;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;

@State(Scope.Benchmark)
public class IntelliJState {
    IntelliJModel m;
    IntelliJModel m2;

    @Setup
    public void prepare() {
        m =  new IntelliJModel(1.0, 1, Arrays.asList("1", "2", "3", "4", "5"), "1","2","3","4","5","6");
        m2 = new IntelliJModel(1.5, 1, Arrays.asList("1","2","3","4","5"), "1","2","3","4","5","6");
    }
}