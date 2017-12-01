package br.com.own.autocar.business.cliente.web.view.request;

import br.com.own.autocar.business.cliente.domain.model.Cliente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "Cliente")
public class ClienteRequest {

    @ApiModelProperty(value = "Nome", required = true, dataType = "String")
    @NotEmpty(message = "O Nome do cliente e obrigatorio")
    private String nome;

    @ApiModelProperty(value = "Numero CNH", required = true, dataType = "Long")
    @NotEmpty(message = "O numero da CNH do cliente e obrigatorio")
    private Long cnh;

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setNumeroCnh(cnh);

        return cliente;
    }

}
