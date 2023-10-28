package com.example.demo.customTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class PostgreSqlTemplate<T extends Object> {

	public T data;
//	
//	@Autowired
//	private EntityManager entityManager;
	
	void some(){ 
//		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Object> cm = criteria.createQuery();
		
	}
	
}
