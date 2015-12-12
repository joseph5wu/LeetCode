package medium.courseSchedule;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if(numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        // store courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(pCounter[i] == 0) {
                queue.add(i);
            }
        }

        // number of courses that satisfy prerequisites
        int numSatisfy = queue.size();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == course) {
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] == 0) {
                        numSatisfy++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numSatisfy == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if(numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        int[] visited = new int[numCourses];

        Map<Integer, List<Integer>> dependsMap = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            if(!dependsMap.containsKey(prerequisite[0])) {
                dependsMap.put(prerequisite[0], new ArrayList<>());
            }
            dependsMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!canFinish2DFS(dependsMap, visited, course)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish2DFS(Map<Integer, List<Integer>> dependsMap, int[] visited, int course) {
        // course is depending on other courses
        if(visited[course] == -1) {
            return false;
        }
        // course is not depending on other courses
        if(visited[course] == 1) {
            return true;
        }

        visited[course] = -1;
        if(dependsMap.containsKey(course)) {
            for(int i : dependsMap.get(course)) {
                if(!canFinish2DFS(dependsMap, visited, i)) {
                    return false;
                }
            }
        }
        visited[course] = 1;
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if(prerequisites.length == 0) {
            int[] result = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        if(numCourses <= 0) {
            return new int[0];
        }

        int[] pCounter = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(pCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numSatisfy = queue.size();
        int j = 0;
        int[] results = new int[numCourses];
        while(!queue.isEmpty()) {
            int course = queue.poll();
            results[j++] = course;
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course) {
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] == 0) {
                        numSatisfy++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        if(numSatisfy == numCourses) {
            return results;
        }
        else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] prerequisites = {{1,0}, {2,1}};
        System.out.println(sol.canFinish(3, prerequisites));
    }
}
