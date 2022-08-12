package Challenges;

public class ContainerWithMostWater {
    private int area;
    private int[] height;

    public int maxArea(int[] height) {
        this.height = height;
        int left = 0;
        int right = height.length - 1;
        updateArea(left, right);

        while (left < right) {
            if (height[left] < height[right]) {
                updateArea(++left, right);
            } else {
                updateArea(left, --right);
            }
        }

        return area;
    }

    private void updateArea(int left, int right) {
        area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
    }
}
