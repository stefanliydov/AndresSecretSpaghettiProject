package andres_game.io;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private final Scanner scanner;
    private int  letterMilliseconds;
    private int lineMilliseconds;
    public ConsoleIO(int letterMilliseconds, int lineMilliseconds) {
        scanner = new Scanner(System.in);
        this.letterMilliseconds =letterMilliseconds;
        this.lineMilliseconds = lineMilliseconds;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void animateLine(String str) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                sleep(letterMilliseconds);

            }
            sleep(lineMilliseconds);
            System.out.println();

    }
    public void animateLineBySeparatingIt(String str) {
        String[] lines = str.split(System.lineSeparator());
        for (int z = 0; z < lines.length; z++) {
            str = lines[z];
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                sleep(letterMilliseconds);

            }
            if(z ==0){
                sleep(lineMilliseconds*2);
                System.out.println();
            }else {
                sleep(lineMilliseconds);
                System.out.println();
            }
        }
    }

    @Override
    public void write(String str) {
        System.out.println(str);
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
