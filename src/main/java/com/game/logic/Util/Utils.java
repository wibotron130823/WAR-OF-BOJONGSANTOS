package com.game.logic.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
    //buat method mencatat waktu pertandingan ke dalam BattleHistory.file
    public static void HistoryBattle(String matchResult) {
        try {
            FileWriter fw = new FileWriter("src\\main\\java\\com\\game\\logic\\DB_txt\\BattleHistory.file");
            BufferedWriter bw = new BufferedWriter(fw);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ld = LocalDateTime.now();
            bw.write(dtf.format(ld) + " - " + matchResult);
        }
        catch (IOException e) {
            System.err.println("DB not found");
        }
    }

    public static boolean YesOrNoFunct (String message) {
        //change isYourChoice condition if the input is not (y or Y)
        Scanner UserInput = new Scanner (System.in);
        System.out.print(message);
        String UserChoice = UserInput.next();
        while(! (UserChoice.equalsIgnoreCase("Y") || UserChoice.equalsIgnoreCase("N")) ) {
            System.err.print("Warning : Input invalid, please re-input with (Y/N) only : ");
            UserChoice = UserInput.next();
            System.out.println();
        }
        if (UserChoice.equalsIgnoreCase("N")) {
            return false;
        }
        return UserChoice.equalsIgnoreCase("Y");
    }
}
