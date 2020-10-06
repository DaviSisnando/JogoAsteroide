
package game;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Musica {
     private Media musicSound;
    private MediaPlayer musicPlayer;

    public Musica(String a) {
        musicSound = new Media(new File(new File(a).getAbsolutePath()).toURI().toString());
        musicPlayer = new MediaPlayer(musicSound);
    }

    // Starta a música //
    public void tocarMusica() {
        musicPlayer.play();
    }
    public void pararMusica() {
        musicPlayer.stop();
    }
}
