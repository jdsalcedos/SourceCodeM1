package control.DAO;

import java.util.ArrayList;

import modelo.factory.abstracto.Documento;


public class DocumentoDAO implements InterfaceDAO<Documento>{

	private ArrayList<Documento> datos;
		
		public DocumentoDAO() {
			datos = new ArrayList<Documento>();
		}
		
		// toca reescribir todos los metodos para que funcionen con Documentos

		
		//Este metodo toca revisarlo ya que toca preguntar que es mejor, traer Strings para la visualizacion
		//o mejor traer los objetos 
		
		@Override
		public String getAll() {
			String rta = "";
			if(!datos.isEmpty()) {
				for (Documento doc : datos) {
					rta += doc + "\n"; //esto es porque la clase Autor debe tener un metodo toString y por eso guarda bien el String
				}
			}
			return rta;
		}

		@Override
		public Documento getOne(int id) {
			Documento rta = null;
			if(!datos.isEmpty()) {
				for(Documento doc : datos) {
					rta = doc;
				}
			}
			return rta;
		}

		@Override
		public boolean add(Documento doc) {
			if(find(doc) == null) {
				datos.add(doc);
				return true;
			}
			return false;
		}

		@Override
		public boolean update(Documento antiguo, Documento nuevo) {
			Documento doc = find(antiguo);
			if(doc != null) {
				datos.remove(doc);
				doc.setIdAutor(nuevo.getIdDocumento());
				doc.setIdEditorial(nuevo.getIdEditorial());
				doc.setIdAutor(nuevo.getIdAutor());
				doc.setTitulo(nuevo.getTitulo());
				doc.setFechaPublicacion(nuevo.getFechaPublicacion());
				doc.setIsbn(nuevo.getIsbn());
				doc.setTipoDocumento(nuevo.getTipoDocumento());
				doc.setEstadoVisualizacion(nuevo.getEstadoVisualizacion());
				datos.add(doc);
				return true;
			}
			return false;
		}

		@Override
		public boolean delete(Documento docDelete) {
			Documento doc = find(docDelete);
			if(doc != null) {
				datos.remove(doc);
				return true;
			}
			return false;
		}

}



