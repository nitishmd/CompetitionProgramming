import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static String check(ArrayList<Integer> A, ArrayList<Integer> B, int K, int N) { 
            for(int i = 0, j = N-1; i < N; i++, j--) {
                        if(A.get(i) + B.get(j) < K) {
                                        return "NO";
                                    }
                    }
            return "YES";
        }

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            
            int T = in.nextInt();
            String[] result = new String[T];
            
            for(int i = 0; i < T; i++) {
                        int N = in.nextInt();
                        int K = in.nextInt();
                        ArrayList<Integer> A = new ArrayList<Integer>();
                        ArrayList<Integer> B = new ArrayList<Integer>();
                        
                        for(int j = 0; j < N; j++) {
                                        A.add(in.nextInt());
                                    }
                        for(int j = 0; j < N; j++) {
                                        B.add(in.nextInt());
                                    }
                        Collections.sort(A);
                        Collections.sort(B);
                        result[i] = check(A, B, K, N);
                    }
            
            for(int i = 0; i < T; i++) {
                        System.out.println(result[i]);
                    }
        }
}
