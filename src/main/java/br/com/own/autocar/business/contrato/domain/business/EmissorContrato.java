package br.com.own.autocar.business.contrato.domain.business;

import br.com.own.autocar.business.cliente.domain.model.Cliente;
import br.com.own.autocar.business.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.business.contrato.domain.model.InformacaoComplementar;
import br.com.own.autocar.business.veiculo.domain.model.Veiculo;

public interface EmissorContrato {

    ContratoLocacao emitir(Veiculo veiculo, Cliente cliente, InformacaoComplementar infoComplementar);

}
