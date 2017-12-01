package br.com.own.autocar.business.veiculo.infra.dao;

import br.com.own.autocar.business.veiculo.domain.model.Veiculo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long> {
}
