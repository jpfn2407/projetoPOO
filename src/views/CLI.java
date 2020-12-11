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
                    break;
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
