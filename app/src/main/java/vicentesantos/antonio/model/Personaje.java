package vicentesantos.antonio.model;

import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private int imagenId;
    private String descripcion;
    private String caracteristicas;

    public Personaje(String nombre, int imagenId, String descripcion, String caracteristicas) {
        this.nombre = nombre;
        this.imagenId = imagenId;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }
}