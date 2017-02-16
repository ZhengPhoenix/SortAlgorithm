package phoenix.sortalgorithm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import phoenix.sortalgorithm.R;
import phoenix.sortalgorithm.util.BubbleSort;
import phoenix.sortalgorithm.util.HeapSort;
import phoenix.sortalgorithm.util.InsertSort;
import phoenix.sortalgorithm.util.MergeSort;
import phoenix.sortalgorithm.util.QuickSort;
import phoenix.sortalgorithm.util.SelectSort;

public class SortAlgorithmMainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] numbers;
    private TextView mTvOriginal;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_algorithm_main);

        mTvOriginal = (TextView) findViewById(R.id.tv_sample);
        mTvResult = (TextView) findViewById(R.id.tv_result);

        ((Button) findViewById(R.id.btn_bubble)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_heap)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_insert)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_merge)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_quick)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_select)).setOnClickListener(this);

        initData();
    }

    private void initData() {
        String sample = mTvOriginal.getText().toString();
        String[] samples = sample.split(",");
        int length = samples.length;
        numbers = new int[length];
        for(int i = 0; i < samples.length; i ++) {
            numbers[i] = Integer.valueOf(samples[i]);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_bubble) {
            BubbleSort.sort(numbers, true);
        } else if(v.getId() == R.id.btn_heap) {
            HeapSort.sort(numbers, true);
        } else if(v.getId() == R.id.btn_insert) {
            InsertSort.sort(numbers, true);
        } else if(v.getId() == R.id.btn_merge) {
            MergeSort.sort(numbers, true);
        } else if(v.getId() == R.id.btn_quick) {
            QuickSort.sort(numbers, true);
        } else if(v.getId() == R.id.btn_select) {
            SelectSort.sort(numbers, true);
        }
        setText();
        initData();
    }

    private void setText() {
        StringBuilder builder = new StringBuilder();

        for(int value : numbers) {
            builder.append(String.valueOf(value)).append(",");
        }

        mTvResult.setText(builder.toString());
    }
}
