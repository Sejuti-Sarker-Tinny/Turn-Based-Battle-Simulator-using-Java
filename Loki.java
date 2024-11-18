// Loki class
class Loki extends Character {
    private int illusionCount;

    public Loki() {
        super("Loki", 90, 120, 10, 8, "Magical Dagger");
        this.illusionCount = 0;
    }

    public void createIllusion() {
        if (mana >= 30 && illusionCount < 3) {
            illusionCount++;
            mana -= 30;
            defense += 5;
            System.out.println("Loki creates an illusion! Defense increased!");
        } else {
            System.out.println("Cannot create more illusions!");
        }
    }

    public void resetDefense() {
        this.defense = 8;
        this.illusionCount = 0;
    }

    @Override
    public void useSpecialAbility() {
        createIllusion();
    }
}