package SignUp;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import MySQL.MySQLConnection;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

/*
 * Esta clase implementa la primera pantalla para poder registrarse
 * 
 * @Version 1.0
 */

public class Welcome {
	
	private JFrame frame;
	private JTextField userTextField;
	private JTextField passwordTextField;
	private JPanel panel;
	private JLabel usernameLabel;
	private JLabel password;
	private JLabel imageLabel;
	private JLabel titleLabel;
	private RoundButton loginButton;
	private JLabel singuplabel;
	private JLabel lblhasOlvidadoTu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Welcome ventana = new Welcome();
					//la ventana se hace visible en el constructor
								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		//invocar la creaci�n de una ventana
		initialize();     
       
	}

	/**
	 * Metodo inicializar ventana.
	 */
	private void initialize() {
			
		//crear una instancia Jframe
		frame = new JFrame();
		//confirgurar el tama�o de la ventana
		frame.setBounds(100, 100, 450, 300);
		//Configurar el cierre de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Crear un panel (JPanel) para agregar contenido.
        panel = new JPanel();

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        // Crear una etiqueta "Username:"
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        usernameLabel.setBounds(36, 58, 67, 14);
        panel.add(usernameLabel);
        //Campo para ingresar username
        userTextField = new JTextField(20);
        userTextField.setBounds(113, 55, 166, 20);
        panel.add(userTextField);         
           
        // Crear una etiqueta "Password:"  
        password= new JLabel("Password:");
        password.setFont(new Font("SansSerif", Font.BOLD, 11));
        password.setBounds(36, 83, 67, 14);
        panel.add(password);
        //Campo para ingresar Password  
        passwordTextField = new JTextField(20);
        passwordTextField.setBounds(113, 86, 166, 20);
        panel.add(passwordTextField);
           
        // Crea una etiqueta para mostrar la imagen
        imageLabel = new JLabel();
        imageLabel.setBounds(306, 31, 100, 117); // Ajusta las coordenadas y dimensiones seg�n tus necesidades
        panel.add(imageLabel);
        // Ruta de la imagen
        String imagePath = "LOGO CLOUDTOWN-27.png"; // Reemplaza con la ruta correcta de tu imagen
		try {
			// Cargar la imagen
			ImageIcon imageIcon = new ImageIcon(imagePath);
			Image image = imageIcon.getImage();

			// Se Ajusta el tama�o de la imagen
			Image newImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);

			// Actualizamos la etiqueta con la nueva imagen
			imageLabel.setIcon(new ImageIcon(newImage));
		} catch (Exception ex) {
			ex.printStackTrace();
		}    
        
		// Crear una etiqueta (JLabel) para el t�tulo "WELCOME!"
        titleLabel = new JLabel("WELCOME!");
        titleLabel.setBounds(134, 12, 133, 32);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Establece el color del texto
        panel.add(titleLabel); 
       
        
        // Crear un bot�n "Log In"
        loginButton = new RoundButton("Log In");
        loginButton.setBackground(Color.GRAY);
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String user=userTextField.getText().toString();
        		String password=passwordTextField.getText().toString();
        		
        		MySQLConnection conexion=new MySQLConnection();
        		
        		try {
					if(conexion.validaUsuario(user, password)==1) {
						
						// Abre la ventana de Sign Up
					    MainMenu mainWindow = new MainMenu();
					    if((user.equals(""))) {
					    	JOptionPane.showMessageDialog(null, "Debe introducir usuario y contraseña");
					    }
					    else if(password.equals("")) {
					    	JOptionPane.showInternalConfirmDialog(null, "Debe introducir usuario y contraseña");
					    }else {
					    	JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");
					    	mainWindow.getUsuarioLabel().setText(user);
						    mainWindow.getMainFrame().setVisible(true);
					    }
					    

					    // Cierra la ventana actual si es necesario
					    frame.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					}
					
					conexion.desconectar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}

        });
        loginButton.setBounds(140, 140, 100, 40);
        panel.add(loginButton);
        
        // Crear una etiqueta (JLabel) para el subrallado del sign up y la creacion del fake link"
        singuplabel = new JLabel("<html><u>Or Sing Up</u></html>");
        singuplabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        singuplabel.setBounds(301, 200, 84, 14);
        singuplabel.setBorder(new EmptyBorder(7, 5, 12, 10));
        panel.add(singuplabel);
        
        // Agregar el MouseListener
        singuplabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // M�todo que se llama cuando se hace clic en la etiqueta "Sign Up" para pasar a la ventana Sign Up
            	mousePressed(e);
        	    // Abre la ventana de Sign Up
        	    SingUp signUpWindow = new SingUp();
        	    signUpWindow.getSingUpFrame().setVisible(true);
        	    //signUpWindow.gets

        	    // Cierra la ventana actual si es necesario
        	    frame.dispose();
            }
        });
             
        // Crear una etiqueta (JLabel) para el subrallado del sign up y la creacion del fake link"
        lblhasOlvidadoTu = new JLabel("<html><u>Has olvidado tu contrase\u00F1a?</u></html>");
        lblhasOlvidadoTu.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblhasOlvidadoTu.setBorder(new EmptyBorder(7, 5, 12, 10));
        lblhasOlvidadoTu.setBounds(113, 224, 166, 14);
        panel.add(lblhasOlvidadoTu);
               
        frame.setVisible(true);
       			
	}
	
}
