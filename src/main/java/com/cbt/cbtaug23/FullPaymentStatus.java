package com.cbt.cbtaug23;

public class FullPaymentStatus
{
    FullProductOffer offer;
    int bidamnt;

    public void setBidamnt(int bidamnt) {
        this.bidamnt = bidamnt;
    }

    public void setOffer(FullProductOffer offer) {
        this.offer = offer;
    }

    public FullProductOffer getOffer() {
        return offer;
    }

    public int getBidamnt() {
        return bidamnt;
    }
}
