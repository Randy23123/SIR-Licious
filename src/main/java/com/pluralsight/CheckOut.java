package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CheckOut {
    private ArrayList<String> items;
    private double totalPrice;


    public CheckOut(ArrayList<String> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void receipt() throws IOException {
        LocalDateTime time = LocalDateTime.now();
        String file = "receipt_" + time + ".txt";

        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write("Order Details:\n");
            bufferedWriter.write("Items:\n");
            for (String item : items) {
                bufferedWriter.write("- " + item + "\n");
            }
            bufferedWriter.write("Total Price: $" + totalPrice + "\n");

            System.out.println("Order receipt saved to " + file);
            items.clear();
            totalPrice = 0.0;
        }
    }
}
