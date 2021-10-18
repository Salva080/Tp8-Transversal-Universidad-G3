package tp8.transversal.g3.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tp8.transversal.g3.clases.Alumno;
import tp8.transversal.g3.clases.Conexion;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class AlumnoData {
    private Connection con;
    
    public AlumnoData(Conexion conn){
        this.con =  conn.getConexion();
        /*try {
            this.con =  conn.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion en alumnoData.");
        }*/
    }
    
    public void ingresarAlumno(Alumno al){
        String sql="INSERT INTO alumno (legajo,activo,apellido,nombre,fechaNac) VALUES (?,?,?,?,?)";       
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, al.getLegajo());
            ps.setBoolean(2, al.isEstado());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getNombre());
            ps.setDate(5, Date.valueOf(al.getFechaNac()));
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                al.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Ingresado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion en metodo ingresarAlumno.");
        }
    }
    
    public void actualizarAlumno(Alumno al){
        String sql="UPDATE alumno SET legajo =?,activo=?,apellido=?,nombre=?,fechaNac=? where idAlumno=?";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, al.getLegajo());
            ps.setBoolean(2, al.isEstado());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getNombre());
            ps.setDate(5, Date.valueOf(al.getFechaNac()));
            ps.setInt(6, al.getId_alumno());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            al.setId_alumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    
    public void modificarEstado(int id){
        String sql="UPDATE `alumno` SET `activo`=? WHERE `idAlumno`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Alumno a = this.buscarAlumno(id);
            ps.setBoolean(1, !a.isEstado());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion en modificarEstado");
        }
    }
   
    public Alumno buscarAlumno(int id){
        Alumno a= new Alumno();
        
        String sql="SELECT * FROM alumno WHERE idAlumno = ? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                a.setLegajo(rs.getInt("legajo"));
                a.setEstado(rs.getBoolean("activo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setId_alumno(rs.getInt("idAlumno"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return a;
    }
    
    public List<Alumno> obtenerAlumnos(){
        Alumno a;
        ArrayList<Alumno> alumnos=new ArrayList<>();        
        String sql="SELECT * FROM alumno";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= ps.executeQuery();
        
            while(rs.next()){
                a = new Alumno();
                a.setLegajo(rs.getInt("legajo"));
                a.setEstado(rs.getBoolean("activo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setId_alumno(rs.getInt("idAlumno"));
                alumnos.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return alumnos;
    }
}
