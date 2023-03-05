import java.util.ArrayList;

public class Frontend {
  private char gender;
  private int age;
  private double weight;

  private int patientCount;

  private int calories;

  private double height;

  private int CASE_NUMBER;

  public ArrayList<String> food = new ArrayList<>();

  private int points;

  public Frontend(char gender, int age, double weight, double height, int calories) {
    boolean badInput = true;
    while (badInput) {
      try {
        this.gender = gender;
        badInput = false;
      } catch (Exception e) {
        badInput = true;
        System.out.println(
            "Please enter a character representing the gender, i.e. M for male, F " + "for " + "female, or X for other");
      }
    }
    boolean worseInput = true;
    while (worseInput) {
      try {
        this.age = age;
        worseInput = false;
      } catch (Exception e) {
        worseInput = true;
        System.out.println("Please enter an integer representing the age.");
      }
    }
    boolean horribleInput = true;
    while (horribleInput) {
      try {
        weight = weight / 2.205;
        String weightValue = "" + weight;
        weightValue = String.format(weightValue, .2f);
        this.weight = Double.parseDouble(weightValue);
        horribleInput = false;
      } catch (Exception e) {
        horribleInput = true;
        System.out.println("Please enter a decimal value representing the weight.");
      }
    }
    boolean uglyInput = true;
    while (uglyInput) {
      try {
        this.calories = calories;
        uglyInput = false;
      } catch (Exception e) {
        uglyInput = true;
        System.out.println("Please enter an integer value representing the calorie intake.");
      }
      boolean nastyInput = true;
      while (nastyInput) {
        try {
          height = height / 39.37;
          this.height = height;
          nastyInput = false;
        } catch (Exception e) {
          nastyInput = true;
          System.out.println("Please enter an decimal value representing the height in inches.");
        }
      }
      CASE_NUMBER = generateCaseID(this.gender, this.age);
    }
  }

  private int generateCaseID(char gender, int age) {
    int firstDigit;
    int secondDigit;
    int thirdDigit;
    int fourthDigit;
    int fifthDigit;
    if (gender == 'M') {
      firstDigit = 1;
    } else if (gender == 'F') {
      firstDigit = 1;
    } else {
      firstDigit = 3;
    }
    String ageNum = "" + age;
    if (ageNum.length() <= 1) {
      secondDigit = 0;
      thirdDigit = Integer.parseInt(String.valueOf(ageNum.charAt(ageNum.length() - 1)));
    } else {
      secondDigit = Integer.parseInt(String.valueOf(ageNum.charAt(ageNum.length() - 2)));
      thirdDigit = Integer.parseInt(String.valueOf(ageNum.charAt(ageNum.length() - 1)));
    }
    String patientCounter = "" + patientCount % 100;
    if (patientCounter.length() < 2) {
      fourthDigit = 0;
      fifthDigit =
          Integer.parseInt(String.valueOf(patientCounter.charAt(patientCounter.length() - 1)));
    } else {
      fourthDigit =
          Integer.parseInt(String.valueOf(patientCounter.charAt(patientCounter.length() - 2)));
      fifthDigit =
          Integer.parseInt(String.valueOf(patientCounter.charAt(patientCounter.length() - 1)));
    }
    String caseID = "" + firstDigit + secondDigit + thirdDigit + fourthDigit + fifthDigit;
    patientCount++;
    return Integer.parseInt(caseID);
  }

  public double getWeight() {
    return weight;
  }

  public int getAge() {
    return age;
  }

  public int getCalories() {
    return calories;
  }

  public void updateCalories(int newCalories) {
    calories = newCalories;
  }

  public void addFood(String food) {
    this.food.add(food);
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public double getBMI() {
    double heightSquared = height * height;
    return weight / heightSquared;
  }
}
