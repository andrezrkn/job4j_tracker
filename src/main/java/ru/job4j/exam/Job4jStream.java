package ru.job4j.exam;

import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.BaseStream;

public interface Job4jStream<T> extends BaseStream {

    Job4jStream<T> filter(Predicate predicate);

    <T> Job4jStream of(T t);

    <R> R collect(Supplier<R> supplier,
                  BiConsumer accumulator,
                  BiConsumer<R, R> combiner);
}
