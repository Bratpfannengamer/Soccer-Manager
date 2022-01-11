package de.szut.soccer;

import java.util.ArrayList;
import java.util.Random;

public class Team{
    private String name;
    private Coach coach;
    private Goalkeeper goalkeeper;
    private ArrayList<Player> squad;
    public Team(String name,Coach coach,Goalkeeper goalkeeper){
        this.name=name;
        this.coach=coach;
        this.goalkeeper= goalkeeper;
        this.squad= new ArrayList<Player>();
    }
    public void addPlayer(Player player) {
        this.squad.add(player);
    }
    public int getTotalMotivation(){
        int motivation=this.goalkeeper.getMotivation();
        for (int i = 0; i < this.squad.size(); i++) {
            motivation=motivation+this.squad.get(i).getMotivation();
        }
        motivation=motivation/(this.squad.size()+1);
        return motivation;
    }
    public int getTotalForce(){
        int totalForce= this.goalkeeper.getForce();
        for(int i=0;i<9;i++){
            totalForce=totalForce+this.squad.get(i).getForce();
        }
        return totalForce/10;
    }
    public int getTotalForce(int fielded){
        if(fielded<1){
            return 0;
        }
        int totalForce= this.goalkeeper.getForce();
        for(int i=0;i<fielded;i++){
            totalForce=totalForce+this.squad.get(i).getForce();
        }
        return totalForce/fielded;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        String string = "***Team***\nCoach: "+this.coach.getName()+"\nGoalkeeper: "+this.goalkeeper.getName();
        for(int i=0;i<squad.size();i++){
            string=string+"\nPlayer: "+squad.get(i).getName();
        }
        return string;
    }

    public Coach getCoach() {
        return this.coach;
    }

    public Goalkeeper getGoalkeeper() {
        return this.goalkeeper;
    }

    public Player getRandomPlayer(){
        Random random = new Random();
        return this.squad.get(random.nextInt(10));
    }
}