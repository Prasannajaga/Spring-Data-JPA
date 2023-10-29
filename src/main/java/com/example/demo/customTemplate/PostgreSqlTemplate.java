package com.example.demo.customTemplate;

 import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostgreSqlTemplate {
	
 	 
 	private final EntityManager entityManager;
	
	public List<Student> getByName(String name){ 
   		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		
//		Predicate predicate = criteriaBuilder.equal(root.get("studentName"), name);
		Predicate agePredicate = criteriaBuilder.gt(root.get("age"), 15);
//		Predicate andPredicate = criteriaBuilder.and(predicate , emailpredicate);
		query.where(agePredicate);
		
		TypedQuery<Student> typedQuery = entityManager.createQuery(query);
		return typedQuery.getResultList();
		
	}
	
}
