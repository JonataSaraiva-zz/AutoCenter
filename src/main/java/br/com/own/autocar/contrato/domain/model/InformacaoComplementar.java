package br.com.own.autocar.contrato.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.Validate.validState;

@Getter
public class InformacaoComplementar {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public InformacaoComplementar(LocalDateTime dataInicio, LocalDateTime dataFim) {
        requireNonNull(dataInicio);
        requireNonNull(dataFim);
        validState(isVigenciaValida(), "O Periodo informado e invalido!!");

        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public boolean isVigenciaValida(){
       return dataInicio.isBefore(dataFim);
    }

}
