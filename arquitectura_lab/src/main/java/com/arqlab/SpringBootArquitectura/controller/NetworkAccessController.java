package com.arqlab.SpringBootArquitectura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/networkAccess")
public class NetworkAccessController {

	@GetMapping(path = "/accessList")
	public String accessList() {
		return "prueba";
	}

}
