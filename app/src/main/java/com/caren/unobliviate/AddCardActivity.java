package com.caren.unobliviate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String question = getIntent().getStringExtra("question");
        String answer = getIntent().getStringExtra("answer");
        ((EditText) findViewById(R.id.questionTextField)).setText(question);
        ((EditText) findViewById(R.id.answerTextField)).setText(answer);

        findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                // Pass relevant data back as a result
                String question = ((EditText) findViewById(R.id.questionTextField)).getText().toString();
                String answer = ((EditText) findViewById(R.id.answerTextField)).getText().toString();
                data.putExtra("question", question);
                data.putExtra("answer", answer);
                setResult(RESULT_OK, data); // set result code and bundle data for response

                finish(); // closes the activity, pass data to parent
            }
        });
    }
}
