package amazon;

import java.util.LinkedList;
import java.util.Queue;
import commons.models.Process;

public class RoundRobinScheduling {

    public float averageWaitTime(int[] aTime, int[] eTime, int q) {
        if(aTime == null || eTime == null || aTime.length != eTime.length) {
            return 0;
        }

        int processCount = aTime.length;
        Queue<Process> queue = new LinkedList<>();
        int index = 0;
        int curTime = 0;
        int waitTime = 0;
        while(!queue.isEmpty() || index < processCount) {
            if(!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += Math.min(cur.executeTime, q);
                // add all arriveTime is less than curTime to queue to wait for processing
                while(index < processCount && aTime[index] <= curTime) {
                    queue.offer(new Process(aTime[index], eTime[index]));
                    index++;
                }
                // if current process not finished yet, need to add back to queue as a new process
                if(cur.executeTime > q) {
                    queue.offer(new Process(curTime, cur.executeTime - q));
                }
            }
            else {
                queue.offer(new Process(aTime[index], eTime[index]));
                index++;
            }
        }

        return (float) waitTime / processCount;
    }
}


