package andres_game.io;

public interface IO extends AutoCloseable {

    public String read();

    public void animateLine(String str);

    public void write(String str);

    public void animateLineBySeparatingIt(String str);
}
