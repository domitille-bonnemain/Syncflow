package com;

import org.springframework.data.repository.CrudRepository;

import com.Magasin2;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Magasin2Repository extends CrudRepository<Magasin2, Integer> {

}
