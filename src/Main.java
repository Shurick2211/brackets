import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static Set<String> rezult = new HashSet<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter N: ");
    int n = scanner.nextInt();
    // A number(pair brackets) i+1 has differences of i: add () left of i; add () right of i; add () around i
    // We make iterations N times and update Set, that we used to get unique values.
    for(int i = 0; i<n; i++) {
      update(rezult);
    }
    //rezult.forEach(System.out::println);

    // Size of Set shows the number of unique values
    System.out.println("Answer: "+rezult.size());
  }

  /**
   * Make operation to change rezult Set in a iteration
   * @param update - Set<String>
   */
  private static void update(Set<String> update) {
    Set<String> set = new HashSet<>();
    if(update.isEmpty()) {
      set.add(around(""));
      set.add(left(""));
      set.add(right(""));
    }
    else update.forEach(u -> {
      set.add(around(u));
      set.add(left(u));
      set.add(right(u));
    });
    rezult = set;
  }

  /**
   * Make operation to add () around of input String
   * @param in String
   * @return new String
   */
  private static String around(String in) {
    return new StringBuilder().append("(").append(in).append(")").toString();
  }

  /**
   * Make operation to add () left of input String
   * @param in String
   * @return new String
   */
  private static String left(String in) {
    return new StringBuilder().append("(").append(")").append(in).toString();
  }

  /**
   * Make operation to add () right of input String
   * @param in String
   * @return new String
   */
  private static String right(String in) {
    return new StringBuilder().append(in).append("(").append(")").toString();
  }
}
