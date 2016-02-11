package facebook.taskScheduler;

import java.util.*;

public class Solution {
    public int countSlot(int[] tasks, int coolTime) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        // using a map to mark down when task is put in
        Map<Integer, Integer> map = new HashMap<>();
        int slots = 0;
        for (int task : tasks) {
            if (map.containsKey(task) && map.get(task) + coolTime + 1 > slots) {
                slots = map.get(task) + coolTime + 1;
            }
            map.put(task, slots++);
        }

        return slots;
    }

    public String schedule(int[] tasks, int coolTime) {
        if (tasks == null || tasks.length == 0) {
            return "";
        }

        // using a map to mark down when task is put in
        Map<Integer, Integer> map = new HashMap<>();
        int slots = 0;
        StringBuilder sb = new StringBuilder();
        for (int task : tasks) {
            if (map.containsKey(task) && map.get(task) + coolTime + 1 > slots) {
                while(slots++ != map.get(task) + coolTime + 1) {
                    sb.append("_, ");
                }
            }
            map.put(task, slots++);
            sb.append(task).append(", ");
        }

        return sb.toString().substring(0, sb.length() - 2);
    }

//    public static void main(String[] args) {
//        int[] tasks = new int[]{1, 2, 1, 1, 3, 4};
//        Solution sol = new Solution();
//        System.out.println(sol.countSlot(tasks, 2));
//        System.out.println(sol.schedule(tasks, 2));
//    }

    public int getTimeSlots(int[] nums, int coolTime) {
        if(nums == null || nums.length == 0 || coolTime < 0) {
            return 0;
        }

        int slots = 0;
        // key = num, value = last slot
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num) && slots - map.get(num) < coolTime + 1) {
                slots = map.get(num) + coolTime + 1;
            }
            map.put(num, slots++);
        }

        return slots;
    }

    public String getShortest(int[] nums, int coolTime) {
        StringBuilder sb = new StringBuilder();
        if(nums == null || nums.length == 0 || coolTime < 0) {
            return sb.toString();
        }

        // sort the nums the number of which num is bigger the num will be at front
        sort(nums);

        int slots = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num) && slots - map.get(num) < coolTime + 1) {
                while(slots < map.get(num) + coolTime + 1) {
                    sb.append("_");
                    slots++;
                }
            }
            map.put(num, slots++);
            sb.append(num);
        }

        return sb.toString();
    }

    private void sort(int[] nums) {
        // count the tasks times
        Map<Integer, Integer> times = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(!times.containsKey(num)) {
                times.put(num, 1);
            }
            else {
                times.put(num, times.get(num) + 1);
            }
        }

        // based on the times sort the task
        List<Map.Entry<Integer, Integer>> timeSet = new ArrayList<>(times.entrySet());
        Collections.sort(timeSet, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });

        int i = 0;
        int tasksCount = timeSet.size();
        for(Map.Entry<Integer, Integer> entry : timeSet) {
            int j = i, counts = entry.getValue();
            while(j < nums.length && counts > 0) {
                nums[j] = entry.getKey();
                j += j + tasksCount < nums.length ? tasksCount : 1;
                counts--;
            }
            i++;
        }
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        int[] nums = {0,0,0,0,1,1,2,2};
        System.out.println(sol.getTimeSlots(nums, 2));
        System.out.println(sol.getShortest(nums, 2));
    }
}
