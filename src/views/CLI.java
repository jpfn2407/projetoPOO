package views;
import controllers.Controller;
import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class CLI {
    public CLI(){
        Controller controller = null;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            if (line == "") return;

            String[] commands = line.split(" ");

            switch (commands[0]) {
                case "RF":
                    String category = commands[1];
                    String permission = commands[2];
                    //String name = commands[3];
                    String employerName = "";
                    for(int i=3; i<commands.length; i++){
                        employerName += commands[i] + " ";
                    }

                    if(!controller.hasCategory(category)){
                        System.out.println("Categoria inexistente.");
                    }
                    else if(!controller.hasPermission(category, permission)){
                        System.out.println("Permissão inexistente.");
                    }
                    else if(controller.hasEmployerName(category)){
                        System.out.println("Funcionário existente.");
                    }
                    else{
                        int employerId = controller.registerEmployer(category, permission, employerName);
                        System.out.println("Funcionário registado com o identificador " + employerId);
                    }
                    break;

                case "RC":
                    String clientName = "";
                    for(int i=1; i<commands.length; i++){
                        clientName += commands[i] + " ";
                    }
                    if(controller.hasClient(clientName)){
                        System.out.println("Cliente Existente.");
                    }
                    else{
                        int clientId = controller.registerClient(clientName);
                        System.out.println("Cliente registado com o identificador " + clientId);
                    }
                    break;

                case "RI":
                    int clientId = Integer.parseInt(commands[1]);
                    String itemName = commands[2];
                    if(!controller.hasClientID(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else{
                        Scanner scanner2 = new Scanner(System.in);
                        while(true) {
                            String line2 = scanner2.nextLine();
                            boolean valid = true;
                            if (line == "") controller.registerItem("N");

                            String[] commands2 = line2.split(", ");

                            for(int i=0; i<commands2.length; i++){
                                if(!controller.validPermission(commands2[i])){
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
                        System.out.println("Local registado com o identificador" + locationId);
                    }
                    break;

                case "RD":
                    int clientId = Integer.parseInt(commands[1]);
                    int locationId = Integer.parseInt(commands[2]);
                    String[] firstEntry = {commands[1], commands[2]};
                    if(controller.hasLocationId(locationId)){
                        System.out.println("Local inexistente.");
                    }
                    else if(!controller.hasClientID(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else{
                        Scanner scanner2 = new Scanner(System.in);
                        while(true) {

                        }
                    }

                    break;

                case "RE":
                    break;

                case "CC":
                    int clientId = Integer.parseInt(commands[1]);

                    if(!controller.hasClient(clientId)){
                        System.out.println("Cliente inexistente.");
                    }

                    else{
                        System.out.println(controller.getClient(clientId).getName());
                        System.out.println(controller.getClient(clientId).getManager().getName());

                        System.out.println("Items:");
                        List<Item> items = controller.getClient(clientId).getItems();
                        for(Item item: items){
                            System.out.println("  " + item.getId() + " (" + item.getQuantity() + ") " + " [" + item.getPermissions() + "] " + item.getName());
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
                    int clientId = Integer.parseInt(commands[1]);
                    int itemId = Integer.parseInt(commands[2]);

                    if(!controller.hasClient(clientId)){
                        System.out.println("Cliente inexistente.");
                    }

                    if(!controller.hasItem(itemId)){

                    }

                    break;

                case "CE":
                    break;

                case "CF":
                    break;

                case "G":

                String fileName = commands[1];
                //chamar a funçao de gravar
                System.out.println("Ficheiro gravado com sucesso.");
                    break;

                case "L":
                    String fileName = commands[1];
                    //if(fileName not in saveFolder){ sout "Ficheiro inexistente."}
                    else{
                    //chamar funçao de ler
                    System.out.println("Ficheiro lido com sucesso.");
                    }
                    break;

                default:
                    System.out.println("Instrução Inválida.");
            }
        }
    }
}
