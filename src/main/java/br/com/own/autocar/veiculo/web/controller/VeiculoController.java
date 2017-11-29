package br.com.own.autocar.veiculo.web.controller;

import br.com.own.autocar.veiculo.domain.model.Veiculo;
import br.com.own.autocar.veiculo.infra.dao.VeiculoRepository;
import br.com.own.autocar.veiculo.web.view.VeiculoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private VeiculoRepository pacienteReposity;

    @Autowired
    public VeiculoController(VeiculoRepository pacienteReposity) {
        this.pacienteReposity = pacienteReposity;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<VeiculoDto> salvar(@RequestBody @Valid VeiculoDto veiculoDto){
        this.pacienteReposity.save( veiculoDto.toEntity() );
        return ResponseEntity.created( URI.create("veiculo/"  + veiculoDto.getId()) ).body(veiculoDto);
    }

    @ResponseBody
    @GetMapping
    public List<VeiculoDto> listar(Pageable page){
        Iterable<Veiculo> veiculos = pacienteReposity.findAll(page);
        return newArrayList(veiculos).stream()
                                    .map(VeiculoDto::of)
                                    .collect(Collectors.toList());
    }

    @ResponseBody
    @DeleteMapping
    public ResponseEntity<VeiculoDto> remover(@RequestBody @Valid VeiculoDto veiculoDto){
        this.pacienteReposity.delete( veiculoDto.toEntity() );
        return ResponseEntity.noContent().build();
    }

}

