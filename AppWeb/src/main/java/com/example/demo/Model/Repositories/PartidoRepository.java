package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Model.Entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findDistinctByIdEquipoLocalOrderByFechaDesc(Equipo equipoLocal);
}
