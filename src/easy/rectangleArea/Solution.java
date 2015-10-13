package easy.rectangleArea;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 判断x轴是否有交点
        if(C < E || A > G) {
            return (C - A) * (D - B) + (G - E) * (H - F);
        }
        // 判断y轴是否有交点
        if(D < F || B > H) {
            return (C - A) * (D - B) + (G - E) * (H - F);
        }

        // 求出交点所在位置
        int leftX = Math.max(A, E);
        int rightX = Math.min(C, G);
        int leftY = Math.max(B, F);
        int rightY = Math.min(D, H);
        return (C - A) * (D - B) + (G - E) * (H - F) - (rightX - leftX) * (rightY - leftY);
    }
}
