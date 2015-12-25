package medium.permutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // create a list of numbers to get indices
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;
        for(int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }
}
