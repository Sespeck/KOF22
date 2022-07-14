package model;
import java.util.Random;

public class Evil extends Character {

    public Evil(String name, int hp, int power){
        super(name, hp, power);
        this.alive = true;
    }

    /**
     * enum phrases
     */
    public enum Phrases{
        brain,
        howl,
        blowUp;

        Phrases phrases;

        public void wordsLike(){
            switch (phrases){
                case brain:
                    System.out.println("La dohsola fasoray!"); // Your delicious brains!
                    break;
                case howl:
                    System.out.println("Fa! Soso so doh lasomeefa sotee!"); // Howl! This is the scariest night!
                    break;
                case blowUp:
                    System.out.println("So sodoh mee rayfa sotee ray!"); // I like to blow things up!
                    break;
            }
        }
    }

    /**
     * Bad guy is speaking before each attach
     * @return 
     */
    public Phrases speak(){
        return Phrases.values()[new Random().nextInt(Phrases.values().length)];
    }
    
    @Override
    public int attack(){
//        this.speak();
        Random r = new Random();
        return r.nextInt(this.power)+1;
    }

}
