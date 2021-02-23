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

public class Buscar {

    ConexionMySQL bd = new ConexionMySQL();

    public void buscar_alumno(String buscar_id) {
        try {
            bd.conectarBaseDeDatos();
            bd.resultado = bd.sentencia.executeQuery("SELECT * FROM alumnos WHERE id = " + buscar_id + "");
            if (bd.resultado != null) {
                while (bd.resultado.next()) {
                    Inicio.i.setText("" + bd.resultado.getString("id"));
                    Inicio.n.setText("" + bd.resultado.getString("nombres"));
                    Inicio.a.setText("" + bd.resultado.getString("apellidos"));
                    Inicio.e.setText("" + bd.resultado.getString("edad"));
                    Inicio.d.setText("" + bd.resultado.getString("direccion"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
        }
    }
}
