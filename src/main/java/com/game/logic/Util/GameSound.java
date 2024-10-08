package com.game.logic.Util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameSound {

    private static Clip clip;

    public static void playSound() {
        try {
            if (clip == null || !clip.isRunning()) { // Mengecek apakah musik sudah dimainkan
                File f = new File("Avabel Online MMORPG OST - Opening Theme.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop musik tanpa henti
                clip.start();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}

