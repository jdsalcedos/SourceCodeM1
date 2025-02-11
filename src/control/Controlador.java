package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import control.DAO.AutorDAO;
import control.DAO.UsuarioDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DAO.documentos.LibroDAO;
import control.DTO.AutorDTO;
import control.DTO.LibroDTO;
import control.DTO.Mapper;
import control.DTO.UsuarioDTO;
import control.conexion.ConexionBD;
import modelo.autor.Autor;
import modelo.factory.abstracto.Documento;
import modelo.factory.documento.Libro;
import modelo.usuario.Usuario;

public class Controlador {

	private AutorDAO autorDao;
	private UsuarioDAO usuarioDao;
	private DocumentoDAO documentoDao;
	private Connection cone;

	public Controlador() {
		cone = ConexionBD.getInstancia().getConexion();
		autorDao = new AutorDAO();
		usuarioDao = new UsuarioDAO();
		documentoDao = new DocumentoDAO();
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

	public ArrayList<Documento> traerDocumentoAutor(int id) {
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
		Libro libActual = Mapper.convertirToLibro(dto);
		Libro libNuevo = Mapper.convertirToLibro(dto);
		documentoDao.update(libActual, libNuevo);
	}

}
