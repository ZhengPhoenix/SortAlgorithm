package phoenix.sortalgorithm.util;

/**
 * Created by zhenghui on 2017/2/13.
 * 堆排序
 */
public class HeapSort {

    /**
     *
     * @param numbers
     * @param ascend true, 升序
     */
    public static void sort(int[] numbers, boolean ascend) {
        if(numbers == null || numbers.length < 2) {
            return;
        }

        for(int i = 0; i < numbers.length - 1; i ++) {
            buildMaxHeap(numbers, numbers.length - i - 1, ascend);
            swap(numbers, 0, numbers.length - i - 1);
        }
    }

    /**
     * 建立最大堆，堆顶保持最大
     * @param numbers
     * @param lastIndex 最后一个叶节点
     * @param ascend
     */
    private static void buildMaxHeap(int[] numbers, int lastIndex, boolean ascend) {
        for(int index = ((lastIndex  - 1) / 2); index >= 0; index --){
            //k为当前遍历检验的父节点
            int k = index;

            //保证k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //当前检验的k的子节点，仅保留较大的index
                int biggerIndex = k * 2 + 1;

                //检验右子节点是否存在
                //因为建立的堆必须满足完全二叉树
                //所以当 < lastIndex 时必存在右节点
                //当 == lastIndex 时,lastIndex必为左节点
                if(biggerIndex < lastIndex) {
                    if(ascend) {
                        //升序排列
                        if(numbers[biggerIndex] < numbers[biggerIndex + 1]) {
                            //右节点较大
                            biggerIndex += 1;
                        }
                    } else {
                        //降序排列
                        if(numbers[biggerIndex] > numbers[biggerIndex + 1]) {
                            //右节点较小
                            biggerIndex += 1;
                        }
                    }
                }

                //比较父节点的值
                if(ascend) {
                    //升序排列
                    if(numbers[k] < numbers[biggerIndex]) {
                        swap(numbers, k, biggerIndex);
                        //更新父节点index为更换后的biggerIndex，进入子树的遍历判断
                        k = biggerIndex;
                    } else {
                        //没有发生变化，堆仍然满足最大堆
                        break;
                    }
                } else {
                    //降序排列
                    if(numbers[k] > numbers[biggerIndex]) {
                        swap(numbers, k, biggerIndex);
                        //更新父节点index为更换后的biggerIndex，进入子树的遍历判断
                        k = biggerIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
