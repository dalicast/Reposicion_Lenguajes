package hn.unah.lenguajes._0.reposicion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes._0.reposicion.Modelos.Equipo;
import hn.unah.lenguajes._0.reposicion.Repositorios.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo crearEquipo(Equipo nvoEquipo){
        return this.equipoRepository.save(nvoEquipo);
    }

    public String eliminarEquipo(int codigoEquipo){
        Equipo equipo = this.equipoRepository.findById(codigoEquipo).get();
        if(equipo != null){
            this.equipoRepository.delete(equipo);
            return "Se elimino el equipo: " + codigoEquipo;
        }
        return "No se encontro el codigo de equipo: " + codigoEquipo;
    }

    
    public Equipo buscarEquipo(int codigoEquipo){
        Equipo equipo = this.equipoRepository.findById(codigoEquipo).get();
        if(equipo != null){
            return equipo;
        }
        return null;
    }

}
