package views;
import controllers.Controller;
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

                    }
                case "RC":
                    break;
                case "RI":
                    break;
                case "RL":
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
                default:
                    System.out.println("Instrução Inválida.");
            }
        }
    }
}
