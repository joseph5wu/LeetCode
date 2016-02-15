package airbnb.cidr;

public class Solution {
    public static String cidr(String ip, int num) {
        String[] ipSeg = ip.split("\\.");
        int total = 0;
        int segNum = 1;
        for (int i = ipSeg.length - 1; i >= 0; i--) {
            int seg = Integer.parseInt(ipSeg[i]);
            // find the highest 1 of the seg
            int end = seg + num / segNum;
            if (end <= 255) {
                int times = 128;
                while ((seg & times) == (end & times)) {
                    total++;
                    times >>= 1;
                }
                total += 8 * i;
                break;
            } else {
                num = end;
            }
            segNum *= 256;
        }
        return ip + "/" + total;
    }

    public static void main(String[] args) {
        System.out.println(cidr("1.1.1.1", 400));
    }
}
