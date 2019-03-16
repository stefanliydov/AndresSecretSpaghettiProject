package andres_game.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer  {
    private static Clip clip;
    private static Clip gameClip;
    public static void playMusic(MusicTracks musicTracks) {
        try {
            File in = new File(musicTracks.getName());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
             clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }


    public static void stopMusic(){
        if(clip!=null) {
            clip.stop();
        }
    }
    public static void continueMusic(){
        if(clip!=null) {
            clip.start();
        }
    }
    public static void playSound(MusicTracks musicTracks, boolean sleep) {

        try {
            File in = new File(musicTracks.getName());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            if(sleep) {
                Thread.sleep((clip.getMicrosecondLength()/1000));
            }

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void loopGameSong(MusicTracks musicTracks){
        if(gameClip!=null) {
            gameClip.stop();
            gameClip = null;
        }
        try {
            File in = new File(musicTracks.getName());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
            gameClip = AudioSystem.getClip();
            gameClip.open(audioInputStream);
            gameClip.loop(Clip.LOOP_CONTINUOUSLY);
            gameClip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
    public static void stopGameLoopSong(){
        if(gameClip!=null) {
            gameClip.stop();
            gameClip = null;
        }
    }


}
