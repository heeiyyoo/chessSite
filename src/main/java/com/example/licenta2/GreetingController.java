package com.example.licenta2;

import ch.astorm.jchess.core.Move;
import ch.astorm.jchess.util.ASCIIPositionRenderer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import service.StockfishServive;

import java.io.IOException;
import java.util.Objects;

@Controller
public class GreetingController {
    StockfishServive stockfishServive = new StockfishServive();

    public GreetingController() throws IOException {
    }

    @GetMapping("/play")
    public String greeting() {

        return "play";
    }
    @GetMapping("/learnmain")
    public String learn() {
        return "learnmain";
    }

    @GetMapping("/learnknight")
    public String learnKnight() {

        return "learnknight";
    }
    @GetMapping("/learnrook")
        public String learnRook() {

        return "learnrook";
    }
    @GetMapping("/learnbishop")
    public String learnBishop() {

        return "learnbishop";
    }
    @GetMapping("/learnking")
    public String learnKing() {

        return "learnking";
    }
    @GetMapping("/learnqueen")
    public String learnQueen() {

        return "learnqueen";
    }
    @GetMapping("/learnforks")
    public String learnForks() {

        return "learnforks";
    }
    @GetMapping("/learncastle")
    public String learnCastle() {

        return "learncastle";
    }
    @GetMapping("/puzzle1")
    public String learnPuzzle1() {

        return "puzzle1";
    }
    @GetMapping("/puzzle2")
    public String learnPuzzle2() {

        return "puzzle2";
    }

    @GetMapping("/openingKI")
    public String learnOpeningsKI() {

        return "openingKI";
    }
    @GetMapping("/coordinates")
    public String learnCoordinates() {

        return "coordinates";
    }

    @PostMapping("/play/move")
    public ResponseEntity<String> checkMove(@RequestBody Move1 move1) throws IOException {
        System.out.println(move1.getOrigin() + move1.getDestination() +move1.getPiece());
        System.out.println(stockfishServive.getGame().getAvailableMoves());
        if(Objects.equals(move1.getPiece(), "P")) {
            if (stockfishServive.getGame().getAvailableMoves().toString().contains(move1.getDestination())) {

                stockfishServive.updateGame(move1.getDestination());
                System.out.println("e pawn");
                return new ResponseEntity<>("OK", HttpStatus.OK);
            }
            else if(stockfishServive.getGame().getAvailableMoves().toString().contains(move1.getOrigin().charAt(0) + "x" + move1.getDestination())){
            stockfishServive.updateGame(move1.getOrigin().charAt(0) + "x" + move1.getDestination());
            System.out.println("e pawn");
            return new ResponseEntity<>("OK", HttpStatus.OK);}

            else return new ResponseEntity<>("not", HttpStatus.OK);

        }
        else if (stockfishServive.getGame().getAvailableMoves().toString().contains(move1.getPiece() + move1.getDestination())) {
            stockfishServive.updateGame(move1.getPiece()+move1.getDestination());
            return new ResponseEntity<>("OK", HttpStatus.OK);

        }
        else if(stockfishServive.getGame().getAvailableMoves().toString().contains(move1.getPiece() + "x" + move1.getDestination())){
            stockfishServive.updateGame(move1.getPiece()+ "x" + move1.getDestination());
            return new ResponseEntity<>("OK", HttpStatus.OK);}

        else return new ResponseEntity<>("not", HttpStatus.OK);



    }
    @PostMapping("/play/move1")
    public ResponseEntity<Move1> makeMove(@RequestBody Move1 move1) throws IOException {

        String answer = stockfishServive.sendMove(move1.getOrigin(),move1.getDestination());

        move1.setOrigin(answer.substring(0, 2));
        move1.setDestination(answer.substring(2, 4));
        System.out.println(answer);
        System.out.println(stockfishServive.getGameMoves());
        return new ResponseEntity<>(move1, HttpStatus.OK);


    }
    public static class Move1 {
        private String origin;
        private String destination;

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        private String piece;


        // Add getters and setters for origin and destination
        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
    }

}
