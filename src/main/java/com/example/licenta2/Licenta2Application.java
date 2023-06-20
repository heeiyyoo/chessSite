package com.example.licenta2;

import controller.Stockfish;
import controller.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.*;

@SpringBootApplication
public class Licenta2Application{

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

        SpringApplication.run(Licenta2Application.class, args);

    }



}
