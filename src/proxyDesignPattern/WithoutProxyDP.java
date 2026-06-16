package proxyDesignPattern;

class VideoService{
    public void playVideo(String userType, String videoName){
        if(userType.equals("premium")){
            System.out.println("Streaming premium video : " + videoName);
        } else if (userType.equals("free")) {
            System.out.println("Streaming free video : " + videoName);
        } else {
            System.out.println("Access denied : Invalid user type!");
        }
    }
}

public class WithoutProxyDP {
    public static void main(String[] args) {
        VideoService videoService = new VideoService();
        videoService.playVideo("free", "Free Video 1");
        videoService.playVideo("premium", "Premium Video 1");
        videoService.playVideo("guest", "Video 1");
    }
}
