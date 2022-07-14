import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

  // Main method
  public static void main(String[] args) {

    // Declare ArrayList and add values
    ArrayList<String> words = new ArrayList<>();
    Collections.addAll(words, "right", "subdued", "trick", "crayon", "punishment", "silk", "describe",
            "royal", "prevent", "slope");

    // Use sort method
    bubbleSort(words);

    // Print Values of List to console.
    for (int i = 0; i < words.size(); i++) {
      if( i != words.size()-1) {
        System.out.print(words.get(i) + ", ");
      } else {
        System.out.print(words.get(i));
      }
    }
  }

  /* Bubble sort method
     Compared each value with all the other values
     if the next value is smaller the values switch places. */
  static void bubbleSort(ArrayList<String> stringList) {
    for (int i = (stringList.size() - 1); i >= 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (stringList.get(j - 1).compareTo(stringList.get(j)) > 0) {
          String temp = stringList.get(j - 1);
          stringList.set(j - 1, stringList.get(j));
          stringList.set(j, temp);
        }
      }
    }
  }

}
