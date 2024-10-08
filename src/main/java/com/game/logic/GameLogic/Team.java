package com.game.logic.GameLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Team {

    //data members
    private ArrayList<Hero> heroArrayList = new ArrayList<>();
    private ArrayList<TeamSpell> spellArrayList = new ArrayList<>();

    //Constructor : baca heroes dari Heroes.file file lalu masukkan ke list
    public Team(String filename) throws IOException {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            while (data != null) {
                String[] parts = data.split(",");
                heroArrayList.add(new Hero(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                data = br.readLine();
            }
            br.close();
        }

        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Team() {

    }

    public void removeHeroesFor3v3() {
        if (heroArrayList.size() > 3) {
            heroArrayList = new ArrayList<>(heroArrayList.subList(heroArrayList.size() - 3, heroArrayList.size()));
        }
    }

    public void removeHeroesFor5v5() {
        if (heroArrayList.size() > 5) {
            heroArrayList = new ArrayList<>(heroArrayList.subList(heroArrayList.size() - 5, heroArrayList.size()));
        }
    }
    public void only_2_Spell() {
        if(spellArrayList.size() > 2) {
            spellArrayList = new ArrayList<>(spellArrayList.subList(spellArrayList.size()-2, spellArrayList.size()));
        }
    }


    public int lenghtArr() {
        return heroArrayList.size();
    }
    public int lengthArrOfSpell() {
        return spellArrayList.size();
    }

    //tambah hero ke dalam team
    public void addHero(Hero hero) { //untuk menyusun komposisi team dengan 3 player dan 5 player
        heroArrayList.add(hero);
    }
    //tambah spell ke dalam team-spell
    public void addSpell(TeamSpell spell) {
        spellArrayList.add(spell);
    }
    //buat komposisi team-spell
    public void createSpellComposition(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();

            // Loop membaca baris dari file sampai akhir file
            while (data != null) {
                String[] parts = data.split(";");
                spellArrayList.add(new TeamSpell(parts[0]));
                // Update data dengan membaca baris berikutnya
                data = br.readLine();
            }
            br.close(); // Jangan lupa tutup BufferedReader
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    //akses list hero
    public ArrayList<Hero> getHeroArrayList() {
        return heroArrayList;
    }
    //akses list spell
    public ArrayList<TeamSpell> getSpellArrayList() {
        return spellArrayList;
    }

    // cek tim masih hidup/tidak
    public boolean isDefeated() {
        for(Hero varHero : heroArrayList) {
            if (varHero.isAlive()) {
                return false;
            }
        }
        return true;
    }

    public void showSpell() {
        int cnt = 0;
        for(TeamSpell spell: spellArrayList) {
            cnt =  cnt + 1;
            System.out.println(cnt + ". " + spell.namaSpell);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        stringBuilder.append("================================ YOUR TEAM ======================================\n");
        stringBuilder.append("+----+----------------------+------------+------------+------------+------------+\n");
        stringBuilder.append("| No | Name                 | Type       | HP         | DMG        | DEF        |\n");
        stringBuilder.append("+----+----------------------+------------+------------+------------+------------+\n");

        for (Hero varHero : heroArrayList) {
            cnt++;
            stringBuilder.append(String.format("| %-2d | %-20s | %-10s | %-10s | %-10s | %-10s |\n",
                    cnt,
                    varHero.getName(),
                    varHero.getType(),
                    varHero.getCurrentHealth() + "/" + varHero.getBaseHealth(),
                    varHero.getCurrentAttack() + "/" + varHero.getBaseAtk(),
                    varHero.getCurrentDef() + "/" + varHero.getBaseDef()
            ));
        }

        stringBuilder.append("+----+----------------------+------------+------------+------------+------------+");

        return stringBuilder.toString();
    }



}
