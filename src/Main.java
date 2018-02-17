public class Main {

    public static void main(String[] args){

        Table board = new Table();
        board.printBoard();

        Player x = new Player(board, Table.Symbol.SX);
        Player y = new Player(board, Table.Symbol.SO);

        boolean xTurn = board.isXFirst();
        System.out.println(xTurn);

        while((board.checkForWin() == Table.Symbol.S_) && (board.locuriLibere()>0))
        {
           if(xTurn)
           {
               x.nextMove();
               board.printBoard();
           }
           else
           {
               y.nextMove();
               board.printBoard();
           }

           xTurn = !xTurn;
        }

        if(board.checkForWin() == Table.Symbol.SX)
        {
            System.out.println("X este castigatorul!");
        }
        else if((board.checkForWin()!= Table.Symbol.SX) && (board.checkForWin()!= Table.Symbol.SO))
        {
            System.out.println("Remiza!");
        }
        else
        {
            System.out.println("O este castigatorul!");
        }

    }
}
