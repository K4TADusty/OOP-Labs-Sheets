public class Main {
    public static void main(String[] args) {
        FootballPlayer p1 = new FootballPlayer();
        p1.setName("Harry");
        p1.setTeam("Gryffindor");
        p1.setPlayerNumber(1);
        p1.setPosition("keeper");

        FootballPlayer p2 = new FootballPlayer();
        p2.setName("Jame");
        p2.setTeam("Gryffindor");
        p2.setPlayerNumber(1);
        p2.setPosition("keeper");

        System.out.println("We are same position : " + p1.isSamePosition(p2));
        System.out.println("We are same team : " + p1.isSameTeam(p2));
    }
}

class FootballPlayer {
    private String team;
    private String position;

    public void setName(String name) {
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPlayerNumber(int playerNumber) {
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isSamePosition(FootballPlayer other) {
        return this.position.equals(other.position);
    }

    public boolean isSameTeam(FootballPlayer other) {
        return this.team.equals(other.team);
    }
}
