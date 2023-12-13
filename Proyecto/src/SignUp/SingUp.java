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

public class SingUp extends JFrame {

	JFrame SingUp;
	private JTextField nametextField;
	private JTextField emailtextField;
	private JTextField passwordtextField;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp window = new SingUp();
					       window.SingUp.setVisible(true);
					    
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
		SingUp = new JFrame();
		SingUp.setBounds(100, 100, 450, 300);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		 // Crear un panel (JPanel) para agregar contenido.
        JPanel panel = new JPanel();

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        SingUp.getContentPane().add(panel, BorderLayout.CENTER);
           panel.setLayout(null);
           
        // Crear una etiqueta "Name:"
           JLabel nameLabel = new JLabel("Name:");
           nameLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
           nameLabel.setBounds(70, 76, 33, 14);
           panel.add(nameLabel);
        //Campo para ingresar name
           nametextField = new JTextField(20);
           nametextField.setBounds(134, 74, 166, 20);
           panel.add(nametextField);
           
        // Crear una etiqueta (JLabel) para el t�tulo "SIGN UP!"
           JLabel titleLabel = new JLabel("SIGN UP!");
           titleLabel.setBounds(151, 11, 133, 32);
           titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
           titleLabel.setForeground(Color.BLACK); // Establece el color del texto
           panel.add(titleLabel); 
           
           
           // Crea una etiqueta para mostrar la imagen
                 JLabel imageLabel = new JLabel();
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
           JLabel lblEmail = new JLabel("E-mail:");
           lblEmail.setFont(new Font("SansSerif", Font.BOLD, 11));
           lblEmail.setBounds(70, 111, 44, 14);
           panel.add(lblEmail);
           
        // Crear campo para ingresar "email!"
           textField = new JTextField(20);
           textField.setBounds(134, 105, 166, 20);
           panel.add(textField);
           
        // Crear campo para ingresar "Password"
           textField_1 = new JTextField(20);
           textField_1.setBounds(134, 136, 166, 20);
           panel.add(textField_1);
           
          // Crear una etiqueta (JLabel) para el t�tulo "Password"          
           JLabel nameLabel_1_1 = new JLabel("Password:");
           nameLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 11));
           nameLabel_1_1.setBounds(56, 142, 66, 14);
           panel.add(nameLabel_1_1);
           
           // Crear un bot�n "Next"
           RoundButton nextButton = new RoundButton("Next");
           nextButton.setBackground(Color.GRAY);
           nextButton.setForeground(new Color(0, 0, 0));
           nextButton.setFont(new Font("SansSerif", Font.BOLD, 11));
           nextButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e){
           		dispose();  
           //cerrar la ventana actual (SignUp) antes de abrir la siguiente (SignUp2).	
           
           // Crea una instancia de la siguiente ventana (SignUp2) y hazla visible.
            SingUp2 singUp2 = new SingUp2();
            singUp2.SingUp2.setVisible(true);
           	}
           });
           nextButton.setBounds(250, 195, 100, 40);
           panel.add(nextButton);        
           
	}	
}
