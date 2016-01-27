package amazon;

import java.util.Arrays;

public class DaysChange {
    public int[] solution(int[] origin, int days) {
        if(origin == null || origin.length <= 1) {
            return origin;
        }

        int length = origin.length;
        // using a new extended array to calculate the changed value
        int[] temp = new int[length + 2];
        temp[0] = temp[length + 1] = 0;
        System.arraycopy(origin, 0, temp, 1, length);

        for(int i = 0; i < days; i++) {
            int pre = temp[0];
            for(int j = 1; j <= length; j++) {
                int preVal = temp[j];
                temp[j] = pre ^ temp[j + 1];
                pre = preVal;
            }
        }

        return Arrays.copyOfRange(temp, 1, length + 1);
    }

    public static void main(String[] args) {
        int[] origin = new int[]{1,0,0,0,0,1,0,0};
        DaysChange sol = new DaysChange();
        int[] changed = sol.solution(origin, 1);
        System.out.println(Arrays.toString(changed));
        changed = sol.solution(origin, 2);
        System.out.println(Arrays.toString(changed));
    }
}
