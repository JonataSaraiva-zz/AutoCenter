package br.com.own.autocar.contrato.domain.business;

import br.com.own.autocar.cliente.domain.model.Cliente;
import br.com.own.autocar.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;
import br.com.own.autocar.veiculo.domain.model.Veiculo;

public interface EmissorContrato {

    ContratoLocacao emitir(Veiculo veiculo, Cliente cliente, InformacaoComplementar infoComplementar);

}
