public class primeMain {
  public static void main(String[] args) {
    Prime number = new Prime(32);
//     HashMap<Integer, Integer> factorization = number.primeFactorization();
//     int phi = number.findPhi(factorization);
    System.out.println(number.numberWithOrder(32).toString());
//     System.out.println(number.computePrimitiveRoot().toString());
  }
}
