package br.com.own.autocar.cliente.domain.model;

import br.com.own.autocar.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.utility.date.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Column(name = "numero_cnh")
    private Long numeroCnh;

    @Column(name = "data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataRegistro;

    @Column(name = "ultima_modificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime ultimaAtualizacao;

    @OneToMany(mappedBy = "cliente")
    private Collection<ContratoLocacao> contrato;

    @PrePersist
    private void ultimaAtualizacao() {
        this.ultimaAtualizacao = DateUtil.getDataAtual();
    }

}
