public class Burger {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;
    private String toppings;
    private int counter;
    private double toppingsPrice;

    public Burger(String type, char size, boolean deluxe) {                  //Default constructor
        this.type = type;
        this.size = size;
        this.deluxe = deluxe;
        this.toppings = "";
        this.toppingsPrice = 0.0;
    }

    public void deleteBurger(String type, char size) {                              //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {                                  //Calculate the burger's price with its type and size. This method nobody can call directly
        double burgerTypePrice = 0.0;
        double burgerSizePrice = 0.0;

        if (deluxe) {                                          //If burger is Deluxe ('deluxe' field is 'true') then we add to field 'type' string 'Deluxe' and set static price of the Order to $25
            type += "Deluxe";
            size = 'L';
            burgerTypePrice += 25.0;
            return burgerTypePrice + burgerSizePrice;
        } else if (!deluxe) {
            switch (type) {                                        //If customer enter a correct 'type' of burger then the 'price' will be calculated
                case "Big Mac" -> burgerTypePrice += 5.0;
                case "McDouble" -> burgerTypePrice += 7.5;
                case "Cheeseburger" -> burgerTypePrice += 6.43;
                case "Chickenburger" -> burgerTypePrice += 5.45;
                case "Fishburger" -> burgerTypePrice += 6.76;
                case "" -> { this.type = "No burger"; burgerTypePrice = 0.0; }                //If customer's input won't match to any case then 'type' will be set to 'No burger' and 'price' will be set to '0' (zero)
            }

            if (type != "No burger") {                                              //If it isn't a Deluxe burger then the customer can change the burger's size
                switch (size) {                                                     //If customer enter a correct 'size' of burger then the 'price' will be calculated
                    case 'S' -> burgerTypePrice -= (burgerTypePrice * 0.25);        //If the 'size' is 'S' (Small) then we subtract from burger's price 25%
                    case 'M' -> burgerSizePrice = 0.0;                              //If the 'size' is 'M' (Medium) then the burger's price won't change
                    case 'L' -> burgerSizePrice += burgerTypePrice / 2;             //If the 'size' is 'L' (Large) then we add to the burger's price 50%
                    default -> {
                        this.size = 'M';                                            //It is 'M' (Medium) size of burger by default
                        burgerSizePrice = 0;
                    }
                }
            }
        }

        return burgerTypePrice + burgerSizePrice;              //The formula of calculating the burger's total price
    }

    public void addTopping(int flag) {                         //The customer can add extra toppings to his(her) burger with this method
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

    public double getPrice() {                             //We calculate the value of field 'price' via method 'totalPrice' and return it
        return this.price = totalPrice();
    }

    public String getToppings() {
        return this.toppings;
    }

    public double getToppingsPrice() {
        return toppingsPrice;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}

class Drink {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;


    public Drink(String type, char size, boolean deluxe) {              //Default constructor
        this.type = type;
        this.size = size;
        this.deluxe = deluxe;
    }

    public void deleteDrink(String type, char size) {                           //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {                       //The method to calculate the drink's total price with its type and size. This method nobody can call directly
        double drinkTypePrice = 0.0;
        double drinkSizePrice = 0.0;

        switch (type) {                                      //If customer's input won't match to any of the cases then the 'type' will be set to 'No drink'
            case "Coke" -> drinkTypePrice = 2.5;
            case "Ice Coffee" -> drinkTypePrice = 2.25;
            case "Orange Juice" -> drinkTypePrice = 3.1;
            case "Apple Juice" -> drinkTypePrice = 2.1;
            case "Cold Tea" -> drinkTypePrice = 2.4;
            case "Hot Tea" -> drinkTypePrice = 1.75;
            case "" -> { this.type = "No drink"; drinkTypePrice = 0; }
        }

        if (type != "No drink") {                              //If the field 'type' isn't equals to string 'No drink' then we calculate the drink's price with its size
            switch (size) {
                case 'S' -> drinkTypePrice -= (drinkTypePrice * 0.15);          //If the 'size' is 'S' (Small) then we subtract from drink's price 15%
                case 'M' -> drinkSizePrice = 0.0;                               //If the 'size' is 'M' (Medium) then the price won't change
                case 'L' -> drinkSizePrice = drinkTypePrice / 2;                //If the 'size' is 'L' (Large) then we add to the drink's price 50%
                default -> {
                    this.size = 'S';                                            //It is 'S' (Small) size of drink by default
                    drinkTypePrice -= (drinkTypePrice * 0.15);
                }
            }
        }

        if (deluxe) {                                            //If customer ordered the Deluxe burger then the price of the drink is included into the burger's price
            drinkSizePrice = 0.0;
            drinkTypePrice = 0.0;
        }

        return drinkTypePrice + drinkSizePrice;
    }

    public double getPrice() {                            //We calculate the value of field 'price' via method 'totalPrice' and return it
        return this.price = totalPrice();
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}

class SideItem {

    private String type;
    private char size;
    private double price;
    private boolean deluxe;

    public SideItem(String type, char size, boolean deluxe) {
        this.type = type;
        this.size = size;
        this.deluxe = deluxe;
    }

    public void deleteSideItem(String type, char size) {                                    //The method for deleting positions in the order
        this.type = type;
        this.size = size;
    }

    private double totalPrice() {
        double sideItemTypePrice = 0.0;
        double sideItemSizePrice = 0.0;

        switch (type) {
            case "Fries" -> sideItemTypePrice = 4.5;
            case "Chicken Nuggets" -> sideItemTypePrice = 4.95;
            case "Salad" -> sideItemTypePrice = 3.75;
            case "" -> { this.type = "No side item"; sideItemTypePrice = 0; }
        }

        if (type != "No side item") {
            switch (size) {
                case 'S' -> sideItemTypePrice -= (sideItemTypePrice * 0.2);                        //If the 'size' is 'S' (Small) then we subtract from side item's price 20%
                case 'M' -> sideItemSizePrice = 0.0;                                               //If the 'size' is 'M' (Medium) then the price won't change
                case 'L' -> sideItemSizePrice = sideItemTypePrice / 2;                             //If the 'size' is 'L' (Large) then we add to the side item's price 50%
                default -> { this.size = 'S'; sideItemTypePrice -= (sideItemTypePrice * 0.2); }    //It is 'S' (Small) size of side item by default
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
    public String toString() {
        return "SideItem{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }
}
