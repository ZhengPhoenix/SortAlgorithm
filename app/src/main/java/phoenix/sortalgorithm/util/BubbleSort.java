package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 */
public class BubbleSort {

    /**
     * @param num
     * @param ascend true ascend 升序排列
     * @return
     */
    public static void sort(int[] num, boolean ascend) {
        if(num == null || num.length < 2) {
            return;
        }

        int length = num.length;

        int temp;

        for(int i = 0; i < length; i ++) {
            for (int j = i + 1; j < length; j ++) {
                if(ascend) {
                    //升序判断
                    if(num[i] > num[j]) {
                        temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                    }
                } else {
                    //降序判断
                    if(num[i] < num[j]) {
                        temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                    }
                }
            }
        }
    }
}
