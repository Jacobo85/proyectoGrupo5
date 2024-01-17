package SignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import MySQL.MySQLConnection;

public class SingUp2 extends JFrame  {

	private JFrame singUp2Frame;
	private JTextField nombreTextField;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JPanel panel;
	private JLabel nombreLabel;
	private JLabel titleLabel;
	private JLabel imageLabel;
	private JLabel cifLabel;
	private JLabel countryLabel;
	private JComboBox<String> paisList;
	private JLabel cityLabel;
	private JLabel codigoPLabel;
	private JLabel dirLabel;
	private JLabel docuLabel;
	private ButtonGroup buttonGroup;
	private RoundButton ad1Button;
	private RoundButton ad1Button_1;
	private JCheckBox checkboxAceptarTerms;
	private JCheckBox checkbox2;
	private RoundButton nextButton;
	private JTextField cifTextField;
	private JTextField ciudadTextField;
	private JTextField codigoPTextField;
	private JTextField dirTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp2 window = new SingUp2();
					window.singUp2Frame.setVisible(true);
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
		singUp2Frame = new JFrame();
		singUp2Frame.setBounds(100, 100, 450, 300);
		singUp2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Crear un panel (JPanel) para agregar contenido.
        panel = new JPanel();

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        singUp2Frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
           
        // Crear una etiqueta "Razon Social:"
        nombreLabel = new JLabel("Name:");
        nombreLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        nombreLabel.setBounds(54, 54, 33, 14);
        panel.add(nombreLabel);
           
        //Campo para ingresar "Razon Social:"
        nombreTextField = new JTextField(20);
        nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
        nombreTextField.setBounds(86, 54, 120, 14);
        panel.add(nombreTextField);
           
        // Crear una etiqueta (JLabel) para el t�tulo "SIGN UP!"
        titleLabel = new JLabel("SIGN UP!");
        titleLabel.setBounds(151, 11, 133, 32);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Establece el color del texto
        panel.add(titleLabel); 
           
           
        // Crea una etiqueta para mostrar la imagen
        imageLabel = new JLabel();
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
           
        cifLabel = new JLabel("CIF:");
        cifLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        cifLabel.setBounds(54, 72, 19, 14);
        panel.add(cifLabel);
           
        countryLabel = new JLabel("Country:");
        countryLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        countryLabel.setBounds(54, 97, 41, 14);
        panel.add(countryLabel);
           
        // Crear la lista desplegable para el pa�s
        String[] countries = {"Espa�a", "Portugal", "Francia", "Italia"};
        paisList = new JComboBox<>(new DefaultComboBoxModel<>(countries));
        paisList.setFont(new Font("SansSerif", Font.PLAIN, 8));
        paisList.setBounds(92, 94, 114, 20);
        panel.add(paisList);
           
        cityLabel = new JLabel("City:");
        cityLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        cityLabel.setBounds(54, 122, 33, 14);
        panel.add(cityLabel);
           
        codigoPLabel = new JLabel("CP:");
        codigoPLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        codigoPLabel.setBounds(54, 147, 33, 14);
        panel.add(codigoPLabel);
           
        dirLabel = new JLabel("Address:");
        dirLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        dirLabel.setBounds(43, 172, 44, 14);
        panel.add(dirLabel);
           
        docuLabel = new JLabel("Documents:");
        docuLabel.setFont(new Font("SansSerif", Font.BOLD, 8));
        docuLabel.setBounds(54, 194, 53, 14);
        panel.add(docuLabel);
           
        //Creo los radio Buttons
           
        radioButton1 = new JRadioButton("Certificado Bancario");
        radioButton1.setBackground(new Color(255, 255, 0));
        radioButton1.setFont(new Font("SansSerif", Font.PLAIN, 8));
        radioButton1.setBounds(62, 215, 120, 10);
        panel.add(radioButton1);
           
        radioButton2 = new JRadioButton("DNI");
        radioButton2.setBackground(new Color(255, 255, 0));
        radioButton2.setFont(new Font("SansSerif", Font.PLAIN, 8));
        radioButton2.setBounds(62, 238, 80, 10);
        panel.add(radioButton2);
          
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        //creo boton adjuntar 1
        ad1Button = new RoundButton("Adjuntar");
        ad1Button.setBackground(Color.GRAY);
        ad1Button.setForeground(new Color(0, 0, 0));
        ad1Button.setFont(new Font("SansSerif", Font.BOLD, 6));
        ad1Button.addActionListener(new ActionListener() {        	
         	public void actionPerformed(ActionEvent e) {
           		
           		}          	
           		//Aqui codigo del evento al pulsar el boton
           	});
        ad1Button.setBounds(180, 214, 59, 14);
        panel.add(ad1Button);
           
        //creo boton adjuntar 2
        ad1Button_1 = new RoundButton("Adjuntar");
        ad1Button_1.setForeground(Color.BLACK);
        ad1Button_1.setFont(new Font("SansSerif", Font.BOLD, 6));
        ad1Button_1.setBackground(Color.GRAY);
        ad1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	}          	
              	//Aqui codigo del evento al pulsar el boton
              });
        ad1Button_1.setBounds(180, 232, 59, 14);
        panel.add(ad1Button_1);
           
        // Crear los checkboxes
        checkboxAceptarTerms = new JCheckBox("Accept Terms and Conditions");
        checkboxAceptarTerms.setBackground(new Color(255, 255, 0));
        checkboxAceptarTerms.setFont(new Font("SansSerif", Font.BOLD, 8));
        checkboxAceptarTerms.setBounds(290, 194, 140, 10);
        panel.add(checkboxAceptarTerms);

        checkbox2 = new JCheckBox("Share Data");
        checkbox2.setBackground(new Color(255, 255, 0));
        checkbox2.setFont(new Font("SansSerif", Font.BOLD, 8));
        checkbox2.setBounds(290, 217, 80, 10);
        panel.add(checkbox2);
           
        nextButton = new RoundButton("Next");
        nextButton.setForeground(Color.BLACK);
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 6));
        nextButton.setBackground(Color.GRAY);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              	dispose();
                // Crear una instancia de la siguiente ventana y hazla visible.
                
                if(checkboxAceptarTerms.isSelected()) {
                	
                	MySQLConnection conexion=new MySQLConnection();
              		
              		String nombreTabla="infousuarios";
              		
               		String nombre=nombreTextField.getText().toString();
               		int id_Usuario;
					try {
						id_Usuario = conexion.sacaIdUsuario(nombre);
						String cif=cifTextField.getText().toString();
	               		String pais=paisList.getSelectedItem().toString();
	               		String ciudad=ciudadTextField.getText().toString();
	               		String cp=codigoPTextField.getText().toString();
	               		String direccion=dirTextField.getText().toString();               		
	               		
	               		conexion.insertarLineaInfoUsuario(nombreTabla, id_Usuario, nombre, cif, pais, 
	               				ciudad, cp, direccion);
	               		
	               		conexion.desconectar();
	               		
	               		CheckOut checkOut = new CheckOut();
	               		checkOut.getCheckOutFrame().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
              		
              	}else {
              		JOptionPane.showInternalMessageDialog(null,"Debe aceptar los términos y condiciones");
              	}
              }          	
             });
        nextButton.setBounds(321, 238, 59, 14);
        panel.add(nextButton);
        
        cifTextField = new JTextField(20);
        cifTextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
        cifTextField.setBounds(86, 72, 120, 14);
        panel.add(cifTextField);
        
        ciudadTextField = new JTextField(20);
        ciudadTextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
        ciudadTextField.setBounds(86, 122, 120, 14);
        panel.add(ciudadTextField);
        
        codigoPTextField = new JTextField(20);
        codigoPTextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
        codigoPTextField.setBounds(86, 147, 120, 14);
        panel.add(codigoPTextField);
        
        dirTextField = new JTextField(20);
        dirTextField.setFont(new Font("Tahoma", Font.PLAIN, 8));
        dirTextField.setBounds(86, 172, 120, 14);
        panel.add(dirTextField);
 
	}

	public JFrame getSingUp2Frame() {
		return singUp2Frame;
	}

	public void setSingUp2Frame(JFrame singUp2Frame) {
		this.singUp2Frame = singUp2Frame;
	}
	
}
