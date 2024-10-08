package com.game.logic.Main;
import com.game.logic.GameLogic.Game;
import com.game.logic.Util.Display;
import com.game.logic.Util.GameSound;
import com.game.logic.Util.Utils;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        Game game = new Game();
        boolean isContinue = true;

        while(isContinue) {
            ClearScreenTerminal();
            GameSound.playSound();
            Display.showGameCover();
            System.out.println();
            System.out.print(" 1. Start Game \n 2. Heroes List \n 3. Battle Spell List \n 4. Match History \n 5. Game Guide \n 6. Exit Game\n");
            System.out.print("choose [1 - 6] : ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    game.start();
                    break;
                case 2:
                    //show all heroes
                    Display.showKnights();
                    System.out.println();
                    Display.showGhosts();
                    System.out.println();
                    break;
                case 3:
                    //show all spells
                    Display.showBattleSpell();
                    System.out.println();
                    break;
                case 4:
                    //show history
                    Display.showHistory();
                    System.out.println();
                    break;
                case 5:
                    //guide for the best gameplay experience
                    Display.showGuide();
                    break;
                case 6:
                    GameSound.stopSound();
                    isContinue = false;
                    break;
                default:
                    System.err.println("Input Invalid!");
                    break;
            }
            isContinue = Utils.YesOrNoFunct("Wanna do anything else (Y/N) ? : ");
            System.out.println();
        }
    }

    public static void ClearScreenTerminal () throws IOException {
        try {
            new ProcessBuilder("cmd" , "/c" , "cls").inheritIO().start().waitFor();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

}