package easy.nimGame;

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

 在初始状态一定的情况下，博弈的结果不是必胜就是必败，所以必败的状态就是剩余4个石子的情况，同样4的倍数都是必败的。
 关键要推导出必胜或必败的公式
 */
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}
