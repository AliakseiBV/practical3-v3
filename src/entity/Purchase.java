package entity;

public class Purchase implements java.lang.Comparable<Purchase> {
    private final static String PURCHASE_NAME = "Rkatsiteli";
    private final static int PRICE = 2000;
    private int numberOfUnits;
    private int discountPercent;
    private WeekDay weekDay;


    public Purchase(){
        this.numberOfUnits = 2;
        this.discountPercent = 0;
        this.weekDay = WeekDay.SUNDAY;
    }

    public Purchase(int numberOfUnits, int discountPercent, int weekDay) {
        this.numberOfUnits = numberOfUnits;
        this.discountPercent = discountPercent;
        this.weekDay = getWeekDay(weekDay);
    }


    @Override
    public String toString(){
        return numberOfUnits + ";" + discountPercent + ";" + weekDay + ";" + getPriceInCurrency(getCost());
    }

    public int getCost(){
        return PRICE * numberOfUnits * (100 - discountPercent) / 100;
    }

    public static String getPriceInCurrency(int amount) {
        return String.format("%d.%02d", amount / 100, amount % 100);
    }

    public boolean equals(Purchase o){
        return this.numberOfUnits == o.numberOfUnits;
    }

    @Override
    public int compareTo(Purchase o){
        return this.numberOfUnits - o.numberOfUnits;
    }
/*
    @Override
    public int compareTo(Purchase purchase) {
        if (this.numberOfUnits < purchase.numberOfUnits){
            return 1;
        } else if (this.numberOfUnits == purchase.numberOfUnits) {
            return 0;
        }else
            return -1;
    }
*/


    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }
    public WeekDay getWeekDay(int weekday) {
        switch (weekday) {
            case 0:
                return WeekDay.SUNDAY;
            case 1:
                return WeekDay.MONDAY;
            case 2:
                return WeekDay.TUESDAY;
            case 3:
                return WeekDay.WEDNESDAY;
            case 4:
                return WeekDay.THURSDAY;
            case 5:
                return WeekDay.FRIDAY;
            case 6:
                return WeekDay.SATURDAY;
            default:
                return null;
        }
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }
}
