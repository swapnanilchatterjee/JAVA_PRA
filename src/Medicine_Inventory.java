// TCS PRA Practice: Medicine Inventory Management
// Description: Retrieves and sorts prices of medicines matching a specified disease in ascending order.
// Category: Core Java / OOPs

import java.util.*;

public class Medicine_Inventory {
public static int[] getMedicineByDisease(medicine[] arr,String disease){
    List<Integer>list=new ArrayList<>();
    for(medicine m:arr){
        if(m.getDisease().equalsIgnoreCase(disease)){
            list.add(m.getPrice());
        }
    }
    if(list.isEmpty()) return  null;
    Collections.sort(list);
    int[] result=new int[list.size()];
    for(int i=0;i<list.size();i++){
        result[i]=list.get(i);
    }
    return result;
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        medicine[] meds=new  medicine[4];
        for(int i=0;i<4;i++){
            String name=sc.nextLine();
            String batch=sc.nextLine();
            String dis=sc.nextLine();
            int price=sc.nextInt();
            sc.nextLine();
            meds[i]=new medicine(name,batch,dis,price);
        }
        String targetDisease=sc.nextLine();
        int[] prices=getMedicineByDisease(meds,targetDisease);
        if(prices!=null){
            for(int p:prices){
                System.out.println(p);
            }
        }
        else {
            System.out.println("No medicine found");
        }
        sc.close();
    }
}

class  medicine{
    private  String medicineName;
    private  String batchNo;
    private  String disease;
    private  int price;
    public  medicine(String medicineName,String batchNo,String disease,int price){
        this.medicineName=medicineName;
        this.batchNo=batchNo;
        this.disease=disease;
        this.price=price;
    }
    public  String getMedicineName(){return medicineName;}
    public void setMedicineName(String medicineName){this.medicineName=medicineName;};
    public String getBatchNo(){return batchNo;}
    public void setBatchNo(String batchNo){this.batchNo=batchNo;}
    public  String getDisease(){return  disease;}
    public void setDisease(String disease){this.disease=disease;}
    public int getPrice(){return  price;}
    public void setPrice(int price){this.price=price;}
}
