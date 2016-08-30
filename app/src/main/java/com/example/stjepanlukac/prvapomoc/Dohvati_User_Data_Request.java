package com.example.stjepanlukac.prvapomoc;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stjepan Lukac on 18.5.2016..
 */
public class Dohvati_User_Data_Request  extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://stjepanlukac.comli.com/Dohvati.php";
    private Map<String, String> params;

    public Dohvati_User_Data_Request(String username, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
