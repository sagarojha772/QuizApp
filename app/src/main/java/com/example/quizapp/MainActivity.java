package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV, questionNumber;
    private Button option1, option2, option3, option4;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0;
    int questionsAttempted = 1;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.Question);
        questionNumber = findViewById(R.id.QuestionsAttempted);
        option1 = findViewById(R.id.Option1);
        option2 = findViewById(R.id.Option2);
        option3 = findViewById(R.id.Option3);
        option4 = findViewById(R.id.Option4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionsAttempted++;
//                currentPos = random.nextInt(quizModelArrayList.size());
//                setDataToViews(currentPos);

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionsAttempted++;
//                currentPos = random.nextInt(quizModelArrayList.size());
//                setDataToViews(currentPos);

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionsAttempted++;
//                currentPos = random.nextInt(quizModelArrayList.size());
//                setDataToViews(currentPos);

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionsAttempted++;
//                currentPos = random.nextInt(quizModelArrayList.size());
//                setDataToViews(currentPos);

            }
        });
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }


    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.LLScore));
        TextView scoreTv = bottomSheetView.findViewById(R.id.Score);
        Button resButton = bottomSheetView.findViewById(R.id.RestartButton);
        scoreTv.setText("Your score is " + currentScore);
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionsAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos) {
        questionNumber.setText("Questions Attempted : " + questionsAttempted + "/5");
        if (questionsAttempted == 5) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1.setText(quizModelArrayList.get(currentPos).getOption1());
            option2.setText(quizModelArrayList.get(currentPos).getOption2());
            option3.setText(quizModelArrayList.get(currentPos).getOption3());
            option4.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }
    private void getQuizQuestion (ArrayList<QuizModel> quizModelArrayList) {
            quizModelArrayList.add(new QuizModel("Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Delhi"));
            quizModelArrayList.add(new QuizModel("Currency Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Mumbai"));
            quizModelArrayList.add(new QuizModel("Silicon Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Bangalore"));
            quizModelArrayList.add(new QuizModel("Ancient Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Kolkata"));
            quizModelArrayList.add(new QuizModel("Populated Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Delhi"));
            quizModelArrayList.add(new QuizModel("Rich Capital Of India ?", "Delhi", "Mumbai", "Kolkata", "Bangalore", "Mumbai"));
    }
}