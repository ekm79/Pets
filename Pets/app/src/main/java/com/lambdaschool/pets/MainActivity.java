package com.lambdaschool.pets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int EDIT_REQUEST_CODE = 1;

    //EditText userInput;
    Button addButton;
    TextView textView;
    LinearLayout listLayout;
    ArrayList<Pet> pets;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        listLayout = findViewById(R.id.text_layout);
        textView = findViewById(R.id.list_text);
        addButton = findViewById(R.id.add_button);
        pets = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                Pet newPet = new Pet(pets.size());
                pets.add(newPet);
                intent.putExtra(EditActivity.EDIT_PET_KEY, newPet);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });

    }

    private TextView getDefaultTextView(Pet pet) {
        TextView textView = new TextView(context);
        textView.setText(pet.getName());
        textView.setTextSize(24);
        textView.setPadding(10, 10, 10, 10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                //intent.putExtra(EditActivity.EDIT_NOTE_KEY, note);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });
        return textView;
    }
    private void refreshListView() {
        listLayout.removeAllViews();
        for(Pet pet: pets) {
            listLayout.addView(getDefaultTextView(pet));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == EDIT_REQUEST_CODE) {
                if (data != null) {
                    Pet returnedPet = (Pet) data.getSerializableExtra(EditActivity.EDIT_PET_KEY);

                    boolean foundNote = false;
                    for(int i = 0; i < pets.size(); ++i) {
                        if(pets.get(i).getId() == returnedPet.getId()) {
                            pets.add(i, returnedPet);
                            foundNote = true;
                        }
                        if(!foundNote) {
                            pets.add(returnedPet);
                        }
                    }



                    //notes.add(returnedNote);
                    //int index = notes.size()-1;
                    //listLayout.addView(getDefaultTextView(notes.get(index)));
                }
            }
        }
    }
}
