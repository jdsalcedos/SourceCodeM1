package control.DAO;

public interface InterfaceDAO {
	public String getAll();
	public <T> T getOne(String x);
	public boolean add();
	public boolean update();
	public boolean delete();
	public <T> T find();
}
