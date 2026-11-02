// TCS PRA Practice: Book Library Management System
// Description: Finds the book with maximum pages for a given author and counts books with price greater than a given threshold.
// Category: Core Java / OOPs

import java.util.*;
public class Book_Library {
   public static book findBookWithMaxPagesByAuthor(book[] arr,String author){
       book maxBook=null;
       for(book c:arr){
           if(c.getAuthor().equalsIgnoreCase(author)){
               if(maxBook==null || c.getPages()> maxBook.getPages()){
                   maxBook=c;
               }
           }
       }
       return maxBook;
   }
   public  static int countBooksAbovePrice(book[] arr,double threshold){
       int count=0;
       for (book c:arr){
           if(c.getPrice()>threshold){
               count++;
           }
       }
       return  count;
   }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        book[] books=new book[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String title=sc.nextLine();
            String  author=sc.nextLine();
            double price=sc.nextDouble();
            int pages=sc.nextInt();
            sc.nextLine();
            books[i]=new book(id,title,author,price,pages);
        }
        String searchAuthor=sc.nextLine();
        double threshold=sc.nextDouble();

        book res=findBookWithMaxPagesByAuthor(books,searchAuthor);
        if(res!=null){
            System.out.println(res.getBookId());
            System.out.println(res.getTitle());
        }else {
            System.out.println("No such book");
        }
        int count=countBooksAbovePrice(books,threshold);
        if(count>0) System.out.println(count);
        else System.out.println("No book found");
        sc.close();
    }
}
class book{
    private  int bookId;
    private String title;
    private  String author;
    private double price;
    private  int pages;
    public book(int bookId,String title,String author,double price,int pages){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.price=price;
        this.pages=pages;
    }
    public int getBookId(){return bookId;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public  double getPrice(){return price;}
    public int getPages(){return pages;}
}
