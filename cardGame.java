import java.util.*;
import java.io.*;
public class cardGame
{
    public static void main(String args[]) throws Exception
    {
        //Decalre scanner
        Scanner scan = new Scanner (System.in);
       
        //Asks user for number of players
        System.out.println("Enter the number of players: ");
        //Sets input to variable 'players'
        int players = scan.nextInt();
       
        //Asks user for location of file
        System.out.println("Enter location of pack to load: ");
        //Sets input to variable 'pack'
        String pack = scan.next();
       
        String randomList[] = new String[8 * players];
        int cardsInPack[] = new int[8 * players];
       
       
        FileWriter writer = new FileWriter(pack);
       
        for(int x = 0; x < 8 * players; x++)
        {
            randomList[x] = Integer.toString((int)(Math.random() * 13) +1);
            writer.write(randomList[x] + "\n");
        }
        writer.close();
       
        //test if pack is valid
        File file = new File(pack);
        Scanner reader = new Scanner(file);
       
        boolean isValid = true;
        int packSize = 0;
        String element = "";
        while(reader.hasNextLine())
        {
            element = reader.nextLine();
            System.out.println(element);
            if(Integer.parseInt(element) < 0 || Integer.parseInt(element) > 13 )
            {
                isValid = false;
            }
            cardsInPack[packSize] = Integer.parseInt(element);
            packSize++;
        }
       
        if (packSize != 8 * players)
        {
            isValid = false;
        }
        System.out.println(isValid);
       
        Player[] gamer = new Player[players -1];
       
        for(int x = 0; x < players -1; x++)
        {
            gamer[x] = new Player();
            gamer[x].addCard(cardsInPack[x]);
        }
       
    }
}