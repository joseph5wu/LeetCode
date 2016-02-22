package airbnb.twoDArray;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        array.add(row1);

        List<Integer> row3 = new ArrayList<>();
        array.add(row3);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        array.add(row2);

//        Array2D<Integer> sol = new Array2D<>(array);
//        while (sol.hasNext()) {
//            int result = sol.next();
//            System.out.println(result);
//
//            if (result == 3) {
//                sol.remove();
//            }
//        }

        System.out.println();

        for (List<Integer> row : array) {
            for (Integer elem : row) {
                System.out.println(elem);
            }
        }

        Iterator<Integer> itr = row1.iterator();
        itr.next();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        System.out.println(row1);
    }

}

class Array2D<T>{
    int rowId;
    int colId;
    List<List<T>> array;

    public Array2D(List<List<T>> array) {
        this.rowId = 0;
        this.colId = 0;
        this.array = array;
    }

    public void add(List<T> list) {
        if(list != null && !list.isEmpty()) {
            array.add(list);
        }
    }

    public boolean hasNext() {
        if(array == null || array.isEmpty()) {
            return false;
        }
        // clear empty list
//        while(rowId < array.size() && (array.get(rowId) == null || array.get(rowId).isEmpty())) {
//            array.remove(rowId);
//            rowId++;
//        }

        return rowId < array.size();
    }

    public T next() {
        T value = array.get(rowId).get(colId++);
        if(colId == array.get(rowId).size()) {
            rowId++;
            colId = 0;
        }
        return value;
    }

    public void remove() {
        int removeRowId = -1;
        List<T> removeRow = null;
        if(colId == 0 && rowId > 0) {
            // need to delete previous row last element
            removeRowId = rowId - 1;
            removeRow = array.get(removeRowId);
            removeRow.remove(removeRow.size() - 1);
        }
        else {
            removeRowId = rowId;
            removeRow = array.get(removeRowId);
            removeRow.remove(colId - 1);
        }

        if(removeRow.isEmpty()) {
            array.remove(removeRowId);
            rowId--;
        }
        if(colId != 0) {
            colId--;
        }
    }
}
