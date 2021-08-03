package com.gpaddy.module.main;

import com.google.gson.Gson;
import com.gpaddy.module.model.Item;
import com.gpaddy.module.model.ItemTiki;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkRequestTiki {

	public NetworkRequestTiki() {
	}

	public Observable<Item> requestTiki(String url) {
		return Observable.create(new ObservableOnSubscribe<Item>() {
			@Override
			public void subscribe(ObservableEmitter<Item> arg0) throws Exception {
				try {
//					https://tiki.vn/api/v2/products/73568379?platform=web&spid=73568383

//					https://tiki.vn/api/v2/products/74500335?platform=web&spid=74500336
					String urlApi= convertID(url);
//					accept: application/json, text/plain, */*
					System.out.println("Api: "+urlApi );
					OkHttpClient client = new OkHttpClient().newBuilder().build();
					Request request = new Request.Builder()
							.url(urlApi).method("GET", null)
							.addHeader("accept", "application/json, text/plain, */*")
							.addHeader("user-agent",
									"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
							.addHeader("referer", url)
							.build();

					Response response = client.newCall(request).execute();

					String body = response.body().string();
					Gson gson = new Gson();
					ItemTiki entity = gson.fromJson(body, ItemTiki.class);
//					Long id, String shopId, String name, String image, Long price
					Item item= new Item(entity.getId(), entity.getMasterId(), entity.getName(), entity.getImage(),entity.getPrice());
					arg0.onNext(item);
					arg0.onComplete();
				}catch (Exception e) {
					System.out.println("Error: "+e);
					arg0.onError(e);
				}
				
			}

		});
	}

	//https://tiki.vn/camera-ip-wifi-tp-pink-tapo-c200-full-hd-1080p-giam-sat-an-ninh-hang-chinh-hang-p74500335.html?spid=74500336
//https://tiki.vn/mat-kinh-nu-aldo-abilithaa-p93151323.html?itm_campaign=PDP_YPD_TKA_PLA_UNK_ALL_UNK_UNK_UNK_UNK_X.29411_Y.222665_Z.1155470_CN.Kinh-mat-nu---Jul%252721&itm_medium=CPC&itm_source=tiki-ads&spid=93151324

	public String convertID(String url) {
		String[] arr = url.split("\\?");
		String[] string  = arr[0].split("-p");
		String itemid = arr[1];
		String id="";
		for (String k: string){
			if (k.endsWith(".html")) {
				id=k.replace(".html","");
			}
		}
		String urlApi="https://tiki.vn/api/v2/products/"+id+"?platform=web&"+itemid;
		return urlApi;
	}

	

}
