package common.src.main.java.com.trading.common.model;

import java.io.Serializable;

public class Order implements Serializable {
    private String symbol;
    private double price;
    private int quantity;
    private String side; // "buy" or "sell"
    private long timestamp;

    public Order() {}

    public Order(String symbol, double price, int quantity, String side, long timestamp) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getSide() { return side; }
    public void setSide(String side) { this.side = side; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return side + " " + quantity + " " + symbol + " @ " + price;
    }
}
