package com.example.MeraparDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Analyze {

    @Autowired
    private DataController dataController;

    @GetMapping("/analyze")
    public String GetData( Model model){
        Data data = new Data();
        model.addAttribute("Data", data);
        return "data";
    }

    @PostMapping("/analyze")
    public String sendData(@ModelAttribute Data data){
        dataController.analyzeData(data);
        return "analyzed";
    }
}
