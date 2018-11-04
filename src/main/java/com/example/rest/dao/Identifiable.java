package com.example.rest.dao;

public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {
	public void setId(Long id);
}
