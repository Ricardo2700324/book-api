package com.ricardo.book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.book.domain.Livro;
import com.ricardo.book.repositories.LivroRepsitory;
import com.ricardo.book.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepsitory livroRepsitory;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepsitory.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Livro: " + Livro.class.getName()));
	}

}
