package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import control.DTO.AutorDTO;
import control.DTO.UsuarioDTO;
import modelo.factory.abstracto.Documento;
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
	private int identificacion;
	private int modDoc;
	private int infoDoc;
	private int indice;
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
		biblioteca.getBtnModificarDoc2().addActionListener(this);
		biblioteca.getBtnModificarDoc3().addActionListener(this);
		biblioteca.getBtnModificarDoc4().addActionListener(this);
		biblioteca.getBtnModificarDoc5().addActionListener(this);
		biblioteca.getBtnModificarDoc6().addActionListener(this);
		biblioteca.getBtnModificarDoc7().addActionListener(this);
		biblioteca.getBtnModificarDoc8().addActionListener(this);
		biblioteca.getBtnModificarDoc9().addActionListener(this);

		biblioteca.getBtnInfoDoc1().addActionListener(this);
		biblioteca.getBtnInfoDoc2().addActionListener(this);
		biblioteca.getBtnInfoDoc3().addActionListener(this);
		biblioteca.getBtnInfoDoc4().addActionListener(this);
		biblioteca.getBtnInfoDoc5().addActionListener(this);
		biblioteca.getBtnInfoDoc6().addActionListener(this);
		biblioteca.getBtnInfoDoc7().addActionListener(this);
		biblioteca.getBtnInfoDoc8().addActionListener(this);
		biblioteca.getBtnInfoDoc9().addActionListener(this);

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
				} catch (Exception e2) {
					System.out.println("Error: La cadena no es un número válido.");
				}

				String contrasena = new String(login.getPasswordAutor().getPassword()).trim();

				if (controler.buscarAutor(idAutor) == null) {
					login.avisoError();
					System.out.println("Autor no existe");
				} else {
					String contrasenaReal = controler.buscarAutor(idAutor).getContrasena();
					if (contrasena.equals(contrasenaReal)) {
						identificacion = idAutor;
						login.avisoExito();
						System.out.println("Inicio de sesión exitoso");
						biblioteca.setVisible(true);
						login.dispose();
					} else {
						login.avisoError2();
						System.out.println("Contraseña incorrecta, digitela otra vez.");
					}
				}
				user = 2;
			}

		} else if (comando.equals("INGRESAR_LECTOR")) {
			if (login.verifyLector()) {
				int idUser = 0;
				try {
					idUser = Integer.parseInt(login.getTxtUsuarioLector().getText());
				} catch (Exception e2) {
					System.out.println("Error: La cadena no es un número válido.");
				}

				String contrasena = new String(login.getPasswordLector().getPassword()).trim();

				if (controler.buscarUsuario(idUser) == null) {
					login.avisoError();
					System.out.println("Usuario no existe");
				} else {
					String contrasenaReal = controler.buscarUsuario(idUser).getContrasena();
					if (contrasena.equals(contrasenaReal)) {
						identificacion = idUser;
						login.avisoExito();
						System.out.println("Inicio de sesión exitoso");
						biblioteca.setVisible(true);
						login.dispose();
					} else {
						login.avisoError2();
						System.out.println("Contraseña incorrecta, digitela otra vez.");
					}
				}
				user = 1;
			}
		}

		// Ventana registro
		if (comando.equals("REGISTRARSE")) {
			if (registro.verify()) {
				int id = Integer.valueOf(registro.getTxtIdentificacion().getText());
				String contrasena = new String(registro.getPasswordRegistro().getPassword()).trim();
				String nombre = registro.getTxtNombre().getText();
				String telefono = registro.getTxtTelefono().getText();
				String correo = registro.getTxtCorreo().getText();
				String direccion = registro.getTxtDireccion().getText();

				if (registro.prueba() == 1) {
					UsuarioDTO user = new UsuarioDTO();
					user.setIdUsuario(id);
					user.setNombre(nombre);
					user.setContrasena(contrasena);
					user.setTelefono(telefono);
					user.setCorreo(correo);
					user.setDireccion(direccion);

					if (controler.buscarUsuario(id) != null) {
						registro.avisoError();
						System.out.println("⚠ Error: Ya existe un usuario con ese ID.");
						registro.clear();
					} else {
						registro.avisoExito();
						controler.registrarUsuario(user);

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

					if (controler.buscarAutor(id) != null) {
						registro.avisoError();
						System.out.println("⚠ Error: Ya existe un autor con ese ID.");
						registro.clear();
					} else {
						registro.avisoExito();
						controler.registrarAutor(autor);

						login.setVisible(true);
						registro.dispose();
						registro.clear();
					}
				}

			}
		} else if (comando.equals("VOLVER1")) {
			login.clear();
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

			ArrayList<Documento> documentos = controler.traerDocumento();

			int i = 0;
			String titulo;
			for (Documento doc : documentos) {
				titulo = doc.getTitulo();
				if (i < biblioteca.getCampos().length) { // Para evitar IndexOutOfBoundsException
					biblioteca.getCampos()[i].setText(titulo);
//					System.out.println("titulooooooooooo: " + titulo);
					i++;
				} else {
					break; // Si hay más documentos que campos, evita errores
				}
			}

			biblioteca.bloquearCampos();

		} else {

			ArrayList<Documento> documentos = controler.traerDocumentoAutor(identificacion);
			System.out.println("tamaño documentos: " + documentos.size());

			int i = 0;
			String titulo;
			for (Documento doc : documentos) {
				titulo = doc.getTitulo();
				if (i < biblioteca.getCampos().length) { // Para evitar IndexOutOfBoundsException
					biblioteca.getCampos()[i].setText(titulo);
//					System.out.println("titulooooooooooo: " + titulo);
					i++;
				} else {
					break; // Si hay más documentos que campos, evita errores
				}
			}

			biblioteca.bloquearCampos();

			if (comando.equals("SUBIR_DOCUMENTO")) {
				elegirDocumento.setVisible(true);
				biblioteca.dispose();
			}

			documentos = controler.traerDocumentoAutor(identificacion);
			modificarDocumento.getLblCampo4().setText("ISBN");
			modificarDocumento.getLblBordeTxt6().setVisible(true);
			modificarDocumento.getTxtCampo6().setVisible(true);

			for (int j = 0; j < documentos.size(); j++) {
				if (comando.equals("MOD_LIBRO" + (j + 1))) {
					modDoc = j + 1;
					String tipoDoc = documentos.get(j).getTipoDocumento();
					System.out.println(tipoDoc + " entro al modlibro2");
					if (tipoDoc.equals("Libro")) {
						modificarDocumento.getLblCampo6().setText("Número de páginas");
					}
					if (tipoDoc.equals("Ponencia")) {
						modificarDocumento.getLblCampo6().setText("Congreso");
					}
					if (tipoDoc.equals("Articulo cientifico")) {
						modificarDocumento.getLblCampo4().setText("SSN");
						modificarDocumento.getLblBordeTxt6().setVisible(false);
						modificarDocumento.getTxtCampo6().setVisible(false);
						modificarDocumento.getLblCampo6().setText("");
					}
					System.out.println("AIUDAAAAAAAAAAAA");
					modificarDocumento.getTxtTituloDoc().setText(documentos.get(j).getTitulo());
					modificarDocumento.getFmtTxtFechaPublicacion()
							.setText(documentos.get(j).getFechaPublicacion().toString());
					AutorDTO autor = controler.autorEnSesion(identificacion);
					modificarDocumento.getTxtNombreAutor().setText(autor.getNombre());
//						infoDocumento.getTxtInfo4().setText(documentos.get(0).get);
					modificarDocumento.getTxtEditorial().setText(String.valueOf(documentos.get(j).getIdEditorial()));

					modificarDocumento.setVisible(true);
					biblioteca.dispose();
				}
			}

			documentos = controler.traerDocumento();
			infoDocumento.getLblModificar4().setText("ISBN");
			infoDocumento.getLblBordeTxt6().setVisible(true);
			infoDocumento.getTxtInfo6().setVisible(true);

			for (int j = 0; j < documentos.size(); j++) {
				if (comando.equals("INFO_DOC" + (j + 1))) {
					infoDocumento.clear();
					infoDoc = 1;
					String tipoDoc = documentos.get(j).getTipoDocumento();
					if (tipoDoc.equals("Libro")) {
						infoDocumento.getLblModificar6().setText("Número de páginas");
					}
					if (tipoDoc.equals("Ponencia")) {
						infoDocumento.getLblModificar6().setText("Congreso");
					}
					if (tipoDoc.equals("Articulo cientifico")) {
						infoDocumento.getLblModificar4().setText("SSN");
						infoDocumento.getLblBordeTxt6().setVisible(false);
						infoDocumento.getTxtInfo6().setVisible(false);
						infoDocumento.getLblModificar6().setText("");
					}
					infoDocumento.getTxtInfo1().setText(documentos.get(j).getTitulo());
					infoDocumento.getTxtInfo2().setText(documentos.get(j).getFechaPublicacion().toString());
					AutorDTO autor = controler.autorEnSesion(identificacion);
					infoDocumento.getTxtInfo3().setText(autor.getNombre());

//					infoDocumento.getTxtInfo4().setText(documentos.get(0).get);
					infoDocumento.getTxtInfo5().setText(String.valueOf(documentos.get(j).getIdEditorial()));
//					infoDocumento.getTxtInfo6().setText(documentos.get(0).get);
//					controler.buscaLibro(documentos.get(0).getIdDocumento());
					infoDocumento.setVisible(true);
					biblioteca.dispose();
				}
			}

			// Ventana elegirdocumento
			if (comando.equals("VOLVER2")) {
				biblioteca.setVisible(true);
				elegirDocumento.dispose();
			} else if (comando.equals("ARTICULO")) {
				System.out.println("articulo gestion");
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
				doc = "articulo";
				subirDocumento.setVisible(true);
				subirDocumento.clear();
				elegirDocumento.dispose();
			} else if (comando.equals("PONENCIA")) {
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
				doc = "ponencia";
				subirDocumento.setVisible(true);
				subirDocumento.clear();
				elegirDocumento.dispose();
			} else if (comando.equals("LIBRO")) {
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
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
			if (comando.equals("MODIFICAR")) {

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
}