package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        Vehicle car = new Vehicle(101121, "Ford Explorer", "Red", 4500, 13500);

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(car);

        Vehicle yourCar = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles.add(yourCar);

        for (Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle.getColor());

        }
        String menuPrompt = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""";
        System.out.println(menuPrompt);
        String userInput = myScanner.nextLine();

        switch (userInput) {
            case "1" -> {
                for (Vehicle currentVehicle: vehicles) {
                    currentVehicle.getVehicleId();
                    currentVehicle.display();
                }

                }


                case "2" -> {
                    //searchVehicles();


                }
            }
        }






    }
