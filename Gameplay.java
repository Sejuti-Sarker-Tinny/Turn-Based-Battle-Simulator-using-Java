import java.util.Scanner;
// Gameplay class

class Gameplay {
    private Character player1;
    private Character player2;
    private Scanner scanner = new Scanner(System.in);

    public Gameplay(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startFight() {
        System.out.println("=== Fight Begins ===");
        System.out.println(player1.getName() + " VS " + player2.getName());

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            player1.displayStatus();
            player2.displayStatus();
            performTurn(player1, player2);
            if (player2.getHealth() > 0) {
                performTurn(player2, player1);
            }
            resetDefense(player1);
            resetDefense(player2);
        }

        Character winner = player1.getHealth() > 0 ? player1 : player2;
        System.out.println("\n=== " + winner.getName() + " Wins! ===");
    }

    private void performTurn(Character attacker, Character defender) {
        System.out.println("\n" + attacker.getName() + "'s turn. Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Special Ability");
        System.out.println("4. Heal");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                attacker.attack(defender);
                break;
            case 2:
                attacker.defend();
                break;
            case 3:
                attacker.useSpecialAbility();
                break;
            case 4:
                attacker.heal();
                break;
            default:
                System.out.println("Invalid choice, skipping turn.");
        }
    }

    private void resetDefense(Character character) {
        if (character instanceof Thor) {
            ((Thor) character).resetDefense();
        } else if (character instanceof Loki) {
            ((Loki) character).resetDefense();
        }
    }
}