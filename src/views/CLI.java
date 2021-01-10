package views;

import controllers.Controller;
import controllers.ControllerClass;
import models.employee.Employee;
import models.employee.Loader;
import models.transport.*;
import java.util.*;

public class CLI {
    public CLI(){
        Controller controller = new ControllerClass();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            if (line == "") return;

            String[] commands = line.split(" ");

            switch (commands[0]) {
                case "RF":
                    String category = commands[1];
                    String permission = commands[2];
                    String employeeName = "";
                    for(int i=3; i<commands.length; i++){
                        employeeName += commands[i] + " ";
                    }

                    if(!controller.hasCategory(category)){
                        System.out.println("Categoria inexistente.");
                    }
                    else if(!controller.hasPermission(category, permission)){
                        System.out.println("Permissão inexistente.");
                    }
                    else if(controller.hasEmployeeName(category, employeeName)){
                        System.out.println("Funcionário existente.");
                    }
                    else{
                        int employeeId = controller.registerEmployee(category, permission, employeeName);
                        System.out.println("Funcionário registado com o identificador " + employeeId);
                    }
                    break;

                case "RC":
                    int employeeId = Integer.parseInt(commands[1]);
                    String clientName = "";
                    for(int i=2; i<commands.length; i++){
                        clientName += commands[i] + " ";
                    }
                    if(!controller.hasEmployeeId(employeeId)){
                        System.out.println("Funcionário inexistente.");
                    }
                    else if(!controller.getEmployee(employeeId).getCategory().equals("Gestor")){
                        System.out.println("Funcionario incorreto.");
                    }
                    else if(controller.hasClientName(clientName)){
                        System.out.println("Cliente existente.");
                    }
                    else{
                        int clientId = controller.registerClient(employeeId, clientName);
                        System.out.println("Cliente registado com o identificador " + clientId);
                    }
                    break;



                case "RI":
                    int clientId = Integer.parseInt(commands[1]);
                    String itemName = "";
                    for(int i=2; i<commands.length; i++){
                        itemName += commands[i] + " ";
                    }
                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else{
                        Scanner scanner2 = new Scanner(System.in);
                        while(true) {
                            String line2 = scanner2.nextLine();
                            boolean valid = true;
                            if (line2 == "") {
                                String[] normal = {"N"};
                                int itemId = controller.registerItem(clientId, itemName, normal);
                                System.out.println("Item registado para o cliente " + clientId + " com o identificador " + itemId);
                                break;
                            }

                            String[] commands2 = line2.split(", ");

                            for(int i=0; i<commands2.length; i++){
                                if(!controller.validPermission(commands2[i])){
                                    valid = false;
                                    System.out.println("Permissão inválida.");
                                    break;
                                }
                            }
                            if(valid){
                               int itemId = controller.registerItem(clientId, itemName, commands2);
                               System.out.println("Item registado para o cliente " + clientId + " com o identificador " + itemId);
                            }
                            break;
                        }
                    }
                    break;

                case "RL":
                    String locationName = commands[1];
                    if(controller.hasLocation(locationName)) {
                        System.out.println("Local existente.");
                    }
                    else{
                        int locationId = controller.registerLocation(locationName);
                        System.out.println("Local registado com o identificador " + locationId);
                    }
                    break;

                case "RD":
                    clientId = Integer.parseInt(commands[1]);
                    int locationId = Integer.parseInt(commands[2]);
                    String[] idArray = {commands[1], commands[2]};

                    boolean isValidId = true;
                    int numberOfDrivers = 0;

                    Scanner scanner2 = new Scanner(System.in);
                    String line2 = scanner2.nextLine();

                    String[] commands2 = line2.split(" ");

                    for(int i=0; i< commands2.length; i++){
                        if(!controller.hasEmployeeId(Integer.parseInt(commands2[i]))){
                            isValidId = false;
                        }
                    }

                    numberOfDrivers = controller.getNumberOfDriversInThisArray(commands2);

                    String[] employeeArray = commands2;

                    boolean hasIndicatedItem = true;

                    Scanner scanner3 = new Scanner(System.in);
                    List<String[]> itemArrayList = new ArrayList<String[]>();
                    while (true) {
                        String line3 = scanner3.nextLine();
                        if (line3 == "") break;

                        String[] commands3 = line3.split(" ");
                        if(!controller.hasItem(clientId, Integer.parseInt(commands3[0]))){
                            hasIndicatedItem = false;
                        }
                        itemArrayList.add(commands3);
                    }

                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!controller.hasLocationId(locationId)){
                        System.out.println("Local inexistente.");
                    }
                    else if(!isValidId){
                        System.out.println("Funcionário inexistente.");
                    }
                    else if(!hasIndicatedItem){
                        System.out.println("Item inexistente.");
                    }
                    else if(!controller.driverHasPermissionsForItem(clientId, employeeArray, itemArrayList) || (numberOfDrivers == 0)){
                        System.out.println("Condutor sem permissões.");
                    }
                    else  if(!controller.loadersHavePermissionsForItem(clientId, employeeArray, itemArrayList)){
                        System.out.println("Carregador sem permissões.");
                    }
                    else{
                        int depositId = controller.registerItemDeposit(idArray, employeeArray, itemArrayList);
                        System.out.println("Depósito registado com o identificador " + depositId);
                    }


                    break;

                case "RE":
                    clientId = Integer.parseInt(commands[1]);
                    locationId = Integer.parseInt(commands[2]);
                    idArray = new String[]{commands[1], commands[2]};

                    isValidId = true;
                    numberOfDrivers = 0;
                    scanner2 = new Scanner(System.in);
                    line2 = scanner2.nextLine();

                    commands2 = line2.split(" ");

                    for(int i=0; i< commands2.length; i++){
                        if(!controller.hasEmployeeId(Integer.parseInt(commands2[i]))){
                            isValidId = false;
                        }
                    }

                    employeeArray = commands2;

                    hasIndicatedItem = true;
                    boolean hasIndicatedItemQuantity = true;

                    scanner3 = new Scanner(System.in);
                    itemArrayList = new ArrayList<String[]>();
                    while (true) {
                        String line3 = scanner3.nextLine();
                        if (line3 == "") break;

                        String[] commands3 = line3.split(" ");

                        if(!controller.hasItem(clientId, Integer.parseInt(commands3[0]))){
                            hasIndicatedItem = false;
                        }
                        else if(!controller.hasItemQuantity(clientId, Integer.parseInt(commands3[0]), Integer.parseInt(commands3[1]))){
                            hasIndicatedItemQuantity = false;
                        }

                        itemArrayList.add(commands3);
                    }

                    numberOfDrivers = controller.getNumberOfDriversInThisArray(commands2);

                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if(controller.hasLocationId(locationId)){
                        System.out.println("Local inexistente.");
                    }
                    else if(numberOfDrivers > 1 || !isValidId){
                        System.out.println("Funcionário inexistente.");
                    }
                    else if(!controller.driverHasPermissionsForItem(clientId, employeeArray, itemArrayList) || (numberOfDrivers == 1)){
                        System.out.println("Condutor sem permissões.");
                    }
                    else  if(!controller.loadersHavePermissionsForItem(clientId, employeeArray, itemArrayList)){
                        System.out.println("Carregador sem permissões.");
                    }
                    else if(!hasIndicatedItem){
                        System.out.println("Item inexistente.");
                    }
                    else if(!hasIndicatedItemQuantity){
                        System.out.println("Quantidade insuficiente.");
                    }
                    else{
                        int deliveryId = controller.registerItemDelivery(idArray, employeeArray, itemArrayList);
                        System.out.println("Depósito registado com o identificador " + deliveryId);
                    }

                    break;


                case "CC":
                    clientId = Integer.parseInt(commands[1]);

                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }

                    else{
                        System.out.println(controller.getClient(clientId).getName());
                        System.out.println(controller.getClient(clientId).getManager().getName());

                        System.out.println("Items:");
                        List<Item> items = controller.getClient(clientId).getItems();
                        for(Item item: items){
                            System.out.println("  " + item.getId() + " (" + item.getQuantity() + ") " + item.getPermissions() + " " + item.getName());
                        }

                        System.out.println("Depósitos:");
                        List<Deposit> deposits = controller.getClient(clientId).getDeposits();
                        for(Deposit deposit: deposits){
                            System.out.println("  " + deposit.getId() + " (" + deposit.getLocationName() + ") ");
                        }

                        System.out.println("Entregas:");
                        List<Delivery> deliveries = controller.getClient(clientId).getDeliveries();
                        for(Delivery delivery: deliveries){
                            System.out.println("  " + delivery.getId() + " (" + delivery.getLocationName() + ") ");
                        }
                    }
                    break;



                case "CI":
                    clientId = Integer.parseInt(commands[1]);
                    int itemId = Integer.parseInt(commands[2]);

                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!controller.hasItem(clientId, itemId)) {
                        System.out.println("Item inexistente.");
                    }
                    else{
                        Item item = controller.getClient(clientId).getItem(itemId);

                        System.out.println(item.getQuantity() + " " + item.getPermissions() + " " + item.getName());

                        System.out.println("Depósitos:");
                        List<Deposit> deposits = controller.getClient(clientId).getDeposits();
                        for(Deposit deposit: deposits){
                            if(deposit.hasItem(itemId)) {
                                System.out.println("  " + deposit.getId() + " " + deposit.getItemQuantity(itemId));
                            }
                        }

                        System.out.println("Entregas:");
                        List<Delivery> deliveries = controller.getClient(clientId).getDeliveries();
                        for(Delivery delivery: deliveries){
                            if(delivery.hasItem(itemId)) {
                                System.out.println("  " + delivery.getId() + " " + delivery.getItemQuantity(itemId));
                            }
                        }
                    }

                    break;

                case "CE":
                    clientId = Integer.parseInt(commands[1]);
                    int deliveryId = Integer.parseInt(commands[2]);
                    if(!controller.hasClientId(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else if(!controller.getClient(clientId).hasDelivery(deliveryId)){
                        System.out.println("Entrega inexistente.");
                    }
                    else{
                        Delivery delivery = controller.getClient(clientId).getDelivery(deliveryId);
                        System.out.println(delivery.getDriverPermission() + " " + delivery.getDriverName());

                        List<Employee> loaders = delivery.getLoaders();
                        for(Employee loader: loaders){
                            System.out.println("  " + loader.getPermissions() + " " + loader.getName());
                        }

                        List<Item> items = delivery.getItems();
                        for(Item item: items){
                            System.out.println("  " + item.getId() + " " + item.getQuantity() + " " + item.getName());
                        }
                    }

                    break;

                case "CF":
                    employeeId = Integer.parseInt(commands[1]);
                    if(!controller.hasEmployeeId(employeeId)){
                        System.out.println("Funcionário inexistente.");
                    }
                    else{
                        System.out.println(controller.getEmployee(employeeId).getName());
                        System.out.println(controller.getEmployee(employeeId).getCategory());
                        System.out.println(controller.getEmployee(employeeId).getPermissions());

                        System.out.println("Depósitos:");
                        List<Deposit> deposits = controller.getEmployee(employeeId).getDeposits();

                        for (Deposit deposit : deposits) {
                            System.out.println("  " + deposit.getClientId() + " " + deposit.getId() + " " + deposit.getLocationName() + " " + deposit.getClientName());
                        }

                        System.out.println("Entregas:");
                        List<Delivery> deliveries = controller.getEmployee(employeeId).getDeliveries();

                        for (Delivery delivery : deliveries) {
                            System.out.println("  " + delivery.getClientId() + " " + delivery.getId() + " " + delivery.getLocationName() + " " + delivery.getClientName());
                        }

                    }

                    break;

                case "G":
                    String fileName = commands[1];
                    controller.saveFile(fileName);
                    System.out.println("Ficheiro gravado com sucesso.");
                    break;

                case "L":
                    fileName = commands[1];
                    try {
                        controller = Controller.loadFile(fileName);
                        System.out.println("Ficheiro lido com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Ficheiro inexistente.");
                    }
                    break;

                default:
                    System.out.println("Instrução Inválida.");
            }
        }
    }
}
