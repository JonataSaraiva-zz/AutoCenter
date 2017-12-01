package br.com.own.autocar.business.contrato.infra.dao;

import br.com.own.autocar.business.contrato.domain.model.ContratoLocacao;
import org.springframework.data.repository.CrudRepository;

public interface ContratoLocacaoRepository extends CrudRepository<ContratoLocacao, Long> {
}
