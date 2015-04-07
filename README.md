# Benchmarking JVM model classes

This is a quick study of the relative performance of the typical DTO methods generated by Groovy annotations, Scala case classes, Kotlin data classes, and Lombok, all running on Java 8u40.  These tests use the Groovy indy jar and compile flag.

I'm impatient, so each benchmark is running with 20 warmups, 50 iterations, and 1 fork.

## equals()

    Benchmark                         Mode  Cnt     Score    Error  Units
    EqualsBenchmark.equalsGroovy      avgt   50   123.055 ±  6.099  ns/op
    EqualsBenchmark.equalsKotlin      avgt   50    85.407 ±  3.900  ns/op
    EqualsBenchmark.equalsLombok      avgt   50    30.252 ±  1.518  ns/op
    EqualsBenchmark.equalsScala       avgt   50    54.764 ±  2.630  ns/op

## hashCode()

    Benchmark                         Mode  Cnt     Score    Error  Units
    HashCodeBenchmark.hashCodeGroovy  avgt   50  1333.265 ± 54.085  ns/op
    HashCodeBenchmark.hashCodeKotlin  avgt   50    62.726 ±  2.674  ns/op
    HashCodeBenchmark.hashCodeLombok  avgt   50    59.936 ±  3.065  ns/op
    HashCodeBenchmark.hashCodeScala   avgt   50   140.214 ±  7.004  ns/op
    
## toString()

    Benchmark                         Mode  Cnt     Score     Error  Units
    ToStringBenchmark.toStringGroovy  avgt   50  2694.039 ± 94.590  ns/op
    ToStringBenchmark.toStringKotlin  avgt   50   401.872 ± 20.895  ns/op
    ToStringBenchmark.toStringLombok  avgt   50   425.689 ± 16.246  ns/op
    ToStringBenchmark.toStringScala   avgt   50   740.832 ± 30.823  ns/op