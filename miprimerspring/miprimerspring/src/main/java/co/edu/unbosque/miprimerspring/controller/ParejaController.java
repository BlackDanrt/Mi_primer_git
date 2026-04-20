package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.service.ParejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/pareja")
@CrossOrigin(origins = { "http:://localhost:8080", "*" })
public class ParejaController {

	@Autowired
	private ParejaService parejaService;

	public ParejaController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam String fechaAniversario, @RequestParam String carrera) {
		ParejaDTO nuevo = new ParejaDTO(nombre, edad, LocalDateTime.parse(fechaAniversario), carrera);
		int status = parejaService.create(nuevo);
		if (status == 0) {
			return new ResponseEntity<String>("Dato creado con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Error al crear pareja", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mostrar")
	public ResponseEntity<List<ParejaDTO>> mostrarTodo() {
		List<ParejaDTO> parejas = parejaService.getAll();
		if (parejas.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizar(@RequestParam long id, @RequestParam String nombre, @RequestParam int edad,
			@RequestParam String fechaAniversario, @RequestParam String carrera) {
		ParejaDTO temp = new ParejaDTO(nombre, edad, LocalDateTime.parse(fechaAniversario), carrera);
		int respuesta = parejaService.updateById(id, temp);
		if (respuesta == 0) {
			return new ResponseEntity<String>("Error al eliminar la pareja", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>("Pareja eliminada con exito", HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminar(@RequestParam long id) {
		int respuesta = parejaService.deleteById(id);
		if (respuesta == 0) {
			return new ResponseEntity<String>("Error al eliminar la pareja", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>("Pareja eliminada con exito", HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/findbynombre")
	public ResponseEntity<List<ParejaDTO>> buscarPorNombre(@RequestParam String nombre) {
		List<ParejaDTO> encontrados = parejaService.findByNombre(nombre);
		if(encontrados.isEmpty()) return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.ACCEPTED);
	}
	@GetMapping("/findbycarrera")
	public ResponseEntity<List<ParejaDTO>> buscarPorCarrera(@RequestParam String carrera) {
		List<ParejaDTO> encontrados = parejaService.findByCarrera(carrera);
		if(encontrados.isEmpty()) return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.ACCEPTED);
	}
	@GetMapping("/findbyedad")
	public ResponseEntity<List<ParejaDTO>> buscarPorEdad(@RequestParam int edad) {
		List<ParejaDTO> encontrados = parejaService.findByEdad(edad);
		if(encontrados.isEmpty()) return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.ACCEPTED);
	}
	@GetMapping("/findbyfechaaniversario")
	public ResponseEntity<List<ParejaDTO>> buscarPorFechaAniversario(LocalDateTime fechaAniversario) {
		List<ParejaDTO> encontrados = parejaService.findByFechaAniversario(fechaAniversario);
		if(encontrados.isEmpty()) return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<ParejaDTO>>(encontrados, HttpStatus.ACCEPTED);
	}

}
