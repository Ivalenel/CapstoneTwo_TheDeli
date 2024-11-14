package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    // Save order receipt to a timestamped file
    public static void saveReceipt(String receiptContent) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "Receipt_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Order Receipt\n");
            writer.write("Date and Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");
            writer.write(receiptContent);
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }

    // Append order to a formatted CSV file
    public static void saveToCsv(String orderDetails, double totalPrice) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DeliOrders.csv", true))) {
            writer.write("Order Timestamp: " + timestamp + "\n");
            writer.write("Total Price: $" + totalPrice + "\n");
            writer.write("Order Details:\n");
            writer.write(orderDetails + "\n");
            writer.write("----------------------------------------------------------\n\n");
            System.out.println("Order appended to DeliOrders.csv");
        } catch (IOException e) {
            System.err.println("An error occurred while saving to CSV: " + e.getMessage());
        }
    }
}
