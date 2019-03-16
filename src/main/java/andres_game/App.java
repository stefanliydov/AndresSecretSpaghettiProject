package andres_game;

import java.io.Console;
import java.io.IOException;


public class App {

	public static void main(String[] args) throws InterruptedException, IOException {

		Console console = System.console();
	

		if (console == null) {
			String filename = App.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);

			Runtime.getRuntime()
					.exec(new String[] { "cmd", "/c", "start", "cmd", "/k", "java -jar \"" + filename + "\"" });
				System.exit(0);
		}

		
		new Story().engageStory();
	}

}
