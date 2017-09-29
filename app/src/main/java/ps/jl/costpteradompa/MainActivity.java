package ps.jl.costpteradompa;

import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ps.jl.costpteradompa.Adapter.CustomAdapterList;
import ps.jl.costpteradompa.Model.ModelListItem;

public class MainActivity extends AppCompatActivity {
    //ตัวแปลในการทำงาน
    private CustomAdapterList adapterList;
    private List<ModelListItem> dataSet;
    private RecyclerView review;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เรียกใช้ RecyclerView
        review = (RecyclerView) findViewById(R.id.review);
        //เรียกใช้ ModelListItem
        dataSet = new ArrayList<>();
        //เรียกใช้ gridLayoutManager
        gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        //เรียกใช้ CustomAdapterList
        adapterList = new CustomAdapterList(dataSet,MainActivity.this);
        //set Adapter ลง RecyclerView
        review.setAdapter(adapterList);
        review.setLayoutManager(gridLayoutManager);
        review.setHasFixedSize(true);
        setAdapterList();

    }
    private void setAdapterList(){
        //จัดการเพิ่มข้อมมูล
        for (int i=0;i<=20;i++) {
            ModelListItem modelListItem = new ModelListItem();
            modelListItem.setF_Name("P"+i);
            modelListItem.setL_Name("L"+i);
            dataSet.add(modelListItem);
            adapterList.notifyDataSetChanged();
        }

    }
}
