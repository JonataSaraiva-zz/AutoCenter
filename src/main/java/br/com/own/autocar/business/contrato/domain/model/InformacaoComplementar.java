package br.com.own.autocar.business.contrato.domain.model;

import lombok.Getter;

import java.util.Date;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.Validate.validState;

@Getter
public class InformacaoComplementar {

    private Date dataInicio;
    private Date dataFim;

    public InformacaoComplementar(Date dataInicio, Date dataFim) {
        requireNonNull(dataInicio);
        requireNonNull(dataFim);
        validState(isVigenciaValida(), "O Periodo informado e invalido!!");

        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public boolean isVigenciaValida(){
       return dataInicio.before(dataFim);
    }

}
