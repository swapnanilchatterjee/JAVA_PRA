// TCS PRA Practice: Fruits Management System
// Description: Finds the fruit with the maximum price having a rating greater than a specified threshold.
// Category: Core Java / OOPs

import java.util.*;
class Fruits{
    private int fruitId,price,rating;
    private String fruitName;
    public Fruits(int fruitId,int price,int rating,String fruitName){
        this.fruitId=fruitId;
        this.price=price;
        this.fruitName=fruitName;
        this.rating=rating;
    }
    public int getFruitId(){
        return fruitId;
    }
    public int getPrice(){
        return price;
    }
    public int getRating(){
        return  rating;
    }
}



public class Fruits_Management_System {
    public static Fruits findMaximumPriceByRating(Fruits[] arr,int targetRating){
        Fruits maxFruit=null;
        for(Fruits f:arr){
            if(f.getRating()>targetRating){
                if(maxFruit==null || f.getPrice()>maxFruit.getPrice()) maxFruit=f;
            }
        }
        return maxFruit;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Fruits[] fruits=new Fruits[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int price=sc.nextInt();
            int rating=sc.nextInt();
            sc.nextLine();
            fruits[i]=new Fruits(id,price,rating,name);
        }
        int targetRating=sc.nextInt();
        Fruits res=findMaximumPriceByRating(fruits,targetRating);
        if(res!=null) System.out.println(res.getFruitId());
        else System.out.println("No such Fruit");
        sc.close();
    }
}
