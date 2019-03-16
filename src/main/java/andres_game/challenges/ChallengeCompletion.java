package andres_game.challenges;

import andres_game.io.ConsoleIO;
import andres_game.io.IO;

public class ChallengeCompletion {

    private IO io = new ConsoleIO(70,500);

    private boolean aChallengeIsCompleted;
    private boolean bChallengeIsCompleted;
    private boolean cChallengeIsCompleted;

    public void aComplete(){
        aChallengeIsCompleted = true;
    }
    public void bComplete()
    {
        bChallengeIsCompleted = true;
    }
    public void cComplete(){
        cChallengeIsCompleted = true;
    }

    public boolean isAChallengeIsCompleted() {
        return this.aChallengeIsCompleted;
    }

    public boolean isBChallengeIsCompleted() {
        return this.bChallengeIsCompleted;
    }

    public boolean isCChallengeIsCompleted() {
        return this.cChallengeIsCompleted;
    }


    public boolean areChallengesComplete(){
        return aChallengeIsCompleted && bChallengeIsCompleted &&cChallengeIsCompleted;
    }



}
