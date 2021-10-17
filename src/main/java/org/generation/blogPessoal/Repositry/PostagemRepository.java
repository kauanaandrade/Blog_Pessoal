package org.generation.blogPessoal.Repositry;

import java.util.List;

import org.generation.blogPessoal.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
 
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	public List<Postagem> findAllByDescricaoContainingIgnoreCase(String descricao);

}