import java.util.Random;

public class Chivalry extends Character {
    private static Random r = new Random();
    protected int CHIVALRY_CONST;

    public Chivalry(int CHIVALRY_CONST) {
        super(r.nextInt(11) + CHIVALRY_CONST, r.nextInt(11) + CHIVALRY_CONST);
        this.CHIVALRY_CONST = CHIVALRY_CONST;
    }

    @Override
    public void kick(Character c)
    {
        int damage = r.nextInt(this.getPower() + CHIVALRY_CONST);
        int remainHealth = c.getHealth() - damage;
        c.setHealth(remainHealth);
        System.out.printf("%s kick %s with damage %d(%d hp left)\n", this.toString(), c.toString(), damage, remainHealth);
        if (remainHealth < 1)
        {
            System.out.printf("%s win!\n", this.toString());
        }
    }
}
