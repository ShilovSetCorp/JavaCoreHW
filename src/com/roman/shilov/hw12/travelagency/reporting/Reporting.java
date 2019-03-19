package com.roman.shilov.hw12.travelagency.reporting;

import com.roman.shilov.hw12.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw12.travelagency.order.domain.Order;
import com.roman.shilov.hw12.travelagency.order.service.OrderService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import static com.roman.shilov.hw12.travelagency.storage.Storage.ordersList;

public class Reporting {
    private static final String FILE_PATH = "report.txt";


    private OrderService orderService = ServiceSupplier.setSupplier().getOrderService();

    public static void reportMaker() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_PATH))) {
            for (Order order : ordersList) {
                String reportLine = order.getUser().toString() + ": \nCountry " + order.getBaseCountry().getName() + ", city: " + order.getCity().getName() + ", price: " + order.getPrice();
                writer.println(reportLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
