// TCS PRA Practice: Course Administration System
// Description: Calculates average fees by course administrator and sorts courses by fee for ratings within a threshold.
// Category: Core Java / OOPs

import java.util.*;
public class Course_Administration {
    public static int findAvgFeeByAdmin(course[] arr,String admin){
        int sum=0,count=0;
        for(course c:arr){
            if(c.getCourseAdmin().equalsIgnoreCase(admin)){
                sum+=c.getFee();
                count++;
            }
        }
        return count>0?(sum/count):0;
    }
    public static course[] sortCourseByFee(course[] arr,int ratingThreshold){
        List<course>list=new ArrayList<>();
        for(course c:arr){
            if(c.getRating()<=ratingThreshold){
                list.add(c);
            }
        }
        if(list.isEmpty()) return  null;
        list.sort((a,b)->a.getFee()-b.getFee());
        return list.toArray(new course[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        course[] courses=new course[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String cName=sc.nextLine();
            String cAdmin=sc.nextLine();
            int fee=sc.nextInt();
            int rating=sc.nextInt();
            sc.nextLine();
            courses[i]=new course(id,cName,cAdmin,fee,rating);
        }
        String targetAdmin=sc.nextLine();
        int targetRating=sc.nextInt();
        int avg=findAvgFeeByAdmin(courses,targetAdmin);
        if(avg>0) System.out.println(avg);
        else System.out.println("No Such Courses");

        course[] res=sortCourseByFee(courses,targetRating);
        if(res!=null){
            for(course c:res) System.out.println(c.getCourseName());
        }
        else {
            System.out.println("No Certificate found");
        }
        sc.close();
    }
}

class  course{
    private int courseId;
    private  String courseName;
    private  String courseAdmin;
    private int fee;
    private int rating;

    public course(int courseId,String courseName,String courseAdmin,int fee,int rating){
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.fee=fee;
        this.rating=rating;
    }
    public int getCourseId(){return courseId;}
    public  void setCourseId(int courseId){this.courseId=courseId;}
    public  String getCourseName(){return courseName;}
    public void setCourseName(String courseName){this.courseName=courseName;}
    public String getCourseAdmin(){return courseAdmin;}
    public void setCourseAdmin(String courseAdmin){this.courseAdmin=courseAdmin;}
    public int getFee(){return fee;}
    public void setFee(int fee){this.fee=fee;}
    public int getRating(){return  rating;}
    public void setRating(int rating){this.rating=rating;}
}
