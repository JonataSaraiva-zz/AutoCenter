package br.com.own.autocar.utility.validator;

import java.util.function.Predicate;

public interface Validador {

    <T> void verify(Predicate<T> condition, T t);

    <T> void validate(T t);

}
