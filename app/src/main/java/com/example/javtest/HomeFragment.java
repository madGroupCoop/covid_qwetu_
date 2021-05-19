package com.example.javtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class HomeFragment extends Fragment {
    private TextView confirmed1,recovered1,deaths1,confirmedToday,recoveredToday,deathsToday;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //call view
        confirmed1 = root.findViewById(R.id.confirmed1);
        recovered1 = root.findViewById(R.id.recovered1);
        deaths1 = root.findViewById(R.id.deaths1);
        confirmedToday = root.findViewById(R.id.confirmedToday);
        recoveredToday = root.findViewById(R.id.recoveredToday);
        deathsToday = root.findViewById(R.id.deathsToday);



        // call Volley
        getData();

        return root;
    }

    //Getting data from API
    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        String url = "https://corona.lmao.ninja/v2/countries/kenya";
        @SuppressLint("SetTextI18n") StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {

            try {
                JSONObject jsonObject = new JSONObject(response);

                confirmed1.setText(jsonObject.getString("cases"));
                deaths1.setText(jsonObject.getString("deaths"));
                recovered1.setText(jsonObject.getString("recovered"));
                confirmedToday.setText("+"+(jsonObject.getString("todayCases")));
                recoveredToday.setText("+"+(jsonObject.getString("todayRecovered")));
                deathsToday.setText("+"+(jsonObject.getString("todayDeaths")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, (error -> Log.d("Error Response",error.toString())));

        queue.add(stringRequest);
    }



}


