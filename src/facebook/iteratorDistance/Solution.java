package facebook.iteratorDistance;

import java.util.*;

public class Solution {
    public boolean isDistanceZeroOrOne(Iterator<Integer> a, Iterator<Integer> b) {
        boolean isEqual = true;
        // find the first difference
        int prevA = 0, prevB = 0;
        while(a.hasNext() && b.hasNext()) {
            prevA = a.next();
            prevB = b.next();
            if(prevA != prevB) {
                isEqual = false;
                break;
            }
        }

        // check whether one iterator has more than 2 elements than the other
        if(isEqual) {
            if(a.hasNext()) {
                a.next();
            }
            if(b.hasNext()) {
                b.next();
            }
            return !a.hasNext() && !b.hasNext();
        }


        boolean changeA = true, insertA = true, removeA = true;
        int valA = 0, valB = 0;
        while(a.hasNext() && b.hasNext()) {
            valA = a.next();
            valB = b.next();
            changeA = changeA && (valA == valB);
            insertA = insertA && (prevA == valB);
            removeA = removeA && (valA == prevB);
            if(!changeA && !insertA && !removeA) {
                return false;
            }
            prevA = valA;
            prevB = valB;
        }

        if(changeA && !a.hasNext() && !b.hasNext()) {
            return true;
        }
        if(insertA && b.hasNext() && prevA == b.next() && !b.hasNext()) {
            return true;
        }
        if(removeA && a.hasNext() && a.next() == prevB && !a.hasNext()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(1);
        l2.add(2);
        Solution sol = new Solution();
        System.out.println(sol.isDistanceZeroOrOne(l1.iterator(), l2.iterator()));

        Set<List<Integer>> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        System.out.println(set.contains(l3));
        System.out.println(l1 == l3);
        System.out.println(l1.equals(l3));
    }
}
