package br.com.banco.service;

import br.com.banco.dtos.FiltroTransacaoDTO;
import br.com.banco.models.Transacao;
import br.com.banco.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository repository;

    public List<Transacao> getTransacoes( Integer conta, FiltroTransacaoDTO filtro) {

        final List<Transacao> transacoes = new ArrayList<>();

        if ( conta != null )
        {
            if ( filtro == null )
            {
                repository.buscarPorConta( conta );
            }
            else if ( filtro.getDataInicio() != null && filtro.getDataFim() != null && filtro.getOperador() != null )
            {
                repository.buscarTudo( conta,filtro.getDataInicio(),filtro.getDataFim(), filtro.getOperador() );
            }
            else if ( filtro.getDataInicio() != null && filtro.getDataFim() != null )
            {
                repository.buscarPorPeriodo( conta, filtro.getDataInicio(),filtro.getDataFim());
            }
            else if ( filtro.getOperador() != null )
            {
                repository.buscarPorOperador( conta, filtro.getOperador());
            }
            else
            {
                repository.buscarPorConta( conta );
            }
        }

        return transacoes;
    }
}

