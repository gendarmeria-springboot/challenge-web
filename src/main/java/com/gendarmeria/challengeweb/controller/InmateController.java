package com.gendarmeria.challengeweb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gendarmeria.challengeweb.dto.InmateDTO;
import com.gendarmeria.challengeweb.dto.TokenDTO;
import com.gendarmeria.challengeweb.exception.ChallengeWebException;

@RestController
@RequestMapping(value = "/inmate")
@CrossOrigin("*")
public class InmateController {

	// POST http://localhost:10000/inmate -> body: {inmateDTO}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InmateDTO> createInmate(@RequestBody InmateDTO body) throws ChallengeWebException {
		return null;
	}

	// PUT http://localhost:10000/inmate -> body: {inmateDTO}
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InmateDTO> updateInmate(@RequestBody InmateDTO body) throws ChallengeWebException {
		return null;
	}

	// DELETE http://localhost:10000/inmate/1
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InmateDTO> deleteInmate(@PathVariable(value = "id") Integer id) throws ChallengeWebException {
		return null;
	}

	// GET http://localhost:10000/inmate/1
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InmateDTO> getInmate(@PathVariable(value = "id") Integer id) throws ChallengeWebException {
		return null;
	}

	// GET http://localhost:10000/inmate/all
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InmateDTO>> getInmate() throws ChallengeWebException {
		return null;
	}
}
