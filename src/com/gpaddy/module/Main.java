package com.gpaddy.module;

public class Main {
    public static void main(String[] args) {
        NetworkRequest nw= new NetworkRequest();
        nw.requestShopee("https://shopee.vn/product/331346099/7561066412?smtt=0.29909045-1626160856.9")
        .subscribe(d->{
            System.out.println("Data: "+d.getItem().getImage());
        },Throwable::printStackTrace);

    }
}
