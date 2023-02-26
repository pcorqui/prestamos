package com.pruebaTecnica.demo.repository;

import com.pruebaTecnica.demo.entity.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamosRepository extends CrudRepository<Prestamo,Long> {

    @Query("SELECT p FROM Prestamo p WHERE p.cliente = :cliente ORDER BY estado DESC")
    List<Prestamo> findAllByClient(@Param("cliente")Long cliente);
}
