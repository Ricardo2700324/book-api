package com.ricardo.book.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.book.domain.Categoria;
import com.ricardo.book.domain.Livro;
import com.ricardo.book.repositories.CategoriaRepsitory;
import com.ricardo.book.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepsitory categoriaRepsitory;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "livro de TI"); 
		Categoria cat2 = new Categoria(null, "Ficção", "livro de Ficção"); 
		Categoria cat3 = new Categoria(null, "Biografias", "livro de Biografias"); 
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat1);
		Livro l2 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat1);
		Livro l3 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat2);
		Livro l4 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat2);
		Livro l5 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4, l5));
		
		this.categoriaRepsitory.saveAllAndFlush(Arrays.asList(cat1, cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3,l4, l5));
	}

}
