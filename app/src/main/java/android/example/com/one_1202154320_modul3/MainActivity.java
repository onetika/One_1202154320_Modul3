package android.example.com.one_1202154320_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Water> mWaterData; //buat inisialisasi array
    private WaterAdapter mAdapter; //buat inisialisasi adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the RecyclerView
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Initialize the ArrayList that will contain the data
        mWaterData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext()); //inisialisasi adapter untuk recycleView
        mRecyclerView.setLayoutManager(mLayoutManager);      //menghubungkan adapter dan layout
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //buat inisilaisasi awalnya itu orientasi potrait = 1
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount)); //buat mengatur jika dilandscape

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                int from = viewHolder.getAdapterPosition(); //buat inisialisasi si posisi gambarnya
                int to = target.getAdapterPosition();

                Collections.swap(mWaterData, from, to); //buat swap si waterdata
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                mWaterData.remove(viewHolder.getAdapterPosition()); //hapus cardview

                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition()); //memberitahu adapter cardview terhapus
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] waterList = getResources().getStringArray(R.array.air_titles);
        String[] waterInfo = getResources().getStringArray(R.array.air_info);
        TypedArray waterImageResources = getResources().obtainTypedArray(R.array.air_images);
        //Clear the existing data (to avoid duplication)
        mWaterData.clear();

        // and information about each sport
        for(int i=0; i<waterList.length; i++){
            mWaterData.add(new Water(waterList[i], waterInfo[i],
                    waterImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        waterImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }


    public void resetWater(View view) {
        initializeData();
    }
}
