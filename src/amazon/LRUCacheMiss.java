package amazon;

import java.util.LinkedList;
import java.util.List;

public class LRUCacheMiss {
    public int solution(int[] inputs, int size) {
        if(inputs == null || inputs.length == 0) {
            return 0;
        }

        int count = 0;
        List<Integer> list = new LinkedList<>();
        for(int input : inputs) {
            if(list.contains(input)) {
                list.remove(list.indexOf(input));
            }
            else {
                count++;
                if(list.size() == size) {
                    list.remove(0);
                }
            }
            list.add(input);
        }

        return count;
    }
}
