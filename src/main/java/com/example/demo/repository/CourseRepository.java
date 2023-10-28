package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;

@Repository
public interface CourseRepository extends BaseRepository<Course, String>{

}
