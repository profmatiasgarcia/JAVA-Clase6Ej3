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
import javax.swing.JOptionPane;

public class Guardar {

    ConexionMySQL bd = new ConexionMySQL();// se declara un alias
    // bd que es igual
    // que decir conexionMySQL
    Mostrar mostrar = new Mostrar();

    public void registrar_alumno(String id, String nombres, String apellidos, String edad, String direccion) {
        // aqui se halan las variables declaradas en el formulario de inicio que
        // traen los valores de las cajas de texto
        // hehe ahora las declaramos trankis
        try {
            bd.conectarBaseDeDatos();
            // conectamos
            bd.sentencia.execute("INSERT INTO `alumnos` (id, nombres, apellidos, edad, direccion) VALUES ('" + id + "', '" + nombres + "', '" + apellidos + "', '" + edad + "', '" + direccion + "')");
            // insertamos los datos
            JOptionPane.showMessageDialog(null, "El  Alumno  Fue  Registrado  Correctamente", "  .::MENSAJE::.",
                    JOptionPane.INFORMATION_MESSAGE);
            mostrar.mostrar_datos();
        } catch (Exception e) {
        }
    }
}
