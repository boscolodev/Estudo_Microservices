package dev.boscolo.hrworker.resourcers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.boscolo.hrworker.dto.WorkerDTO;
import dev.boscolo.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WokerResource {

	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll(){
		List<WorkerDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
		WorkerDTO workerDTO =  service.findById(id);
		return ResponseEntity.ok().body(workerDTO);
	}
	
}
