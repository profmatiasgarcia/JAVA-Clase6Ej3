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
public class Mostrar {

    ConexionMySQL bd = new ConexionMySQL();
    int i = 0;

    public void mostrar_datos() {
        try {
            bd.conectarBaseDeDatos();
            i = 0;
            bd.resultado = bd.sentencia.executeQuery("SELECT * FROM alumnos");
            // seleccionamos todos de la tabla alumnos
            if (bd.resultado != null) {
                // si la consulta no viene vacia
                while (bd.resultado.next()) {
                    Inicio.Mitabla.setValueAt("" + bd.resultado.getString("id"), i, 0);
                    Inicio.Mitabla.setValueAt("" + bd.resultado.getString("nombres"), i, 1);
                    Inicio.Mitabla.setValueAt("" + bd.resultado.getString("apellidos"), i, 2);
                    Inicio.Mitabla.setValueAt("" + bd.resultado.getString("edad"), i, 3);
                    Inicio.Mitabla.setValueAt("" + bd.resultado.getString("direccion"), i, 4);
                    // Asignamos los valores de la consulta a la tabla
                    i = i + 1;
                }
            }
        } catch (Exception e) {
        }
    }
}
