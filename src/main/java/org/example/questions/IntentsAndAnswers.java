package org.example.questions;
import org.example.interfaces.Question;

import java.util.List;

public class IntentsAndAnswers {

    private final List<Question> listQuestionsAndAnswers;

    public IntentsAndAnswers(List<Question> listQuestionsAndAnswers){
        this.listQuestionsAndAnswers = listQuestionsAndAnswers;
    }

    public List<Question> getQuestionsWithAnswers(){
        return listQuestionsAndAnswers;
    }
}
