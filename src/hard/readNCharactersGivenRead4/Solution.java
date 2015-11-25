package hard.readNCharactersGivenRead4;

public class Solution extends Reader4{
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buffer = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] temp = new char[4];

        while(!eof && total < n) {
            int count = read4(temp);
            if(count < 4) {
                eof = true;
            }

            count = Math.min(count, n - total);

            for(int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }

        return total;
    }

    public int read2(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n) {
            if(buffPtr == 0) {
                buffCnt = read4(buffer);
            }

            if(buffCnt == 0) {
                break;
            }
            while(ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buffer[buffPtr++];
            }
            if(buffPtr >= buffCnt) {
                buffPtr = 0;
            }
        }
        return ptr;
    }
}
