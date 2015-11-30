package com.ocit.trainingapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ocit.trainingapi.adapter.AdapterDisplaystatus;
import com.ocit.trainingapi.model.DisplayStatus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "http://raihanshop.com/index.php/api/status/displaystatusbyid";
    private ListView lv;
    private ArrayList<DisplayStatus> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        data = new ArrayList<>();
        getDataDisplaystatus();
    }

    private void getDataDisplaystatus() {
        StringRequest request = new StringRequest(Request.Method.POST, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        Type collectionType = new TypeToken<ArrayList<DisplayStatus>>() {
                        }.getType();
                        data = gson.fromJson(response.toString(), collectionType);

                        AdapterDisplaystatus adapter = new AdapterDisplaystatus(getApplicationContext(), data);
                        lv.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("onErrorResponse() called with: ", error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("id_creator", "7");
                return params;
            }
        };
        BaseApp.getsInstance().getRequestQueue().add(request);
    }
}