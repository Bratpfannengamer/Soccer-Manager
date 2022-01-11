package de.szut.soccer;

public class Game {
    private Team homeTeam;
    private Team guestTeam;
    private int goalsHomeTeam;
    private int goalsGuestTeam;

    public Game(Team homeTeam,Team guestTeam){
        this.goalsHomeTeam=0;
        this.goalsGuestTeam=0;
        this.homeTeam=homeTeam;
        this.guestTeam=guestTeam;
    }

    public void increaseScore(Team team){
        if(team == homeTeam){
            this.goalsHomeTeam++;
        }else {
            this.goalsGuestTeam++;
        }

    }


    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public Team getGuestTeam() {
        return this.guestTeam;
    }

    public String getScore(){
        return this.goalsHomeTeam+"-"+this.goalsGuestTeam;
    }

     @Override
    public String toString(){
         return this.homeTeam.getName()+" "+goalsHomeTeam+"-"+goalsGuestTeam+" "+this.guestTeam.getName();
     }
}
