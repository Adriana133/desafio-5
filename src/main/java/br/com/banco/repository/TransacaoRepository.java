package br.com.banco.repository;

import br.com.banco.models.Transacao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Integer>, JpaSpecificationExecutor<Transacao> {

    @Query("SELECT t FROM transacao t WHERE t.conta_id = :conta AND t.data_transferencia >= :dtInicio t.data_transferencia <= :dtFim AND t.nome_operador_transacao = :operador")
    List<Transacao> buscarTudo(@Param("conta") Integer conta,
                               @Param("dtInicio") Date dtInicio,
                               @Param("dtFim") Date dtFim,
                               @Param("operador") String operador);

    @Query("SELECT t FROM transacao t WHERE t.conta_id = :conta")
    List<Transacao> buscarPorConta(@Param("conta") Integer conta);

    @Query("SELECT t FROM transacao t WHERE t.conta_id = :conta AND t.data_transferencia >= :dtInicio t.data_transferencia <= :dtFim")
    List<Transacao> buscarPorPeriodo(@Param("conta") Integer conta,
                           @Param("dtInicio") Date dtInicio,
                           @Param("dtFim") Date dtFim);

    @Query("SELECT t FROM transacao t WHERE t.conta_id = :conta AND t.nome_operador_transacao = :operador")
    List<Transacao> buscarPorOperador(@Param("conta") Integer conta,
                                      @Param("operador") String operador);
}
