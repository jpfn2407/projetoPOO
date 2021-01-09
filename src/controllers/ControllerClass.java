package controllers;
import models.*;
import models.client.Client;
import models.employee.Employee;
import models.employee.Manager;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;

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

    public int registerLocation(String locationName) {
        return this.locationsList.registerLocation(locationName);
    }

    public int getNumberOfDriversInThisArray(String[] commands2) {
        return 0;
    }

    public boolean hasItemId(int parseInt) {
        return false;
    }

    public boolean hasLocationId(int locationId) {
        return false;
    }

    public boolean driverHasPermissionsForItem(String[] employeeArray, ArrayList<String[]> itemArrayList) {
        return false;
    }

    public boolean loadersHavePermissionsForItem(String[] employeeArray, ArrayList<String[]> itemArrayList) {
        return false;
    }

    public int registerItemDeposit(String[] idArray, String[] employeeArray, ArrayList<String[]> itemArrayList) {
        return 0;
    }

    public boolean hasItem(int clientId, int s) {
        return false;
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
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
