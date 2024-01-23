import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[] { 1, 0, 0, 0, 1 };
        int n = 2;
        canPlaceFlowers(arr, n);
        System.out.println(canPlaceFlowers(arr, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        for (int i = 0; i < flowerbed.length; i++) {
            // [0, 0, 1]
            // [1, 0, 0]
            // [0, 0, 0]
            // [1, 0, 0, 0, 1]
            // We check that the current index is 0, and the index before and after is 0 aswell.
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                n--;

                if (n == 0) {
                    return true;
                }
                // If we set the current index to 1, then no need to check the index next to it 
                i++;
            }
        }
        return false;
    }
}
