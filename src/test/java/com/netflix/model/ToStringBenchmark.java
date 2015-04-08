package com.netflix.model;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ToStringBenchmark {
    @Benchmark public String toStringJava(JavaState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringIntelliJ(IntelliJState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringEclipse(EclipseState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringGroovy(GroovyState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringLombok(LombokState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringScala(ScalaState state) {
        return state.m.toString();
    }
    @Benchmark public String toStringKotlin(KotlinState state) {
        return state.m.toString();
    }
}
