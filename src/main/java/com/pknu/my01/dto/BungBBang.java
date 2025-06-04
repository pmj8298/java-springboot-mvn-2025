package com.pknu.my01.dto;

import java.time.LocalDate;

public class BungBBang {
    private String flavor;
    private int price;
    private LocalDate madeDate;

    public BungBBang(String flavor, int price, LocalDate madeDate) {
        this.flavor = flavor;
        this.price = price;
        this.madeDate = madeDate;

    }

    public String getFlavor() {
        return flavor;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getMadeDate() {
        return madeDate;
    }

}
