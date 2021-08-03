package com.gpaddy.module.main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;

import com.gpaddy.module.model.DataShopee;
import com.gpaddy.module.model.Item;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkRequestShopee {

	public NetworkRequestShopee() {

	}

	public Observable<Item> requestShopee(String url) {
		return Observable.create(new ObservableOnSubscribe<Item>() {
			@Override
			public void subscribe(ObservableEmitter<Item> arg0) throws Exception {
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
					DataShopee entity = gson.fromJson(body, DataShopee.class);
//
					Item item= new Item(entity.getItem().getItemid(),
							entity.getItem().getShopId(),
							entity.getItem().getName(),
							"https://cf.shopee.vn/file/"+entity.getItem().getImage(),
							entity.getItem().getPrice()/100000);
					arg0.onNext(item);
					arg0.onComplete();
				}catch (Exception e) {
					System.out.println("Error: "+e);
					arg0.onError(e);
				}

			}

		});
	}

	private String convertID(String url) {
		String id= "";
		String[] arr = url.split("/");
		if (arr[3].equals("product")){
			String shopid = arr[4];
			String itemid = arr[5].split("\\?")[0];
			id = "itemid=" + itemid + "&shopid=" + shopid;

		}else {
			String[] arr1 = arr[3].split("\\?");
			String[] arr2= arr1[0].split("\\.");
			String shopid = arr2[1];
			String itemid = arr2[2];
			 id = "itemid=" + itemid + "&shopid=" + shopid;
		}

		return id;
	}
//	public String convertID2(String url) {
//		String[] arr = url.split("/");
//
//		System.out.println("id: "+ id);
//		return id;
//	}
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
