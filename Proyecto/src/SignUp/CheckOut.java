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
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

public class CheckOut extends JFrame {

	private JFrame CheckOutFrame;
	private JLabel sliderValueLabel;
	private JPanel panel;
	private JLabel fianzaLabel;
	private JLabel titleLabel;
	private JLabel imageLabel;
	private JSlider slider;
	private JLabel pagoLabel;
	private RoundButton ad1Button;
	private RoundButton nextButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut window = new CheckOut();
					window.CheckOutFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CheckOutFrame = new JFrame();
		CheckOutFrame.setBounds(100, 100, 450, 300);
		CheckOutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Crear un panel (JPanel) para agregar contenido.
        panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

        //Establecer el color de fondo del panel en amarillo.
        panel.setBackground(Color.YELLOW);

        //Agregar el panel a la ventana.
        CheckOutFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
           
        // Crear una etiqueta "Fianza Establecida:"
        fianzaLabel = new JLabel("Fianza Establecida Mensual:");
        fianzaLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        fianzaLabel.setBounds(28, 69, 256, 14);
        panel.add(fianzaLabel);
           
        //Crear una etiqueta (JLabel) para el t�tulo "Check Out!"
        titleLabel = new JLabel("Check Out!");
        titleLabel.setBounds(151, 11, 133, 32);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Establece el color del texto
        panel.add(titleLabel); 
           
           
        // Crea una etiqueta para mostrar la imagen
        imageLabel = new JLabel();
        imageLabel.setBounds(362, 11, 64, 82); // Ajusta las coordenadas y dimensiones seg�n tus necesidades
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
           
        // Crear el slider
        slider = new JSlider(JSlider.HORIZONTAL,0, 100, 50);
        slider.setForeground(new Color(0, 0, 0));
        slider.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        slider.setFont(new Font("Tahoma", Font.PLAIN, 8));
        slider.setBounds(38, 89, 300, 35);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);
          
        //Creo la etiqueta para guardar valor del slider   
        sliderValueLabel = new JLabel("Su fianza Anual es de : 150");
        sliderValueLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        sliderValueLabel.setBounds(28, 150, 200, 14);
        panel.add(sliderValueLabel);
           
        //Crear la eqtiqueta del pago  
        pagoLabel = new JLabel("Upload Pago");
        pagoLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        pagoLabel.setBounds(28, 175, 163, 26);
        panel.add(pagoLabel);
           
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
        ad1Button.setBounds(67, 215, 59, 14);
        panel.add(ad1Button);
           
        //creo boton end  
        nextButton = new RoundButton("End");
        nextButton.setForeground(Color.BLACK);
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 9));
        nextButton.setBackground(Color.GRAY);
        nextButton.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
			}
			// Aqui codigo del evento al pulsar el boton
		});
        nextButton.setBounds(303, 215, 72, 26);
        panel.add(nextButton);
           
	
        //Guardamos el cambio del slider
        slider.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        int value = slider.getValue()*12;
        sliderValueLabel.setText("Su fianza es de: " + value);
            // Imprimimos en consola valor del slider para prueba
           // System.out.println("Valor del slider: " + value);
        	}
        });
	  
        CheckOutFrame.setVisible(true);
	}

	public JFrame getCheckOutFrame() {
		return CheckOutFrame;
	}

	public void setCheckOutFrame(JFrame checkOutFrame) {
		CheckOutFrame = checkOutFrame;
	}

}
