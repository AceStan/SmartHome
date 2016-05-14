package com.example.aleksandar.raspberrycommunication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends Activity implements Callback<MyResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boiler ;
        final TextView boiler_status;
        Button klima ;
        final TextView klima_status;
        boiler = (Button)findViewById(R.id.boiler);
        boiler_status = (TextView)findViewById(R.id.boiler_status);
        klima = (Button)findViewById(R.id.klima);
        klima_status = (TextView)findViewById(R.id.klima_status);
        boiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<MyResponse> call;
                call = RestClient.getUrlService().updateStatus("Boiler");
                call.enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Response<MyResponse> response, Retrofit retrofit) {
                        Log.d("Success", response.body().getMessage());
                        if(response.body().getStatus() == 1)
                        {
                            boiler_status.setText("On");
                        }
                        else
                        {
                            boiler_status.setText("Off");
                        }
                     }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        klima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<MyResponse> call;
                call = RestClient.getUrlService().updateStatus("Klima");
                call.enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Response<MyResponse> response, Retrofit retrofit) {
                        Log.d("Success", response.body().getMessage());
                        if(response.body().getStatus() == 1)
                        {
                            klima_status.setText("On");
                        }
                        else
                        {
                            klima_status.setText("Off");
                        }
                    }
                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
                }


        });

    }


    @Override
    public void onResponse(Response<MyResponse> response, Retrofit retrofit) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
