package commandLineGames.zombieTrain;

import java.util.Random;

public class trigger1 extends Thread{
    ZombieTrain.Passenger head;
    final String Italic = "\u001B[3m";

    trigger1(ZombieTrain.Passenger head) {
        this.head = head;
    }

    public void bite() throws InterruptedException {
        Random rand = new Random();
        int toss = rand.nextInt(10);
        if(toss >= 8) {
            biteCase newBite = new biteCase(head, ZombieTrain.currentFighterZombie());
            newBite.start();
            newBite.join();
        }
    }

    public void run() {
        while(true) {
            int prev = ZombieTrain.zombieCounter;
            for(int i = 0; i < ZombieTrain.zombieCounter; i++) {
                try {
                    bite();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int curr = ZombieTrain.zombieCounter;
            int change = curr - prev;
            if(ZombieTrain.zombieCounter>1 && change > 0 ) {
                System.out.println();
                System.out.print(ZombieTrain.Italic + ZombieTrain.Yellow + "Here is total " + ZombieTrain.zombieCounter + " zombies now! Zombies can bite innocent humans! Fight and Kill the jombies fast!⚔\uFE0F" + ZombieTrain.Reset);
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
