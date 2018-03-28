package my.edu.utar;

public class MarketCustomer {

    private int coupunDiscount, newMemberDiscount, loyaltyDiscount;

    public MarketCustomer(int coupunDiscount, int newMemberDiscount, int loyaltyDiscount) {
        this.coupunDiscount = coupunDiscount;
        this.newMemberDiscount = newMemberDiscount;
        this.loyaltyDiscount = loyaltyDiscount;
    }

    public int getTotalDiscount() {
        return coupunDiscount + newMemberDiscount + loyaltyDiscount;
    }

    public void processDiscount(boolean haveCoupun, boolean existAcc, boolean newAcc) {

<<<<<<< HEAD
        if (haveCoupun) {
            if (existAcc) {
                if (!newAcc) {
                    loyaltyDiscount += 10;
                    coupunDiscount += 20;
                } else {
                    throw new IllegalArgumentException();
                }
            } else
                coupunDiscount += 20;
        } else {
            if (existAcc) {
                if (!newAcc)
=======
        if(haveCoupun) {
            if(existAcc) {
                if(!newAcc) {
                    loyaltyDiscount += 10;
                    coupunDiscount += 20;
                } else
                    throw new IllegalArgumentException();
            } else
                coupunDiscount += 20;
        } else {
            if(existAcc) {
                if(!newAcc)
>>>>>>> 85798357cb3bcf339962d6fd8b512ce9c9f7f4fb
                    loyaltyDiscount += 10;
                else
                    throw new IllegalArgumentException();
            } else {
<<<<<<< HEAD
                if (newAcc)
                    newMemberDiscount += 15;
                else
                    throw new IllegalArgumentException();
=======
                if(newAcc)
                    newMemberDiscount += 15;
>>>>>>> 85798357cb3bcf339962d6fd8b512ce9c9f7f4fb
            }
        }

    }


}
