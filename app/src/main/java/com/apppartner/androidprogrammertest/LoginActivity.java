package com.apppartner.androidprogrammertest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;


public class LoginActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
    public void onBackBtnClicked(View v){
        onBackPressed();
    }
   public void onLoginButtonClicked(View v){

       final long[] time = new long[2];
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        String user= ((EditText)findViewById(R.id.usernametxt)).getText().toString();
        String pass= ((EditText)findViewById(R.id.passwordtxt)).getText().toString();
        params.put("username", user);
        params.put("password", pass);

       time[0] = System.currentTimeMillis();
        client.post("http://dev.apppartner.com/AppPartnerProgrammerTest/scripts/login.php",params,new AsyncHttpResponseHandler(){
        @Override
        public void onStart() {
        // called before request is started



    }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] response){
            // called when response HTTP status is "200 OK"
             time[1] = System.currentTimeMillis();
            long responseTime=time[1]-time[0];
            alertBox(response,responseTime);

        }


        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)

    }

        @Override
        public void onRetry(int retryNo) {
        // called when request is retried
    }
    });


    }
    public void alertBox(byte[] response, long responseTime){
        String str=new String(response);

        AlertDialog alert=new AlertDialog.Builder(this)
                .setTitle("Response From API")
                .setMessage(str + " "+"\n"+"The API took"+" "+responseTime +" "+"millliseconds to respond" )
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        onBackPressed();
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();



    }





    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
