import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedListChallenge {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        showOptions();
        LinkedList<Places> listOfPlaces = new LinkedList<>();
        boolean quit = true;
        listOfPlaces.add(new Places("Kyiv", 0));                           //Manually add some number of places to the LinkedList 'listOfPlaces'
        listOfPlaces.add(new Places("Kharkiv", 404));
        listOfPlaces.add(new Places("Lviv", 519));
        listOfPlaces.add(new Places("Sumy", 213));
        listOfPlaces.add(new Places("Odessa", 708));
        listOfPlaces = sort(listOfPlaces);


        while (quit) {
            System.out.print("--> ");
            String input = scanner.nextLine();
            char symbol = input.toUpperCase().charAt(0);

            switch (symbol) {                                                                         //Switch the first character of the user input and call the appropriate method
                case 'F' -> { processForward(listOfPlaces); }
                case 'B' -> { processBackward(listOfPlaces); }
                case 'L' -> { showPlaces(listOfPlaces); }
                case 'M' -> { showOptions(); }
                case 'A' -> { listOfPlaces = addPlace(listOfPlaces);
                              listOfPlaces = sort(listOfPlaces); }
                case 'R' -> { listOfPlaces = removePlace(listOfPlaces); }
                case 'Q' -> { System.out.println("Bye!"); quit = false; }
            }
        }
    }

    public static void processForward(LinkedList<Places> placesToVisit) {                                 //Using listIterator to navigate forward through the list of places

        var forwardIterator = placesToVisit.listIterator();
        var forwardIterator2 = placesToVisit.listIterator(1);                                       //Using index '1' to skip the first element in the LinkedList

        System.out.println("Process Forward:");
        while (forwardIterator.hasNext()) {
            try {
                System.out.println("From " + forwardIterator.next().getName() + " to " + forwardIterator2.next().getName());
            } catch (NoSuchElementException e) {
                break;
            }

        }
    }

    public static void processBackward(LinkedList<Places> placesToVisit) {                                 //Using listIterator to go backwards through the list of places

        var backwardIterator =  placesToVisit.listIterator(placesToVisit.size());
        var backwardIterator2 = placesToVisit.listIterator(placesToVisit.size() - 1);

        System.out.println("Process Backwards:");
        while (backwardIterator.hasPrevious()) {
            try {
                System.out.println("From " + backwardIterator.previous().getName() + " to " + backwardIterator2.previous().getName());
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }

    public static void showPlaces(LinkedList<Places> placesToVisit) {                                       //Display the list of places

        var iterator = placesToVisit.listIterator();                                                        //ListIterator to process a name of the place
        var iterator2 = placesToVisit.listIterator();                                                       //ListIterator to process a distance value of the place
        int counter = 0;
        while (iterator.hasNext()) {
            for (int i = 0; i < placesToVisit.size(); i++) {
                counter++;
                System.out.println(counter + ". " + iterator.next().getName() + " -> " + iterator2.next().getDistanceFromTheStartPoint() + " km");
            }
        }
    }

    public static void showOptions() {                                                                   //Show Menu of options(actions)

        String message = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (A)dd Place
                (R)emove Place
                (M)enu
                (Q)uit
                """;
        System.out.print(message);
    }

    public static LinkedList<Places> addPlace(LinkedList<Places> placesToVisit) {                                   //Add a new location to the list of places

        Scanner placeScanner = new Scanner(System.in);
        Scanner distanceScanner = new Scanner(System.in);
        System.out.print("Enter a name of the Place: ");
        String name = placeScanner.nextLine().trim();
        System.out.print("How far does this place from Kyiv (only numbers): ");
        double distance = distanceScanner.nextDouble();

        var listIterator = placesToVisit.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getName().equals(name)) {                                        //If location already exists in the list, notify the user and do not add anything to the list
                System.out.println("This place is already exists in the list!");
                return placesToVisit;
            }
        }

        placesToVisit.add(new Places(name, distance));
        System.out.println("New Place was successfully added");

        return placesToVisit;
    }

    public static LinkedList<Places> removePlace(LinkedList<Places> placesToVisit) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("What place do you want to remove (enter its name): ");
        String placeToRemove = scanner.nextLine().trim();

        var iterator = placesToVisit.listIterator(1);                                           //Skip the first element in the list because we don't want to remove the capital city
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(placeToRemove)) {
                iterator.remove();
                System.out.println("Place was successfully removed!");
            }
        }
        return placesToVisit;
    }

    private static LinkedList<Places> sort(LinkedList<Places> list) {                                   //Simple sorting of the list of places

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).getDistanceFromTheStartPoint() > list.get(j + 1).getDistanceFromTheStartPoint()) {
                    var temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set((j + 1), temp);
                }
            }
        }
        return list;
    }
}

class Places {

    private String name;
    private double distanceFromTheStartPoint;

    public Places(String name, double distanceFromTheStartPoint) {
        this.name = name;
        this.distanceFromTheStartPoint = distanceFromTheStartPoint;
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromTheStartPoint() {
        return distanceFromTheStartPoint;
    }
}

