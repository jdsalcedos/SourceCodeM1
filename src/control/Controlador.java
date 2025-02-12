package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import control.DAO.AutorDAO;
import control.DAO.UsuarioDAO;
import control.DAO.documentos.ArticuloCientificoDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DAO.documentos.LibroDAO;
import control.DAO.documentos.PonenciaDAO;
import control.DTO.ArticuloCientificoDTO;
import control.DTO.AutorDTO;
import control.DTO.LibroDTO;
import control.DTO.Mapper;
import control.DTO.PonenciaDTO;
import control.DTO.UsuarioDTO;
import control.conexion.ConexionBD;
import modelo.autor.Autor;
import modelo.factory.abstracto.Documento;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;
import modelo.usuario.Usuario;

public class Controlador {

	private AutorDAO autorDao;
	private UsuarioDAO usuarioDao;
	private DocumentoDAO documentoDao;
	private LibroDAO libroDao;
	private ArticuloCientificoDAO articuloDao;
	private PonenciaDAO ponenciaDao;
	private Connection cone;

	public Controlador() {
		cone = ConexionBD.getInstancia().getConexion();
		autorDao = new AutorDAO();
		usuarioDao = new UsuarioDAO();
		documentoDao = new DocumentoDAO();
		libroDao = new LibroDAO();
		articuloDao = new ArticuloCientificoDAO();
		ponenciaDao = new PonenciaDAO();
	}

	public AutorDTO buscarAutor(int id) {
		Autor autor = autorDao.getOne(id);
		if (autor == null) {
			return null;
		} else {
			return Mapper.convertirToAutorDto(autor);
		}
	}

	public AutorDTO autorEnSesion(int id) {
		return buscarAutor(id);
	}

	public UsuarioDTO usuarioEnSesion(int id) {
		return buscarUsuario(id);
	}

	public UsuarioDTO buscarUsuario(int id) {
		Usuario usuario = usuarioDao.getOne(id);
		if (usuario == null) {
			return null;
		} else {
			return Mapper.convertirToUsuarioDto(usuario);
		}
	}

	public void registrarAutor(AutorDTO dto) {
		Autor aut = Mapper.convertirToAutor(dto);
		autorDao.add(aut);
	}

	public void registrarUsuario(UsuarioDTO dto) {
		Usuario us = Mapper.convertirToUsuario(dto);
		usuarioDao.add(us);
	}

	public ArrayList<Documento> traerDocumentosAutor(int id) {
//		System.out.println("controlador...");
		ArrayList<Documento> documentos = documentoDao.getAllByAutor(id);
		return documentos;
	}
	
	public Documento traerDocumento(int id) {
		Documento documento = documentoDao.getOne(id);
		return documento;
	}

	public ArrayList<Documento> traerDocumento() {
		ArrayList<Documento> documentos = documentoDao.getAllVisible();
		return documentos;
	}

	public void modificarLibro(LibroDTO dto) {
		Libro libActual = (Libro) documentoDao.getOne(dto.getIdDocumento());
		Libro libNuevo = Mapper.convertirToLibro(dto);
		documentoDao.update(libActual, libNuevo);
	}
	
	public void modificarPonencia(PonenciaDTO dto) {
		Ponencia ponActual = (Ponencia) documentoDao.getOne(dto.getIdDocumento());
		Ponencia ponNuevo = Mapper.convertirToPonencia(dto);
		documentoDao.update(ponActual, ponNuevo);
	}
	
	public void modificarArticulo(ArticuloCientificoDTO dto) {
		ArticuloCientifico artActual = (ArticuloCientifico) documentoDao.getOne(dto.getIdDocumento());
		ArticuloCientifico artNuevo = Mapper.convertirToArticuloCientifico(dto);
		documentoDao.update(artActual, artNuevo);
	}
	
	public LibroDTO buscarLibro(int id) {
//		Documento libro = documentoDao.getOne(id);
		Libro libro = (Libro) documentoDao.getOne(id);
		System.out.println("\nEstoy en Controlador en el metodo buscarLibro()\n");
//		System.out.println("\nLibro encontrado: " + libro.toString());
		
		if(libro==null) {
			System.out.println("\nDevolvio un null\n");
			return null;
		}else {
//			return null;
			System.out.println("\nDevolvio un libro\n");
			return Mapper.convertirToLibroDto(libro);
		}
	}
	
	public PonenciaDTO buscarPonencia(int id) {
		Ponencia ponencia = ponenciaDao.getOne(id);
		if(ponencia==null) {
			return null;
		}else {
			return Mapper.convertirToPonenciaDto(ponencia);
		}
	}
	
	public ArticuloCientificoDTO buscarArticuloCientifico(int id) {
		ArticuloCientifico articulo = articuloDao.getOne(id);
		if(articulo==null) {
			return null;
		}else {
			return Mapper.convertirToArticuloCientificoDto(articulo);
		}
	}
	
	public void subirLibro(LibroDTO dto) {
		System.out.println("\nEstoy en Controlador en el metodo subirLibro()\n");
		Libro libro = Mapper.convertirToLibro(dto);
		System.out.println("Libro a subir: "+libro.toString());
		libroDao.add(libro);
	}
	
	public void subirPonencia(PonenciaDTO dto) {
		Ponencia ponencia = Mapper.convertirToPonencia(dto);
		ponenciaDao.add(ponencia);
	}
	
	public void subirArticuloCientifico(ArticuloCientificoDTO dto) {
		ArticuloCientifico articuloCientifico = Mapper.convertirToArticuloCientifico(dto);
		articuloDao.add(articuloCientifico);
	}
	

	

}
