package amazon;

public class ArithmeticSlice {
    public int solution(int[] array) {
        if(array == null || array.length < 3) {
            return 0;
        }

        int result = 0;
        int gap = array[1] - array[0];
        int length = 2;
        for(int i = 1; i < array.length - 1; i++) {
            if(array[i + 1] - array[i] == gap) {
                length++;
            }
            else {
                gap = array[i + 1] - array[i];
                if(length >= 3) {
                    result += (length - 1) * (length - 2) / 2;
                }
                if(result > 1000000000) {
                    return -1;
                }
                length = 2;
            }
        }

        if(length >= 3) {
            result += (length - 1) * (length - 2) / 2;
        }
        return result;
    }
}
