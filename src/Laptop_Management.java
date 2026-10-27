// TCS PRA Practice: Laptop Management System
// Description: Filters laptops by brand with rating > 3, and searches/sorts laptops by OS type in descending order of ID.
// Category: Core Java / OOPs

import java.util.*;
public class Laptop_Management {
    public  static  int countofLaptopByBrand(Laptop[] arr,String b){
        int c=0;
        for(Laptop l:arr) if(l.getBrand().equalsIgnoreCase(b) && l.getRating()>3) c++;
        return c;
    }
    public static Laptop[] searchLaptopByOsType(Laptop[] arr,String os){
          List<Laptop>list=new ArrayList<>();
          for(Laptop l:arr) if(l.getOsType().equalsIgnoreCase(os)) list.add(l);
          if(list.isEmpty()) return null;
          list.sort((a,b)->b.getLaptopId()-a.getLaptopId());
          return  list.toArray(new Laptop[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Laptop[] laptops=new Laptop[4];
        for(int i=0;i<4;i++){
            int id= sc.nextInt();
            sc.nextLine();
            String brand=sc.nextLine();
            String os=sc.nextLine();
            double price=sc.nextDouble();
            int rating=sc.nextInt();
            sc.nextLine();
            laptops[i]=new Laptop(id,brand,os,price,rating);
        }
        String brand=sc.nextLine();
        String os=sc.nextLine();
        int count=countofLaptopByBrand(laptops,brand);
        if(count>0) System.out.println(count);
        else System.out.println("The given brand is not available");

        Laptop[] res=searchLaptopByOsType(laptops,os);
        if(res!=null){
            for(Laptop lp:res){
                System.out.println(lp.getLaptopId());
                System.out.println(lp.getPrice());
            }
        }
        else System.out.println("The given OS is not available");sc.close();

    }
}
class  Laptop{
    private  int laptopId,rating;
    private String brand,osType;
    private double price;
    public Laptop(int id,String b,String os,double p,int r){
        this.laptopId=id;
        this.brand=b;
        this.osType=os;
        this.price=p;
        this.rating=r;
    }
    public int getLaptopId(){return laptopId;}
    public int getRating(){return rating;}
    public double getPrice(){return price;}
    public String getBrand(){return brand;}
    public String getOsType(){return osType;}
}
