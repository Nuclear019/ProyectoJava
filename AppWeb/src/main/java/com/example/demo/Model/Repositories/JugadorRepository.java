package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Jugador;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

}
