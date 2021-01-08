package models.employee;

public class Employee {
    private Integer id;
    private String name;
    private String category;
    private String permission;

    public Employee(Integer id, String name, String category, String permission){
        this.id = id;
        this.name = name;
        this.category = category;
        this. permission = permission;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPermission() {
        return this.permission;
    }
}
