package trainseatfindproblem2;

import java.util.Scanner;

/**
 *
 * @author snehal
 */
public class TrainSeatFindProblem2 {

    public static void main(String[] args) {

        int SeatValueArray[];
        SeatValueArray = TakeAllInputFromUser();
        FindSeatTypeAndSeatNo(SeatValueArray);

    }

    static int[] TakeAllInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        //save input for user that which time want to check seat no 
        System.out.println("enter the no which time you want check seat:");
        int CountOfCheck = scanner.nextInt();

        //Array for save user's seat
        int SeatValueArray[];
        SeatValueArray = new int[0];
        //Label for Process of find seat type and facing seat no
        FindSeatType:
        if (CountOfCheck == 0 || CountOfCheck > 105) {
            System.out.println("Please,enter value between 1 to 105...");
        } else {

            //save all values in array
            SeatValueArray = new int[CountOfCheck];

            for (int i = 0; i < CountOfCheck; i++) {
                System.out.println("Enter seat no:");
                int SeatNo = scanner.nextInt();
                if (SeatNo == 0 || SeatNo > 108) {
                    System.out.println("Please, enter seat no between 1 to 108.. otherwise your value can't be store..");
                    //break FindSeatType;
                } else {
                    SeatValueArray[i] = SeatNo;
                }
            }
        }
        return SeatValueArray;

    }

    static void FindSeatTypeAndSeatNo(int SeatValueArray[]) {
        //check seat type and facing seat no
        //we will divide seatno by 12 and then compare for check seat type sequance
        for (int j = 0; j < SeatValueArray.length; j++) {
            int num = SeatValueArray[j];
            if (num != 0 && num <= 108) {
                int val = num % 12;
                switch (val) {
                    case 1:
                        System.out.print(num + 11 + " WS");
                        break;
                    case 2:
                        System.out.print(num + 9 + " MS");
                        break;
                    case 3:
                        System.out.print(num + 7 + " AS");
                        break;
                    case 4:
                        System.out.print(num + 5 + " AS");
                        break;
                    case 5:
                        System.out.print(num + 3 + " MS");
                        break;
                    case 6:
                        System.out.print(num + 1 + " WS");
                        break;
                    case 7:
                        System.out.print(num - 1 + " WS");
                        break;
                    case 8:
                        System.out.print(num - 3 + " MS");
                        break;
                    case 9:
                        System.out.print(num - 5 + " AS");
                        break;
                    case 10:
                        System.out.print(num - 7 + " AS");
                        break;
                    case 11:
                        System.out.print(num - 9 + " MS");
                        break;
                    case 0:
                        System.out.print(num - 11 + " WS");
                        break;
                    default:
                        break;
                }
                System.out.print("\n");
            }

        }

    }
}
