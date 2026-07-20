import java.util.*;
public class reverseword {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] words=sc.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i>0) sb.append(" ");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
