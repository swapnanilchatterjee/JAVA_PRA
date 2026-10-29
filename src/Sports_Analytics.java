import  java.util.*;
public class Sports_Analytics {
   public static player findWithLowestRuns(player[] arr,String playerType){
       player minPlayer=null;
       for(player p:arr){
           if(p.getPlayerType().equalsIgnoreCase(playerType)){
               if(minPlayer==null || p.getRuns()<minPlayer.getRuns()){
                   minPlayer=p;
               }
           }
       }
       return  minPlayer;
   }
   public static int findAverageMatchType(player[] arr,String matchType){
       int totalRuns=0;
       int count=0;
       for(player p:arr){
           if(p.getMatchType().equalsIgnoreCase(matchType)){
               totalRuns+=p.getRuns();
               count++;
           }
       }
       return count>0?(totalRuns/count):0;
   }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        player[] players=new player[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int runs=sc.nextInt();
            sc.nextLine();
            String pType=sc.nextLine();
            String mType=sc.nextLine();
            players[i]=new player(id,name,runs,pType,mType);
        }
        String searchPType=sc.nextLine();
        String searchMType=sc.nextLine();

        player lowestPlayer=findWithLowestRuns(players,searchPType);
        if(lowestPlayer!=null){
            System.out.println(lowestPlayer.getPlayerId());
            System.out.println(lowestPlayer.getPlayerName());
        }else {
            System.out.println("No such player");
        }
        int avgRuns=findAverageMatchType(players,searchMType);
        if(avgRuns>0){
            System.out.println(avgRuns);
        }else {
            System.out.println("No such match type");
        }
        sc.close();
    }
}

class  player{
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public player(int playerId,String playerName,int runs,String playerType,String matchType){
        this.playerId=playerId;
        this.playerName=playerName;
        this.runs=runs;
        this.playerType=playerType;
        this.matchType=matchType;
    }
    public int getPlayerId() {return  playerId;}
    public void setPlayerId(int playerId) {this.playerId=playerId;}
    public String getPlayerName(){return  playerName;}
    public void setPlayerName(String playerName){this.playerName=playerName;}
    public int getRuns(){return  runs;}
    public void setRuns(int runs){this.runs=runs;}
    public String getPlayerType(){return playerType;}
    public void setPlayerType(String playerType){this.playerType=playerType;}
    public String getMatchType(){return matchType;}
    public void setMatchType(String matchType){this.matchType=matchType;}
}
