package com.ricardo.book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.book.domain.Categoria;
import com.ricardo.book.repositories.CategoriaRepsitory;
import com.ricardo.book.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepsitory categoriaRepsitory;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepsitory.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
