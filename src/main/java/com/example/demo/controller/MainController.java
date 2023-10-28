package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Main;
import com.example.demo.repository.MainRepository;

@RestController 
public class MainController {
 
	@Autowired
	public  MainRepository mainRepo;
	
	 
	@PostMapping("/save")
	public Main save(@RequestBody Main main) {
		return mainRepo.save(main);
	}
	
	@GetMapping("/getuser/{id}")
	public Optional<Main> get(@PathVariable String id){
		return mainRepo.findById(id);
	}
	
	@GetMapping("/getAll")
	public List<Main> getAll(){
		return mainRepo.findAll();
	}
	
	@PutMapping("/update")
	public Main update(@RequestBody Main main) {
		Main data = new Main();
		Optional<Main> n = mainRepo.findById(main.getUserId());
		
		if(n.isPresent()) {
			data = n.get();
			data.setUserEmail(main.getUserEmail());
			data.setUserName(main.getUserName());
			data = mainRepo.save(data);
		}
		else {
			return data;
		}
		
		return data;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id){
		  mainRepo.deleteById(id);
		  return "SUCESS";
	}
	
}
