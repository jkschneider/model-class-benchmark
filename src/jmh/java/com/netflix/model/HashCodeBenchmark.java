package com.netflix.model;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashCodeBenchmark {
    @Benchmark
    public int hashCodeGroovy(GroovyState state) {
        return state.m.hashCode() + state.m2.hashCode();
    }
    @Benchmark public int hashCodeLombok(LombokState state) {
        return state.m.hashCode() + state.m2.hashCode();
    }
    @Benchmark public int hashCodeScala(ScalaState state) {
        return state.m.hashCode() + state.m2.hashCode();
    }
    @Benchmark public int hashCodeKotlin(KotlinState state) {
        return state.m.hashCode() + state.m2.hashCode();
    }
}
