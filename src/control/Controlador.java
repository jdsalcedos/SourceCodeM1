package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import control.DAO.AutorDAO;
import control.DAO.UsuarioDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DTO.AutorDTO;
import control.DTO.Mapper;
import control.DTO.UsuarioDTO;
import control.conexion.ConexionBD;
import modelo.autor.Autor;
import modelo.factory.abstracto.Documento;
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
		if(autor==null) {
			return null;
		}else {
			return Mapper.convertirToAutorDto(autor);
		}
	}
	
	public UsuarioDTO buscarUsuario(int id) {
		Usuario usuario = usuarioDao.getOne(id);
		if(usuario==null) {
			return null;
		}else {
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
	
	public void mostrarDocumento() {
		System.out.println("hola");
//		ArrayList<Documento> documentos = documentoDao.getAll();
		documentoDao.getAll();
//		if(documentos==null) {
//			System.out.println("es nulo");
//		}else {
//			System.out.println("tamaño: " + documentos.size());
//		}
//		
//		for(Documento doc : documentos) {
//			System.out.println("titulo " + doc.getTitulo());
//		}
//		
//		String titulo;
//		
//		if(!documentos.isEmpty()) {
//			System.out.println("chao: " + documentos.toString());
//			System.out.println("ok");
//		}else {
//			System.out.println("paila");
//		}
//		for(Documento doc : documentos) {
//			
//			titulo = doc.getTitulo();
//			System.out.println("titulooooooooooo: "+titulo);
//		}
//		System.out.println("documentos: "+ documentos);
	}

//	public void consultar () {
//		UsuarioDAO usuario = new UsuarioDAO();
//		String res = usuario.getAll();
//		if (res == "") {
//			System.out.println("paila");
//		} else {
//			vista.mostrarMensaje(res);
//		}
//	}
	
	public void consultar () {
		UsuarioDAO usuario = new UsuarioDAO();
		ArrayList<Usuario> res = usuario.getAll();
		if (!res.isEmpty()) {
			System.out.println("chao: " + res.toString());
			System.out.println("ok");
		} else {
			System.out.println("paila");
		}
	}	

}
