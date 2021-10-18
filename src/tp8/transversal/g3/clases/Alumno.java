package tp8.transversal.g3.clases;

import java.time.LocalDate;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class Alumno {
    
    private int idAlumno=-1;
    private String apellido;
    private String nombre;    
    private LocalDate fechaNac;
    private int legajo;
    private boolean estado;

    public Alumno() {
    }
    public Alumno(int id_alumno,String apellido , String nombre, LocalDate fechaNac, int legajo, boolean estado) {
        this.idAlumno = id_alumno;
        this.apellido= apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.estado = estado;
    }
    public Alumno(String apellido, String nombre, LocalDate fechaNac, int legajo, boolean estado) {
        this.apellido= apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.estado = estado;
    }

    public int getId_alumno() {
        return idAlumno;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public int getLegajo() {
        return legajo;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setId_alumno(int id_alumno) {
        this.idAlumno = id_alumno;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Legajo: " + legajo +" - "+ apellido +" "+ nombre;
    }

}
