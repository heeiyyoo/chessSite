package com.example.licenta2;

import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.core.Coordinate;
import ch.astorm.jchess.core.Move;
import ch.astorm.jchess.core.Moveable;
import ch.astorm.jchess.core.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Licenta2Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        /*JChessGame game = JChessGame.newGame();
        List<Move> legalMoves = game.getAvailableMoves();
        System.out.println(legalMoves.toString());
        Position position = game.getPosition();
        Map<Coordinate, Moveable> moveables = position.getMoveables();
        System.out.println(moveables.toString());*/
        Stockfish stockfish = new Stockfish(Runtime.getRuntime(),"D:\\DOWNLOADS\\stockfish\\stockfish\\stockfish.exe");
        User user = new User(stockfish);

        stockfish.getNextMove();

        //SpringApplication.run(Licenta2Application.class, args);

    }



}
