package controller;

import ch.astorm.jchess.JChessGame;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stockfish {
    private Runtime rt;
    private Process proc;
    private PrintWriter writer ;
    JChessGame game = JChessGame.newGame();


    public Stockfish(Runtime rt, String proc1) throws IOException {
        this.rt = rt;
        this.proc = rt.exec(proc1);
        this.writer = new PrintWriter(proc.getOutputStream());
        this.writer.println("position startpos" + "\n");
        this.getWriter().flush();
    }



    public Runtime getRt() {
        return rt;
    }

    public void setRt(Runtime rt) {
        this.rt = rt;
    }

    public Process getProc() {
        return proc;
    }

    public void setProc(Process proc) {
        this.proc = proc;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }



    public String readFromInputStream(InputStream inputStream) throws IOException {
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

    public String getNextMove() throws IOException {
        this.writer.println("go movetime 1000 " + "\n");
        this.getWriter().flush();
        String output = this.readFromInputStream(this.proc.getInputStream());
        Pattern p = Pattern.compile("bestmove ([a-h][1-8][a-h][1-8]) ponder");
        Matcher m = p.matcher(output);

        if (m.find()) {
            System.out.println(m.group(1));  // prints: e2e4"
        }
        return m.group(1);
    }

}
