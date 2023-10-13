public class Order {

    private Burger burger;
    private Drink drink;
    private SideItem sideItem;


    public Order(String burgerType, char burgerSize, String drinkType, char drinkSize, String sideItemType, char sideItemSize, boolean deluxe) {             //Create a custom order
        this.burger = new Burger(burgerType, burgerSize, deluxe);
        this.drink = new Drink(drinkType, drinkSize, deluxe);
        this.sideItem = new SideItem(sideItemType, sideItemSize, deluxe);
    }

    public Order() {                                                              //Common meal order
        this.burger = new Burger("Cheeseburger", 'M', false);
        this.drink = new Drink("Coke", 'S', false);
        this.sideItem = new SideItem("Fries", 'S', false);
    }

    public void printOrder() {                                                   //Get the Total review (with the Total Price) of the Order
        System.out.println("=====Your order=====\n" +
                burger.toString() + " | Price: $" + burger.getPrice() + "\n" +
                drink.toString() + " | Price: $" + drink.getPrice() + "\n" +
                sideItem.toString() + " | Price: $" + sideItem.getPrice() + "\n" +
                "Extra toppings: " + burger.getToppings() + " | Price: " + burger.getToppingsPrice() + "\n" +
                "Total price: $" + (burger.getPrice() + drink.getPrice() + sideItem.getPrice() + burger.getToppingsPrice()));
    }

    public void addToppings(int flag) {                                    //The method we can use to add some toppings to our burger
        burger.addTopping(flag);
    }

    public void deletePosition(int deleteFlag) {                            //The method which we can use to delete some positions in the Order
        switch (deleteFlag) {
            case 1 -> burger.deleteBurger("", ' ');
            case 2 -> drink.deleteDrink("", ' ');
            case 3 -> sideItem.deleteSideItem("", ' ');
        }
    }
}
