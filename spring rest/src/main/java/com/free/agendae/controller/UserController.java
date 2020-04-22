package com.free.agendae.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.free.agendae.model.User;
import com.free.agendae.repository.UserRepository;

@RestController
@RequestMapping({"/user"})
public class UserController {
		
	   @Resource(name="User")	
	   private UserRepository repository;
	   
	   void UsertController(UserRepository userRepository) {
	       this.repository = userRepository;
	   }
	   
	   @GetMapping
	   //@RequestMapping(value="/findall", method=RequestMethod.GET) 
	   public List findAll(){
	      return repository.findAll();
	   }
	   
	   
	   @GetMapping(path = {"/{userId}"})
	   public ResponseEntity findById(@PathVariable("userId") long userId){
	      return repository.findById(userId)
	              .map(record -> ResponseEntity.ok().body(record))
	              .orElse(ResponseEntity.notFound().build());
	   }
	   
	   @PostMapping
	   public User create(@RequestBody User user){
	      return repository.save(user);
	   }
	   
	   
	   @PutMapping(value="/{id}")
	   public ResponseEntity update(@PathVariable("id") long id,
	                                         @RequestBody User user) {
	      return repository.findById(id)
	              .map(record -> {
	                  record.setCpf(user.getCpf()); //TODO: Configurar lombok para não dar erro de compilação (e apagar os gerados do model)
	                  record.setName(user.getName());
	                  record.setWhatsappNumber(user.getWhatsappNumber());
	                  User updated = repository.save(record);
	                  return ResponseEntity.ok().body(updated);
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   
	   @DeleteMapping(path ={"/{id}"})
	   public ResponseEntity<?> delete(@PathVariable long id) {
	      return repository.findById(id)
	              .map(record -> {
	                  repository.deleteById(id);
	                  return ResponseEntity.ok().build();
	              }).orElse(ResponseEntity.notFound().build());
	   }

}
