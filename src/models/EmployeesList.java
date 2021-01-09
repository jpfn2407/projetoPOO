package models;
import models.client.Client;
import models.employee.*;

import java.io.Serializable;
import java.util.*;

public class EmployeesList implements Serializable {

    private Map<Integer, Driver> drivers;
    private Map<Integer, Loader> loaders;
    private Map<Integer, Manager> managers;
    //private Map<String, Map> employees;
    private Integer lastId;
    private List<String> categories;

    public EmployeesList(){
        this.categories = new ArrayList<String>();
        this.drivers = new HashMap<Integer, Driver>();
        this.categories.add("Condutor");
        this.loaders = new HashMap<Integer, Loader>();
        this.categories.add("Carregador");
        this.managers = new HashMap<Integer, Manager>();
        this.categories.add("Gestor");
        /*this.employees = new HashMap<String, Map>();
        this.employees.put("Condutor", drivers);
        this.employees.put("Carregador", loaders);
        this.employees.put("Gestor", managers);*/

        this.lastId = 0;
    }

    public boolean hasCategory(String category) {
        return this.categories.contains(category);
    }

    public boolean hasPermission(String category, String permission){
        if(category.equals("Condutor")){
            return (permission.equals("N") || permission.equals("P"));
        }
        else if(category.equals("Carregador")){
            return (permission.equals("N") || permission.equals("S"));
        }
        else if (category.equals("Gestor")){
            return (permission.equals("N"));
        }
        return false;
    }

    public boolean hasEmployeeName(String category, String employeeName) {
        Employee[] employeesObjects = new Employee[0];
        if (category.equals("Condutor")){
            employeesObjects = new Employee[this.drivers.values().size()];
            this.drivers.values().toArray(employeesObjects);
        }
        else if(category.equals("Carregador")){
            employeesObjects = new Employee[this.loaders.values().size()];
            this.loaders.values().toArray(employeesObjects);
        }
        else if(category.equals("Gestor")){
            employeesObjects = new Employee[this.managers.values().size()];
            this.managers.values().toArray(employeesObjects);
        }
        for(Employee person: employeesObjects){
            if (person.getName().equals(employeeName)){
                return true;
            }
        }
        return false;
    }

    public int registerEmployee(String category, String permission, String employeeName){
        this.lastId += 1;
        if (category.equals("Condutor")){
            this.drivers.put(this.lastId, new Driver(this.lastId, employeeName, category, permission));
        }
        else if(category.equals("Carregador")){
            this.loaders.put(this.lastId, new Loader(this.lastId, employeeName, category, permission));
        }
        else if(category.equals("Gestor")){
            this.managers.put(this.lastId, new Manager(this.lastId, employeeName, category, permission));
        }
        return this.lastId;
    }

    public boolean hasId(int employeeId) {
        return (this.loaders.containsKey(employeeId) || this.drivers.containsKey(employeeId) || this.managers.containsKey(employeeId));
    }

    public void associateClient(int employeeId, Client client){
        this.managers.get(employeeId).associateClient(client);
    }

    public Employee getEmployee(int employeeId) {
        if(this.drivers.containsKey(employeeId)){
            return this.drivers.get(employeeId);
        }
        else if(this.loaders.containsKey(employeeId)){
            return this.loaders.get(employeeId);
        }
        else if(this.managers.containsKey(employeeId)){
            return this.managers.get(employeeId);
        }
        return null;
    }
}
