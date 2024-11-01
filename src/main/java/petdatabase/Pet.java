package petdatabase;

/**
 * This class defines Pet objects.
 * @author conke
 */
public class Pet {
    private String name;
    private int age;
    
    // Constructor
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Setters and Getters
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
