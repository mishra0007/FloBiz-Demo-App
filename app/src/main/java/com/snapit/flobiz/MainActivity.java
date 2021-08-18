package com.snapit.flobiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    CardView saleAd;
    RecyclerView recyclerView;
    ArrayList<AnimalDetails> animalDetailsArrayList;
    MyAdapter myAdapter;
    String[] animalNames;
    int[] animalImg;

    /*@Author Abhishek Mishra
    * @Date 18/08/2021*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saleAd = findViewById(R.id.saleAd);
        recyclerView = findViewById(R.id.recyclerViews);

        /*In this recycler View Animal image and name are repeated to create 25 entries as specified in tha assignment*/

        try {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            animalDetailsArrayList = new ArrayList<>();
            myAdapter = new MyAdapter(this,animalDetailsArrayList);
            recyclerView.setAdapter(myAdapter);

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //array of animal name
        animalNames = new String[]{
                "Bunny",
                "Cave Man",
                "Crab",
                "Elephant",
                "Fox",
                "Honey Bee",
                "Lamb",
                "Penguin",
                "Rat",
                "Shark",
                "Tiger",
                "Bunny",
                "Cave Man",
                "Crab",
                "Elephant",
                "Fox",
                "Honey Bee",
                "Lamb",
                "Penguin",
                "Rat",
                "Shark",
                "Tiger",
                "Bunny",
                "Cave Man",
                "Crab",
                "Elephant",
        };

        // array of animal image resource id
        animalImg = new int[]{
                R.drawable.bunny,
                R.drawable.caveman,
                R.drawable.crab,
                R.drawable.elephant,
                R.drawable.fox,
                R.drawable.honeybee,
                R.drawable.lamb,
                R.drawable.penguin,
                R.drawable.rat,
                R.drawable.shark,
                R.drawable.tiger,
                R.drawable.bunny,
                R.drawable.caveman,
                R.drawable.crab,
                R.drawable.elephant,
                R.drawable.fox,
                R.drawable.honeybee,
                R.drawable.lamb,
                R.drawable.penguin,
                R.drawable.rat,
                R.drawable.shark,
                R.drawable.tiger,
                R.drawable.bunny,
                R.drawable.caveman,
                R.drawable.crab,
                R.drawable.elephant,
        };
        getData();
    }

    //creating animalDetails array
    private void getData() {
        for(int i = 0; i<animalImg.length;i++){
            AnimalDetails animalDetails = new AnimalDetails(animalNames[i],animalImg[i]);
            animalDetailsArrayList.add(animalDetails);
        }
        //notifying adapter that some value are changed
        myAdapter.notifyDataSetChanged();
    }

    //Saved the user choice as shared preference
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("FloBiz",MODE_PRIVATE);
        int flag = sh.getInt("visibility",0);
        if(flag == 1){
            saleAd.setVisibility(View.GONE);
        }
    }


    //on click used to cross the ad Card View
    public void adButton(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("FloBiz",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("visibility",1);
        myEdit.apply();
        saleAd.setVisibility(View.GONE);
    }
}