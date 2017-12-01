package br.com.own.autocar.business.veiculo.web.view;

import br.com.own.autocar.business.veiculo.domain.model.Veiculo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VeiculoDto {

    @NotNull(message = "O id e obrigatorio")
    private Long id;

    @NotEmpty(message = "O campo Nome e obrigatorio")
    private String nome;

    @NotNull(message = "O ano do veiculo e obrigatorio")
    private Integer ano;

    public Veiculo toEntity(){
        Veiculo veiculo = new Veiculo();
        veiculo.setId(id);
        veiculo.setModelo(nome);
        veiculo.setAno(ano);

        return veiculo;
    }

    public static VeiculoDto of(Veiculo veiculo){
        VeiculoDto veiculoDto = new VeiculoDto();
        veiculoDto.setId(veiculo.getId());
        veiculoDto.setNome(veiculo.getModelo());
        veiculoDto.setAno(veiculo.getAno());

        return veiculoDto;
    }
}

