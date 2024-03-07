package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       cliente.setVersao(1L);
       cliente.setDataCriacao(LocalDate.now());
       return repository.save(cliente);
   }

}