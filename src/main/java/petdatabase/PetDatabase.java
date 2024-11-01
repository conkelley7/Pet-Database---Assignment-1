package petdatabase;

/**
 * This class contains methods for managing database.
 * Version 1: Contains methods for adding and displaying pets.
 * Future version will expand capabilities.
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

    public void displayPets() {
        System.out.printf("+----------------------+\n");
        System.out.printf("| ID | NAME      | AGE |\n");
        System.out.printf("+----------------------+\n");
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.printf("| %2d | %-10s | %3d |\n", i, pet.getName(), pet.getAge());
        }
        System.out.printf("+----------------------+\n");
        System.out.printf("%d rows in set.\n", pets.size());
    }
}
