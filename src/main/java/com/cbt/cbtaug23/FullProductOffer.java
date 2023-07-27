package com.cbt.cbtaug23;

public class FullProductOffer
{
    Product product;
    Productoffer productoffer;
    Userdetail userdetail;
    Integer totalPrice;

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Productoffer getProductoffer() {
        return productoffer;
    }

    public Userdetail getUserdetail() {
        return userdetail;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductoffer(Productoffer productoffer) {
        this.productoffer = productoffer;
    }

    public void setUserdetail(Userdetail userdetail) {
        this.userdetail = userdetail;
    }
}
