

// Main class
public class Game {
    public static void main(String[] args) {
        Thor thor = new Thor();
        Loki loki = new Loki();

        Gameplay game = new Gameplay(thor, loki);
        game.startFight();
    }
}


