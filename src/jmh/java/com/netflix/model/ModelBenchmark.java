package com.netflix.model;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ModelBenchmark {
    @Param({"intellij", "eclipse", "groovy", "groovystatic", "lombok", "scala", "kotlin", "kotlinlazy", "autovalue", "guava"})
    public String model;

    public Object m;
    public Object m2;
    public Object o = new Object();

    @Setup
    public void prepareModel() {
        m = create();
        m2 = create();
    }

    @Benchmark
    public Object create() {
        return ModelFactory.create(model);
    }

    @Benchmark
    public boolean equalsWorstCase() {
        return m.equals(m2);
    }

    @SuppressWarnings("EqualsWithItself")
    @Benchmark
    public boolean equalsIdentity() {
        return m.equals(m);
    }

    @SuppressWarnings("ObjectEqualsNull")
    @Benchmark
    public boolean equalsNull() {
        return m.equals(null);
    }

    @Benchmark
    public boolean equalsOtherType() {
        return m.equals(o);
    }

    @Benchmark
    public int hashCode() {
        return m.hashCode();
    }

    @Benchmark
    public int firstHashCode() {
        return create().hashCode();
    }

    @Benchmark
    public String toString() {
        return m.toString();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ModelBenchmark.class.getSimpleName())
                .warmupIterations(15)
                .measurementIterations(30)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
