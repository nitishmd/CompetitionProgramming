import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int calcFairness(ArrayList<Integer> nums, int K) {
            int i = 0;
            int j = K - 1;
            int minFair = Integer.MAX_VALUE;
            
            while (j < nums.size()) {
                        int min = nums.get(i);
                        int max = nums.get(j);
                        int currMin = max - min;
                       
                        if (currMin < minFair)
                            minFair = currMin;
                        
                        i++;
                        j++;
                    }
            return minFair;
        }

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int K = in.nextInt();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            
            for (int i = 0 ; i < N ; i++) {
                        nums.add(in.nextInt());
                    }
            
            Collections.sort(nums);
            int min = calcFairness(nums, K);
            
            System.out.println(min);
        }
}
