package control.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class ArticuloCientificoDTO implements Serializable{
	
    private static final long serialVersionUID = 1L;
	private int idDocumento;
    private int idEditorial;
    private int idAutor;
    private String titulo;
    private LocalDate fechaPublicacion;
    private String tipoDocumento;
    private String estadoVisualizacion;
    private String ssn;

    public ArticuloCientificoDTO(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
                                 String tipoDocumento, String estadoVisualizacion, String ssn) {
        this.idDocumento = idDocumento;
        this.idEditorial = idEditorial;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.tipoDocumento = tipoDocumento;
        this.estadoVisualizacion = estadoVisualizacion;
        this.ssn = ssn;
    }
    
    public ArticuloCientificoDTO() {
    	
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    public void setEstadoVisualizacion(String estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
