import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

/**
 * Manipulates the data model and runs the appropriate methods for each commands. 
 *
 * @author Oyu Gantumur
 */
public class Controller
{
    Model model;
    Viewer viewer;
    List<String> list;

    /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {
        list = new List<String>();
        model = new Model(list);
        viewer = new Viewer(model);        
    }

    /**
     * Loads the file with the provided name and 
     * adds the information to the model by the specified format
     * 
     * @param String filename to be uploaded
     */
    public void loadFile(String filename) {
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            Scanner lineScan = null;
            String line = scanner.nextLine();

            //creates a node and adds to the list
            while(line.contains("----") == false) {               
                lineScan = new Scanner(line);                
                int order = lineScan.nextInt();

                String task = "";
                String word = lineScan.next();
                while(word.equals(":") == false) {
                    task += word + " ";
                    word = lineScan.next();     //task name               
                }

                String date = "";
                do {
                    date += lineScan.next();   //task deadline
                } while(lineScan.next().equals(":") == false);
                list.add(task, date);

                do {
                    model.addTagToTask(lineScan.next());   //tags                 
                } while(lineScan.hasNext() == true);

                line = scanner.nextLine();
            }

            //add to the general tag list
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                model.addTag(line);                
            }

            System.out.println(list.toString());
            System.out.println("Tags: " + model.getTagList().toString());
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }        
    }

    /**
     * Creates a file with the provided name and 
     * writes the data in a format that can be reloaded later
     * 
     * @param String filename to be created
     */
    public void saveTasks(String filename){
        File file = new File(filename);        

        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(list.toString());
            writer.println("-------------");
            writer.println(model.toStrTagList());
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } 
    }

    /**
     * Runs the corresponding methods for each command. 
     * 
     * @param String function to execute
     */
    public void execute(String function) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String filename = "";
        String savedFileName = "";

        if (function.equals("load-tasks") || function.equals("ltk")) {
            
            viewer.print(function);
            filename = sc.nextLine();
            loadFile(filename);
            
        }
        else if (function.equals("add-tag") || function.equals("atg")) {            
            viewer.print(function);
            input = sc.nextLine();

            //add tag until enter is returned
            while (input.length() > 0) {
                
                model.addTag(input);
                viewer.print(function);
                input = sc.nextLine();
            
            }
        } 
        else if (function.equals("display-tags") || function.equals("dit")) {
            viewer.print(function);
        }
        else if (function.equals("delete-tag") || function.equals("det")) {
            
            viewer.print(function);
            input = sc.nextLine();            
            model.removeTag(input);        
            
        } 
        else if (function.equals("display-tasks") || function.equals("dtsk")) {            
            viewer.print(function);        
        } 
        else if (function.equals("add-task") || function.equals("atk")) {            
            viewer.print(function);
            input = sc.nextLine();

            Scanner lineScan = new Scanner(input);
            String task = "";
            String word = lineScan.next();
            
            while(word.equals(":") == false) {
                task += word + " ";
                word = lineScan.next();        //task name            
            }

            String date = "";
            do {
                date += lineScan.next();      //task deadline
            } while(lineScan.next().equals(":") == false);
            list.add(task, date);

            do {
                String newTag = lineScan.next();
                model.addTagToTask(newTag);    //tagList
                
                if(model.genTagList.contains(newTag) == false) {
                    model.addTag(newTag);
                }
            } while(lineScan.hasNext() == true);
            
        }
        else if (function.equals("save-tasks") || function.equals("stk")) {
            
            viewer.print(function);
            savedFileName = sc.nextLine();
            saveTasks(savedFileName);
        
        }
        else if (function.equals("search-tags") || function.equals("st")) {
            
            viewer.print(function);
            input = sc.nextLine();
            List<String> result = list.searchTag(input);
            System.out.println(result);

            executeList(result);
        } 
        else if (function.equals("search-dates") || function.equals("sd")) {
            
            viewer.print(function);
            input = sc.nextLine();
            List<String> result = list.searchDate(input);
            System.out.println(result);
            
            executeList(result);
        }
        else if (function.equals("search-text") || function.equals("stxt")) {
            
            viewer.print(function);
            input = sc.nextLine();
            List<String> result = model.searchText(input);
            System.out.println(result);
            
            executeList(result);
        }
        else if (function.equals("search-tags-dates") || function.equals("std")) {
            
            viewer.print(function);
            input = sc.nextLine();
            List<String> result = model.searchTagDate(input);
            System.out.println(result);
            
            executeList(result);
        }
        else if (function.equals("exit") || function.equals("e")) {
            
            viewer.print(function);
            savedFileName = sc.nextLine();
            
            if(savedFileName.length() > 0) { //if the user enter a file name
                saveTasks(savedFileName);
            }
        }
    }

    /**
     * Takes the corresponding actions on the itemized lists returned by search methods 
     * 
     * @param List to be modified
     */
    public void executeList(List<String> newList) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        
        //only if the list is not empty
        if(newList.head != null) {
            viewer.printAction("ask");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println(newList.get(id).toString());
    
            viewer.printOptions();
            int action = Integer.parseInt(sc.nextLine());
            
            if(action == 1) {
                viewer.printAction("add-tag");
                input = sc.nextLine();
    
                while (input.length() > 0) {
                    list.get(id).addMoreTag(input);
                    viewer.printAction("add-tag");
                    input = sc.nextLine();
                }
            } 
            else if (action == 2) {
                viewer.printAction("edit");
                action = Integer.parseInt(sc.nextLine());
                           
                if(action == 1) {  //edit the name of the task
                    viewer.printAction("name");
                    input = sc.nextLine();
                    list.get(id).setTask(input);
                }
                else if (action == 2) {  //edit the deadline of the task
                    viewer.printAction("deadline");
                    input = sc.nextLine();
                    list.get(id).setDeadline(input);
                } 
                else {
                    System.out.println("Invalid input");
                }
                
            } 
            else if (action == 3) {
                //removes the task from the list
                list.remove(newList.get(id));
            } 
            else if (action == 4) {  
                System.out.println("Enter the file name to save the tasks...");
                input = sc.nextLine();
                 
                File file = new File(input);
                
                //saves the list, tagList and the chosen task at the end of the file
                try { 
                    PrintWriter writer = new PrintWriter(file);
                    writer.println(list.toString());
                    writer.println(id + " " + newList.get(id).toString());
                    writer.println("-------------");
                    writer.println(model.toStrTagList());                
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Exception " + e);
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number from 1-4.");
            }
            
        }
        else {
            System.out.println("The search list is empty");
        }
    }
}
