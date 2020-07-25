package com.example.volley_example;


import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class LoginRequest extends JsonObjectRequest {
    //web 주소
    private static final String LOGIN_REQUEST_URL = IpPath.WEBIP + "/post";
    private static JSONObject jsonBody = new JSONObject();

    // string,string 해쉬맵
    private Map<String, String> params;
    private byte[] body;


    //생성자
    public LoginRequest(byte[] content, Response.Listener<JSONObject> listener) {
        //post형식으로 전송
        super(Method.POST,LOGIN_REQUEST_URL,null,listener,null);
        body = content;
        //매개변수 저장 , key : value
    }




    @Override
    public String getBodyContentType() {
        return super.getBodyContentType();
    }

    @Override
    public byte[] getBody() {
        JSONObject j = new JSONObject();
        try {
            j.put("hello","hello");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return j.toString().getBytes();
    }
}