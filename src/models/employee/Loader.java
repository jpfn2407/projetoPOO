package models.employee;

import java.io.Serializable;

public class Loader extends Employee implements Serializable {
    public Loader(Integer id, String name, String category, String permission){
        super(id, name, category, permission);
    }
}
