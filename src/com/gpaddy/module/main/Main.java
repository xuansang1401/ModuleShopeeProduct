package com.gpaddy.module.main;

public class Main {
    public static void main(String[] args) {
//        NetworkRequestShopee nw= new NetworkRequestShopee();
//        nw.requestShopee("https://shopee.vn/product/331346099/7561066412?smtt=0.29909045-1626160856.9")
//        .subscribe(d->{
//            System.out.println("Data: "+d.getShopId());
//        },Throwable::printStackTrace);

//        NetworkRequestTiki tiki= new NetworkRequestTiki();
//        tiki.convertID("https://tiki.vn/camera-ip-wifi-tp-pink-tapo-c200-full-hd-1080p-giam-sat-an-ninh-hang-chinh-hang-p74500335.html?spid=74500336");

//        String url= "https://tiki.vn/thanh-long-trang-sky-fruit-qua-500gram-p110739443.html?spid=110739444";
//        tiki.requestTiki(url)
//        .subscribe(d->{
//            System.out.println("Data: "+d.getImage());
//        },Throwable::printStackTrace);


//        NetworkRequestSendo sendo = new NetworkRequestSendo();
//        String url= "https://www.sendo.vn/500g-cha-da-ot-xiem-26256623.html";
//        sendo.requestSendo(url)
//                .subscribe(d->{
//                    System.out.println("Data: "+d.getImage());
//                },Throwable::printStackTrace);

        NetworkRequestLazada lazada = new NetworkRequestLazada();
        String url= "https://www.lazada.vn/products/non-ket-van-go-doc-la-phoi-luoi-sieu-dep-mu-luoi-trai-theu-logo-tron-thoi-trang-i1298628100-s4973693890.html?spm=a2o4n.home.just4u.16.67cae182mLD0HT&scm=1007.17519.217310.0&pvid=1f990239-c305-4d3b-8d62-9b382be1b032&search=jfy&clickTrackInfo=tcsceneid%3AHPJFY%3Bbuyernid%3A28a4f906-8e0f-496e-8c1e-e77eb1aad100%3Btctags%3A1498575426+2024240392%3Btcboost%3A0%3Bpvid%3A1f990239-c305-4d3b-8d62-9b382be1b032%3Bchannel_id%3A0000%3Bmt%3Ahot%3Bitem_id%3A1298628100%3Bself_ab_id%3A217310%3Bself_app_id%3A7519%3Blayer_buckets%3A955.3629_955.7333_5437.25236_3650.16539_6008.28468_6059.28891_4944.22709_3650.16542_6008.28452_4944.22702%3Bpos%3A17%3B";
        lazada.requestLazada(url)
                .subscribe(d->{
                    System.out.println("Data: "+d.toString());
                },Throwable::printStackTrace);
    }
}
