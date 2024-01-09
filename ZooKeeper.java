import java.util.List;
import java.util.Scanner;

class Zookeeper {
    
    private String name;
    private String password;

    public Zookeeper(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double askFoodAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The amount of food " + ": ");
        double foodAmount = scanner.nextDouble();
        scanner.nextLine(); 
        return foodAmount;
    }

    public int chooseHabitat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the Habitat: ");
        System.out.println("1. LandAnimal");
        System.out.println("2. AquaticAnimal");
        System.out.print("Choose the Habitat (1 or 2): ");
        return scanner.nextInt();
    }

    public String chooseAnimal(List<Animal> animals) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the Animal: ");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).getName());
        }
        System.out.print("Enter the id of the Animal: ");
        int animalId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        return animals.get(animalId - 1).getName();
    }

    public void feedAnimal(Animal animal, double foodAmount) {
        System.out.println(name + " is feeding " + animal.getName());
        animal.eat(this, foodAmount);
    }

    public String getFoodNameByHabitat(String habitat) {
        return "Generic Food";
    }
}
