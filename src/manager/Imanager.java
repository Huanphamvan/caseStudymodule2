package manager;

import model.Staff;

import java.util.List;

public interface Imanager <E>{
    void add (E e);
    boolean delete (int id);
    boolean edit (int id , E e);
    int findById(int id);
    List<Staff> findAll();
    List<Staff> seachName(String name);
    boolean searchStatus(String name);
    String salary(int id);
    void status(int id,boolean status);


}
