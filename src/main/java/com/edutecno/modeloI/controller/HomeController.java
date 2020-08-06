package com.edutecno.modeloI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.modeloI.librosService.LibrosService;
import com.edutecno.modeloI.pojos.Libro;

@Controller
@RequestMapping("/")
@CrossOrigin
public class HomeController {
	
	@Autowired
	LibrosService book;
	
	@GetMapping("/")
	public String home() {
	//	book.searchBook();
		
		return "search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		List<Libro> libros = book.searchBook();
		model.addAttribute("searchBooks", libros);

		return "/search";
	}
	
	@PostMapping("/search")
	public String searchForm(Model model,@RequestParam("nombre") String nombre) {
		List<Libro> libros = book.searchBook();
		int cont=0;
		for(Libro list: libros) {
			//System.out.println(list.toString());
			//System.out.println("Nombre libro "+ nombre+" "+ list.getTitulo());
			if(list.getTitulo().equals(nombre)) {
				model.addAttribute("libroBuscado", list.toString());
				cont=1;
				//System.out.println(nombre);
			//	System.out.println("libro encontrado");
			}
			else if(cont==0){
				//System.out.println(nombre);
				model.addAttribute("libroBuscado", "Libro no encontrado");	
				System.out.println("libro no encontrado");
			}
		}
		
		return "/search";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
				
		return "add";
	}
	
	@PostMapping("/add")
	public String addBook(Model model, @RequestParam("titulo") String titulo, @RequestParam("date") String date, @RequestParam("autor") String autor, @RequestParam("imprenta") String imprenta ) {
		
	//	Libro libro = new Libro(null, date, titulo, autor, imprenta );
		Libro libro= new Libro();
		libro.setAnoPublicacion(date);
		libro.setNombreAutor(titulo);
		libro.setNombreImprenta(imprenta);
		libro.setTitulo(titulo);
		libro.setDisponibilidad("Disponible");
				
		book.addBook(libro);
	//	System.out.println(libro.getId());
		return "add";
	}
	
	@GetMapping("/update")
	public String update() {
		
		return "update";
	}
	
	@PostMapping("/update")
	public String updateLibro(@RequestParam("id") Integer id ,@RequestParam("titulo") String titulo, @RequestParam("date") String date, @RequestParam("autor") String autor, @RequestParam("imprenta") String imprenta, @RequestParam("disponibilidad") String disponibilidad) {
		Libro libro = new Libro(id,date, titulo, autor, imprenta, disponibilidad);
		book.updateBook(libro);
		
		return "update";
	}
	
	@PostMapping("/updateDisponibilidad")
	public String updateDiponibilidad(@RequestParam("idUpdate") Integer id,@RequestParam("disponibilidadLibro") String disp) {
		book.dispBook(id, disp);
		
		return "update";
	}
	
	
	@GetMapping("/delete")
	public String delete(){
		
		return("delete");
	}
	
	@PostMapping("/delete")
	public String deleteLibro(@RequestParam("id") Integer id){
		book.deleteBook(id);
		return("delete");
	}
	
	
}
