package com.example.demo.customTemplate;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class CriteriaTemplate<T> {

	private EntityManager entityManager;
	private Class<T> entityClass;
	private CriteriaBuilder crBuilder;
	private CriteriaQuery<T> crQuery;
	private Root<T> root;
	
	public CriteriaTemplate(EntityManager manager , Class<T> entity) {
		entityClass = entity;
		entityManager = manager;
		crBuilder = entityManager.getCriteriaBuilder();
		crQuery = crBuilder.createQuery(entityClass);
		root = crQuery.from(entityClass);
		crQuery.select(root);
	}
	
	public List<T> findAll(){ 		 
		return entityManager.createQuery(crQuery).getResultList();
	}
	
	public List<T> findByEqaulsPropertyName(String propertyName , String value){
		crQuery.where(equalPredicate(propertyName, value));
		return entityManager.createQuery(crQuery).getResultList();
	}
	
	public List<T> findByContainsPropertyName(String propertyName , String value){
		crQuery.where(containsPredicate(propertyName, value));
		return entityManager.createQuery(crQuery).getResultList();
	}
	 
	public <valueList> List<T> findByPropertyNameIn(String propertyNameName , List<valueList> values){
		crQuery.where(InPredicate(propertyNameName, values));
		return entityManager.createQuery(crQuery).getResultList();
	}
	
	  
	
	
	// PREDICATES  
	private Predicate equalPredicate(String propertyName, String value) { 
		return crBuilder.equal(root.get(propertyName),value);
	}
	
	private Predicate containsPredicate(String propertyName , String value) { 
		return crBuilder.like(root.get(propertyName), "%"+ value + "%");
	}
	
	private Predicate InPredicate(String propertyName , List<?> value) { 
		return root.get(propertyName).in(value);
	}
 
	
	
}
