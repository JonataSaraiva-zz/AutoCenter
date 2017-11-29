package br.com.own.autocar.contrato.domain.business.validador;

import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;

public interface ValidadorInformacaoComplementar {

    <T> void validar(InformacaoComplementar informacaoComplementar);

}
