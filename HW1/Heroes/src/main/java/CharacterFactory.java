import java.util.Random;

public class CharacterFactory {
    private static Random r = new Random();

    public static Character createCharacter(){
        int i = r.nextInt(4);

        if (i == 0){
            return new Hobbit();
        }
        else if(i == 1){
            return new Elf();
        }
        else if(i == 2){
            return new Knight();
        }
        else{
            return new King();
        }
    }
}
