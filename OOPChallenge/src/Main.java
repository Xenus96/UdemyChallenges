import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String first, third, fifth;
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

        getSize(burgerSizeFlag);                                      //We use method 'getSize' on Main class to get the size of the meal
        getSize(drinkSizeFlag);
        getSize(sideItemSizeFlag);

        if (deluxeFlag == 1) {
            deluxe = true;
        } else {
            deluxe = false;
        }

        Order order = new Order(first, getSize(burgerSizeFlag), third,  getSize(drinkSizeFlag), fifth, getSize(sideItemSizeFlag), deluxe);                                    //We create a new object of type 'Object' and assign to it all the variables showed above

        System.out.println("Do you want to add some extra toppings | 1 (yes) or 2 (no):");
        toppingsFlag = scanner.nextInt();
        if (toppingsFlag == 1) {
            System.out.println("Toppings | 1 - Cheese; 2 - Ketchup; 3 - Mustard; 0 - Exit");
            toppingsFlag = scanner.nextInt();
            if (toppingsFlag != 0 && toppingsFlag < 4) {
                order.addToppings(toppingsFlag);
            } else if (toppingsFlag == 0){
                System.out.println("Exiting this feature...");
            } else {
                System.out.println("Invalid Input");
            }
        }

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
        }

        order.printOrder();                                                      //Review the Order
        System.out.println();

        Order newOrder = new Order();                                            //If we create a new object of type 'Object' without any parameters, we will get the 'Common Order'
        newOrder.printOrder();
        System.out.println();
    }

    private static void createMenu(int flag) {                                   //We create an object of type 'Object' and use it to call the method 'showMenu' on class 'Order'
        Order menu = new Order();
        menu.showMenu(flag);
    }

    public static void showMenu() {                                                                                //We use this function to offer the customer to view the menu
        Scanner menu = new Scanner(System.in);

        System.out.println("Do you want to see the Menu? | 1 (yes) or 2 (no):");
        int menuFlag = menu.nextInt();

        if (menuFlag == 1) {
            System.out.println("Menu | 1 - Burgers; 2 - Drinks; 3 - Side Items");
            menuFlag = menu.nextInt();
            createMenu(menuFlag);
        }
    }

    public static char getSize (int flag) {                                   //We use this method to get the position size
        char size;
        switch (flag) {
            case 1 -> size = 'S';
            case 2 -> size = 'M';
            case 3 -> size = 'L';
            default -> size = ' ';
        }
        return size;
    }
}
