package br.com.banco.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltroTransacaoDTO {

    public String operador;
    public Date dataInicio;
    public Date dataFim;

}
