package com.gpaddy.module.main;

import com.google.gson.Gson;
import com.gpaddy.module.model.DataSendo;
import com.gpaddy.module.model.Item;
import com.gpaddy.module.model.ItemSendo;
import com.gpaddy.module.model.ItemTiki;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkRequestSendo {

	public NetworkRequestSendo() {
	}

	public Observable<Item> requestSendo(String url) {
		return Observable.create(new ObservableOnSubscribe<Item>() {
			@Override
			public void subscribe(ObservableEmitter<Item> arg0) throws Exception {
				try {

					String urlApi= convertID(url);
					System.out.println("Api: "+urlApi );
					OkHttpClient client = new OkHttpClient().newBuilder().build();
					Request request = new Request.Builder()
							.url(urlApi).method("GET", null)
							.addHeader("accept", "*/*")
							.addHeader("user-agent",
									"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
							.addHeader("referer", "https://www.sendo.vn/")
							.build();

					Response response = client.newCall(request).execute();

					String body = response.body().string();

					Gson gson = new Gson();
					DataSendo entity = gson.fromJson(body, DataSendo.class);
//					System.out.println("Sendo, body: " + entity.getId());
					Item item= new Item(entity.getItem().getId(),
							entity.getItem().getUrlKey(),
							entity.getItem().getName(),
							entity.getItem().getImage(),
							entity.getItem().getPrice());

					arg0.onNext(item);
					arg0.onComplete();
				}catch (Exception e) {
					System.out.println("Error: "+e);
					arg0.onError(e);
				}
				
			}

		});
	}

	//https://www.sendo.vn/bong-den-sac-tich-dien-100w-day-cam-usb-tien-loi-44895391.html


	public String convertID(String url) {
		String[] arr = url.split("/");
		String id="";
		for (String k: arr){
			System.out.println("Sendo, url1: "+ k );
			if (k.endsWith(".html")) {
				System.out.println("Sendo, id: " + k);
				id=k.replace(".html","");
				System.out.println("Sendo, id1: " + id);
			}
		}

		String urlApi="https://detail-api.sendo.vn/full/"+id+"?platform=web";
		return urlApi;
	}

	

}
