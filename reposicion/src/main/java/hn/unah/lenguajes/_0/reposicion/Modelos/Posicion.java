package hn.unah.lenguajes._0.reposicion.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="posicion")
@Data
public class Posicion {
    
    @Id
    private int codigoEquipo;

    private int empates;

    private int ganados;

    private int perdidos;

    private int golesFavor;

    private int golesContra;

    private int puntos;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "codigoequipo")
    private Equipo equipo;
}