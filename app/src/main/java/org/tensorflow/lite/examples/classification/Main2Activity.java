package org.tensorflow.lite.examples.classification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    int pStatus = 0;
    Button button;
    double status = 0;
    double statuscarb = 0,calgoal=20000.0,progoal=5000.0,carbgoal=2800.0,fatgoal=500.0;
    double statusfat = 0;
    double statuspro = 0;
    String s1="",s2="",s3="";
    String dpro,dcal,dfat,dcarb;
    double ddpro=0,ddcal=0,ddfat=0,ddcarb=0;
    private Handler handler = new Handler();

    TextView tv,tv2,tv4,tv1,tv32,tv34;
    int s1cal,s2cal,s3cal;
    //TextView textView = (TextView)findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        double cal=0;
        double carb=0;
        double pro=0;
        double fat=0;
        //s1="Pizza";s2="Pizza";s3="Pizza";s1cal="0";s2cal="0";s3cal="0";
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        s3 = b.getString("s3");
        s2 = b.getString("s2");
        s1 = b.getString("s1");
        s3cal = b.getInt("s3cal");
        s2cal = b.getInt("s2cal");
        s1cal = b.getInt("s1cal");
        /*Map< String,Integer> hmcal =
                new HashMap< String,Integer>();
        Map< String,Integer> hmpro =
                new HashMap< String,Integer>();
        Map< String,Integer> hmfat =
                new HashMap< String,Integer>();
        Map< String,Integer> hmcarb =
                new HashMap< String,Integer>();
        hmcal.put("Orange", 470);
        hmcal.put("Cucumber", 45);
        hmcal.put("FrenchFries", 395);
        hmcal.put("Pizza", 190);
        hmcal.put("AlooParantha", 154);
        hmcal.put("Apple", 520);
        hmcal.put("Banana", 403);
        hmcal.put("Biryani", 210);
        hmcal.put("Burger", 240);
        hmcal.put("CholeBhature", 443);
        hmcal.put("CocaCola", 90);
        hmcal.put("Coffee", 35);
        hmcal.put("Dosa", 106);
        hmcal.put("Doughnut", 226);
        hmcal.put("Egg", 73);
        hmcal.put("Grapes", 670);
        hmcal.put("Idli", 39);
        hmcal.put("Momos", 35);
        hmcal.put("Noodles", 380);
        hmcal.put("PlainRice", 252);
        hmcal.put("Samosa", 262);
        hmcal.put("Sandwich", 204);
        hmcal.put("TandooriChicken", 350);
        hmcal.put("GulabJamun", 150);
        hmcal.put("Jalebi", 108);
        hmcal.put("Utpam", 257);
        hmcal.put("Upma", 54);
        hmcal.put("Cookies", 405);
        hmcal.put("KajuKatli", 58);
        hmcal.put("Rajma", 190);
        hmcal.put("Boondiladdoo", 185);
        hmcal.put("Aloogobhi", 108);
        hmcal.put("Tacos", 160);
        hmcal.put("Rasmalai", 160);
        hmcal.put("ChillyPotato", 126);
        hmcal.put("scram", 327);
        hmcal.put("Dhokla", 80);
        hmcal.put("Rasgulla", 100);
        hmcal.put("Imarti", 500);
        hmcal.put("Chapati", 130);
        hmcal.put("Nutella", 45);
        hmcal.put("Cherry", 63);
        hmcal.put("Beer", 100);
        hmcal.put("Guava", 112);
        hmcal.put("Strawberry", 1);
        hmcal.put("Bhindi", 330);
        hmcal.put("FishFry", 688);
        hmcal.put("Manchurian", 183);
        hmcal.put("Redbull", 160);
        hmcal.put("Lemon", 1);
        hmcal.put("ChocolateIcecream", 240);
        hmcal.put("Cake", 289);
        hmcal.put("Watermelon", 300);
        hmcal.put("Bread", 267);
        hmcal.put("Vegpuff", 90);
        hmcal.put("PaneerCube", 141);
        hmcal.put("Gajar ka Halwa", 275);
        //protein
        hmpro.put("Orange", 9);
        hmpro.put("Cucumber", 1);
        hmpro.put("FrenchFries", 4);
        hmpro.put("Pizza", 9);
        hmpro.put("AlooParantha", 6);
        hmpro.put("Apple", 2);
        hmpro.put("Banana", 4);
        hmpro.put("Biryani", 4);
        hmpro.put("Burger", 21);
        hmpro.put("CholeBhature", 13);
        hmpro.put("CocaCola", 0);
        hmpro.put("Coffee", 0);
        hmpro.put("Dosa", 2);

        hmpro.put("Doughnut", 1);
        hmpro.put("Egg", 6);
        hmpro.put("Grapes", 6);
        hmpro.put("Idli", 2);
        hmpro.put("Momos", 1);
        hmpro.put("Noodles", 9);
        hmpro.put("PlainRice", 4);
        hmpro.put("Samosa", 3);
        hmpro.put("Sandwich", 7);
        hmpro.put("TandooriChicken", 73);
        hmpro.put("GulabJamun", 2);
        hmpro.put("Jalebi", 0);
        hmpro.put("Utpam", 10);
        hmpro.put("Upma", 5);
        hmpro.put("Cookies", 4);
        hmpro.put("KajuKatli", 1);
        hmpro.put("Rajma", 12);
        hmpro.put("Boondiladdoo", 2);
        hmpro.put("Aloogobhi", 4);
        hmpro.put("Tacos", 4);
        hmpro.put("Rasmalai", 5);
        hmpro.put("ChillyPotato", 1);
        hmpro.put("scram", 21);
        hmpro.put("Dhokla", 5);
        hmpro.put("Rasgulla", 2);
        hmpro.put("Imarti", 4);
        hmpro.put("Chapati", 4);
        hmpro.put("Nutella", 0);
        hmpro.put("Cherry", 1);
        hmpro.put("Beer", 1);
        hmpro.put("Guava", 4);
        hmpro.put("Strawberry", 0);
        hmpro.put("Bhindi", 19);
        hmpro.put("FishFry", 43);
        hmpro.put("Manchurian", 2);
        hmpro.put("Redbull", 0);
        hmpro.put("Lemon", 0);
        hmpro.put("ChocolateIcecream", 6);
        hmpro.put("Cake", 5);
        hmpro.put("Watermelon", 6);
        hmpro.put("Bread", 10);
        hmpro.put("Vegpuff", 2);
        hmpro.put("PaneerCube", 6);
        hmpro.put("Gajar ka Halwa",5);


        //fat
        hmfat.put("Orange", 0);
        hmfat.put("Cucumber", 0);
        hmfat.put("FrenchFries", 22);
        hmfat.put("Pizza", 4);
        hmfat.put("AlooParantha", 3);
        hmfat.put("Apple", 1);
        hmfat.put("Banana", 1);
        hmfat.put("Biryani", 8);
        hmfat.put("Burger", 17);
        hmfat.put("CholeBhature", 18);
        hmfat.put("CocaCola", 0);
        hmfat.put("Coffee", 0);
        hmfat.put("Dosa", 2);

        hmfat.put("Doughnut", 12);
        hmfat.put("Egg", 5);
        hmfat.put("Grapes", 3);
        hmfat.put("Idli", 0);
        hmfat.put("Momos", 0);
        hmfat.put("Noodles", 9);
        hmfat.put("PlainRice", 5);
        hmfat.put("Samosa", 17);
        hmfat.put("Sandwich", 2);
        hmfat.put("TandooriChicken", 25);
        hmfat.put("GulabJamun", 7);
        hmfat.put("Jalebi", 1);
        hmfat.put("Utpam", 5);
        hmfat.put("Upma", 3);
        hmfat.put("Cookies", 16);
        hmfat.put("KajuKatli", 3);
        hmfat.put("Rajma", 1);
        hmfat.put("Boondiladdoo", 8);
        hmfat.put("Aloogobhi", 2);
        hmfat.put("Tacos", 4);
        hmfat.put("Rasmalai", 12);
        hmfat.put("ChillyPotato", 8);
        hmfat.put("scram", 24);
        hmfat.put("Dhokla", 5);
        hmfat.put("Rasgulla", 0);
        hmfat.put("Imarti", 18);
        hmfat.put("Chapati", 3);
        hmfat.put("Nutella", 4);
        hmfat.put("Cherry", 0);
        hmfat.put("Beer", 0);
        hmfat.put("Guava", 1);
        hmfat.put("Strawberry", 0);
        hmfat.put("Bhindi", 2);
        hmfat.put("FishFry", 26);
        hmfat.put("Manchurian", 10);
        hmfat.put("Redbull", 0);
        hmfat.put("Lemon", 0);
        hmfat.put("ChocolateIcecream", 10);
        hmfat.put("Cake", 2);
        hmfat.put("Watermelon", 1);
        hmfat.put("Bread", 3);
        hmfat.put("Vegpuff", 5);
        hmfat.put("PaneerCube", 11);
        hmfat.put("Gajar ka Halwa",13);
        //carb
        hmcarb.put("Orange", 10);
        hmcarb.put("Cucumber", 10);
        hmcarb.put("FrenchFries", 45);
        hmcarb.put("Pizza", 27);
        hmcarb.put("AlooParantha", 55);
        hmcarb.put("Apple", 138);
        hmcarb.put("Banana", 103);
        hmcarb.put("Biryani", 30);
        hmcarb.put("Burger", 29);
        hmcarb.put("CholeBhature", 56);
        hmcarb.put("CocaCola", 25);
        hmcarb.put("Coffee", 4);
        hmcarb.put("Dosa", 17);

        hmcarb.put("Doughnut", 26);
        hmcarb.put("Egg", 0);
        hmcarb.put("Grapes", 171);
        hmcarb.put("Idli", 7);
        hmcarb.put("Momos", 6);
        hmcarb.put("Noodles", 29);
        hmcarb.put("PlainRice", 46);
        hmcarb.put("Samosa", 24);
        hmcarb.put("Sandwich", 40);
        hmcarb.put("TandooriChicken", 10);
        hmcarb.put("GulabJamun", 16);
        hmcarb.put("Jalebi", 23);
        hmcarb.put("Utpam", 43);
        hmcarb.put("Upma", 33);
        hmcarb.put("Cookies", 63);
        hmcarb.put("KajuKatli", 6);
        hmcarb.put("Rajma", 31);
        hmcarb.put("Boondiladdoo", 16);
        hmcarb.put("Aloogobhi", 18);
        hmcarb.put("Tacos", 27);
        hmcarb.put("Rasmalai", 10);
        hmcarb.put("ChillyPotato", 12);
        hmcarb.put("scram", 3);
        hmcarb.put("Dhokla", 7);
        hmcarb.put("Rasgulla", 80);
        hmcarb.put("Imarti", 80);
        hmcarb.put("Chapati", 23);
        hmcarb.put("Nutella", 8);
        hmcarb.put("Cherry", 16);
        hmcarb.put("Beer", 5);
        hmcarb.put("Guava", 24);
        hmcarb.put("Strawberry", 1);
        hmcarb.put("Bhindi", 70);
        hmcarb.put("FishFry", 71);
        hmcarb.put("Manchurian", 20);
        hmcarb.put("Redbull", 41);
        hmcarb.put("Lemon", 0);
        hmcarb.put("ChocolateIcecream", 32);
        hmcarb.put("Cake", 61);
        hmcarb.put("Watermelon", 75);
        hmcarb.put("Bread", 48);
        hmcarb.put("Vegpuff", 10);
        hmcarb.put("PaneerCube", 3);
        hmcarb.put("Gajar ka Halwa",35);*/

        /*Toast.makeText(Main2Activity.this, Integer.toString(s1cal),
                Toast.LENGTH_LONG).show();*/
        /*Toast.makeText(Main2Activity.this, "madar",
                Toast.LENGTH_LONG).show();*/
        //Toast.makeText(Main2Activity.this, s1,
        // Toast.LENGTH_LONG).show();
        /*if(s1cal!=0){
            cal=cal+hmcal.get(s1)*s1cal;
            pro=pro+hmpro.get(s1)*s1cal;
            carb=carb+hmcarb.get(s1)*s1cal;
            fat=fat+hmfat.get(s1)*s1cal;
        }
        if(s2cal!=0){
            cal=cal+hmcal.get(s2)*s2cal;
            pro=pro+hmpro.get(s2)*s2cal;
            carb=carb+hmcarb.get(s2)*s2cal;
            fat=fat+hmfat.get(s2)*s2cal;
        }
        if(s3cal!=0){
            pro=pro+hmpro.get(s3)*s3cal;
            cal=cal+hmcal.get(s3)*s3cal;
            carb=carb+hmcarb.get(s3)*s3cal;
            fat=fat+hmfat.get(s3)*s3cal;
        }*/
        SharedPreferences prefs1 = this.getSharedPreferences("myPrefsKey3", Context.MODE_PRIVATE);
        int firstLaunch = prefs1.getInt("key", 0);

        /*SharedPreferences.Editor editor1 = prefs1.edit();
        editor1.putInt("key", 1);

        editor1.commit();*/
        try{
            SQLiteDatabase myDatabase=this.openOrCreateDatabase("users",MODE_PRIVATE,null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (FoodItem VARCHAR(24) DEFAULT NULL,Quantity VARCHAR(15) DEFAULT NULL,Calorie decimal(7,3) DEFAULT NULL,Carbs decimal(6,3) DEFAULT NULL,Fat decimal(5,3) DEFAULT NULL,Protein decimal(5,3) DEFAULT NULL)");
            if(firstLaunch==0) {
                myDatabase.execSQL("INSERT INTO users(FoodItem,Quantity,Calorie,Carbs,Fat,Protein) VALUES ('Pizza','100gm',190.000,27.000,4.000,9.000),('Aloo Parantha','1.0',154.000,55.000,3.000,6.000),('Apple','1kg',520.000,138.000,1.000,2.000),('Banana','450gm',403.000,103.000,1.000,4.000),('Biryani','125gm',210.000,30.000,8.000,4.000),('Burger','1.0',354.000,29.000,17.000,21.000),('Chole Bhature','1 serving size',443.000,56.000,18.000,13.000),('Coca Cola','230ml',90.000,25.000,0.000,0.000),('Coffee','1 cup(250g)',35.000,4.000,0.000,0.000),('Dosa','1.0',106.000,17.000,2.000,2.000),('Doughnut','50.0',226.000,26.000,12.000,1.000),('Egg','1.0',73.000,0.350,4.750,6.250),('Grapes','1kg',670.000,171.000,3.000,6.000),('Idli','1(39gm)',39.000,7.000,0.000,2.000),('Steamed Momos','1.0',35.000,6.125,0.250,1.125),('Momos','1.0',35.000,6.125,0.250,1.125),('Noodles','1cup',380.000,29.000,9.000,9.000),('Plain Rice','200gm',252.000,46.000,5.000,4.000),('Samosa','1.0',262.000,24.000,17.000,3.500),('Sandwich','1.0',204.000,40.000,2.000,7.000),('Tandoori Chicken','200gm',350.000,10.000,25.000,73.000),('Gulab Jamun','1 piece(50g)',150.000,16.000,7.000,2.000),('Jalebi','1.0',108.000,23.000,1.000,0.000),('Orange','1kg',470.000,117.000,1.000,9.000),('Utpam','1.0',257.400,43.800,5.200,10.100),('Upma','1 cup',54.000,33.000,3.000,5.000),('Cookies','1.0',405.000,63.000,16.000,4.000),('Kaju Katli','1.0',58.000,6.000,3.000,1.000),('Rajma','1 cup',190.000,31.000,1.000,12.000),('Boondi Laddoo','1(50g)',185.000,16.000,8.000,2.000),('Aloo Gobhi','1cup',108.000,18.000,2.000,4.000),('Tacos','1.0',160.000,27.000,4.000,4.000),('Rasmalai','1 piece',160.000,10.000,12.000,5.000),('Chilly Potato','70.0',126.000,12.000,8.500,1.400),('Scrambled Egg','1 cup',327.000,3.000,24.000,21.000),('Dhokla','1 piece',80.000,7.000,5.000,2.000),('Rasgulla','1 piece(50g)',100.000,80.000,0.000,4.000),('Imarti','100gm',500.000,80.000,18.000,4.000),('Chapati','1 piece (57gm)',130.000,23.000,3.000,4.000),('Cucumber','1.0',45.000,10.000,0.000,1.000),('Nutella','15.0',82.000,8.000,4.000,0.000),('Cheery','100gm',63.000,16.000,0.000,1.000),('Beer','1 pint',100.000,5.000,0.000,1.000),('French Fries','0.5 cup',395.000,45.000,22.000,4.000),('Guava','165.0',112.000,24.000,1.600,4.200),('Strawberry','1.0',0.320,0.760,0.030,0.060),('Bhindi','100.0',330.000,70.000,2.000,19.000),('Fish Fry','513.0',688.000,71.000,26.000,43.000),('Manchurian','1 serving',183.400,19.900,10.700,2.400),('Red Bull','355.0',160.000,41.000,0.000,0.000),('Lemon','1 pc',0.226,0.071,0.002,0.003),('Chocolate Icecream','1cup',240.000,32.000,10.000,6.000),('Cake','100 g',289.000,61.000,2.000,5.000),('Watermelon','1kg',300.000,75.000,1.000,6.000),('Bread','100.0',267.000,48.000,3.000,10.000),('Veg Puff','1 piece',90.000,10.000,5.000,2.000),('Paneer Cubes','100.0',141.000,3.000,11.000,6.000),('Gajar ka Halwa','228.0',275.000,35.000,13.000,5.600),('Chicken Biryani','100gm',146.000,15.500,4.700,10.000),('Mutton Biryani','100gm',160.500,9.500,9.500,9.500),('Mutton Korma','150gm',277.000,7.400,23.000,12.000),('Mutton Fry','135gm',284.000,4.100,19.000,23.000),('Baigan Bharta','115gm',58.500,8.500,2.800,1.100),('Chicken Tikka','127gm',145.500,5.500,6.000,16.500),('Chicken wings','100gm',352.000,10.400,26.000,18.000),('Chicken Curry','118gm',121.500,3.800,5.500,14.000),('Chicken Salad','115gm',254.000,3.300,18.000,19.000),('Chicken Sandwich','1 piece',468.000,39.000,21.000,30.000),('Chicken Salami','1 slice',48.000,0.400,2.600,5.400),('Chicken Liver','135gm',219.000,1.100,8.700,33.000),('Matar Paneer','220gm',299.500,12.500,23.000,11.500),('Paneer Korma','118gm',183.500,5.000,14.500,8.500),('Paneer Kabab','180gm',280.000,12.000,21.000,13.000),('Saag Paneer','200gm',366.000,10.000,30.000,15.000),('Palak Paneer','150gm',230.000,5.000,18.000,10.000),('Aloo  Naan','1 piece',300.000,46.000,11.000,6.100),('Aloo Curry','240gm',204.000,21.000,13.000,2.900),('Aloo Matar','100gm',121.400,11.400,7.100,2.900),('Aloo Tikki','100gm',194.700,15.300,14.400,3.000),('Pav Bhaji','100gm',97.500,15.800,2.800,3.000),('Onion Paratha','1 piece',277.000,40.000,11.000,5.700),('Egg Paratha','1 piece',279.000,45.000,7.500,11.000),('Paneer Paratha','1 piece',176.000,21.000,7.800,7.700),('Mooli  Paratha','1 piece',296.000,46.000,9.500,6.000),('Baked Chicken','114gm',250.000,0.100,14.700,26.700),('Tomato daal','100gm',84.700,11.000,2.900,4.600),('Whiskey','1 shot',97.000,0.000,0.000,0.000),('Wine Red','1 glass',125.000,3.800,0.000,0.100),('Wine Rose','1 glass',126.000,5.800,0.000,0.600),('Port Wine','30ml',15.000,1.800,0.000,0.100),('Wheat Beer','1 can',153.000,13.000,0.000,1.600),('Root Beer','1 can',152.000,39.000,0.000,0.000),('Lite Beer','1 can',103.000,5.800,0.000,0.800),('Chicken Nuggets','100gm',318.500,15.600,21.400,16.300),('Pork Gravy','100gm',81.000,5.400,5.400,1.800),('Butter Chicken Masala','100gm',148.500,4.000,9.000,13.900),('Chicken Shawarma','100gm',184.800,16.100,5.900,15.700),('Chicken roll','100gm',186.500,28.500,4.100,7.800),('Egg Roll','100gm',267.600,28.800,13.200,8.900),('Spring roll','100gm',251.600,32.300,10.500,6.300),('Pork Spring roll','62gm',150.000,19.000,6.200,4.900),('Tofu Spring Roll','62gm',136.000,19.000,5.200,3.800),('Chicken spring roll','40gm',90.000,9.000,4.500,5.000),('Chicken eggroll','57gm',110.000,15.000,3.000,5.000),('Salmon roll','160gm',278.000,21.000,12.000,21.000),('Egg Omlette','178gm',323.000,1.400,21.000,25.000),('Ham Omlette','265gm',512.000,2.900,37.000,40.000),('Veggie Omlette','445gm',620.000,19.000,4.000,37.000),('Cheese Omlette','192gm',407.000,2.200,31.000,27.000),('Spinach Omlette','258gm',363.000,5.600,27.000,25.000),('Saag Aloo','195gm',160.000,23.000,6.700,4.900),('Jeera Aloo','145gm',172.000,28.000,5.600,3.500),('Tandoori Aloo','120gm',229.000,18.000,17.000,3.500),('Aloo Pakoda','1 piece',20.000,3.500,0.200,0.900),('Dum Aloo','140gm',240.000,11.000,20.000,3.000),('Rava Idli','1 piece',70.000,13.000,1.000,2.000),('Ragi Dosa','1 medium',135.000,15.000,7.800,2.000),('Wheat Dosa','1 medium',168.000,29.000,3.700,3.900),('Egg Dosa','1 piece',205.000,21.000,9.600,9.000),('Onion Dosa','1 medium',191.000,35.000,3.900,4.600),('Carrot Dosa','330gm',292.000,36.000,14.000,4.600),('Butter Dosa','1 medium',239.000,29.000,12.000,4.000),('Chicken Lollipop','1 piece',88.000,2.600,6.500,4.500),('Sabudana Khichdi','185gm',262.000,38.000,11.000,4.500),('Lassi','250gm',130.000,22.000,2.100,6.900),('Mango Lassi','240gm',186.000,34.000,4.500,5.200),('Whole Milk Yogurt','1 container',104.000,7.900,5.500,5.900),('Aloo Gajar Matar','160gm',155.000,23.000,5.900,3.800),('Aloo Sabzi','160gm',141.000,27.000,2.700,3.500),('Methi Thepla','1 piece',128.000,14.000,7.100,2.800),('Aloo Methi Paratha','1 piece',270.000,35.000,12.000,5.000),('Lachcha Paratha','1 piece',210.000,27.000,9.000,5.000),('Mix Veg Paratha','1 piece',240.000,29.000,11.000,6.000),('Shahi Paneer','242gm',310.000,12.000,25.000,12.000),('Chili Paneer','230gm',366.000,17.000,27.000,15.000),('Paneer Capsicum','233gm',366.000,17.000,27.000,15.000),('Bhindi Fry','186gm',196.000,12.000,17.000,2.900),('Bhindi Masala','142gm',330.000,20.000,26.000,4.000),('Capsicum rice','240gm',342.000,57.000,11.000,6.200),('Kadhai Paneer','142gm',270.000,13.000,22.000,6.000),('Kadhai Gosht','246gm',463.000,10.000,35.000,28.000),('Grilled Chicken','192gm',284.000,0.000,6.500,57.000),('Grilled Onion','210gm',211.000,20.000,14.000,2.700),('Grilled Shrimp','85gm',101.000,1.300,1.400,19.000),('Grilled Salmon','1 fillet',468.000,0.000,28.000,50.000),('Salami beef','28gm',74.000,0.500,6.300,3.600),('7 Up','1 can',151.000,38.000,0.000,0.300),('Appy Fizz','100ml',54.000,13.600,0.000,0.000),('Thums Up','100ml',40.000,10.000,0.000,0.000),('Sprite','100ml',48.000,12.000,0.000,0.000),('Limca','100ml',44.000,11.000,0.000,0.000),('Fanta','100ml',52.000,13.000,0.000,0.000),('Mirinda','100ml',55.000,13.800,0.000,0.000),('Pepsi','100ml',43.000,10.900,0.000,0.000),('Diet Pepsi','100ml',0.300,0.000,0.000,0.000),('Diet Coke','100ml',0.200,0.000,0.000,0.000),('Nimbooz Masala Soda','100ml',42.000,10.600,0.000,0.000),('Cabbage Shredded','75gm',17.000,4.100,0.100,0.900),('Red Cabbage Shredded','150gm',44.000,10.000,0.100,2.300),('Cabbage roll','260gm',229.000,30.000,7.800,11.000),('Cabbage soup','245gm',85.000,7.000,6.000,1.700),('Pulao','164gm',261.000,42.000,8.100,4.100),('Veg Pulao','244gm',281.000,54.000,4.400,5.400),('Mint Pulao','290gm',342.000,57.000,10.000,6.800),('Palak Pulao','400gm',473.000,82.000,12.000,10.000),('Rajma Pulao','250gm',235.000,43.000,3.400,9.500),('Pasta','1 cup',196.000,38.000,1.200,7.200),('Vodka Pasta','1 cup',272.500,37.500,9.000,7.500),('Beetroot','50gm',22.000,5.000,0.100,0.800),('Beetroot Juice','350gm',98.000,23.000,0.300,2.800),('Beetroot Salad','260gm',598.000,24.000,52.000,11.000),('Mango ','100gm',60.600,15.000,0.400,0.800),('Raspberry','1 piece',1.000,0.200,0.000,0.000),('Passion Fruit','236gm',229.000,55.000,1.700,5.200),('Dal Kachori','1 piece',83.000,7.700,5.300,1.500),('Mutter Kachori','1 piece',180.000,17.000,11.000,4.000),('Dry Kachori','1 piece',97.000,9.000,5.000,4.000),('Dry Fruit Kachori','1 piece',133.000,16.000,6.500,2.200),('Soya Patty','1 patty',124.000,10.000,4.400,11.000),('Aloo Papdi','130gm',242.000,32.000,10.000,6.800),('Raj Kachori','1 serving',200.000,25.000,7.000,6.000),('Palak Biryani','400gm',473.000,82.000,12.000,10.000),('Fish Biryani','100gm',148.000,15.500,5.000,9.500),('Egg Biryani','100gm',131.000,18.300,4.700,4.000),('Nasi Biryani','100gm',190.000,25.400,8.800,2.500),('Dal Fry','100gm',89.000,10.500,3.900,4.000),('Hamburger Roll','1 roll',120.000,23.000,1.500,4.000),('Dal Palak','1 cup',130.000,10.000,8.000,4.000),('Moong Dal','100gm',476.000,51.000,21.000,21.000),('Chicken Kabab','100gm',110.000,17.500,1.100,7.500),('Seekh Kabab','100gm',211.000,5.500,13.000,18.200),('Oats','100gm',397.800,70.200,6.800,13.800),('Ghugni','100gm',109.000,12.000,6.000,3.500),('Murg Malai Kabab','100gm',135.000,1.900,3.400,23.000),('Chilli Chicken','1 pot',327.000,60.000,3.700,12.000),('Shami Kabab','100gm',232.800,6.200,18.000,12.000),('Bun Kabab','1 sandwich',654.000,102.000,17.000,27.000),('Kabab Kubideh','100gm',268.000,2.100,19.000,21.000),('Pea Sprouts','100gm',125.200,27.700,0.700,9.200),('Bean Sprouts','100gm',20.800,4.200,0.100,2.000),('Brussel Sprouts','100gm',37.500,7.500,0.500,2.700),('Broccoli Sprouts','100gm',22.800,2.100,3.900,0.700),('Almond Milk','100gm',21.800,3.200,1.000,0.400),('Coconut Milk','100gm',200.300,2.900,21.600,2.100),('Apricot','1 apricot',17.000,3.900,0.100,0.500),('Asparagus','100gm',23.100,4.200,0.200,2.400),('Bacon','100gm',461.500,1.700,34.400,34.400),('Baked Sweet Potato','100gm',92.700,21.600,0.200,2.100),('Banana Pudding','1 cup',288.000,47.000,10.000,4.000),('Banana Muffin','1 medium',366.000,63.000,12.000,5.000),('Orange Muffin','1 medium',435.000,64.000,18.000,5.800),('Berry Muffin','1 medium',424.000,60.000,18.000,5.100),('Black Currant','100gm',70.000,17.230,0.460,1.570),('Fig','1 fig',21.000,5.400,0.100,0.300),('Grapefruit','123gm',52.000,13.000,1.400,0.900),('Son Papdi','100gm',362.600,47.600,3.100,18.100),('Boorelu','1 piece',171.000,18.000,3.000,24.000),('Kova Kajjikayalu','1 Kajjikayalu',78.000,4.000,5.000,2.000),('Moti Choor Laddu','1 piece',140.000,16.000,8.000,2.000),('Shrikhand','50gm',130.000,23.000,3.000,4.000),('Ghevar','10gm',40.000,0.000,0.000,0.000),('Modak','1 piece',180.000,40.000,8.000,2.000),('Puran Poli','1 serving',300.000,16.000,4.000,4.000),('Sevaiya','1 cup',80.000,11.000,0.000,8.000),('Sabudana kheer','1 cup',250.000,11.000,0.000,2.000),('Sabudana','25gm',88.000,22.000,0.000,0.000),('Phool Makhana','100gm',333.000,57.000,0.000,25.000),('Soya Milk','250ml',82.000,1.000,5.000,9.000),('Soya Crisps','20gm',94.000,7.000,5.000,4.000),('Soya Bean Curry','1 cup',150.000,10.000,0.000,16.000),('Soya Chunks','2 oz',153.000,18.000,2.000,53.000),('Soya Keema','1 cup',70.000,0.000,0.000,0.000),('Soya Chap','100gm',122.000,5.000,2.000,20.000),('Kashmiri Kehwa','1 cup',92.000,4.000,1.000,16.000),('Aloo methi','1 oz',50.000,4.000,4.000,1.000),('Aloo Baingan','1 serving',97.000,21.000,12.000,3.000),('Aloo Kathi Roll','1 piece',460.000,60.000,20.000,8.000),('Bondas','1 ball',136.000,22.000,5.000,3.000),('Beans Aloo','1 cup',143.000,34.000,0.000,5.000),('Bhindi Karela Masala','1.5 cups',300.000,42.000,10.000,0.000),('Parval, Pointed Guard','0.5 cup',30.000,3.000,0.000,3.000),('Bottle Guard, Raw','0.5 cup',8.000,2.000,0.000,0.000),('Tori, Ridge Guard','230gm',41.000,10.000,0.000,0.000),('Mysore Bonda','1 piece',60.000,7.700,2.700,1.200),('Curd Rice','1 cup',207.000,38.000,3.200,6.100),('Rasam','250g',64.000,8.700,3.100,2.200),('Appam','1 piece(46g)',94.000,17.000,2.400,1.500),('Sambar','506 g',260.000,53.000,1.300,14.000),('Vada','1 piece( 71g)',135.000,11.000,8.400,4.400),('Suji Halwa','122g',318.000,46.000,13.000,4.900),('Masala Dosa','1 (97g)',168.000,29.000,3.700,3.900),('Payasam','113g',131.000,17.000,5.300,4.200),('Pongal','1 cup (207g)',319.000,54.000,8.100,7.300),('Chaat','1 cup(129g)',242.000,32.000,10.000,6.800),('Coconut Burfi ','1 piece(19g)',92.000,12.000,4.500,1.500),('Dal Dhokli','1 piece (56g)',93.000,14.000,2.800,3.400),('Besan Ladoo','1 piece',211.000,24.000,11.000,4.200),('Khandvi','25g',90.000,15.000,1.000,4.000),('Khakhra','1 piece (20g)',83.500,11.000,3.500,2.000),('Pani Puri','1 piece',152.000,15.000,9.900,2.500),('Sohan Papadi','1 piece',259.000,34.000,13.000,2.200),('Thepla','1 piece',128.000,14.000,7.100,2.800),('Chiken  Momo','1 piece',61.000,7.900,2.200,3.400),('Litti','1 piece',116.000,19.000,2.900,4.400),('Red Velvet Cake','1 piece (109g)',368.000,36.000,23.000,4.200),('Bread Pakoda','1 piece (36g)',98.000,12.000,4.200,2.700),('Onion Pakora','1 piece (33g)',80.000,8.200,4.800,1.100),('Paneer Pakora ','1 piece (30g)',90.000,8.000,4.000,5.000),('Aloo Pakora','1 piece (16g)',20.000,3.500,0.200,0.900),('Banana Chips ','28g',147.000,17.000,9.500,0.700),('Banana Shake','100g ',124.000,20.300,3.800,2.800),('Vanilla Shake','313g',351.000,56.000,38.000,12.000),('Mango Shake','452g',515.000,81.000,17.000,12.000),('Namak Para','1 piece (2.8g)',17.000,1.100,1.300,0.200),('Palak Paratha','1 piece (83g)',160.000,23.000,6.000,4.100),('Methi Paratha','1 piece (60g)',180.000,26.000,7.000,4.000),('Gobhi Paratha','1 piece (100g)',240.000,34.000,9.000,7.000),('Vanilla Ice Cream','1 cup (188g)',460.000,50.000,26.000,6.000),('Rogan Josh','1 cup (236g)',223.000,11.000,13.000,17.000),('Malai Kofta','1 piece (30g)',73.000,1.300,4.800,6.100),('Rumali Roti','1 piece (60g)',160.000,24.000,4.500,5.000),('Vada Pav','1 piece (127g)',263.000,37.000,9.500,7.500),('Egg Curry','224g',200.000,13.000,12.000,9.600),('Fish Curry','210g',307.000,6.100,15.000,36.000),('Chiken Curry','235g',243.000,7.500,11.000,28.000),('Cold Coffe','113g',3.000,0.000,0.000,0.000),('Black Coffee','237g',2.400,0.000,0.100,0.300),('Black Tea','178g',1.800,0.000,0.000,0.000),('Green Tea','178g',2.500,0.000,0.000,0.500),('Black Rice','1 cup (158g)',205.000,45.000,0.400,4.300),('Brown Rice','1 cup (98g)',109.000,23.000,0.800,2.300),('Red Rice','1 cup(98g)',109.000,23.000,0.800,2.300),('Lemon Rice','1 cup(180g)',221.000,43.000,2.900,4.900),('Nankhatai','1 piece (31g)',166.000,17.000,10.000,1.500),('Dal Makhani','1 cup(253g)',427.000,39.000,24.000,16.000),('Rajma Rice','1 cup (250g)',235.000,43.000,3.400,9.500),('Peda','1 ball (11gm)',40.000,4.900,1.700,1.400),('Kheer','1 cup (226g)',262.000,34.000,10.600,8.400),('Kulfi','1 bar (73g)',184.000,25.000,7.600,4.800),('Blueberry','1 berry (1.4g)',0.800,0.200,0.000,0.000),('Blackberry','1 berry (6.5g)',2.800,0.600,0.000,0.100),('Plum','1 fruit (66g)',30.000,7.500,0.200,0.500),('Moong Dal ','1 cup (206g)',236.000,41.000,2.000,16.000),('Grilled Fish','1 fillet (72g)',84.000,0.000,1.200,17.000),('Grilled Steak','1 fillet (221g)',614.000,0.000,41.000,58.000),('Milk Cake','1 piece (124g)',326.000,41.000,15.000,6.600),('Broccoli ','1 spear (37g)',2.700,0.000,0.100,0.900),('Pumpkin','1 cup (245g)',48.000,12.000,0.200,1.800),('Aloo Tikki','1 cup (121g)',229.000,18.000,17.000,3.500),('Brownie','1 piece (50g)',233.000,25.000,15.000,3.100),('Poha','1 cup(139g)',158.000,35.000,0.200,2.900),('Ragi Roti','1 piece (68g)',139.000,20.000,5.700,2.800),('Sarson Ka Saag','1 cup (141g)',150.000,9.000,12.000,2.000),('Kadhi Chawal ','2 cups (462g)',496.000,40.000,32.000,14.000),('Murgh Makhani','1 cup (240g)',355.000,14.000,23.000,23.000),('Sweet Potato','151g',115.000,27.000,0.200,2.100),('Vodka','42g',0.000,0.000,0.000,0.000),('Kachori','1 piece (20g)',83.000,7.700,5.300,1.500),('Kalakand','1 piece (44g)',142.000,17.000,6.300,5.000),('Aalu Jeera ','1 cup (143g)',172.000,28.000,5.600,3.500),('Peanut','1 peanut(1g)',5.900,0.000,0.500,0.200),('Date','1 piece (7.1g)',20.000,5.300,0.000,0.200),('Pine apple ','1 cup(166g)',82.000,22.000,0.200,0.900),('Avocado','1 fruit (136g)',227.000,12.000,21.000,2.700),('Peach ','1 fruit (175g)',68.000,17.000,0.400,1.600),('Kiwi','1 fruit (69g)',42.000,10.000,0.400,0.800),('Lychee','1 cup (190g)',125.000,31.000,0.800,1.600),('Pear','1 fruit (178g)',101.000,27.000,0.300,0.600),('Mango ','1 fruit (336g)',202.000,50.000,1.300,2.800),('Pomegranate','1 fruit (282g)',234.000,53.000,3.300,4.700),('Cheese Balls','1 cup (27g)',151.000,15.000,9.700,1.600),('Nacho','1 cup (550g)',1234.000,26.000,96.000,67.000),('Pork Cutlet','1 piece (166g)',461.000,22.000,27.000,30.000),('Oreo Shake ','1 (356g)',652.000,102.000,22.000,15.000),('Lava Cake','1 (154g)',660.000,66.000,41.000,10.000),('Mayonese ','1 tbsp (14g)',94.000,0.100,10.000,0.100),('Soup Dumpling','1 piece (37g)',67.000,7.700,2.300,3.600),('Pork Dumpling','1 piece (37g)',67.000,7.700,2.300,3.600),('Lasagna Rolls','1 roll (218g)',308.000,27.000,15.000,16.000),('Misal Pav','1 plate (226g)',264.000,42.000,7.400,10.000),('Dahi Vada','1 piece (71g)',89.000,7.800,5.000,3.800),('Bhujia ','1 cup (35g)',196.000,13.000,14.000,4.900),('Phirnee','1 cup (264)',511.000,67.000,24.000,9.900),('Chana Masala','1 cup (195g)',281.000,29.000,16.000,7.700),('Chana Puri','1 (226g)',393.000,54.000,14.000,15.000),('Ginger Bread ','1 piece (69g)',219.000,36.000,7.300,2.400),('Ginger  Tea ','1 cup (237g)',2.400,0.500,0.000,0.000),('Onion Soup ','1 tbsp (7.5g)',22.000,4.900,0.000,0.600),('Tomato Soup ','2 cups (488g)',170.000,36.000,1.100,3.500),('Prawn','1 shrimp (5g)',6.000,0.100,0.100,1.100),('Saffron Rice ','1 cup (187g)',167.000,29.000,4.000,2.500),('Tamarind Rice ','1 cup (194g)',344.000,51.000,13.000,7.400),('Cham Cham ','1 piece (109g)',150.000,30.000,3.100,1.600),('Gur Rewari','50gm',220.000,39.000,6.000,1.000),('Rabdi','100gm',400.000,40.000,20.000,10.000),('Veg Korma','300gm',445.000,30.000,35.000,8.000),('Curry Pakoda','25gm',35.000,15.000,0.000,2.000),('Thekua','1 piece',22.000,10.000,5.000,1.000),('Virgin Mojito','1 can',140.000,37.000,0.000,0.000),('Lemonade','1 cup',230.000,0.000,0.000,0.000),('Hot Dog','1 piece',423.000,38.000,23.000,15.000),('Sphagetti Cooked, Cooked','100gm',158.000,31.000,1.000,6.000),('Saucage','100gm',192.000,7.000,12.000,14.000),('Pie','1 slice',290.000,43.000,13.000,2.000),('Cup Cake','1 cake',160.000,26.000,6.000,1.000),('Donut','1 piece',297.000,38.000,15.000,3.000),('Sushi','5 piece',295.000,32.000,7.000,5.000),('Cat fish, raw','100gm',95.000,0.000,3.000,16.000),('Cat fish, fried','Half fillet',199.000,7.000,12.000,16.000),('Turkey','1 slice',25.000,1.000,0.000,6.000),('Meat balls','6 pieces',240.000,5.000,19.000,13.000),('Pan cake','200gm',90.000,12.000,3.000,30.000),('Veg Quiche','1 slice',350.000,21.000,25.000,10.000),('Chicken Quiche','1 piece',334.000,16.000,24.000,10.000),('Apple Cidar Vinegar','1 tablespoon',0.000,0.000,0.000,0.000),('Balushahi','1 piece',132.000,16.000,7.000,2.000),('Pua','1 piece',125.000,26.000,5.000,3.000),('Khichdi','Half cup',255.000,47.000,9.000,9.000),('Thandai','100ml',315.000,75.000,1.000,2.000),('Gujiya','1 piece',175.000,20.000,11.000,2.000),('Dal Bati Churma','100gm',320.000,30.000,5.000,4.000),('Petha','100gm',305.000,74.000,0.000,1.000),('Basundi','1 cup',400.000,30.000,24.000,38.000),('Gajak','100gm',200.000,0.000,0.000,0.000),('Faluda Kulfi','1 bowl',311.000,33.000,15.000,13.000),('Faluda Drink','100ml',90.000,15.000,2.000,3.000),('Channa Dal','1 bowl',145.000,13.000,7.000,5.000),('Shahi Tukda','1 piece',169.000,17.000,11.000,2.000),('Chilli Fish','100gm',80.000,4.000,2.000,10.000),('Bhalle Papdi Chat','1 plate ',498.000,29.000,4.000,16.000),('Double Chicken Salan',' 581 g',230.000,12.000,5.000,17.000),('Aloo Ka Salan','1 fluid oz',294.000,30.000,19.000,4.000),('Bhindi Salan','130gm',129.000,11.000,10.000,2.000),('Mirchi Salan','125gm',220.000,9.000,18.000,5.000),('Gosht Salan Tarkari','1 cup',350.000,9.000,15.000,25.000),('Paneer Kulcha','1 piece',220.000,28.000,9.000,7.000),('Chole Kulcha','1 serving',342.000,57.000,7.000,14.000),('Vegetable Kulcha','1 piece',244.000,0.000,0.000,0.000),('Palak Gosht',' 1 cup',367.000,16.000,19.000,35.000),('Karahi Gosht','100gm',222.000,2.000,17.000,18.000),('Nihari Curry','10gm',30.000,3.000,1.000,1.000)");
            }
            SharedPreferences.Editor editor1 = prefs1.edit();
            editor1.putInt("key", 1);

            editor1.commit();
            Cursor c = myDatabase.rawQuery("SELECT * FROM users",null);
            int foodIndex=c.getColumnIndex("FoodItem");
            int quantindex=c.getColumnIndex("Quantity");
            int caloindex=c.getColumnIndex("Calorie");
            int carbindex=c.getColumnIndex("Carbs");
            int fatindex=c.getColumnIndex("Fat");
            int proteinindex=c.getColumnIndex("Protein");
            c.moveToFirst();
            while(c!=null){



                if((c.getString(foodIndex)).equalsIgnoreCase(s1)){
                    Log.i("FoodItem",c.getString(foodIndex));
                    Log.i("Quantity",c.getString(quantindex));
                    dcal=c.getString(caloindex);
                    ddcal=ddcal+Double.parseDouble(dcal)*(double)s1cal;

                    Log.i("Calorie",dcal);
                    dcarb=c.getString(carbindex);
                    ddcarb=ddcarb+Double.parseDouble(dcarb)*(double)s1cal;
                    Log.i("Carbs",dcarb);
                    dfat=c.getString(fatindex);
                    ddfat=Double.parseDouble(dfat);
                    Log.i("Fat",dfat);
                    dpro=c.getString(caloindex);
                    ddpro=ddpro+Double.parseDouble(dpro)*(double)s1cal;
                    Log.i("Protein",dpro);
                    break;
                }

                c.moveToNext();


            }
            c.moveToFirst();
            while(c!=null){



                if((c.getString(foodIndex)).equalsIgnoreCase(s2)){
                    Log.i("FoodItem",c.getString(foodIndex));
                    Log.i("Quantity",c.getString(quantindex));
                    dcal=c.getString(caloindex);
                    ddcal=ddcal+Double.parseDouble(dcal)*(double)s2cal;

                    Log.i("Calorie",dcal);
                    dcarb=c.getString(carbindex);
                    ddcarb=ddcarb+Double.parseDouble(dcarb)*(double)s2cal;
                    Log.i("Carbs",dcarb);
                    dfat=c.getString(fatindex);
                    ddfat=ddfat+Double.parseDouble(dfat);
                    Log.i("Fat",dfat);
                    dpro=c.getString(caloindex);
                    ddpro=ddpro+ddpro+Double.parseDouble(dpro)*(double)s2cal;
                    Log.i("Protein",dpro);
                    break;
                }

                c.moveToNext();


            }
            c.moveToFirst();
            while(c!=null){



                if((c.getString(foodIndex)).equalsIgnoreCase(s3)){
                    Log.i("FoodItem",c.getString(foodIndex));
                    Log.i("Quantity",c.getString(quantindex));
                    dcal=c.getString(caloindex);
                    ddcal=ddcal+Double.parseDouble(dcal)*(double)s3cal;

                    Log.i("Calorie",dcal);
                    dcarb=c.getString(carbindex);
                    ddcarb=ddcarb+Double.parseDouble(dcarb)*(double)s3cal;
                    Log.i("Carbs",dcarb);
                    dfat=c.getString(fatindex);
                    ddfat=ddfat+Double.parseDouble(dfat);
                    Log.i("Fat",dfat);
                    dpro=c.getString(caloindex);
                    ddpro=ddpro+Double.parseDouble(dpro)*(double)s3cal;
                    Log.i("Protein",dpro);
                    break;
                }

                c.moveToNext();


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }







        //if(!s2cal.equals(""))
        //cal=cal+Integer.parseInt(hmcal.get(s2))*Integer.parseInt(s2cal);
        //if(!s3cal.equals(""))
        //cal=cal+Integer.parseInt(hmcal.get(s3))*Integer.parseInt(s3cal);*/
        //textView.setText(cal);
        //double calgoal=2000;
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int score = prefs.getInt("key", 0)+(int)ddcal;
        int scorepro = prefs.getInt("keypro", 0)+(int)ddpro;
        int scorecarb = prefs.getInt("keycarb", 0)+(int)ddcarb;
        int scorefat = prefs.getInt("keyfat", 0)+(int)ddfat;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("key", score);
        editor.putInt("keypro", scorepro);
        editor.putInt("keycarb", scorecarb);
        editor.putInt("keyfat", scorefat);
        editor.commit();
        status=Math.round((double)score*100)/calgoal;
        statuspro=Math.round((double)scorepro*100)/progoal;
        statuscarb=Math.round((double)scorecarb*100)/carbgoal;
        statusfat=Math.round((double)scorefat*100)/fatgoal;
        Toast.makeText(Main2Activity.this, Double.toString((int)statuscarb),
                Toast.LENGTH_LONG).show();
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        //Drawable drawable2 = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);

        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);
        mProgress.setProgress((int)status);
        //////pro


        Resources res2 = getResources();
        Drawable drawable2 = res2.getDrawable(R.drawable.circular);
        final ProgressBar mProgresspro = (ProgressBar) findViewById(R.id.circularProgressbar2);
        mProgresspro.setProgress(0);   // Main Progress
        mProgresspro.setSecondaryProgress(100); // Secondary Progress
        mProgresspro.setMax(100); // Maximum Progress
        mProgresspro.setProgressDrawable(drawable2);
        mProgresspro.setProgress((int)statuspro);
        //carb


        Resources res3 = getResources();
        Drawable drawable3 = res3.getDrawable(R.drawable.circular);
        final ProgressBar mProgresscarb = (ProgressBar) findViewById(R.id.circularProgressbar3);
        mProgresscarb.setProgress(0);   // Main Progress
        mProgresscarb.setSecondaryProgress(100); // Secondary Progress
        mProgresscarb.setMax(100); // Maximum Progress
        mProgresscarb.setProgressDrawable(drawable3);
        mProgresscarb.setProgress((int)statuscarb);

        //fat

        Resources res4 = getResources();
        Drawable drawable4 = res4.getDrawable(R.drawable.circular);
        final ProgressBar mProgressfat = (ProgressBar) findViewById(R.id.circularProgressbar4);
        mProgressfat.setProgress(0);   // Main Progress
        mProgressfat.setSecondaryProgress(100); // Secondary Progress
        mProgressfat.setMax(100); // Maximum Progress
        mProgressfat.setProgressDrawable(drawable4);
        mProgressfat.setProgress((int)statusfat);
      /*  ObjectAnimator animation = ObjectAnimator.ofInt(mProgress, "progress", 0, 100);
        animation.setDuration(50000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();*/

        tv = (TextView) findViewById(R.id.tv);
        tv.setText((int)status + "%");
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText((int)statuspro + "%");
        tv32 = (TextView) findViewById(R.id.tv32);
        tv32.setText((int)statuscarb + "%");
        tv34 = (TextView) findViewById(R.id.tv34);
        tv34.setText((int)statusfat + "%");
        tv2 = (TextView) findViewById(R.id.simpleTextView2);
        tv2.setText(Double.toString(ddcal));
        tv4 = (TextView) findViewById(R.id.simpleTextView4);
        tv4.setText(Double.toString(score));

      /*  new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < (int)status) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (pStatus < (int)statuscarb) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgresscarb.setProgress(pStatus);
                            tv.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (pStatus < (int)statusfat) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgressfat.setProgress(pStatus);
                            tv.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (pStatus < (int)statuspro) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgresspro.setProgress(pStatus);
                            tv.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/
        button=(Button)findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),image.class);

                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this,ClassifierActivity.class));
    }
}

