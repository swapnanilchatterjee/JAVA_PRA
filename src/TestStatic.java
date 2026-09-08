// TCS PRA Practice: Static Keyword Demonstration
// Description: Demonstrates static initialization blocks, static variables (instance counter), static methods, and constructor execution order.
// Category: Core Java / OOPs

import java.util.*;
class Abc
{
  static int cnt=0;
  static {
      System.out.println("This is static block");
  }
  Abc(){
      System.out.println("This is constructor");
      cnt++;
  }
  static void display(){
      System.out.println(cnt);
  }
}

public class TestStatic {
    public static void main(String[] args) {
        Abc A1=new Abc();
        Abc A2=new Abc();
        Abc A3=new Abc();
        Abc.display();
    }
}
