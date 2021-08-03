package com.gpaddy.module.main;

public class Main {
    public static void main(String[] args) {
//        NetworkRequestShopee nw= new NetworkRequestShopee();
////        https://shopee.vn/product/42192570/1380361794?smtt=0.29909045-1626836689.9
////        "https://shopee.vn/product/331346099/7561066412?smtt=0.29909045-1626160856.9"
//        String url= "https://shopee.vn/-M%C3%A3-COSSBDCPC4-8-%C4%90H250k-Gel-s%E1%BB%AFa-ch%E1%BB%91ng-n%E1%BA%AFng-Senka-Perfect-UV-Gel-80ml-i.27495213.2041024195";
//        nw.requestShopee(url)
//        .subscribe(d->{
//            System.out.println("Data: "+d.toString());
//        },Throwable::printStackTrace);


//        NetworkRequestTiki tiki= new NetworkRequestTiki();
////        tiki.convertID("https://tiki.vn/camera-ip-wifi-tp-pink-tapo-c200-full-hd-1080p-giam-sat-an-ninh-hang-chinh-hang-p74500335.html?spid=74500336");
//
//        String url=
//                "https://tiki.vn/combo-dau-goi-kem-xa-dove-phuc-hoi-hu-ton-chiet-xuat-bo-dau-argan-botanical-selection-500g-chai-p16625310.html?spid=16625311&__s=ssdp&ssdp_block_code=infinite_scroll"
//                ;
//        tiki.requestTiki(url)
//        .subscribe(d->{
//            System.out.println("Data: "+d.toString());
//        },Throwable::printStackTrace);
//
//        NetworkRequestSendo sendo = new NetworkRequestSendo();
//        String url=
//"https://www.sendo.vn/combo-3-cai-kinh-bao-ho-chong-giot-ban-hang-cao-cap-44770128.html?fromItem=69663772&source_block_id=flash-sale&source_position=3&source_slot_id=50214683&source_category_group_id=0&source_page_id=flash-sale&source_info=desktop2_60_1627527814051_7aa0bf50-c7f3-4e0c-a1ea-81c8be416b01__default__3__"
//                ;
//        sendo.requestSendo(url)
//                .subscribe(d->{
//                    System.out.println("Data: "+d.toString());
//                },Throwable::printStackTrace);

        NetworkRequestLazada lazada = new NetworkRequestLazada();
        String url=
"https://s.lazada.vn/s.bK82t"
                ;
        lazada.requestLazada(url)
                .subscribe(d->{
                    System.out.println("Data: "+d.toString());
                },Throwable::printStackTrace);
    }
}   
