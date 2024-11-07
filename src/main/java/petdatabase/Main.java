package petdatabase;

/**
 * Entry point for program. Contains user interactions.
 * @author conke
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    * Main method - Entry point
    */
    public static void main(String[] args) {
        PetDatabase database = new PetDatabase();
        Scanner scnr = new Scanner(System.in);
        String input;
        int petCounter = 0;

        System.out.println("Pet Database Program");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update a pet");
            System.out.println("4) Remove a pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            System.out.print("Your choice: ");
            input = scnr.nextLine();

            switch (input) {
                // Viewing pets
                case "1":
                    database.displayPets();
                    break;
                // Adding pets
                case "2":
                    while (true) {
                        System.out.print("add pet (name and age): ");
                        input = scnr.nextLine();
                        if (input.equals("done")) {
                            System.out.println(petCounter + " pets added.");
                            petCounter = 0;
                            break;
                        }
                        if (input.contains(",")) {
                            System.out.println("Error: Input must not contain a comma.");
                            continue;
                        }
                        String[] parts = input.split(" ");
                        if (parts.length != 2) {
                            System.out.println("Error: You must enter both a name and an age.");
                            continue;
                        }
                        String name = parts[0];
                        try {
                            int age = Integer.parseInt(parts[1]);
                            database.addPet(name, age);
                            petCounter += 1;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Age must be a number");
                        }
                    }
                    break;
                // Updating pets
                case "3":
                    // Using while loop to get a valid ID.
                    int updateId;
                    while (true) {
                        System.out.print("Enter pet ID to update: ");
                    
                        try {
                            updateId = Integer.parseInt(scnr.nextLine());
                            if (updateId < 0 || updateId > 5) {
                                System.out.println("Error: ID must be a valid index.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error. ID must be a number.");
                        }
                    }
                    System.out.print("Enter new name and age: ");
                    String[] updateParts = scnr.nextLine().split(" ");
                    if (updateParts.length != 2) {
                        System.out.println("Error: You must enter both a name and an age.");
                    } else {
                        try {
                            String name = updateParts[0];
                            int age = Integer.parseInt(updateParts[1]);
                            
                            database.updatePet(updateId, name, age);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Age must be a valid number.");
                        }
                    }
                    break;
                // Removing pets
                case "4":
                    System.out.print("Enter pet ID to remove: ");
                    int removeId = Integer.parseInt(scnr.nextLine());
                    database.removePet(removeId);
                    break;
                // Search pets by name    
                case "5":
                    System.out.print("Enter pet name to search: ");
                    String searchName = scnr.nextLine();
                    ArrayList<Pet> foundByName = database.searchByName(searchName);
                    database.displayPets(foundByName);
                    break;
                // Search pets by age
                case "6":
                    System.out.print("Enter pet age to search: ");
                    int searchAge = Integer.parseInt(scnr.nextLine());
                    ArrayList<Pet> foundByAge = database.searchByAge(searchAge);
                    database.displayPets(foundByAge);
                    break;
                // Exiting program
                case "7":
                    System.out.println("Saving pets to file.");
                    database.savePetsToFile();                    
                    System.out.println("Exiting program.");                    
                    scnr.close();
                    return;
 
                // Handle invalid input
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
