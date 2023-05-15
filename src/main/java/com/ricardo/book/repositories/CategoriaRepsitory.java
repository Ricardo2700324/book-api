package com.ricardo.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.book.domain.Categoria;

@Repository
public interface CategoriaRepsitory extends JpaRepository<Categoria, Integer>{

}
