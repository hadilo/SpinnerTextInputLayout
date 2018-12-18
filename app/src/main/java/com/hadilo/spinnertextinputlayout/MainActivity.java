package com.hadilo.spinnertextinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hadilo.spinnertextinputlayout.widget.spinner.SpinnerTextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SpinnerTextInputLayout spinnerGender;
    SpinnerTextInputLayout spinnerColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerGender  = findViewById(R.id.spinner_gender);
        spinnerColor  = findViewById(R.id.spinner_color);


        spinnerGender.setMode(SpinnerTextInputLayout.MODE_DROPDOWN);
        spinnerGender.setItems(getGenderList());
        spinnerGender.setOnItemSelectedListener(new SpinnerTextInputLayout.OnItemSelectedListener<SpinnerTextInputLayout.Listable>() {
            @Override
            public void onItemSelectedListener(SpinnerTextInputLayout.Listable item, int selectedIndex) {
                spinnerGender.getEditText().setText(item.getLabel());
                spinnerGender.setErrorEnabled(false);
                spinnerGender.setError("");
            }
        });

        spinnerColor.setMode(SpinnerTextInputLayout.MODE_POPUP);
        spinnerColor.setItems(getColorList());
        spinnerColor.setOnItemSelectedListener(new SpinnerTextInputLayout.OnItemSelectedListener<SpinnerTextInputLayout.Listable>() {
            @Override
            public void onItemSelectedListener(SpinnerTextInputLayout.Listable item, int selectedIndex) {
                spinnerColor.getEditText().setText(item.getLabel());
                spinnerColor.setErrorEnabled(false);
                spinnerColor.setError("");
            }
        });
    }

    private List<SpinnerTextInputLayout.Listable> getGenderList(){
        List<SpinnerTextInputLayout.Listable> genders = new ArrayList<>();
        genders.add(new SpinnerTextInputLayout.ItemModel("Laki-Laki"));
        genders.add(new SpinnerTextInputLayout.ItemModel("Perempuan"));
        return genders;
    }

    private List<SpinnerTextInputLayout.Listable> getColorList(){
        List<SpinnerTextInputLayout.Listable> genders = new ArrayList<>();
        genders.add(new SpinnerTextInputLayout.ItemModel("Merah"));
        genders.add(new SpinnerTextInputLayout.ItemModel("Kuning"));
        genders.add(new SpinnerTextInputLayout.ItemModel("Hijau"));
        return genders;
    }
}
