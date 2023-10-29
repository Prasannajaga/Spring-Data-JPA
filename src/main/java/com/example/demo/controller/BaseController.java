package com.example.demo.controller;

import java.util.List;

public abstract class BaseController<T>{

	public abstract T save(T data);
	public abstract T update(T data);
	public abstract List<T> findAll();
	public abstract T findById(String id);
	public abstract void delete(String id);

}
