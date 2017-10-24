public class Hobbit extends Character {
    public Hobbit() {
        super(0, 3);
    }

    @Override
    public void kick(Character c){
        if (c instanceof Hobbit){
            System.out.println("Hello, my friend!");
            System.out.println("What brings you here?");
            System.out.println("Let's find a tovern with good meal and ale!");
            c.setHealth(0);

            return;
        }

        toCry();
    }

    @Override
    public String toString(){
        return "Hobbit";
    }

    private void toCry() {
        System.out.println("No-no-no don't kill me, I'm just a small hobbit...");
    }

}
