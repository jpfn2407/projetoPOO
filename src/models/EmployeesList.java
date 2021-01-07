package models;

import models.employee.*;

import java.util.*;

public class EmployeesList {

    private Map<Integer, Driver> drivers;
    private Map<Integer, Loader> loaders;
    private Map<Integer, Manager> managers;
    private Map<String, Map> employees;
    //private List<String> categories;

    public EmployeesList(){
        this.drivers = new HashMap<Integer, Driver>();
        //this.categories.add("Driver");
        this.loaders = new HashMap<Integer, Loader>();
        //this.categories.add("Loader");
        this.managers = new HashMap<Integer, Manager>();
        //this.categories.add("Manager");
        this.employees.put("Driver", drivers);
        this.employees.put("Loader", loaders);
        this.employees.put("Manager", managers);
    }

    public boolean hasCategory(String category) {
        return this.employees.containsKey(category);
    }

}
