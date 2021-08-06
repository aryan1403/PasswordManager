package com.manager.console;

import java.util.Scanner;
import com.manager.DB.db;

public class manager {
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    Scanner sc3 = new Scanner(System.in);

    public void menu() {
        System.out.println("1. Set a new Entity");
        System.out.println("2. Get all the available Entities");
        System.out.println("3. Delete All");
        System.out.println("5. Exit");
        System.out.print("Enter your Choice : ");
    }
    
    public void add(String key, String value) {
        if (new db().add(key, value))
            System.out.println("Successfully Added Data!");
    }

    public void set() {
        System.out.print("Enter a new key : ");
        String key = sc2.nextLine();
        System.out.print("Enter a new value : ");
        String value = sc3.nextLine();

        add(key, value);
    }

    public void get() {
        System.out.println("Available Data :");
        new db().get();
    }

    public void exit() {
        System.out.println("Thank You!");
        System.exit(0);
    }

    public void deleteAll(){
        if(new db().deleteAll()) 
            System.out.println("Cleared DataBase Successfully!");
    }

    public void start() {
        while (true) {
            menu();
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    set();
                    break;

                case 2:
                    get();
                    break;
                
                case 3:
                    deleteAll();
                    break;

                case 5:
                    exit();
                    break;

                default:
                    break;
            }
        }

    }
}
