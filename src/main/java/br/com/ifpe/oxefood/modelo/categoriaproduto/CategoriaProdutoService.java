package br.com.ifpe.oxefood.modelo.categoriaproduto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.ifpe.oxefood.modelo.produto.produto;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
//import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

   @Autowired
   private CategoriaProdutoRepository repository;

   @Transactional
   public CategoriaProduto save(CategoriaProduto categoriaProduto) {

    categoriaProduto.setHabilitado(Boolean.TRUE);
    categoriaProduto.setVersao(1L);
    categoriaProduto.setDataCriacao(LocalDate.now());
       return repository.save(categoriaProduto);
   }

   public List<CategoriaProduto> listarTodos() {
  
        return repository.findAll();
    }

    public CategoriaProduto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, CategoriaProduto produtoAlterado) {

    CategoriaProduto categoriaProduto = repository.findById(id).get();
    categoriaProduto.setDescricao(produtoAlterado.getDescricao());
	    
      categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);
      repository.save(categoriaProduto);
  }
    @Transactional
   public void delete(Long id) {

    CategoriaProduto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);
       produto.setVersao(produto.getVersao() + 1);

       repository.save(produto);
   }




}


