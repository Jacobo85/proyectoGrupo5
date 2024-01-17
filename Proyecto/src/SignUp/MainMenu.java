package SignUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainMenu {

	private JFrame mainFrame;
	private JLabel usuarioLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.getMainFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//crear una instancia Jframe
		setMainFrame(new JFrame());
		//confirgurar el tama�o de la ventana
		getMainFrame().setBounds(100, 100, 450, 300);
		//Configurar el cierre de la ventana
		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// Crear un panel (JPanel) para agregar contenido.
		JPanel panel = new JPanel();

		//Establecer el color de fondo del panel en amarillo.
		panel.setBackground(Color.YELLOW);

		//Agregar el panel a la ventana.
		getMainFrame().getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		// Ruta de la imagen
		String imagePath = "LOGO CLOUDTOWN-27.png"; // Reemplaza con la ruta correcta de tu imagen
		
		try {
	           // Cargar la imagen
	           ImageIcon imageIcon = new ImageIcon(imagePath);
	           Image image = imageIcon.getImage();
	           
	           JLabel bienvenidoLabel = new JLabel("Bienvenido");
	           bienvenidoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
	           bienvenidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
	           bienvenidoLabel.setBounds(10, 31, 416, 31);
	           panel.add(bienvenidoLabel);
	           
	           usuarioLabel = new JLabel("Bienvenido");
	           usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
	           usuarioLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
	           usuarioLabel.setBounds(10, 73, 416, 31);
	           panel.add(usuarioLabel);
		}catch (Exception ex) {
			ex.printStackTrace();
		}    
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JLabel getUsuarioLabel() {
		return usuarioLabel;
	}

	public void setUsuarioLabel(JLabel usuarioLabel) {
		this.usuarioLabel = usuarioLabel;
	}
	
	
}
