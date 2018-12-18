package com.hadilo.spinnertextinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hadilo.spinnertextinputlayout.widget.spinner.SpinnerTextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SpinnerTextInputLayout spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerGender  = findViewById(R.id.spinner_gender);

        spinnerGender.setItems(getGenderList());
        spinnerGender.setOnItemSelectedListener(new SpinnerTextInputLayout.OnItemSelectedListener<SpinnerTextInputLayout.Listable>() {
            @Override
            public void onItemSelectedListener(SpinnerTextInputLayout.Listable item, int selectedIndex) {
                spinnerGender.getEditText().setText(item.getLabel());
                spinnerGender.setErrorEnabled(false);
                spinnerGender.setError("");
            }
        });

    }

    private List<SpinnerTextInputLayout.Listable> getGenderList(){
        List<SpinnerTextInputLayout.Listable> genders = new ArrayList<>();
        genders.add(new SpinnerTextInputLayout.ItemModel("Laki-Laki"));
        genders.add(new SpinnerTextInputLayout.ItemModel("Perempuan"));
        return genders;
    }
}
