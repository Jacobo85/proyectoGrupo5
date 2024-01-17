package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLConnection {
    private static Connection conn;
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String user="root";
    private static String password="";
    private static String databasename="proyectoifp";
    private static String url="jdbc:mysql://localhost:3306/" + databasename;

	public MySQLConnection() {

		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Conectado a la base de datos: " + databasename);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar" + e);
		} catch (SQLException ex) {
			System.out.println("Error al conectar" + ex);
		}
	}
        
	public void desconectar() {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Desconectado de la base de datos: " + databasename);
			}
		} catch (SQLException e) {
			System.out.println("Error al desconectar: " + e);
		}
	}
	
    public void insertarLineaRegistro(String nombreTabla, String nombre, String eMail, String password){
        try{
        	Statement statement=conn.createStatement();

            String insertSQL="INSERT INTO "+nombreTabla+" (Nombre, Email, Password)"
                    + "VALUES ('" + nombre +"', '" + eMail +"', '" + password +"')";

            int lineasAfectadas=statement.executeUpdate(insertSQL);
    
            if(lineasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Usuario registrrado con éxito");

            }else{
            	 JOptionPane.showMessageDialog(null, "Algo ha salido mal. Vuelva a intentarlo");
            }

            statement.close();

        }catch(SQLException e){
            System.out.println("Error al insertar la línea: " +e);
        }
    }
    
    public int sacaIdUsuario(String nombre) throws SQLException {
    	int id_Usuario=0;
    	
    	Statement stm=conn.createStatement();
		String selectSQL="SELECT Id_Usuario FROM registrousuarios "
				+ "WHERE Nombre= '"+nombre+"'";
		ResultSet resultado=stm.executeQuery(selectSQL);
		
		while(resultado.next()) {
			id_Usuario=resultado.getInt("Id_Usuario");
		}
		
		stm.close();
    	
    	return id_Usuario;
    }
    
    public void insertarLineaInfoUsuario(String nombreTabla, int id_Usuario, String nombre, 
    		String cif, String pais, String ciudad, String cp, String direccion){
        try{

        	Statement statement=conn.createStatement();

            String insertSQL="INSERT INTO "+nombreTabla+" (Id_Usuario, Nombre, "
            		+ "Cif, Pais, Ciudad, Cp, Direccion)"
                    + "VALUES ("+ id_Usuario+", '" + nombre +"', '" + cif +"', '" + pais +"', '" 
            		+ ciudad +"', '" + cp +"', '" + direccion+"')";

            int lineasAfectadas=statement.executeUpdate(insertSQL);
    
            if(lineasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Info añadida a usuario satisfactoriamente");

            }else{
            	 JOptionPane.showMessageDialog(null, "Algo ha salido mal. Vuelva a intentarlo");
            }

            statement.close();

        }catch(SQLException e){
            System.out.println("Error al insertar la línea: " +e);
        }
    }
    
    public int validaUsuario(String user, String pass) throws SQLException {
    	
    		String rUser="";
    		String rPass="";
			Statement stm=conn.createStatement();
			String selectSQL="SELECT Email, Password FROM registrousuarios "
					+ "WHERE Email= '"+user+"' AND Password= '"+pass+"'";
			ResultSet resultado=stm.executeQuery(selectSQL);
			
			while(resultado.next()) {
				rUser=resultado.getString("Email");
				rPass=resultado.getString("Password");
			}
			
			stm.close();
			
			if((rUser.equals(user))&&(rPass.equals(pass))){
				return 1;
			}else {
				return 0;
			}
    }
    
}
