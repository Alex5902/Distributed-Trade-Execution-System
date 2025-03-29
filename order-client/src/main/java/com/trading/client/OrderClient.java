package com.trading.client;

import com.trading.common.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        while (true) {
            System.out.print("Symbol: ");
            String symbol = scanner.nextLine();

            System.out.print("Side (buy/sell): ");
            String side = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Order order = new Order(symbol, price, quantity, side, System.currentTimeMillis());

            // Send via HTTP
            URL url = new URL("http://localhost:8080/api/orders");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(mapper.writeValueAsBytes(order));
            os.flush();
            os.close();

            System.out.println("Response Code: " + conn.getResponseCode());
        }
    }
}
