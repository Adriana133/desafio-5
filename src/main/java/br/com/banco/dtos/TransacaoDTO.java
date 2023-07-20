package br.com.banco.dtos;

import br.com.banco.models.Transacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {

    public int conta;
    public Date dataTransferencia;
    public String tipo;
    public String nomeOperadorTransacao;
    public double valor;

    public static TransacaoDTO getInstancia(Transacao transacao)
    {
        DecimalFormat df = new DecimalFormat("#.00");

        return TransacaoDTO.builder()
                .conta(transacao.getConta())
                .dataTransferencia(transacao.getDataTransferencia())
                .tipo(transacao.getTipo())
                .nomeOperadorTransacao(transacao.getNomeOperadorTransacao())
                .valor( BigDecimal.valueOf(transacao.getValor()).setScale(2, RoundingMode.HALF_UP).doubleValue() )
                .build();

    }

}
