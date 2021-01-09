package controllers;

import javax.print.attribute.Attribute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import models.*;
import models.client.Client;
import models.employee.Employee;

import java.util.ArrayList;

public interface Controller {

    boolean hasCategory(String category);

    boolean hasPermission(String category, String permission);

    boolean hasEmployeeName(String category, String employeeName);

    int registerEmployee(String category, String permission, String employeeName);

    boolean hasClientName(String clientName);

    int registerClient(int employeeId, String clientName);

    boolean hasClientId(int clientId);

    int registerItem(int clientId, String itemName, String[] commands2);

    boolean validPermission(String s);

    boolean hasLocation(String locationName);

    int registerLocation(String locationName);

    boolean hasEmployeeId(int s);

    int getNumberOfDriversInThisArray(String[] commands2);

    boolean hasLocationId(int locationId);

    boolean driverHasPermissionsForItem(String[] employeeArray, ArrayList<String[]> itemArrayList);

    boolean loadersHavePermissionsForItem(String[] employeeArray, ArrayList<String[]> itemArrayList);

    int registerItemDeposit(String[] idArray, String[] employeeArray, ArrayList<String[]> itemArrayList);

    boolean hasItem(int clientId, int s);

    boolean hasItemQuantity(int clientId, int parseInt, String s);

    int registerItemDelivery(String[] idArray, String[] employeeArray, ArrayList<String[]> itemArrayList);

    Client getClient(int clientId);

    Employee getEmployee(int employeeId);

    void saveFile(String fileName);

    static Controller loadFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Controller c = (Controller) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return c;
    }

}
