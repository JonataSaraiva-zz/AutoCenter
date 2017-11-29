package br.com.own.autocar.contrato.domain.business;

import br.com.own.autocar.cliente.domain.model.Cliente;
import br.com.own.autocar.contrato.domain.business.validador.ValidadorInformacaoComplementar;
import br.com.own.autocar.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.contrato.domain.model.ContratoLocacaoBuilder;
import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;
import br.com.own.autocar.veiculo.domain.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static java.text.MessageFormat.format;
import static java.util.Objects.requireNonNull;

public class EmissorContratoVeiculo implements EmissorContrato {

    public static final String MESSAGE_REQUIRED = "É necessario um {0} para a emissao do contrato";

    private Collection<ValidadorInformacaoComplementar> validadores;

    @Autowired
    public EmissorContratoVeiculo(Collection<ValidadorInformacaoComplementar> validadores) {
        this.validadores = validadores;
    }

    @Override
    public ContratoLocacao emitir(Veiculo veiculo, Cliente cliente, InformacaoComplementar infoComplementar) {
        requireNonNull(veiculo, format(MESSAGE_REQUIRED, "Veiculo"));
        requireNonNull(cliente, format(MESSAGE_REQUIRED, "Cliente"));

        validadores.stream().forEach(validador -> validador.validar(infoComplementar));

        return ContratoLocacaoBuilder.builder()
                            .comCliente(cliente)
                            .comVeiculo(veiculo)
                            .comDataDeInicio(infoComplementar.getDataInicio())
                            .comDataDeTermino(infoComplementar.getDataFim())
                            .build();
    }

}
