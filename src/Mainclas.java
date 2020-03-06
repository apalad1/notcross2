import java.util.*;

public class Mainclas {

    public static void main(String[]args){
        String playerchoice = "";
        String compchoice = "";
        boolean playerdidntchooseweird = false;

        //couldnt return a modified string, they kept coming back from my other method as "" so theyre back on main
        //rather than as a recursive method elsewhere
        while(playerdidntchooseweird == false){
            System.out.println("x or o, just lowercase");
            Scanner scanthing = new Scanner(System.in);
            String userinput = scanthing.nextLine();

            playerchoice = userinput;

            if((playerchoice.equals("x") || playerchoice.equals("o")) == true){
                System.out.println("player chose " + playerchoice);
                playerdidntchooseweird = true;
            }
        }

        if(playerchoice.equals("x") || playerchoice.equals("o")){ //picks the comp after the players choice
            if(playerchoice.equals("x")){
                compchoice = "o";
                System.out.println("comp is " + compchoice);
            }
            if(playerchoice.equals("o")){
                compchoice = "x";
                System.out.println("comp is " + compchoice);
            }
        }

        //************************************************************************

        //game(playerchoice, compchoice)
            //determine turn
            //link player input to board changes ex: if(playerinp = 1) -> board[0] = x

        playgame(playerchoice, compchoice);

    }

    public static void playgame(String playerchoice, String compchoice) {
        int rand = (int)(Math.random()*2)+1;  //comes up with 1 or 2 FOR TEST CASES JUST SET IT TO ONLY GO TO 1 ALL THE TIME

        if(rand== 1){
            System.out.println("You go first ");
            Goplayerfirst(playerchoice, compchoice);
        }else{
            System.out.println("Comp go first, no code here yet it just ends");
        }
    }

    public static void Goplayerfirst(String playerchoice, String compchoice){  //if the player is chosen to be rand1; player goes first

        String[] board = new String[15];
        board = new String[]{"1", "|", "2","|","3",
                "4", "|", "5", "|", "6",
                "7", "|", "8", "|", "9",
        };                                       //board setup*******************
        boolean isgamewon = false;

        int didyouwin = 0;
        //playercombo might have to take in the entire board range

        printarray(board);

        int[] arrayofplayerchoices = new int[15]; //to check for the ones theyve picked

        //while(isgamewon == false){
            for(int turns = 1; turns <= 9; turns++){     //intend to just toggle it between 1 and 2
                //odd number players turns
                if(turns%2 != 0){
                    System.out.println("your turn");
                    Scanner scanUsergofirst = new Scanner(System.in);
                    int userinput = scanUsergofirst.nextInt();

                    for(int i=0; i<arrayofplayerchoices.length;i++){       //checks if the players pick is already existing
                        if(userinput == arrayofplayerchoices[i]){
                            System.out.println("you picked " + arrayofplayerchoices[i] + " already.");
                        }
                    }


                    switch(userinput){  //depending on the userinput it should fill the corresponding slot on the board
                        case 1:
                            //loop through arrayofplayerchoices and if its a dupe have them choose again
                            board[0] = playerchoice;
                            break;
                        case 2:
                            board[2] = playerchoice;
                            break;
                        case 3:
                            board[4] = playerchoice;
                            break;
                        case 4:
                            board[5] = playerchoice;
                            break;
                        case 5:
                            board[7] = playerchoice;
                            break;
                        case 6:
                            board[9] = playerchoice;
                            break;
                        case 7:
                            board[10] = playerchoice;
                            break;
                        case 8:
                            board[12] = playerchoice;
                            break;
                        case 9:
                            board[14] = playerchoice;
                            break;
                    }
                    //runs through board, logs in the ones that are the same as player choice
                    for(int i = 0; i < board.length; i++){
                        if(board[i].equals(playerchoice)) {
                            arrayofplayerchoices[i] = userinput;
                        }
                    }

                    printarray(board);
                    //put the board / players answers into an array

                    checkwin(board, playerchoice, didyouwin);

                }
                //even number comp turns
                if(turns%2 == 0){ //even number the comps turns
                    System.out.println("comp turn, no code yet it just ends");

                    //look through the array if its not 'playerchoice' or '|' then fill it only need 1 iteration

                    //checkwin method
                }

                //print board
            }
        //}

    }


    public static int printarray(String [] board){
        System.out.println(board[0] + board[1] + board[2] + board[3] + board[4]);
        System.out.println(board[5] + board[6] + board[7] + board[8] + board[9]);
        System.out.println(board[10] + board[11] + board[12] + board[13] + board[14]);

        return 0;
    }

    public static int checkwin(String[] board, String playerchoice, int didyouwin){
        if((board[0] == playerchoice) && (board[2] == playerchoice) && board[4] == playerchoice){
            System.out.println("toprow win");
        }

        return 0;
    }


}
