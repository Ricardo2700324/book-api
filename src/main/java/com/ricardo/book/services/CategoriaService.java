package com.ricardo.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.book.domain.Categoria;
import com.ricardo.book.dtos.CategoriaDTO;
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
	
	public List<Categoria> findAll(){
		return categoriaRepsitory.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepsitory.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepsitory.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		categoriaRepsitory.deleteById(id);
		
	}
}
