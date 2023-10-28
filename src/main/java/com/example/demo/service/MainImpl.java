
package com.example.demo.service;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Main;
import com.example.demo.repository.MainRepository;
 
@Service
public class MainImpl {
		
   @Autowired
   private  MainRepository mainrepo;
 
	
	public Main save(Main main) {
		return mainrepo.save(main);
	}
	
}
