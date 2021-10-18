package tp8.transversal.g3.clases;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class Cursada {
    
    private int idCursada;
    private Alumno alumno;
    private Materia materia;
    private float nota;

    public Cursada() {
    }
    public Cursada(int idCursada, Alumno alumno, Materia materia, float nota) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    public Cursada(Alumno alumno, Materia materia, float nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }    
  

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
