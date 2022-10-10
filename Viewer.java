
/**
 * Displays the information retrieved from the model and presents it to the user. 
 *
 * @author Oyu Gantumur
 */
public class Viewer
{
    Model model;

    /**
     * Constructor for objects of class Viewer
     */
    public Viewer(Model model)
    {
        this.model = model;
    }

    /**
     * Prints the corresponding outputs for each command
     */
    public void print(String function) {

        if(function.equals("add-tag") || function.equals("atg")) {
            System.out.println("Enter the tag you want to add to the program...");
        }
        else if (function.equals("display-tags") || function.equals("dit")) {
            System.out.println(model.getTagList().toString());
        }
        else if (function.equals("delete-tag") || function.equals("det")) {
            System.out.println("Type the tag you want to delete from the program...");            
        } 
        else if (function.equals("display-tasks") || function.equals("dtsk")) {
            System.out.println(model.getList().toString());
        }
        else if (function.equals("add-task") || function.equals("atk")) {
            System.out.println("Enter the task you want to add in the format- task : MM/DD/YYYY : tag1 tag2 tag2");
        }
        else if (function.equals("save-tasks") || function.equals("stk")) {
            System.out.println("Enter the file name to save the tasks...");
        }
        else if (function.equals("search-text") || function.equals("stxt")) {
            System.out.println("Enter the text you're searching...");
        }
        else if (function.equals("search-tags") || function.equals("st")) {
            System.out.println("Enter the tag you're searching...");
        }
        else if (function.equals("search-dates") || function.equals("sd")) {
            System.out.println("Enter the date(mm/dd/yyyy) or date range(mm/dd/yyyy--mm/dd/yyyy) you're searching for...");
        }
        else if (function.equals("search-tags-dates") || function.equals("std")) {
            System.out.println("Enter the tag and date you're searching for in a format of AND/OR ... ...");
        }
        else if (function.equals("load-tasks") || function.equals("ltk")) {
            System.out.println("Type the file name you want to load...");
        }
        else if (function.equals("exit") || function.equals("e")) {
            System.out.println("Would you like to save the current tasks to a file?\n" + 
                "If yes, enter the file name to save the tasks. If no, press enter.");
        }

    }

    /**
     * Prints the options for the returned itemized task list
     */
    public void printOptions() {
        System.out.println("Enter the integer of the action you'd like to take...");
        System.out.println("1. Add new tags to the identified task");
        System.out.println("2. Edit the task information");
        System.out.println("3. Delete the task from the system");
        System.out.println("4. Append the identified task to the end of a file");
    }

    /**
     * Prints the appropriate outputs for each requested action on the itemized list 
     */
    public void printAction(String command) {

        if(command.equals("ask")) {
            System.out.println("Choose which task you want to edit. Enter the number corresponding to the task");
        }
        else if(command.equals("add-tag")) {
            System.out.println("Enter the tags to add to the task one by one...");
        }
        else if(command.equals("edit")) {
            System.out.println("What information would you like to edit? Enter the number...");
            System.out.println("1. Task name");
            System.out.println("2. Task deadline");
        } 
        else if (command.equals("name")) {
            System.out.println("Enter the new task name");
        } 
        else if (command.equals("deadline")) {
            System.out.println("Enter the new deadline");
        }
    }
}
