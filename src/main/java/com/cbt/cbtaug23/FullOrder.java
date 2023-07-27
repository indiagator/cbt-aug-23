package com.cbt.cbtaug23;

public class FullOrder
{
    Order order;
    Userdetail buyerdetails;
    String offername;
    int totalprice;

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public void setBuyerdetails(Userdetail buyerdetails) {
        this.buyerdetails = buyerdetails;
    }

    public Order getOrder() {
        return order;
    }

    public String getOffername() {
        return offername;
    }

    public Userdetail getBuyerdetails() {
        return buyerdetails;
    }
}
