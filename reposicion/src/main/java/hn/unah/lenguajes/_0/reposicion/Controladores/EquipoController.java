package hn.unah.lenguajes._0.reposicion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes._0.reposicion.Modelos.Equipo;
import hn.unah.lenguajes._0.reposicion.Servicios.EquipoService;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    
    @Autowired
    private EquipoService equiposervice;

    @PostMapping("/crear/nuevo")
    public Equipo crearEquipo(@RequestBody Equipo nvEquipo){
        return this.equiposervice.crearEquipo(nvEquipo);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEquipo(@RequestParam(name = "codigoEquipo")int codigoEquipo){
        return this.equiposervice.eliminarEquipo(codigoEquipo);
    }

    @GetMapping("/obtener")
    public Equipo buscarEquipo(@RequestParam(name = "codigoEquipo")int codigoEquipo){
        return this.equiposervice.buscarEquipo(codigoEquipo);
    }

}
