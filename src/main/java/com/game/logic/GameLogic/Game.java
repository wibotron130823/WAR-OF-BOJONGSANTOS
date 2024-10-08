package com.game.logic.GameLogic;
import com.game.logic.Util.*;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// disinilah logika game dibuat
public class Game {
    Team playerTeam;
    Team opponentTeam;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    // buat constructor
    public Game()   {
        try{
            playerTeam = new Team("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file");
            opponentTeam = new Team("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file");
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void vsMode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PILIH MODE : \n 1. vs Player \n 2. vs COM");
        System.out.print("Choose Mode (1 or 2) : ");
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.println("======vs Player======");
            combatModeVSPLAYER();
            //tinggal dishow saja
            displayChosenHeroes();
            displayChosenSpell();
            //battle
            battlingProcessVSPLAYER();
        }
        else if (choice == 2) {
            System.out.println("======vs COM======");
            combatModeVSCOM();
            //tinggal dishow saja
            displayChosenHeroes();
            displayChosenSpell();
            //battle
            battlingProcessVSCOM();
        }
        else {
            vsMode();
        }
    }

    public void displayChosenHeroes() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CHOSEN HEROES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // Util.Display All Teams
        System.out.println("Player 1 Team : ");
        System.out.println(playerTeam.toString());
        System.out.println("Player 2 Team : ");
        System.out.println(opponentTeam.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void displayChosenSpell() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CHOSEN SPELL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Player 1 Spell : ");
        playerTeam.showSpell();
        System.out.println("Player 2 Spell : ");
        opponentTeam.showSpell();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void combatModeVSPLAYER() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSING COMBAT MODE : \n 1. (3 vs 3) \n 2. (5 vs 5) ");
        System.out.print("Choose by index : ");
        int choice = sc.nextInt();
        if(choice == 1) {
            int randomDecision = random.nextInt(2);
            switch(randomDecision) {
                case 0 :
                    System.out.println("\nTURN OF CHOOSING HEROES START FROM P1!");
                    System.out.println("\nCHOOSING HEROES OF P1 TEAM : ");
                    for (int i = 0; i < 3; i++) {
                        playerTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file"));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P1 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    // pilih opponent team
                    System.out.println("CHOOSING HEROES OF P2 TEAM : ");
                    for (int i = 0; i < 3; i++) {
                        opponentTeam.addHero((selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file")));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P2 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        opponentTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    playerTeam.removeHeroesFor3v3();
                    playerTeam.only_2_Spell();
                    opponentTeam.removeHeroesFor3v3();
                    opponentTeam.only_2_Spell();
                    break;
                case 1 :
                    System.out.println("\nTURN OF CHOOSING HEROES START FROM P2!");
                    System.out.println("\nCHOOSING HEROES OF P2 TEAM : ");
                    for (int i = 0; i < 3; i++) {
                        opponentTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file"));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P2 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        opponentTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING HEROES OF P1 TEAM : ");
                    for (int i = 0; i < 3; i++) {
                        playerTeam.addHero((selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file")));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P1 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    playerTeam.removeHeroesFor3v3();
                    playerTeam.only_2_Spell();
                    opponentTeam.removeHeroesFor3v3();
                    opponentTeam.only_2_Spell();
                    break;
            }
        }
        else if (choice == 2) {
            int randomDecision = random.nextInt(2);
            switch (randomDecision) {
                case 0:
                    System.out.println("\nTURN OF CHOOSING HEROES START FROM P1!");
                    System.out.println("\nCHOOSING HEROES OF P1 TEAM : ");
                    for (int i = 0; i < 5; i++) {
                        playerTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file"));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P1 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    // pilih opponent team
                    System.out.println("CHOOSING HEROES OF P2 TEAM : ");
                    for (int i = 0; i < 5; i++) {
                        opponentTeam.addHero((selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file")));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P2 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        opponentTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    playerTeam.removeHeroesFor5v5();
                    playerTeam.only_2_Spell();
                    opponentTeam.removeHeroesFor5v5();
                    opponentTeam.only_2_Spell();
                    break;
                case 1:
                    System.out.println("TURN OF CHOOSING HEROES START FROM P2!");
                    System.out.println("\nCHOOSING HEROES OF P2 TEAM : ");
                    for (int i = 0; i < 5; i++) {
                        opponentTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file"));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P2 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        opponentTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    // pilih opponent team
                    System.out.println("CHOOSING HEROES OF P1 TEAM : ");
                    for (int i = 0; i < 5; i++) {
                        playerTeam.addHero((selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file")));
                    }
                    System.out.println("\n");
                    System.out.println("CHOOSING SPELL OF P1 TEAM : ");
                    for (int i = 0; i < 2; i++) {
                        playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
                    }
                    System.out.println("\n");
                    playerTeam.removeHeroesFor5v5();
                    playerTeam.only_2_Spell();
                    opponentTeam.removeHeroesFor5v5();
                    opponentTeam.only_2_Spell();
                    break;
            }
        }
    }

    public void combatModeVSCOM() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSING COMBAT MODE : \n 1. (3 vs 3) \n 2. (5 vs 5) ");
        System.out.print("choose by index : ");
        int choice = sc.nextInt();
        if(choice == 1) {
            // pilih player team
            System.out.println("\nCHOOSING HEROES OF P1 TEAM : ");
            for(int i = 0; i < 3; i++) {
                playerTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file"));
            }
            System.out.println("\n");
            System.out.println("CHOOSING SPELL OF P1 TEAM : ");
            for(int i = 0; i < 2; i++) {
                playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
            }
            System.out.println("\n");
            // pilih opponent team
            System.out.println("CHOOSING HEROES OF P2 TEAM : ");
            for(int i = 0; i < 3; i++) {
                opponentTeam.addHero((selectRandomHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file")));
            }
            System.out.println("\n");
            System.out.println("CHOOSING SPELL OF P2 TEAM : ");
            for(int i = 0; i < 2; i++) {
                opponentTeam.addSpell(selectRandomSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
            }
            System.out.println("\n");
            playerTeam.removeHeroesFor3v3();
            playerTeam.only_2_Spell();
            opponentTeam.removeHeroesFor3v3();
            opponentTeam.only_2_Spell();
        }
        else if (choice == 2) {
            // pilih player team
            System.out.println("\nCHOOSING HEROES OF P1 TEAM : ");
            for(int i = 0; i < 5; i++) {
                playerTeam.addHero(selectHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file"));
            }
            System.out.println("\n");
            System.out.println("CHOOSING SPELL OF P1 TEAM : ");
            for(int i = 0; i < 2; i++) {
                playerTeam.addSpell(selectSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
            }
            System.out.println("\n");
            // pilih opponent team
            System.out.println("CHOOSING HEROES OF P2 TEAM : ");
            for(int i = 0; i < 5; i++) {
                opponentTeam.addHero((selectRandomHero("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file")));
            }
            System.out.println("CHOOSING SPELL OF P2 TEAM : ");
            for(int i = 0; i < 2; i++) {
                opponentTeam.addSpell(selectRandomSpell("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt"));
            }
            System.out.println("\n");
            playerTeam.removeHeroesFor5v5();
            playerTeam.only_2_Spell();
            opponentTeam.removeHeroesFor5v5();
            opponentTeam.only_2_Spell();
        }
    }

    public void battlingProcessVSPLAYER() {
        // start battle
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BATTLING~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(!playerTeam.isDefeated() && !opponentTeam.isDefeated()) {
            Turn(playerTeam, opponentTeam); //p1 menyerang p2
            if(!opponentTeam.isDefeated()) {
                Turn(opponentTeam, playerTeam); //p2 menyerang p1
            }
        }

        String result;
        if(playerTeam.isDefeated()) {
            result = "TEAM 1 WIN !";
        }
        else {
            result = "TEAM 2 WIN !";
        }

        try {
            Utils.HistoryBattle(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void battlingProcessVSCOM() {
        // start battle
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BATTLING~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(!playerTeam.isDefeated() && !opponentTeam.isDefeated()) {
            Turn(playerTeam, opponentTeam); //p1 menyerang p2
            if(!opponentTeam.isDefeated()) {
                turnVSCOMforP2(opponentTeam, playerTeam); //p2 menyerang p1
            }
        }

        String result;
        if(playerTeam.isDefeated()) {
            result = "TEAM 1 WIN !";
        }
        else {
            result = "TEAM 2 WIN !";
        }

        try {
            Utils.HistoryBattle(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void start() {
        vsMode();
    }

    private Hero selectHero(String filename) {
        Team availableHeroes = null;
        try{
            availableHeroes = new Team(filename); //akan membaca semua hero di file dan langsung dimasukkan ke array list
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(availableHeroes.toString());
        System.out.print("Choose heroes by inserting Index : ");
        int index = sc.nextInt();
        return availableHeroes.getHeroArrayList().get(index - 1);
    }
    private TeamSpell selectSpell(String filename) {
        // Pastikan choosingSpell diinisialisasi dengan objek Team
        Team choosingSpell = new Team();
        // Panggil method createSpellComposition
        choosingSpell.createSpellComposition(filename);
        // Tampilkan spell yang ada
        choosingSpell.showSpell();
        // Ambil input index dari user
        System.out.println("Choose spell by inserting Index : ");
        int index = sc.nextInt();
        // Kembalikan spell yang dipilih berdasarkan index
        return choosingSpell.getSpellArrayList().get(index - 1);
    }

    private Hero selectRandomHero(String filename) {
        Team availableHeroes = null;
        try {
            availableHeroes = new Team(filename);
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(availableHeroes.toString());
        System.out.println("Opponents are going to be chosen randomly");
        int index = random.nextInt(availableHeroes.lenghtArr());
        return availableHeroes.getHeroArrayList().get(index);
    }
    private TeamSpell selectRandomSpell(String filename) {
        // Pastikan choosingSpell diinisialisasi dengan objek Team
        Team choosingSpell = new Team();
        // Panggil method createSpellComposition
        choosingSpell.createSpellComposition(filename);
        // Tampilkan spell yang ada
        choosingSpell.showSpell();
        // Ambil input index dari user
        System.out.println("Choose spell by inserting Index : ");
        int index = random.nextInt(choosingSpell.lengthArrOfSpell());
        // Kembalikan spell yang dipilih berdasarkan index
        return choosingSpell.getSpellArrayList().get(index);
    }

    private void Turn(Team atkTeam, Team defTeam) {
        Hero attacker = selectAttacker(atkTeam);
        if (attacker == null) return;

        if (attacker.getType().equals("Support")) {
            System.out.println("+++++++ACTIONS+++++++\n" + "1. Heal Teammate\n" + "2. Attack Opponent\n" + "3. Heal a whole Teammates\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = sc.nextInt();
            Hero target;
            switch (choice) {
                case 1:
                    target = selectTarget(atkTeam, true); //healing action
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Heal(target);
                        System.out.println(attacker.getName() + " heals " + target.getName() + " with " + attacker.getCurrentAttack() + " HP");
                        System.out.println(target.getName() + "'s health increased by " + (target.getCurrentHealth() - curHP + " HP") );
                        System.out.print(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2:
                    target = selectTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 3 :
                    attacker.HealTeam(atkTeam.getHeroArrayList());
                default:
                    System.err.println("Input Invalid");
                    break;
            }
        }
        else if(attacker.getType().equals("Warrior")) {
            System.out.println("+++++++ACTIONS+++++++\n" + "1. Slash Opponent\n" + "2. Slash All Opponents\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1  :
                    Hero target = selectTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2  :
                    attacker.AttackTeam(defTeam.getHeroArrayList());
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if(attacker.getType().equals("Tank")) {
            System.out.println("++++++ACTIONS++++++\n" + "1. Slash Opponent\n" + "2. Protect Teammate\n" + "3. Protect a whole Teammates\n");
            System.out.println("CHOOSE ACTION BY INDEX = ");
            int choice = sc.nextInt();
            Hero target;
            switch (choice) {
                case 1 :
                    target = selectTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2 :
                    target = selectTarget(atkTeam, false);
                    if(target != null && target != attacker) {
                        attacker.Protect(target);
                        System.out.println(attacker.getName() + " is protecting " + target.getName() + " by sharing his half defense = " + attacker.getCurrentDef()/2 + " DEF");
                        System.out.println(target.getName() + " now has " + target.getCurrentDef() + " DEF\n");
                    }
                    break;
                case 3 :
                    attacker.ProtectTeam(atkTeam.getHeroArrayList());
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if (attacker.getType().equals("Buffer")) {
            System.out.println("++++++ACTIONS++++++ \n 1. Attack Opponent \n 2. Increase Teammate's Damage \n 3. Decrease Opponent's Damage \n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = sc.nextInt();
            Hero target;
            switch (choice) {
                case 1 :
                    target = selectTarget(defTeam, false);
                    if(target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2 :
                    target = selectTarget(atkTeam, false);
                    Hero target2;
                    if (target != null && target != attacker && Hero.getBuffCoupon() > 0) {
                        int baseDMG = target.getBaseAtk();
                        attacker.attackUp_to(target);
                        System.out.println("It's your turn to attack opponent : ");
                        target2 = selectTarget(defTeam, false);
                        int curHP = target2.getCurrentHealth();
                        target.Attack(target2);
                        System.out.println(target.getName() + " attacks " + target2.getName() + " with " + target.getCurrentAttack() + " DMG");
                        System.out.println(target2.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target2.getName() + " now has " + target2.getCurrentHealth() + " HP\n");
                        attacker.attackReset(target, baseDMG);
                    }
                    else {
                        System.err.println("you have no atk up buff coupon anymore");
                    }
                    break;
                case 3 :
                    target = selectTarget(defTeam, false);
                    if(target != null && Hero.getBuffCoupon2() > 0) {
                        attacker.attackDecreaser_to(target);
                    }
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if (attacker.getType().equals("Poisoner")) {
            System.out.println("++++++ACTIONS++++++ \n 1. Attack Opponent \n 2. Poisoner Mode \n 3. Poison of Defend Decreaser\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = sc.nextInt();
            Hero target;
            switch (choice) {
                case 1 :
                    target = selectTarget(defTeam, false);
                    if(target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2 :
                    target = attacker;
                    if(target != null && Hero.getBody_PoisonedCoupon() > 0) {
                        System.out.println(attacker.getName() + " use poisoner mode\n");
                        attacker.usePoisonMode();
                    }
                    break;
                case 3 :
                    target = selectTarget(defTeam, false);
                    if(target != null) {
                        attacker.defDecreaser_to(target);
                    }
                    break;
                default:
                    System.err.println("Input Invalid!");
                    break;
            }
        }

        System.out.print("Wanna use your spell(y/n) : ");
        String keputusan = sc.next();
        keputusan.toLowerCase();
        if(keputusan.equals("y")) {
            turnSpellnonCom(atkTeam, defTeam);
        }
        else{
            System.out.println("I decided not to use spell");
        }
    }
    private void turnSpellnonCom(Team atkTeam, Team defTeam) {
        TeamSpell ur_spell = selectYourSpell(atkTeam);
        if(ur_spell.getNamaSpell().equals("Meteor-Rain")) {
            ur_spell.MeteorAttack(defTeam.getHeroArrayList());
        }
        else if(ur_spell.getNamaSpell().equals("Thunder-Strike")) {
            Hero target = selectTarget(defTeam, false);
            ur_spell.ThunderStrike(target);
        }
        else if(ur_spell.getNamaSpell().equals("Vampiric-Touch")) {
            Hero receiver = selectAttacker(atkTeam);
            Hero victim = selectTarget(defTeam, false);
            ur_spell.VampiricTouch(receiver, victim);
        }
        else if(ur_spell.getNamaSpell().equals("Life-Switcher")) {
            Hero sacrificer = selectAttacker(atkTeam);
            Hero life_Receiver = selectTarget(atkTeam, false);
            ur_spell.Sacrificer(sacrificer, life_Receiver);
        }
    }

    private void turnSpellCom(Team atkTeam, Team defTeam) {
        TeamSpell ur_spell = selectYourRandomSpell(atkTeam);
        if(ur_spell.getNamaSpell().equals("Meteor-Rain")) {
            ur_spell.MeteorAttack(defTeam.getHeroArrayList());
        }
        else if(ur_spell.getNamaSpell().equals("Thunder-Strike")) {
            Hero target = selectRandomTarget(defTeam, false);
            ur_spell.ThunderStrike(target);
        }
        else if(ur_spell.getNamaSpell().equals("Vampiric-Touch")) {
            Hero receiver = selectRandomAttacker(atkTeam);
            Hero victim = selectRandomTarget(defTeam, false);
            ur_spell.VampiricTouch(receiver, victim);
        }
        else if(ur_spell.getNamaSpell().equals("Life-Switcher")) {
            Hero sacrificer = selectRandomAttacker(atkTeam);
            Hero life_Receiver = selectRandomTarget(atkTeam, false);
            ur_spell.Sacrificer(sacrificer, life_Receiver);
        }
    }

    private void turnVSCOMforP2(Team atkTeam, Team defTeam) {
        Hero attacker = selectRandomAttacker(atkTeam);
        if (attacker == null) return;
        if (attacker.getType().equals("Support")) {
            System.out.println("+++++++ACTIONS+++++++\n" + "1. Heal Teammate\n" + "2. Attack Opponent\n" + "3. Heal a whole Teammates\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = random.nextInt(3);
            Hero target;
            switch (choice) {
                case 0:
                    target = selectRandomTarget(atkTeam, true); //healing action
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Heal(target);
                        System.out.println(attacker.getName() + " heals " + target.getName() + " with " + attacker.getCurrentAttack() + " HP");
                        System.out.println(target.getName() + "'s health increased by " + (target.getCurrentHealth() - curHP + " HP") );
                        System.out.print(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 1:
                    target = selectRandomTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 2:
                    attacker.HealTeam(atkTeam.getHeroArrayList());
                default:
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if(attacker.getType().equals("Warrior")) {
            System.out.println("+++++++ACTIONS+++++++\n" + "1. Slash Opponent\n" + "2. Slash All Opponents\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = random.nextInt(2);
            switch (choice) {
                case 0  :
                    Hero target = selectRandomTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 1  :
                    attacker.AttackTeam(defTeam.getHeroArrayList());
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if(attacker.getType().equals("Tank")) {
            System.out.println("++++++ACTIONS++++++\n" + "1. Slash Opponent\n" + "2. Protect Teammate\n" + "3. Protect a whole Teammates\n");
            System.out.println("CHOOSE ACTION BY INDEX = ");
            int choice = random.nextInt(3);
            Hero target;
            switch (choice) {
                case 0 :
                    target = selectRandomTarget(defTeam, false);
                    if (target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 1 :
                    target = selectRandomTarget(atkTeam, false);
                    if(target != null && target != attacker) {
                        attacker.Protect(target);
                        System.out.println(attacker.getName() + " is protecting " + target.getName() + " by sharing his half defense = " + attacker.getCurrentDef()/2 + " DEF");
                        System.out.println(target.getName() + " now has " + target.getCurrentDef() + " DEF\n");
                    }
                    break;
                case 2 :
                    attacker.ProtectTeam(atkTeam.getHeroArrayList());
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if (attacker.getType().equals("Buffer")) {
            System.out.println("++++++ACTIONS++++++ \n 1. Attack Opponent \n 2. Increase Teammate's Damage \n 3. Decrease Opponent's Damage \n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = random.nextInt(3);
            Hero target;
            switch (choice) {
                case 0 :
                    target = selectRandomTarget(defTeam, false);
                    if(target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 1 :
                    target = selectRandomTarget(atkTeam, false);
                    Hero target2;
                    if (target != null && target != attacker && Hero.getBuffCoupon() > 0) {
                        int baseDMG = target.getBaseAtk();
                        attacker.attackUp_to(target);
                        System.out.println("It's your turn to attack opponent : ");
                        target2 = selectTarget(defTeam, false);
                        int curHP = target2.getCurrentHealth();
                        target.Attack(target2);
                        System.out.println(target.getName() + " attacks " + target2.getName() + " with " + target.getCurrentAttack() + " DMG");
                        System.out.println(target2.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target2.getName() + " now has " + target2.getCurrentHealth() + " HP\n");
                        attacker.attackReset(target, baseDMG);
                    }
                    else {
                        System.err.println("you have no atk up buff coupon anymore");
                    }
                    break;
                case 2 :
                    target = selectRandomTarget(defTeam, false);
                    if(target != null && Hero.getBuffCoupon2() > 0) {
                        attacker.attackDecreaser_to(target);
                    }
                    break;
                default :
                    System.err.println("Input Invalid!");
                    break;
            }
        }
        else if (attacker.getType().equals("Poisoner")) {
            System.out.println("++++++ACTIONS++++++ \n 1. Attack Opponent \n 2. Poisoner Mode \n 3. Poison of Defend Decreaser\n");
            System.out.print("CHOOSE ACTION BY INDEX = ");
            int choice = random.nextInt(3);
            Hero target;
            switch (choice) {
                case 0 :
                    target = selectRandomTarget(defTeam, false);
                    if(target != null) {
                        int curHP = target.getCurrentHealth();
                        attacker.Attack(target);
                        System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + attacker.getCurrentAttack() + " DMG");
                        System.out.println(target.getName() + " health is damaged by " + (target.getCurrentHealth() - curHP) + " DMG");
                        System.out.println(target.getName() + " now has " + target.getCurrentHealth() + " HP\n");
                    }
                    break;
                case 1 :
                    target = attacker;
                    if(target != null && Hero.getBody_PoisonedCoupon() > 0) {
                        System.out.println(attacker.getName() + " use poisoner mode\n");
                        attacker.usePoisonMode();
                    }
                    break;
                case 2 :
                    target = selectRandomTarget(defTeam, false);
                    if(target != null) {
                        attacker.defDecreaser_to(target);
                    }
                    break;
                default:
                    System.err.println("Input Invalid!");
                    break;
            }
        }

        System.out.print("Wanna use your spell : ");
        int decision = random.nextInt(2);
        switch(decision) {
            case 0:
                turnSpellCom(atkTeam, defTeam);
                break;
            case 1:
                System.out.println("I decided not to use spell");
                break;
            default:
                System.err.println("Input Invalid!");
                break;
        }
    }

    private Hero selectAttacker(Team team) {
        System.out.println("CHOOSE ATTACKER FROM UR TEAM : ");
        System.out.println(team.toString());
        System.out.print("Choose by Index : ");
        int index = sc.nextInt();
        return team.getHeroArrayList().get(index-1);
    }

    private TeamSpell selectYourSpell(Team team) {
        System.out.println("CHOOSE SPELL FOR UR TEAM :");
        team.showSpell();
        System.out.println("Choose by Index : ");
        int index = sc .nextInt();
        return team.getSpellArrayList().get(index-1);
    }
    private TeamSpell selectYourRandomSpell(Team team) {
        System.out.println("CHOOSE SPELL FOR UR TEAM RANDOMLY :");
        team.showSpell();
        int index = random.nextInt(team.lengthArrOfSpell());
        return team.getSpellArrayList().get(index);
    }

    private Hero selectRandomAttacker(Team team) {
        System.out.println("CHOOSING ATTACKER RANDOMLY ");
        System.out.println(team.toString());
        int index = random.nextInt(team.lenghtArr());
        return team.getHeroArrayList().get(index);
    }

    private Hero selectTarget(Team team, boolean isHealing) {
        if(isHealing) {
            System.out.println("CHOOSE TARGET : ");
        }
        else {
            System.out.println("CHOOSE TARGET : ");
        }
        System.out.println(team.toString());
        System.out.print("Choose by Index : ");
        int index = sc.nextInt();
        return team.getHeroArrayList().get(index-1);
    }

    private Hero selectRandomTarget(Team team, boolean isHealing) {
        System.out.println("CHOOSING TARGET RANDOMLY");
        System.out.println(team.toString());
        int index = random.nextInt(team.lenghtArr());
        return team.getHeroArrayList().get(index);
    }

}