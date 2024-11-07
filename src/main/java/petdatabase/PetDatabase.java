package petdatabase;

/**
 * This class contains methods for managing database.
 * @author conke
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PetDatabase {
    private ArrayList<Pet> pets;
    private final String FILENAME = "pets.txt";
    private final int MAX_PETS = 5;

    public PetDatabase() {
        pets = new ArrayList<>();
        loadPetsFromFile();
    }

    public void addPet(String name, int age) {
        if (pets.size() >= MAX_PETS) {
            System.out.println("Error: Database is full. 5 pet limit reached.");
        }
        if (age < 1 || age > 20) {
            System.out.println("Error: Age must be between 1 and 20.");
        }
        pets.add(new Pet(name, age));
    }
    
    public void displayPets(){
        displayPets(pets);
    }
    
    public void displayPets(ArrayList<Pet> petsToDisplay) {
        System.out.printf("+----------------------+\n");
        System.out.printf("| ID | NAME      | AGE |\n");
        System.out.printf("+----------------------+\n");
        for (int i = 0; i < petsToDisplay.size(); i++) {
            Pet pet = petsToDisplay.get(i);
            System.out.printf("| %2d | %-10s | %3d |\n", i, pet.getName(), pet.getAge());
        }
        System.out.printf("+----------------------+\n");
        System.out.printf("%d rows in set.\n", petsToDisplay.size());
    }
    
    public void updatePet(int id, String newName, int newAge) {
        if (id >= 0 && id < pets.size()) {
            pets.set(id, new Pet(newName, newAge));
        }
    }

    public void removePet(int id) {
        if (id >= 0 && id < pets.size()) {
            pets.remove(id);
        }
    }
    
    public ArrayList<Pet> searchByName(String name) {
        ArrayList<Pet> result = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                result.add(pet);
            }
        }
        return result;
    }

    public ArrayList<Pet> searchByAge(int age) {
        ArrayList<Pet> result = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getAge() == age) {
                result.add(pet);
            }
        }
        return result;
    }
    
    private void loadPetsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Loading pets from file.");
                String [] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    addPet(name, age);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load pets from file.");
        }
    }
    
    public void savePetsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Pet pet: pets) {
                writer.write(pet.getName() + "," + pet.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save pets to file");
        }
    }
}
