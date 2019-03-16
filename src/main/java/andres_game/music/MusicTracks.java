package andres_game.music;

import java.io.File;

public enum MusicTracks {
    MATRIX_TRACK("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "matrix_music.wav"),
    STAR_WARS_SIRENS("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "star_wars_siren.wav"),
    ANDRES_AD("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "ad.wav"),
    NYAN_CAT("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "flappy_andres" + File.separator + "Nyan.wav"),
    BACKGROUND_ONE_TO_FIVE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_1to5.wav"),
    BACKGROUND_SIX_TO_EIGTH("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_6to8.wav"),
    BACKGROUND_NINE_TO_ELEVEN("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_9to11.wav"),
    BACKGROUND_TWELVE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_12.wav"),
    QUIZ_CORRECT_ONE_TO_EIGTH("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_correct_1to8.wav"),
    QUIZ_CORRECT_NINE_TO_ELEVEN("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_correct_9to11.wav"),
    QUIZ_CORRECT_TWELVE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_correct_12.wav"),
    QUIZ_LOSE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_lose.wav"),
    QUIZ_SELECT_NINE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_select_9.wav"),
    QUIZ_SELECT_TEN("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_select_10.wav"),
    QUIZ_SELECT_ELEVEN("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_select_11.wav"),
    QUIZ_SELECT_TWELVE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_select_12.wav"),
    QUIZ_BEFORE_AD("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_beforeAD.wav"),
    QUIZ_BETWEEN_BACKGROUND_CHANGE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_between_bgm.wav"),
    QUIZ_MAIN("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "quiz" + File.separator + "quiz_main.wav"),
    HANGMAN_MUSIC("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator + "hangman" + File.separator + "hangman_music.wav"),
    QUEST_COMPLETE("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator  + "quest_complete.wav"),
    END_CREDITS("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator  + "end_credits.wav"),
    END_GAME_OUTRO("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator  + "finale.wav"),
    HAPPY_BIRTHDAY("src" + File.separator + "main" + File.separator + "resources" + File.separator + "music" + File.separator  + "surprise.wav");




    String name;

    MusicTracks(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
