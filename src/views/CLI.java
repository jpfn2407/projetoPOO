package views;
import controllers.Controller;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class CLI {
    public CLI(){
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            if (line == "") return;

            String commands[] = line.split(" ");

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

                    }
                    else if(!controller.hasPermission(category, permission)){

                    }
                    else if(controller.hasEmployerName(category)){
                        
                    }
                    else{
                        call controller.something();
                        System.out.println("Funcionário registado com o identificador ", controller.getEmployer(employerName).getId());
                    }
                    break;

                case "RC":
                    String clientName = commands[1];
                    if(controller.hasClient(clientName)){
                        System.out.println("Cliente Existente.");
                    }
                    else{
                        controller.registerClient(clientName);
                        System.out.println("Cliente registado com o identificador ", controller.getClient(clientName).getId());
                    }
                    break;

                case "RI":
                    Integer clientId = commands[1];             //tem de ser String?
                    String itemName = commands[2];
                    if(!controller.hasClient(clientId)){
                        System.out.println("Cliente inexistente.");
                    }
                    else{
                        //new line, ler input
                        //if siglaPermissao in controller.singlasPermissao{ registar e sout "item registado..."}
                        //else{ sout "permissao invalida"}
                    }
                    break;

                case "RL":
                    String locationName = commands[1];
                    if(controller.hasLocation(locationName)) {
                        System.out.println("Local existente.");
                    }
                    else{
                        controller.registerLocation(locationName);
                        System.out.println("Local registado com o identificador", controller.getLocation(locationName).getId());
                    }
                    break;

                case "RD":

                    break;

                case "RE":
                    break;

                case "CC":
                    break;

                case "CI":
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
