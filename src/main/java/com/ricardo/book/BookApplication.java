package com.ricardo.book;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.book.domain.Categoria;
import com.ricardo.book.domain.Livro;
import com.ricardo.book.repositories.CategoriaRepsitory;
import com.ricardo.book.repositories.LivroRepsitory;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepsitory categoriaRepsitory;
	@Autowired
	private LivroRepsitory livroRepsitory;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "livro de TI"); 
		Categoria cat2 = new Categoria(null, "Informática", "livro de Python"); 
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat1);
		Livro l2 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsun", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		
		this.categoriaRepsitory.saveAllAndFlush(Arrays.asList(cat1, cat2));
		this.livroRepsitory.saveAll(Arrays.asList(l1, l2));
		
	}

}
