public class Burger {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;
    private String toppings;
    private int counter;
    private double toppingsPrice;

    public Burger(String type, char size, boolean deluxe) {                  //Default constructor
        if (checkInput(type)) {                                              //If method 'checkInput' return 'true' then we assign user's input to the fields 'type' and 'size'
            this.size = size;
            if (deluxe) {
                this.type = type + " Deluxe";
            } else {
                this.type = type;
            }
        } else {                                                                    //If method 'checkInput' return 'false' then we omit the user's input and set some static values
            this.type = "No burger";
            this.size = 'N';
        }

        this.deluxe = deluxe;
        this.toppings = "";
        this.toppingsPrice = 0.0;
    }

    public void deleteBurger(String type, char size) {                              //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {                                                   //Calculate the burger's price with its type and size. This method nobody can call directly
        double burgerTypePrice = 0.0;
        double burgerSizePrice = 0.0;

        if (type != "No burger") {
            if (deluxe) {                                                           //If burger is Deluxe ('deluxe' field is 'true') then we add to field 'type' string 'Deluxe' and set static price of the Order to $25
                burgerTypePrice += 17.0;
                return burgerTypePrice + burgerSizePrice;
            } else if (!deluxe) {
                switch (type) {                                                     //If customer enter a correct 'type' of burger then the 'price' will be calculated
                    case "Big Mac" -> burgerTypePrice += 5.0;
                    case "McDouble" -> burgerTypePrice += 7.5;
                    case "Cheeseburger" -> burgerTypePrice += 6.43;
                    case "Chickenburger" -> burgerTypePrice += 5.45;
                    case "Fishburger" -> burgerTypePrice += 6.76;
                }

                switch (size) {                                                     //If customer enter a correct 'size' of burger then the 'price' will be calculated
                    case 'S' -> burgerTypePrice -= (burgerTypePrice * 0.25);        //If the 'size' is 'S' (Small) then we subtract from burger's price 25%
                    case 'M' -> burgerSizePrice = 0.0;                              //If the 'size' is 'M' (Medium) then the burger's price won't change
                    case 'L' -> burgerSizePrice += burgerTypePrice / 2;             //If the 'size' is 'L' (Large) then we add to the burger's price 50%
                }
            }
        }

        return burgerTypePrice + burgerSizePrice;                        //The formula of calculating the burger's total price. The sum will be rounded with 'Math.round'
    }

    public void addTopping(int flag) {                                   //The customer can add extra toppings to his(her) burger with this method
        double toppingPrice = 0.0;
        counter = 0;

         if(deluxe) {                                                    //If 'deluxeBurger' is 'true' then the customer can add up to 5 toppings and this isn't change the price
             if (counter < 5) {
                 switch (flag) {
                     case 1 -> {
                         System.out.println("Extra cheese added");
                         counter++;
                         toppings += "Extra cheese added, ";
                     }
                     case 2 -> {
                         System.out.println("Extra ketchup added");
                         counter++;
                         toppings += "Extra ketchup added, ";
                     }
                     case 3 -> {
                         System.out.println("Extra mustard added");
                         counter++;
                         toppings += "Extra mustard added";
                     }
                 }
             } else {
                 System.out.println("You've reached your topping limit (5 toppings)!");
             }
         } else if (!deluxe) {
             if (counter < 3) {
                 switch (flag) {
                     case 1 -> {
                         System.out.println("Extra cheese added");
                         counter++;
                         toppingPrice += 0.75;
                         toppings += "Extra cheese added, ";
                     }
                     case 2 -> {
                         System.out.println("Extra ketchup added");
                         counter++;
                         toppingPrice += 0.65;
                         toppings += "Extra ketchup added, ";
                     }
                     case 3 -> {
                         System.out.println("Extra mustard added");
                         counter++;
                         toppingPrice += 0.7;
                         toppings += "Extra mustard added";
                     }
                 }
             } else {
                 System.out.println("You've reached your topping limit (3 toppings)!");
             }
         }

         this.toppingsPrice += toppingPrice;                       //Here we add the cost of the toppings chosen by to the customer to the Total Price
    }

    public double getPrice() {                                     //We calculate the value of field 'price' via method 'totalPrice' and return it
        return this.price = totalPrice();
    }

    public String getToppings() {                                  //We use this getter in 'printOrder' method on class 'Order'
        return this.toppings;
    }

    public double getToppingsPrice() {
        return toppingsPrice;
    }

    @Override
    public String toString() {                                     //We use this getter in 'printOrder' method on class 'Order'
        return "Burger{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    public void burgerMenu() {                                     //With this method we can review the burger's menu
        System.out.println("===Burgers===\n" +
                "Big Mac | $5.0\n" +
                "McDouble | $7.5\n" +
                "Cheeseburger | $6.43\n" +
                "Chickenburger | $5.45\n" +
                "Fishburger | $6.76\n" +
                "==Burger's size==\n" +
                "'S' (Small) | price - 25%\n" +
                "'M' (Medium) | price don't change\n" +
                "'L' (Large) | price + 50%\n" +
                "==Toppings==\n" +
                "Extra Cheese | $0.75\n" +
                "Extra Ketchup | $0.65\n" +
                "Extra Mustard | $0.7\n" +
                "==Deluxe Order==\n" +
                "Any Deluxe order has a static price - $25\n" +
                "you can chose whatever you want and the price won't change\n");
    }

    private boolean checkInput(String type) {                                                               //If the string in the 'if' statement contains the user input ('type' variable) then we return 'true'
        if ("Big Mac McDouble Cheeseburger Chickenburger Fishburger".contains(type)) {
            return true;
        } else {
            return false;
        }
    }
}

class Drink {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;


    public Drink(String type, char size, boolean deluxe) {              //Default constructor
        if(checkInput(type)) {
            this.type = type;
            this.size = size;
        } else {
            this.type = "No drink";
            this.size = 'N';
        }
        this.deluxe = deluxe;
    }

    public void deleteDrink(String type, char size) {               //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {                                   //The method to calculate the drink's total price with its type and size. This method nobody can call directly
        double drinkTypePrice = 0.0;
        double drinkSizePrice = 0.0;

        if (type != "No drink") {
            switch (type) {                                         //If customer's input won't match to any of the cases then the 'type' will be set to 'No drink'
                case "Coke" -> drinkTypePrice = 2.5;
                case "Ice Coffee" -> drinkTypePrice = 2.25;
                case "Orange Juice" -> drinkTypePrice = 3.1;
                case "Apple Juice" -> drinkTypePrice = 2.1;
                case "Cold Tea" -> drinkTypePrice = 2.4;
                case "Hot Tea" -> drinkTypePrice = 1.75;
            }

            switch (size) {
                case 'S' -> drinkTypePrice -= (drinkTypePrice * 0.15);          //If the 'size' is 'S' (Small) then we subtract from drink's price 15%
                case 'M' -> drinkSizePrice = 0.0;                               //If the 'size' is 'M' (Medium) then the price won't change
                case 'L' -> drinkSizePrice = drinkTypePrice / 2;                //If the 'size' is 'L' (Large) then we add to the drink's price 50%
            }
        }

        if (deluxe) {                                            //If customer ordered the Deluxe burger then the price of the drink is included into the burger's price
            drinkSizePrice = 0.0;
            drinkTypePrice = 0.0;
        }

        return drinkTypePrice + drinkSizePrice;
    }

    public double getPrice() {                                   //We calculate the value of field 'price' via method 'totalPrice' and return it
        return this.price = totalPrice();
    }

    @Override
    public String toString() {                                   //We use this getter in 'printOrder' method on class 'Order'
        return "Drink{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    public void drinkMenu() {                                    //With this method we can review the drink's menu
        System.out.println("===Drinks===\n" +
                "Coke | $2.5\n" +
                "Ice Coffee | $2.25\n" +
                "Orange Juice | $3.1\n" +
                "Apple Juice | $2.1\n" +
                "Cold Tea | $2.4\n" +
                "Hot Tea | $1.75\n" +
                "==Drink's size==\n" +
                "'S' (Small) | price - 15%\n" +
                "'M' (Medium) | price don't change\n" +
                "'L' (Large) | price + 50%\n");
    }

    private boolean checkInput(String type) {
        if ("Coke Ice Coffee Orange Juice Apple Juice Cold Tea Hot Tea".contains(type)) {
            return true;
        } else {
            return false;
        }
    }
}

class SideItem {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;

    public SideItem(String type, char size, boolean deluxe) {
        if (checkInput(type)) {
            this.type = type;
            this.size = size;
        } else {
            this.type = "No Side Item";
            this.size = 'N';
        }
        this.deluxe = deluxe;
    }

    public void deleteSideItem(String type, char size) {                                               //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {
        double sideItemTypePrice = 0.0;
        double sideItemSizePrice = 0.0;

        if (type != "No Side Item") {
            switch (type) {
                case "Fries" -> sideItemTypePrice = 4.5;
                case "Chicken Nuggets" -> sideItemTypePrice = 4.95;
                case "Salad" -> sideItemTypePrice = 3.75;
            }

            switch (size) {
                case 'S' -> sideItemTypePrice -= (sideItemTypePrice * 0.2);                        //If the 'size' is 'S' (Small) then we subtract from side item's price 20%
                case 'M' -> sideItemSizePrice = 0.0;                                               //If the 'size' is 'M' (Medium) then the price won't change
                case 'L' -> sideItemSizePrice = sideItemTypePrice / 2;                             //If the 'size' is 'L' (Large) then we add to the side item's price 50%
            }

        }

        if (deluxe == true) {                                               //If customer ordered the Deluxe burger then the price of the Side Item is included into the burger's price
            sideItemTypePrice = 0.0;
            sideItemSizePrice = 0.0;
        }

        return sideItemTypePrice + sideItemSizePrice;
    }

    public double getPrice() {
        return this.price = totalPrice();
    }

    @Override
    public String toString() {                              //We use this getter in 'printOrder' method on class 'Order'
        return "SideItem{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    public void sideItemMenu() {                           //With this method we can review the side item's menu
        System.out.println("===Side Items===\n" +
                "Fries | $4.5\n" +
                "Chicken Nuggets | $4.95\n" +
                "Salad | $3.75\n" +
                "==Side Item's size==\n" +
                "'S' (Small) | price - 15%\n" +
                "'M' (Medium) | price don't change\n" +
                "'L' (Large) | price + 50%\n");
    }

    private boolean checkInput(String type) {
        if ("Fries Chicken Nuggets Salad".contains(type)) {
            return true;
        } else {
            return false;
        }
    }
}
