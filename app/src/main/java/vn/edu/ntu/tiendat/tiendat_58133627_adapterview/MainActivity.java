package vn.edu.ntu.tiendat.tiendat_58133627_adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lvTinhThanh;
    GridView gvDaily;
    AutoCompleteTextView acYear;
    ArrayAdapter<String> adapterTinhThanh, adapterDaily, adapterYear;
    String[] dsTinhThanh, dsDaily, dsYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = adapterTinhThanh.getItem(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + message, Toast.LENGTH_SHORT).show();
            }
        });

        gvDaily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String messagedaily = adapterDaily.getItem(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + messagedaily, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addViews() {
        lvTinhThanh = findViewById(R.id.lvTinhThanh);
        dsTinhThanh = getResources().getStringArray(R.array.tinh_thanh);
        adapterTinhThanh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsTinhThanh);
        lvTinhThanh.setAdapter(adapterTinhThanh);

        gvDaily = findViewById(R.id.gvDaily);
        dsDaily = getResources().getStringArray(R.array.daily);
        adapterDaily = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsDaily);
        gvDaily.setAdapter(adapterDaily);

        acYear = findViewById(R.id.acYear);
        dsYear = getResources().getStringArray(R.array.year);
        adapterYear = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsYear);
        acYear.setAdapter(adapterYear);
    }
}
