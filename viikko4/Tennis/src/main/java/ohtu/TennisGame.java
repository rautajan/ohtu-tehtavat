package ohtu;

public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (player1Points == player2Points) {
            return evenScore(score);
        } else if (player1Points >= 4 || player2Points >= 4) {
            if (player1Points > player2Points) {
                return AtLeast4Points(score, player1Name, player1Points - player2Points);
            } else {
                return AtLeast4Points(score, player2Name, player2Points - player1Points);
            }
        }
        return pointsWithLetters(score, player1Points) + "-" + pointsWithLetters(score, player2Points);

    }

    public String evenScore(String score) {
        switch (player1Points) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public String AtLeast4Points(String score, String leader, int pointsLead) {
        switch (pointsLead) {
            case 1:
                score = "Advantage " + leader;
                break;
            default:
                score = "Win for " + leader;

        }
        return score;

    }

    public String pointsWithLetters(String score, int points) {
        switch (points) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }
}
