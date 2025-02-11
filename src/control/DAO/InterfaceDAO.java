package control.DAO;


import java.util.ArrayList;

public interface InterfaceDAO <T> {
	 T getOne(int id);
	 void add(T x);
	 boolean update(T x, T y);
	 boolean delete(T x);
}
