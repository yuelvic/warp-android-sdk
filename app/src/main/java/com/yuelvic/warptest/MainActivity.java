package com.yuelvic.warptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yuelvic.warptest.http.WarpCallback;
import com.yuelvic.warptest.utils.WarpObject;
import com.yuelvic.warptest.utils.WarpResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.tv_result);

        Warp.initialize("http://192.168.0.137:3000/api/1/classes/", "f6d8g6987dfg98g7fd");
        WarpObject object = new WarpObject.Builder()
                .setClassName("location")
                .find(new WarpCallback() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(WarpResult result) {
                        textView.setText(new Gson().toJson(result));
                    }
                });
    }
}
