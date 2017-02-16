package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 */
public class InsertSort {

    /**
     * @param numbers
     * @param ascend  true 升序排列
     */
    public static void sort(int[] numbers, boolean ascend) {
        if (numbers == null || numbers.length < 2) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {

            int temp = numbers[i];
            int j;
            if (ascend) {
                for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                    //升序排列
                    numbers[j] = numbers[j - 1];
                }
            } else {
                for (j = i; j > 0 && temp > numbers[j - 1]; j--) {
                    //降序排列
                    numbers[j] = numbers[j - 1];
                }
            }

            numbers[j] = temp;
        }
    }
}
