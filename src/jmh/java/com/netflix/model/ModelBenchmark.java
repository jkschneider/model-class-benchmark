package com.netflix.model;

import com.netflix.model.groovy.GroovyModel;
import com.netflix.model.ide.EclipseModel;
import com.netflix.model.ide.IntelliJModel;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ModelBenchmark {
    @Param({"intellij", "eclipse", "groovy", "lombok", "scala", "kotlin"})
    public String model;

    public Object m;
    public Object m2;

    @Setup
    public void prepareModel() {
        m = getModel(model);
        m2 = getModel(model);
    }

    private Object getModel(String model) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        switch (model) {
            case "intellij":
                return new IntelliJModel(1.0, 1, list, "1", "2", "3", "4", "5", "6");
            case "eclipse":
                return new EclipseModel(1, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "groovy":
                return new GroovyModel(1, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "lombok":
                return new LombokModel(1, list, "1", "2", "3", "4", "5", "6", 1.0);
            case "scala":
                return ScalaModel.apply(1, JavaConverters.collectionAsScalaIterableConverter(list).asScala(),
                        "1", "2", "3", "4", "5", "6", 1.0);
            case "kotlin":
                return new KotlinModel(1, list, "1", "2", "3", "4", "5", "6", 1.0);
            default:
                throw new IllegalArgumentException("Unknown model " + model);
        }
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
    public int hashCode() {
        return m.hashCode();
    }

    @Benchmark
    public String toString() {
        return m.toString();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ModelBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
