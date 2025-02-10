package modelo.visitor;

import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;

public interface DocumentoVisitor {
	void visit(Libro libro);
	void visit(Ponencia ponencia);
	void visit(ArticuloCientifico ac);
	
}
