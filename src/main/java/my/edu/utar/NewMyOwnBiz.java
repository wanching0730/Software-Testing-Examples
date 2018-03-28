package my.edu.utar;

import java.util.Random;

interface RandomGet {
    public int getPromoItems();
    public void updatePrice(int discount);
}

class DummySalesObject implements RandomGet{

    int quantity;
    int discount;

    public DummySalesObject(int qty) {
        this.quantity = qty;
    }

    @Override
    public int getPromoItems() {
        return quantity;
    }

    @Override
    public void updatePrice(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}

public class NewMyOwnBiz {
    RandomGet rg;

    public NewMyOwnBiz(RandomGet rd){
        this.rg = rg;
    }

    public void doPromotion(){
        int quantity;
        int discount;

        quantity = rg.getPromoItems();

        if(quantity < 5000)
            discount =10;
        else
            discount = 5;
        rg.updatePrice(discount);
    }
}
