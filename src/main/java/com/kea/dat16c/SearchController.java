package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    
    @RequestMapping({"searchpage"})
    public String searchpage(@RequestParam String query, Model model) {
        model.addAttribute("user", "Dat16c site");
        model.addAttribute("list", sqlQuery(levenshtein(query)));
        return "searchpage";
    }

    private List<String> levenshtein(String query)
    {
        List<String> words = new ArrayList<>();

        for(int i = 0; i < query.length(); i++)
        {
            // insertions
            words.add(query.substring(0, i) + "_" + query.substring(i));
            // deletions
            words.add(query.substring(0, i) + query.substring(i + 1));
            // substitutions
            words.add(query.substring(0, i) + "_" + query.substring(i + 1));
        }
        words.add(query + "_");

        return words;
    }

    private String sqlQuery(List<String> words)
    {
        String query =  "SELECT * FROM pages WHERE \n";
        for (String word : words) {
            query += "text LIKE '%" + word + "%' OR \n" ;
        }

        return query.substring(0, query.length() - 4) + ";";
    }


}
