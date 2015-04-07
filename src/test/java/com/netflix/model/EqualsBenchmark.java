package com.netflix.model;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class EqualsBenchmark {
    @Benchmark public boolean equalsGroovy(GroovyState state) {
        return state.m.equals(state.m2);
    }
    @Benchmark public boolean equalsLombok(LombokState state) {
        return state.m.equals(state.m2);
    }
    @Benchmark public boolean equalsScala(ScalaState state) {
        return state.m.equals(state.m2);
    }
    @Benchmark public boolean equalsKotlin(KotlinState state) {
        return state.m.equals(state.m2);
    }
}
