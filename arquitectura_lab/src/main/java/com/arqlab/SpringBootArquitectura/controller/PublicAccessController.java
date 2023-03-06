package com.arqlab.SpringBootArquitectura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accesoPublico")
public class PublicAccessController {
	
	@GetMapping(path = "/")
	public String index() {
	    return "acceso público";
	}

}
