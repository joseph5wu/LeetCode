package airbnb.orderMeal;

import java.util.*;
public class Solution {
    public static List<List<Integer>> solutions(int[] meals, int money) {
        if(meals == null || meals.length == 0 || money <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(meals);
        // using dp
        List<List<List<Integer>>> dp = new ArrayList<>();
        List<List<Integer>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        dp.add(empty);
        for(int i = 1; i <= money; i++) {
            for(int meal : meals) {
                if(i < meal) {
                    break;
                }
                if(dp.get(i - meal) != null) {
                    if(dp.size() == i) {
                        dp.add(new ArrayList<>());
                    }
                    for(List<Integer> comb : dp.get(i - meal)) {
                        List<Integer> newComb = new ArrayList<>(comb);
                        newComb.add(meal);
                        dp.get(i).add(newComb);
                    }
                }
            }
            if(dp.size() == i) {
                dp.add(null);
            }
        }
        return dp.get(dp.size() - 1);
    }

    public static void main(String[] args) {
        int[] meals = {5, 2, 1};
        System.out.println(solutions(meals, 10));
    }
}
