package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaElegirDoc extends JFrame {

	private JButton btnCerrar;
	private JButton btnVolver;
	private JButton btnLibro;
	private JButton btnPonencia;
	private JButton btnArticulo;
	private JPanel contentPane;

	public VentanaElegirDoc() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBarraSuperior = new JPanel();
		panelBarraSuperior.setLayout(null);
		panelBarraSuperior.setBackground(new Color(255, 189, 89));
		panelBarraSuperior.setBounds(0, 0, 900, 40);
		contentPane.add(panelBarraSuperior);
		
		JLabel lblTitulo = new JLabel("Libreria Distrital");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblTitulo.setBounds(375, 0, 158, 40);
		panelBarraSuperior.add(lblTitulo);
		
		btnCerrar = new JButton("");
		btnCerrar.setBounds(0, 0, 40, 40);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setActionCommand("CERRAR");
		panelBarraSuperior.add(btnCerrar);
		
		JLabel lblImagenCerrar = new JLabel("");
		lblImagenCerrar.setIcon(new ImageIcon(VentanaElegirDoc.class.getResource("/imagenes/cerrar.png")));
		lblImagenCerrar.setBounds(0, 0, 40, 40);
		panelBarraSuperior.add(lblImagenCerrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setOpaque(false);
		btnVolver.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBounds(790, 0, 90, 40);
		btnVolver.setActionCommand("VOLVER2");
		panelBarraSuperior.add(btnVolver);
		
		btnLibro = new JButton("Libro");
		btnLibro.setOpaque(false);
		btnLibro.setHorizontalAlignment(SwingConstants.CENTER);
		btnLibro.setForeground(Color.WHITE);
		btnLibro.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnLibro.setContentAreaFilled(false);
		btnLibro.setBorderPainted(false);
		btnLibro.setBounds(388, 252, 125, 40);
		btnLibro.setActionCommand("LIBRO");
		contentPane.add(btnLibro);
		
		btnPonencia = new JButton("Ponencia");
		btnPonencia.setOpaque(false);
		btnPonencia.setHorizontalAlignment(SwingConstants.CENTER);
		btnPonencia.setForeground(Color.WHITE);
		btnPonencia.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnPonencia.setContentAreaFilled(false);
		btnPonencia.setBorderPainted(false);
		btnPonencia.setBounds(388, 309, 125, 40);
		btnPonencia.setActionCommand("PONENCIA");
		contentPane.add(btnPonencia);
		
		btnArticulo = new JButton("Articulo");
		btnArticulo.setOpaque(false);
		btnArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		btnArticulo.setForeground(Color.WHITE);
		btnArticulo.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnArticulo.setContentAreaFilled(false);
		btnArticulo.setBorderPainted(false);
		btnArticulo.setBounds(388, 365, 125, 40);
		btnArticulo.setActionCommand("ARTICULO");
		contentPane.add(btnArticulo);
		
		JLabel lblLibro = new JLabel("");
		lblLibro.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/boton.png")));
		lblLibro.setBounds(388, 252, 125, 40);
		contentPane.add(lblLibro);
		
		JLabel lblPonencia = new JLabel("");
		lblPonencia.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/boton.png")));
		lblPonencia.setBounds(388, 309, 125, 40);
		contentPane.add(lblPonencia);

		JLabel lblArticulo = new JLabel("");
		lblArticulo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/boton.png")));
		lblArticulo.setBounds(388, 365, 125, 40);
		contentPane.add(lblArticulo);
		
		JLabel lblTxtElegir = new JLabel("Elija el tipo de documento");
		lblTxtElegir.setFont(new Font("Roboto ExtraBold", Font.PLAIN, 13));
		lblTxtElegir.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtElegir.setBounds(374, 186, 150, 51);
		contentPane.add(lblTxtElegir);
		
		JLabel lblFondoElegir = new JLabel("");
		lblFondoElegir.setIcon(new ImageIcon(VentanaElegirDoc.class.getResource("/imagenes/fondo_elegir_doc.png")));
		lblFondoElegir.setBounds(337, 170, 225, 260);
		contentPane.add(lblFondoElegir);
	}

	
	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnLibro() {
		return btnLibro;
	}

	public void setBtnLibro(JButton btnLibro) {
		this.btnLibro = btnLibro;
	}

	public JButton getBtnPonencia() {
		return btnPonencia;
	}

	public void setBtnPonencia(JButton btnPonencia) {
		this.btnPonencia = btnPonencia;
	}

	public JButton getBtnArticulo() {
		return btnArticulo;
	}

	public void setBtnArticulo(JButton btnArticulo) {
		this.btnArticulo = btnArticulo;
	}
	
	
}