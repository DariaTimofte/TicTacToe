import javafx.scene.control.Tab;

import java.util.Scanner;

public class Player {

    Table board;
    Table.Symbol role;

    Player(Table t, Table.Symbol role)
    {
        this.board = t;
        this.role = role;
    }

    int readValidIndex() {
        Scanner sc = new Scanner(System.in);

        int a = -1;
        while (a < 0 || a >= 3) {
            a = sc.nextInt();
            if (a < 0 || a >= 3) {
                System.out.println("Index invalid");
            }
        }

        return a;
    }

    public void nextMove() {
        int a = readValidIndex();
        int b = readValidIndex();
        board.completeaza(a, b, role);

    }



}
