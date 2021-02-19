package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());
        String bodyText = Request.Get(url).execute().returnContent().asString();
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        ArrayList<Player> finnishPlayers = new ArrayList<>();
        
        
        
        
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finnishPlayers.add(player);
            }
            
        }
        
        System.out.println("Players from FIN " + currentTime);
        System.out.println("");
        Collections.sort(finnishPlayers);
        for (Player player : finnishPlayers) {
            System.out.printf("%-25s%-5s%-20s\n", player.getName(), player.getTeam(), player.printPoints());
        }
    }
  
}