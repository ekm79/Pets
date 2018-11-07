package com.lambdaschool.pets;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_PET_KEY = "edit_pet";

    EditText editName, editType;
    Pet pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName = findViewById(R.id.edit_name);
        editType = findViewById(R.id.edit_type);

        pet = (Pet) getIntent().getSerializableExtra(EDIT_PET_KEY);

        if(pet == null) {
            pet = new Pet(Pet.NO_ID);
        }

        //note = new Note();

    }

    @Override
    public void onBackPressed() {
        prepResult();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        prepResult();
    }

    private void prepResult() {
        pet.setName(editName.getText().toString());
        pet.setType(editType.getText().toString());
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_PET_KEY, pet);
        setResult(Activity.RESULT_OK, resultIntent);
    }
}
