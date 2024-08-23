package hn.unah.lenguajes._0.reposicion.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes._0.reposicion.Modelos.Equipo;
import hn.unah.lenguajes._0.reposicion.Modelos.Posicion;
import hn.unah.lenguajes._0.reposicion.Repositorios.EquipoRepository;
import hn.unah.lenguajes._0.reposicion.Repositorios.PosicionRepository;

@Service
public class PosicionService {
    
    @Autowired
    private PosicionRepository posicionRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Posicion> obtenerTabla(){
        return this.posicionRepository.findAll();
    }

    public String simularPartidos() {
    List<Equipo> equipos = equipoRepository.findAll();
    if (equipos.size() < 6) {
        // Creacion de equipos de manera automatica
        for (int i = equipos.size(); i < 6; i++) {
            Equipo nuevoEquipo = new Equipo();
            nuevoEquipo.setNombre("Equipo" + (i + 1));
            nuevoEquipo.setAtaque(Math.random() * 10);
            nuevoEquipo.setDefensa(Math.random() * 10);
            equipoRepository.save(nuevoEquipo);
        }
        equipos = equipoRepository.findAll();
    }

    for (int i = 0; i < equipos.size(); i++) {
        for (int j = i + 1; j < equipos.size(); j++) {
            Equipo equipoA = equipos.get(i);
            Equipo equipoB = equipos.get(j);

            // Simular partido
            int golesA = (int) (Math.random() * 5);
            int golesB = (int) (Math.random() * 5);

            // Actualizar posiciones
            actualizarPosicion(equipoA, golesA, golesB);
            actualizarPosicion(equipoB, golesB, golesA);
        }
    }


    private String actualizarPosicion(Equipo equipo, int golesFavor, int golesContra) {
        Posicion posicion = posicionRepository.findById(equipo.getCodigoEquipo())
            .orElse(new Posicion());
        posicion.setEquipo(equipo);
        posicion.setGolesFavor(posicion.getGolesFavor() + golesFavor);
        posicion.setGolesContra(posicion.getGolesContra() + golesContra);
        if (golesFavor > golesContra) {
            posicion.setGanados(posicion.getGanados() + 1);
        }
        return null;

    }

}
