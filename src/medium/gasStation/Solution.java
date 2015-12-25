package medium.gasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length != gas.length) {
            return -1;
        }

        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += (gas[i] - cost[i]);
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if(totalGas >= totalCost) {
            return start;
        }
        else {
            return -1;
        }
    }
}
