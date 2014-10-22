import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
            for(int i = 0; i < N; i++) {
                        Integer key = in.nextInt();
                        Integer count = mapA.get(key);
                        if (count == null) {
                                        count = 1;
                                    }
                        else {
                                        count++;
                                    }
                        mapA.put(key, count); 
                    }
            int M = in.nextInt();
            TreeSet<Integer> res = new TreeSet<Integer>();
            
            for(int i = 0; i < M; i++) {
                        Integer num = in.nextInt();
                        Integer result = mapA.get(num);
                        if(result == null || result == 0) {
                                        res.add(num);
                                    }
                        else {
                                        result = result - 1;
                                        mapA.put(num, result);
                                    }
                    }
            Collections.sort(res);
            
            for(Integer i : res) {
                        System.out.print(i + " ");
                    }
        }
}
