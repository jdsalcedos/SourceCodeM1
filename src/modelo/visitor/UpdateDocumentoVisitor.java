package modelo.visitor;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;

public class UpdateDocumentoVisitor implements DocumentoVisitor {
	
	private DocumentoDAO dao;
	
	public UpdateDocumentoVisitor(DocumentoDAO dao) {
		this.dao = dao;
	}

	@Override
	public void visit(Libro libro) {
		dao.actualizarLibro(libro);
		
	}

	@Override
	public void visit(Ponencia ponencia) {
		dao.actualizarPonencia(ponencia);
		
	}

	@Override
	public void visit(ArticuloCientifico ac) {
		dao.actualizarArticulo(ac);
		
	}

}
