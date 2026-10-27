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

        Vehicle car3 = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        vehicles.add(car3);

        Vehicle car4 = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicles.add(car4);

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
                    System.out.println("Enter make/model to search for: ");
                    String searchMakeModel = myScanner.nextLine();
                    searchVehicles(searchMakeModel, vehicles);


                }
                case "4" -> {
                    System.out.println("Enter the color you want: ");
                    String searchColor = myScanner.nextLine();

                    searchForColor(searchColor, vehicles);
                }
            }
        }

    private static void searchForColor(String searchColor, ArrayList<Vehicle> vehiclesToSearch) {
        for (Vehicle currentVehicle : vehiclesToSearch) {
            String currentColor = currentVehicle.getColor();
            if (currentColor.equals(searchColor)) {
                currentVehicle.display();
            }
        }
    }

    private static void searchVehicles(String searchMakeModel, ArrayList<Vehicle> vehicles) {
        for (Vehicle currentVehicle : vehicles) {
            String currenMakeModel = currentVehicle.getMakeModel();
           if (currenMakeModel.equals(searchMakeModel)) {
               currentVehicle.display();
           }


        }
    }


}
