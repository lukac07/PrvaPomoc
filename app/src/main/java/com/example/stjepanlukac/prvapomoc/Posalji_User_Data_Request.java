package com.example.stjepanlukac.prvapomoc;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stjepan Lukac on 18.5.2016..
 */
public class Posalji_User_Data_Request extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://stjepanlukac.comli.com/Setter.php";
    private Map<String, String> params;

    //pravimo konstruktor koji će se prvi izvršiti kada se stvori instanca na RegisterRequest klasu
    public Posalji_User_Data_Request(String username, String password, String krv, int tlak1, int tlak2, Double tezina, Double visina, int id, Response.Listener<String> listener){

        /*preko POST metode šaljemo podatke u register.php i on nam daje reposnse
        i kada volley završi request tada preko listenera obavještavamo da je sve prošlo okej*/

        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();   //preko params pristupamo podacima
        params.put("username", username);
        params.put("password", password);
        params.put("krv", krv);
        params.put("tlak1", tlak1 + "");
        params.put("tlak2", tlak2 + "");
        params.put("tezina", tezina + "");
        params.put("visina", visina + "");
        params.put("user_id", id + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
