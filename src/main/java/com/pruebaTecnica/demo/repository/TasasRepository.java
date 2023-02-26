package com.pruebaTecnica.demo.repository;

import com.pruebaTecnica.demo.entity.Tasas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TasasRepository extends CrudRepository<Tasas,Long> {

     @Query("SELECT t FROM Tasas t WHERE plazo_min <= :plazo AND plazo_max >= :plazo")
     Tasas findByPlazoMinAndMax(@Param("plazo") int plazo);
}
