# Benchmarking JVM model classes

This is a quick study of the relative performance and size of the typical DTO methods generated by:

* Groovy 2.4.3 annotations
* Scala 2.11.6 case classes
* Kotlin 0.11.91.1 data classes
* Lombok and AutoValue annotation generated
* Eclipse and IntelliJ auto-generated
* Guava recommendations

## Notes

* Caching `hashCode()` values for immutable classes is an important optimisation, that can't be inferred and needs to be manually implemented
*We also don't consider the quality of the `hashCode()` implementation. They may take the same time, but result in poor hash distribution
* Groovy 2.3.9 scored over 1000 ns/op on `equals()` with a similar error margin as below, prompting an upgrade to 2.4.3

# Running

To run locally:

* Benchmarks - `./gradlew jmh` (it should take about 30 minutes and the results will be in ./build/reports/jmh/human.txt)
* Memory - `./gradlew measureMemory`

# Benchmarks

    # JMH 1.8 (released 8 days ago)
    # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/bin/java
    # VM options: -Dfile.encoding=UTF-8 -Duser.country=US -Duser.language=en -Duser.variant
    # Warmup: 15 iterations, 1 s each
    # Measurement: 30 iterations, 1 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op

    Model Name: MacBook Pro
    Model Identifier: MacBookPro11,2
    Processor Name: Intel Core i7
    Processor Speed: 2.8 GHz
    Number of Processors: 1
    Total Number of Cores: 4
    L2 Cache (per Core): 256 KB
    L3 Cache: 6 MB
    Memory: 16 GB

## Object instantiation

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.create               intellij  avgt   30    22.157 ±  0.217  ns/op
    ModelBenchmark.create                eclipse  avgt   30    23.090 ±  0.173  ns/op
    ModelBenchmark.create                 groovy  avgt   30    29.400 ±  0.203  ns/op
    ModelBenchmark.create           groovystatic  avgt   30    26.915 ±  0.194  ns/op
    ModelBenchmark.create                 lombok  avgt   30    22.047 ±  0.212  ns/op
    ModelBenchmark.create                  scala  avgt   30    25.742 ±  0.287  ns/op
    ModelBenchmark.create                 kotlin  avgt   30    21.753 ±  0.309  ns/op
    ModelBenchmark.create             kotlinlazy  avgt   30    26.180 ±  0.248  ns/op
    ModelBenchmark.create              autovalue  avgt   30    23.076 ±  0.191  ns/op
    ModelBenchmark.create                  guava  avgt   30    22.856 ±  0.168  ns/op

## equals()

Equals against the same model instance:

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.equalsIdentity       intellij  avgt   30     4.024 ±  0.028  ns/op
    ModelBenchmark.equalsIdentity        eclipse  avgt   30     2.663 ±  0.020  ns/op
    ModelBenchmark.equalsIdentity         groovy  avgt   30     6.622 ±  0.040  ns/op
    ModelBenchmark.equalsIdentity   groovystatic  avgt   30     4.016 ±  0.040  ns/op
    ModelBenchmark.equalsIdentity         lombok  avgt   30     4.018 ±  0.033  ns/op
    ModelBenchmark.equalsIdentity          scala  avgt   30     2.597 ±  0.022  ns/op
    ModelBenchmark.equalsIdentity         kotlin  avgt   30     2.615 ±  0.037  ns/op
    ModelBenchmark.equalsIdentity     kotlinlazy  avgt   30     2.602 ±  0.023  ns/op
    ModelBenchmark.equalsIdentity      autovalue  avgt   30     2.640 ±  0.019  ns/op
    ModelBenchmark.equalsIdentity          guava  avgt   30     2.611 ±  0.029  ns/op

Equals null:

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.equalsNull           intellij  avgt   30     4.076 ±  0.038  ns/op
    ModelBenchmark.equalsNull            eclipse  avgt   30     2.632 ±  0.029  ns/op
    ModelBenchmark.equalsNull             groovy  avgt   30     3.942 ±  0.045  ns/op
    ModelBenchmark.equalsNull       groovystatic  avgt   30     3.913 ±  0.041  ns/op
    ModelBenchmark.equalsNull             lombok  avgt   30     4.351 ±  0.045  ns/op
    ModelBenchmark.equalsNull              scala  avgt   30     2.631 ±  0.022  ns/op
    ModelBenchmark.equalsNull             kotlin  avgt   30     2.629 ±  0.028  ns/op
    ModelBenchmark.equalsNull         kotlinlazy  avgt   30     2.627 ±  0.030  ns/op
    ModelBenchmark.equalsNull          autovalue  avgt   30     2.666 ±  0.025  ns/op
    ModelBenchmark.equalsNull              guava  avgt   30     2.643 ±  0.023  ns/op


Equals against an instance with a different type:

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.equalsOtherType      intellij  avgt   30     4.472 ±  0.036  ns/op
    ModelBenchmark.equalsOtherType       eclipse  avgt   30     3.272 ±  0.041  ns/op
    ModelBenchmark.equalsOtherType        groovy  avgt   30     6.705 ±  0.087  ns/op
    ModelBenchmark.equalsOtherType  groovystatic  avgt   30     4.910 ±  0.038  ns/op
    ModelBenchmark.equalsOtherType        lombok  avgt   30     5.905 ±  0.304  ns/op
    ModelBenchmark.equalsOtherType         scala  avgt   30     3.398 ±  0.031  ns/op
    ModelBenchmark.equalsOtherType        kotlin  avgt   30     3.386 ±  0.034  ns/op
    ModelBenchmark.equalsOtherType    kotlinlazy  avgt   30     3.394 ±  0.037  ns/op
    ModelBenchmark.equalsOtherType     autovalue  avgt   30     3.610 ±  0.025  ns/op
    ModelBenchmark.equalsOtherType         guava  avgt   30     3.271 ±  0.048  ns/op

Equals against an equal, but different instance:

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.equalsWorstCase      intellij  avgt   30    28.162 ±  0.289  ns/op
    ModelBenchmark.equalsWorstCase       eclipse  avgt   30    28.493 ±  0.256  ns/op
    ModelBenchmark.equalsWorstCase        groovy  avgt   30   284.807 ±  3.706  ns/op
    ModelBenchmark.equalsWorstCase  groovystatic  avgt   30    46.680 ±  0.472  ns/op
    ModelBenchmark.equalsWorstCase        lombok  avgt   30    27.754 ±  0.257  ns/op
    ModelBenchmark.equalsWorstCase         scala  avgt   30    27.396 ±  0.330  ns/op
    ModelBenchmark.equalsWorstCase        kotlin  avgt   30    73.141 ±  0.651  ns/op
    ModelBenchmark.equalsWorstCase    kotlinlazy  avgt   30    29.659 ±  0.325  ns/op
    ModelBenchmark.equalsWorstCase     autovalue  avgt   30    26.905 ±  0.319  ns/op
    ModelBenchmark.equalsWorstCase         guava  avgt   30    28.181 ±  0.297  ns/op

## firstHashCode()

Allows comparison of expense of lazy initialisation of hashCode for lazy classes. Includes object creation overhead.

    ModelBenchmark.firstHashCode        intellij  avgt   30    44.858 ±  0.276  ns/op
    ModelBenchmark.firstHashCode         eclipse  avgt   30    45.929 ±  0.395  ns/op
    ModelBenchmark.firstHashCode          groovy  avgt   30   824.708 ± 12.540  ns/op
    ModelBenchmark.firstHashCode    groovystatic  avgt   30   726.060 ±  5.983  ns/op
    ModelBenchmark.firstHashCode          lombok  avgt   30    45.172 ±  0.581  ns/op
    ModelBenchmark.firstHashCode           scala  avgt   30    68.644 ±  0.498  ns/op
    ModelBenchmark.firstHashCode          kotlin  avgt   30    41.501 ±  0.427  ns/op
    ModelBenchmark.firstHashCode      kotlinlazy  avgt   30   125.924 ±  1.734  ns/op
    ModelBenchmark.firstHashCode       autovalue  avgt   30    42.409 ±  0.580  ns/op
    ModelBenchmark.firstHashCode           guava  avgt   30   108.756 ±  1.352  ns/op

## hashCode()

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.hashCode             intellij  avgt   30    25.924 ±  0.200  ns/op
    ModelBenchmark.hashCode              eclipse  avgt   30    27.128 ±  0.225  ns/op
    ModelBenchmark.hashCode               groovy  avgt   30   790.066 ±  7.902  ns/op
    ModelBenchmark.hashCode         groovystatic  avgt   30   705.565 ±  7.212  ns/op
    ModelBenchmark.hashCode               lombok  avgt   30    27.113 ±  0.300  ns/op
    ModelBenchmark.hashCode                scala  avgt   30    45.070 ±  0.705  ns/op
    ModelBenchmark.hashCode               kotlin  avgt   30    27.024 ±  0.255  ns/op
    ModelBenchmark.hashCode           kotlinlazy  avgt   30     4.101 ±  0.039  ns/op
    ModelBenchmark.hashCode            autovalue  avgt   30    25.372 ±  0.210  ns/op
    ModelBenchmark.hashCode                guava  avgt   30    92.790 ±  1.038  ns/op

## toString()

    Benchmark                            (model)  Mode  Cnt     Score    Error  Units
    ModelBenchmark.toString             intellij  avgt   30   360.352 ±  3.316  ns/op
    ModelBenchmark.toString              eclipse  avgt   30   344.785 ±  2.575  ns/op
    ModelBenchmark.toString               groovy  avgt   30  2459.703 ± 29.160  ns/op
    ModelBenchmark.toString         groovystatic  avgt   30  2256.511 ± 20.937  ns/op
    ModelBenchmark.toString               lombok  avgt   30   346.593 ±  2.323  ns/op
    ModelBenchmark.toString                scala  avgt   30   666.399 ±  5.046  ns/op
    ModelBenchmark.toString               kotlin  avgt   30   337.323 ±  2.805  ns/op
    ModelBenchmark.toString           kotlinlazy  avgt   30   335.975 ±  2.669  ns/op
    ModelBenchmark.toString            autovalue  avgt   30   406.148 ±  3.602  ns/op
    ModelBenchmark.toString                guava  avgt   30   513.389 ±  5.612  ns/op

# Memory

    intellij : 440 bytes, Footprint{Objects=17, References=21, Primitives=[double, int x 8, char x 6]}
    eclipse : 440 bytes, Footprint{Objects=17, References=21, Primitives=[double, int x 8, char x 6]}
    groovy : 448 bytes, Footprint{Objects=17, References=22, Primitives=[double, int x 8, char x 6]}
    groovystatic : 448 bytes, Footprint{Objects=17, References=22, Primitives=[double, int x 8, char x 6]}
    lombok : 440 bytes, Footprint{Objects=17, References=21, Primitives=[double, int x 8, char x 6]}
    scala : 520 bytes, Footprint{Objects=17, References=39, Primitives=[double, int x 8, char x 6]}
    kotlin : 408 bytes, Footprint{Objects=15, References=19, Primitives=[double, int x 8, char x 6]}
    autovalue : 440 bytes, Footprint{Objects=17, References=21, Primitives=[double, int x 8, char x 6]}
    guava : 440 bytes, Footprint{Objects=17, References=21, Primitives=[double, int x 8, char x 6]}

Note: `metaClass` reference is excluded for Groovy.
