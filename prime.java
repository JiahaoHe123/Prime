import java.util.ArrayList;
import java.util.HashMap;

public class prime {
  private int number;

  public prime(int num) {
    if (num <= 0) {
      throw new IllegalArgumentException();
    }
    this.number = num;
  }

  public HashMap<Integer, Integer> primeFactorization() {
    HashMap<Integer, Integer> nums = new HashMap<>();
    int power = 0;
    int num = number;
    for (int i = 2; i <= num; i++) {
      while (num % i == 0) {
        power++;
        if (nums.containsKey(i)) {
          nums.replace(i, power);
        } else {
          nums.put(i, power);
        }
        num = num / i;
      }
      power = 0;
    }
    return nums;
  }

  public String factorizationToString(HashMap<Integer, Integer> factorization) {
    String result = "";
    for (Integer key : factorization.keySet()) {
      result = result + "base: " + key + ", power: " + factorization.get(key) + "; ";
    }
    return result;
  }

  public int findPhi(HashMap<Integer, Integer> factorization) {
    int result = 1;
    for (Integer key : factorization.keySet()) {
      double power = factorization.get(key);
      double front = Math.pow((double) key, (double) power);
      double end = Math.pow((double) key, (double) power - 1);
      result = result * ((int) front - (int) end);
    }
    return result;
  }

  public int findPhi() {
    int result = 1;
    HashMap<Integer, Integer> factorization = primeFactorization();
    for (Integer key : factorization.keySet()) {
      double power = factorization.get(key);
      double front = Math.pow((double) key, (double) power);
      double end = Math.pow((double) key, (double) power - 1);
      result = result * ((int) front - (int) end);
    }
    return result;
  }

  public ArrayList<Integer> computePrimitiveRoot() {
    ArrayList<Integer> result = new ArrayList<>();
    int n = number;
    int phi = findPhi();
    for (int i = 2; i < n; i++) {
      int power = 1;
      int num = i;
      while (((num * i) % n != 1 && (num * i) % n != 0) && power <= phi) {
        num = (num * i) % n;
        power++;
      }
      if (power == phi - 1) {
        result.add((int) i);
      }
      power = 1;
    }
    return result;
  }

  public ArrayList<Integer> numberWithOrder(int order) {
    if (order > number) {
      throw new IllegalArgumentException();
    }
    if (order == 1) {
      ArrayList<Integer> result = new ArrayList<>();
      result.add(1);
      return result;
    }
    ArrayList<Integer> result = new ArrayList<>();
    int n = number;
    int phi = order;
    for (int i = 2; i < n; i++) {
      int power = 1;
      int num = i;
      while (((num * i) % n != 1 && (num * i) % n != 0) && power <= phi) {
        num = (num * i) % n;
        power++;
      }
      if (power == phi - 1) {
        result.add((int) i);
      }
      power = 1;
    }
    return result;
  }

}