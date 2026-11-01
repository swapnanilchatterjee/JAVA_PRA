// TCS PRA Practice: Phone Store Management System
// Description: Calculates total price of phones for a given brand and finds the phone with minimum price for a given OS.
// Category: Core Java / OOPs

import java.util.*;

public class Phone_Store {
    public static int findPriceForGivenBrand(Phone[] arr, String brand) {
        int total = 0;
        for (Phone p : arr) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                total += p.getPrice();
            }
        }
        return total;
    }

    public static Phone getPhoneByOsAndMinPrice(Phone[] arr, String os) {
        Phone min = null;
        for (Phone p : arr) {
            if (p.getOs().equalsIgnoreCase(os)) {
                if (min == null || p.getPrice() < min.getPrice()) {
                    min = p;
                }
            }
        }
        return min;
    }

    // 2. MAIN EXECUTION RUNNER
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            phones[i] = new Phone(id, os, brand, price);
        }
        String searchBrand = sc.nextLine();
        String searchOs = sc.nextLine();
        int total = findPriceForGivenBrand(phones, searchBrand);
        if (total > 0) System.out.println(total);
        else System.out.println("The given Brand is not available");
        Phone res = getPhoneByOsAndMinPrice(phones, searchOs);
        if (res != null) System.out.println(res.getPhoneId());
        else System.out.println("The given OS is not available");
        sc.close();
    }
}

class Phone {
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() { return phoneId; }
    public void setPhoneId(int phoneId) { this.phoneId = phoneId; }
    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
