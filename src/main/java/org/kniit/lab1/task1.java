package org.kniit.lab1;
public class task1 {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++){
      if (i != 100) {
        System.out.print(Integer.toString(i) + ", ");
      }
      else {
        System.out.print(Integer.toString(i));
      }
      if (i % 10 == 0){
        System.out.println();
      }
    }
  }
}
