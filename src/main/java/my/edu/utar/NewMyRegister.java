package my.edu.utar;

import java.time.Year;

interface ICheckOutObject {
    public int pickABook();
    public void updateRecord(boolean proceed);
}

class DummyCheckOutObject implements ICheckOutObject {

    private int year;
    private boolean proceed;

    public DummyCheckOutObject(int year) {
        this.year = year;
    }

    @Override
    public int pickABook() {
        return year;
    }

    public void updateRecord(boolean proceed) {
        this.proceed = proceed;
    }

    public boolean getProceed() {
        return proceed;
    }
}

public class NewMyRegister {

    ICheckOutObject co;

    public NewMyRegister() {}

    public NewMyRegister(ICheckOutObject co) { this.co = co; }

    public int getCurrentYear(){
        return Year.now().getValue();
    }

    public void borrowBook(){
        int year;
        boolean proceed;

        year = co.pickABook();

        if((getCurrentYear() - year) < 5)
            proceed = true;
        else
            proceed = false;
        co.updateRecord(proceed);
    }



}
