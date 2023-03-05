import java.util.Scanner;

public class Run {
  public static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println(
          "Please enter gender (M, F, or X), age, weight (in pounds), height (in inches) and " +
              "calorie " + "intake " + "goal.");
      String choiceVal = "Y";
      char gender = input.next().charAt(0);
      int age = input.nextInt();
      double weight = input.nextDouble();
      double height = input.nextDouble();
      int calorieGoal = input.nextInt();
      Frontend newFront = new Frontend(gender, age, weight, height, calorieGoal);
      while (choiceVal.equalsIgnoreCase("Y")) {
        System.out.println("Choose one of the following options: ");
        System.out.println("1. Enter Food, 2. Calculate BMI, 3. Use Points, 4. Display food data");
        int choice = input.nextInt();
        if (choice == 1) {
          String choiceForFood = "F";
          while (choiceForFood.equalsIgnoreCase("F")) {
            System.out.println("Please enter a type of food: ");
            String food = input.next();
            newFront.addFood(food);
            System.out.println("Current food data: " + newFront.food);
            System.out.println("Would you like to add more food? Enter F to continue or any other" +
                " key, otherwise" +
                ".");
            choiceForFood = input.next();
          }
        } else if (choice == 2) {
          double bmi = newFront.getBMI();
          System.out.printf("BMI is: %.3f\n", bmi);
          if (bmi < 18.5) {
            System.out.println("You are currently underweight.");
            if (newFront.getPoints() != 0) {
              System.out.println("Removing 10 points.");
              newFront.setPoints(newFront.getPoints() - 10);
            }
          } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You are healthy. Adding 20 points!");
            newFront.setPoints(newFront.getPoints() + 20);
          } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are currently overweight.");
            if (newFront.getPoints() != 0) {
              System.out.println("Removing 30 points!");
              newFront.setPoints(newFront.getPoints() - 30);
            }
          } else {
            System.out.println("You are currently obese.");
            if (newFront.getPoints() != 0) {
              System.out.println("Removing 50 points.");
              newFront.setPoints(newFront.getPoints() - 50);
            }
          }
        } else if (choice == 3) {
          if (newFront.getPoints() == 0) {
            System.out.println("You currently have no points.");
          } else {
            System.out.println("TBD");
          }
        } else if (choice == 4) {
          if (newFront.food.isEmpty()) {
            System.out.println("Your current food data log is empty.");
          } else {
            System.out.println("Current food data: " + newFront.food);
          }
        }
        System.out.println("Enter choice (Y) to continue or any other key to exit");
        choiceVal = input.next();
      }
    }
  }
}
