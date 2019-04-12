package com.roman.shilov.hw22.travelagency.reporting;

import com.roman.shilov.hw22.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw22.travelagency.order.domain.Order;
import com.roman.shilov.hw22.travelagency.order.service.OrderService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import static com.roman.shilov.hw22.travelagency.storage.Storage.ordersList;

public class Reporting implements ReportComponent {
    private static final String FILE_PATH = "report.txt";


    private OrderService orderService = ServiceSupplier.setSupplier().getOrderService();

    public void generateReport() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_PATH))) {
            for (Order order : ordersList) {
                String reportLine = order.getUser().toString() + ": \nCountry " + order.getBaseCountry().getName() + ", city: " + order.getCity().getName() + ", price: " + order.getPrice();
                writer.println(reportLine);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateReportLamb() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_PATH))) {
            for (Order order : ordersList) {
                String reportLine = order.getUser().toString() + ": \nCountry " + order.getBaseCountry().getName() + ", city: " + order.getCity().getName() + ", price: " + order.getPrice();
                writer.println(reportLine);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
