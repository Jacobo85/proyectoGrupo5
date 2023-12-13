package SignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SingUp2 extends JFrame  {

	JFrame SingUp2;
	private JTextField razontextField;
	private JTextField textField;
	private JTextField countrytextField;
	private JTextField cityField;
	private JTextField cptextField;
	private JTextField adtextField_1;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp2 window = new SingUp2();
					window.SingUp2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SingUp2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SingUp2 = new JFrame();
		SingUp2.setBounds(100, 100, 450, 300);
		SingUp2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 // Crear un panel (JPanel) para agregar contenido.
        JPanel panel = new JPanel();

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        SingUp2.getContentPane().add(panel, BorderLayout.CENTER);
           panel.setLayout(null);
           
        // Crear una etiqueta "Razon Social:"
           JLabel razonLabel = new JLabel("Name:");
           razonLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           razonLabel.setBounds(62, 60, 33, 14);
           panel.add(razonLabel);
           
        //Campo para ingresar "Razon Social:"
           razontextField = new JTextField(20);
           razontextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
           razontextField.setBounds(94, 62, 120, 10);
           panel.add(razontextField);
           
        // Crear una etiqueta (JLabel) para el t�tulo "SIGN UP!"
           JLabel titleLabel = new JLabel("SIGN UP!");
           titleLabel.setBounds(151, 11, 133, 32);
           titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
           titleLabel.setForeground(Color.BLACK); // Establece el color del texto
           panel.add(titleLabel); 
           
           
           // Crea una etiqueta para mostrar la imagen
                 JLabel imageLabel = new JLabel();
                 imageLabel.setBounds(294, 11, 100, 96); // Ajusta las coordenadas y dimensiones seg�n tus necesidades
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
           
        // Crear una etiqueta (JLabel) para el t�tulo "CIF!"
           JLabel lblcif = new JLabel("CIF:");
           lblcif.setFont(new Font("SansSerif", Font.BOLD, 8));
           lblcif.setBounds(94, 62, 120, 10);
           panel.add(lblcif);
           
           JLabel lblCif = new JLabel("CIF:");
           lblCif.setFont(new Font("SansSerif", Font.BOLD, 8));
           lblCif.setBounds(72, 72, 33, 14);
           panel.add(lblCif);
           
           textField = new JTextField(20);
           textField.setFont(new Font("Tahoma", Font.PLAIN, 8));
           textField.setBounds(94, 74, 120, 10);
           panel.add(textField);
           
           JLabel countryLabel = new JLabel("Country:");
           countryLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           countryLabel.setBounds(54, 85, 41, 14);
           panel.add(countryLabel);
           
           countrytextField = new JTextField(20);
           countrytextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
           countrytextField.setBounds(94, 87, 120, 10);
           panel.add(countrytextField);
           
        // Crear la lista desplegable para el pa�s
           String[] countries = {"Espa�a", "Portugal", "Francia", "Italia"};
           JComboBox<String> countryDropdown = new JComboBox<>(new DefaultComboBoxModel<>(countries));
           countryDropdown.setFont(new Font("SansSerif", Font.PLAIN, 8));
           countryDropdown.setBounds(94, 87, 120, 20);
           panel.add(countryDropdown);
           
           JLabel cityLabel = new JLabel("City:");
           cityLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           cityLabel.setBounds(54, 97, 33, 14);
           panel.add(cityLabel);
           
           cityField = new JTextField(20);
           cityField.setFont(new Font("Tahoma", Font.PLAIN, 8));
           cityField.setBounds(94, 99, 120, 10);
           panel.add(cityField);
           
           JLabel codigoPLabel = new JLabel("CP:");
           codigoPLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           codigoPLabel.setBounds(54, 112, 33, 14);
           panel.add(codigoPLabel);
           
           cptextField = new JTextField(20);
           cptextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
           cptextField.setBounds(94, 110, 120, 10);
           panel.add(cptextField);
           
           JLabel dirLabel = new JLabel("Address:");
           dirLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           dirLabel.setBounds(42, 122, 53, 14);
           panel.add(dirLabel);
           
           adtextField_1 = new JTextField(20);
           adtextField_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
           adtextField_1.setBounds(94, 124, 120, 10);
           panel.add(adtextField_1);
           
           JLabel docuLabel = new JLabel("Documents:");
           docuLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
           docuLabel.setBounds(42, 137, 53, 14);
           panel.add(docuLabel);
           
           //Creo los radio Buttons
           
           radioButton1 = new JRadioButton("Certificado Bancario");
           radioButton1.setBackground(new Color(255, 255, 0));
           radioButton1.setFont(new Font("SansSerif", Font.PLAIN, 8));
           radioButton1.setBounds(62, 158, 120, 10);
           panel.add(radioButton1);
           
           radioButton2 = new JRadioButton("DNI");
           radioButton2.setBackground(new Color(255, 255, 0));
           radioButton2.setFont(new Font("SansSerif", Font.PLAIN, 8));
           radioButton2.setBounds(62, 181, 80, 10);
           panel.add(radioButton2);
           
           ButtonGroup buttonGroup = new ButtonGroup();
           buttonGroup.add(radioButton1);
           buttonGroup.add(radioButton2);
           //creo boton adjuntar 1
           RoundButton ad1Button = new RoundButton("Adjuntar");
           ad1Button.setBackground(Color.GRAY);
           ad1Button.setForeground(new Color(0, 0, 0));
           ad1Button.setFont(new Font("SansSerif", Font.BOLD, 6));
           ad1Button.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		
           	}          	
           	//Aqui codigo del evento al pulsar el boton
           });
           ad1Button.setBounds(180, 157, 59, 14);
           panel.add(ad1Button);
           
           //creo boton adjuntar 2
           RoundButton ad1Button_1 = new RoundButton("Adjuntar");
           ad1Button_1.setForeground(Color.BLACK);
           ad1Button_1.setFont(new Font("SansSerif", Font.BOLD, 6));
           ad1Button_1.setBackground(Color.GRAY);
           ad1Button.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e) {
              	}          	
              	//Aqui codigo del evento al pulsar el boton
              });
           ad1Button_1.setBounds(180, 175, 59, 14);
           panel.add(ad1Button_1);
           
        // Crear los checkboxes
           JCheckBox checkbox1 = new JCheckBox("Accept Terms and Conditions");
           checkbox1.setBackground(new Color(255, 255, 0));
           checkbox1.setFont(new Font("SansSerif", Font.BOLD, 8));
           checkbox1.setBounds(290, 158, 140, 10);
           panel.add(checkbox1);

           JCheckBox checkbox2 = new JCheckBox("Share Data");
           checkbox2.setBackground(new Color(255, 255, 0));
           checkbox2.setFont(new Font("SansSerif", Font.BOLD, 8));
           checkbox2.setBounds(290, 181, 80, 10);
           panel.add(checkbox2);
           
           RoundButton nextButton = new RoundButton("Next");
           nextButton.setForeground(Color.BLACK);
           nextButton.setFont(new Font("SansSerif", Font.BOLD, 6));
           nextButton.setBackground(Color.GRAY);
           nextButton.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e) {
              		dispose();
                    // Crear una instancia de la siguiente ventana y hazla visible.
                    CheckOut checkOut = new CheckOut();
                    checkOut.CheckOut.setVisible(true);             		
              	}          	
              	//Aqui codigo del evento al pulsar el boton
              });
           nextButton.setBounds(321, 220, 59, 14);
           panel.add(nextButton);
           
                 
           
	}
}
