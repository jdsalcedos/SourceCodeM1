package control.DAO;

import java.util.ArrayList;

import modelo.usuario.Usuario;


public class DocumentoDAO implements InterfaceDAO<Documento>{

	private ArrayList<Documento> datos;
		
		public DocumentoDAO() {
			datos = new ArrayList<Documento>();
		}
		
		// toca reescribir todos los metodos para que funcionen con Documentos

		@Override
		public String getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Documento getOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean update(Documento x, Documento y) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean delete() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Documento find(Documento x) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
}



