package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 */
public class SelectSort {

    public static void sort(int[] numbers, boolean ascend) {
        if (numbers == null || numbers.length < 2) {
            return;
        }

        for(int i = 0; i < numbers.length; i ++) {

            //记录当前选择位置
            int k = i;
            for(int j = numbers.length - 1; j > i; j--) {
                if(ascend) {
                    //升序
                    if(numbers[j] < numbers[k]) {
                        k = j;
                    }
                } else {
                    //降序
                    if(numbers[j] > numbers[k]) {
                        k = j;
                    }
                }
            }

            //swap
            int temp = numbers[k];
            numbers[k] = numbers[i];
            numbers[i] = temp;
        }
    }
}
