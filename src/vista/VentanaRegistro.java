package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	private JButton btnCerrar;
	private JButton btnVolver;
	private JButton btnRegistrarse;
	private JTextField txtUsuario;
	private JPasswordField passwordRegistro;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JRadioButton rdBtnAutor;
	private JRadioButton rdBtnLector;
	private JPanel contentPane;

	public VentanaRegistro() {
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
		panelBarraSuperior.setBounds(0, 0, 900, 40);
		panelBarraSuperior.setLayout(null);
		panelBarraSuperior.setBackground(new Color(255, 189, 89));
		contentPane.add(panelBarraSuperior);
		
		JLabel lblTitulo = new JLabel("Libreria Distrital");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblTitulo.setBounds(375, 0, 158, 40);
		panelBarraSuperior.add(lblTitulo);
		
		btnCerrar = new JButton("");
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(0, 0, 40, 40);
		btnCerrar.setActionCommand("CERRAR");
		panelBarraSuperior.add(btnCerrar);
		
		JLabel lblImagenCerrar = new JLabel("");
		lblImagenCerrar.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/cerrar.png")));
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
		btnVolver.setActionCommand("VOLVER1");
		panelBarraSuperior.add(btnVolver);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setBounds(387, 451, 125, 40);
		btnRegistrarse.setActionCommand("REGISTRARSE");
		contentPane.add(btnRegistrarse);
		
		passwordRegistro = new JPasswordField();
		passwordRegistro.setOpaque(false);
		passwordRegistro.setBorder(null);
		passwordRegistro.setBounds(441, 226, 128, 40);
		contentPane.add(passwordRegistro);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDireccion.setBorder(null);
		txtDireccion.setBounds(441, 394, 128, 40);
		contentPane.add(txtDireccion);
		
		txtCorreo = new JTextField();
		txtCorreo.setOpaque(false);
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(441, 338, 128, 40);
		contentPane.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(441, 282, 128, 40);
		contentPane.add(txtTelefono);
		
		txtUsuario = new JTextField();
		txtUsuario.setOpaque(false);
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(441, 172, 128, 40);
		contentPane.add(txtUsuario);
		
		rdBtnAutor = new JRadioButton("Autor");
		rdBtnAutor.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtnAutor.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		rdBtnAutor.setBounds(407, 135, 88, 23);
		rdBtnAutor.setOpaque(false);
		rdBtnAutor.setActionCommand("REG_AUTOR");
		contentPane.add(rdBtnAutor);
		
		rdBtnLector = new JRadioButton("Lector");
		rdBtnLector.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtnLector.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		rdBtnLector.setBounds(407, 109, 88, 23);
		rdBtnLector.setOpaque(false);
		rdBtnLector.setActionCommand("REG_LECTOR");
		contentPane.add(rdBtnLector);
		
		ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rdBtnAutor);
        grupo1.add(rdBtnLector);
		
		JLabel lblRegistrarse = new JLabel("");
		lblRegistrarse.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/boton.png")));
		lblRegistrarse.setBounds(388, 451, 124, 40);
		contentPane.add(lblRegistrarse);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblDireccion.setBounds(325, 394, 88, 40);
		contentPane.add(lblDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblCorreo.setBounds(325, 338, 88, 40);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblTelefono.setBounds(325, 282, 88, 40);
		contentPane.add(lblTelefono);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblContrasena.setBounds(325, 226, 88, 40);
		contentPane.add(lblContrasena);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblUsuario.setBounds(325, 171, 88, 40);
		contentPane.add(lblUsuario);
		
		JLabel lblBordeDireccion = new JLabel("");
		lblBordeDireccion.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/borde_texto.png")));
		lblBordeDireccion.setBounds(423, 394, 146, 40);
		contentPane.add(lblBordeDireccion);
		
		JLabel lblBordeCorreo = new JLabel("");
		lblBordeCorreo.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/borde_texto.png")));
		lblBordeCorreo.setBounds(423, 338, 146, 40);
		contentPane.add(lblBordeCorreo);
		
		JLabel lblBordeTelefono = new JLabel("");
		lblBordeTelefono.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/borde_texto.png")));
		lblBordeTelefono.setBounds(423, 282, 146, 40);
		contentPane.add(lblBordeTelefono);
		
		JLabel lblBordeContrasena = new JLabel("");
		lblBordeContrasena.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/borde_texto.png")));
		lblBordeContrasena.setBounds(423, 226, 146, 40);
		contentPane.add(lblBordeContrasena);
		
		JLabel lblBordeUsuario = new JLabel("");
		lblBordeUsuario.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/borde_texto.png")));
		lblBordeUsuario.setBounds(423, 171, 146, 40);
		contentPane.add(lblBordeUsuario);
		
		JLabel lblFondoRegistro = new JLabel("");
		lblFondoRegistro.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/fondo_registro.png")));
		lblFondoRegistro.setBounds(285, 87, 330, 430);
		contentPane.add(lblFondoRegistro);
	}

	public boolean verify() {
		String password = new String(passwordRegistro.getPassword()).trim();
		if(txtUsuario.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de usuario"
					, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		
		if(txtTelefono.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de teléfono"
					, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(txtCorreo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de correo"
					, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(txtDireccion.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de dirección"
					, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de contraseña"
            		, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
        }
		
		if (!rdBtnAutor.isSelected() && !rdBtnLector.isSelected()) {
			JOptionPane.showMessageDialog(this, "Hace falta elegir autor o lector"
            		, "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		JOptionPane.showMessageDialog(this, "Registro exitoso"
				, "Éxito", JOptionPane.INFORMATION_MESSAGE);
		return true;
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

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	public JRadioButton getRdBtnAutor() {
		return rdBtnAutor;
	}

	public void setRdBtnAutor(JRadioButton rdBtnAutor) {
		this.rdBtnAutor = rdBtnAutor;
	}

	public JRadioButton getRdBtnLector() {
		return rdBtnLector;
	}

	public void setRdBtnLector(JRadioButton rdBtnLector) {
		this.rdBtnLector = rdBtnLector;
	}
	
}
