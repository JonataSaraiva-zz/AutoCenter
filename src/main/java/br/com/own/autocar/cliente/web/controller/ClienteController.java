package br.com.own.autocar.cliente.web.controller;

import br.com.own.autocar.cliente.domain.model.Cliente;
import br.com.own.autocar.cliente.infra.dao.ClienteRepository;
import br.com.own.autocar.cliente.web.view.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@RequestMapping("/api/cliente")
@RestController
public class ClienteController {

    private ClienteRepository clienteReposity;

    @Autowired
    public ClienteController(ClienteRepository clienteReposity) {
        this.clienteReposity = clienteReposity;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<ClienteDto> salvar(@RequestBody @Valid ClienteDto clienteDto){
        this.clienteReposity.save( clienteDto.toEntity() );
        return ResponseEntity.created( URI.create("cliente/"  + clienteDto.getId()) ).body(clienteDto);
    }

    @ResponseBody
    @GetMapping
    public List<ClienteDto> listar(Pageable page){
        Iterable<Cliente> clientes = clienteReposity.findAll(page);
        return newArrayList(clientes).stream()
                                .map(ClienteDto::of)
                                .collect(Collectors.toList());
    }

    @ResponseBody
    @DeleteMapping
    public ResponseEntity<ClienteDto> remover(@RequestBody @Valid ClienteDto clienteDto){
        this.clienteReposity.delete( clienteDto.toEntity() );
        return ResponseEntity.noContent().build();
    }

}
