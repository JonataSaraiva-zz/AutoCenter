package br.com.own.autocar.business.cliente.web.controller;

import br.com.own.autocar.business.cliente.domain.model.Cliente;
import br.com.own.autocar.business.cliente.infra.dao.ClienteRepository;
import br.com.own.autocar.business.cliente.web.view.request.ClienteRequest;
import br.com.own.autocar.business.cliente.web.view.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.net.URI.create;

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
    public ResponseEntity<ClienteResponse> salvar(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toEntity();
        this.clienteReposity.save( cliente );
        return ResponseEntity.created( create("/cliente/"  + cliente.getId()) ).body( ClienteResponse.of(cliente) );
    }

    @ResponseBody
    @GetMapping
    public List<ClienteResponse> listar(Pageable page){
        Iterable<Cliente> clientes = clienteReposity.findAll(page);
        return newArrayList(clientes).stream()
                                .map(ClienteResponse::of)
                                .collect(Collectors.toList());
    }

    @ResponseBody
    @DeleteMapping
    public ResponseEntity<ClienteResponse> remover(@RequestBody @Valid ClienteRequest clienteRequest){
        this.clienteReposity.delete( clienteRequest.toEntity() );
        return ResponseEntity.noContent().build();
    }

}
