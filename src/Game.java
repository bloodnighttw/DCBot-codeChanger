public class Game {

    private int goal;
    private int[] playerSum;
    private Player first=new Player();


    public Game(int playerAmount){
        goal= (int) (Math.random()*100);


    }


    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getGame(int i){

        if(goal==i)
            return -1;
        else if(i<goal)
            return  goal-i;
        else
            return i-goal;

    }




}

class Player{

    private  Player next;

    private static Player end;
    private String playerName="";
    private String hosterPlayer="";
    private int playerSum;


    //private static Player end;

    Player(String hostPlayerName,int playerAmount){
        this.hosterPlayer=hostPlayerName;



    }

    Player(){

        if(end==null)
            end=this;
        else {
            end.setNext(this);
            end=this;
        }
    }

    public void setNext(Player next){
        this.next=next;
    }

    public void start(String name){

        hosterPlayer=name;

    }



}
