// TCS PRA Practice: Autonomous Car Testing
// Description: Updates car grades based on test pass rate in a given environment and finds the car with the second highest pass rate.
// Category: Core Java / OOPs

import java.util.*;

public class Autonomous_Car_Testing {
    private static double passRate(AutonomousCar c) {
        if (c.getTestsConducted() == 0) return 0;
        return c.getTestsPassed() * 100.0 / c.getTestsConducted();
    }

    // 1. STATIC BUSINESS METHODS FIRST
    public static AutonomousCar[] updateGradeByEnvironment(AutonomousCar[] arr, String env) {
        List<AutonomousCar> list = new ArrayList<>();
        for (AutonomousCar c : arr) {
            if (c.getEnvironment().equalsIgnoreCase(env)) {
                c.setGrade(passRate(c) >= 80 ? "A1" : "B2");
                list.add(c);
            }
        }
        if (list.isEmpty()) return null;
        return list.toArray(new AutonomousCar[0]);
    }

    public static AutonomousCar findCarWithSecondHighestPassRate(AutonomousCar[] arr) {
        List<AutonomousCar> list = new ArrayList<>(Arrays.asList(arr));
        if (list.isEmpty()) return null;
        list.sort((a, b) -> Double.compare(passRate(b), passRate(a)));   // descending
        double top = passRate(list.get(0));
        for (AutonomousCar c : list) {
            if (passRate(c) < top) {
                return c;
            }
        }
        return null;
    }

    // 2. MAIN EXECUTION RUNNER
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            int tests = sc.nextInt();
            int passed = sc.nextInt();
            sc.nextLine();
            String env = sc.nextLine();
            cars[i] = new AutonomousCar(id, brand, tests, passed, env);
        }
        String searchEnv = sc.nextLine();
        AutonomousCar[] updated = updateGradeByEnvironment(cars, searchEnv);
        if (updated != null) {
            for (AutonomousCar c : updated) {
                System.out.println(c.getCarId());
                System.out.println(c.getGrade());
            }
        } else {
            System.out.println("No car found in the given environment");
        }
        AutonomousCar second = findCarWithSecondHighestPassRate(cars);
        if (second != null) {
            System.out.println(second.getCarId());
            System.out.println(second.getBrand());
        } else {
            System.out.println("No such car");
        }
        sc.close();
    }
}

class AutonomousCar {
    private int carId;
    private String brand;
    private int testsConducted;
    private int testPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carId, String brand, int testsConducted, int testPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.testsConducted = testsConducted;
        this.testPassed = testPassed;
        this.environment = environment;
        this.grade = "NA";
    }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getTestsConducted() { return testsConducted; }
    public void setTestsConducted(int testsConducted) { this.testsConducted = testsConducted; }
    public int getTestPassed() { return testPassed; }
    public int getTestsPassed() { return testPassed; }
    public void setTestPassed(int testPassed) { this.testPassed = testPassed; }
    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
