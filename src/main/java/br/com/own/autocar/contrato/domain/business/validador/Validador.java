package br.com.own.autocar.contrato.domain.business.validador;

import java.util.function.Predicate;

public interface Validador {

    <T> void validar(Predicate<T> condition, T t);

}
