package airbnb.pagePosts;

import java.util.*;
public class Solution {
    public static List<List<String>> getPages(String[] posts, int pageSize) {
        List<List<String>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        Map<String, Integer> map = new HashMap<>();
        int currentPage = 0;
        for(String post : posts) {
            String id = getId(post);
            if(map.containsKey(id)) {
                // get last page id
                int newPageNum = map.get(id) + 1;
                if(newPageNum == results.size()) {
                    results.add(new ArrayList<>());
                }
                results.get(newPageNum).add(post);
                map.put(id, newPageNum);
            }
            else {
                map.put(id, currentPage);
                results.get(currentPage).add(post);
                if(results.get(currentPage).size() == pageSize) {
                    // update map remove those page # = currentPage
                    update(map, results.get(currentPage), currentPage);
                    currentPage++;
                    if(currentPage == results.size()) {
                        results.add(new ArrayList<>());
                    }
                }
            }
        }

        return results;
    }

    private static void update(Map<String, Integer> map, List<String> page, int currentPage) {
        for(String post : page) {
            String id = getId(post);
            if(map.containsKey(id) && map.get(id) == currentPage) {
                map.remove(id);
            }
        }
    }

    private static String getId(String post) {
        return post.substring(0, post.indexOf(","));
    }

    public static void main(String[] args) {
        String[] posts = new String[]{
                "1,28,300.1,SanFrancisco",

                "4,5,209.1,SanFrancisco",

                "20,7,208.1,SanFrancisco",

                "23,8,207.1,SanFrancisco",

                "16,10,206.1,Oakland",

                "1,16,205.1,SanFrancisco",

                "6,29,204.1,SanFrancisco",

                "7,20,203.1,SanFrancisco",

                "8,21,202.1,SanFrancisco",

                "2,18,201.1,SanFrancisco",

                "2,30,200.1,SanFrancisco",

                "15,27,109.1,Oakland",

                "10,13,108.1,Oakland",

                "11,26,107.1,Oakland",

                "12,9,106.1,Oakland",

                "13,1,105.1,Oakland",

                "22,17,104.1,Oakland",

                "1,2,103.1,Oakland",

                "28,24,102.1,Oakland",

                "18,14,11.1,SanJose",

                "6,25,10.1,Oakland",

                "19,15,9.1,SanJose",

                "3,19,8.1,SanJose",

                "3,11,7.1,Oakland",

                "27,12,6.1,Oakland",

                "1,3,5.1,Oakland",

                "25,4,4.1,SanJose",

                "5,6,3.1,SanJose",

                "29,22,2.1,SanJose",

        };

        List<List<String>> results = getPages(posts, 12);
        System.out.println(results);
    }
}
