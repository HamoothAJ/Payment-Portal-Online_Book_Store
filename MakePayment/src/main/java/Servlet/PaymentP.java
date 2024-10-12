package Servlet;

public class PaymentP {
    private String cName;
    private String cardType;
    private int cardNumber;
    private int cvc;
    private String date; // Assuming date is a string representation

    private float amount;

    public PaymentP(String cName, String cardType, int cardNumber, int cvc, String date, float amount) {
        super();
        this.cName = cName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.date = date; // Assign the date parameter
        this.amount = amount;
    }

    public String getcName() {
        return cName;
    }

    public String getCardType() {
        return cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public String getDate() { // Change return type to String
        return date;
    }

    public float getAmount() {
        return amount;
    }
}
