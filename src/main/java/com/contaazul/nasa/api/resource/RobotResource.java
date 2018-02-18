package com.contaazul.nasa.api.resource;

import static org.springframework.http.HttpStatus.OK;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contaazul.nasa.api.model.Moviment;
import com.contaazul.nasa.api.service.RobotService;

@RestController
@RequestMapping("/rest/mars")
public class RobotResource {
	
	@Autowired
	private RobotService robotService;

	@PostMapping(path = "/{moviments}")
	public ResponseEntity<String> moveRobot(@PathVariable("moviments") String stringMoviments, HttpServletResponse response) {
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{moviments}")
				.buildAndExpand(stringMoviments).toUri();	
		response.setHeader("Location", uri.toASCIIString());
		
		List<Moviment> moviments = Moviment.parseStringToMoviments(stringMoviments);
		
		return ResponseEntity.status(OK).body(robotService.executeMoviment(moviments));
	}
}
