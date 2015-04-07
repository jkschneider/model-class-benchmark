package com.netflix.model;

import com.netflix.model.groovy.GroovyModel;
import com.netflix.model.kotlin.KotlinModel;
import com.netflix.model.lombok.LombokModel;
import com.netflix.model.scala.ScalaModel;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import scala.collection.JavaConverters;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ModelBenchmark {
    @State(Scope.Benchmark)
    public static class GroovyState {
        GroovyModel m;
        GroovyModel m2;

        @Setup
        public void prepare() {
            m =  new GroovyModel(1, Arrays.asList("1","2","3","4","5"), "1","2","3","4","5","6", 1.0);
            m2 = new GroovyModel(1, Arrays.asList("1","2","3","4","5"), "1","2","3","4","5","6", 1.5);
        }
    }

    @Benchmark
    public boolean groovy(GroovyState state) {
        return state.m.equals(state.m2);
    }

    @State(Scope.Benchmark)
    public static class LombokState {
        LombokModel m;
        LombokModel m2;

        @Setup
        public void prepare() {
            m =  new LombokModel(1, Arrays.asList("1","2","3","4","5"), "1","2","3","4","5","6", 1.0);
            m2 = new LombokModel(1, Arrays.asList("1","2","3","4","5"), "1","2","3","4","5","6", 1.5);
        }
    }

    @Benchmark
    public boolean lombok(LombokState state) {
        return state.m.equals(state.m2);
    }

    @State(Scope.Benchmark)
    public static class ScalaState {
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

    @Benchmark
    public boolean scala(ScalaState state) {
        return state.m.equals(state.m2);
    }

    @State(Scope.Benchmark)
    public static class KotlinState {
        KotlinModel m;
        KotlinModel m2;

        @Setup
        public void prepare() {
            m = new KotlinModel(1, Arrays.asList("1", "2", "3", "4", "5"), "1","2","3","4","5","6", 1.0);
            m2 = new KotlinModel(1, Arrays.asList("1", "2", "3", "4", "5"), "1","2","3","4","5","6", 1.5);
        }
    }

    @Benchmark
    public boolean kotlin(KotlinState state) {
        return state.m.equals(state.m2);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ModelBenchmark.class.getSimpleName())
                .warmupIterations(20)
                .measurementIterations(50)
//                .addProfiler(GCProfiler.class)
//                .addProfiler(StackProfiler.class)
//                .addProfiler(HotspotMemoryProfiler.class)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
