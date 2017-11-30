package br.com.own.autocar.contrato.domain.model;

import br.com.own.autocar.cliente.domain.model.Cliente;
import br.com.own.autocar.veiculo.domain.model.Veiculo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ContratoLocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contrato_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Column(name = "data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataEfetivacao;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataFim;

}
