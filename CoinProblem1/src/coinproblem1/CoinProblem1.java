package coinproblem1;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class CoinProblem1 {

    public static void main(String[] args) {
        int NumberOfPlayer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players which want to part of this game-");
        NumberOfPlayer = scanner.nextInt(); // save Number input of Players

        int CoinCount;

        System.out.print("Number of Coin Count-");
        CoinCount = scanner.nextInt(); //save  number input  of Coin count

        if (NumberOfPlayer > CoinCount) {

            System.err.println("Please, Enter Valid Coins"); //if number of Player is greater than coin count- it is not valid 
            return;
        }

        int x = CoinCount % NumberOfPlayer;
        if (x != 0) {
            System.err.println("Please Enter Right Coins so divide equally"); // if  number of player are 4 and coins are 15 so that is wrong because can't divided equally
            return;
        } else {

            int ArrCoinValue[] = new int[CoinCount];
            System.out.println("Enter all the Coins Value:");// save input of coins value
            for (int i = 0; i < ArrCoinValue.length; i++) {
                System.out.println("value of coin[" + (i+1) + "]");
                ArrCoinValue[i] = scanner.nextInt();

            }

            int Winner = FindWinnerPlayer(ArrCoinValue, NumberOfPlayer); // pass total number of coins value and number of player to FindWinnerPlayer

        }

    }

    // User define function  which is return winner player
    static int FindWinnerPlayer(int ArrCoinValue[], int NumberOfPlayer) {
        int NoOfPlayerCount = 0, tempValueOfArrCoinValue = ArrCoinValue.length - 1;
        int player[] = new int[NumberOfPlayer];    // array of number of players

        //here we run loop for count coins value for particular players
        for (int i = 0; i != tempValueOfArrCoinValue + 1; i++, NoOfPlayerCount++) {
            if (NoOfPlayerCount == player.length) {
                NoOfPlayerCount= 0;
            }
            if (ArrCoinValue[i] > ArrCoinValue[tempValueOfArrCoinValue]) {
                player[NoOfPlayerCount] += ArrCoinValue[i];
            } else {
                player[NoOfPlayerCount] += ArrCoinValue[tempValueOfArrCoinValue];
                i--;
                tempValueOfArrCoinValue--;
            }
        }

        //after end of the loop we get the players with their total number of coins 
        int WinnerValueOfCoins = 0, IndexOfPlayer = 0;
        for (int i = 0; i < player.length; i++) {
            if (WinnerValueOfCoins < player[i]) {
                WinnerValueOfCoins = player[i];
                IndexOfPlayer = i;
            }
        }

        System.out.println("The Winner is " + (IndexOfPlayer + 1) + " player and Coin get " + WinnerValueOfCoins);
        return IndexOfPlayer + 1;
    }

}


