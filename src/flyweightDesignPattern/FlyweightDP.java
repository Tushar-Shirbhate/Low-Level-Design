package flyweightDesignPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParticleType{
    private final String color;
    private final String sprite;

    public ParticleType(String color, String sprite){
        this.color = color;
        this.sprite = sprite;
    }

    public void render(float x, float y, float velocity){
        System.out.println("Particle at position (" + x + "," + y + ") with color " + color + " and sprite " + sprite + ". ");
    }
}

class ParticleTypeFactory{
    private Map<String, ParticleType> particleTypes = new HashMap<>();
    public ParticleType getParticleType (String color, String sprite){
        String key = color + "_" + sprite;
        return particleTypes.computeIfAbsent(key, k-> new ParticleType(color, sprite));
    }
}

class Particle {
    private ParticleType particleType;
    private float x;
    private float y;
    private float velocity;

    public Particle(ParticleType particleType, float x, float y, float velocity){
        this.particleType = particleType;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update(){
        y += velocity;
        particleType.render(x,y,velocity);
    }
}

public class FlyweightDP {
    public static void main(String[] args) {
        ParticleTypeFactory particleTypeFactory = new ParticleTypeFactory();
        List<Particle> particles = new ArrayList<>();

        ParticleType explosionType = particleTypeFactory.getParticleType("red", "explosion.png");
        for (int i=0; i<100; i++){
            particles.add(new Particle(explosionType, (float) Math.random()*100, (float) Math.random()*100, 1.0f));
        }

        for (Particle particle : particles){
            particle.update();
        }
    }
}
