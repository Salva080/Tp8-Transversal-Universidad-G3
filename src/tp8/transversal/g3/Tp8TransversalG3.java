package tp8.transversal.g3;

import tp8.transversal.g3.data.CursadaData;
import tp8.transversal.g3.data.AlumnoData;
import tp8.transversal.g3.data.MateriaData;
import tp8.transversal.g3.clases.Conexion;
import tp8.transversal.g3.vistas.ViewEscritorio;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus.garcia , roberto.miranda, salvador.torres
 */
public class Tp8TransversalG3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion con=null;
        
        con = new Conexion();
        /*try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"error de driver");
        }*/
        LocalDate dat=LocalDate.of(1966, 6, 27);
        AlumnoData ad=new AlumnoData(con);
        MateriaData md=new MateriaData(con);
        CursadaData cd=new CursadaData(con);
          
        ViewEscritorio frm = new ViewEscritorio();
        frm.setVisible(true);
        
    }    
}
