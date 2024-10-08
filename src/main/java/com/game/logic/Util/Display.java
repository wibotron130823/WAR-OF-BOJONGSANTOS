package com.game.logic.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Display {

    public static void showGameCover() {
        System.out.println("==========WAR OF BOJONGSANTOS=========== ");
        try {
            FileReader fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\LogoDisplay1.txt");
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            while(data!=null) {
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void showKnights() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\Heroes.file");
            br = new BufferedReader(fr);
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data, ",");

            // Header of the table
            System.out.println("==================TEAM 1 HEROES===================");
            System.out.format("+----------------+-----------+------+-----+------+\n");
            System.out.format("| Name           | Type      | HP   | DMG | DEF  |\n");
            System.out.format("+----------------+-----------+------+-----+------+\n");

            // Loop through the file and display each hero in the table
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                String type = st.nextToken();
                String hp = st.nextToken();
                String dmg = st.nextToken();
                String def = st.nextToken();

                // Util.Display each row in a formatted way
                System.out.format("| %-14s | %-9s | %-4s | %-3s | %-4s |\n", name, type, hp, dmg, def);

                // Read the next line and check if it's null
                data = br.readLine();
                if (data == null) {
                    break;
                }
                st = new StringTokenizer(data, ",");
            }

            // Footer of the table
            System.out.format("+----------------+-----------+------+-----+------+\n");

            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("DB not Found");
        }
    }

    public static void showGhosts() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\Opponents.file");
            br = new BufferedReader(fr);
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data, ",");

            // Header of the table
            System.out.println("==================TEAM 2 HEROES===================");
            System.out.format("+----------------+-----------+------+-----+------+\n");
            System.out.format("| Name           | Type      | HP   | DMG | DEF  |\n");
            System.out.format("+----------------+-----------+------+-----+------+\n");

            // Loop through the file and display each hero in the table
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                String type = st.nextToken();
                String hp = st.nextToken();
                String dmg = st.nextToken();
                String def = st.nextToken();

                // Util.Display each row in a formatted way
                System.out.format("| %-14s | %-9s | %-4s | %-3s | %-4s |\n", name, type, hp, dmg, def);

                // Read the next line and check if it's null
                data = br.readLine();
                if (data == null) {
                    break;
                }
                st = new StringTokenizer(data, ",");
            }

            // Footer of the table
            System.out.format("+----------------+-----------+------+-----+------+\n");

            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("DB not Found");
        }
    }

    public static void showBattleSpell() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\TeamSpell.txt");
            br = new BufferedReader(fr);
            String data;

            // Header of the table
            System.out.println("=====================TEAM SPELL========================");
            System.out.format("+----------------+------------------------------------------------+\n");
            System.out.format("|   Spell Name   |               Description                      |\n");
            System.out.format("+----------------+------------------------------------------------+\n");

            // Loop through the file and display each spell in the table
            while ((data = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(data, ";");
                if (st.countTokens() == 2) { // Pastikan ada dua token
                    String name = st.nextToken().trim();
                    String description = st.nextToken().trim();

                    // Display each row in a formatted way with fixed width
                    System.out.format("| %-14s | %-45s  |\n", name, description);
                }
            }

            // Footer of the table
            System.out.format("+----------------+------------------------------------------------+\n");

            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("DB not Found");
        }
    }



    public static void showHistory() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\BattleHistory.file");
            br = new BufferedReader(fr);
            String data = br.readLine();
            int cnt = 0;
            while(data != null) {
                cnt++;
                System.out.println(cnt +". "+data);
                data = br.readLine();
            }
         }
        catch(IOException e) {
            System.err.println("DB not Found <---> You have never played the game!");
        }
    }

    public static void showGuide() {
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader("src\\main\\java\\com\\game\\logic\\DB_txt\\GameGuide.txt");
            br = new BufferedReader(fr);
            String data = br.readLine();
            System.out.println();
            while(!(data.equals("Creator:@Wibotron.ai"))) {
                System.out.println(data);
                data = br.readLine();
            }
            System.out.println("\n");
        }
        catch(Exception e) {
            System.err.println("DB not Found");
        }
    }


}

