package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import control.DAO.HistorialDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DAO.documentos.LibroDAO;
import control.DTO.ArticuloCientificoDTO;
import control.DTO.AutorDTO;
import control.DTO.LibroDTO;
import control.DTO.PonenciaDTO;
import control.DTO.UsuarioDTO;
import modelo.facade.historial.HistorialCambio;
import modelo.factory.abstracto.Documento;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;
import modelo.state.EstadoOculto;
import modelo.state.EstadoVisible;
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
	private int user = 0;
	private int infoDoc = 0;
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
		infoDocumento.getBtnDarDeAlta().addActionListener(this);
		infoDocumento.getBtnDarDeBaja().addActionListener(this);
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

				int id = Integer.parseInt(new String(registro.getTxtIdentificacion().getText().trim()));
				String contrasena = new String(registro.getPasswordRegistro().getPassword()).trim();
				String nombre = registro.getTxtNombre().getText().trim();
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
					i++;
				} else {
					break; // Si hay más documentos que campos, evita errores
				}
			}

			infoDocumento.getLblModificar4().setText("ISBN");
			infoDocumento.getLblBordeTxt6().setVisible(true);
			infoDocumento.getTxtInfo6().setVisible(true);

			for (int j = 0; j < documentos.size(); j++) {
				if (comando.equals("INFO_DOC" + (j + 1))) {
					infoDocumento.clear();
//					infoDoc = 1;
					String tipoDoc = documentos.get(j).getTipoDocumento();
					Documento doc = controler.traerDocumento(documentos.get(j).getIdDocumento());

					if (tipoDoc.equals("Libro")) {
						infoDocumento.getLblModificar6().setText("Número de páginas");
						Libro lib = (Libro) doc;
						infoDocumento.getTxtInfo6().setText(lib.getNumPaginas());
						infoDocumento.getTxtInfo4().setText(doc.getIsbn());
					}
					if (tipoDoc.equals("Ponencia")) {
						infoDocumento.getLblModificar6().setText("Congreso");
						Ponencia pon = (Ponencia) doc;
						infoDocumento.getTxtInfo6().setText(pon.getCongreso());
						infoDocumento.getTxtInfo4().setText(doc.getIsbn());
					}
					if (tipoDoc.equals("Articulo cientifico")) {
						infoDocumento.getLblModificar6().setText("");
						infoDocumento.getLblModificar4().setText("SSN");
						infoDocumento.getLblBordeTxt6().setVisible(false);
						infoDocumento.getTxtInfo6().setVisible(false);
						ArticuloCientifico ac = (ArticuloCientifico) doc;
						infoDocumento.getTxtInfo4().setText(ac.getSsn());

//						infoDocumento.getLblModificar6().setText(ac.getSsn());
					}
					infoDocumento.getTxtInfo1().setText(documentos.get(j).getTitulo());
					infoDocumento.getTxtInfo2().setText(documentos.get(j).getFechaPublicacion().toString());
					UsuarioDTO user = controler.usuarioEnSesion(identificacion);
					infoDocumento.getTxtInfo3().setText(user.getNombre());

					infoDocumento.getTxtInfo5().setText(String.valueOf(documentos.get(j).getIdEditorial()));
					infoDocumento.getBtnDarDeAlta().setVisible(false);
					infoDocumento.getLblDarDeAlta().setVisible(false);
					infoDocumento.getBtnDarDeBaja().setVisible(false);
					infoDocumento.getLblDarDeBaja().setVisible(false);
					infoDocumento.setVisible(true);
					biblioteca.dispose();
				}
			}
			// Ventana infodocumento
			if (comando.equals("VOLVER5")) {
				biblioteca.setVisible(true);
				infoDocumento.dispose();
			} else if (comando.equals("RESERVAR")) {
				// codigo del boton reservar
			} else if (comando.equals("DEVOLVER")) {

			}

		} else if (user == 2) {
			System.out.println("gestor...");
			ArrayList<Documento> documentos = controler.traerDocumentosAutor(identificacion);
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

			
			traerDoc();
			biblioteca.bloquearCamposAutor();

			if (comando.equals("SUBIR_DOCUMENTO")) {
				elegirDocumento.setVisible(true);
				biblioteca.dispose();
			}

			documentos = controler.traerDocumentosAutor(identificacion);

			for (int j = 0; j < documentos.size(); j++) {
				if (comando.equals("MOD_LIBRO" + (j + 1))) {
//					modDoc = j + 1;
					String tipoDoc = documentos.get(j).getTipoDocumento();
					doc = tipoDoc;
					Documento doc = controler.traerDocumento(documentos.get(j).getIdDocumento());

					System.out.println(tipoDoc + " entro al modlibro2");
					if (tipoDoc.equals("Libro")) {
						modificarDocumento.getTxtCampo6().setVisible(true);
						modificarDocumento.getLblBordeTxt6().setVisible(true);
						modificarDocumento.getLblCampo4().setText("ISBN");
						modificarDocumento.getLblCampo6().setText("Número de páginas");
						Libro lib = (Libro) doc;
						modificarDocumento.getTxtCampo6().setText(lib.getNumPaginas());
						modificarDocumento.getTxtCampo4().setText(doc.getIsbn());

					}
					if (tipoDoc.equals("Ponencia")) {
						modificarDocumento.getTxtCampo6().setVisible(true);
						modificarDocumento.getLblBordeTxt6().setVisible(true);
						modificarDocumento.getLblCampo4().setText("ISBN");
						modificarDocumento.getLblCampo6().setText("Congreso");
						Ponencia pon = (Ponencia) doc;
						modificarDocumento.getTxtCampo6().setText(pon.getCongreso());
						modificarDocumento.getTxtCampo4().setText(doc.getIsbn());
					}
					if (tipoDoc.equals("Articulo cientifico")) {
						modificarDocumento.getLblCampo4().setText("SSN");
						modificarDocumento.getLblCampo6().setText("");
						modificarDocumento.getLblBordeTxt6().setVisible(false);
						modificarDocumento.getTxtCampo6().setVisible(false);

						ArticuloCientifico ac = (ArticuloCientifico) doc;
						modificarDocumento.getTxtCampo4().setText(ac.getSsn());
					}
					modificarDocumento.getTxtTituloDoc().setText(documentos.get(j).getTitulo());
					modificarDocumento.getFmtTxtFechaPublicacion()
							.setText(documentos.get(j).getFechaPublicacion().toString());
					AutorDTO autor = controler.autorEnSesion(identificacion);
					modificarDocumento.getTxtNombreAutor().setText(autor.getNombre());

					modificarDocumento.getTxtEditorial().setText(String.valueOf(documentos.get(j).getIdEditorial()));

					modificarDocumento.setVisible(true);
					biblioteca.dispose();
				}
			}

			documentos = controler.traerDocumentosAutor(identificacion);
			// Obtener lista de documentos

			for (int j = 0; j < documentos.size(); j++) {
				if (comando.equals("INFO_DOC" + (j + 1))) {
					infoDocumento.clear();
					infoDoc = j+1;
					String tipoDoc = documentos.get(j).getTipoDocumento();
					Documento doc = controler.traerDocumento(documentos.get(j).getIdDocumento());

					if (tipoDoc.equals("Libro")) {
						infoDocumento.getLblModificar4().setText("ISBN");
						infoDocumento.getLblBordeTxt6().setVisible(true);
						infoDocumento.getTxtInfo6().setVisible(true);
						infoDocumento.getLblModificar6().setText("Número de páginas");
						Libro lib = (Libro) doc;
						infoDocumento.getTxtInfo6().setText(lib.getNumPaginas());
//						System.out.println("cacorro: " + lib.getNumPaginas());
						infoDocumento.getTxtInfo4().setText(doc.getIsbn());
					}
					if (tipoDoc.equals("Ponencia")) {
						infoDocumento.getLblModificar4().setText("ISBN");
						infoDocumento.getLblBordeTxt6().setVisible(true);
						infoDocumento.getTxtInfo6().setVisible(true);
						infoDocumento.getLblModificar6().setText("Congreso");
						Ponencia pon = (Ponencia) doc;
						infoDocumento.getTxtInfo6().setText(pon.getCongreso());
						infoDocumento.getTxtInfo4().setText(doc.getIsbn());
					}
					if (tipoDoc.equals("Articulo cientifico")) {
						infoDocumento.getLblModificar6().setText("");
						infoDocumento.getLblModificar4().setText("SSN");
						infoDocumento.getLblBordeTxt6().setVisible(false);
						infoDocumento.getTxtInfo6().setVisible(false);
						ArticuloCientifico ac = (ArticuloCientifico) doc;
						infoDocumento.getTxtInfo4().setText(ac.getSsn());

						if (comando.equals("VOLVER5")) {
							biblioteca.setVisible(true);
							infoDocumento.dispose();
						}

					}
					infoDocumento.getTxtInfo1().setText(documentos.get(j).getTitulo());
					infoDocumento.getTxtInfo2().setText(documentos.get(j).getFechaPublicacion().toString());
					AutorDTO autor = controler.autorEnSesion(identificacion);
					infoDocumento.getTxtInfo3().setText(autor.getNombre());

					infoDocumento.getTxtInfo5().setText(String.valueOf(documentos.get(j).getIdEditorial()));

					if (doc.getEstadoVisualizacion().getEstado().equals("Dado de alta")) {
						infoDocumento.getBtnDarDeBaja().setVisible(true);
						infoDocumento.getLblDarDeBaja().setVisible(true);
						infoDocumento.getBtnDarDeAlta().setVisible(false);
						infoDocumento.getLblDarDeAlta().setVisible(false);
					} else if (doc.getEstadoVisualizacion().getEstado().equals("Dado de baja")) {
						infoDocumento.getBtnDarDeAlta().setVisible(true);
						infoDocumento.getLblDarDeAlta().setVisible(true);
						infoDocumento.getBtnDarDeBaja().setVisible(false);
						infoDocumento.getLblDarDeBaja().setVisible(false);
					}
					
					infoDocumento.getBtnDevolver().setVisible(false);
					infoDocumento.getLblDevolver().setVisible(false);
					infoDocumento.getBtnReservar().setVisible(false);
					infoDocumento.getLblReservar().setVisible(false);
					infoDocumento.setVisible(true);
					biblioteca.dispose();
				}
			}

			// ===================> MOVER LA LÓGICA DE CAMBIO DE ESTADO AQUÍ <===================

			// Buscar el documento que estaba abierto
			Documento docSeleccionado = null;
			for (Documento d : documentos) {
			    if (d.getEstadoVisualizacion().getEstado().equals("Dado de alta") && comando.equals("DARDEBAJA")) {
			        docSeleccionado = d;
			        break;
			    } else if (d.getEstadoVisualizacion().getEstado().equals("Dado de baja") && comando.equals("DARDEALTA")) {
			        docSeleccionado = d;
			        break;
			    }
			}

			// Si se encontró un documento para cambiar su estado, proceder
			if (docSeleccionado != null) {
			    System.out.println("Ejecutando " + comando + " para doc: " + docSeleccionado.getIdDocumento());

			    if (comando.equals("DARDEBAJA")) {
			    	System.out.println("Entra a dar de baja");
			        EstadoOculto oculto = new EstadoOculto();
			        System.out.println("lo dio de baja supuestamente");
			        infoDocumento.getBtnDarDeAlta().setVisible(true);
					infoDocumento.getLblDarDeAlta().setVisible(true);
					infoDocumento.getBtnDarDeBaja().setVisible(false);
					infoDocumento.getLblDarDeBaja().setVisible(false);
//			        docSeleccionado.cambiarEstado(oculto, docDao);
			    } else if (comando.equals("DARDEALTA")) {
			    	System.out.println("Entra a dar de alta");
			        EstadoVisible visible = new EstadoVisible();
			        System.out.println("lo dio de alta supuestamente");
			        infoDocumento.getBtnDarDeBaja().setVisible(true);
					infoDocumento.getLblDarDeBaja().setVisible(true);
					infoDocumento.getBtnDarDeAlta().setVisible(false);
					infoDocumento.getLblDarDeAlta().setVisible(false);
//			        docSeleccionado.cambiarEstado(visible, docDao);
			    }

			    // Mostrar mensaje de cambio
			    infoDocumento.avisoCambio();
			}
//			if (comando.equals("DARDEALTA")) {
//				for (int j = 0; j < documentos.size(); j++) {
//					if(infoDoc==j+1) {
//						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//						System.out.println(comando);
//						EstadoVisible visible = new EstadoVisible();
////						doc.cambiarEstado(visible, docDao);
//						infoDocumento.avisoCambio();
//					}
//				}
//			}
//			if (comando.equals("DARDEBAJA")) {
////				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
////				System.out.println(comando);
////				EstadoOculto oculto = new EstadoOculto();
//////				doc.cambiarEstado(oculto, docDao);
////				infoDocumento.avisoCambio();
//				for (int j = 0; j < documentos.size(); j++) {
//					if(infoDoc==j+1) {
//						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//						System.out.println(comando);
//						EstadoOculto oculto = new EstadoOculto();
////						doc.cambiarEstado(visible, docDao);
//						infoDocumento.avisoCambio();
//					}
//				}
//			}
			
			if (comando.equals("VOLVER5")) {
				biblioteca.setVisible(true);
				infoDocumento.dispose();
			}

			// Ventana elegirdocumento
			if (comando.equals("VOLVER2")) {
				biblioteca.setVisible(true);
				elegirDocumento.dispose();
			} else if (comando.equals("ARTICULO")) {
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
				doc = "Articulo cientifico";
				subirDocumento.setVisible(true);
				subirDocumento.clear();
				elegirDocumento.dispose();
			} else if (comando.equals("PONENCIA")) {
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
				doc = "Ponencia";
				subirDocumento.setVisible(true);
				subirDocumento.clear();
				elegirDocumento.dispose();
			} else if (comando.equals("LIBRO")) {
				AutorDTO autor = controler.autorEnSesion(identificacion);
				subirDocumento.getTxtNombreAutor().setText(autor.getNombre());
				doc = "Libro";
				subirDocumento.setVisible(true);
				subirDocumento.clear();
				elegirDocumento.dispose();
			}

			// Ventana subirdocumento
			subirDocumento.getLblCampo4().setText("ISBN");
			subirDocumento.getLblBordeTxt6().setVisible(true);
			subirDocumento.getTxtCampo6().setVisible(true);
			if (doc.equals("Libro")) {
				subirDocumento.getLblCampo6().setText("Número de páginas");
			} else if (doc.equals("Ponencia")) {
				subirDocumento.getLblCampo6().setText("Congreso");
			} else if (doc.equals("Articulo cientifico")) {
				subirDocumento.getLblCampo4().setText("SSN");
				subirDocumento.getLblBordeTxt6().setVisible(false);
				subirDocumento.getTxtCampo6().setText("a");
				subirDocumento.getTxtCampo6().setVisible(false);
				subirDocumento.getLblCampo6().setText("");
			}

			if (comando.equals("SUBIR")) {
				if (subirDocumento.verify()) {
					String titulo1 = subirDocumento.getTxtTituloDoc().getText();
					LocalDate fecha = LocalDate.parse(subirDocumento.getFmtTxtFechaPublicacion().getText());
					int idEditorial = Integer.valueOf(subirDocumento.getTxtIdEditorial().getText());
					String campo4 = subirDocumento.getTxtCampo4().getText();
					String campo6 = subirDocumento.getTxtCampo6().getText();
					int idDoc = Integer.valueOf(subirDocumento.getTxtCampo4().getText());
					EstadoVisible est = new EstadoVisible();

					if (doc.equals("Libro")) {

						LibroDTO libro = new LibroDTO();
						libro.setTitulo(titulo1);
						libro.setFechaPublicacion(fecha);
						libro.setIdAutor(identificacion);
						libro.setIsbn(campo4);
						libro.setIdEditorial(idEditorial);
						libro.setNumPaginas(campo6);
						libro.setTipoDocumento(doc);
						libro.setIdDocumento(idDoc);
						libro.setEstadoVisualizacion(est);

//						System.out.println("\nDetras del tostring de libro\n");
//						System.out.println(libro.toString()); 

//						para verificar si el libro ya existe
						if (controler.buscarLibro(idDoc) != null) {

							System.out.println("\n" + 1 + "\n");
							subirDocumento.avisoError();
							System.out.println("⚠ Error: Ya existe un documento con ese ID.");
//							subirDocumento.clear();
						} else {
							System.out.println("\n" + 2 + "\n");
							subirDocumento.avisoExito();
							controler.subirLibro(libro);

							biblioteca.setVisible(true);
							subirDocumento.dispose();
							subirDocumento.clear();
						}

					}
					if (doc.equals("Ponencia")) {
						PonenciaDTO ponencia = new PonenciaDTO();
						ponencia.setTitulo(titulo1);
						ponencia.setFechaPublicacion(fecha);
						ponencia.setIdAutor(identificacion);
						ponencia.setIsbn(campo4);
						ponencia.setIdEditorial(idEditorial);
						ponencia.setCongreso(campo6);
						ponencia.setTipoDocumento(doc);
						ponencia.setIdDocumento(idDoc);
						ponencia.setEstadoVisualizacion(est);

//						System.out.println("\nDetras del tostring de ponencia\n");
//						System.out.println(ponencia.toString()); 

						if (controler.buscarPonencia(idDoc) != null) {

							System.out.println("\n" + 1 + "\n");
							subirDocumento.avisoError();
							System.out.println("⚠ Error: Ya existe un documento con ese ID.");
//							subirDocumento.clear();
						} else {
							System.out.println("\n" + 2 + "\n");
							subirDocumento.avisoExito();
							controler.subirPonencia(ponencia);

							biblioteca.setVisible(true);
							subirDocumento.dispose();
							subirDocumento.clear();
						}
					}
					if (doc.equals("Articulo cientifico")) {
						ArticuloCientificoDTO articulo = new ArticuloCientificoDTO();
						articulo.setTitulo(titulo1);
						articulo.setFechaPublicacion(fecha);
						articulo.setIdAutor(identificacion);
						articulo.setIsbn(campo4);
						articulo.setSsn(campo4);
						articulo.setIdEditorial(idEditorial);
						articulo.setTipoDocumento(doc);
						articulo.setIdDocumento(idDoc);
						articulo.setEstadoVisualizacion(est);

//						System.out.println("\nDetras del tostring de articulo cientifico\n");
//						System.out.println(articulo.toString()); 

						if (controler.buscarArticuloCientifico(idDoc) != null) {

							System.out.println("\n" + 1 + "\n");
							subirDocumento.avisoError();
							System.out.println("⚠ Error: Ya existe un documento con ese ID.");
//							subirDocumento.clear();
						} else {
							System.out.println("\n" + 2 + "\n");
							subirDocumento.avisoExito();
							controler.subirArticuloCientifico(articulo);

							biblioteca.setVisible(true);
							subirDocumento.dispose();
							subirDocumento.clear();
						}
					}
					traerDoc();
					biblioteca.bloquearCamposAutor();
				}
			} else if (comando.equals("VOLVER3")) {
				elegirDocumento.setVisible(true);
				subirDocumento.dispose();
			}

			// Ventana modificadocumento
			if (comando.equals("MODIFICAR")) {
				HistorialDAO hist = new HistorialDAO();
				ArrayList<HistorialCambio> listaCambio = controler.traerCambios();
				//codigo del boton modificar
				String tituloNuevo = modificarDocumento.getTxtTituloDoc().getText();
				String fechaPublicacion = modificarDocumento.getFmtTxtFechaPublicacion().getText();
				LocalDate fechaNueva = LocalDate.parse(fechaPublicacion);
				String isbn = modificarDocumento.getTxtCampo4().getText();
				if (doc.equals("Libro")) {
					int idDoc = Integer.parseInt(isbn);
					String numPaginas = modificarDocumento.getTxtCampo6().getText();
					LibroDTO libro = new LibroDTO();
					libro.setIdDocumento(idDoc);
					libro.setTitulo(tituloNuevo);
					libro.setFechaPublicacion(fechaNueva);
					libro.setIsbn(isbn);
					libro.setNumPaginas(numPaginas);
					controler.modificarLibro(libro);
					
					modificarDocumento.avisoExito();

					biblioteca.setVisible(true);
					modificarDocumento.dispose();
					modificarDocumento.clear();
	            }
	            if (doc.equals("Ponencia")) {
	            	int idDoc = Integer.parseInt(isbn);
					String congreso = modificarDocumento.getTxtCampo6().getText();
					PonenciaDTO ponencia = new PonenciaDTO();
					ponencia.setIdDocumento(idDoc);
					ponencia.setTitulo(tituloNuevo);
					ponencia.setFechaPublicacion(fechaNueva);
					ponencia.setIsbn(isbn);
					ponencia.setCongreso(congreso);
					controler.modificarPonencia(ponencia);
					
					modificarDocumento.avisoExito();

					biblioteca.setVisible(true);
					modificarDocumento.dispose();
					modificarDocumento.clear();
	            }
	            if (doc.equals("Articulo cientifico")) {
					ArticuloCientificoDTO articulo = new ArticuloCientificoDTO();
					int idDoc = Integer.parseInt(isbn);
					articulo.setIdDocumento(idDoc);
					articulo.setTitulo(tituloNuevo);
					articulo.setFechaPublicacion(fechaNueva);
					articulo.setIsbn(isbn);
					articulo.setSsn(isbn);
					controler.modificarArticulo(articulo);
					
					modificarDocumento.avisoExito();

					biblioteca.setVisible(true);
					modificarDocumento.dispose();
					modificarDocumento.clear();
	            }
	            traerDoc();
				biblioteca.bloquearCamposAutor();
			} else if (comando.equals("VOLVER4")) {
				biblioteca.setVisible(true);
				modificarDocumento.dispose();
			}

		}

	}

	public void traerDoc() {
		ArrayList<Documento> documentos = controler.traerDocumentosAutor(identificacion);
		System.out.println("tamaño documentos: " + documentos.size());

		int i = 0;
		String titulo;
		for (Documento doc : documentos) {
			titulo = doc.getTitulo();
			if (i < biblioteca.getCampos().length) { // Para evitar IndexOutOfBoundsException
				biblioteca.getCampos()[i].setText(titulo);
				i++;
			} else {
				break; // Si hay más documentos que campos, evita errores
			}
		}

	}
}