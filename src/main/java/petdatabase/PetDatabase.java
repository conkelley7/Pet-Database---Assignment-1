package petdatabase;

/**
 * This class contains methods for managing database.
 * Current version includes methods for adding, displaying, updating, removing, and searching pets.
 * 
 * @author conke
 */
import java.util.ArrayList;

public class PetDatabase {
    private ArrayList<Pet> pets;

    public PetDatabase() {
        pets = new ArrayList<>();
    }

    public void addPet(String name, int age) {
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
}
