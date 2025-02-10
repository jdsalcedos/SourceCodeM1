package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.DTO.AutorDTO;
import control.DTO.UsuarioDTO;
import vista.VentanaBiblioteca;
import vista.VentanaLogin;
import vista.VentanaRegistro;
import vista.VentanaElegirDoc;
import vista.VentanaInfoDoc;
import vista.VentanaModDoc;
import vista.VentanaSubirDoc;

public class Gestor implements ActionListener {
	private VentanaLogin login;
	private VentanaRegistro registro;
	private VentanaBiblioteca biblioteca;
	private VentanaSubirDoc subirDocumento;
	private VentanaElegirDoc elegirDocumento;
	private VentanaModDoc modificarDocumento;
	private VentanaInfoDoc infoDocumento;
	private Controlador controler;
	private int user = 0;
	private String doc = "";

	public Gestor() {
		login = new VentanaLogin();
		registro = new VentanaRegistro();
		biblioteca = new VentanaBiblioteca();
		subirDocumento = new VentanaSubirDoc();
		elegirDocumento = new VentanaElegirDoc();
		modificarDocumento = new VentanaModDoc();
		infoDocumento = new VentanaInfoDoc();
		controler = new Controlador();
		asignarOyentes();
	}

	public void asignarOyentes() {
		login.getBtnCerrar().addActionListener(this);
		login.getBtnIngresarAutor().addActionListener(this);
		login.getBtnIngresarLector().addActionListener(this);
		login.getBtnRegister().addActionListener(this);

		registro.getBtnCerrar().addActionListener(this);
		registro.getBtnRegistrarse().addActionListener(this);
		registro.getBtnVolver().addActionListener(this);
		registro.getRdBtnAutor().addActionListener(this);
		registro.getRdBtnLector().addActionListener(this);

		biblioteca.getBtnCerrar().addActionListener(this);
		biblioteca.getBtnSubirDoc().addActionListener(this);
		biblioteca.getBtnModificarDoc1().addActionListener(this);
		biblioteca.getBtnInfoDoc1().addActionListener(this);

		subirDocumento.getBtnCerrar().addActionListener(this);
		subirDocumento.getBtnSubir().addActionListener(this);
		subirDocumento.getBtnVolver().addActionListener(this);

		elegirDocumento.getBtnCerrar().addActionListener(this);
		elegirDocumento.getBtnVolver().addActionListener(this);
		elegirDocumento.getBtnLibro().addActionListener(this);
		elegirDocumento.getBtnPonencia().addActionListener(this);
		elegirDocumento.getBtnArticulo().addActionListener(this);

		modificarDocumento.getBtnCerrar().addActionListener(this);
		modificarDocumento.getBtnModificar().addActionListener(this);
		modificarDocumento.getBtnVolver().addActionListener(this);

		infoDocumento.getBtnCerrar().addActionListener(this);
		infoDocumento.getBtnReservar().addActionListener(this);
		infoDocumento.getBtnDevolver().addActionListener(this);
		infoDocumento.getBtnVolver().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println(comando);
		// Ventana login
		if (comando.equals("CERRAR")) {
			System.exit(0);

		} else if (comando.equals("REGISTER")) {
			registro.clear();
			registro.setVisible(true);
			login.dispose();

		} else if (comando.equals("INGRESAR_AUTOR")) {
			if (login.verifyAutor()) {
				int idAutor = 0;
				try {
					idAutor = Integer.parseInt(login.getTxtUsuarioAutor().getText()); 
					System.out.println(idAutor);
				} catch (Exception e2) {
					System.out.println("Error: La cadena no es un número válido.");
				}
				
				String contrasena = new String(login.getPasswordAutor().getPassword()).trim();
				
				if(controler.buscarAutor(idAutor)==null) {
					System.out.println("Autor no existe");
				}else {
					
				}

				biblioteca.setVisible(true);
				login.dispose();
				user = 2;
			}

		} else if (comando.equals("INGRESAR_LECTOR")) {
			if (login.verifyLector()) {
				biblioteca.setVisible(true);
				login.dispose();
				user = 1;
			}
		}

		//TOCA HACER AUTOINCREMENTABLE EL ID TANTO DE USUARIO COMO DE AUTOR
		// Ventana registro
		if (comando.equals("REGISTRARSE")) {
			if (registro.verify()) {
				int id = Integer.parseInt(registro.getTxtIdentificacion().getText());
				String contrasena = new String(registro.getPasswordRegistro().getPassword()).trim();
				String telefono = registro.getTxtTelefono().getText();
				String correo = registro.getTxtCorreo().getText();
				String direccion = registro.getTxtDireccion().getText();
				String nombre = registro.getTxtNombre().getText();

				if (registro.prueba() == 1) {
					UsuarioDTO user = new UsuarioDTO();
					user.setIdUsuario(id);
					user.setNombre(nombre);
					user.setContrasena(contrasena);
					user.setTelefono(telefono);
					user.setCorreo(correo);
					user.setDireccion(direccion);
					
					if(controler.buscarUsuario(id)!=null) {
						registro.avisoError();
						System.out.println("⚠ Error: Ya existe un usuario con ese ID.");
						registro.clear();
					}else {
						registro.avisoExito();
						controler.agregarUsuario(user);
						
						login.setVisible(true);
						registro.dispose();
						registro.clear();
					}
					
				} else if (registro.prueba() == 2) {
					AutorDTO autor = new AutorDTO();
					autor.setIdAutor(id);
					autor.setNombre(nombre);
					autor.setContrasena(contrasena);
					autor.setTelefono(telefono);
					autor.setCorreo(correo);
					autor.setDireccion(direccion);
					
					if(controler.buscarAutor(id)!=null) {
						registro.avisoError();
						System.out.println("⚠ Error: Ya existe un autor con ese ID.");
						registro.clear();
					}else{
						registro.avisoExito();
						controler.agregarAutor(autor);
						
						login.setVisible(true);
						registro.dispose();
						registro.clear();
					}
				}

			}

		} else if (comando.equals("VOLVER1")) {
			login.setVisible(true);
			registro.dispose();

		}

		// Ventana biblioteca
		if (user == 1) {
			biblioteca.getBtnModificarDoc1().setVisible(false);
			biblioteca.getBtnModificarDoc2().setVisible(false);
			biblioteca.getBtnModificarDoc3().setVisible(false);
			biblioteca.getBtnModificarDoc4().setVisible(false);
			biblioteca.getBtnModificarDoc5().setVisible(false);
			biblioteca.getBtnModificarDoc6().setVisible(false);
			biblioteca.getBtnModificarDoc7().setVisible(false);
			biblioteca.getBtnModificarDoc8().setVisible(false);
			biblioteca.getBtnModificarDoc9().setVisible(false);
			biblioteca.getLblModificarDoc1().setVisible(false);
			biblioteca.getLblModificarDoc2().setVisible(false);
			biblioteca.getLblModificarDoc3().setVisible(false);
			biblioteca.getLblModificarDoc4().setVisible(false);
			biblioteca.getLblModificarDoc5().setVisible(false);
			biblioteca.getLblModificarDoc6().setVisible(false);
			biblioteca.getLblModificarDoc7().setVisible(false);
			biblioteca.getLblModificarDoc8().setVisible(false);
			biblioteca.getLblModificarDoc9().setVisible(false);
			biblioteca.getBtnSubirDoc().setVisible(false);
		}
		if (comando.equals("SUBIR_DOCUMENTO")) {
			elegirDocumento.setVisible(true);
			biblioteca.dispose();
		}
		if (comando.equals("MOD_LIBRO1")) {
			modificarDocumento.setVisible(true);
			modificarDocumento.clear();
			biblioteca.dispose();
		} else if (comando.equals("INFO_DOC1")) {
			infoDocumento.setVisible(true);
			biblioteca.dispose();
		}

		// Ventana elegirdocumento
		if (comando.equals("VOLVER2")) {
			biblioteca.setVisible(true);
			elegirDocumento.dispose();
		} else if (comando.equals("ARTICULO")) {
			doc = "articulo";
			subirDocumento.setVisible(true);
			subirDocumento.clear();
			elegirDocumento.dispose();
		} else if (comando.equals("PONENCIA")) {
			doc = "ponencia";
			subirDocumento.setVisible(true);
			subirDocumento.clear();
			elegirDocumento.dispose();
		} else if (comando.equals("LIBRO")) {
			doc = "libro";
			subirDocumento.setVisible(true);
			subirDocumento.clear();
			elegirDocumento.dispose();
		}

		// Ventana subirdocumento
		if (comando.equals("SUBIR")) {
			if (subirDocumento.verify()) {
				biblioteca.setVisible(true);
				subirDocumento.dispose();
			}
		} else if (comando.equals("VOLVER3")) {
			elegirDocumento.setVisible(true);
			subirDocumento.dispose();
		}
		subirDocumento.getLblCampo4().setText("ISBN");
		subirDocumento.getLblBordeTxt6().setVisible(true);
		subirDocumento.getTxtCampo6().setVisible(true);
		if (doc.equals("libro")) {
			subirDocumento.getLblCampo6().setText("Número de páginas");
		}
		if (doc.equals("ponencia")) {
			subirDocumento.getLblCampo6().setText("Congreso");
		}
		if (doc.equals("articulo")) {
			subirDocumento.getLblCampo4().setText("SSN");
			subirDocumento.getLblBordeTxt6().setVisible(false);
			subirDocumento.getTxtCampo6().setVisible(false);
			subirDocumento.getLblCampo6().setText("");
		}

		// Ventana modificadocumento
		if (comando.equals("ELIMINAR")) {

		} else if (comando.equals("MODIFICAR")) {

		} else if (comando.equals("VOLVER4")) {
			biblioteca.setVisible(true);
			modificarDocumento.dispose();
		}

		// Ventana infodocumento
		if (comando.equals("RESERVAR")) {

		} else if (comando.equals("VOLVER5")) {
			biblioteca.setVisible(true);
			infoDocumento.dispose();
		} else if (comando.equals("DEVOLVER")) {

		}

	}
}