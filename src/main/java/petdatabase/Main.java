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
            System.out.println("3) Search pets by name");
            System.out.println("4) Search pets by age");
            System.out.println("5) Exit program");
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
                        System.out.print("add pet (name, age): ");
                        input = scnr.nextLine();
                        if (input.equals("done")) {
                            System.out.println(petCounter + " pets added.");
                            petCounter = 0;
                            break;
                        }
                        String[] parts = input.split(" ");
                        if (parts.length == 2) {
                            String name = parts[0];
                            int age = Integer.parseInt(parts[1]);
                            database.addPet(name, age);
                            petCounter += 1;
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("Enter pet name to search: ");
                    String searchName = scnr.nextLine();
                    ArrayList<Pet> foundByName = database.searchByName(searchName);
                    database.displayPets(foundByName);
                    break;
                case "4":
                    System.out.print("Enter pet age to search: ");
                    int searchAge = Integer.parseInt(scnr.nextLine());
                    ArrayList<Pet> foundByAge = database.searchByAge(searchAge);
                    database.displayPets(foundByAge);
                    break;
                // Exiting program
                case "5":
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
