package com.roman.shilov.hw4;

import com.roman.shilov.hw4.event.service.EventMemoryService;
import com.roman.shilov.hw4.order.service.OrderMemoryService;
import com.roman.shilov.hw4.storage.Storage;
import com.roman.shilov.hw4.stuff.service.StuffMemoryService;
import com.roman.shilov.hw4.user.User;
import com.roman.shilov.hw4.user.service.UserMemoryService;

public class EventAgencyDemo {

    private static class App{
        private UserMemoryService userService = new UserMemoryService();
        private OrderMemoryService orderService = new OrderMemoryService();
        private EventMemoryService eventService = new EventMemoryService();
        private StuffMemoryService stuffService = new StuffMemoryService();

        private Storage storage = new Storage();

        private void addUsers() {
            String[] userArr = new String[]{"Move LLC | Vlad", "SES LLC | Konstantin", "Vitrina | Ekaterina"};

            for (String arUser : userArr){
                String[] userAtt = arUser.split("\\|");
                int attrIndex = -1;
                userService.addUser(new User(userArr[++attrIndex], userArr[++attrIndex]));
            }
        }

        public void fillStorage() {
            addUsers();
        }

        public void printUsers(){
            userService.printUsers();
        }

        public void printEvents(){
            eventService.printEvents();
        }
    }


    public static void main(String[] args) {
        App app = new App();
        app.fillStorage();

        System.out.println("----------Users-------------");
        app.printUsers();
        System.out.println("----------Events-------------");
        app.printEvents();
    }
}
