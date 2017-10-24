import java.util.Scanner;

public class GameManager {
    private static String delim = "______________";

    public static void fight(Character c1, Character c2){
        System.out.printf("First character - %s(health %d, power %d)\n", c1.toString(), c1.getHealth(), c1.getPower());
        System.out.printf("Second character - %s(health %d, power %d)\n", c2.toString(), c2.getHealth(), c2.getPower());

        boolean oneMoreRound = true;
        while (oneMoreRound){
            if (c1.isAlive()) {
                System.out.println(delim);
                System.out.println("First character move");
                c1.kick(c2);
            }
            if (c2.isAlive()) {
                System.out.println(delim);
                System.out.println("Second character move");
                c2.kick(c1);
            }

            oneMoreRound = c1.isAlive() && c2.isAlive();
        }
        System.out.println(delim);
        System.out.println("And they leave happily ever after...");
        System.out.println("That's all, folks!");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resp = "y";

        while (resp.equals("y")) {
            Character c1 = CharacterFactory.createCharacter();
            Character c2 = CharacterFactory.createCharacter();
            fight(c1, c2);
            System.out.println(delim);
            System.out.println("Do you want to play again?(y/n)");
            resp = scan.nextLine();
        }
        System.exit(0);
    }
}
