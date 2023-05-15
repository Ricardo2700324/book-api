package com.ricardo.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.book.domain.Livro;

@Repository
public interface LivroRepsitory extends JpaRepository<Livro, Integer>{

}
