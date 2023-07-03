package com.example.licenta2;

import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.core.Move;
import ch.astorm.jchess.core.Position;
import controller.Stockfish;
import controller.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import service.StockfishServive;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class Licenta2Application{

    public static void main(String[] args) throws IOException, InterruptedException {
        JChessGame game = JChessGame.newGame();
        List<Move> legalMoves = game.getAvailableMoves();
        System.out.println(legalMoves.toString());
        Position position = game.getPosition();
       // game.doMove("e4");
        //System.out.println(game.getAvailableMoves().toString());
        /*Map<Coordinate, Moveable> moveables = position.getMoveables();
        System.out.println(moveables.toString());*/

        SpringApplication.run(Licenta2Application.class, args);

    }



}
