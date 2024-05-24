import java.util.*;

public class primeMain {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("Type a positive integer to form a finite number system or type \"end\" to end the program");
      String ans = console.next();
      while (!ans.equalsIgnoreCase("end")) {
         try {
            int num = Integer.parseInt(ans);
            Prime number = new Prime(num);
            options();
            ans = console.next();
            while (ans.indexOf('6') < 0 && !ans.equalsIgnoreCase("end")) {
               HashMap<Integer, Integer> factorization = null;
               if (ans.indexOf('1') >= 0) {
                  factorization = showFactorization(number);
               } else if (ans.indexOf('2') >= 0) {
                  findPhi(factorization, number);
               } else if (ans.indexOf('3') >= 0) {
                  primitiveRoot(number);
               } else if (ans.indexOf('4') >= 0) {
                  System.out.println("Please type the order n(Please type Integer)");
                  int order = console.nextInt();
                  System.out.print("All number in this finite number system with order " + order + " are: ");
                  System.out.println(number.numberWithOrder(order).toString());
                  System.out.println();
               } else if (ans.indexOf('5') >= 0) {
                  factorization = showFactorization(number);
                  findPhi(factorization, number);
                  List<Integer> primitiveRoot = number.computePrimitiveRoot();
                  primitiveRoot(number);
                  System.out.println();
               }
               options();
               ans = console.next();
            }
            if (ans.equalsIgnoreCase("end")) {
               break;
            }
            System.out
                  .println("Type a positive integer to form a finite number system or type \"end\" to end the program");
            ans = console.next();
         } catch (Exception e) {
            System.out.println("Please enter an valid number");
            System.out
                  .println("Type a positive integer to form a finite number system or type \"end\" to end the program");
            ans = console.next();
         }

      }
      System.out.println("System ended");
   }

   public static void options() {
      System.out.println("Please choose what you want to do with this number");
      System.out.println("1: find prime factorization");
      System.out.println("2: find Euler's phi of this number");
      System.out.println("3: find all primitive roots of this number");
      System.out.println("4: find all numbers with order n");
      System.out.println("5: find all of the above");
      System.out.println("6: choose another number");
   }

   public static HashMap<Integer, Integer> showFactorization(Prime number) {
      HashMap<Integer, Integer> result = number.primeFactorization();
      System.out.println("the prime factorization is: " + number.factorizationToString(result));
      System.out.println();
      return result;
   }

   public static void findPhi(HashMap<Integer, Integer> factorization, Prime number) {
      int phi = 0;
      if (factorization != null) {
         phi = number.findPhi(factorization);
      } else {
         phi = number.findPhi();
      }
      System.out.println("The Euler's Phi of this number is: " + phi);
      System.out.println();
   }

   public static void primitiveRoot(Prime number) {
      List<Integer> primitiveRoot = number.computePrimitiveRoot();
      if (primitiveRoot.size() == 0) {
         System.out.println("This number does not have primitive roots");
      } else {
         System.out.println("All the primitive roots are: " + primitiveRoot.toString());
      }
      System.out.println();
   }
}
