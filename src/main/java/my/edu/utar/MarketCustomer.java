package my.edu.utar;

public class MarketCustomer {

    private int totalDiscount, coupunDiscount, newMemberDiscount, loyaltyDiscount;
    private double amountSpent = 0.0;

    public MarketCustomer(int coupunDiscount, int newMemberDiscount, int loyaltyDiscount) {
        this.coupunDiscount = coupunDiscount;
        this.newMemberDiscount = newMemberDiscount;
        this.loyaltyDiscount = loyaltyDiscount;
    }

    public int getTotalDiscount() {
        return coupunDiscount + newMemberDiscount + loyaltyDiscount;
    }

    public void processDiscount(boolean haveCoupun, boolean existAcc, boolean newAcc) {

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
                    loyaltyDiscount += 10;
                else
                    throw new IllegalArgumentException();
            } else {
                if (newAcc)
                    newMemberDiscount += 15;
                else
                    throw new IllegalArgumentException();
            }
        }
    }


}
