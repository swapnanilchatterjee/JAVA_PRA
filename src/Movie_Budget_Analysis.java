// TCS PRA Practice: Movie Budget & Rating Analysis
// Description: Calculates average budget for a specified genre and sorts movies with rating above threshold in descending order of budget.
// Category: Core Java / OOPs

import java.util.*;
public class Movie_Budget_Analysis {
    public static int findAvgBudgetByGenre(Movie[] arr,String genre){
        int sum=0,count=0;
        for(Movie m:arr){
            if(m.getGenre().equalsIgnoreCase(genre)){
                sum+=m.getBudget();
                count++;
            }
        }
        return count>0?(sum/count):0;
    }
    public static Movie[] getMoviesByRatingSortedByBudget(Movie[] arr,int rating){
        List<Movie>list=new ArrayList<>();
        for(Movie m:arr){
            if(m.getRating()>=rating){
                list.add(m);
            }
        }
        if(list.isEmpty()) return  null;
        list.sort((a,b)->b.getBudget()-a.getBudget());
        return list.toArray(new Movie[0]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Movie[] movies=new Movie[4];
        for(int i=0;i<4;i++){
            String name=sc.nextLine();
            String company=sc.nextLine();
            String genre=sc.nextLine();
            int budget=sc.nextInt();
            int rating=sc.nextInt();
            sc.nextLine();
            movies[i]=new Movie(name,company,genre,budget,rating);
        }
        String searchGenre=sc.nextLine();
        int searchRating=sc.nextInt();
        int avg=findAvgBudgetByGenre(movies,searchGenre);
        if(avg>0) System.out.println(avg);
        else System.out.println("No such genre");
        Movie[] res=getMoviesByRatingSortedByBudget(movies,searchRating);
        if(res!=null){
            for(Movie m:res){
                System.out.println(m.getMovieName());
            }
        }
        else {
            System.out.println("No movies found");
        }
        sc.close();
    }
}
class Movie{
    private  String movieName;
    private String company;
    private String genre;
    private  int budget;
    private  int rating;
    public Movie(String movieName,String company,String genre,int budget,int rating){
        this.movieName=movieName;
        this.company=company;
        this.genre=genre;
        this.budget=budget;
        this.rating=rating;
    }
    public String getMovieName(){return movieName;}
    public String getCompany(){return company;}
    public String getGenre(){return genre;}
    public int getBudget(){return budget;}
    public int getRating(){return rating;}
}
