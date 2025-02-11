package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class VentanaBiblioteca extends JFrame {

	private JButton btnCerrar;
	private JButton btnSubirDoc;

	private JTextField txtDoc1;
	private JTextField txtDoc2;
	private JTextField txtDoc3;
	private JTextField txtDoc4;
	private JTextField txtDoc5;
	private JTextField txtDoc6;
	private JTextField txtDoc7;
	private JTextField txtDoc8;
	private JTextField txtDoc9;

	private JLabel lblModificarDoc1;
	private JLabel lblModificarDoc2;
	private JLabel lblModificarDoc3;
	private JLabel lblModificarDoc4;
	private JLabel lblModificarDoc5;
	private JLabel lblModificarDoc6;
	private JLabel lblModificarDoc7;
	private JLabel lblModificarDoc8;
	private JLabel lblModificarDoc9;

	private JButton btnInfoDoc1;
	private JButton btnInfoDoc2;
	private JButton btnInfoDoc3;
	private JButton btnInfoDoc4;
	private JButton btnInfoDoc5;
	private JButton btnInfoDoc6;
	private JButton btnInfoDoc7;
	private JButton btnInfoDoc8;
	private JButton btnInfoDoc9;

	private JButton btnModificarDoc1;
	private JButton btnModificarDoc2;
	private JButton btnModificarDoc3;
	private JButton btnModificarDoc4;
	private JButton btnModificarDoc5;
	private JButton btnModificarDoc6;
	private JButton btnModificarDoc7;
	private JButton btnModificarDoc8;
	private JButton btnModificarDoc9;

	private int mouseX, mouseY;

	private JTextField[] campos;

	private JPanel contentPane;

	public VentanaBiblioteca() {
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

		// Metodos para que la ventana se pueda mover
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

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
		lblImagenCerrar.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/cerrar.png")));
		lblImagenCerrar.setBounds(0, 0, 40, 40);
		panelBarraSuperior.add(lblImagenCerrar);

		btnSubirDoc = new JButton("Subir documento");
		btnSubirDoc.setOpaque(false);
		btnSubirDoc.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSubirDoc.setForeground(Color.WHITE);
		btnSubirDoc.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnSubirDoc.setContentAreaFilled(false);
		btnSubirDoc.setBorderPainted(false);
		btnSubirDoc.setBounds(742, 0, 158, 40);
		btnSubirDoc.setActionCommand("SUBIR_DOCUMENTO");
		panelBarraSuperior.add(btnSubirDoc);

		btnInfoDoc1 = new JButton("");
		btnInfoDoc1.setBounds(225, 70, 450, 40);
		btnInfoDoc1.setOpaque(false);
		btnInfoDoc1.setBorder(null);
		btnInfoDoc1.setContentAreaFilled(false);
		btnInfoDoc1.setActionCommand("INFO_DOC1");
		contentPane.add(btnInfoDoc1);

		btnInfoDoc2 = new JButton("");
		btnInfoDoc2.setBounds(225, 128, 450, 40);
		btnInfoDoc2.setOpaque(false);
		btnInfoDoc2.setBorder(null);
		btnInfoDoc2.setContentAreaFilled(false);
		btnInfoDoc2.setActionCommand("INFO_DOC2");
		contentPane.add(btnInfoDoc2);

		btnInfoDoc3 = new JButton("");
		btnInfoDoc3.setBounds(225, 184, 450, 40);
		btnInfoDoc3.setOpaque(false);
		btnInfoDoc3.setBorder(null);
		btnInfoDoc3.setContentAreaFilled(false);
		btnInfoDoc3.setActionCommand("INFO_DOC3");
		contentPane.add(btnInfoDoc3);

		btnInfoDoc4 = new JButton("");
		btnInfoDoc4.setBounds(225, 240, 450, 40);
		btnInfoDoc4.setOpaque(false);
		btnInfoDoc4.setBorder(null);
		btnInfoDoc4.setContentAreaFilled(false);
		btnInfoDoc4.setActionCommand("INFO_DOC4");
		contentPane.add(btnInfoDoc4);

		btnInfoDoc5 = new JButton("");
		btnInfoDoc5.setBounds(225, 296, 450, 40);
		btnInfoDoc5.setOpaque(false);
		btnInfoDoc5.setBorder(null);
		btnInfoDoc5.setContentAreaFilled(false);
		btnInfoDoc5.setActionCommand("INFO_DOC5");
		contentPane.add(btnInfoDoc5);

		btnInfoDoc6 = new JButton("");
		btnInfoDoc6.setBounds(225, 353, 450, 40);
		btnInfoDoc6.setOpaque(false);
		btnInfoDoc6.setBorder(null);
		btnInfoDoc6.setContentAreaFilled(false);
		btnInfoDoc6.setActionCommand("INFO_DOC6");
		contentPane.add(btnInfoDoc6);

		btnInfoDoc7 = new JButton("");
		btnInfoDoc7.setBounds(225, 409, 450, 40);
		btnInfoDoc7.setOpaque(false);
		btnInfoDoc7.setBorder(null);
		btnInfoDoc7.setContentAreaFilled(false);
		btnInfoDoc7.setActionCommand("INFO_DOC7");
		contentPane.add(btnInfoDoc7);

		btnInfoDoc8 = new JButton("");
		btnInfoDoc8.setBounds(225, 465, 450, 40);
		btnInfoDoc8.setOpaque(false);
		btnInfoDoc8.setBorder(null);
		btnInfoDoc8.setContentAreaFilled(false);
		btnInfoDoc8.setActionCommand("INFO_DOC8");
		contentPane.add(btnInfoDoc8);

		btnInfoDoc9 = new JButton("");
		btnInfoDoc9.setBounds(225, 521, 450, 40);
		btnInfoDoc9.setOpaque(false);
		btnInfoDoc9.setBorder(null);
		btnInfoDoc9.setContentAreaFilled(false);
		btnInfoDoc9.setActionCommand("INFO_DOC9");
		contentPane.add(btnInfoDoc9);

		txtDoc1 = new JTextField();
		txtDoc1.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc1.setEnabled(false);
		txtDoc1.setDisabledTextColor(Color.BLACK);
		txtDoc1.setOpaque(false);
		txtDoc1.setForeground(Color.BLACK);
		txtDoc1.setBorder(null);
		txtDoc1.setBounds(240, 70, 435, 40);
		contentPane.add(txtDoc1);

		txtDoc2 = new JTextField();
		txtDoc2.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc2.setEnabled(false);
		txtDoc2.setDisabledTextColor(Color.BLACK);
		txtDoc2.setOpaque(false);
		txtDoc2.setForeground(Color.BLACK);
		txtDoc2.setBorder(null);
		txtDoc2.setBounds(240, 128, 435, 40);
		contentPane.add(txtDoc2);

		txtDoc3 = new JTextField();
		txtDoc3.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc3.setEnabled(false);
		txtDoc3.setDisabledTextColor(Color.BLACK);
		txtDoc3.setOpaque(false);
		txtDoc3.setForeground(Color.BLACK);
		txtDoc3.setBorder(null);
		txtDoc3.setBounds(240, 184, 435, 40);
		contentPane.add(txtDoc3);

		txtDoc4 = new JTextField();
		txtDoc4.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc4.setEnabled(false);
		txtDoc4.setDisabledTextColor(Color.BLACK);
		txtDoc4.setOpaque(false);
		txtDoc4.setForeground(Color.BLACK);
		txtDoc4.setBorder(null);
		txtDoc4.setBounds(240, 240, 435, 40);
		contentPane.add(txtDoc4);

		txtDoc5 = new JTextField();
		txtDoc5.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc5.setEnabled(false);
		txtDoc5.setDisabledTextColor(Color.BLACK);
		txtDoc5.setOpaque(false);
		txtDoc5.setForeground(Color.BLACK);
		txtDoc5.setBorder(null);
		txtDoc5.setBounds(240, 296, 435, 40);
		contentPane.add(txtDoc5);

		txtDoc6 = new JTextField();
		txtDoc6.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc6.setEnabled(false);
		txtDoc6.setDisabledTextColor(Color.BLACK);
		txtDoc6.setOpaque(false);
		txtDoc6.setForeground(Color.BLACK);
		txtDoc6.setBorder(null);
		txtDoc6.setBounds(240, 353, 435, 40);
		contentPane.add(txtDoc6);

		txtDoc7 = new JTextField();
		txtDoc7.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc7.setEnabled(false);
		txtDoc7.setDisabledTextColor(Color.BLACK);
		txtDoc7.setOpaque(false);
		txtDoc7.setForeground(Color.BLACK);
		txtDoc7.setBorder(null);
		txtDoc7.setBounds(240, 409, 435, 40);
		contentPane.add(txtDoc7);

		txtDoc8 = new JTextField();
		txtDoc8.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc8.setEnabled(false);
		txtDoc8.setDisabledTextColor(Color.BLACK);
		txtDoc8.setOpaque(false);
		txtDoc8.setForeground(Color.BLACK);
		txtDoc8.setBorder(null);
		txtDoc8.setBounds(240, 465, 435, 40);
		contentPane.add(txtDoc8);

		txtDoc9 = new JTextField();
		txtDoc9.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtDoc9.setEnabled(false);
		txtDoc9.setDisabledTextColor(Color.BLACK);
		txtDoc9.setOpaque(false);
		txtDoc9.setForeground(Color.BLACK);
		txtDoc9.setBorder(null);
		txtDoc9.setBounds(240, 521, 435, 40);
		contentPane.add(txtDoc9);

		campos = new JTextField[] { txtDoc1, txtDoc2, txtDoc3, txtDoc4, txtDoc5, txtDoc6, txtDoc7, txtDoc8, txtDoc9 };

		JLabel lblBordeDoc1 = new JLabel("");
		lblBordeDoc1.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc1.setBounds(225, 70, 450, 40);
		contentPane.add(lblBordeDoc1);

		JLabel lblBordeDoc2 = new JLabel("");
		lblBordeDoc2.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc2.setBounds(225, 128, 450, 40);
		contentPane.add(lblBordeDoc2);

		JLabel lblBordeDoc3 = new JLabel("");
		lblBordeDoc3.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc3.setBounds(225, 184, 450, 40);
		contentPane.add(lblBordeDoc3);

		JLabel lblBordeDoc4 = new JLabel("");
		lblBordeDoc4.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc4.setBounds(225, 240, 450, 40);
		contentPane.add(lblBordeDoc4);

		JLabel lblBordeDoc5 = new JLabel("");
		lblBordeDoc5.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc5.setBounds(225, 296, 450, 40);
		contentPane.add(lblBordeDoc5);

		JLabel lblBordeDoc6 = new JLabel("");
		lblBordeDoc6.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc6.setBounds(225, 353, 450, 40);
		contentPane.add(lblBordeDoc6);

		JLabel lblBordeDoc7 = new JLabel("");
		lblBordeDoc7.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc7.setBounds(225, 409, 450, 40);
		contentPane.add(lblBordeDoc7);

		JLabel lblBordeDoc8 = new JLabel("");
		lblBordeDoc8.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc8.setBounds(225, 465, 450, 40);
		contentPane.add(lblBordeDoc8);

		JLabel lblBordeDoc9 = new JLabel("");
		lblBordeDoc9.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/borde_libros.png")));
		lblBordeDoc9.setBounds(225, 521, 450, 40);
		contentPane.add(lblBordeDoc9);

		btnModificarDoc1 = new JButton("");
		btnModificarDoc1.setBounds(176, 70, 40, 40);
		btnModificarDoc1.setOpaque(false);
		btnModificarDoc1.setBorder(null);
		btnModificarDoc1.setContentAreaFilled(false);
		btnModificarDoc1.setActionCommand("MOD_LIBRO1");
		contentPane.add(btnModificarDoc1);

		btnModificarDoc2 = new JButton("");
		btnModificarDoc2.setBounds(176, 128, 40, 40);
		btnModificarDoc2.setOpaque(false);
		btnModificarDoc2.setBorder(null);
		btnModificarDoc2.setContentAreaFilled(false);
		btnModificarDoc2.setActionCommand("MOD_LIBRO2");
		contentPane.add(btnModificarDoc2);

		btnModificarDoc3 = new JButton("");
		btnModificarDoc3.setBounds(176, 184, 40, 40);
		btnModificarDoc3.setOpaque(false);
		btnModificarDoc3.setBorder(null);
		btnModificarDoc3.setContentAreaFilled(false);
		btnModificarDoc3.setActionCommand("MOD_LIBRO3");
		contentPane.add(btnModificarDoc3);

		btnModificarDoc4 = new JButton("");
		btnModificarDoc4.setBounds(176, 240, 40, 40);
		btnModificarDoc4.setOpaque(false);
		btnModificarDoc4.setBorder(null);
		btnModificarDoc4.setContentAreaFilled(false);
		btnModificarDoc4.setActionCommand("MOD_LIBRO4");
		contentPane.add(btnModificarDoc4);

		btnModificarDoc5 = new JButton("");
		btnModificarDoc5.setBounds(176, 296, 40, 40);
		btnModificarDoc5.setOpaque(false);
		btnModificarDoc5.setBorder(null);
		btnModificarDoc5.setContentAreaFilled(false);
		btnModificarDoc5.setActionCommand("MOD_LIBRO5");
		contentPane.add(btnModificarDoc5);

		btnModificarDoc6 = new JButton("");
		btnModificarDoc6.setBounds(176, 353, 40, 40);
		btnModificarDoc6.setOpaque(false);
		btnModificarDoc6.setBorder(null);
		btnModificarDoc6.setContentAreaFilled(false);
		btnModificarDoc6.setActionCommand("MOD_LIBRO6");
		contentPane.add(btnModificarDoc6);

		btnModificarDoc7 = new JButton("");
		btnModificarDoc7.setBounds(176, 409, 40, 40);
		btnModificarDoc7.setOpaque(false);
		btnModificarDoc7.setBorder(null);
		btnModificarDoc7.setContentAreaFilled(false);
		btnModificarDoc7.setActionCommand("MOD_LIBRO7");
		contentPane.add(btnModificarDoc7);

		btnModificarDoc8 = new JButton("");
		btnModificarDoc8.setBounds(176, 465, 40, 40);
		btnModificarDoc8.setOpaque(false);
		btnModificarDoc8.setBorder(null);
		btnModificarDoc8.setContentAreaFilled(false);
		btnModificarDoc8.setActionCommand("MOD_LIBRO8");
		contentPane.add(btnModificarDoc8);

		btnModificarDoc9 = new JButton("");
		btnModificarDoc9.setBounds(176, 521, 40, 40);
		btnModificarDoc9.setOpaque(false);
		btnModificarDoc9.setBorder(null);
		btnModificarDoc9.setContentAreaFilled(false);
		btnModificarDoc9.setActionCommand("MOD_LIBRO9");
		contentPane.add(btnModificarDoc9);

		lblModificarDoc1 = new JLabel("");
		lblModificarDoc1.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc1.setBounds(176, 70, 40, 40);
		contentPane.add(lblModificarDoc1);

		lblModificarDoc2 = new JLabel("");
		lblModificarDoc2.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc2.setBounds(176, 128, 40, 40);
		contentPane.add(lblModificarDoc2);

		lblModificarDoc3 = new JLabel("");
		lblModificarDoc3.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc3.setBounds(176, 184, 40, 40);
		contentPane.add(lblModificarDoc3);

		lblModificarDoc4 = new JLabel("");
		lblModificarDoc4.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc4.setBounds(176, 240, 40, 40);
		contentPane.add(lblModificarDoc4);

		lblModificarDoc5 = new JLabel("");
		lblModificarDoc5.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc5.setBounds(176, 296, 40, 40);
		contentPane.add(lblModificarDoc5);

		lblModificarDoc6 = new JLabel("");
		lblModificarDoc6.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc6.setBounds(176, 353, 40, 40);
		contentPane.add(lblModificarDoc6);

		lblModificarDoc7 = new JLabel("");
		lblModificarDoc7.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc7.setBounds(176, 409, 40, 40);
		contentPane.add(lblModificarDoc7);

		lblModificarDoc8 = new JLabel("");
		lblModificarDoc8.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc8.setBounds(176, 465, 40, 40);
		contentPane.add(lblModificarDoc8);

		lblModificarDoc9 = new JLabel("");
		lblModificarDoc9.setIcon(new ImageIcon(VentanaBiblioteca.class.getResource("/imagenes/modificar.png")));
		lblModificarDoc9.setBounds(176, 521, 40, 40);
		contentPane.add(lblModificarDoc9);
	}

	public void bloquearCampos() {
		if (txtDoc1.getText().equals("")) {
			btnInfoDoc1.setVisible(false);
			btnModificarDoc1.setVisible(false);
			lblModificarDoc1.setVisible(false);
		}
		if (txtDoc2.getText().equals("")) {
			btnInfoDoc2.setVisible(false);
			btnModificarDoc2.setVisible(false);
			lblModificarDoc2.setVisible(false);
		}
		if (txtDoc3.getText().equals("")) {
			btnInfoDoc3.setVisible(false);
			btnModificarDoc3.setVisible(false);
			lblModificarDoc3.setVisible(false);
		}
		if (txtDoc4.getText().equals("")) {
			btnInfoDoc4.setVisible(false);
			btnModificarDoc4.setVisible(false);
			lblModificarDoc4.setVisible(false);
		}
		if (txtDoc5.getText().equals("")) {
			btnInfoDoc5.setVisible(false);
			btnModificarDoc5.setVisible(false);
			lblModificarDoc5.setVisible(false);
		}
		if (txtDoc6.getText().equals("")) {
			btnInfoDoc6.setVisible(false);
			btnModificarDoc6.setVisible(false);
			lblModificarDoc6.setVisible(false);
		}
		if (txtDoc7.getText().equals("")) {
			btnInfoDoc7.setVisible(false);
			btnModificarDoc7.setVisible(false);
			lblModificarDoc7.setVisible(false);
		}
		if (txtDoc8.getText().equals("")) {
			btnInfoDoc8.setVisible(false);
			btnModificarDoc8.setVisible(false);
			lblModificarDoc8.setVisible(false);
		}
		if (txtDoc9.getText().equals("")) {
			btnInfoDoc9.setVisible(false);
			btnModificarDoc9.setVisible(false);
			lblModificarDoc9.setVisible(false);
		}
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnSubirDoc() {
		return btnSubirDoc;
	}

	public void setBtnSubirDoc(JButton btnSubirDoc) {
		this.btnSubirDoc = btnSubirDoc;
	}

	public JButton getBtnModificarDoc1() {
		return btnModificarDoc1;
	}

	public void setBtnModificarDoc1(JButton btnModificarDoc1) {
		this.btnModificarDoc1 = btnModificarDoc1;
	}

	public JButton getBtnModificarDoc2() {
		return btnModificarDoc2;
	}

	public void setBtnModificarDoc2(JButton btnModificarDoc2) {
		this.btnModificarDoc2 = btnModificarDoc2;
	}

	public JButton getBtnModificarDoc3() {
		return btnModificarDoc3;
	}

	public void setBtnModificarDoc3(JButton btnModificarDoc3) {
		this.btnModificarDoc3 = btnModificarDoc3;
	}

	public JButton getBtnModificarDoc4() {
		return btnModificarDoc4;
	}

	public void setBtnModificarDoc4(JButton btnModificarDoc4) {
		this.btnModificarDoc4 = btnModificarDoc4;
	}

	public JButton getBtnModificarDoc5() {
		return btnModificarDoc5;
	}

	public void setBtnModificarDoc5(JButton btnModificarDoc5) {
		this.btnModificarDoc5 = btnModificarDoc5;
	}

	public JButton getBtnModificarDoc6() {
		return btnModificarDoc6;
	}

	public void setBtnModificarDoc6(JButton btnModificarDoc6) {
		this.btnModificarDoc6 = btnModificarDoc6;
	}

	public JButton getBtnModificarDoc7() {
		return btnModificarDoc7;
	}

	public void setBtnModificarDoc7(JButton btnModificarDoc7) {
		this.btnModificarDoc7 = btnModificarDoc7;
	}

	public JButton getBtnModificarDoc8() {
		return btnModificarDoc8;
	}

	public void setBtnModificarDoc8(JButton btnModificarDoc8) {
		this.btnModificarDoc8 = btnModificarDoc8;
	}

	public JButton getBtnModificarDoc9() {
		return btnModificarDoc9;
	}

	public void setBtnModificarDoc9(JButton btnModificarDoc9) {
		this.btnModificarDoc9 = btnModificarDoc9;
	}

	public JButton getBtnInfoDoc1() {
		return btnInfoDoc1;
	}

	public void setBtnInfoDoc1(JButton btnInfoDoc1) {
		this.btnInfoDoc1 = btnInfoDoc1;
	}

	public JButton getBtnInfoDoc2() {
		return btnInfoDoc2;
	}

	public void setBtnInfoDoc2(JButton btnInfoDoc2) {
		this.btnInfoDoc2 = btnInfoDoc2;
	}

	public JButton getBtnInfoDoc3() {
		return btnInfoDoc3;
	}

	public void setBtnInfoDoc3(JButton btnInfoDoc3) {
		this.btnInfoDoc3 = btnInfoDoc3;
	}

	public JButton getBtnInfoDoc4() {
		return btnInfoDoc4;
	}

	public void setBtnInfoDoc4(JButton btnInfoDoc4) {
		this.btnInfoDoc4 = btnInfoDoc4;
	}

	public JButton getBtnInfoDoc5() {
		return btnInfoDoc5;
	}

	public void setBtnInfoDoc5(JButton btnInfoDoc5) {
		this.btnInfoDoc5 = btnInfoDoc5;
	}

	public JButton getBtnInfoDoc6() {
		return btnInfoDoc6;
	}

	public void setBtnInfoDoc6(JButton btnInfoDoc6) {
		this.btnInfoDoc6 = btnInfoDoc6;
	}

	public JButton getBtnInfoDoc7() {
		return btnInfoDoc7;
	}

	public void setBtnInfoDoc7(JButton btnInfoDoc7) {
		this.btnInfoDoc7 = btnInfoDoc7;
	}

	public JButton getBtnInfoDoc8() {
		return btnInfoDoc8;
	}

	public void setBtnInfoDoc8(JButton btnInfoDoc8) {
		this.btnInfoDoc8 = btnInfoDoc8;
	}

	public JButton getBtnInfoDoc9() {
		return btnInfoDoc9;
	}

	public void setBtnInfoDoc9(JButton btnInfoDoc9) {
		this.btnInfoDoc9 = btnInfoDoc9;
	}

	public JLabel getLblModificarDoc1() {
		return lblModificarDoc1;
	}

	public void setLblModificarDoc1(JLabel lblModificarDoc1) {
		this.lblModificarDoc1 = lblModificarDoc1;
	}

	public JLabel getLblModificarDoc2() {
		return lblModificarDoc2;
	}

	public void setLblModificarDoc2(JLabel lblModificarDoc2) {
		this.lblModificarDoc2 = lblModificarDoc2;
	}

	public JLabel getLblModificarDoc3() {
		return lblModificarDoc3;
	}

	public void setLblModificarDoc3(JLabel lblModificarDoc3) {
		this.lblModificarDoc3 = lblModificarDoc3;
	}

	public JLabel getLblModificarDoc4() {
		return lblModificarDoc4;
	}

	public void setLblModificarDoc4(JLabel lblModificarDoc4) {
		this.lblModificarDoc4 = lblModificarDoc4;
	}

	public JLabel getLblModificarDoc5() {
		return lblModificarDoc5;
	}

	public void setLblModificarDoc5(JLabel lblModificarDoc5) {
		this.lblModificarDoc5 = lblModificarDoc5;
	}

	public JLabel getLblModificarDoc6() {
		return lblModificarDoc6;
	}

	public void setLblModificarDoc6(JLabel lblModificarDoc6) {
		this.lblModificarDoc6 = lblModificarDoc6;
	}

	public JLabel getLblModificarDoc7() {
		return lblModificarDoc7;
	}

	public void setLblModificarDoc7(JLabel lblModificarDoc7) {
		this.lblModificarDoc7 = lblModificarDoc7;
	}

	public JLabel getLblModificarDoc8() {
		return lblModificarDoc8;
	}

	public void setLblModificarDoc8(JLabel lblModificarDoc8) {
		this.lblModificarDoc8 = lblModificarDoc8;
	}

	public JLabel getLblModificarDoc9() {
		return lblModificarDoc9;
	}

	public void setLblModificarDoc9(JLabel lblModificarDoc9) {
		this.lblModificarDoc9 = lblModificarDoc9;
	}

	public JTextField getTxtDoc1() {
		return txtDoc1;
	}

	public void setTxtDoc1(JTextField txtDoc1) {
		this.txtDoc1 = txtDoc1;
	}

	public JTextField getTxtDoc2() {
		return txtDoc2;
	}

	public void setTxtDoc2(JTextField txtDoc2) {
		this.txtDoc2 = txtDoc2;
	}

	public JTextField getTxtDoc3() {
		return txtDoc3;
	}

	public void setTxtDoc3(JTextField txtDoc3) {
		this.txtDoc3 = txtDoc3;
	}

	public JTextField getTxtDoc4() {
		return txtDoc4;
	}

	public void setTxtDoc4(JTextField txtDoc4) {
		this.txtDoc4 = txtDoc4;
	}

	public JTextField getTxtDoc5() {
		return txtDoc5;
	}

	public void setTxtDoc5(JTextField txtDoc5) {
		this.txtDoc5 = txtDoc5;
	}

	public JTextField getTxtDoc6() {
		return txtDoc6;
	}

	public void setTxtDoc6(JTextField txtDoc6) {
		this.txtDoc6 = txtDoc6;
	}

	public JTextField getTxtDoc7() {
		return txtDoc7;
	}

	public void setTxtDoc7(JTextField txtDoc7) {
		this.txtDoc7 = txtDoc7;
	}

	public JTextField getTxtDoc8() {
		return txtDoc8;
	}

	public void setTxtDoc8(JTextField txtDoc8) {
		this.txtDoc8 = txtDoc8;
	}

	public JTextField getTxtDoc9() {
		return txtDoc9;
	}

	public void setTxtDoc9(JTextField txtDoc9) {
		this.txtDoc9 = txtDoc9;
	}

	public JTextField[] getCampos() {
		return campos;
	}

	public void setCampos(JTextField[] campos) {
		this.campos = campos;
	}

}