package com.example.licenta2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/play")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "play";
    }
    @GetMapping("/learnmain")
    public String learn(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnmain";
    }

    @GetMapping("/learnknight")
    public String learnKnight(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnknight";
    }
    @GetMapping("/learnrook")
        public String learnRook(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnrook";
    }
    @GetMapping("/learnbishop")
    public String learnBishop(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnbishop";
    }
    @GetMapping("/learnking")
    public String learnKing(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnking";
    }
    @GetMapping("/learnqueen")
    public String learnQueen(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnqueen";
    }
    @GetMapping("/learnforks")
    public String learnForks(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learnforks";
    }
    @GetMapping("/learncastle")
    public String learnCastle(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "learncastle";
    }
    @GetMapping("/puzzle1")
    public String learnPuzzle1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "puzzle1";
    }
    @GetMapping("/puzzle2")
    public String learnPuzzle2(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "puzzle2";
    }

    @GetMapping("/openingKI")
    public String learnOpeningsKI(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "openingKI";
    }
    @GetMapping("/coordinates")
    public String learnCoordinates(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "coordinates";
    }

}
