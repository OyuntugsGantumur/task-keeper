import java.io.*; 
import java.util.*;

class Main {
        
    static public void main(String[] args) { 
        Controller controller = new Controller();
        String  command = null;
        Scanner input   = new Scanner(System.in);
        
        //displays the help file at the beginning
        runHelpCommand();
        System.out.println("Type the one of the commands from above or press enter to exit"); 
        
        while(true) {
            // get next command
            System.out.print("> ");
            command = input.nextLine();
            
            //didn't enter any command to run
            if(command.length() == 0) {
                command = "exit";
            }

            if(command.equals("exit") || command.equals("e")) {
                controller.execute(command);
                System.out.println("BYE!!");
                break;
            } 
            else if (command.equals("help") || command.equals("h")) {
                runHelpCommand();
            }
            else if (command.equals("display-tasks") || command.equals("dtsk")) {
                controller.execute(command);
            }
            else if (command.equals("add-tag") || command.equals("atg")) {
                controller.execute(command);
            }
            else if (command.equals("delete-tag") || command.equals("det")) {
                controller.execute(command);
            }
            else if (command.equals("display-tags") || command.equals("dit")) {
                controller.execute(command);
            }
            else if (command.equals("add-task") || command.equals("atk")) {
                controller.execute(command);
            }
            else if (command.equals("search-tags") || command.equals("st")) {
                controller.execute(command);
            }
            else if(command.equals("search-dates") || command.equals("sd")) {
                controller.execute(command);
            }
            else if (command.equals("search-text") || command.equals("stxt")) {
                controller.execute(command);
            }
            else if (command.equals("search-tags-dates") || command.equals("std")) {
                controller.execute(command);
            }
            else if (command.equals("save-tasks") || command.equals("stk")) {
                controller.execute(command);                
            }
            else if (command.equals("load-tasks") || command.equals("ltk")) {
                controller.execute(command);
            }
            else {
                // default condition
                System.out.println("Unknown command: " + command);
            }
        }
    }

    public static void runHelpCommand() {

        try {
            Scanner sc = new Scanner(new File("./help.txt"));

            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (IOException err) {
            System.out.println("Error reading help.txt file.");
            System.out.println(err);
        }
    }
}