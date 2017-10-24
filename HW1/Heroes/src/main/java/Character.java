import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter@Setter private int power;
    @Getter@Setter private int health;

    public Character(int pow, int hp){
        power = pow;
        health = hp;
    }

    public abstract void kick(Character c);

    public boolean isAlive(){
        return health > 0;
    }
}
