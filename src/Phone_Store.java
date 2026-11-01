import java.util.*;
public class Phone_Store {
    public static int findPriceForGivenBrand(phone[] arr, String brand) {
        int total = 0;
        for (phone p : arr) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                total += p.getPrice();
            }
        }
        return total;
    }
    public static phone getphoneByOsAndMinPrice(phone[] arr, String os) {
        phone min = null;
        for (phone p : arr) {
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
        phone[] phones = new phone[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String os = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            phones[i] = new phone(id, os, brand, price);
        }
        String searchBrand = sc.nextLine();
        String searchOs = sc.nextLine();
        int total = findPriceForGivenBrand(phones, searchBrand);
        if (total > 0) System.out.println(total);
        else System.out.println("The given Brand is not available");
        phone res = getphoneByOsAndMinPrice(phones, searchOs);
        if (res != null) System.out.println(res.getphoneId());
        else System.out.println("The given OS is not available");
        sc.close();
    }
}

class phone{
    private  int phoneId;
    private  String os;
    private  String brand;
    private  int price;

    public phone(int phoneId,String os,String brand,int price){
        this.phoneId=phoneId;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }
    public int getphoneId(){return  phoneId;}
    public void setphoneId(int phoneId){this.phoneId=phoneId;}
    public String getOs(){return  os;}
    public void  setOs(String os){this.os=os;}
    public String getBrand(){return  brand;}
    public void  setBrand(String brand){this.brand=brand;}
    public int getPrice(){return price;}
    public void setPrice(int price){this.price=price;}
}
