package game;

import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingData {
    private String fileName;
    private Game game;


    /**
     * Initialise a new
     * @param fileName the name of the high-score file
     */
    public ReadingData(String fileName,Game game) {
        this.fileName = fileName;
        this.game=game;

    }

    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public GameLevel loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            int levelNumber = Integer.parseInt(line);
            System.out.println("levelNumber  "+levelNumber);

            GameLevel level = null;
            if (levelNumber == 1){
                level=new Level1();
            }else if (levelNumber == 2){
                level=new Level2();
            }else if (levelNumber == 3){
                level=new Level3();
            }

            line = reader.readLine();
            String[] tokens = line.split(",");
            int ring = Integer.parseInt(tokens[0]);
            int health = Integer.parseInt(tokens[1]);

            System.out.println("Ring   "+ring+"    health      "+health);
            while ((line = reader.readLine()) !=null){
                tokens = line.split(",");
                float posx= Float.parseFloat(tokens[1]);
                float posy= Float.parseFloat(tokens[2]);
                Vec2 pos = new Vec2(posx,posy);
                String className = tokens[0];


                System.out.println("className  "+className);
                System.out.println("posx  "+posx);
                System.out.println("posy  "+posy);

                if (className.equals("Sonic")){
                    Sonic body = new Sonic(level);
                    level.startPosition().set(pos);
                }

                if (className.equals("Ring")){
                    Body body = new Ring(level);
                    body.setPosition(pos);
                }

                if (className.equals("Health")){
                    Body body = new Health(level);
                    body.setPosition(pos);
                }
            }
            return level;

        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

}
