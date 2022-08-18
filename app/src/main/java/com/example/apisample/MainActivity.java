package com.example.apisample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<EmployeeData> employeelist= new ArrayList<EmployeeData>();

    RecyclerView rv;
    ProgressBar pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        pr = findViewById(R.id.pr);

        pr.setVisibility(View.VISIBLE);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Employee> call = apiService.getEmployees();

        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                pr.setVisibility(View.GONE);

                Log.d("message",response.code()+"");
                if(response.body().getData() != null) {

                    employeelist = (ArrayList<EmployeeData>) response.body().getData();



                    setAdapter(employeelist);
                }

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Log.d("message","error");

                pr.setVisibility(View.GONE);



            }
        });




    }
    private void setAdapter(ArrayList<EmployeeData> employeelist) {

        Adapter adapter = new Adapter(employeelist);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}