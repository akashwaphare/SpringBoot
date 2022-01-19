package com.example.virus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virus.exception.ResourceNotFoundException;
import com.example.virus.model.informetion;


@Controller
@RestController
@RequestMapping("/api/v1/")
public class informetionController
{
	@RequestMapping("/login")
	public String showHomePage()
	{
		return "index.html";
	}
	
	@Autowired
	private com.example.virus.repository.informetionRepository informetionRepository;
	
	@GetMapping("informetion")
	public List<informetion> getAllInformetion()
	{
		return this.informetionRepository.findAll();
	}
	
	@GetMapping("/informetion/{id}")
	public ResponseEntity<informetion> getEmployeeById(@PathVariable(value = "id")long informetionId) throws ResourceNotFoundException
	{
		informetion informetion =informetionRepository.findById(informetionId).orElseThrow(()-> new ResourceNotFoundException("informetion not found for this id :: "+informetionId));
		return ResponseEntity.ok().body(informetion);
	}
	
	 @PostMapping("/informetion")
	    public informetion createEmployee(@RequestBody informetion informetion) {
	        return this.informetionRepository.save(informetion);
	    }
	 
	 @PutMapping("/informetion/{id}")
	    public ResponseEntity<informetion> updateEmployee(@PathVariable(value = "id") Long informetionId,
	          @RequestBody informetion informetionDetails) throws ResourceNotFoundException
	 {
	    	informetion informetion = informetionRepository.findById(informetionId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + informetionId));

	        informetion.setVirusPattern(informetionDetails.getVirusPattern());
	        informetion.setNoPatients(informetionDetails.getNoPatients());
	        informetion.setBloodSamples(informetionDetails.getBloodSamples());
	        
	        final informetion updatedinformetion = informetionRepository.save(informetion);
	        return ResponseEntity.ok(updatedinformetion);
	    }
	    
	    @DeleteMapping("/informetion/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long informetionId)
	         throws ResourceNotFoundException {
	    	informetion informetion = informetionRepository.findById(informetionId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + informetionId));

	        informetionRepository.delete(informetion);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
}
