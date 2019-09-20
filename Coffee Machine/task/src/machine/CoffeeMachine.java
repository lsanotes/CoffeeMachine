package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Write action (buy, fill, take, remaining, exit):");
        while (scanner.hasNext()) {
            String action = scanner.next();
            System.out.println();
            chooseAction(action);
            if ("exit".equalsIgnoreCase(action)) break;
            System.out.print("Write action (buy, fill, take, remaining, exit) :");
        }
    }

    private static void chooseAction(String action) {
        switch (action) {
            case "remaining":
                dumpMachineStatus();
                break;
            case "buy":
                buyCoffee();
                break;
            case "exit":
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
        }
    }

    private static void takeMoney() {
        System.out.println(String.format("I gave you $%d", money));
        money = 0;

        System.out.println();
    }

    private static void fillMachine() {
        System.out.print("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();

        System.out.println();
    }

    private static void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:: ");
        switch (scanner.next()) {
            case "back":
                break;
            case "1":
                if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    cups -= 1;
                    water -= 250;
                    beans -= 16;
                    money += 4;
                }
                break;
            case "2":
                if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    cups -= 1;
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                }
                break;
            case "3":
                if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (beans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    cups -= 1;
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                }
                break;
        }
        System.out.println();
    }

    private static void dumpMachineStatus() {
        System.out.println("The Coffee machine has:");
        System.out.println(String.format("%d of water", water));
        System.out.println(String.format("%d of milk", milk));
        System.out.println(String.format("%d of coffee beans", beans));
        System.out.println(String.format("%d of disposable cups", cups));
        System.out.println(String.format("$%d of money", money));
        System.out.println();
    }
}
