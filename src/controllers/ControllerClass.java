package controllers;
import models.*;
import models.client.Client;
import models.employee.Employee;
import models.employee.Manager;
import models.transport.Deposit;
import models.transport.Item;

import java.io.*;
import java.util.*;

public class ControllerClass implements Controller, Serializable {

    private ClientsList clientsList;
    private EmployeesList employeesList;
    private LocationsList locationsList;

    public ControllerClass(){
        this.clientsList = new ClientsList();
        this.employeesList = new EmployeesList();
        this.locationsList = new LocationsList();
    }

    public boolean hasCategory(String category) {
        return this.employeesList.hasCategory(category);
    }

    public boolean hasPermission(String category, String permission) {
        return this.employeesList.hasPermission(category, permission);
    }

    public boolean hasEmployeeName(String category, String employeeName) {
        return this.employeesList.hasEmployeeName(category, employeeName);
    }

    public int registerEmployee(String category, String permission, String employeeName) {
        return this.employeesList.registerEmployee(category, permission, employeeName);
    }

    public boolean hasEmployeeId(int employeeId) {
        return this.employeesList.hasId(employeeId);
    }

    public Employee getEmployee(int employeeId) {
        return this.employeesList.getEmployee(employeeId);
    }

    public boolean hasClientName(String clientName) {
        return this.clientsList.hasClientName(clientName);
    }

    public int registerClient(int employeeId, String clientName) {
        int id = this.clientsList.registerClient((Manager)getEmployee(employeeId), clientName);
        this.employeesList.associateClient(employeeId, this.clientsList.getClient(id));
        return id;
    }

    public boolean hasClientId(int clientId) {
        return this.clientsList.hasId(clientId);
    }

    public Client getClient(int clientId) {
        return this.clientsList.getClient(clientId);
    }

    public boolean validPermission(String permission) {
        return (permission.equals("N") || permission.equals("S") || permission.equals("P"));
    }

    public int registerItem(int clientId, String itemName, String[] permissions) {
        return this.clientsList.getClient(clientId).registerItem(clientId, itemName, permissions);
    }

    public boolean hasLocation(String locationName) {
        return this.locationsList.hasLocation(locationName);
    }

    public boolean hasLocationId(int locationId) {
        return this.locationsList.hasId(locationId);
    }

    public int registerLocation(String locationName) {
        return this.locationsList.registerLocation(locationName);
    }

    public boolean hasItem(int clientId, int itemId) {
        return this.clientsList.getClient(clientId).hasItem(itemId);
    }

    private boolean isDriver(Integer employeeId){
        return this.getEmployee(employeeId).getCategory().equals("Condutor");
    }

    private boolean isLoader(Integer employeeId){
        return this.getEmployee(employeeId).getCategory().equals("Carregador");
    }

    private boolean employeeEqualsItemPermission(Integer clientId, Integer itemId, Integer employeeId){
        return this.clientsList.getClient(clientId).getItem(itemId).getPermissions().equals(this.employeesList.getEmployee(employeeId).getPermissions());
    }

    public int getNumberOfDriversInThisArray(String[] employeesIdArray) {
        int numberOfDrivers = 0;
        for(int i=0; i<employeesIdArray.length; i++){
            if(this.isDriver(Integer.parseInt(employeesIdArray[i]))){
                numberOfDrivers++;
            }
        }
        return numberOfDrivers;
    }

    public boolean driverHasPermissionsForItem(int clientId, String[] employeeArray, List<String[]> itemArrayList) {
        boolean valid = false;
        for(int i=0; i<employeeArray.length; i++){
            if(this.isDriver(Integer.parseInt(employeeArray[i]))){
                for (String[] id : itemArrayList){
                    if( this.employeeEqualsItemPermission(clientId, Integer.parseInt(id[0]), Integer.parseInt(employeeArray[i])) ){
                        valid = true;
                    }
                }
            }
        }
        return valid;
    }

    public boolean loadersHavePermissionsForItem(int clientId, String[] employeeArray, List<String[]> itemArrayList) {
        boolean valid = false;
        for(int i=0; i<employeeArray.length; i++){
            if(this.isLoader(Integer.parseInt(employeeArray[i]))){
                for (String[] id : itemArrayList){
                    if( this.employeeEqualsItemPermission(clientId, Integer.parseInt(id[0]), Integer.parseInt(employeeArray[i])) ){
                        valid = true;
                    }
                }
            }
        }
        return valid;
    }

    /** Adicionar o item à itemList do Client, ao depositList do Client,
     * ao depositList de todos os Employees no Array com base no seu ID.
     *
     * @param idArray Constituido por [0] que é o ClientID e o [1] que é o LocationID.
     * @param employeeArray Array de IDs dos employees.
     * @param itemArrayList ArrayList de Arrays, cada posição é um String[] sendo que o [0] é ItemID [1] é a quantidade do Item.
     * @return itemId
     */
    public int registerItemDeposit(String[] idArray, String[] employeeArray, List<String[]> itemArrayList) {
        Integer clientId = Integer.parseInt(idArray[0]);
        Integer locationId = Integer.parseInt(idArray[1]);
        List<Item> itemList = new ArrayList<>();
        for(String[] item: itemArrayList){
            this.clientsList.getClient(clientId).addItemQuantityById(Integer.parseInt(item[0]),Integer.parseInt(item[1]));
            itemList.add(this.clientsList.getClient(clientId).getItem(Integer.parseInt(item[1])));
        }
        List<Employee> employeeList = this.employeeIdArrayToList(employeeArray);
        Deposit deposit = this.clientsList.getClient(clientId).registerDeposit(this.clientsList.getClient(clientId), this.locationsList.getLocation(locationId), employeeList, itemList);
        for(Employee employee : employeeList){
            employee.addDeposit(deposit);
        }
        return deposit.getId();
    }

    private List<Employee> employeeIdArrayToList(String[] employeeArray){
        List<Employee> employeeList = new ArrayList<>();
        for(String id : employeeArray){
            employeeList.add(this.getEmployee(Integer.parseInt(id)));
        }
        return employeeList;
    }

    public boolean hasItemQuantity(int clientId, int parseInt, String s) {
        return false;
    }

    public int registerItemDelivery(String[] idArray, String[] employeeArray, ArrayList<String[]> itemArrayList) {
        return 0;
    }

    public void saveFile(String fileName) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
