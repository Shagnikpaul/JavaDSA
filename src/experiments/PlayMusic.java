package experiments;

import jaco.mp3.player.MP3Player;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayMusic {
    public static void main(String[] args) throws MalformedURLException {
        new MP3Player(new File("D:\\Code Projects\\Java Projects\\LearningJava\\LearningJava\\song.mp3")).play();


    }
}
