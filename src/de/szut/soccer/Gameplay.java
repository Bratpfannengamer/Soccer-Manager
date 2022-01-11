package de.szut.soccer;

import java.util.Random;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME=5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;
    Game game;
    public Gameplay(Game game){
        this.game=game;
    }

    public void play(){
        Random random = new Random();
        int overtime = random.nextInt(MAX_ADDITIONAL_TIME+1);
        System.out.println("The game starts.\n"+game.toString()+"\n");
        for (int i = 1+random.nextInt(MAX_DURATION_UNTIL_NEXT_ACTION); i < PLAYING_TIME/2+overtime; i+=(1+random.nextInt(MAX_DURATION_UNTIL_NEXT_ACTION))) {
            delay();
            if(calculateForceOfTheTeam(game.getHomeTeam())>= calculateForceOfTheTeam(game.getGuestTeam())){
                doGameAction(game.getHomeTeam().getRandomPlayer(),game.getGuestTeam().getGoalkeeper(),i, game.getHomeTeam());
            }else{
                doGameAction(game.getGuestTeam().getRandomPlayer(),game.getHomeTeam().getGoalkeeper(),i, game.getGuestTeam());
            }

        }
        delay();
        System.out.println("Break"+"\n");
        delay();
        System.out.println("2nd half\n"+game.toString()+"\n");
        overtime = random.nextInt(MAX_ADDITIONAL_TIME+1);
        for (int i =46+random.nextInt(MAX_DURATION_UNTIL_NEXT_ACTION); i < PLAYING_TIME+overtime; i+=(1+random.nextInt(MAX_DURATION_UNTIL_NEXT_ACTION))) {
            delay();
            if(calculateForceOfTheTeam(game.getHomeTeam())>= calculateForceOfTheTeam(game.getGuestTeam())){
                doGameAction(game.getHomeTeam().getRandomPlayer(),game.getGuestTeam().getGoalkeeper(),i+PLAYING_TIME/2, game.getHomeTeam());
            }else{
                doGameAction(game.getGuestTeam().getRandomPlayer(),game.getHomeTeam().getGoalkeeper(),i, game.getGuestTeam());
            }

        }
        delay();
        System.out.println("The game ends.\n"+ game.toString()+"\n");
    }

    private void doGameAction(Player player, Goalkeeper goalkeeper, int minute, Team team){
        System.out.println(minute+". Minute:");
        System.out.println("Chance für "+team.getName()+" ...");
        System.out.println(player.getName()+" zieht ab");
        if(goalkeeper.ballHold(player.powerAtGoalKick)){
            System.out.println(goalkeeper.getName()+" pariert glanzvoll.\n");
        }else {player.addGoal();
            game.increaseScore(team);
            System.out.println("TOR!!!  "+game.getScore()+"  "+player.getName()+"("+player.getGoals()+")\n");

        }
    }
    private void delay(){
        for(long i=0; i<214740000;i++){
            for(long j =0; j<10; j++){
            }
        }
    }
    private int calculateForceOfTheTeam(Team team){
        Random random = new Random();
        int randint= random.nextInt(7)-3;
        return team.getTotalMotivation()+ team.getTotalMotivation()+team.getCoach().getExperience()+randint;
    }
}
