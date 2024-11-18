

// Main class
public class Game {
    public static void main(String[] args) {
        Thor thor = new Thor();
        Loki loki = new Loki();

        Gameplay game = new Gameplay(thor, loki);
        game.startFight();
    }
}


// Another way of playing the game
// // Abstract base class for all characters
// abstract class Character {
//     protected String name;
//     protected int health;
//     protected int mana;
//     protected int strength;
//     protected int defense;
//     protected String weapon;
    
//     // Constructor
//     public Character(String name, int health, int mana, int strength, int defense, String weapon) {
//         this.name = name;
//         this.health = health;
//         this.mana = mana;
//         this.strength = strength;
//         this.defense = defense;
//         this.weapon = weapon;
//     }
    
//     // Basic attack method
//     public void attack(Character target) {
//         int damage = calculateDamage();
//         int actualDamage = Math.max(0, damage - target.defense);
//         target.health = Math.max(0, target.health - actualDamage);
//         System.out.println(this.name + " attacks " + target.name + " for " + actualDamage + " damage!");
//     }
    
//     // Calculate damage based on strength and random factor
//     protected int calculateDamage() {
//         return (int) (strength * (0.8 + Math.random() * 0.4));
//     }
    
//     // Defend to reduce incoming damage temporarily
//     public void defend() {
//         this.defense += 5;
//         System.out.println(this.name + " takes defensive stance! Defense increased!");
//     }
    
//     // Abstract method for special ability 
//     public abstract void useSpecialAbility();
    
//     // Healing method
//     public void heal() {
//         if (mana >= 30) {
//             int healAmount = 20;
//             health = Math.min(100, health + healAmount);
//             mana -= 30;
//             System.out.println(this.name + " heals for " + healAmount + " health!");
//         } else {
//             System.out.println("Not enough mana to heal!");
//         }
//     }
    
//     // Getters and setters
//     public String getName() { return name; }
//     public int getHealth() { return health; }
//     public int getMana() { return mana; }
//     public void setHealth(int health) { this.health = health; }
//     public void setMana(int mana) { this.mana = mana; }
    
//     // Status display
//     public void displayStatus() {
//         System.out.println("\n" + name + " Status:");
//         System.out.println("Health: " + health);
//         System.out.println("Mana: " + mana);
//         System.out.println("Defense: " + defense);
//     }
// }

// // Thor class 
// class Thor extends Character {
//     private boolean hammerCharged;
//     private int lightningPower;
    
//     public Thor() {
//         super("Thor", 100, 100, 15, 10, "Mjolnir");
//         this.hammerCharged = false;
//         this.lightningPower = 20;
//     }
    
//     public void summonLightning() {
//         if (mana >= 40) {
//             System.out.println("Thor summons lightning! Damage increased!");
//             this.lightningPower += 10;
//             this.mana -= 40;
//         } else {
//             System.out.println("Not enough mana to summon lightning!");
//         }
//     }
    
//     public void throwMjolnir() {
//         if (hammerCharged) {
//             System.out.println("Thor throws Mjolnir with devastating force!");
//             strength *= 2;
//             hammerCharged = false;
//         } else {
//             System.out.println("Mjolnir needs to be charged first!");
//         }
//     }
    
//     public void chargeHammer() {
//         if (mana >= 30) {
//             hammerCharged = true;
//             mana -= 30;
//             System.out.println("Thor charges Mjolnir with lightning!");
//         } else {
//             System.out.println("Not enough mana to charge Mjolnir!");
//         }
//     }
    
//     public void groundSmash() {
//         if (mana >= 25) {
//             System.out.println("Thor smashes the ground, creating a shockwave!");
//             mana -= 25;
//             strength += 5;
//         } else {
//             System.out.println("Not enough mana for ground smash!");
//         }
//     }
    
//     public void resetDefense() {
//         this.defense = 10; // Reseting the defense value  to original 
//     }
    
//     @Override
//     public void useSpecialAbility() {
//         summonLightning();
//     }
// }

// // Loki class implementation
// class Loki extends Character {
//     private int illusionCount;
//     private boolean disguiseActive;
    
//     public Loki() {
//         super("Loki", 90, 120, 10, 8, "Magical Dagger");
//         this.illusionCount = 0;
//         this.disguiseActive = false;
//     }
    
//     public void createIllusion() {
//         if (mana >= 30 && illusionCount < 3) {
//             illusionCount++;
//             mana -= 30;
//             defense += 5;
//             System.out.println("Loki creates an illusion! Defense increased!");
//         } else {
//             System.out.println("Cannot create more illusions!");
//         }
//     }
    
//     public void disguise() {
//         if (mana >= 40 && !disguiseActive) {
//             disguiseActive = true;
//             mana -= 40;
//             defense += 10;
//             System.out.println("Loki disguises himself! Defense increased!");
//         } else {
//             System.out.println("Already disguised or not enough mana!");
//         }
//     }
    
//     public void daggerThrow() {
//         if (mana >= 20) {
//             System.out.println("Loki throws magical daggers!");
//             strength += 8;
//             mana -= 20;
//         } else {
//             System.out.println("Not enough mana for dagger throw!");
//         }
//     }
    
//     public void mindControl() {
//         if (mana >= 50) {
//             System.out.println("Loki attempts to control the opponent's mind!");
//             mana -= 50;
//             strength *= 1.5;
//         } else {
//             System.out.println("Not enough mana for mind control!");
//         }
//     }
//     public void resetDefense() {
//         this.defense = 8; // Reseting the defense value to original  
//         this.disguiseActive = false;
//         this.illusionCount = 0;
//     }
//     @Override
//     public void useSpecialAbility() {
//         createIllusion();
//     }
// }

// // Game class to manage the fighting system

// class Game {
//     private Character player1;
//     private Character player2;
//     private int turnCount;
//     private final int MAX_TURNS = 50; //turn is used otherwise the fight will continure eternally :)
    
//     public Game(Character player1, Character player2) {
//         this.player1 = player1;
//         this.player2 = player2;
//         this.turnCount = 0;
//     }
    
//     public void startFight() {
//         System.out.println("=== Fight Begins ===");
//         System.out.println(player1.getName() + " VS " + player2.getName());
        
//         // Add turn limit and ensure health changes
//         while (player1.getHealth() > 0 && player2.getHealth() > 0 && turnCount < MAX_TURNS) {
//             turnCount++;
//             System.out.println("\n=== Turn " + turnCount + " ===");
            
//             // Display current status
//             player1.displayStatus();
//             player2.displayStatus();
            
//             // Players take turns
//             performTurn(player1, player2);
//             if (player2.getHealth() > 0) {
//                 performTurn(player2, player1);
//             }
            
//             // Reset defense after each round to prevent infinite stacking
//             resetDefense(player1);
//             resetDefense(player2);
//         }
        
//         // Announce winner or draw
//         if (turnCount >= MAX_TURNS) {
//             System.out.println("\n=== Draw! Maximum turns reached ===");
//             System.out.println(player1.getName() + " Health: " + player1.getHealth());
//             System.out.println(player2.getName() + " Health: " + player2.getHealth());
//         } else {
//             Character winner = player1.getHealth() > 0 ? player1 : player2;
//             System.out.println("\n=== " + winner.getName() + " Wins! ===");
//         }
//     }
    
//     private void performTurn(Character attacker, Character defender) {
//         // Modified action selection to ensure damage is dealt
//         int action = (int)(Math.random() * 100); // Using 0-99 range for percentage-based decisions
        
//         if (attacker.getHealth() < 30 && attacker.getMana() >= 30) {
//             // Prioritize healing when low on health
//             attacker.heal();
//         } else if (action < 60) {
//             // 60% chance to attack
//             attacker.attack(defender);
//         } else if (action < 75) {
//             // 15% chance to defend
//             attacker.defend();
//         } else if (action < 90) {
//             // 15% chance to use special ability
//             attacker.useSpecialAbility();
//         } else {
//             // 10% chance to heal
//             attacker.heal();
//         }
//     }
    
//     private void resetDefense(Character character) {
//         if (character instanceof Thor) {
//             ((Thor) character).resetDefense();
//         } else if (character instanceof Loki) {
//             ((Loki) character).resetDefense();
//         }
//     }
// }
// // Main class 
// public class Main {
//     public static void main(String[] args) {
//         // Create characters
//         Thor thor = new Thor();
//         Loki loki = new Loki();
        
//         // Create and start game
//         Game game = new Game(thor, loki);
//         game.startFight();
//     }
// }