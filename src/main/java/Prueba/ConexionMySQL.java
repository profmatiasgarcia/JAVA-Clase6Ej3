package Prueba;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQL {

    public static Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;

    public void conectarBaseDeDatos() {
        try {

            //final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
            final String CONTROLADOR = "org.mariadb.jdbc.Driver";

            Class.forName(CONTROLADOR);

            //conexion = DriverManager.getConnection("jdbc:mysql://localhost/colegio", "root", "");
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost/colegio", "root", "");
            sentencia = conexion.createStatement();
            // variable sentencia encargada de las funciones hacia la db
        } catch (ClassNotFoundException ex1) {

            ex1.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error Carga Driver");
            // encaso de errores referentes a driver error de carga, no
            // encontrarlo etc
            System.exit(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error Creacion Statement");
            // encaso de no encontrar la bd
            System.exit(1);
        }
    }

    public void desconectarBaseDeDatos() {
        // metodo de desconexion
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    // si la conexion devuelve valores nulos
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
