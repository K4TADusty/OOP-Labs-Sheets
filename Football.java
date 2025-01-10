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
