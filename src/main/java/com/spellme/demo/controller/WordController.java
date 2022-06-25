package com.spellme.demo.controller;

import com.spellme.demo.Model.Term;
import com.spellme.demo.repositories.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WordController {
    @Autowired
    WordRepo wordRepo;
//    @GetMapping("/words")
//    public List<Term> addWords() {
//        List<Term> words = new ArrayList<Term>();
//        words.add(new Term(1, "hat"));
//        words.add(new Term(2, "cat"));
//        return words;
//    }
    @GetMapping("/allwords")
    public List<Term> getWords(){
        return wordRepo.findAll();
    }
    @PostMapping("/save")
    public String SaveWord(@RequestBody Term term){
        wordRepo.save(term);
        return "saved..." ;
    }
    @PutMapping("/update/{id}")
        public String updateWord(@PathVariable long id, @RequestBody Term term){
        Term updateWord = wordRepo.findById(id).get();
        updateWord.setId(term.getId());
        updateWord.setTerm(term.getTerm());
        wordRepo.save(updateWord);
        return "updated...";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteWord(@PathVariable("id")long id){
        Term deleteWord = wordRepo.findById(id).get();
        wordRepo.delete(deleteWord);
        return "deleted word with id: " + id;
    }
};
