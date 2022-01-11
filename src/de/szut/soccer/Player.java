package de.szut.soccer;

import java.util.Random;

public class Player extends Person{
    protected String name;
    protected int age;
    protected int force;
    protected int powerAtGoalKick;
    protected int motivation;
    protected int goals;

    public Player(String name,int age,int force,int powerAtGoalKick,int motivation, int goals){
        super(name,age);
        this.force=force;
        this.powerAtGoalKick=powerAtGoalKick;
        this.motivation=motivation;
        this.goals=goals;
    }

    public int shootAtGoal(){
        Random random = new Random();
        return validate(powerAtGoalKick+ random.nextInt(4)-2);
    }

    public void addGoal(){
        goals++;
    }

    public int getMotivation(){
        return this.motivation;
    }

    public int getForce(){
        return this.force;
    }

    public int getGoals() {
        return this.goals;
    }

    @Override
    public String toString() {
        return "\nCoach\n" +
                "name: " + this.name +
                "\nage: " + this.age +
                "\nforce: " + this.force +
                "\npowerAtGoalKick " + this.powerAtGoalKick +
                "\nmotivation: " + this.motivation +
                "\ngoals: " + this.goals;
    }

    protected int validate(int number){
        if (number<1){
            return 1;
        }
        if (number>10){
            return 10;
        }
        return number;
    }

}
