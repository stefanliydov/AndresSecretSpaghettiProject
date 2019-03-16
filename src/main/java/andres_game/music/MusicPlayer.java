package andres_game.music;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.*;

public class MusicPlayer {
    private static  AudioPlayer MGP;
    private static  AudioStream BGM= null;


    public static <InputStream> void playMusic(MusicTracks musicTracks) {
        MGP = AudioPlayer.player;

        AudioData MD= null;

        ContinuousAudioDataStream loop = null;

        try {
            FileInputStream test = new FileInputStream(musicTracks.getName());
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        } catch (FileNotFoundException e) {
            System.out.print(e.toString());
        } catch (IOException error) {
            System.out.print(error.toString());
        }
        MGP.start(loop);

    }
    public static void stopMusic(){
        MGP.stop(BGM);
    }
}
