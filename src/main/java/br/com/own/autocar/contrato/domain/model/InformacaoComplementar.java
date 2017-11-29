package br.com.own.autocar.contrato.domain.model;

import lombok.Data;

import java.util.Date;

import static br.com.own.autocar.utility.date.DateUtil.isPrimeiraDataMenorQueSegunda;

@Data
public class InformacaoComplementar {

    private Date dataInicio;
    private Date dataFim;

    public boolean isVigenciaValida(){
       return isPrimeiraDataMenorQueSegunda(dataInicio , dataFim);
    }

}
