package com.example.Product.Helper;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestService {

    private final static OkHttpClient httpClient = new OkHttpClient();
    private final static String baseURLAccount = "http://localhost:8080/";

    public static Boolean doCheckSeller(Integer id) throws IOException {
    	
    	Boolean isValid = false;
    	
    	HttpUrl.Builder urlBuilder = HttpUrl.parse(baseURLAccount+"account/is-seller-exist").newBuilder();
    	urlBuilder.addQueryParameter("id", id.toString());
    	String newUrl = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(newUrl).
                build();
        
        try {
        Response response = httpClient.newCall(request).execute();
        isValid = Boolean.parseBoolean(response.body().string());
        }catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
        
        return isValid;

    }

}
