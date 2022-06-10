package com.vti.frontend;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Question;

/**
 * @author giangdm
 */
public class Test {
    public static void main(String[] args) {
        CategoryQuestion cq1 = new CategoryQuestion();
        cq1.id = 1;
        cq1.name = "ques1";

        Question qs1 = new Question();
        qs1.categoryQuestion = cq1;
    }
}
