package de.szut.soccer;

import java.util.Random;

public class Goalkeeper extends Player{
    int reaction;

    public Goalkeeper(String name,int age,int force,int powerAtGoalKick,int motivation, int goals,int reaction){
        super(name,age,force,powerAtGoalKick,motivation,0);
        this.reaction=reaction;
    }

    public boolean ballHold(int powerAtGoalKick){
        Random random =new Random();
        if(validate(reaction+ random.nextInt(3)-1)<powerAtGoalKick){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "\nCoach\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nforce: " + this.force +
                "\npowerAtGoalKick " + this.powerAtGoalKick +
                "\nreaction: " + this.reaction +
                "\nmotivation: " + this.motivation +
                "\ngoals: " + this.goals;
    }
}
