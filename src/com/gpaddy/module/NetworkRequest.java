package com.gpaddy.module;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkRequest {

	public NetworkRequest() {

	}

	public Observable<Data> requestShopee(String url) {
		return Observable.create(new ObservableOnSubscribe<Data>() {
			@Override
			public void subscribe(ObservableEmitter<Data> arg0) throws Exception {
				try {
					String id= convertID(url);
					String urlApi = "https://shopee.vn/api/v2/item/get?" + id;
					String key= convertKey(id);
					System.out.println("Api: "+urlApi +" ;key: "+key);
					OkHttpClient client = new OkHttpClient().newBuilder().build();
					Request request = new Request.Builder()
							.url(urlApi).method("GET", null)
							.addHeader("accept", "*/*")
							.addHeader("user-agent",
									"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
							.addHeader("x-requested-with", "XMLHttpRequest")
							.addHeader("referer", "https://shopee.vn/user/account/profile/")
							.addHeader("if-none-match-", "55b03-da5730cb9c387af8602faa14e0ed95dd").build();

					Response response = client.newCall(request).execute();

					String body = response.body().string();
					Gson gson = new Gson();
					Data entity = gson.fromJson(body, Data.class);
					arg0.onNext(entity);
					arg0.onComplete();
				}catch (Exception e) {
					System.out.println("Error: "+e);
					arg0.onError(e);
				}
				
			}

		});
	}
	
	private String convertID(String url) {
		String[] arr = url.split("/");
		String shopid = arr[4];
		String itemid = arr[5].split("\\?")[0];
		String id = "itemid=" + itemid + "&shopid=" + shopid;
		System.out.println("Arr: " + itemid + "; shop: " + shopid);
		return id;
	}

	private String convertKey(String id) {		
		String hash= toMd5(id);
		return "55b03" + hash + "55b03";
	}
	
	private String toMd5(String s) {
			try {
				MessageDigest md5;
				md5 = MessageDigest.getInstance("MD5");
				md5.update(StandardCharsets.UTF_8.encode(s));
				return String.format("%032x", new BigInteger(1, md5.digest()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return "SANG";
		
	}
}
