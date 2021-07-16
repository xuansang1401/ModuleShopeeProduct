package com.gpaddy.module.main;


import com.gpaddy.module.model.Item;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;

public class NetworkRequestLazada {

    public NetworkRequestLazada() {
    }

    public Observable<Item> requestLazada(String url) {
        return Observable.create(new ObservableOnSubscribe<Item>() {
			@Override
			public void subscribe(ObservableEmitter<Item> arg0) throws Exception {

				try {
					Document document = (Document) Jsoup.connect(url).get();
					Elements elementScripts = document.getElementsByTag("script");
					for (int j = 0; j < elementScripts.size(); j++) {
						if (elementScripts.get(j).data().contains("__moduleData__")) {
							String script = elementScripts.get(j).toString();
							String moduleData = script.substring(script.indexOf("var __moduleData__"), script.indexOf("var __googleBot__")).replace("var __moduleData__", "").replace(";", "").replace(" = ", "");
							JSONObject jsonObject1 = new JSONObject(moduleData);
							JSONObject jsonItems = jsonObject1.getJSONObject("data").getJSONObject("root").getJSONObject("fields").getJSONObject("skuInfos").getJSONObject("0");
							String name = jsonItems.getJSONObject("dataLayer").getString("pdt_name");
							String imgUrl = jsonItems.getString("image");
							Long originalPrice = jsonItems.getJSONObject("price").getJSONObject("originalPrice").getLong("value");
							Long salePrice = jsonItems.getJSONObject("price").getJSONObject("salePrice").getLong("value");

							Long price=salePrice;
							if (salePrice==0){
								price=originalPrice;
							}
							Long id = jsonItems.getLong("itemId");
							Long shopId = jsonItems.getLong("sellerId");
							Item item = new Item(id,
									shopId.toString(),
									name,
									imgUrl,
									price);
							arg0.onNext(item);
							arg0.onComplete();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					arg0.onError(e);
				}


			}

		});
    }
}