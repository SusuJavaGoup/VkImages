package ru.alexp.itschool.vkimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

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
                    loadWallImages();
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

        ((EditText) findViewById(R.id.groupIdField)).setText("joyreactor_ru"); // for fast start
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

    private void loadWallImages() {
        ((TextView) findViewById(R.id.infoMessage)).setText("Loading ...");

        final String id = Vars.getValue("groupId", "");
        VKParameters params;
        if (id.startsWith("-")) {
            params = VKParameters.from(VKApiConst.OWNER_ID, id);
        } else {
            params = VKParameters.from("domain", id);
        }
        params.put("count", 20); // мне пока надо только 20

        VKRequest request = new VKRequest("wall.get", params);
        request.executeSyncWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onError(VKError error) {
                ((TextView) findViewById(R.id.infoMessage)).setText(error.toString());
            }

            @Override
            public void onComplete(VKResponse response) {
                try {
                    ImageManager.getIstance().parseImages(response.json.getJSONArray("items")); // парсим все каритнки
                    ((TextView) findViewById(R.id.infoMessage)).setText("Done");
                    setContentView(R.layout.activity_image_weaver);
                } catch (Exception e) {
                    ((TextView) findViewById(R.id.infoMessage)).setText(e.getMessage());
                }
            }
        });
    }
}
