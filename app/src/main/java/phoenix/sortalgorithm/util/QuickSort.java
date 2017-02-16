package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 */
public class QuickSort {

    /**
     *
     * @param numbers
     * @param ascend true, ascend
     * @return
     */
    public static void sort(int[] numbers, boolean ascend) {
        if(numbers == null || numbers.length < 2) {
            return;
        }

        quickSort(numbers, 0, numbers.length - 1, ascend);
    }

    public static void quickSort(int[] numbers, int low, int high, boolean ascend) {
        if(low < high) {
            int middle = sort(numbers, low, high, ascend);
            //排序中轴左边数组
            quickSort(numbers, low, middle - 1, ascend);
            //排序种种右边数组
            quickSort(numbers, middle + 1, high, ascend);
        }
    }

    /** 对numbers做单次排序 */
    public static int sort(int[] numbers, int low, int high, boolean ascend) {
        int temp = numbers[low];

        while (low < high) {

            if(ascend) {
                //升序排列
                while(low < high && numbers[high] > temp) {
                    high --;
                }
                numbers[low] = numbers[high];

                while(low < high && numbers[low] < temp) {
                    low ++;
                }
                numbers[high] = numbers[low];
            } else {
                //降序排列
                while(low < high && numbers[high] < temp) {
                    high --;
                }
                numbers[low] = numbers[high];

                while(low < high && numbers[low] > temp) {
                    low ++;
                }
                numbers[high] = numbers[low];
            }
        }
        numbers[low] = temp;

        return low;
    }
}
