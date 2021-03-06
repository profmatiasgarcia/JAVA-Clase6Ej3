package StoredProcedures;
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author profmatias
 */
public class ejecucionSP extends javax.swing.JFrame {

    ConexionMySQL bd = new ConexionMySQL();

    /**
     * Creates new form ejecucionSP
     */
    public ejecucionSP() {
        initComponents();
        try {
            bd.conectarBaseDeDatos();
            bd.resultado = bd.listarLocalidades.executeQuery();
            if (bd.resultado != null) {
                while (bd.resultado.next()) {
                    cboxLocalidades.addItem(bd.resultado.getString(2));
                    cboxLocalidad.addItem(bd.resultado.getString(2));
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
//            System.out.println(res);
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlumnos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        btnBuscarId = new javax.swing.JButton();
        btnBuscarLoc = new javax.swing.JButton();
        cboxLocalidades = new javax.swing.JComboBox<>();
        btnAlumnosMayor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        btnBuscarApellido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboxEdad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboxLocalidad = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAlumnos.setText("Listar Todos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        jTableResultados.setBackground(new java.awt.Color(51, 228, 154));
        jTableResultados.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(243, 45, 45)));
        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableResultados);

        btnBuscarId.setText("Buscar x ID");
        btnBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIdActionPerformed(evt);
            }
        });

        btnBuscarLoc.setText("Buscar");
        btnBuscarLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLocActionPerformed(evt);
            }
        });

        cboxLocalidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        btnAlumnosMayor.setText("Filtrar x Edad");
        btnAlumnosMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosMayorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Ejemplo llamada a Stored Procedures");

        jLabel2.setText("Apellido:");

        txtApellido.setColumns(10);

        btnBuscarApellido.setText("Buscar");
        btnBuscarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarApellidoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ingresar nuevo Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 14), javax.swing.UIManager.getDefaults().getColor("nb.errorForeground"))); // NOI18N

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Edad:");

        cboxEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "13", "14", "15", "16", "17", "18" }));

        jLabel6.setText("Direccion:");

        jLabel7.setText("Localidad:");

        cboxLocalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNombres)
            .addComponent(txtApellidos)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(cboxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txtDireccion)
            .addComponent(cboxLocalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAlumnos)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnBuscarId)
                                        .addGap(42, 42, 42)
                                        .addComponent(cboxLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarApellido)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarLoc)
                                .addGap(42, 42, 42)
                                .addComponent(btnAlumnosMayor))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlumnos)
                            .addComponent(btnBuscarId)
                            .addComponent(cboxLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlumnosMayor)
                            .addComponent(btnBuscarLoc))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarApellido))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        try {
            bd.conectarBaseDeDatos();
            bd.resultado = bd.listarAlumnos.executeQuery();
            if (bd.resultado != null) {
//                String res = "";
//                res += " " + bd.resultado.getMetaData().getColumnLabel(1);
//                res += "\t " + bd.resultado.getMetaData().getColumnLabel(2);
//                res += "\t " + bd.resultado.getMetaData().getColumnLabel(3);
//                res += "\t " + bd.resultado.getMetaData().getColumnLabel(4);
//                res += "\t " + bd.resultado.getMetaData().getColumnLabel(5);
//                res += "\t " + bd.resultado.getMetaData().getColumnLabel(6);
//                res += "\n";
//                while (bd.resultado.next()) {
//                    res += (" " + bd.resultado.getString("nombres"));
//                    res += ("\t " + bd.resultado.getString("apellidos"));
//                    res += ("\t " + bd.resultado.getString("edad"));
//                    res += ("\t " + bd.resultado.getString("direccion"));
//                    res += ("\t " + bd.resultado.getString("localidad"));
//                    res += ("\t " + bd.resultado.getString("zona"));
//                    res += "\n";
//                }
                DefaultTableModel modelo = new DefaultTableModel();
                jTableResultados.setModel(modelo);
                ResultSetMetaData columnas = bd.resultado.getMetaData();
                int cantidadColumnas = columnas.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(columnas.getColumnLabel(i));
                }
                while (bd.resultado.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = bd.resultado.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
//            System.out.println(res);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIdActionPerformed
        try {
            bd.conectarBaseDeDatos();
            bd.buscarAlumnosID.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID a buscar")));
            bd.resultado = bd.buscarAlumnosID.executeQuery();
            if (bd.resultado != null) {
                DefaultTableModel modelo = new DefaultTableModel();
                jTableResultados.setModel(modelo);
                ResultSetMetaData columnas = bd.resultado.getMetaData();
                int cantidadColumnas = columnas.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(columnas.getColumnLabel(i));
                }
                while (bd.resultado.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = bd.resultado.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
            bd.resultado.close();
            bd.desconectarBaseDeDatos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarIdActionPerformed

    private void btnBuscarLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLocActionPerformed
        try {
            bd.conectarBaseDeDatos();
            bd.buscarAlumnosLoc.setString(1, cboxLocalidades.getSelectedItem().toString());
            bd.resultado = bd.buscarAlumnosLoc.executeQuery();
            if (bd.resultado != null) {
                DefaultTableModel modelo = new DefaultTableModel();
                jTableResultados.setModel(modelo);
                ResultSetMetaData columnas = bd.resultado.getMetaData();
                int cantidadColumnas = columnas.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(columnas.getColumnLabel(i));
                }
                while (bd.resultado.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = bd.resultado.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
            bd.resultado.close();
            bd.desconectarBaseDeDatos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarLocActionPerformed

    private void btnAlumnosMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosMayorActionPerformed
        try {
            bd.conectarBaseDeDatos();
            bd.buscarAlumnosMayor.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad minima a buscar")));
            bd.resultado = bd.buscarAlumnosMayor.executeQuery();
            if (bd.resultado != null) {
                DefaultTableModel modelo = new DefaultTableModel();
                jTableResultados.setModel(modelo);
                ResultSetMetaData columnas = bd.resultado.getMetaData();
                int cantidadColumnas = columnas.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(columnas.getColumnLabel(i));
                }
                while (bd.resultado.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = bd.resultado.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
            bd.resultado.close();
            bd.desconectarBaseDeDatos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAlumnosMayorActionPerformed

    private void btnBuscarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarApellidoActionPerformed
        try {
            bd.conectarBaseDeDatos();
            bd.buscarAlumnosApellido.setString(1, txtApellido.getText());
            bd.resultado = bd.buscarAlumnosApellido.executeQuery();
            if (bd.resultado != null) {
                DefaultTableModel modelo = new DefaultTableModel();
                jTableResultados.setModel(modelo);
                ResultSetMetaData columnas = bd.resultado.getMetaData();
                int cantidadColumnas = columnas.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(columnas.getColumnLabel(i));
                }
                while (bd.resultado.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = bd.resultado.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
            bd.resultado.close();
            bd.desconectarBaseDeDatos();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarApellidoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            int resul;

            bd.conectarBaseDeDatos();
            bd.insertarAlumno.setString(1, txtNombres.getText());
            bd.insertarAlumno.setString(2, txtApellidos.getText());
            bd.insertarAlumno.setInt(3, Integer.parseInt((String) cboxEdad.getSelectedItem()));
            bd.insertarAlumno.setString(4, txtDireccion.getText());
            bd.insertarAlumno.setString(5, (String) cboxLocalidad.getSelectedItem());

            resul = bd.insertarAlumno.executeUpdate();
            if (resul == 1) {
                JOptionPane.showMessageDialog(null, "El alumno fue ingresado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
                bd.resultado.close();
                bd.desconectarBaseDeDatos();
                txtNombres.setText("");
                txtApellidos.setText("");
                txtDireccion.setText("");
                cboxEdad.setSelectedIndex(0);
                cboxLocalidad.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun  dato  Encontrado", "Mensaje  de  Informacion", JOptionPane.PLAIN_MESSAGE);
            }
            bd.resultado.close();
            bd.desconectarBaseDeDatos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ejecucionSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ejecucionSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ejecucionSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ejecucionSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ejecucionSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnAlumnosMayor;
    private javax.swing.JButton btnBuscarApellido;
    private javax.swing.JButton btnBuscarId;
    private javax.swing.JButton btnBuscarLoc;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cboxEdad;
    private javax.swing.JComboBox<String> cboxLocalidad;
    private javax.swing.JComboBox<String> cboxLocalidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
