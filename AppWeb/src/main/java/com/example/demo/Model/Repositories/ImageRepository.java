package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Model.Entities.Imagen;
import com.example.demo.Model.Entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Imagen, Long> {
    Optional<Imagen> findByIdJugador(Jugador idJugador);



}
