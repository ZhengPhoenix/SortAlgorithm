package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 * 归并排序
 */
public class MergeSort {
    private static final String TAG = "MergeSort";

    /**
     *
     * @param numbers
     * @param ascend true,升序排列
     */
    public static void sort(int[] numbers, boolean ascend) {
        if(numbers == null || numbers.length < 2) {
            return;
        }

        mergeSort(numbers, 0, numbers.length - 1, ascend);
    }

    private static void mergeSort(int[] numbers, int left, int right, boolean ascend) {
        int middle = (left + right) / 2;
        if(left < right) {
            mergeSort(numbers, left, middle, ascend);
            mergeSort(numbers, middle + 1, right, ascend);
            merge(numbers, left, middle, right, ascend);
        }
    }

    private static void merge(int[] numbers, int left, int middle, int right, boolean ascend) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = middle + 1;
        int index = 0;

        while (i <= middle && j <= right) {
            if(ascend) {
                if(numbers[i] < numbers[j]) {
                    temp[index++] = numbers[i++];
                } else {
                    temp[index++] = numbers[j++];
                }
            } else {
                if(numbers[i] > numbers[j]) {
                    temp[index++] = numbers[i++];
                } else {
                    temp[index++] = numbers[j++];
                }
            }
        }

        while (i <= middle) {
            temp[index++] = numbers[i++];
        }

        while (j <= right) {
            temp[index++] = numbers[j++];
        }

        for(int k = 0; k < index; k ++) {
            numbers[left + k] = temp[k];
        }
    }
}
