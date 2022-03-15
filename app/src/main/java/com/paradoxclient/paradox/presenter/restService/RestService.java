package com.paradoxclient.paradox.presenter.restService;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static RestService restService;
    public RestInterface restInterface;


    public RestService() {

        /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/
        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();


/*
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());*/

        restInterface = new Retrofit.Builder()
                .baseUrl(RestInterface.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestInterface.class);
    }



    public static RestService getInstance() {
        if (restService == null) {
            restService = new RestService();
        }

        return restService;
    }




}
