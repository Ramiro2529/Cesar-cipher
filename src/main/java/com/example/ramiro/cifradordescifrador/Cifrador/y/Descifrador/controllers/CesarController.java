package com.example.ramiro.cifradordescifrador.Cifrador.y.Descifrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ramiro.cifradordescifrador.Cifrador.y.Descifrador.service.CesarService;

@RestController
public class CesarController {
	
	@Autowired
	private CesarService service;
	
	
	@GetMapping("/sumar/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		
		return service.sumar(a, b);
		
		
	}
	
    @GetMapping("/cifrador/{texto}/{despl}")
    public String cifrar( @PathVariable String texto, @PathVariable int despl) {
    	
		return service.cifrar(texto, despl);
    	
    }
    
    @GetMapping("/descifrador/{texto}/{despl}")
    public String descifrar(@PathVariable String texto, @PathVariable int despl) {
    	 return service.desCifrar(texto, despl);
    }
    
   

}
