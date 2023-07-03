package service;

import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.core.Move;
import ch.astorm.jchess.core.Moveable;
import ch.astorm.jchess.io.PGNWriter;
import ch.astorm.jchess.util.ASCIIPositionRenderer;
import controller.Stockfish;
import controller.User;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StockfishServive {
    Stockfish stockfish = new Stockfish(Runtime.getRuntime(),"D:\\DOWNLOADS\\stockfish\\stockfish\\stockfish.exe");
    JChessGame game = JChessGame.newGame();
    List<Move> legalMoves = game.getAvailableMoves();
    User user = new User(stockfish);

    public String getGameMoves() {
        return gameMoves;
    }

    public void setGameMoves(String gameMoves) {
        this.gameMoves = gameMoves;
    }

    String gameMoves = new String();

    public Stockfish getStockfish() {
        return stockfish;
    }

    public void setStockfish(Stockfish stockfish) {
        this.stockfish = stockfish;
    }

    public JChessGame getGame() {
        return game;
    }

    public void setGame(JChessGame game) {
        this.game = game;
    }

    public List<Move> getLegalMoves() {
        return legalMoves;
    }

    public void setLegalMoves(List<Move> legalMoves) {
        this.legalMoves = legalMoves;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public StockfishServive() throws IOException {
    }

    public String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Pattern p = Pattern.compile("ponder*");

        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            output.append(line).append('\n');
            Matcher m = p.matcher(output);
            if (m.find()) {
                break;
            }
        }

        return output.toString();
    }

    public String sendMove(String origin, String destination) throws IOException {
        gameMoves +=  origin + destination + " ";
        String nextMove = this.getNextMove();
        Moveable moveableAtLocation = game.getPosition().get(nextMove.substring(0, 2));
        if(moveableAtLocation.getClass().toString().equals("class ch.astorm.jchess.core.entities.Pawn")){
            this.updateGame(nextMove.substring(2, 4));

        }
        else if(moveableAtLocation.getClass().toString().charAt(38) == 'n'){
            System.out.println(moveableAtLocation.getClass().toString().charAt(38) + nextMove.substring(2, 4));
            this.updateGame(Character.toUpperCase(moveableAtLocation.getClass().toString().charAt(38)) + nextMove.substring(2, 4));}
        else this.updateGame(moveableAtLocation.getClass().toString().charAt(37) + nextMove.substring(2, 4));
        System.out.println("characterul e " +moveableAtLocation.getClass().toString().charAt(38));
        gameMoves +=  nextMove + " ";
        ASCIIPositionRenderer.render(System.out, game.getPosition());
        return nextMove;
    }
    public void updateGame(String move){
        game.doMove(move);
        System.out.println(game.getAvailableMoves().toString());
    }

    public String getNextMove() throws IOException {
        stockfish.getWriter().println("position startpos moves " + gameMoves + "\n");
        stockfish.getWriter().println("go movetime 1000 " + "\n");
        stockfish.getWriter().flush();
        String output = this.readFromInputStream(stockfish.getProc().getInputStream());
        Pattern p = Pattern.compile("bestmove ([a-h][1-8][a-h][1-8]) ponder");
        Matcher m = p.matcher(output);

        if (m.find()) {
            System.out.println(m.group(1));  // prints: e2e4"
        }
        else { p = Pattern.compile("bestmove *");
            m = p.matcher(output);
            if (m.find()) {
                System.out.println(m.group(1));  // prints: e2e4"
            }
        }
        return m.group(1);
    }
}
