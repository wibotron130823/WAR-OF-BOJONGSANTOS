package com.game.logic.GameLogic;

import java.util.ArrayList;
import java.util.Random;

public class Hero {
    //Data members
    Random random = new Random();
    private String name;
    private String type;
    private int baseHealth;
    public int currentHealth;
    private int baseAtk;
    private int baseDef;
    public int currentDef;
    public Hero protectedBy = null;
    public Hero defDecreaser = null;
    private int currentAttack;

    //Constructor for initializing
    public Hero(String name, String type, int baseHealth, int baseAtk, int baseDef) {
        this.name = name;
        this.type = type;
        this.baseHealth = baseHealth;
        this.currentHealth = baseHealth;
        this.baseAtk = baseAtk;
        this.currentAttack = baseAtk;
        this.baseDef = baseDef;
        this.currentDef = baseDef;
    }

    //Tank Class, Support Class, Warrior Class, Buffer Class, Toxicologist Class
    public void Attack(Hero target) {
        int damage = Math.max(0, this.currentAttack - target.getCurrentDef());
        target.Attacked(damage);
        if (target.protected_LenghtTime == 1) {
            target.currentDef -= (target.protectedBy.getBaseDef()/2);
            target.protectedBy.currentDef += target.protectedBy.currentDef;
            System.out.println(target.getName() +"'s defense is back to his base defense power = " + target.getCurrentDef() + " DEF");
        }
        else if (target.protected_LenghtTime == 2) {
            target.currentDef -= target.protectedBy.getBaseDef()/(amountOfTeamMembers+1);
            target.protectedBy.currentDef += target.protectedBy.baseDef/(amountOfTeamMembers+1);
            System.out.println(target.getName() +"'s defense is back to his base defense power = " + target.getCurrentDef() + " DEF");
        }

        if(target.protected_LenghtTime == 3) {
            target.currentDef += target.defDecreaser.getCurrentAttack();
        }
        target.protected_LenghtTime = 0;
        if (this.buffActivation == 1) {
            this.buffActivation = 0;
            this.currentAttack = this.getBaseAtk();
            System.out.println(this.getName() +"'s damage is back to his base attack power = " + this.getBaseAtk() + " DMG");
        }
        if(target.body_PoisonedStatus == 1) {
            this.currentHealth -= (target.currentAttack - this.currentDef);
            target.body_PoisonedStatus = 0;
        }
    }
    public void Attacked(int damage) {
        this.currentHealth = Math.max(0, this.currentHealth - damage);
    }
    public void AttackTeam(ArrayList<Hero> opponents) {
        System.out.println("\n"+this.name + " attacks a whole opponents with " + this.baseAtk/ opponents.size() + " DMG");
        for(Hero heroVar : opponents ) {
            int damage = Math.max(0, this.currentAttack/opponents.size() - heroVar.getCurrentDef());
            heroVar.Attacked(damage);
            if(heroVar.protected_LenghtTime == 1) {
                heroVar.currentDef -= (heroVar.protectedBy.getBaseDef()/2);
                heroVar.protectedBy.currentDef += heroVar.protectedBy.getCurrentDef();
                System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
            }
            else if(heroVar.protected_LenghtTime == 2) {
                heroVar.currentDef -= heroVar.protectedBy.getBaseDef()/(amountOfTeamMembers+1);
                heroVar.protectedBy.currentDef += (heroVar.protectedBy.baseDef/(amountOfTeamMembers+1));
                System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
            }
            if(heroVar.protected_LenghtTime == 3) {
                heroVar.currentDef += heroVar.defDecreaser.getCurrentAttack();
            }
            heroVar.protected_LenghtTime = 0;
            System.out.println(heroVar.getName() + " now has " + heroVar.getCurrentHealth() + " HP");
            if (this.buffActivation == 1) {
                this.buffActivation = 0;
                this.currentAttack = this.getBaseAtk();
                System.out.println(this.getName() +"'s damage is back to his base attack power = " + this.getCurrentAttack() + " DMG");
            }
            if(heroVar.body_PoisonedStatus == 1) {
                this.currentHealth -= (heroVar.currentAttack - this.currentDef);
                heroVar.body_PoisonedStatus = 0;
            }
            if(heroVar.getCurrentHealth() <= 0) {
                System.out.println(heroVar.getName() + " dies!");
            }
        }
        System.out.println();
    }

    //Tank Class
    public void Protect(Hero target) {
        if(target != this) {
            target.Protected(this.getCurrentDef() / 2);
            this.currentDef -= this.currentDef/2;
            target.protected_LenghtTime = 1;
            target.protectedBy = this; // Set pelindung
        }
    }
    public void Protected(int tankatk) {
        this.currentDef += tankatk;
    }
    public void ProtectAll(Hero target, int AmountOfTeammates) {
        target.Protected(this.getCurrentDef()/(AmountOfTeammates+1));
        this.currentDef -= ( (AmountOfTeammates) * (this.getCurrentDef()/(AmountOfTeammates+1)));
        target.protected_LenghtTime = 2;
        target.protectedBy = this;
    }
    public int protected_LenghtTime = 0;
    public void ProtectTeam(ArrayList<Hero> teammates) {
        System.out.println(this.name + " protects a whole teammates with " + this.getBaseDef()/teammates.size() + " DEF");
        for(Hero heroVar : teammates) {
            if( (heroVar.isAlive() || heroVar != null) && heroVar != this) {
                ProtectAll(heroVar, teammates.size());
                System.out.println(heroVar.getName() + " now has " + heroVar.getCurrentDef() + " DEF");
                amountOfTeamMembers++;
            }
        }
        System.out.println();
    }
    public static int amountOfTeamMembers = 0;

    //Support Class
    public void Heal(Hero target) {
        target.Healed(this.currentAttack);
    }
    public void Healed(int heal) {
        this.currentHealth = Math.min(this.baseHealth, this.currentHealth + heal);
    }
    public void HealTeam(ArrayList<Hero> teammates) {
        System.out.println(this.name + " heals a whole teammates with " + this.currentAttack/teammates.size() + " HP");
        int heal = this.currentAttack/teammates.size();
        for(Hero heroVar : teammates) {
            if ( ((heroVar.isAlive()) || heroVar != null) && heroVar != this) {
                heroVar.Healed(heal);
                System.out.println(heroVar.getName() + " gets healed for " + heal +" HP");
            }
        }
    }

    //Buffer Class
    private static int buffCoupon = 5;
    public static int getBuffCoupon() {
        return buffCoupon;
    }
    public void attackReset(Hero hero, int trueDMG) {
        hero.currentAttack = trueDMG;
    }
    public void attackUp_to(Hero target) {
        target.teammate_AttackedUp();
        System.out.println(target.getName() + " now has " + target.getCurrentAttack() + " DMG");
        buffCoupon--;
    }
    public void teammate_AttackedUp() {
        int damageUp = Math.max( 0, random.nextInt(6, 11+1) );
        System.out.println("your teammate gets " + damageUp + " DMG up");
        this.currentAttack = this.currentAttack + damageUp;
    }

    private static int buffCoupon2 = 5;
    private int buffActivation = 0;
    public static int getBuffCoupon2() {
        return buffCoupon2;
    }
    public void attackDecreaser_to(Hero target) {
        target.opponentDamage_Decreaded();
        buffCoupon2--;
        target.buffActivation = 1;
        System.out.println(target.getName() + " now has " + target.getCurrentAttack() + " DMG");
    }
    public void opponentDamage_Decreaded() {
        int atkDecrease = Math.max(0, random.nextInt(6, 11+1));
        this.currentAttack = this.getCurrentAttack() - atkDecrease;
        System.out.println("your opponent gets " + atkDecrease + " DMG decreased");
    }

    //Toxicologist Class
    private int body_PoisonedStatus = 0;
    private static int body_PoisonedCoupon = 5;
    public static int getBody_PoisonedCoupon() {
        return body_PoisonedCoupon;
    }
    public void usePoisonMode() {
        this.body_PoisonedStatus = 1;
        body_PoisonedCoupon--;
    }
    public void defDecreaser_to(Hero target) {
        target.opponentDef_Decreased(this.currentAttack);
        target.defDecreaser = this;
        System.out.println(target.getName() + "'s defense gets decreased for " + (target.getBaseDef()-target.getCurrentDef()) + " DEF");
        System.out.println(target.getName() + " now has " + target.getCurrentDef() + " DEF");
        target.protected_LenghtTime = 3;
    }
    public void opponentDef_Decreased(int defDecrease) {
        this.currentDef -= defDecrease;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getBaseHealth() {
        return this.baseHealth;
    }

    public int getBaseAtk() {
        return this.baseAtk;
    }

    public int getBaseDef() {
        return this.baseDef;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getCurrentDef() {
        return this.currentDef;
    }
    public int getCurrentAttack() {
        return this.currentAttack;
    }

    public Hero getProtectedBy() {
        return this.protectedBy;
    }
    //cek hero masih hidup atau tidak
    public boolean isAlive() {
        if(this.currentHealth > 0) {
            return true;
        }
        return false;
    }

    //untuk display
    @Override
    public String toString() {
        return String.format("%s (%s) HP = %d/%d, DMG = %d/%d, DEF = %d/%d",
                getName(),
                getType(),
                getCurrentHealth(),
                getBaseHealth(),
                getCurrentAttack(),
                getBaseAtk(),
                getCurrentDef(),
                getBaseDef()
        );
    }

}
