public class Elf extends Character {
    public Elf(){
        super(10, 10);
    }

    @Override
    public void kick(Character c) {
        if (c instanceof Elf){
            System.out.println("Brother, we are the same blood, I won't hurt you!");
            System.out.println("Let's go and kick some ass together!");
            this.setHealth(0);

            return;
        }

        if (c.getPower() < this.getPower()){
            c.setHealth(0);
            System.out.println("Elves kills weaker enemies instantly. They can smell their weakness...");
            System.out.println("Elf win!");
        }
        else{
            c.setPower(c.getPower() - 1);
            System.out.printf("Elf increases power of %s by 1\n", c.toString());
        }
    }

    @Override
    public String toString(){
        return "Elf";
    }
}
