package com.edutecno.modeloI.librosService;

import java.util.List;
import java.util.Optional;

import com.edutecno.modeloI.pojos.Libro;


public interface LibrosService {

	public List<Libro> searchBook();
	public Libro addBook(Libro libro);
	public Libro deleteBook(Integer id);
	public Libro updateBook(Libro libro);
	public Libro dispBook(Integer id, String disp);
	
}
