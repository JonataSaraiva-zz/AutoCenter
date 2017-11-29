package br.com.own.autocar.veiculo.infra.dao;

import br.com.own.autocar.veiculo.domain.model.Veiculo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long> {
}
