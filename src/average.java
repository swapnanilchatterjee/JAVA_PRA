// TCS PRA Practice: Average of N Numbers
// Description: Computes the mathematical average of N inputs and formats the output to 2 decimal places.
// Category: Basic Mathematics

import java.util.*;

public class average{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=sc.nextInt();
        }
        double avg=(double)sum/n;
        System.out.printf("%.2f%n",avg);
        sc.close();
    }

}