/*package com;

import org.springframework.data.repository.CrudRepository;

import com.Parametres;

public interface ParametresRepository extends CrudRepository<Parametres, Integer> {
 
}*/


package com;

import org.springframework.data.repository.CrudRepository;

public interface ParametresRepository extends CrudRepository<Parametres, Long> {
 
}
