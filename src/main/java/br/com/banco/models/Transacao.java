package br.com.banco.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transferencia")
public class Transacao {

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "data_transferencia")
    public Date dataTransferencia;

    public double valor;

    public String tipo;

    @Column(name = "nome_operador_transacao")
    public String nomeOperadorTransacao;

    @Column(name = " conta_id")
    public int conta;

}
