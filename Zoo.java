import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
   
        Scanner scanNEW = new Scanner(System.in);
        create.insertEmployeeData(scanNEW);
        System.out.println("");

        Scanner scn = new Scanner(System.in);
        updt.updateEmployeeCredentials(scn);
        System.out.println("");

   
        del.deleteEmployeeById();
        System.out.println("");

    

        try {
            System.out.print("Zookeeper: ");
            String zookeeperName = scanner.nextLine();
            System.out.print("Password : ");
            String zookeeperPassword = scanner.nextLine();
            System.out.println("\t");

            Zookeeper zookeeper = new Zookeeper(zookeeperName, zookeeperPassword);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            int choice;
            do {
                System.out.println("---------------------------------");
                System.out.println("         Hallo " + zookeeper.getName());
                System.out.println("---------------------------------");
                System.out.println("The Habitat  : 1 (LandAnimal) or 2 (AquaticAnimal)");
                System.out.print("Choose the Habitat  : ");
                int habitatChoice = scanner.nextInt();

                List<Animal> animals = new ArrayList<>();

                if (habitatChoice == 1) {
                    LandAnimal lion = new LandAnimal("Lion", "LandAnimal", 5.0); 
                    LandAnimal elephant = new LandAnimal("Elephant", "LandAnimal", 10.0);
                    animals.add(lion);
                    animals.add(elephant);
                } else if (habitatChoice == 2) {
                    AquaticAnimal dolphin = new AquaticAnimal("Dolphin", "AquaticAnimal", 3.0);
                    animals.add(dolphin);
                } else {
                    System.out.println("Invalid habitat choice.");
                    return;
                }

                System.out.println("the Animals        \t");
                for (int i = 0; i < animals.size(); i++) {
                    System.out.println("   " + (i + 1) + ". " + animals.get(i).getName());
                }
                System.out.print("id of the Animal : ");
                int animalId = scanner.nextInt();
                scanner.nextLine();  

                Animal chosenAnimal = animals.get(animalId - 1);
                double foodAmount = zookeeper.askFoodAmount();
                System.out.println("\t");

                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.println("     Welcome to the Zoo!");
                System.out.println("\t");
                System.out.println("Date: " + dateFormat.format(new Date()));
                System.out.println("   -------------------------------");
                System.out.println("Animal              : " + chosenAnimal.getName());
                System.out.println("Food                : " + zookeeper.getFoodNameByHabitat(chosenAnimal.getHabitat()));
                double totalFoodConsumption = ((AnimalInZoo) chosenAnimal).calculateFoodConsumption(7);
                System.out.println("Food consumption    : " + totalFoodConsumption + " units of " +
                        zookeeper.getFoodNameByHabitat(chosenAnimal.getHabitat()));
                System.out.println("-------------------------------");
                System.out.println("Zookeeper: " + zookeeper.getName());
                System.out.println("+++++++++++++++++++++++++++++++\t");
                System.out.println("");

                System.out.println("Do you want to continue? (1 for Yes, 0 for No): ");
                choice = scanner.nextInt();

            } while (choice == 1);

        } catch (Exception e) {
            System.out.println("Wrong!!");
        } finally {
            scanner.close();
        }
    }
}