package com.example.loren.dlrg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.example.loren.dlrg.Model.Kurs;
import com.example.loren.dlrg.Model.VolleyService;
import com.example.loren.dlrg.interfaces.ApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class KursFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    //Interface for Volley Call
    ApiResult apiResult;

    ArrayList<Kurs> kurse;
    private RecyclerView recyclerView;
    private MyPersonRecyclerViewAdapter mAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public KursFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static KursFragment newInstance(int columnCount) {
        KursFragment fragment = new KursFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_list, container, false);

        //Interface for API Volley call
        initApiResult();
        kurse = new ArrayList<>();

        //create VolleyService to get Data from API
        VolleyService volleyService = new VolleyService(apiResult,getContext());
        //get Data from URL -> interface
        volleyService.getDataFromUrl("http://192.168.64.2/api_db.php");

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            mAdapter = new MyPersonRecyclerViewAdapter(kurse, mListener);
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Kurs kurs);
    }

    public void initApiResult(){
        apiResult = new ApiResult() {
            @Override
            public void notifySuccess(JSONArray response) {
                Log.d("Volley",response.toString());
                getPersonFromJson(response);
                //notify adapter
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void notifyError(VolleyError error) {
                Log.d("Fail",error.toString());

            }
        };
    }
    
    public void getPersonFromJson(JSONArray response){
        for(int i = 0; i<response.length();i++){
            try {
                JSONObject jsonObject = response.getJSONObject(i);
                Kurs kurs = new Kurs(jsonObject.getInt("Kurs_ID"),jsonObject.getString("Wochentag"));
                kurse.add(kurs);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
