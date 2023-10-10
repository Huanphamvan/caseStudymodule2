package manager;

import model.Staff;
import readAndWrite.ReadAndWriteForStaff;

import java.util.ArrayList;
import java.util.List;

public class StaffManager implements Imanager<Staff> {
    private List<Staff>list;
    private ReadAndWriteForStaff readAndWrite= new ReadAndWriteForStaff();
    public StaffManager(){

        list = readAndWrite.readFile();
    }
    @Override
    public void add(Staff staff) {
        list.add(staff);
        System.out.println("Đã thêm thành công");
        readAndWrite.writeFile(list);

    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        if (index == -1){
            System.out.println(" Không có nhân viên nào có id này");
            return false;
        }
        list.remove(index);
        System.out.println("Đã xóa thành công");
        readAndWrite.writeFile(list);
        return true;
    }

    @Override
    public boolean edit(int id, Staff staff) {
        int index = findById(id);
        if (index == -1){
            System.out.println("không có nhân viên nào có id này.");
            return false;
        }
        list.set(index,staff);
        System.out.println("Đã sửa thành công");
        readAndWrite.writeFile(list);
        return true;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Staff> findAll() {

        return list;
    }

    @Override
    public List<Staff> seachName(String name) {
        List<Staff>newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    @Override
    public boolean searchStatus(String name) {
        for (Staff staff: list) {
            if (staff.getName().toLowerCase().contains(name.toLowerCase())) {
                return staff.isStatus();
            }
        }
        return false;
    }

    @Override
    public String salary(int id) {
        for (Staff staff: list) {
            if (id == staff.getId()) {
                return staff.getType();
            }
        }
        return null;
    }

    @Override
    public void status(int id, boolean status) {
        int index = findById(id);
        if (index != -1) {
            list.get(index).setStatus(status);
            System.out.println("Đổi Thành Công");
        } else {
            System.out.println("Không Có vị Trí này");
        }

    }
}
