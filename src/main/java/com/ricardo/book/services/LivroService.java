package com.ricardo.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.book.domain.Livro;
import com.ricardo.book.repositories.LivroRepository;
import com.ricardo.book.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Livro: " + Livro.class.getName()));
	}

	
	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return null;//livroRepository.findAllByCategoria(id_cat);
	}


	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}


	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		
	}
	
	

}
