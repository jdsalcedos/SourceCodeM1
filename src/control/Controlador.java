package control;

import java.sql.Connection;

import control.DAO.AutorDAO;
import control.DAO.UsuarioDAO;
import control.DTO.AutorDTO;
import control.DTO.Mapper;
import control.DTO.UsuarioDTO;
import control.conexion.ConexionBD;
import modelo.autor.Autor;
import modelo.usuario.Usuario;

public class Controlador {

	private AutorDAO autorDao;
	private UsuarioDAO usuarioDao;
	private Connection cone;
//	private Gestor gestor;

	public Controlador() {
//		gestor = new Gestor();
		cone = ConexionBD.getInstancia().getConexion();
		autorDao = new AutorDAO();
		usuarioDao = new UsuarioDAO();
//		consultar();
	}

//	public AutorDTO buscarAutor(int id, String pass) {
////		Autor autor = (Autor) autorDao.getOne(id, pass);
//		return Mapper.convertirToAutorDto(autor);
//	}

	public void agregarAutor(AutorDTO dto) {
		Autor aut = Mapper.convertirToAutor(dto);
		autorDao.add(aut);
	}

	public void agregarUsuario(UsuarioDTO dto) {
		Usuario us = Mapper.convertirToUsuario(dto);
		usuarioDao.add(us);
	}

//	public void consultar () {
//		UsuarioDAO usuario = new UsuarioDAO();
//		ArrayList<Usuario> res = usuario.getAll();
//		if (!res.isEmpty()) {
//			System.out.println("ok");
//		} else {
//			System.out.println("paila");
//		}
//	}	

}
