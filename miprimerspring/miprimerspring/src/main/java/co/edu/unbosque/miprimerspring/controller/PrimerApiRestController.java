package co.edu.unbosque.miprimerspring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/primerapi")
@CrossOrigin(origins = { "http:://localhost:8080", "*" })
//IMPORTANTE: si esto ya esta listo, hay que modificarlo, o si no cualquiera podra conectarse
public class PrimerApiRestController {
	
	@GetMapping("/saludar")
	public String getSaludar() {
		return "BUENOS DIAS";
	}
	
	@GetMapping("/saludarpornombre")
	public String getSaludarPorNombre(@RequestParam String nombre) {
		return "BUENOS DIAS "+nombre;
	}
	
	@GetMapping("suma")
	public int getSuma(@RequestParam String num1, @RequestParam String num2) {
		return Integer.parseInt(num1) + Integer.parseInt(num2);
	}
	
	@GetMapping("multiplicacion")
	public int getMultiplicacion(@RequestParam String num1, @RequestParam String num2) {
		return Integer.parseInt(num1) * Integer.parseInt(num2);
	}
	
	@GetMapping("resta")
	public int getResta(@RequestParam String num1, @RequestParam String num2) {
		return Integer.parseInt(num1) - Integer.parseInt(num2);
	}
	
	@GetMapping("division")
	public int getDivision(@RequestParam String num1, @RequestParam String num2) {
		return Integer.parseInt(num1) / Integer.parseInt(num2);
	}
	
	
	
}
