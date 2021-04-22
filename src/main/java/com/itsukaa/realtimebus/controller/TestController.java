package com.itsukaa.realtimebus.controller;

import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() throws IOException {
        String url = "http://bus.wuhancloud.cn:9087/website/web/420100/line/027-804-1.do?Type=LineDetail";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });

        return "1";
    }

}
