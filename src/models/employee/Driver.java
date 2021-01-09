package models.employee;
import models.*;

import java.io.Serializable;

public class Driver extends Employee implements Serializable {
    public Driver(Integer id, String name, String category, String permission){
        super(id, name, category, permission);
    }
}
