package andres_game.music;

import java.io.File;

public enum MusicTracks {
    MATRIX_TRACK("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music"+File.separator+"music.wav"),
    STAR_WARS_SIRENS("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music"+File.separator+"star_wars_siren.wav"),
    EXPLOSION_SOUND("");

    String name;

    MusicTracks(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
