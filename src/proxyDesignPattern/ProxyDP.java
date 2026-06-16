package proxyDesignPattern;

import java.util.HashMap;
import java.util.Map;

interface VideoInterfaceService{
    void playVideo(String userType, String videoName);
}

class RealVideoService implements VideoInterfaceService{
    @Override
    public void playVideo(String userType, String videoName) {
        System.out.println("Streaming video : " + videoName);
    }
}

class ProxyVideoService implements VideoInterfaceService{
    private RealVideoService realVideoService;
    private Map<String, String> cachedVideos = new HashMap<>();
    private Map<String, Integer> requestCounts = new HashMap<>();

    public ProxyVideoService(RealVideoService realVideoService){
        this.realVideoService = realVideoService;
    }

    @Override
    public void playVideo(String userType, String videoName) {
        // check user permission
        if(!userType.equals("premium") && videoName.startsWith("premium")){
            System.out.println("Access denied : premium video requires premium account");
            return;
        }

        //Limit requests
        requestCounts.put(userType,requestCounts.getOrDefault(userType,0) + 1);
        if (requestCounts.get(userType) > 5){
            System.out.println("Access denied : too many requests.");
            return;
        }

        // caching logic
        if (cachedVideos.containsKey(videoName)){
            System.out.println("Streaming cached video : " + videoName);
        } else {
            realVideoService.playVideo(userType, videoName);
            cachedVideos.put(videoName,videoName);
        }
    }
}

public class ProxyDP {
    public static void main(String[] args) {
        RealVideoService realVideoService = new RealVideoService();
        ProxyVideoService proxyVideoService = new ProxyVideoService(realVideoService);
        proxyVideoService.playVideo("free", "Free Video 1");
        // Premium user trying to watch a video
        proxyVideoService.playVideo("premium", "Premium Video 1");
        // Unauthorized user
        proxyVideoService.playVideo("guest", "Video 1");
        // Too many requests
        for (int i = 0; i < 6; i++) {
            proxyVideoService.playVideo("free", "Free Video 2");
        }

    }
}
