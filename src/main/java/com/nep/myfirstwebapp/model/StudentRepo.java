package com.nep.myfirstwebapp.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepo extends CrudRepository<Student, Long> {
	
}
