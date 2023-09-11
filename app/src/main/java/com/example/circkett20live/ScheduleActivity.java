package com.example.circkett20live;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.circkett20live.Playerdetils.Data;
import com.example.circkett20live.Playerdetils.MainResponse;
import com.example.circkett20live.Retrofit.RetrofitClientInstance;
import com.example.circkett20live.Retrofit.RetrofitServices;
import com.example.circkett20live.databinding.ActivityScheduleBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MatchAdapter matchAdapter;

    ActivityScheduleBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        matchAdapter = new MatchAdapter();
        recyclerView.setAdapter(matchAdapter);


        getLiveScore();


        binding.backButton.setOnClickListener(view -> {
            onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });


    }
    private void getLiveScore() {
        RetrofitServices services = RetrofitClientInstance.getApiClient().create(RetrofitServices.class);
        Call<MainResponse> call = services.getLiveScore(getResources().getString(R.string.live_Match_key), "0");
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful()) {
                    MainResponse mainResponse = response.body();
                    List<Data> dataList = mainResponse.getData();
                    matchAdapter.setMatches(dataList);

                    binding.recyclerView.setVisibility(View.VISIBLE);
                    binding.progressBar.setVisibility(View.GONE);
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                t.printStackTrace();
                // Handle network request failure here
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}