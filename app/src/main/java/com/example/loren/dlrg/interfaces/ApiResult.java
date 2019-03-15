package com.example.loren.dlrg.interfaces;

import com.android.volley.VolleyError;

import org.json.JSONArray;

public interface ApiResult {

    public void notifySuccess(JSONArray response);
    public void notifyError(VolleyError error);
}
