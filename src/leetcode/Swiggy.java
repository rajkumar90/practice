package leetcode;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'connectedCities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER g
     *  3. INTEGER_ARRAY originCities
     *  4. INTEGER_ARRAY destinationCities
     */

    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < originCities.size(); i++) {
            int gcd = gcd(originCities.get(i), destinationCities.get(i));
            if (gcd > g)
            result.add(1);
            else
            result.add(0); 
        }

        return result;
    }

}