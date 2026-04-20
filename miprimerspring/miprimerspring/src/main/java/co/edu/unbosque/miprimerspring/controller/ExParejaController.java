package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.ExParejaDTO;
import co.edu.unbosque.miprimerspring.service.ExParejaService;

@RestController
@RequestMapping ("/expareja")
@CrossOrigin(origins = { "http:://localhost:8080", "*" })
public class ExParejaController  {
	
	@Autowired
	private ExParejaService exparejaService;
	
	public ExParejaController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearExPareja(@RequestParam long id, @RequestParam String nombre, @RequestParam int edad,
			@RequestParam String fechaNacimiento,@RequestParam String fechaRuptura, @RequestParam String motivoRuptura) {
		ExParejaDTO temp = new ExParejaDTO(nombre, edad, LocalDateTime.parse(fechaNacimiento), LocalDateTime.parse(fechaRuptura), motivoRuptura);
		int respuesta = exparejaService.updateById(id, temp);
		if (respuesta == 0) {
			return new ResponseEntity<String>("Dato creado con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Error al crear pareja", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mostrar")
	public ResponseEntity<List<ExParejaDTO>> mostrarTodo() {
		List<ExParejaDTO> exparejas = exparejaService.getAll();
		if (exparejas.isEmpty()) {
			return new ResponseEntity<List<ExParejaDTO>>(exparejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ExParejaDTO>>(exparejas, HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<String> actualizar(@RequestParam long id, @RequestParam String nombre, @RequestParam int edad,
			@RequestParam LocalDateTime fechaNacimiento, @RequestParam LocalDateTime fechaRuptura, @RequestParam String motivoRuptura) {
		ExParejaDTO temp = new ExParejaDTO(nombre, edad, fechaNacimiento, fechaRuptura, motivoRuptura);
		int respuesta = exparejaService.updateById(id, temp);
		if (respuesta == 0) {
			return new ResponseEntity<String>("Error al eliminar la expareja", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>("Expareja eliminada con exito", HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestParam long id) {
		int respuesta = exparejaService.deleteById(id);
		if (respuesta == 0) {
			return new ResponseEntity<String>("Error al eliminar la expareja", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>("Expareja eliminada con exito", HttpStatus.ACCEPTED);
		}
	}
}
