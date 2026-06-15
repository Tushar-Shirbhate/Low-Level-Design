package facadeDesignPattern;

import java.util.Scanner;

public class WithoutFacadeDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an action: playMusic, playVideo, viewImage");
        String action = sc.nextLine();

        if(action.equalsIgnoreCase("playMusic")){
            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.initializeAudioDrivers();
            musicPlayer.decodeAudio();
            musicPlayer.startPlayback();
        } else if (action.equalsIgnoreCase("playVideo")) {
            VideoPlayer videoPlayer = new VideoPlayer();
            videoPlayer.setupRenderingEngine();
            videoPlayer.loadVideoFile();
            videoPlayer.playVideo();
        } else if (action.equalsIgnoreCase("viewImage")) {
            ImageViewer imageViewer = new ImageViewer();
            imageViewer.loadImageFile();
            imageViewer.applyScaling();
            imageViewer.displayImage();
        }
        else {
            System.out.println("Invalid action!");
        }
        sc.close();
    }
}
