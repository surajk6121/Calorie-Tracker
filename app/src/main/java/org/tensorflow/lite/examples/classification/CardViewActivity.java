

package org.tensorflow.lite.examples.classification;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class CardViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    Timer timer;
    protected String s1,s2,s3,s1cal,s2cal,s3cal;
    //SharedPreferences mSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        Map< String,String> hm =
                new HashMap< String,String>();
        hm.put("Orange","200");
        //hmcal.put("")
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        s3 = b.getString("s3");
        s2 = b.getString("s2");
        s1 = b.getString("s1");
        //s1cal="200";
        //s2cal="125";
        hm.put("Cucumber", "45");
        hm.put("FrenchFries", "395");
        hm.put("Pizza", "190");
        hm.put("AlooParantha", "154");
        hm.put("Apple", "520");
        hm.put("Banana", "403");
        hm.put("Biryani", "210");
        hm.put("Burger", "240");
        hm.put("CholeBhature", "443");
        hm.put("CocaCola", "90");
        hm.put("Coffee", "35");
        hm.put("Dosa", "106");

        hm.put("Doughnut", "226");
        hm.put("Egg", "73");
        hm.put("Grapes", "670");
        hm.put("Idli", "39");
        hm.put("Momos", "35");
        hm.put("Noodles", "380");
        hm.put("PlainRice", "252");
        hm.put("Samosa", "262");
        hm.put("Sandwich", "204");
        hm.put("TandooriChicken", "350");
        hm.put("GulabJamun", "150");
        hm.put("Jalebi", "108");
        hm.put("Utpam", "257.4");
        hm.put("Upma", "54");
        hm.put("Cookies", "405");
        hm.put("KajuKatli", "58");
        hm.put("Rajma", "190");
        hm.put("Boondiladdoo", "185");
        hm.put("Aloogobhi", "108");
        hm.put("Tacos", "160");
        hm.put("Rasmalai", "160");
        hm.put("ChillyPotato", "126");
        hm.put("scram", "327");
        hm.put("Dhokla", "80");
        hm.put("Rasgulla", "100");
        hm.put("Imarti", "500");
        hm.put("Chapati", "130");
        hm.put("Nutella", "45");
        hm.put("Cherry", "63");
        hm.put("Beer", "100");
        hm.put("Guava", "112");
        hm.put("Strawberry", "0.32");
        hm.put("Bhindi", "330");
        hm.put("FishFry", "688");
        hm.put("Manchurian", "183.4");
        hm.put("Redbull", "160");
        hm.put("Lemon", "0.226");
        hm.put("ChocolateIcecream", "240");
        hm.put("Cake", "289");
        hm.put("Watermelon", "300");
        hm.put("Bread", "267");
        hm.put("Vegpuff", "90");
        hm.put("PaneerCube", "141");
        hm.put("Gajar ka Halwa", "275");


        s1cal=hm.get(s1);
        s2cal=hm.get(s2);
        s3cal=hm.get(s3);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        //timer.schedule (hourlyTask, 0l, 1000*1*60);
       // mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 1; index++) {
            DataObject obj = new DataObject(s1 +"   "+ s1cal,
                    s2 +"   "+s2cal);
            results.add(index, obj);
        }
        /*int index=0;
        DataObject obj = new DataObject("Some Primary Text check " + index,
                "Secondary " + index);
        results.add(index, obj);*/
        return results;
    }
}
