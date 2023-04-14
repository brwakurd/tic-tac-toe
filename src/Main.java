import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        game_start();
    }

    static void game() {
        int [][] data = {

                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        boolean play = true;
        int [][] player1 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int [][] player2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        display_game(data);
        int win = 0;
        int winner = 0;
        while (play == true) {
            System.out.println("Player 1, choose tile:  ");
            int [] temp = {10, 10};

            int num = player_choice();
            temp = row_logic(num);
            if (data[temp[0]][temp[1]] == 11 || data[temp[0]][temp[1]] == 10) {
                while (true) {
                    System.out.println("That place is taken already, try again.");
                    num = player_choice();
                    temp = row_logic(num);
                    if (!(data[temp[0]][temp[1]] == 11 || data[temp[0]][temp[1]] == 10)) {
                        break;
                    }
                }
            }

            data[temp[0]][temp[1]] = 11;
            player1[temp[0]][temp[1]] = 1;

            win = game_logic(player1);

            if (draw_logic(data)) {
                winner = 3;
                break;
            }
            if (win == 1) {
                play = false;
                winner = 1;
                break;
            }

            display_game(data);

            System.out.println("Player 2, choose tile:  ");
            int num2 = player_choice();
            temp = row_logic(num2);
            if (data[temp[0]][temp[1]] == 11 || data[temp[0]][temp[1]] == 10) {
                while (true) {
                    num2 = player_choice();
                    temp = row_logic(num2);
                    if (data[temp[0]][temp[1]] != 11 || data[temp[0]][temp[1]] != 10) {
                        break;
                    }
                }
            }
            data[temp[0]][temp[1]] = 10;
            player2[temp[0]][temp[1]] = 1;

            win = game_logic(player2);

            if (draw_logic(data)) {
                winner = 3;
                break;
            }
            if (win == 1) {
                play = false;
                winner = 2;
                break;
            }

            display_game(data);

        }
        display_game(data);
        if (winner == 3) {
            System.out.println("Draw! No one won.");
        } else {
            System.out.println("Player " + winner + " won!");
        }

        game_start();
    }

    static boolean draw_logic(int[][] data) {
        int counter = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (data[i][j] == 11 || data[i][j] == 10) {
                    counter += 1;
                }
            }
        }

        if (counter >= 9) {
            return true;
        } else {
            return false;
        }
    }
    static int player_choice() {
        Scanner int_input = new Scanner(System.in);
        int num = int_input.nextInt();
        return num;
    }
    static int game_logic(int[][] player) {
        for (int i = 0; i <= 2; i++) {
            if (player[i][0] == 1 && player[i][1] == 1 && player[i][2] == 1) {
                System.out.println("ues1");
                return 1;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (player[0][i] == 1 && player[1][i] == 1 && player[2][i] == 1) {
                System.out.println("ues2");
                return 1;
            }
        }
        if (player[0][0] == 1 && player[1][1] == 1 && player[2][2] == 1) {
            System.out.println("ues3");
            return 1;
        } else if (player[0][2] == 1 && player[1][1] == 1 && player[2][0] == 1) {
            System.out.println("ues4");
            return 1;
        } else {
            return 0;
        }

    }

    static int[] row_logic(int num) {
        int [] return_temp = {10, 10};
        if (num == 1 || num == 2 || num == 3){
            return_temp[0] = 0;
            return_temp[1] = num- 1;
            return return_temp;
        } else if (num == 4 || num == 5 || num == 6){
            return_temp[0] = 1;
            return_temp[1] = num - 4;
            return return_temp;
        } else if (num == 7 || num == 8 || num == 9){
            return_temp[0] = 2;
            return_temp[1] = num - 7;
            return return_temp;
        } else {
            return return_temp;
        }
    }

    static void game_start() {
        System.out.print("Press 1 if you want to start the game:  ");
        Scanner sc = new Scanner(System.in);
        int decide = sc.nextInt();
        if (decide == 1) {
            System.out.println("Game starting...");
            game();
        }
    }

    public static void display_game(int [][] data) {
        int vertical_size = 5;
        int space = 12;

        System.out.println("___________________________________________");
        display_tiles(space, vertical_size, " ", data[0]);
        display_tiles(space, vertical_size, " ", data[1]);
        display_tiles(space, vertical_size, " ", data[2]);
    }

    static void display_tiles(int space, int size, String filler, int [] data) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print("|");
                if (i == size) {
                    filler = "_";
                }
                if (i == (size/2)) {
                    for (int d = 0; d <= space; d++) {
                        if (d == (space/2)) {
                            switch(data[j]) {
                                case 11:
                                    System.out.print("x");
                                    break;
                                case 10:
                                    System.out.print("o");
                                    break;
                                default:
                                    System.out.print(data[j]);
                            }
                        }
                        else {
                            System.out.print(filler);
                        }
                    }
                } else {
                    for (int d = 0; d <= space; d++) {
                        System.out.print(filler);
                    }
                }

            }
            System.out.println("|");
        }
    }
}