package hn.unah.lenguajes._0.reposicion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes._0.reposicion.Modelos.Posicion;
import hn.unah.lenguajes._0.reposicion.Servicios.PosicionService;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {
    
    @Autowired
    private PosicionService posicionService;

    @GetMapping("/obtener/tabla")
    public List<Posicion> obtenerTabla(){
        return this.posicionService.obtenerTabla();
    }

}
