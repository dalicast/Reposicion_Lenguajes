package hn.unah.lenguajes._0.reposicion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes._0.reposicion.Modelos.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    
}
