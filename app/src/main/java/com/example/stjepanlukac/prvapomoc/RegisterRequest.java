package com.example.stjepanlukac.prvapomoc;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stjepan Lukac on 12.4.2016..
 */

//ova klasa pravi request na register.php file na serveru i dobiva response kao string
public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://stjepanlukac.comli.com/Register.php";
    private Map<String, String> params;

    //pravimo konstruktor koji će se prvi izvršiti kada se stvori instanca na RegisterRequest klasu
    public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener){

        /*preko POST metode šaljemo podatke u register.php i on nam daje reposnse
        i kada volley završi request tada preko listenera obavještavamo da je sve prošlo okej*/

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();   //preko params pristupamo podacima
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("age", age + "");
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
