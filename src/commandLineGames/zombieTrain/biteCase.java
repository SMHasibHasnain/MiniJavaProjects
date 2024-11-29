package commandLineGames.zombieTrain;

class biteCase extends Thread {

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

    ZombieTrain.Passenger head;
    ZombieTrain.Passenger zombie;

    biteCase(ZombieTrain.Passenger head, ZombieTrain.Passenger zombie) {
        this.head = head;
        this.zombie = zombie;
    }

    public ZombieTrain.Passenger bite() {
        ZombieTrain.Passenger current = head;
        while (current != null) {
            if(current.role.equals("Human")) {
                current.role = "Zombie";
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void run() {
        ZombieTrain.Passenger whoGotBite =  bite();
        if(whoGotBite == null) {
            return;
        }
        System.out.println(Red + Bold + "⚠ Caution: " + Reset + Bold + whoGotBite.name + " got a bite from a Zombie. He has become a Zombie now!\uD83E\uDDDF" + Reset);
        //System.out.println("_________________________________");
        ZombieTrain.zombieCounter++;
    }
}
