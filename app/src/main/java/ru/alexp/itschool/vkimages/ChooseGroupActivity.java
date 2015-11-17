package ru.alexp.itschool.vkimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ChooseGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_group);

        findViewById(R.id.selectGroupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = parseGroupId(((EditText) findViewById(R.id.groupIdField)).getText().toString());
                if (id != null) {
                    Vars.putValue("groupId", id);
                    setContentView(R.layout.activity_image_weaver);
                } else {
                    ((TextView) findViewById(R.id.infoMessage)).setText("NotFound");
                }

            }
        });

        ((EditText) findViewById(R.id.groupIdField)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                update();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                update();
            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }

            private void update() {
                ((TextView) findViewById(R.id.infoMessage)).setText(""); // при изменении очищаем лэйбл с ошибкой
            }
        });
    }

    private String parseGroupId(String id) {
        if (id.matches("^(https?://vk\\.com/)?([^/]+)$")) {

            id = id.replaceAll("^(https?://vk\\.com/)?([^/]+)/?$", "$2"); // если нам выдали целый URL

            if (id.matches("^(-|public)?(\\d{7,9})$")) { // если нам выдали id группы
                return '-' + id.replaceAll("^(-|public)?(\\d{7,9})$", "$2");
            } else {
                return id;
            }
        } else {
            return null; // если всё очень плохо
        }
    }
}
