package com.example.a11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.xeditText);
        textView = findViewById(R.id.xtextView);

        Button button = findViewById(R.id.xbutton);
        button.setOnClickListener(v -> makeRequest());

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    public void makeRequest() {
        String url = editText.getText().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> println("응답 -> " + response),
                error -> println("에러 -> " + error.getMessage())
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄");
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}