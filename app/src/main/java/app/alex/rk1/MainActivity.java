package app.alex.rk1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int
            LIST_LENGTH = 100,
            NUMBER_RANGE_MAX = 10,
            NUMBER_RANGE_MIN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        NumbersRecycleViewAdapter adapter = new NumbersRecycleViewAdapter(
                this.getApplicationContext(), getList()
        );

        RecyclerView numbersRecyclerView = findViewById(R.id.numbers_recycle_view);
        numbersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        numbersRecyclerView.setAdapter(adapter);
    }

    private List<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < LIST_LENGTH ; i += 1) {
            list.add(
                    random.nextInt(NUMBER_RANGE_MAX + NUMBER_RANGE_MIN) - NUMBER_RANGE_MIN
            );
        }
        return list;
    }

}
