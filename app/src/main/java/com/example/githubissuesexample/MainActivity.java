package com.example.githubissuesexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.githubissuesexample.R.id.issuetitle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewCom;

    CutomAdapter adapter;
    CustomCommentAdapter commentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str;




        GetDataService service= RetrofitClient.getRetrofit().create(GetDataService.class);


        Call<List<Issues>> call = service.getAllIssue();


        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {
               Toast.makeText(MainActivity.this,"hello inside issue",Toast.LENGTH_LONG).show();
                getDataService(response.body());

            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }
        });



    }







    private void getDataService(List<Issues> body)
    {
        recyclerView=findViewById(R.id.recycle);
        adapter= new CutomAdapter(body,this);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

}