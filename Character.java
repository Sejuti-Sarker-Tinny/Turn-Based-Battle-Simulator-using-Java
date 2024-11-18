

// Abstract base class for all characters
abstract class Character {
    protected String name;
    protected int health;
    protected int mana;
    protected int strength;
    protected int defense;
    protected String weapon;

    // Constructor
    public Character(String name, int health, int mana, int strength, int defense, String weapon) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.defense = defense;
        this.weapon = weapon;
    }

    // Basic attack method
    public void attack(Character target) {
        int damage = calculateDamage();
        int actualDamage = Math.max(0, damage - target.defense);
        target.health = Math.max(0, target.health - actualDamage);
        System.out.println(this.name + " attacks " + target.name + " for " + actualDamage + " damage!");
    }

    // Calculate damage based on strength and a higher multiplier for faster takedown
    protected int calculateDamage() {
        return (int) (strength * (1.5 + Math.random() * 0.5)); //Damage
    }

    // Defend to reduce incoming damage temporarily
    public void defend() {
        this.defense += 5;
        System.out.println(this.name + " takes a defensive stance! Defense increased!");
    }

    // Abstract method for special ability
    public abstract void useSpecialAbility();

    // Healing method
    public void heal() {
        if (mana >= 30) {
            int healAmount = 20;
            health = Math.min(100, health + healAmount);
            mana -= 30;
            System.out.println(this.name + " heals for " + healAmount + " health!");
        } else {
            System.out.println("Not enough mana to heal!");
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public void setHealth(int health) { this.health = health; }
    public void setMana(int mana) { this.mana = mana; }

    // Status display
    public void displayStatus() {
        System.out.println("\n" + name + " Status:");
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Defense: " + defense);
    }
}