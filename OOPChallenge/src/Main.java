import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String first, third, fifth;
        char second, fourth, sixth;
        boolean deluxe;
        int deluxeFlag, burgerSizeFlag, drinkSizeFlag, sideItemSizeFlag, toppingsFlag, deleteFlag, menuFlag;

        System.out.println("=====Make your order=====");
        showMenu();                                                                                          //The method which creates new object of type 'Order' and uses it to call the method 'showMenu' on class 'Order'

        System.out.println("Burger | type & size (1 - Small; 2 - Medium; 3 - Large):");
        first = scanner.nextLine();
        burgerSizeFlag = scanner.nextInt();

        showMenu();
        System.out.println("Drink | type & size (1 - Small; 2 - Medium; 3 - Large):");
        third = scanner1.nextLine();
        drinkSizeFlag = scanner1.nextInt();

        showMenu();
        System.out.println("Side Item | type & size (1 - Small; 2 - Medium; 3 - Large):");
        fifth = scanner2.nextLine();
        sideItemSizeFlag = scanner2.nextInt();

        System.out.println("Do you want this order to be Deluxe | 1 (yes) or 2 (no):");
        deluxeFlag = scanner.nextInt();

        switch (burgerSizeFlag) {
            case 1 -> second = 'S';
            case 2 -> second = 'M';
            case 3 -> second = 'L';
            default -> second = ' ';
        }
        switch (drinkSizeFlag) {
            case 1 -> fourth = 'S';
            case 2 -> fourth = 'M';
            case 3 -> fourth = 'L';
            default -> fourth = ' ';
        }
        switch (sideItemSizeFlag) {
            case 1 -> sixth = 'S';
            case 2 -> sixth = 'M';
            case 3 -> sixth = 'L';
            default -> sixth = ' ';
        }

        if (deluxeFlag == 1) {
            deluxe = true;
        } else {
            deluxe = false;
        }

        Order order = new Order(first, second, third, fourth, fifth, sixth, deluxe);                                    //We create a new object of type 'Object' and assign to it all the variables showed above
        order.printOrder();                                                                                             //We call the method 'printOrder' on class 'Order' to print our Order
        System.out.println();

        System.out.println("Do you want to add some extra toppings | 1 (yes) or 2 (no):");
        toppingsFlag = scanner.nextInt();
        if (toppingsFlag == 1) {
            System.out.println("Toppings | 1 - Cheese; 2 - Ketchup; 3 - Mustard");
            toppingsFlag = scanner.nextInt();
            switch (toppingsFlag) {
                case 1 -> order.addToppings(1);
                case 2 -> order.addToppings(2);
                case 3 -> order.addToppings(3);
            }
            order.printOrder();
        }
        System.out.println();

        System.out.println("Do you cant to delete the specific position in your order? | 1 (yes) or 2 (no):");
        deleteFlag = scanner.nextInt();
        if (deleteFlag == 1) {
            System.out.println("Delete | 1 - Burger; 2 - Drink; 3 - Side Item");
            deleteFlag = scanner.nextInt();
            switch (deleteFlag) {
                case 1 -> order.deletePosition(1);
                case 2 -> order.deletePosition(2);
                case 3 -> order.deletePosition(3);
            }
            order.printOrder();
        }

        System.out.println("\n=====Your Final Order=====");
        order.printOrder();
        System.out.println();


        Order newOrder = new Order();                                                                                   //If we create a new object of type 'Object' without any parameters, we will get the 'Common Order'
        newOrder.printOrder();
        System.out.println();

//        Order newOrder2 = new Order("Big Mac", 'L', "Coke", 'S', "Salad", 'M', false);
//        newOrder2.printOrder();
//        newOrder2.addToppings(3);
//        newOrder2.printOrder();
//        System.out.println();
//
//        Order newOrder3 = new Order("McDouble", 'S', "Apple Juice", 'M', "Chicken Nuggets", 'L', true);
//        newOrder3.printOrder();
//        newOrder3.addToppings(1);
//        newOrder3.addToppings(2);
//        newOrder3.addToppings(3);
//        newOrder3.printOrder();
//        System.out.println();
//
//        Order newOrder4 = new Order("", ' ', "Coke", 'M', "", ' ', false);
//        newOrder4.printOrder();


    }

    private static void createMenu(int flag) {
        Order menu = new Order();
        menu.showMenu(flag);
    }

    public static void showMenu() {
        Scanner menu = new Scanner(System.in);

        System.out.println("Do you want to see the Menu? | 1 (yes) or 2 (no):");
        int menuFlag = menu.nextInt();

        if (menuFlag == 1) {
            System.out.println("Menu | 1 - Burgers; 2 - Drinks; 3 - Side Items");
            menuFlag = menu.nextInt();
            createMenu(menuFlag);
        }
    }
}
