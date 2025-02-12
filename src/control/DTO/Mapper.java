package control.DTO;

import modelo.autor.Autor;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;
import modelo.usuario.Usuario;

public class Mapper {

	public static AutorDTO convertirToAutorDto(Autor autor) {
		AutorDTO dto = new AutorDTO();
		dto.setIdAutor(autor.getIdAutor());
		dto.setNombre(autor.getNombre());
		dto.setCorreo(autor.getCorreo());
		dto.setContrasena(autor.getContrasena());
		dto.setDireccion(autor.getDireccion());
		dto.setTelefono(autor.getTelefono());
		return dto;
	}

	public static Autor convertirToAutor(AutorDTO dto) {
		Autor autor = new Autor();
		autor.setIdAutor(dto.getIdAutor());
		autor.setNombre(dto.getNombre());
		autor.setCorreo(dto.getCorreo());
		autor.setContrasena(dto.getContrasena());
		autor.setDireccion(dto.getDireccion());
		autor.setTelefono(dto.getTelefono());
		return autor;
	}

	public static UsuarioDTO convertirToUsuarioDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setIdUsuario(usuario.getIdUsuario());
		dto.setNombre(usuario.getNombre());
		dto.setCorreo(usuario.getCorreo());
		dto.setContrasena(usuario.getContrasena());
		dto.setDireccion(usuario.getDireccion());
		dto.setTelefono(usuario.getTelefono());
		return dto;
	}

	public static Usuario convertirToUsuario(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(dto.getIdUsuario());
		usuario.setNombre(dto.getNombre());
		usuario.setCorreo(dto.getCorreo());
		usuario.setContrasena(dto.getContrasena());
		usuario.setDireccion(dto.getDireccion());
		usuario.setTelefono(dto.getTelefono());
		return usuario;
	}

	public static ArticuloCientificoDTO convertirToArticuloCientificoDto(ArticuloCientifico articulo) {
		ArticuloCientificoDTO dto = new ArticuloCientificoDTO();
		dto.setIdAutor(articulo.getIdAutor());
		dto.setIdDocumento(articulo.getIdDocumento());
		dto.setIdEditorial(articulo.getIdEditorial());
		dto.setTitulo(articulo.getTitulo());
		dto.setFechaPublicacion(articulo.getFechaPublicacion());
		dto.setSsn(articulo.getSsn());
		dto.setTipoDocumento(articulo.getTipoDocumento());
		dto.setEstadoVisualizacion(articulo.getEstadoVisualizacion());
		return dto;
	}

	public static ArticuloCientifico convertirToArticuloCientifico(ArticuloCientificoDTO dto) {
		ArticuloCientifico articulo = new ArticuloCientifico();
		articulo.setIdDocumento(dto.getIdDocumento());
		articulo.setIdEditorial(dto.getIdEditorial());
		articulo.setIdAutor(dto.getIdAutor());
		articulo.setTitulo(dto.getTitulo());
		articulo.setFechaPublicacion(dto.getFechaPublicacion());
		articulo.setIsbn(dto.getIsbn());
		articulo.setSsn(dto.getSsn());
		articulo.setTipoDocumento(dto.getTipoDocumento());
		articulo.setEstadoVisualizacion(dto.getEstadoVisualizacion());
		return articulo;
	}
	
	public static LibroDTO convertirToLibroDto(Libro libro) {
		LibroDTO dto = new LibroDTO();
		dto.setIdAutor(libro.getIdAutor());
		dto.setIdDocumento(libro.getIdDocumento());
		dto.setIdEditorial(libro.getIdEditorial());
		dto.setTitulo(libro.getTitulo());
		dto.setFechaPublicacion(libro.getFechaPublicacion());
		dto.setIsbn(libro.getIsbn());
		dto.setTipoDocumento(libro.getTipoDocumento());
		dto.setEstadoVisualizacion(libro.getEstadoVisualizacion());
		dto.setNumPaginas(libro.getNumPaginas());
		return dto;
	}

	public static Libro convertirToLibro(LibroDTO dto) {
		Libro libro = new Libro();
		libro.setIdDocumento(dto.getIdDocumento());
		libro.setIdEditorial(dto.getIdEditorial());
		libro.setIdAutor(dto.getIdAutor());
		libro.setTitulo(dto.getTitulo());
		libro.setFechaPublicacion(dto.getFechaPublicacion());
		libro.setIsbn(dto.getIsbn());
		libro.setTipoDocumento(dto.getTipoDocumento());
		libro.setEstadoVisualizacion(dto.getEstadoVisualizacion());
		libro.setNumPaginas(dto.getNumPaginas());
		return libro;
	}
	
	public static PonenciaDTO convertirToPonenciaDto(Ponencia ponencia) {
		PonenciaDTO dto = new PonenciaDTO();
		dto.setIdAutor(ponencia.getIdAutor());
		dto.setIdDocumento(ponencia.getIdDocumento());
		dto.setIdEditorial(ponencia.getIdEditorial());
		dto.setTitulo(ponencia.getTitulo());
		dto.setFechaPublicacion(ponencia.getFechaPublicacion());
		dto.setIsbn(ponencia.getIsbn());
		dto.setTipoDocumento(ponencia.getTipoDocumento());
		dto.setEstadoVisualizacion(ponencia.getEstadoVisualizacion());
		dto.setCongreso(ponencia.getCongreso());
		return dto;
	}

	public static Ponencia convertirToPonencia(PonenciaDTO dto) {
		Ponencia ponencia = new Ponencia();
		ponencia.setIdDocumento(dto.getIdDocumento());
		ponencia.setIdEditorial(dto.getIdEditorial());
		ponencia.setIdAutor(dto.getIdAutor());
		ponencia.setTitulo(dto.getTitulo());
		ponencia.setFechaPublicacion(dto.getFechaPublicacion());
		ponencia.setIsbn(dto.getIsbn());
		ponencia.setTipoDocumento(dto.getTipoDocumento());
		ponencia.setEstadoVisualizacion(dto.getEstadoVisualizacion());
		ponencia.setCongreso(dto.getCongreso());
		return ponencia;
	}

}