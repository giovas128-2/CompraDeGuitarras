
package menu;

import conexion.conexionmysql;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.Sesion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Desktop;


/**
 *
 * @author Cesar Hernandez
 */
public class productos extends javax.swing.JFrame {

    /**
     * Creates new form productos
     */
    public productos() {
        initComponents();
    }

    public ImageIcon cargarImagen(String nombreArchivo) {
        String ruta = "imagenes/" + nombreArchivo;
        File archivo = new File(ruta);
        if (!archivo.exists()) return null;

        ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }   
   
    public void cargarProductos(String tabla) {
        String sql = "SELECT * FROM " + tabla;
        conexionmysql con = new conexionmysql();
        Connection cn = con.estableceConexion();
        
        
        DefaultTableModel model = new DefaultTableModel() {
            
            @Override
            public Class<?> getColumnClass(int columna) {
                if (columna == 4) return ImageIcon.class;
                if (columna == 6) return Boolean.class;
                return String.class;
            }
        };

        model.addColumn("id_imagen");
        model.addColumn("nombre");
        model.addColumn("tock");
        model.addColumn("precio");
        model.addColumn("imagen");
        model.addColumn("cantidad");
        model.addColumn("comprar"); // Checkbox
        model.addColumn("imagen_real"); // ← NUEVA COLUMNA (oculta)
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(5).setCellEditor(new javax.swing.DefaultCellEditor(new javax.swing.JTextField()));
        String[] dato = new String[6];
        try{
            Statement st = cn.createStatement(); // ← CORRECTO AHORA
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            dato[0] = rs.getString(1);   // Id_producto
            dato[1] = rs.getString(2);  // nombre
            dato[2] = rs.getString(3);  // tock
            dato[3] = rs.getString(4);  // precio
            dato[4] = rs.getString(5); //imagen
            dato[5] = rs.getString(6); //cantidad
            ImageIcon icono = cargarImagen(dato[4]);
            ImageIcon miniatura = null;

            if (icono != null) {
                Image imagen = icono.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                miniatura = new ImageIcon(imagen);
            } else {
                System.err.println("⚠ Imagen no encontrada: " + dato[4]);
    // Puedes poner una imagen por defecto aquí si quieres
                miniatura = new ImageIcon("imagenes/default.png");
            }

            model.addRow(new Object[]{dato[0], dato[1], dato[2], dato[3], miniatura, "", Boolean.FALSE, dato[4]});

            }
            jTable1.setModel(model);
            jTable1.getColumnModel().getColumn(5).setCellEditor(new javax.swing.DefaultCellEditor(new javax.swing.JTextField()));
            jTable1.setRowHeight(80);
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar registros: " + e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "producto", "stock", "precio", "imagen", "cantidad", "comprar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTOS");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VER PRODUCTOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("COMPRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("GENERAR TICKET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarProductos("imagen");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filas = jTable1.getRowCount();
        String emailUsuario = Sesion.emailUsuario;
        if (emailUsuario == null || emailUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no identificado");
            return;
        }

        StringBuilder resumen = new StringBuilder("Productos comprados:\n");

        for (int i = 0; i < filas; i++) {
            Boolean comprar = (Boolean) jTable1.getValueAt(i, 6);
            String cantidadStr = jTable1.getValueAt(i, 5).toString();

            if (comprar != null && comprar) {
                String id = jTable1.getValueAt(i, 0).toString();
                String nombre = jTable1.getValueAt(i, 1).toString();
                int cantidad = 0;

            try {
                cantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida en el producto: " + nombre);
                return;
            }

                resumen.append(nombre).append(" - Cantidad: ").append(cantidad).append("\n");

        // Ahora actualizamos el campo 'productos' o 'cantidad' del usuario:
                try {
                    Connection cn = new conexionmysql().estableceConexion();
                    Statement st = cn.createStatement();
                    String sqlInsert = "INSERT INTO compras (email, id_producto, nombre_producto, cantidad, precio_unitario, fecha) " +
                   "VALUES ('" + emailUsuario + "', '" + id + "', '" + nombre + "', " + cantidad + ", " + 
                   jTable1.getValueAt(i, 3).toString() + ", NOW())";
                   st.executeUpdate(sqlInsert);

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al registrar compra: " + e.getMessage());
                }
            }
        }

    JOptionPane.showMessageDialog(null, resumen.toString());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int filas = jTable1.getRowCount();
    String emailUsuario = Sesion.emailUsuario;
    String nombreUsuario = "";

    if (emailUsuario == null || emailUsuario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Usuario no identificado");
        return;
    }

    try {
        Connection cn = new conexionmysql().estableceConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT nombre FROM usuarios1 WHERE email = '" + emailUsuario + "'");
        if (rs.next()) {
            nombreUsuario = rs.getString("nombre");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombre de usuario: " + e.getMessage());
        return;
    }

    Document document = new Document();
    try {
        String nombreArchivo = "ticket_" + System.currentTimeMillis() + ".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
        document.open();

        document.add(new Paragraph("TICKET DE COMPRA"));
        document.add(new Paragraph("Usuario: " + nombreUsuario));
        document.add(new Paragraph("Email: " + emailUsuario));
        document.add(new Paragraph("Fecha: " + java.time.LocalDateTime.now()));
        document.add(new Paragraph(" "));

        for (int i = 0; i < filas; i++) {
            Boolean comprar = (Boolean) jTable1.getValueAt(i, 6);
            if (comprar != null && comprar) {
                String producto = jTable1.getValueAt(i, 1).toString();
                int cantidad = Integer.parseInt(jTable1.getValueAt(i, 5).toString());
                double precio = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
                double total = cantidad * precio;

                document.add(new Paragraph("Producto: " + producto));
                document.add(new Paragraph("Cantidad: " + cantidad));
                document.add(new Paragraph("Precio Unitario: $" + String.format("%.2f", precio)));
                document.add(new Paragraph("Total: $" + String.format("%.2f", total)));

                // Imagen
                String nombreImagen = jTable1.getModel().getValueAt(i, 7).toString(); // imagen real
                try {
                    String ruta = "imagenes/" + nombreImagen;
                    File imgFile = new File(ruta);
                    if (imgFile.exists()) {
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(ruta);
                        img.scaleAbsolute(80, 80); // Ajusta el tamaño
                        document.add(img);
                    } else {
                        document.add(new Paragraph("Imagen no encontrada"));
                    }
                } catch (Exception e) {
                    document.add(new Paragraph("Error al cargar imagen"));
                }

                document.add(new Paragraph("--------------------------------------------------"));
            }
        }

        document.close();
        JOptionPane.showMessageDialog(null, "Ticket generado con éxito: " + nombreArchivo);
        Desktop.getDesktop().open(new File(nombreArchivo));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar ticket PDF: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
