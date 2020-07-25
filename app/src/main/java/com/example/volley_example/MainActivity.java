package com.example.volley_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Response.Listener<JSONObject> responseListener;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 로그인시 리스너 객체
        // Response received from the server 서버에서 내용을 받았을때 처리할 내용!
        responseListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.e("h","Response: "+ response);
                Toast.makeText(getApplicationContext(),"sucsess", Toast.LENGTH_LONG).show();
            }
        };

        setContentView(R.layout.activity_main);

        // activity 객체들
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);

        //로그인 버튼!!
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = "hello!";

                // EditText에 들어온 ID와 PW로 로그인 시도!
                LoginRequest loginRequest = new LoginRequest(temp.getBytes(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
