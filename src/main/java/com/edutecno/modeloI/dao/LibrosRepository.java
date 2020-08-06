package com.edutecno.modeloI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.modeloI.pojos.Libro;


@Repository
public interface LibrosRepository extends CrudRepository<Libro, Integer> {


}
