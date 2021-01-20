
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void searchToimiiOikein() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri                EDM 37 + 53 = 90", stats.search("Kurri").toString());
        
    }
    
    @Test 
    public void searchToimiiOikeinJosListaTyhja() {
        assertEquals(null, stats.search("Selänne"));
    }
    
    @Test
    public void teamPalauttaaOikeatPelaajat() {
        assertEquals("[Lemieux              PIT 45 + 54 = 99]", stats.team("PIT").toString());
    }
    
    @Test
    public void topScorersPalauttaaOikein() {
        assertEquals("[Gretzky              EDM 35 + 89 = 124]", stats.topScorers(0).toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
