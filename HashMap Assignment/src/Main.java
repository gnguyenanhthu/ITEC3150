import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 This program demonstrates a map that maps names to colors.
 */
public class Main
{
    public static void main(String[] args)
    {
        Map<String, String> statesAndCapitals = new HashMap<>();
        File textFile = new File("statecapitals.txt");
        Scanner scan;
        try {
            scan = new Scanner(textFile);
            while (scan.hasNext()) {
                String state = scan.nextLine();
                String capitol = scan.nextLine();
                statesAndCapitals.put(state,capitol);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();

        System.out.println("-----STATES and CAPITALS HashMap-----");
        Scanner input = new Scanner(System.in);
        System.out.print("Type your command or a state: ");
        String command = input.nextLine();

        while (!command.equalsIgnoreCase("quit")) {
            // Print all keys and values in the map
            if (command.equalsIgnoreCase("print")) {
                System.out.println("-----States and Capitals-----");
                for (String i : statesAndCapitals.keySet()) {
                    System.out.println(i + ", " + statesAndCapitals.get(i));
                }
            }

            //Print keys
            else if (command.equalsIgnoreCase("states")) {
                System.out.println("-----States-----");
                for (String i : statesAndCapitals.keySet()) {
                    System.out.println(i);
                }
            }

            // Print values
            else if (command.equalsIgnoreCase("capitals")) {
                System.out.println("-----Capitals-----");
                for (String i : statesAndCapitals.values()) {
                    System.out.println(i);
                }
            }

            else if (command.equalsIgnoreCase("help"))
                System.out.println("-----Commmand List-----\n" +
                        "print - Prints the full table of  states and capitals\n" +
                        "states - Prints a list all states\n" +
                        "capitals - Prints a list of  all capitals\n" +
                        "help - Prints this message\n" +
                        "quit - Quits the program");

            else {
                boolean stateFound = false; //containsKey is case-sensitive
                for (String state : statesAndCapitals.keySet()) {
                    if (state.equalsIgnoreCase(command)) {
                        System.out.println(state + "'s capital is " + statesAndCapitals.get(state));
                        stateFound = true;
                        break;
                    }
                }
                if (!stateFound)
                    System.out.println("Cannot find your state.");
            }

            System.out.print("PLease type your command: ");
            command = input.nextLine();
        }
        System.out.println("Thank you for using my HashMap");
    }
}
