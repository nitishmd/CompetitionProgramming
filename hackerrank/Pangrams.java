import java.util.Scanner;

public class Pangrams {

  public boolean isPangram(String s) {
    boolean[] alpha = new boolean[26];
    int count = 0;

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(Character.isLetter(c)) {
        int position = Character.toLowerCase(c) - 'a';
        if(alpha[position] == false) {
          // mark as true
          alpha[position] = true;
          count++;
        }
      } 
    }
    if(count == 26)
      return true;
    return false;
  }

  public static void main(String[] args) {
    Pangrams p = new Pangrams();
    Scanner s = new Scanner(System.in);

    while(s.hasNextLine()) {
      if(p.isPangram(s.nextLine())) {
        System.out.println("pangram");
      }
      else {
        System.out.println("not pangram");
      }
    }
  }
}
