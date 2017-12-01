package br.com.own.autocar.business.contrato.domain.business;

import br.com.own.autocar.business.cliente.domain.model.Cliente;
import br.com.own.autocar.business.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.business.contrato.domain.model.ContratoLocacaoBuilder;
import br.com.own.autocar.business.contrato.domain.model.InformacaoComplementar;
import br.com.own.autocar.utility.date.DateUtil;
import br.com.own.autocar.business.veiculo.domain.model.Veiculo;

import static java.text.MessageFormat.format;
import static java.util.Objects.requireNonNull;

public class EmissorContratoVeiculo implements EmissorContrato {

    public static final String MESSAGE_REQUIRED = "É necessario um {0} para a emissao do contrato";

    @Override
    public ContratoLocacao emitir(Veiculo veiculo, Cliente cliente, InformacaoComplementar infoComplementar) {
        requireNonNull(veiculo, format(MESSAGE_REQUIRED, "Veiculo"));
        requireNonNull(cliente, format(MESSAGE_REQUIRED, "Cliente"));

        return ContratoLocacaoBuilder.builder()
                            .comCliente(cliente)
                            .comVeiculo(veiculo)
                            .comDataDeInicio(infoComplementar.getDataInicio())
                            .comDataDeTermino(infoComplementar.getDataFim())
                            .comDataEfetivacao(DateUtil.getDataAtual())
                            .build();
    }

}
