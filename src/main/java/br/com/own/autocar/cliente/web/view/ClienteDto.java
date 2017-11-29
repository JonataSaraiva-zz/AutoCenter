package br.com.own.autocar.cliente.web.view;

import br.com.own.autocar.cliente.domain.model.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteDto {

    @NotNull(message = "O ID nao pode ser nulo")
    private Long id;

    @NotEmpty(message = "O Nome do cliente e obrigatorio")
    private String nome;

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);

        return cliente;
    }

    public static ClienteDto of (Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());

        return clienteDto;
    }

}
