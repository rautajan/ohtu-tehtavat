
package ohtu;

public class Player implements Comparable<Player> {
    private String nationality;
    private String name;
    private String team;
    private String goals;
    private String assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getGoals() {
        return Integer.valueOf(goals);
    }
    
    public int getPoints() {
        return Integer.valueOf(goals) + Integer.valueOf(assists);
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String printPoints() {
        return goals + " + " + assists + " = " + getPoints();
    }

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " + " + assists + " = " + getPoints();
    }

    @Override
    public int compareTo(Player player) {
        if (this.getPoints() == player.getPoints()) {
            if (this.getGoals() < player.getGoals()) {
                return 1;
        } else {
                return -1;
            }
        }
        else if (this.getPoints() < player.getPoints()) {
            return 1;
        } else {
            return -1;
        }
    }
      
}
