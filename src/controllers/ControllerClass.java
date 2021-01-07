package controllers;
import models.*;
import java.io.Serializable;
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
        return false;
    }

    public boolean hasEmployeeName(String category) {
        return false;
    }

    public int registerEmployee(String category, String permission, String employeeName) {
        return 0;
    }

    public boolean hasClientName(String clientName) {
        return false;
    }

    public int registerClient(String clientName) {
        return 0;
    }

    public boolean hasClientId(int clientId) {
        return false;
    }

    public int registerItem(int clientId, String itemName, String[] commands2) {
        return 0;
    }

    public boolean validPermission(String s) {
        return false;
    }

    public boolean hasLocation(String locationName) {
        return false;
    }

    public int registerLocation(String locationName) {
        return 0;
    }

    public boolean hasEmployeeId(int s) {
        return false;
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

    public Client getClient(int clientId) {
        return null;
    }

    public Employee getEmployee(int employeeId) {
        return null;
    }
}
