package com.sun.diffuntil;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerViewCountry;
    ArrayList<Country> countries;
    CountryAdapter countryAdapter;
    FloatingActionButton floatingActionButtonAdd, floatingActionSortByList;
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerViewCountry = findViewById(R.id.recyclerView);
        countries = createData();
        countryAdapter = new CountryAdapter(countries,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerViewCountry.setHasFixedSize(true);
        mRecyclerViewCountry.setLayoutManager(linearLayoutManager);
        mRecyclerViewCountry.setAdapter(countryAdapter);
        mRecyclerViewCountry.setItemAnimator(new DefaultItemAnimator());
        floatingActionButtonAdd = findViewById(R.id.floatingActionButtonAdd);
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    addToTheList();

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });
        floatingActionSortByList = findViewById(R.id.floatingActionButtonSortBySize);
        floatingActionSortByList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    changeCountryName();

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void addToTheList() throws CloneNotSupportedException {
        ArrayList<Country> newCountries = new ArrayList<>();
        for(Country country : countries){
            newCountries.add(country.clone());
        }
        newCountries.add(new Country(i++,R.drawable.japan_flag,"Japan"));
        newCountries.add(new Country(i++,R.drawable.senegal_flag,"Senegal"));
        newCountries.add(new Country(i++,R.drawable.indonesia_flag,"Indonesia"));
        newCountries.add(new Country(i++,R.drawable.laos_flag,"Laos"));
        countryAdapter.setCountriesData(newCountries);
    }

    private void changeCountryName() throws CloneNotSupportedException {
        ArrayList<Country> newCountries = new ArrayList<>();
        for (Country country : countries) {
            newCountries.add(country.clone());
        }
        for(Country country : newCountries){
            if(country.getmImageResource() == R.drawable.japan_flag || country.getmImageResource() == R.drawable.china_flag){
                country.setmImageResource(R.drawable.viet_nam_flag);
            }
        }
        countryAdapter.setCountriesData(newCountries);
    }

    private ArrayList<Country> createData() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(i++, R.drawable.viet_nam_flag,"Viet Nam"));
        countries.add(new Country(i++, R.drawable.england_flag,"England"));
        countries.add(new Country(i++, R.drawable.belgium_flag,"Belgium"));
        countries.add(new Country(i++,R.drawable.new_zealand_flag,"New zeadland"));
        countries.add(new Country(i++,R.drawable.united_kingdom_flag,"United Kingdom"));
        countries.add(new Country(i++,R.drawable.china_flag,"China"));
        return countries;
    }
}
