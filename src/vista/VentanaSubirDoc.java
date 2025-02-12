package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;

public class VentanaSubirDoc extends JFrame {

	private JButton btnCerrar;
	private JButton btnVolver;
	private JButton btnSubir;
	private JTextField txtTituloDoc;
	private JFormattedTextField fmtTxtFechaPublicacion;
	private JTextField txtNombreAutor;
	private JTextField txtIdEditorial;
	private JLabel lblCampo4;
	private JLabel lblCampo6;
	private JTextField txtCampo4;// isbn
	private JTextField txtCampo6;// campo diferente en las clases
	private JLabel lblBordeTxt6;
	private int mouseX, mouseY;
	private JPanel contentPane;

	public VentanaSubirDoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
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
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(0, 0, 40, 40);
		btnCerrar.setActionCommand("CERRAR");
		panelBarraSuperior.add(btnCerrar);

		JLabel lblImagenCerrar = new JLabel("");
		lblImagenCerrar.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/cerrar.png")));
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
		btnVolver.setActionCommand("VOLVER3");
		panelBarraSuperior.add(btnVolver);

		btnSubir = new JButton("Subir");
		btnSubir.setOpaque(false);
		btnSubir.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubir.setForeground(Color.WHITE);
		btnSubir.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		btnSubir.setContentAreaFilled(false);
		btnSubir.setBorderPainted(false);
		btnSubir.setBounds(388, 464, 125, 40);
		btnSubir.setActionCommand("SUBIR");
		contentPane.add(btnSubir);

		JLabel lblSubir = new JLabel("");
		lblSubir.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/boton.png")));
		lblSubir.setBounds(388, 464, 125, 40);
		contentPane.add(lblSubir);

		JLabel lblTituloDoc = new JLabel("Título");
		lblTituloDoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTituloDoc.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblTituloDoc.setBounds(205, 99, 179, 40);
		contentPane.add(lblTituloDoc);

		JLabel lblFechaPublicacion = new JLabel("Fecha de publicación");
		lblFechaPublicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaPublicacion.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblFechaPublicacion.setBounds(205, 158, 179, 40);
		contentPane.add(lblFechaPublicacion);

		JLabel lblNombreAutor = new JLabel("Autor");
		lblNombreAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreAutor.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblNombreAutor.setBounds(205, 217, 179, 40);
		contentPane.add(lblNombreAutor);

		lblCampo4 = new JLabel("");
		lblCampo4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampo4.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblCampo4.setBounds(205, 276, 179, 40);
		contentPane.add(lblCampo4);

		JLabel lblEditorial = new JLabel("Id de Editorial");
		lblEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditorial.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblEditorial.setBounds(205, 335, 179, 40);
		contentPane.add(lblEditorial);

		lblCampo6 = new JLabel("");
		lblCampo6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampo6.setFont(new Font("Roboto ExtraBold", Font.BOLD, 15));
		lblCampo6.setBounds(205, 394, 179, 40);
		contentPane.add(lblCampo6);

		txtTituloDoc = new JTextField();
		txtTituloDoc.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtTituloDoc.setForeground(Color.BLACK);
		txtTituloDoc.setOpaque(false);
		txtTituloDoc.setBorder(null);
		txtTituloDoc.setBounds(423, 99, 253, 40);
		contentPane.add(txtTituloDoc);

		try {
			// Crear formato para la fecha (AAAA-MM-DD)
			MaskFormatter formatoFecha = new MaskFormatter("####-##-##");

			// Crear el campo de texto formateado
			fmtTxtFechaPublicacion = new JFormattedTextField(formatoFecha);

			fmtTxtFechaPublicacion.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
			fmtTxtFechaPublicacion.setForeground(Color.BLACK);
			fmtTxtFechaPublicacion.setOpaque(false);
			fmtTxtFechaPublicacion.setBorder(null);
			fmtTxtFechaPublicacion.setBounds(423, 158, 253, 40);
			contentPane.add(fmtTxtFechaPublicacion);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtNombreAutor = new JTextField();
		txtNombreAutor.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtNombreAutor.setForeground(Color.BLACK);
		txtNombreAutor.setOpaque(false);
		txtNombreAutor.setBorder(null);
		txtNombreAutor.setBounds(423, 217, 253, 40);
		contentPane.add(txtNombreAutor);

		txtCampo4 = new JTextField();
		txtCampo4.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtCampo4.setForeground(Color.BLACK);
		txtCampo4.setOpaque(false);
		txtCampo4.setBorder(null);
		txtCampo4.setBounds(423, 276, 253, 40);
		contentPane.add(txtCampo4);

		txtIdEditorial = new JTextField();
		txtIdEditorial.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtIdEditorial.setForeground(Color.BLACK);
		txtIdEditorial.setOpaque(false);
		txtIdEditorial.setBorder(null);
		txtIdEditorial.setBounds(423, 335, 253, 40);
		contentPane.add(txtIdEditorial);

		txtCampo6 = new JTextField();
		txtCampo6.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		txtCampo6.setForeground(Color.BLACK);
		txtCampo6.setOpaque(false);
		txtCampo6.setBorder(null);
		txtCampo6.setBounds(423, 394, 253, 40);
		contentPane.add(txtCampo6);

		JLabel lblBordeTxt1 = new JLabel("");
		lblBordeTxt1.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt1.setBounds(406, 99, 270, 40);
		contentPane.add(lblBordeTxt1);

		JLabel lblBordeTxt2 = new JLabel("");
		lblBordeTxt2.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt2.setBounds(406, 158, 270, 40);
		contentPane.add(lblBordeTxt2);

		JLabel lblBordeTxt3 = new JLabel("");
		lblBordeTxt3.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt3.setBounds(406, 217, 270, 40);
		contentPane.add(lblBordeTxt3);

		JLabel lblBordeTxt4 = new JLabel("");
		lblBordeTxt4.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt4.setBounds(406, 276, 270, 40);
		contentPane.add(lblBordeTxt4);

		JLabel lblBordeTxt5 = new JLabel("");
		lblBordeTxt5.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt5.setBounds(406, 335, 270, 40);
		contentPane.add(lblBordeTxt5);

		lblBordeTxt6 = new JLabel("");
		lblBordeTxt6.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/borde_modificar.png")));
		lblBordeTxt6.setBounds(406, 394, 270, 40);
		contentPane.add(lblBordeTxt6);

		JLabel lblFondoModificar = new JLabel("");
		lblFondoModificar.setIcon(new ImageIcon(VentanaSubirDoc.class.getResource("/imagenes/fondo_modificar.png")));
		lblFondoModificar.setBounds(205, 75, 490, 450);
		contentPane.add(lblFondoModificar);
	}

	public void clear() {
		txtTituloDoc.setText("");
		fmtTxtFechaPublicacion.setText("");
		txtNombreAutor.setEditable(false);
//		txtNombreAutor.setText("");
		txtCampo4.setText("");
		txtIdEditorial.setText("");
		txtCampo6.setText("");
	}

	public boolean verify() {

		String fecha = fmtTxtFechaPublicacion.getText().trim();
		if (txtTituloDoc.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de título", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (fecha.contains(" ")) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de fecha de publicación", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (txtNombreAutor.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de autores", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (txtCampo4.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de ...", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (txtIdEditorial.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de editorial", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (txtCampo6.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hace falta llenar el campo de ...", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	public void avisoError() {
		JOptionPane.showMessageDialog(this, "Ya existe un documento con ese ISBN, ingrese otro.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void avisoExito() {
		JOptionPane.showMessageDialog(this, "Documento subido exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

	public JButton getBtnSubir() {
		return btnSubir;
	}

	public void setBtnSubir(JButton btnSubir) {
		this.btnSubir = btnSubir;
	}

	public JTextField getTxtTituloDoc() {
		return txtTituloDoc;
	}

	public void setTxtTituloDoc(JTextField txtTituloDoc) {
		this.txtTituloDoc = txtTituloDoc;
	}

	public JFormattedTextField getFmtTxtFechaPublicacion() {
		return fmtTxtFechaPublicacion;
	}

	public void setFmtTxtFechaPublicacion(JFormattedTextField fmtTxtFechaPublicacion) {
		this.fmtTxtFechaPublicacion = fmtTxtFechaPublicacion;
	}

	public JTextField getTxtNombreAutor() {
		return txtNombreAutor;
	}

	public void setTxtNombreAutor(JTextField txtNombreAutor) {
		this.txtNombreAutor = txtNombreAutor;
	}

	public JTextField getTxtIdEditorial() {
		return txtIdEditorial;
	}

	public void setTxtIdEditorial(JTextField txtIdEditorial) {
		this.txtIdEditorial = txtIdEditorial;
	}

	public JLabel getLblCampo4() {
		return lblCampo4;
	}

	public void setLblCampo4(JLabel lblCampo4) {
		this.lblCampo4 = lblCampo4;
	}

	public JLabel getLblCampo6() {
		return lblCampo6;
	}

	public void setLblCampo6(JLabel lblCampo6) {
		this.lblCampo6 = lblCampo6;
	}

	public JLabel getLblBordeTxt6() {
		return lblBordeTxt6;
	}

	public void setLblBordeTxt6(JLabel lblBordeTxt6) {
		this.lblBordeTxt6 = lblBordeTxt6;
	}

	public JTextField getTxtCampo4() {
		return txtCampo4;
	}

	public void setTxtCampo4(JTextField txtCampo4) {
		this.txtCampo4 = txtCampo4;
	}

	public JTextField getTxtCampo6() {
		return txtCampo6;
	}

	public void setTxtCampo6(JTextField txtCampo6) {
		this.txtCampo6 = txtCampo6;
	}

}