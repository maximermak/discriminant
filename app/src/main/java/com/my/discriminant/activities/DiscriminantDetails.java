package com.my.discriminant.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.my.discriminant.App;
import com.my.discriminant.R;
import com.my.discriminant.room.DetailsModel;

import java.util.Objects;

public class DiscriminantDetails extends AppCompatActivity {

    Details details = new Details();

    TextInputEditText a,b,c;
    TextView answer;
    TextWatcher toWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
                calculate();
        }
    };

    private void calculate() {
         String result = "";
        String textA = a.getText().toString();
        String textB = b.getText().toString();
        String textC = c.getText().toString();
        if (!textA.equals("") && !textB.equals("")&& !textC.equals("")) {
            result = details.writeDetails(Integer.parseInt(textA),Integer.parseInt(textB),Integer.parseInt(textC));
        }
        else{
            result = "";
        }
        answer.setText(result);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discriminant_details);

        FloatingActionButton fab = findViewById(R.id.fabSave);
        fab.setOnClickListener(view -> {
            Toast.makeText(this, "Save clicked", Toast.LENGTH_SHORT).show();

            DetailsModel detailsModel = new DetailsModel();
            detailsModel.a = Objects.requireNonNull(a.getText()).toString();
            detailsModel.b = Objects.requireNonNull(b.getText()).toString();
            detailsModel.c = Objects.requireNonNull(c.getText()).toString();

            App.getInstance().getDatabase().detailsDao().insert(detailsModel);
        });

        a = findViewById(R.id.et_a);
        b = findViewById(R.id.et_b);
        c = findViewById(R.id.et_c);
        answer = findViewById(R.id.tv_answer);
        a.addTextChangedListener(toWatch);
        b.addTextChangedListener(toWatch);
        c.addTextChangedListener(toWatch);
    }

}
