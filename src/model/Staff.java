package model;

public class Staff {
    private int id;
    private String name;
    private String gender;
    private boolean status;
    private String type;

    public Staff(int id, String name, String gender, boolean status, String type) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                '}';
    }

    public String getData(){
        return id+","+ name +","+gender +","+ status+","+type;
    }

}
