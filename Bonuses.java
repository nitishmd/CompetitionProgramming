/*
 * Author: Nitish Devadiga
 * Description: TopCoder SRM 145 Div 1 250
 */

import java.util.*;
import java.util.Arrays.*;

public class Bonuses {

  public int[] getDivision(int[] points) {
    int sum = 0;
    Map<Integer, Integer> position = new HashMap<Integer, Integer>();
    int[] percent = new int[points.length];
    int percentUnused = 100;

    for(int i = 0; i < points.length; i++) {
      sum = sum + points[i];
      position.put(points[i], i);
    }

    for(int i = 0; i < points.length; i++) {
      percent[i] = (int) ((points[i] * 100) / sum);
      System.out.println("Percent: "+percentUnused);
      percentUnused = percentUnused - percent[i];
    }

    // Now pick top N = percentUnused elements
    // Sorts in ascending order
    Arrays.sort(points);
    int pt_len = points.length - 1;
    for(int i = 0; i < percentUnused; i++) {
      int max_index = position.get(points[pt_len - i]);
      percent[max_index] = percent[max_index] + 1;
    }
    return percent;
  }

  /*public static void main(String[] args) {
    int[] test = {1,2,3,4,5};
    Bonuses b = new Bonuses();
    int[] result = b.getDivision(test);
    for(int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }*/
}
