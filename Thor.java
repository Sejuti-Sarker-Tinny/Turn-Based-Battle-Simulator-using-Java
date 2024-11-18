// Thor class
class Thor extends Character {
    private boolean hammerCharged;

    public Thor() {
        super("Thor", 100, 100, 15, 10, "Mjolnir");
        this.hammerCharged = false;
    }

    public void summonLightning() {
        if (mana >= 40) {
            System.out.println("Thor summons lightning! Damage increased!");
            mana -= 40;
        } else {
            System.out.println("Not enough mana to summon lightning!");
        }
    }

    public void throwMjolnir() {
        if (hammerCharged) {
            System.out.println("Thor throws Mjolnir with devastating force!");
            strength *= 2;
            hammerCharged = false;
        } else {
            System.out.println("Mjolnir needs to be charged first!");
        }
    }

    public void chargeHammer() {
        if (mana >= 30) {
            hammerCharged = true;
            mana -= 30;
            System.out.println("Thor charges Mjolnir with lightning!");
        } else {
            System.out.println("Not enough mana to charge Mjolnir!");
        }
    }

    public void resetDefense() {
        this.defense = 10;
    }

    @Override
    public void useSpecialAbility() {
        summonLightning();
    }
}