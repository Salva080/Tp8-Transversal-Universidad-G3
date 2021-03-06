package tp8.transversal.g3.data;

import tp8.transversal.g3.clases.Conexion;
import tp8.transversal.g3.clases.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class MateriaData {
    
    private Connection con;
    
    public MateriaData(Conexion conn){
        this.con =  conn.getConexion();
        /*try {
            this.con =  conn.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }*/
    }
    
    public void ingresarMateria(Materia ma){
        String sql="INSERT INTO materia (idMateria,nombre,anio,activo) VALUES (?,?,?,?)";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,ma.getIdMateria());
            ps.setString(2, ma.getNombre());
            ps.setInt(3, ma.getAnio());
            ps.setBoolean(4, ma.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                ma.setIdMateria(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar nueva materia en la base de datos");
        }
    }
    
    public void modificarEstado (int id){
        String sql="UPDATE materia SET activo = ? WHERE idMateria = ?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Materia m = this.buscarMateria(id);
            ps.setBoolean(1,!m.isEstado());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar el estado de la materia en la base de datos.");
        }
    }
    public void actualizarMateria (Materia ma){
        String sql="UPDATE materia SET nombre = ?, anio = ? WHERE idMateria = ?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(3,ma.getIdMateria());
            ps.setString(1, ma.getNombre());
            ps.setInt(2,ma.getAnio());
            
            if (ps.executeUpdate() > 0){
                JOptionPane.showInternalMessageDialog(null, "Materia actualizada correctamente");
            }else{
                JOptionPane.showInternalMessageDialog(null, "Error en la carga de la Materia");
            }
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next())
                ma.setIdMateria(rs.getInt(1));
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar la materia en la base de datos");
        }
    }
    
    public Materia buscarMateria(int id){
        Materia mat=new Materia();
        String sql="SELECT * FROM `materia` WHERE `idMateria`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));                
                mat.setEstado(rs.getBoolean("activo"));                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar la materia en la base de datos");
        }
        return mat;
    }
    public List<Materia> obtenerMaterias(){
        Materia mat;
        ArrayList<Materia> materias=new ArrayList<>();
        
        String sql="SELECT * FROM materia";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= ps.executeQuery();
        
            while(rs.next()){
                mat=new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setEstado(rs.getBoolean("activo"));
                
                materias.add(mat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener el listado de materias de la base de datos");
        }
        return materias;
    }
    
    public boolean materiaEsta(int id){
        boolean ret=false;
        String sql="SELECT * FROM `materia` WHERE `idMateria`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar la materia en la base de datos");
        }
    return ret;
    }
}