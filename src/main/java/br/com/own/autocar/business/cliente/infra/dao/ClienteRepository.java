package br.com.own.autocar.business.cliente.infra.dao;

import br.com.own.autocar.business.cliente.domain.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}
