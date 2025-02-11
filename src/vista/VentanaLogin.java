package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private JTextField txtIdentificacionLector;
	private JTextField txtIdentificacionAutor;
	private JPasswordField passwordLector;
	private JPasswordField passwordAutor;
	private JButton btnIngresarAutor;
	private JButton btnIngresarLector;
	private JButton btnRegister;
	private JButton btnCerrar;
	private JPanel contentPane;

	public VentanaLogin() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		inicializarComponentes();
		setVisible(true);
	}

	public void inicializarComponentes() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelBarraSuperior = new JPanel();
		panelBarraSuperior.setBounds(0, 0, 900, 40);
		panelBarraSuperior.setBackground(new Color(255, 189, 89));
		contentPane.add(panelBarraSuperior);
		panelBarraSuperior.setLayout(null);

		JLabel lblTitulo = new JLabel("Libreria Distrital");
		lblTitulo.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblImagenCerrar.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/cerrar.png")));
		lblImagenCerrar.setBounds(0, 0, 40, 40);
		panelBarraSuperior.add(lblImagenCerrar);

		btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnRegister.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBounds(750, 0, 120, 40);
		btnRegister.setOpaque(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setActionCommand("REGISTER");
		panelBarraSuperior.add(btnRegister);

		JLabel lblUsuarioAutor = new JLabel("Identificación");
		lblUsuarioAutor.setForeground(Color.GRAY);
		lblUsuarioAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuarioAutor.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblUsuarioAutor.setBounds(378, 329, 107, 40);
		contentPane.add(lblUsuarioAutor);

		JLabel lblContrasenaAutor = new JLabel("Contraseña");
		lblContrasenaAutor.setForeground(Color.GRAY);
		lblContrasenaAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenaAutor.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblContrasenaAutor.setBounds(397, 385, 88, 40);
		contentPane.add(lblContrasenaAutor);

		JLabel lblUsuarioLector = new JLabel("Identificación");
		lblUsuarioLector.setForeground(Color.GRAY);
		lblUsuarioLector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuarioLector.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblUsuarioLector.setBounds(378, 112, 107, 40);
		contentPane.add(lblUsuarioLector);

		JLabel lblContrasenaLector = new JLabel("Contraseña");
		lblContrasenaLector.setForeground(Color.GRAY);
		lblContrasenaLector.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenaLector.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblContrasenaLector.setBounds(397, 167, 88, 40);
		contentPane.add(lblContrasenaLector);

		btnIngresarAutor = new JButton("Ingresar");
		btnIngresarAutor.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnIngresarAutor.setOpaque(false);
		btnIngresarAutor.setContentAreaFilled(false);
		btnIngresarAutor.setForeground(Color.WHITE);
		btnIngresarAutor.setBorder(null);
		btnIngresarAutor.setBorderPainted(false);
		btnIngresarAutor.setBounds(459, 449, 125, 40);
		btnIngresarAutor.setActionCommand("INGRESAR_AUTOR");
		contentPane.add(btnIngresarAutor);

		btnIngresarLector = new JButton("Ingresar");
		btnIngresarLector.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnIngresarLector.setForeground(Color.WHITE);
		btnIngresarLector.setBounds(459, 231, 125, 40);
		btnIngresarLector.setOpaque(false);
		btnIngresarLector.setContentAreaFilled(false);
		btnIngresarLector.setBorderPainted(false);
		btnIngresarLector.setBorder(null);
		btnIngresarLector.setActionCommand("INGRESAR_LECTOR");
		contentPane.add(btnIngresarLector);

		JLabel lblIngresarAutor = new JLabel("");
		lblIngresarAutor.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/boton.png")));
		lblIngresarAutor.setBounds(459, 449, 125, 40);
		contentPane.add(lblIngresarAutor);

		JLabel lblIngresarLector = new JLabel("");
		lblIngresarLector.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/boton.png")));
		lblIngresarLector.setBounds(459, 231, 125, 40);
		contentPane.add(lblIngresarLector);

		passwordLector = new JPasswordField();
		passwordLector.setBounds(513, 167, 128, 40);
		passwordLector.setOpaque(false);
		passwordLector.setBorder(null);
		contentPane.add(passwordLector);

		passwordAutor = new JPasswordField();
		passwordAutor.setOpaque(false);
		passwordAutor.setBorder(null);
		passwordAutor.setBounds(513, 385, 128, 40);
		contentPane.add(passwordAutor);

		txtIdentificacionAutor = new JTextField();
		txtIdentificacionAutor.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtIdentificacionAutor.setOpaque(false);
		txtIdentificacionAutor.setForeground(Color.BLACK);
		txtIdentificacionAutor.setBorder(null);
		txtIdentificacionAutor.setBounds(513, 329, 128, 40);
		contentPane.add(txtIdentificacionAutor);

		txtIdentificacionLector = new JTextField();
		txtIdentificacionLector.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtIdentificacionLector.setForeground(Color.BLACK);
		txtIdentificacionLector.setOpaque(false);
		txtIdentificacionLector.setBounds(513, 112, 128, 40);
		txtIdentificacionLector.setBorder(null);
		contentPane.add(txtIdentificacionLector);

		JLabel lblBordeContraAutor = new JLabel("");
		lblBordeContraAutor.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/borde_texto.png")));
		lblBordeContraAutor.setBounds(495, 385, 146, 40);
		contentPane.add(lblBordeContraAutor);

		JLabel lblBordeIdentificacionAutor = new JLabel("");
		lblBordeIdentificacionAutor.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/borde_texto.png")));
		lblBordeIdentificacionAutor.setBounds(495, 329, 146, 40);
		contentPane.add(lblBordeIdentificacionAutor);

		JLabel lblBordeIdentificacionLector = new JLabel("");
		lblBordeIdentificacionLector
				.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/borde_texto.png")));
		lblBordeIdentificacionLector.setBounds(495, 112, 146, 40);
		contentPane.add(lblBordeIdentificacionLector);

		JLabel lblBordeContraLector = new JLabel("");
		lblBordeContraLector.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/borde_texto.png")));
		lblBordeContraLector.setBounds(495, 167, 146, 40);
		contentPane.add(lblBordeContraLector);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setForeground(new Color(0, 0, 0));
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setFont(new Font("Roboto ExtraBold", Font.BOLD, 20));
		lblAutor.setBounds(260, 329, 95, 40);
		contentPane.add(lblAutor);

		JLabel lblLector = new JLabel("Lector");
		lblLector.setForeground(new Color(0, 0, 0));
		lblLector.setHorizontalAlignment(SwingConstants.CENTER);
		lblLector.setFont(new Font("Roboto ExtraBold", Font.BOLD, 20));
		lblLector.setBounds(260, 111, 95, 40);
		contentPane.add(lblLector);

		JLabel lblIconoAutor = new JLabel("");
		lblIconoAutor.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/autor.png")));
		lblIconoAutor.setBounds(255, 369, 107, 90);
		contentPane.add(lblIconoAutor);

		JLabel lblIconoLector = new JLabel("");
		lblIconoLector.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/lector.png")));
		lblIconoLector.setBounds(258, 155, 99, 95);
		contentPane.add(lblIconoLector);

		JLabel lblFondoLogin = new JLabel("");
		lblFondoLogin.setBounds(183, 85, 533, 430);
		lblFondoLogin.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/fondo_login.png")));
		contentPane.add(lblFondoLogin);
	}

	public void clear(){
		txtIdentificacionLector.setText("");
		txtIdentificacionAutor.setText("");
		passwordLector.setText("");
		passwordAutor.setText("");
	}
	
	
	public boolean verifyAutor() {
		String password = new String(passwordAutor.getPassword()).trim();
		if (txtIdentificacionAutor.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de usuario", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de contraseña", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean verifyLector() {
		String password = new String(passwordLector.getPassword()).trim();
		if (txtIdentificacionLector.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de usuario", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de contraseña", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void avisoError() {
		JOptionPane.showMessageDialog(this, "No existe alguien en la base de datos con esa identificación.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void avisoError2() {
		JOptionPane.showMessageDialog(this, "Contraseña incorrecta, digitela de nuevo.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void avisoExito() {
		JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}

	public JButton getBtnIngresarAutor() {
		return btnIngresarAutor;
	}

	public void setBtnIngresarAutor(JButton btnIngresarAutor) {
		this.btnIngresarAutor = btnIngresarAutor;
	}

	public JButton getBtnIngresarLector() {
		return btnIngresarLector;
	}

	public void setBtnIngresarLector(JButton btnIngresarLector) {
		this.btnIngresarLector = btnIngresarLector;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JTextField getTxtUsuarioLector() {
		return txtIdentificacionLector;
	}

	public void setTxtUsuarioLector(JTextField txtUsuarioLector) {
		this.txtIdentificacionLector = txtUsuarioLector;
	}

	public JTextField getTxtUsuarioAutor() {
		return txtIdentificacionAutor;
	}

	public void setTxtUsuarioAutor(JTextField txtUsuarioAutor) {
		this.txtIdentificacionAutor = txtUsuarioAutor;
	}

	public JPasswordField getPasswordLector() {
		return passwordLector;
	}

	public void setPasswordLector(JPasswordField passwordLector) {
		this.passwordLector = passwordLector;
	}

	public JPasswordField getPasswordAutor() {
		return passwordAutor;
	}

	public void setPasswordAutor(JPasswordField passwordAutor) {
		this.passwordAutor = passwordAutor;
	}

}