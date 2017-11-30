package br.com.own.autocar.utility.validator;

import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;

public interface ValidadorInformacaoComplementar {

    <T> void validar(T t);

}
