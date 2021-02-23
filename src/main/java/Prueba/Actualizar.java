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

public class Actualizar {

    ConexionMySQL bd = new ConexionMySQL();
    Mostrar mostrar = new Mostrar();

    public void actualizar_alumno(String elegir_id, String no, String ape, String ed, String dir) {
        // Estas variables vienen delformulario de inicio pronto las
        // declararemos /D
        try {
            bd.conectarBaseDeDatos();
            bd.sentencia.execute("UPDATE `alumnos` SET nombres = '" + no + "', apellidos = '" + ape + "', edad = '" + ed + "', direccion = '" + dir + "' WHERE id = " + elegir_id + " ");
            // Actualiza los datos donde id sea igual a elegir_id (H)
            JOptionPane.showMessageDialog(null, "Los Datos Del Alumno Fueron Actualizados Correctamente",
                    "  .::MENSAJE::.", JOptionPane.INFORMATION_MESSAGE);
            mostrar.mostrar_datos();
        } catch (Exception e) {
        }
    }
}
