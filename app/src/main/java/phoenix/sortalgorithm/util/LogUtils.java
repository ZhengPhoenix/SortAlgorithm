package phoenix.sortalgorithm.util;

import android.util.Log;

/**
 * Created by zhenghui on 2017/2/14.
 */
public class LogUtils {

    public static void printInteger(int numbers[], String TAG) {
        if(numbers == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();

        for(Integer value : numbers) {
            builder.append(String.valueOf(value)).append(",");
        }

        Log.d(TAG, " :" + builder.toString());
    }
}
