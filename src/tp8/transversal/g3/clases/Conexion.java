package tp8.transversal.g3.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class Conexion {
    private String url="jdbc:mariadb://localhost/universidadg3";
    private String usuario="root";
    private String password="";
    
    private Connection conexion = null;
    
    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); //revisar o consultar
            
            conexion = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                    + "&user=" + "root" + "&password=" + "");

            System.out.println("Conexion establecida correctamente");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    
    /*
    public Conexion() throws ClassNotFoundException{
            Class.forName("org.mariadb.jdbc.Driver");
        
    }
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        //Cargamos las clases de mariadb que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");

    }
    
    public Connection getConexion() throws SQLException{
        if(conexion == null){
                    // Setup the connection with the DB
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }
*/
}
