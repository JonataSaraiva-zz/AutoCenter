package br.com.own.autocar.contrato.domain.model;

import br.com.own.autocar.cliente.domain.model.Cliente;
import br.com.own.autocar.veiculo.domain.model.Veiculo;

import java.time.LocalDateTime;
import java.util.Date;

public class ContratoLocacaoBuilder {

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime dataEfetivacao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public static ContratoLocacaoBuilder builder(){
        return new ContratoLocacaoBuilder();
    }

    public ContratoLocacaoBuilder comCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }
    public ContratoLocacaoBuilder comVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return this;
    }
    public ContratoLocacaoBuilder comDataEfetivacao(LocalDateTime dataEfetivacao){
        this.dataEfetivacao = dataEfetivacao;
        return this;
    }
    public ContratoLocacaoBuilder comDataDeInicio(LocalDateTime dataInicio){
        this.dataInicio = dataInicio;
        return this;
    }
    public ContratoLocacaoBuilder comDataDeTermino(LocalDateTime dataFim){
        this.dataFim = dataFim;
        return this;
    }

    public ContratoLocacao build(){
        ContratoLocacao contrato = new ContratoLocacao();
        contrato.setCliente(cliente);
        contrato.setVeiculo(veiculo);
        contrato.setDataEfetivacao(dataEfetivacao);
        contrato.setDataInicio(dataInicio);
        contrato.setDataFim(dataFim);

        return contrato;
    }
}
