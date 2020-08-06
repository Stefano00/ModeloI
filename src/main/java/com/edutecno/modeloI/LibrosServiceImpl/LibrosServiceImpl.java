package com.edutecno.modeloI.LibrosServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.modeloI.dao.LibrosRepository;
import com.edutecno.modeloI.librosService.LibrosService;
import com.edutecno.modeloI.pojos.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {

	@Autowired
	LibrosRepository librosDao;

	@Transactional(readOnly = true)
	@Override
	public List<Libro> searchBook() {
		List<Libro> listaLibros = new ArrayList<Libro>();
		
		/*Optional<Libro> librosOptional = librosDao.findById(1);
		
		//listaLibros= librosDao.findByTitulo("Stefano");
		
		// System.out.println(librosOptional.get().getNombreAutor().toString());
		int id = librosOptional.get().getId();
		String anoPublicacion = librosOptional.get().getAnoPublicacion().toString();
		String titulo = librosOptional.get().getTitulo().toString();
		String nombreAutor = librosOptional.get().getNombreAutor().toString();
		String nombreImprenta = librosOptional.get().getNombreImprenta().toString();

		Libro libro = new Libro(id, anoPublicacion, titulo, nombreAutor, nombreImprenta);
		
		listaLibros.add(libro);
		*/
		
		Iterable<Libro> libros = librosDao.findAll();
		for(Libro list:libros) {
			Libro libro = new Libro(list.getId(),list.getAnoPublicacion(),list.getTitulo(),list.getNombreAutor(),list.getNombreImprenta(), list.getDisponibilidad());
			listaLibros.add(libro);
		}

		return listaLibros;
	}

	@Override
	public Libro addBook(Libro libro) {
		librosDao.save(libro);
		return null;
	}

	@Override
	public Libro deleteBook(Integer id) {
		librosDao.deleteById(id);
		return null;
	}

	@Override
	public Libro updateBook(Libro libro) {
		
		Optional<Libro> optional= librosDao.findById(libro.getId());
		Libro libroTemp;
		libroTemp= optional.get();
	//	System.out.println(libroTemp.toString());
		libroTemp.setAnoPublicacion(libro.getAnoPublicacion());
		libroTemp.setDisponibilidad(libro.getDisponibilidad());
		libroTemp.setNombreAutor(libro.getNombreAutor());
		libroTemp.setNombreImprenta(libro.getNombreImprenta());
		libroTemp.setTitulo(libro.getTitulo());
		librosDao.save(libroTemp);
		return null;
	}

	@Override
	public Libro dispBook(Integer id, String disp) {
		Optional<Libro> optional = librosDao.findById(id);
		Libro libroTemp;
		libroTemp = optional.get();
		libroTemp.setDisponibilidad(disp);
		librosDao.save(libroTemp);
		return null;
	}

}
