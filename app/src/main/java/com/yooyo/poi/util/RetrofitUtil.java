package com.yooyo.poi.util;

import com.yooyo.poi.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {

	public static OkHttpClient createOkHttpClient(){
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(logging)
				.connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
				.writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
				.readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
				.build();

		return client;
	}

	public static Retrofit createRetrofit(){
		Retrofit retrofit = new Retrofit.Builder()
				.client(RetrofitUtil.createOkHttpClient())
				.baseUrl(Constants.END_POIND)
				.addConverterFactory(GsonConverterFactory.create())
				.addConverterFactory(ScalarsConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}
}
