package commons.models;

public class Process {
    public int arriveTime;
    public int executeTime;

    public Process(int arriveTime, int executeTime) {
        this.arriveTime = arriveTime;
        this.executeTime = executeTime;
    }
}
