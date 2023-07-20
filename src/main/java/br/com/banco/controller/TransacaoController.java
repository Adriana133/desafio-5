package br.com.banco.controller;

import br.com.banco.dtos.FiltroTransacaoDTO;
import br.com.banco.dtos.TransacaoDTO;
import br.com.banco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping("/{conta}")
    public ResponseEntity<List<TransacaoDTO>> getTransacoes(@PathVariable Integer conta, @RequestBody(required = false) FiltroTransacaoDTO filtro ){

        List<TransacaoDTO> transacoes =  service.getTransacoes( conta, filtro ).stream().map(t -> TransacaoDTO.getInstancia(t))
                .collect(Collectors.toList());

        return ResponseEntity.ok( transacoes );
    }

}
