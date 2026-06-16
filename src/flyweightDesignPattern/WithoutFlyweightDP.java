package flyweightDesignPattern;

import java.util.ArrayList;
import java.util.List;

class ParticleWFDP{
    private String color;
    private String sprite;
    private float x;
    private float y;
    private float velocity;

    public ParticleWFDP(String color, String sprite, float x, float y, float velocity){
        this.color = color;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update(){
        // update particle position
         y += velocity;
        System.out.println("Particle at position (" + x + "," + y + ") with color " + color + " and sprite " + sprite + ". ");
    }
}

public class WithoutFlyweightDP {
    public static void main(String[] args) {
        List<ParticleWFDP> particles = new ArrayList<>();

        for (int i=0; i<1000; i++){
            particles.add(new ParticleWFDP("red", "explosion.png", (float) Math.random()*100, (float) Math.random()*100, 1.0f));
        }

        for (ParticleWFDP particle : particles){
            particle.update();
        }
    }
}
