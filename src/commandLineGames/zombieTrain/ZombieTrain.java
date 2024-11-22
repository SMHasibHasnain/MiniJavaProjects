package commandLineGames.zombieTrain;
import java.util.Objects;
import java.util.Random;

public class ZombieTrain {

    final String Black = "\u001B[30m";
    final String Red = "\u001B[31m";
    final String Green = "\u001B[32m";
    final String Yellow = "\u001B[33m";
    final String Blue = "\u001B[34m";
    final String Magenta = "\u001B[35m";
    final String Cyan = "\u001B[36m";
    final String White = "\u001B[37m";
    final String Reset = "\u001B[0m";
    final String Bold = "\u001B[1m";

    static class Passenger{
        String name;
        String role;
        int level;
        Passenger next;

        String[] names = {"Hasib", "Rajib", "Suman", "Tanvir", "Zim", "Tofayel", "Sami", "Ishrat", "Ratna", "Mita", "Ria", "Mujahid", "Anis", "Fatema", "Arpita", "Sagor", "Samiul",  "Ananya", "Rahul", "Priya", "Fahim", "Riya", "Shubho", "Tania", "Niloy", "Meher", "Shuvo", "Monira", "Iqbal", "Tanima", "Arif", "Kiran", "Shanta", "Ayesha", "Nabil", "Jannat", "Saad", "Nilima", "Imran", "Rezwana", "Jamil", "Nusrat", "Shohel", "Rasheda", "Rubina", "Abir", "Rajib", "Sharmila", "Mamun", "Kazi", "Shukla", "Roni", "Shirin", "Mahmud", "Kaziya", "Safiya", "Tanvir", "Riyaaz", "Sadiya", "Hossain", "Fatema", "Yasin", "Kazi", "Rashed", "Sabrina", "Jubaida", "Mehedi", "Neelima", "Sadman", "Tanvir", "Anis", "Asifa", "Shahin", "Hena", "Rakib", "Monira", "Zarin", "Arslan", "Nisha", "Omar", "Areeba", "Shawon", "Lubna", "Shahab", "Hamim", "Arindom", "Mehrin"};
        String[] roles = {"Human", "Human", "Hero", "Zombie", "Zombie"};
        int[] levels = {1, 2, 3};

        Passenger(){
            Random random = new Random();
            this.name = names[random.nextInt(names.length)];
            this.role = roles[random.nextInt(roles.length)];
            this.level = levels[random.nextInt(levels.length)];
            next = null;
        }
    }

    Passenger head;

    public void insertPassenger() {
        Passenger newPassenger = new Passenger();
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void viewPassengers() {
        Passenger current = head;
        while (current != null) {

            if(current.role.equals("Hero")) {
                System.out.printf("%s%s[%s%s%s%s]%s -> ", Bold, current.name, Green, current.role, Reset, Bold, Reset);
            } else if(current.role.equals("Zombie")) {
                System.out.printf("%s%s[%s%s%s%s]%s -> ", Bold, current.name, Red, current.role, Reset, Bold, Reset);
            } else {
                System.out.printf("%s[%s] -> ", current.name, current.role);
            }
            current = current.next;
        }
        System.out.println(Cyan + Bold + "Null" + Reset);
    }

    public void removePassengers(String name) {
        Passenger current = head;
        Passenger prev = null;
        if(head != null && head.name.equals(name)) {
            head = current.next;
            return;
        }
        while (current != null) {
            if(current.name.equals(name) && (current.role.equals("Zombie") || current.role.equals("Hero"))) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ZombieTrain zt = new ZombieTrain();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.viewPassengers();

        Passenger current = zt.head;
        String darling;
        while(current != null) {
            if(current.role.equals("Zombie")) {
                darling = current.name;
                zt.removePassengers(darling);
                break;
            }
        }
        zt.viewPassengers();
    }



}
