package hn.unah.lenguajes._0.reposicion.Modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="equipo")
@Data
public class Equipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoequipo")
    private int codigoEquipo;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ataque")
    private double ataque;

    @Column(name = "defensa")
    private double defensa;

    @OneToOne(mappedBy = "equipos", cascade = CascadeType.ALL)
    private Posicion posicion;
}
