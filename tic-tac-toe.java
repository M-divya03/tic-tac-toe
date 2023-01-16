package tictactoe;
import java.util.*;
public class stage5 {
    public static void main(String[] args){
        //int xs=0;
        char[][] battleground={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
       displayBattleGround(battleground);
        userinput(battleground);
        }
    public static void displayBattleGround(char[][] battleground) {

        System.out.println("---------");

        for (char[] row : battleground) {
            System.out.print("| ");

            for (char cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println("|");
        }

        System.out.println("---------");
    }

    //}
    public static void userinput(char[][] battleground){
        Scanner scanner=new Scanner(System.in);
       // char userChoice2='X';
        boolean state;
        int userCoordinate1 = 0;
        int userCoordinate2 = 0;
        int count=0;
        while(count<9) {
            do {
                state = true;
                System.out.println("Enter the coordinates:");
                //xs++;
                try {
                    userCoordinate1 = scanner.nextInt();
                    userCoordinate2 = scanner.nextInt();

                    if (userCoordinate1 > 3 || userCoordinate2 > 3 || userCoordinate1 < 1 || userCoordinate2 < 1) {
                        state = false;
                        System.out.print("Coordinates should be from 1 to 3!");
                    } else if (battleground[userCoordinate1 - 1][userCoordinate2 - 1] != ' ') {
                        state = false;
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } catch (NumberFormatException e) {
                    //catch(InputMismatchException e){
                    state = false;
                    System.out.println("You should enter numbers!");

                }
                System.out.println();
            } while (!state);
            if(count%2==0) {
                battleground[userCoordinate1 - 1][userCoordinate2 - 1] ='X';
                count++;
            }
            else
            {
                battleground[userCoordinate1 - 1][userCoordinate2 - 1] ='O';
                count++;
            }
            displayBattleGround(battleground);
            winordraw(battleground);
            //System.out.print(res);

        }
    }
    public static void winordraw(char[][] arr) {
        int count = 0,xs=0,os=0;
        int ocount = 0, xcount = 0;
        if ((arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X') ||
                (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X') ||
                (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X') ||

                (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X') ||
                (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X') ||
                (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X') ||

                (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') ||
                (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X')) {

            xcount = 1;
            count++;
            //System.out.println("X Wins");
        }  if ((arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O') ||
                (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O') ||
                (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O') ||

                (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O') ||
                (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O') ||
                (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O') ||

                (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') ||
                (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O')) {
            ocount = 1;
            // System.out.println("O Wins");
            count++;
        } //else if (count == 0) {


        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                if (arr[i][j] == 'X')
                    xs++;
                if(arr[i][j]=='O')os++;
            }
        }
        if (xcount == 0 && ocount == 1) {
            System.out.print("O Wins");
            System.exit(0);
            return;
            //return "O Wins";
        }
        else if (xcount == 1 && ocount == 0) {
            System.out.print("X Wins");
            System.exit(0);
            //return "X Wins";
            return ;
        }
        else if (xs + os == 9) {
            System.out.print("Draw");
            System.exit(0);
            //return "Draw";
            return ;
        }
        else if(Math.abs(xs - os)>=1){
            //System.out.print("IMPOSSIBLE");
           // return "Impossible";
            System.out.print(" ");


       } else
           // System.out.print("Game not finished");
            //return "Game not finished";
            System.out.print(" ");
    }

}

