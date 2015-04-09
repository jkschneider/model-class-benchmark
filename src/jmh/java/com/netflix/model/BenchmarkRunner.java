package com.netflix.model;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(EqualsBenchmark.class.getSimpleName())
            .include(HashCodeBenchmark.class.getSimpleName())
            .include(ToStringBenchmark.class.getSimpleName())
            .warmupIterations(20)
            .measurementIterations(50)
            .forks(1)
            .build();

        new Runner(opt).run();
    }
}
