package commandLineGames.zombieTrain;
import java.util.Random;
import java.util.Scanner;

public class ZombieTrain {

    static int coins = 0;
    static int totalPassenger = 0;
    static int zombieCounter = 0;
    static int heroCounter = 0;

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
    final String Clear = "\\033[2K\\r";


    static class Passenger{
        String name;
        String role;
        int level;
        Passenger next;

        String[] names = {"Hasib", "Rajib", "Suman", "Tanvir", "Zim", "Tofayel", "Sami", "Ishrat", "Ratna", "Mita", "Ria", "Mujahid", "Anis", "Fatema", "Arpita", "Sagor", "Samiul",  "Ananya", "Rahul", "Priya", "Fahim", "Riya", "Shubho", "Tania", "Niloy", "Meher", "Shuvo", "Monira", "Iqbal", "Tanima", "Arif", "Kiran", "Shanta", "Ayesha", "Nabil", "Jannat", "Saad", "Nilima", "Imran", "Rezwana", "Jamil", "Nusrat", "Shohel", "Rasheda", "Rubina", "Abir", "Rajib", "Sharmila", "Mamun", "Kazi", "Shukla", "Roni", "Shirin", "Mahmud", "Kaziya", "Safiya", "Tanvir", "Riyaaz", "Sadiya", "Hossain", "Fatema", "Yasin", "Kazi", "Rashed", "Sabrina", "Jubaida", "Mehedi", "Neelima", "Sadman", "Tanvir", "Anis", "Asifa", "Shahin", "Hena", "Rakib", "Monira", "Zarin", "Arslan", "Nisha", "Omar", "Areeba", "Shawon", "Lubna", "Shahab", "Hamim", "Arindom", "Mehrin"};
        String[] roles = {"Human", "Human", "Human", "Hero", "Zombie", "Zombie"};
        int[] levels = {1, 2, 3};

        Passenger(){
            Random random = new Random();
            this.name = names[random.nextInt(names.length)];
            this.role = roles[random.nextInt(roles.length)];
            this.level = levels[random.nextInt(levels.length)];
            next = null;
            totalPassenger++;
            if(this.role.equals("Human")) {
                coins += 10;
            } else if (this.role.equals("Zombie")){
                zombieCounter++;
            } else {
                coins+= 10;
                heroCounter++;
            }
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
        System.out.println("New Passenger just arrived!");
        if(newPassenger.role.equals("Human")) {
            System.out.println("Passenger: Help Me! Please Help Me!");
            System.out.println("Passenger: I'm " + newPassenger.name + ". I'm human, Believe me!");
            System.out.println( Bold + Green + "You have earned 10 coin for helping him/her!" + Reset);
        } else if (newPassenger.role.equals("Hero")) {
            System.out.println("Passenger: Are there any zombie? Let me fuck them!");
            System.out.println("Passenger: I'm " + newPassenger.name + ". People tag me Hero! Am I?");
            System.out.println( Bold + Cyan + "This entity will fight for you against zombies. Also, You have earned 10 coin for picking him/her!" + Reset);
        } else if (newPassenger.role.equals("Zombie")) {
            System.out.println("Passenger: Help me too! Vhhhh...! I'm hungry, need blood!, Ghhhhhh....!");
            System.out.println("Passenger: People call me " + newPassenger.name + ". I'm also human, Trust me!");
            System.out.println( Bold + Red + "This entity is no more a human being. It will kill innocent humans" + Reset);
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
            head = head.next;
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

    void chooseFighter(){
        int heroCounter = 0;
        int zombieCounter = 0;
        Passenger currenthero = null;
        Passenger current = head;
        while(current != null) {
            if(current.role.equals("Hero")) {
                System.out.printf("%s[Level: %d]\n", current.name, current.level);
                heroCounter++;
                currenthero = current;
            } else if(current.role.equals("Zombie")) {
                zombieCounter++;
            }
            current = current.next;
        }
        if(heroCounter == 0) {
            System.out.println("Sorry! You have no hero!");
            return;
        }
        if(zombieCounter == 0) {
            System.out.println("There is no zombie to fight!");
            return;
        }
        System.out.println();
        System.out.printf("You've total %d heroes. %s decided to start fighting against zombies for you!\n", heroCounter, currenthero.name);
        System.out.println();
        fight(currenthero);
    }

    public static void printWithTypingEffect(String text, int delay) {
        for (char c : text.toCharArray()) { // Loop through each character
            System.out.print(c); // Print character without a newline
            try {
                Thread.sleep(delay); // Delay for specified milliseconds
            } catch (InterruptedException e) {
                System.out.println("Typing interrupted");
            }
        }
        System.out.println(); // Move to the next line after typing is done
    }

    public void countAllZombies() {
        Passenger current = head;
        while(current != null) {
            if(current.role.equals("Zombie")) {
                zombieCounter++;
            }
            current = current.next;
        }
    }

    Passenger currentFighterZombie() {
        Passenger current = head;
        while(current != null) {
            if(current.role.equals("Zombie")) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void fight(Passenger fighter) {
        int whoWin;
        Passenger currentZombie = currentFighterZombie();

        if(fighter != null) {
            System.out.println();
            System.out.println(fighter.name + " is going to fight with zombies!");
            System.out.println(currentZombie.name + " is in front of " + fighter.name + "!");
            System.out.println();
            String[] zombieWelcomeSound = {"Oh, fresh meat! I hope you taste better than my last fish curry. 🐟💀", "Why are you running? You’ll only sweat more—it’s like seasoning for me! 😈💦", "Your screams sound like Rabindra Sangeet to my undead ears. 🎶🧟", "Come closer, hero! I promise it won’t hurt... for long. 😬💀", "Are you lost? This isn’t Kolkata’s tram stop—it’s the end of your life! 🚋🩸", "You smell like biryani... or is that just fear marinated in sweat? 🍛💦", "Stop running, hero! I just want to… chew on your existential crisis. 🤤", "Oh, you’re brave? Let’s see how brave you are when I taste your liver! 🩸😈", "This is not your Bollywood fight scene, babu. I’m the real deal! 🎥👹", "Your heartbeat sounds like dhak drumming... perfect for a feast! 🥁💀", "Careful! One bite, and you’ll join me in our eternal adda of the dead. 🧛‍♂️☕", "I don’t care about your hero skills—just hand over your kidneys! 🧟‍♂️🩺", "Run all you want, but at the end, you’re still my midnight snack. 🌌🧟", "Ah, the sweet smell of human flesh... with a hint of mishti doi! 🍮💀", "You think you’re a hero? Even Durga Ma would run from me! 🗡️👹", "Shall I eat you now? Or let you marinate in fear a little longer? ⏳😈", "I skipped my last victim because he had no taste... you look better! 🧟‍♂️😂", "Your blood’s so fresh, I bet it’ll pair well with my afternoon cha! ☕🩸", "The good news? You won’t die hungry. The bad news? You’re dessert. 🍰💀", "Your fate is sealed. But hey, at least I’ll write a poem about it later! ✍️🧛‍♂️"};
            String[] heroWelcomeSound = {"I’ve seen more scary things in a Bengali auntie's adda than you. 🤣💀", "You call yourself a zombie? I’ve faced worse at a family wedding! 🥳💥", "Oh, look at you, trying to look tough. News flash—your bite is worse than your bark! 🧟‍♂️🙄", "I’ve had worse breath from my grandmother’s poodle. 🐩💨", "I don’t know who you think you’re scaring, but I’ve seen scarier things in my fridge. 🧟‍♂️🧀", "What’s this? A zombie or a poorly acted Bollywood villain? Pathetic. 🎥🙄", "I don’t have time for this. Go back to your grave, it’s where you belong. 🪦💀", "You really think I’ll be scared of you? I’ve been to a Bengali gharer pujo, trust me, you’re not that intimidating. 🏠👻", "You should be running from me, not the other way around. What are you even doing here? 🏃‍♂️💪", "I’ve had worse experiences on a Kolkata bus than dealing with you. 🚍💥", "I was expecting a challenge, not a walking disaster. 🧟‍♂️👎", "You’re trying to scare me? Ha, you should see me before my morning tea. You’ll regret it. ☕😤", "Is this all you’ve got? I’ve faced bigger threats from my internet connection. 💻⚡", "You call that a growl? It sounds like a cat trying to do a low-budget horror film. 🐱🎬", "You’re like the bargain bin zombie—cheap and easy to beat. 🧟‍♂️💸", "Oh, so you think you’re intimidating? I’ve seen more life in a soggy paratha. 🍞🧟", "You’re slow, you’re stupid, and you’re about to get schooled. 🏫💀", "Look at you, still thinking you have a chance. I’m just here for the victory. 🏆💥", "I’m not scared of you, I’ve faced my mother’s dudh bhat without blinking. 🍼😎", "Your rotting skills need work. I’ve seen better decay on a week-old mango. 🥭💀", "Just give up already, you’re about as useful as a broken umbrella in a monsoon. ☔💀"};

            Random random = new Random();
            String one = Red + Bold + currentZombie.name + " (Zombie): " + Reset + zombieWelcomeSound[random.nextInt(zombieWelcomeSound.length)];
            String two = Green + Bold + fighter.name + ": " + Reset + heroWelcomeSound[random.nextInt(heroWelcomeSound.length)];
            printWithTypingEffect(one, 100);
            printWithTypingEffect(two, 100);
            System.out.println();

            whoWin = random.nextInt(2);
            if (whoWin == 0) {
                System.out.println( fighter.name + " lose and died!");
                coins -= 10;
                heroCounter--;
                totalPassenger--;
                removePassengers(fighter.name);
            } else {
                System.out.println(fighter.name + " won!");

                String[] zombieDeathSound = {"💀 Thud... No more moving!", "🧟‍♂️ No! Not my brains!", "🩸 Splatter... End of the road.", "⚰️ Silence... nothing left but dust.", "🔥 Burnt to a crisp!", "💥 Pow! Dead in one hit!", "🧠 Zzz... Complete shutdown.", "⚡ Zap! Disintegrated!", "🧟 Groan... it's over.", "🏹 Thunk! Arrow through the skull.", "💀 Crack... My bones break!", "🧟‍♂️ Grr... I can't move!", "🧠 Ugh... brainsss... lost...", "🩸 Splish-splash... fading away.", "🧟 Bwwaaahhh... I’m done.", "🧟‍♀️ *Gurgles*... Not today.", "💀 Clank... Collapsing to the ground.", "🔥 Sizzle... Burnt from the inside out.", "⚰️ Withering away... No more life.", "🧟‍♂️ Slump... Dead again.", "🩸 Gasp... Life leaking away.", "🌫️ Fade away into nothing...", "💥 *Crash*... Headshot!", "🧠 Bleh... Can’t reach my brain.", "🧟 Groan... Falling apart.", "⚡ Zap... Electrical shock to the heart.", "🧟‍♀️ Oof... Out of energy!", "💀 *Snap*... No more movement.", "💨 With a final breath... it's over."};
                String finishingSound1 = Red + Bold + currentZombie.name + " (Zombie): " + Reset + zombieDeathSound[random.nextInt(zombieDeathSound.length)];
                printWithTypingEffect(finishingSound1, 60);

                coins += 15;
                zombieCounter--;
                removePassengers(currentZombie.name);
                if(zombieCounter>1) {
                    System.out.println();
                    System.out.println(fighter.name + "wanna kill more zombies!");
                    System.out.println("He/She is waiting for your permission!");
                    System.out.println();
                    System.out.println("Choose an option:");
                    System.out.println("1. Permit him/her");
                    System.out.println("2. Don't take risk");
                    System.out.println();
                    System.out.print("Enter your choice:");
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    if(choice == 1) {
                        fight(fighter);
                    } else {
                        return;
                    }

                }
            }
        }
    }

    public void researchCenter() {
        System.out.println(Clear);
        System.out.println("________________________________");
        System.out.println("        Research Center");
        System.out.println("--------------------------------");
        System.out.println("You need total 200 coins to research an antidote!");
        if(coins<200) {
            System.out.println("But you have only " + coins + " coins!");
            return;
        } else {
            System.out.println("You have total " + coins + " coins." + "You are eligible for the research!");
            System.out.println("Do you want to perform the research?");
            System.out.println("1. Yes");
            System.out.println("2. Later");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1) {
                Passenger current = head;
                while(current != null) {
                    if(current.role.equals("Zombie")) {
                        current.role = "Human";
                    }
                    current = current.next;
                }
                System.out.println("Hurrray! all zombies became normal human!");
                viewPassengers();
            }
        }
    }

    public void clearThisConsole() {
        //Currently clearing console is not working on linux - intelliz idea ide
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void startGame() {
        clearThisConsole();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("_________________________________");
            System.out.println("        Zombie Train Game");
            System.out.println("_________________________________");
            System.out.println("Your Coin: " + coins + "   Total zombie:" + zombieCounter);
            System.out.println("Total Passengers: " + totalPassenger + "   Total Heros:" + heroCounter);
            System.out.println("1. Take Passenger");
            System.out.println("2. View Passengers");
            System.out.println("3. Fight");
            System.out.println("4. Research Center");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    insertPassenger();
                    break;
                case 2:
                    viewPassengers();
                    break;
                case 3:
                    chooseFighter();
                    break;
                case 4:
                    researchCenter();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while(true);
    }

    public static void main(String[] args) {
        ZombieTrain zt = new ZombieTrain();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.insertPassenger();
        zt.startGame();
    }
}
