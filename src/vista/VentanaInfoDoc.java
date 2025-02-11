package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class VentanaInfoDoc extends JFrame {

	private JButton btnCerrar;
	private JButton btnVolver;
	private JButton btnDarDeBaja;
	private JButton btnDarDeAlta;
	private JButton btnReservar;
	private JButton btnDevolver;
	private JTextField txtInfo1;
	private JTextField txtInfo2;
	private JTextField txtInfo3;
	private JTextField txtInfo4;
	private JTextField txtInfo5;
	private JTextField txtInfo6;
	private JTextField txtInfoTelefono;
	private JTextField txtInfoCorreo;
	private JTextField txtInfoDireccion;
	private JLabel lblModificar4;
	private JLabel lblModificar6;
	private JLabel lblBordeTxt6;
	private JPanel contentPane;

	public VentanaInfoDoc() {
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
		lblImagenCerrar.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/cerrar.png")));
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
		btnVolver.setActionCommand("VOLVER5");
		panelBarraSuperior.add(btnVolver);
		
		btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setOpaque(false);
		btnDarDeBaja.setHorizontalAlignment(SwingConstants.CENTER);
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnDarDeBaja.setContentAreaFilled(false);
		btnDarDeBaja.setBorderPainted(false);
		btnDarDeBaja.setBounds(300, 513, 125, 40);
		btnDarDeBaja.setActionCommand("DARDEBAJA");
		contentPane.add(btnDarDeBaja);
		
		JLabel lblDarDeBaja = new JLabel("");
		lblDarDeBaja.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/boton.png")));
		lblDarDeBaja.setBounds(300, 513, 125, 40);
		contentPane.add(lblDarDeBaja);
		
		btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setOpaque(false);
		btnDarDeAlta.setHorizontalAlignment(SwingConstants.CENTER);
		btnDarDeAlta.setForeground(Color.WHITE);
		btnDarDeAlta.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnDarDeAlta.setContentAreaFilled(false);
		btnDarDeAlta.setBorderPainted(false);
		btnDarDeAlta.setBounds(425, 513, 125, 40);
		btnDarDeAlta.setActionCommand("DARDEALTA");
		contentPane.add(btnDarDeAlta);
		
		JLabel btnDarDeAlta = new JLabel("");
		btnDarDeAlta.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/boton.png")));
		btnDarDeAlta.setBounds(425, 513, 125, 40);
		contentPane.add(btnDarDeAlta);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setOpaque(false);
		btnReservar.setHorizontalAlignment(SwingConstants.CENTER);
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnReservar.setContentAreaFilled(false);
		btnReservar.setBorderPainted(false);
		btnReservar.setBounds(300, 473, 125, 40);
		btnReservar.setActionCommand("RESERVAR");
		contentPane.add(btnReservar);
		
		JLabel lblReservar = new JLabel("");
		lblReservar.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/boton.png")));
		lblReservar.setBounds(300, 473, 125, 40);
		contentPane.add(lblReservar);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.setOpaque(false);
		btnDevolver.setHorizontalAlignment(SwingConstants.CENTER);
		btnDevolver.setForeground(Color.WHITE);
		btnDevolver.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnDevolver.setContentAreaFilled(false);
		btnDevolver.setBorderPainted(false);
		btnDevolver.setBounds(425, 473, 125, 40);
		btnDevolver.setActionCommand("DEVOLVER");
		contentPane.add(btnDevolver);
		
		JLabel btnDevolver = new JLabel("");
		btnDevolver.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/boton.png")));
		btnDevolver.setBounds(425, 473, 125, 40);
		contentPane.add(btnDevolver);
		
		JLabel lblModificar1 = new JLabel("Título");
		lblModificar1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar1.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar1.setBounds(60, 99, 179, 40);
		contentPane.add(lblModificar1);
		
		JLabel lblModificar2 = new JLabel("Fecha de publicación");
		lblModificar2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar2.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar2.setBounds(60, 158, 179, 40);
		contentPane.add(lblModificar2);
		
		JLabel lblModificar3 = new JLabel("Autor");
		lblModificar3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar3.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar3.setBounds(60, 217, 179, 40);
		contentPane.add(lblModificar3);
		
		lblModificar4 = new JLabel("");
		lblModificar4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar4.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar4.setBounds(60, 276, 179, 40);
		contentPane.add(lblModificar4);
		
		JLabel lblModificar5 = new JLabel("Editorial");
		lblModificar5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar5.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar5.setBounds(60, 335, 179, 40);
		contentPane.add(lblModificar5);
		
		lblModificar6 = new JLabel("");
		lblModificar6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar6.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblModificar6.setBounds(60, 394, 179, 40);
		contentPane.add(lblModificar6);
		
		txtInfo1 = new JTextField();
		txtInfo1.setEditable(false);
		txtInfo1.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo1.setForeground(Color.BLACK);
		txtInfo1.setOpaque(false);
		txtInfo1.setBorder(null);
		txtInfo1.setBounds(278, 99, 253, 40);
		contentPane.add(txtInfo1);
		
		txtInfo2 = new JTextField();
		txtInfo2.setEditable(false);
		txtInfo2.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo2.setForeground(Color.BLACK);
		txtInfo2.setOpaque(false);
		txtInfo2.setBorder(null);
		txtInfo2.setBounds(278, 158, 253, 40);
		contentPane.add(txtInfo2);
		
		txtInfo3 = new JTextField();
		txtInfo3.setEditable(false);
		txtInfo3.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo3.setForeground(Color.BLACK);
		txtInfo3.setOpaque(false);
		txtInfo3.setBorder(null);
		txtInfo3.setBounds(278, 217, 253, 40);
		contentPane.add(txtInfo3);
		
		txtInfo4 = new JTextField();
		txtInfo4.setEditable(false);
		txtInfo4.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo4.setForeground(Color.BLACK);
		txtInfo4.setOpaque(false);
		txtInfo4.setBorder(null);
		txtInfo4.setBounds(278, 276, 253, 40);
		contentPane.add(txtInfo4);
		
		txtInfo5 = new JTextField();
		txtInfo5.setEditable(false);
		txtInfo5.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo5.setForeground(Color.BLACK);
		txtInfo5.setOpaque(false);
		txtInfo5.setBorder(null);
		txtInfo5.setBounds(278, 335, 253, 40);
		contentPane.add(txtInfo5);

		txtInfo6 = new JTextField();
		txtInfo6.setEditable(false);
		txtInfo6.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtInfo6.setForeground(Color.BLACK);
		txtInfo6.setOpaque(false);
		txtInfo6.setBorder(null);
		txtInfo6.setBounds(278, 394, 253, 40);
		contentPane.add(txtInfo6);
		
		JLabel lblBordeTxt1 = new JLabel("");
		lblBordeTxt1.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt1.setBounds(261, 99, 270, 40);
		contentPane.add(lblBordeTxt1);
		
		JLabel lblBordeTxt2 = new JLabel("");
		lblBordeTxt2.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt2.setBounds(261, 158, 270, 40);
		contentPane.add(lblBordeTxt2);
		
		JLabel lblBordeTxt3 = new JLabel("");
		lblBordeTxt3.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt3.setBounds(261, 217, 270, 40);
		contentPane.add(lblBordeTxt3);
		
		JLabel lblBordeTxt4 = new JLabel("");
		lblBordeTxt4.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt4.setBounds(261, 276, 270, 40);
		contentPane.add(lblBordeTxt4);
		
		JLabel lblBordeTxt5 = new JLabel("");
		lblBordeTxt5.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt5.setBounds(261, 335, 270, 40);
		contentPane.add(lblBordeTxt5);
		
		lblBordeTxt6 = new JLabel("");
		lblBordeTxt6.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt6.setBounds(261, 394, 270, 40);
		contentPane.add(lblBordeTxt6);
		
		JLabel lblFondoInfoDoc = new JLabel("");
		lblFondoInfoDoc.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/fondo_info_doc.png")));
		lblFondoInfoDoc.setBounds(60, 74, 490, 385);
		contentPane.add(lblFondoInfoDoc);
		
		txtInfoTelefono = new JTextField();
		txtInfoTelefono.setEditable(false);
		txtInfoTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		txtInfoTelefono.setForeground(Color.BLACK);
		txtInfoTelefono.setOpaque(false);
		txtInfoTelefono.setBorder(null);
		txtInfoTelefono.setBounds(593, 114, 226, 20);
		contentPane.add(txtInfoTelefono);
		
		txtInfoCorreo = new JTextField();
		txtInfoCorreo.setEditable(false);
		txtInfoCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		txtInfoCorreo.setForeground(Color.BLACK);
		txtInfoCorreo.setOpaque(false);
		txtInfoCorreo.setBorder(null);
		txtInfoCorreo.setBounds(593, 136, 226, 20);
		contentPane.add(txtInfoCorreo);
		
		txtInfoDireccion = new JTextField();
		txtInfoDireccion.setEditable(false);
		txtInfoDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		txtInfoDireccion.setForeground(Color.BLACK);
		txtInfoDireccion.setOpaque(false);
		txtInfoDireccion.setBorder(null);
		txtInfoDireccion.setBounds(593, 158, 226, 20);
		contentPane.add(txtInfoDireccion);
		
		JLabel lblNewLabel = new JLabel("Informacion de contacto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto ExtraBold", Font.PLAIN, 16));
		lblNewLabel.setBounds(571, 86, 269, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblFondoInfoContacto = new JLabel("");
		lblFondoInfoContacto.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/fondo_contacto.png")));
		lblFondoInfoContacto.setBounds(571, 74, 269, 114);
		contentPane.add(lblFondoInfoContacto);
		
		JTextPane txtModificaciones = new JTextPane();
		txtModificaciones.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		txtModificaciones.setEditable(false);
		txtModificaciones.setBounds(587, 223, 234, 220);
		contentPane.add(txtModificaciones);
		
		JLabel lblFondoModificaciones = new JLabel("");
		lblFondoModificaciones.setIcon(new ImageIcon(VentanaInfoDoc.class.getResource("/imagenes/fondo_modificaciones.png")));
		lblFondoModificaciones.setBounds(571, 207, 269, 253);
		contentPane.add(lblFondoModificaciones);
	}

	public void clear(){
		txtInfo1.setText("");
		txtInfo2.setText("");
		txtInfo3.setText("");
		txtInfo4.setText("");
		txtInfo5.setText("");
		txtInfo6.setText("");
		txtInfoTelefono.setText("");
		txtInfoCorreo.setText("");
		txtInfoDireccion.setText("");
	}
	
	public JButton getBtnDevolver() {
		return btnDevolver;
	}

	public void setBtnDevolver(JButton btnDevolver) {
		this.btnDevolver = btnDevolver;
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

	public JButton getBtnReservar() {
		return btnReservar;
	}

	public void setBtnReservar(JButton btnReservar) {
		this.btnReservar = btnReservar;
	}
	
	public JButton getBtnDarDeBaja() {
		return btnDarDeBaja;
	}

	public void setBtnDarDeBaja(JButton btnDarDeBaja) {
		this.btnDarDeBaja = btnDarDeBaja;
	}
		
	public JButton getBtnDarDeAlta() {
		return btnDarDeAlta;
	}

	public void setBtnDarDeAlta(JButton btnDarDeAlta) {
		this.btnDarDeAlta = btnDarDeAlta;
	}

	public JTextField getTxtInfo1() {
		return txtInfo1;
	}

	public void setTxtInfo1(JTextField txtInfo1) {
		this.txtInfo1 = txtInfo1;
	}

	public JTextField getTxtInfo2() {
		return txtInfo2;
	}

	public void setTxtInfo2(JTextField txtInfo2) {
		this.txtInfo2 = txtInfo2;
	}

	public JTextField getTxtInfo3() {
		return txtInfo3;
	}

	public void setTxtInfo3(JTextField txtInfo3) {
		this.txtInfo3 = txtInfo3;
	}

	public JTextField getTxtInfo4() {
		return txtInfo4;
	}

	public void setTxtInfo4(JTextField txtInfo4) {
		this.txtInfo4 = txtInfo4;
	}

	public JTextField getTxtInfo5() {
		return txtInfo5;
	}

	public void setTxtInfo5(JTextField txtInfo5) {
		this.txtInfo5 = txtInfo5;
	}

	public JTextField getTxtInfo6() {
		return txtInfo6;
	}

	public void setTxtInfo6(JTextField txtInfo6) {
		this.txtInfo6 = txtInfo6;
	}

	public JTextField getTxtInfoTelefono() {
		return txtInfoTelefono;
	}

	public void setTxtInfoTelefono(JTextField txtInfoTelefono) {
		this.txtInfoTelefono = txtInfoTelefono;
	}

	public JTextField getTextInfoCorreo() {
		return txtInfoCorreo;
	}

	public void setTextInfoCorreo(JTextField textInfoCorreo) {
		this.txtInfoCorreo = textInfoCorreo;
	}

	public JTextField getTextInfoDireccion() {
		return txtInfoDireccion;
	}

	public void setTextInfoDireccion(JTextField textInfoDireccion) {
		this.txtInfoDireccion = textInfoDireccion;
	}
}