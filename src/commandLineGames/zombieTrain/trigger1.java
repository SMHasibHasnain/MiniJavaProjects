package commandLineGames.zombieTrain;

import java.util.Random;

public class trigger1 extends Thread{
    ZombieTrain.Passenger head;

    trigger1(ZombieTrain.Passenger head) {
        this.head = head;
    }

    public void bite() throws InterruptedException {
        Random rand = new Random();
        int toss = rand.nextInt(10);
        if(toss >= 7) {
            biteCase newBite = new biteCase(head, ZombieTrain.currentFighterZombie());
            newBite.start();
            newBite.join();
        }
    }

    public void run() {
        while(true) {
            for(int i = 0; i < ZombieTrain.zombieCounter; i++) {
                try {
                    bite();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
