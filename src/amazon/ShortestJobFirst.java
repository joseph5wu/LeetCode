package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import commons.models.Process;

public class ShortestJobFirst {
    public float solution(int[] requestTime, int[] duration) {
        if(requestTime == null || duration == null || requestTime.length != duration.length) {
            return 0;
        }

        PriorityQueue<Process> queue = new PriorityQueue<> (new Comparator<Process>(){
            public int compare(Process p1, Process p2) {
                if(p1.executeTime == p2.executeTime) {
                    return p1.arriveTime - p2.arriveTime;
                }
                return p1.executeTime - p2.executeTime;
            }
        });

        int curTime = 0;
        int waitTime = 0;
        int index = 0;
        int processCount = requestTime.length;
        while(!queue.isEmpty() || index < processCount) {
            if(!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += cur.executeTime;
                while(index < processCount && requestTime[index] <= curTime) {
                    queue.offer(new Process(requestTime[index], duration[index]));
                    index++;
                }
            }
            else {
                queue.offer(new Process(requestTime[index], duration[index]));
                index++;
            }
        }

        return (float) waitTime / processCount;
    }
}
