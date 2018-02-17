import java.util.Random;

public class Table {

    private Symbol[][] board;

    public static final String RED = "\033[0;91m";
    public static final String BLUE = "\033[0;94m";
    public static final String PURPLE = "\033[0;95m";
    public static final String RESET = "\033[0m";

    static public enum Symbol{SX, SO, S_}

    public Table(){
        this.board = new Symbol[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = Symbol.S_;
            }
        }
    }

     void printBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                switch (board[i][j]) {
                    case SX:
                        System.out.print(RED + 'X' + RESET);
                        break;
                    case SO:
                        System.out.print(BLUE + 'O' + RESET);
                        break;
                    default:
                        System.out.print(PURPLE + '_' + RESET);
                        break;
                }
            }
            System.out.println();
        }
    }

     boolean isXFirst() {
        Random r = new Random();
        return r.nextBoolean();
    }

     Symbol checkForWin()
    {
        if((board[0][0]!=Symbol.S_ )&&(board[0][1]==board[0][2]&&(board[0][2]==board[0][0])))
            return board[0][2];
        else if ((board[1][0]!=Symbol.S_)&&(board[1][1]==board[1][2])&&(board[1][2]==board[1][0]))
            return board[1][2];
        else if ((board[2][0]!=Symbol.S_)&&(board[2][1]==board[2][2])&&(board[2][2]==board[2][0]))
            return board[2][1];
        else if((board[0][0]!=Symbol.S_)&&(board[1][0]==board[2][0])&&(board[2][0]==board[0][0]))
            return board[1][0];
        else if((board[0][1]!=Symbol.S_)&&(board[1][1]==board[2][1])&&(board[2][1]==board[0][1]))
            return board[1][1];
        else if((board[0][2]!=Symbol.S_)&&(board[1][2]==board[2][2])&&(board[2][2]==board[0][2]))
            return board[1][2];
        else if((board[1][1]!=Symbol.S_)&&(board[0][0]==board[2][2])&&(board[2][2]==board[1][1]))
            return board[2][2];
        else if((board[1][1]!=Symbol.S_)&&(board[0][2]==board[2][0])&&(board[2][0]==board[1][1]))
            return board[2][0];
        else
            return Symbol.S_;
    }

    void completeaza(int a, int b, Symbol role){
        if (board[a][b] == Table.Symbol.S_) {

            board[a][b] = role;

        } else {
            System.out.println('O');
        }
    }

    int locuriLibere()
    {
        int k=0;
        for(int i=0;i<3;++i)
            for(int j=0;j<3;++j)
            {
                if(board[i][j]==Symbol.S_)
                {
                        k++;
                }
            }
            return k;
    }




}
