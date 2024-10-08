package com.game.logic.GameLogic;

import java.util.ArrayList;

import static com.game.logic.GameLogic.Hero.amountOfTeamMembers;

public class TeamSpell {
    String namaSpell;

    public TeamSpell(String namaSpell) {
        this.namaSpell = namaSpell;
    }

    //aksi-aksi :
    public void MeteorAttack(ArrayList<Hero> opponents) {
        System.out.println("Meteor attacks a whole opponent team with " + 60/ opponents.size() + " damage");

        for(Hero heroVar : opponents) {
            int damage = Math.max(0, 60/opponents.size() - heroVar.getCurrentDef());
            heroVar.Attacked(damage);
            if(heroVar.protected_LenghtTime == 1) {
                heroVar.currentDef -= (heroVar.getProtectedBy().getBaseDef()/2);
                heroVar.protectedBy.currentDef += heroVar.protectedBy.getCurrentDef();
                System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
            }
            else if(heroVar.protected_LenghtTime == 2) {
                heroVar.currentDef -= heroVar.protectedBy.getBaseDef()/(amountOfTeamMembers+1);
                heroVar.protectedBy.currentDef += (heroVar.protectedBy.getBaseDef()/(amountOfTeamMembers+1));
                System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
            }
            if(heroVar.protected_LenghtTime == 3) {
                heroVar.currentDef += heroVar.defDecreaser.getCurrentAttack();
            }
            heroVar.protected_LenghtTime = 0;
            System.out.println(heroVar.getName() + " now has " + heroVar.getCurrentHealth() + " HP");
        }
        System.out.println();
        spellTicket--;
        ticketConditionInformation();
    }

    public void ThunderStrike(Hero heroVar) {
        int damage = Math.max(0,30- heroVar.getCurrentDef());
        System.out.println("Thunder Strike attacks " + heroVar.getName() + " with " +  damage + " DMG");
        heroVar.Attacked(damage);
        if(heroVar.protected_LenghtTime == 1) {
            heroVar.currentDef -= (heroVar.getProtectedBy().getBaseDef()/2);
            heroVar.protectedBy.currentDef += heroVar.protectedBy.getCurrentDef();
            System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
        }
        else if(heroVar.protected_LenghtTime == 2) {
            heroVar.currentDef -= heroVar.protectedBy.getBaseDef()/(amountOfTeamMembers+1);
            heroVar.protectedBy.currentDef += (heroVar.protectedBy.getBaseDef()/(amountOfTeamMembers+1));
            System.out.println(heroVar.getName() + "'s defense is back to his base defense power = " + heroVar.currentDef + " DEF");
        }
        if(heroVar.protected_LenghtTime == 3) {
            heroVar.currentDef += heroVar.defDecreaser.getCurrentAttack();
        }
        heroVar.protected_LenghtTime = 0;
        System.out.println(heroVar.getName() + " now has " + heroVar.getCurrentHealth() + " HP\n");
        spellTicket--;
        ticketConditionInformation();
    }

    public void VampiricTouch(Hero receiver, Hero giver) {
        int curHP_giver = giver.getCurrentHealth();
        int curHP_receiver = receiver.getCurrentHealth();
        int damage = Math.max(0, 20 - giver.getCurrentDef());
        giver.Attacked(damage);
        receiver.currentHealth += (giver.currentHealth- curHP_giver);
        System.out.println(giver.getName() + "'s health is decreased for " + (giver.currentHealth- curHP_giver) + " HP");
        System.out.println(receiver.getName() + "'s health is increased for " + (curHP_receiver - receiver.getCurrentHealth()));
        System.out.println();
        spellTicket--;
        ticketConditionInformation();
    }

    public void Sacrificer(Hero sacrificed, Hero getAlive) {
        if (!getAlive.isAlive() && sacrificed.getCurrentHealth() > getAlive.getCurrentHealth() && sacrificed.getBaseHealth() > getAlive.getBaseHealth()) {
            System.out.println(" You are switching the life condition of " + sacrificed.getName() + " and " + getAlive.getName());
            System.out.println(getAlive.getName() + " is back");
            System.out.println(sacrificed.getName() + " dies\n");
            getAlive.currentHealth += sacrificed.currentHealth;
            sacrificed.currentHealth -= sacrificed.getCurrentHealth();
            spellTicket--;
            ticketConditionInformation();
        }
    }

    public String getNamaSpell() {
        return this.namaSpell;
    }

    public int spellTicket = 3;
    public void ticketConditionInformation() {
        if(spellTicket == 0) {
            System.out.println("your all spell ticket has been used !");
        }
        else {
            System.out.println("you still have " + spellTicket + " ticket left to use your spells");
        }
        System.out.println("\n");
    }

}
