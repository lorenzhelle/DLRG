package com.example.loren.dlrg.Model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.loren.dlrg.interfaces.ApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VolleyService {

    ApiResult mResultCallback;
    Context mContext;

    public VolleyService(ApiResult resultCallback, Context context) {
        mResultCallback = resultCallback;
        mContext = context;
    }

    public void getDataFromUrl(String url) {
        //Request a JSON Array
        RequestQueue queue = Volley.newRequestQueue(mContext);

        try {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            mResultCallback.notifySuccess(response);


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mResultCallback.notifyError(error);
                }
            });
            queue.add(jsonArrayRequest);

        } catch (Exception e) {

        }


    }
}
