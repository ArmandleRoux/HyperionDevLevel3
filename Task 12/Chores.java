import java.util.ArrayList;
import java.util.Collections;

public class Chores {

  static ArrayList<String> names = new ArrayList<>();
  static ArrayList<String> chores = new ArrayList<>();

  public static void main(String[] args) {

    // Initialise lists.
    Collections.addAll(names, "David", "Johnny", "Peter", "Richard", "Victor");
    Collections.addAll(chores, "Sweep", "Mop", "Dust", "Take out trash", "Clean Toilets");

    // Shuffle list to give random output.
    Collections.shuffle(chores);
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i) + ": " + chores.get(i));
    }

  }



}
