package br.com.own.autocar.business.cliente.web.view.response;


import br.com.own.autocar.business.cliente.domain.model.Cliente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Cliente", description = "Dados do Cliente")
public class ClienteResponse {

    @ApiModelProperty(value = "Id", dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "Nome", dataType = "String")
    private String nome;

    public static ClienteResponse of (Cliente cliente){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setNome(cliente.getNome());

        return clienteResponse;
    }
}
