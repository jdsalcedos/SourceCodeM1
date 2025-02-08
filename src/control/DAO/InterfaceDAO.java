package control.DAO;

public interface InterfaceDAO <T> {
	 String getAll();
	 T getOne(int id);
	 boolean add(T x);
	 boolean update(T x, T y);
	 boolean delete(T x);
	 T find(T x);
}
