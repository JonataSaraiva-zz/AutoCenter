package br.com.own.autocar.cliente.infra.dao;

import br.com.own.autocar.cliente.domain.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}
