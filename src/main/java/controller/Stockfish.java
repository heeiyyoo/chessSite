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



}
