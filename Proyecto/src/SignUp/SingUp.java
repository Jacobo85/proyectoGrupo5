package SignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MySQL.MySQLConnection;

public class SingUp extends JFrame {

	private JFrame singUpFrame;
	private JTextField nametextField;
	private JTextField emailtextField;
	private JTextField passwordtextField;
	private JTextField eMailTextField;
	private JTextField passwordTextField;
	private JPanel panel;
	private JLabel nameLabel;
	private JLabel titleLabel;
	private JLabel imageLabel;
	private JLabel eMailLabel;
	private JLabel passwordLabel;
	private RoundButton nextButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp window = new SingUp();
					       window.singUpFrame.setVisible(true);
					    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SingUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		singUpFrame = new JFrame();
		singUpFrame.setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		// Crear un panel (JPanel) para agregar contenido.
        panel = new JPanel();

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        singUpFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
           
        // Crear una etiqueta "Name:"
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        nameLabel.setBounds(70, 76, 33, 14);
        panel.add(nameLabel);
        //Campo para ingresar name
        nametextField = new JTextField(20);
        nametextField.setBounds(134, 74, 166, 20);
        panel.add(nametextField);
           
        // Crear una etiqueta (JLabel) para el t�tulo "SIGN UP!"
        titleLabel = new JLabel("SIGN UP!");
        titleLabel.setBounds(151, 11, 133, 32);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Establece el color del texto
        panel.add(titleLabel); 
        
        // Crea una etiqueta para mostrar la imagen
        imageLabel = new JLabel();
        imageLabel.setBounds(306, 31, 100, 117); // Ajusta las coordenadas y dimensiones seg�n tus necesidades
        panel.add(imageLabel);
        // Ruta de la imagen
        String imagePath = "LOGO CLOUDTOWN-27.png"; // Reemplaza con la ruta correcta de tu imagen
        try {
            // Carga la imagen
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage();

            // Ajusta el tama�o de la imagen
            Image newImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);

            // Actualiza la etiqueta con la nueva imagen
            imageLabel.setIcon(new ImageIcon(newImage));
        }catch (Exception ex) {
          ex.printStackTrace();
        }
           
        // Crear una etiqueta (JLabel) para el t�tulo "email!"
        eMailLabel = new JLabel("E-mail:");
        eMailLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        eMailLabel.setBounds(70, 111, 44, 14);
        panel.add(eMailLabel);
           
        // Crear campo para ingresar "email!"
        eMailTextField = new JTextField(20);
        eMailTextField.setBounds(134, 105, 166, 20);
        panel.add(eMailTextField);
           
        // Crear campo para ingresar "Password"
        passwordTextField = new JTextField(20);
        passwordTextField.setBounds(134, 136, 166, 20);
        panel.add(passwordTextField);
           
        // Crear una etiqueta (JLabel) para el t�tulo "Password"          
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        passwordLabel.setBounds(56, 142, 66, 14);
        panel.add(passwordLabel);
           
        // Crear un bot�n "Next"
        nextButton = new RoundButton("Next");
        nextButton.setBackground(Color.GRAY);
        nextButton.setForeground(new Color(0, 0, 0));
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        nextButton.addActionListener(new ActionListener() {
        	   
          	public void actionPerformed(ActionEvent e){
          		dispose();  
           		//cerrar la ventana actual (SignUp) antes de abrir la siguiente (SignUp2).
           		String nombreTabla="registrousuarios";           		
           		String nombre=nametextField.getText().toString();
           		String eMail=eMailTextField.getText().toString();
           		String password=passwordTextField.getText().toString();
           		           		
           		MySQLConnection conexion=new MySQLConnection();
           		
           		conexion.insertarLineaRegistro(nombreTabla, nombre, eMail, password);
           		
           		conexion.desconectar();
           
           		// Crea una instancia de la siguiente ventana (SignUp2) y hazla visible.
           		SingUp2 singUp2 = new SingUp2();
           		singUp2.getSingUp2Frame().setVisible(true);
           		}
           	});
        nextButton.setBounds(250, 195, 100, 40);
        panel.add(nextButton);        
           
	}

	public JFrame getSingUpFrame() {
		return singUpFrame;
	}

	public void setSingUpFrame(JFrame singUpFrame) {
		this.singUpFrame = singUpFrame;
	}
	
	
	
}
