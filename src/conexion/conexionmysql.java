package conexion;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class conexionmysql {   
    Connection conectar = null;
    String usuario = "adminaz";
String contraseña = "Giovas777";
String bd = "loginJavaMysql";
String ip = "serverdemo2023.mysql.database.azure.com";
String puerto = "3306";

// Probar sin SSL (temporal)
String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?useSSL=false&allowPublicKeyRetrieval=true";

    public Connection estableceConexion(){
        try {
            // Intentamos cargar el driver de MySQL
            
            // Intentamos realizar la conexión
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            JOptionPane.showMessageDialog(null,"Conexión exitosa a la base de datos");
        } catch (Exception e) {
            // En caso de error, mostramos el mensaje de error
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace(); // Muestra el stack trace para depuración
        }
        return conectar;
    }
    
    public void guardar_imagen(String nombre, double stock, double precio, String ruta){
        Connection con = estableceConexion();
        String insert = "insert into imagen (nombre, stock, precio, imagen) values (?,?,?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            File file = new File(ruta);
            fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);
            ps.setString(1, nombre);
            ps.setDouble(2, stock);
            ps.setDouble(3, precio);
            ps.setBinaryStream(4, fi, (int) file.length());
            
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace(); // Muestra el stack trace para depuración
        }
    }
}