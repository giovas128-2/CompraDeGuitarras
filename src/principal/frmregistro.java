
package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import conexion.conexionmysql;
import java.awt.HeadlessException;
import java.sql.SQLException;

public class frmregistro extends javax.swing.JDialog {
    conexionmysql con= new conexionmysql();
    Connection cn = con.estableceConexion();
    public frmregistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        REGISTRO = new javax.swing.JPanel();
        txtCURP = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtFechaDeNacimiento = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtEstadoCivil = new javax.swing.JComboBox<>();
        jbRegistrodeusuario = new javax.swing.JButton();
        txttipodeusuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        REGISTRO.setBackground(new java.awt.Color(0, 0, 0));
        REGISTRO.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        REGISTRO.setForeground(new java.awt.Color(255, 255, 255));

        txtCURP.setBackground(new java.awt.Color(51, 51, 51));
        txtCURP.setForeground(new java.awt.Color(255, 255, 255));
        txtCURP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CURP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtNombre.setBackground(new java.awt.Color(51, 51, 51));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtApellidos.setBackground(new java.awt.Color(51, 51, 51));
        txtApellidos.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtemail.setBackground(new java.awt.Color(51, 51, 51));
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtFechaDeNacimiento.setBackground(new java.awt.Color(51, 51, 51));
        txtFechaDeNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaDeNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtContraseña.setBackground(new java.awt.Color(51, 51, 51));
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        txtEstadoCivil.setBackground(new java.awt.Color(51, 51, 51));
        txtEstadoCivil.setForeground(new java.awt.Color(255, 255, 255));
        txtEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "soltero", "casado", "viudo", "divorciado" }));
        txtEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado Civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jbRegistrodeusuario.setBackground(new java.awt.Color(51, 51, 51));
        jbRegistrodeusuario.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrodeusuario.setText("REGISTRO DE USUARIO");
        jbRegistrodeusuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbRegistrodeusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrodeusuarioActionPerformed(evt);
            }
        });

        txttipodeusuario.setBackground(new java.awt.Color(51, 51, 51));
        txttipodeusuario.setForeground(new java.awt.Color(255, 255, 255));
        txttipodeusuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Administrador", "Usuario" }));
        txttipodeusuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "tipo de usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        javax.swing.GroupLayout REGISTROLayout = new javax.swing.GroupLayout(REGISTRO);
        REGISTRO.setLayout(REGISTROLayout);
        REGISTROLayout.setHorizontalGroup(
            REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(REGISTROLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContraseña)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemail)
                    .addComponent(txtEstadoCivil, 0, 180, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaDeNacimiento)
                    .addComponent(txtApellidos)
                    .addComponent(txtCURP)
                    .addComponent(txttipodeusuario, 0, 193, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addGroup(REGISTROLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jbRegistrodeusuario)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        REGISTROLayout.setVerticalGroup(
            REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REGISTROLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(txtCURP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDeNacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(REGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(txttipodeusuario))
                .addGap(69, 69, 69)
                .addComponent(jbRegistrodeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REGISTRO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(REGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrodeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrodeusuarioActionPerformed
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String email = txtemail.getText().trim();
        String fechadenacimiento = txtFechaDeNacimiento.getText().trim();
        String curp = txtCURP.getText().trim();
         String contraseña = String.valueOf(txtContraseña.getPassword()).trim();
        String estadocivil = txtEstadoCivil.getSelectedItem().toString().toLowerCase();
        String tipodeusuario = txttipodeusuario.getSelectedItem().toString().toLowerCase();
        
        if(nombre.isEmpty()||apellidos.isEmpty()||email.isEmpty()||fechadenacimiento.isEmpty()||curp.isEmpty()||contraseña.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE DE COMPLETAR LOS DATOS");
        }else if (estadocivil.equalsIgnoreCase("Seleccionar")){
            JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR UN ESTADO CIVIL VÁLIDO");
        }else if(tipodeusuario.equalsIgnoreCase("Seleccionar")){
            JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR UN TIPO DE USUARIO VÁLIDO");
        }else{
                try{
                String consulta = "insert into usuarios1(nombre, apellido, email, CURP, estado_civil, fecha_nacimiento, contraseña, tipo_usuario) values (?,?,?,?,?,?,?,?);";
                PreparedStatement ps = cn.prepareStatement(consulta, java.sql.Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setString(3, email);
                ps.setString(4, curp);
                ps.setString(5, estadocivil);
                ps.setString(6, fechadenacimiento);
                ps.setString(7, contraseña);
                ps.setString(8, tipodeusuario);
                limpar();
                
                int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
               java.sql.ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "Usuario registrado con ID: " + idGenerado);
                }
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario.");
                }     
            }catch (HeadlessException | SQLException e){
                e.printStackTrace();
JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());

            }
        }
    }//GEN-LAST:event_jbRegistrodeusuarioActionPerformed
    void limpar(){
        txtNombre.setText("");
        txtApellidos.setText("");
        txtemail.setText("");
        txtFechaDeNacimiento.setText("");
        txtCURP.setText("");
        txtContraseña.setText("");
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            frmregistro dialog = new frmregistro(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel REGISTRO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbRegistrodeusuario;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JComboBox<String> txtEstadoCivil;
    private javax.swing.JTextField txtFechaDeNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtemail;
    private javax.swing.JComboBox<String> txttipodeusuario;
    // End of variables declaration//GEN-END:variables
}
