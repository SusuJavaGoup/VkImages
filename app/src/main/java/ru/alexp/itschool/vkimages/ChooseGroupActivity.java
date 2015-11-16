package ru.alexp.itschool.vkimages;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_group);

        ((Button) findViewById(R.id.selectGroupButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String value = ((EditText) findViewById(R.id.groupIdField)).getText().toString();
                Vars.putValue("groupId", value);
            }
        });
    }
}
