package com.nep.myfirstwebapp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GroupRepo extends CrudRepository<Group, Long>{

}
