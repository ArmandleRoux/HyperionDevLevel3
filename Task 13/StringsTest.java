import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringsTest {

  @Test
  public void testLength() {
    String sentence = "Hello World";

    assertTrue(length(sentence) == sentence.length());
    assertTrue(charAt(sentence, 2) == sentence.charAt(2));
    assertTrue(subString(sentence, 0, 4).equals(sentence.substring(0,4)));
    assertTrue(indexOf(sentence, 'l') == sentence.indexOf("l"));
  }

  public int length(String phrase) {
    char[] phraseArr = phrase.toCharArray();
    int total =0;
    for (char character : phraseArr) {
      total += 1;
    }
    return total;
  }

  public char charAt(String phrase, int index) {
    char[] phraseArr = phrase.toCharArray();
    return phraseArr[index];
  }

  public String subString(String phrase, int startIndex, int endIndex) {
    String subString = "";
    char[] phraseArr = phrase.toCharArray();
    for (int i = startIndex; i < endIndex; i++) {
      subString += phraseArr[i];
    }
    return subString;
  }

  public int indexOf(String phrase, char charToFind) {
    char[] phraseArr = phrase.toCharArray();
    int index = 0;
    for (char character : phraseArr) {
      if(character == charToFind) {
        return index;
      } else {
        index++;
      }
    }
    return index;
  }
}
