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
        JChessGame game = JChessGame.newGame();
        List<Move> legalMoves = game.getAvailableMoves();
        System.out.println(legalMoves.toString());
        Position position = game.getPosition();
        Map<Coordinate, Moveable> moveables = position.getMoveables();
        System.out.println(moveables.toString());
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("D:\\DOWNLOADS\\stockfish\\stockfish\\stockfish.exe");
        OutputStream outputStream = proc.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        // Write data to the process
        writer.println("position startpos move e2e4" + "\n");
        writer.println("go movetime 1000 " + "\n");

        // Flush the writer to ensure the data is sent
        writer.flush();

        InputStream inputStream = proc.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String output = readFromInputStream(proc.getInputStream());

        Pattern p = Pattern.compile("bestmove ([a-h][1-8][a-h][1-8]) ponder");
        Matcher m = p.matcher(output);

        if (m.find()) {
            System.out.println(m.group(1));  // prints: e2e4"
        }
        //SpringApplication.run(Licenta2Application.class, args);
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
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

        }
        return output.toString();
    }

}
