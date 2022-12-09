package com.example.studentgradeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView studentNameText_View;
    private TextView gradeAverageText_View;
    private Button displayStudentGradeAverageButton;
    private Button prevStudentButton;
    private Button nextStudentButton;

    private int currentIndex=0;
    public static final String TAG="Student Grade Project";
    public static final String KEY_INDEX="index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grade.credits = 3;

        Grade gradeRecord1 = new Grade(1, "Graham", "Bill", 69, 70, 98, 80, 90);
        Grade gradeRecord2 = new Grade(2, "Sanchez", "Jim", 88, 72, 90, 83, 93);
        Grade gradeRecord3 = new Grade(3, "White", "Peter", 85, 80, 45, 93, 70);
        Grade gradeRecord4 = new Grade(4, "Phelp", "David", 70, 60, 60, 90, 70);
        Grade gradeRecord5 = new Grade(5, "Lewis", "Sheila", 50, 76, 87, 59, 72);
        Grade gradeRecord6 = new Grade(6, "James", "Thomas", 89, 99, 97, 98, 99);

        Grade[] all_grades = new Grade[]{gradeRecord1, gradeRecord2, gradeRecord3, gradeRecord4, gradeRecord5, gradeRecord6};

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX);

            //get studentNameText_View

            studentNameText_View = (TextView) findViewById(R.id.student_name_text_view);
            studentNameText_View.setText("Grade: " + all_grades[currentIndex].getStudent_id() + " " + all_grades[currentIndex].getStudent_lname() +
                    ", " + all_grades[currentIndex].getStudent_fname() + "," + all_grades[currentIndex].getS_grade_Assignment1() +
                    ", " + all_grades[currentIndex].getS_grade_Assignment2() + "," + all_grades[currentIndex].getS_grade_Assignment3() +
                    ", " + all_grades[currentIndex].getS_grade_Mid_Term() + "," + all_grades[currentIndex].getS_grade_Final_Term());

            displayStudentGradeAverageButton = (Button) findViewById(R.id.display_student_grade_average_button);
            displayStudentGradeAverageButton.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gradeAverageText_View = (TextView) findViewById(R.id.grade_average_text_view);
                    gradeAverageText_View.setText("Grade Average : "); //calculate method from Grade class
                }
            }));
            nextStudentButton = (Button) findViewById(R.id.next_student_button);
            nextStudentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentIndex = (currentIndex + 1) % all_grades.length;
                    studentNameText_View.setText("Grade: " + all_grades[currentIndex].getStudent_id() + " " + all_grades[currentIndex].getStudent_lname() +
                            "," + all_grades[currentIndex].getStudent_fname() + "," + all_grades[currentIndex].getS_grade_Assignment1() +
                            "," + all_grades[currentIndex].getS_grade_Assignment2() + ";" + all_grades[currentIndex].getS_grade_Assignment3() +
                            "," + all_grades[currentIndex].getS_grade_Mid_Term() + "," + all_grades[currentIndex].getS_grade_Final_Term());
                    gradeAverageText_View = (TextView) findViewById(R.id.grade_average_text_view);
                    gradeAverageText_View.setText("");

                    // previos button?

                }
            });
        }


//        @Override
//        public void onStart () {
//            super.onStart();
//            Log.d(TAG, "onStart( called");
//        }
//        @Override
//        public void onPause () {
//            super.onPause();
//            Log.d(TAG, "onPause( called");
//        }
//        @Override
//        public void onResume () {
//            super.onResume();
//            Log.d(TAG, "onResume( called");
//        }
//        @Override
//        public void onSaveInstanceState (Bundle savedInstanceState){
//            super.onSaveInstanceState(savedInstanceState);
//            Log.d(TAG, "saveInstanceState( called");
//            savedInstanceState.putInt(KEY_INDEX, currentIndex);
//        }
//        @Override
//        public void onStop () {
//            super.onStop();
//            Log.d(TAG, "onStop( called");
//        }
//        @Override
//        public void onDestroy () {
//            super.onDestroy();
//            Log.d(TAG, "onDestroy( called");
//        }

    }
}