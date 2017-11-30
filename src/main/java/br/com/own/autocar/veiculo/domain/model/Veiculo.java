package br.com.own.autocar.veiculo.domain.model;

import br.com.own.autocar.contrato.domain.model.ContratoLocacao;
import br.com.own.autocar.utility.date.DateUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "veiculo_id")
    private Long id;
    private String modelo;
    private Integer ano;

    @Column(name = "data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataRegistro;

    @Column(name = "ultima_modificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime ultimaAtualizacao;

    @OneToOne(mappedBy = "veiculo")
    private ContratoLocacao contrato;

    @PrePersist
    public void ultimaAtualizacao(){
        ultimaAtualizacao = DateUtil.getDataAtual();
    }
 }
