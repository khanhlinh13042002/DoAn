package com.example.doan;

import static com.example.doan.CategoryActivity.catList;
import static com.example.doan.CategoryActivity.selected_cat_index;
import static com.example.doan.SetAdapter.selected_set_index;
import static com.example.doan.setActivity.setsIDs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.doan.model.QuestionModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {
   private RecyclerView quesView;
   private Button btn_addques;
   private List<QuestionModel> quesList;
   private QuestionAdapter adapter;
   private Dialog loadingDialog;
   private FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.ques_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Questions");

        loadingDialog = new Dialog(QuestionActivity.this);
        loadingDialog.setContentView(R.layout.loading_progress_bar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        quesView = findViewById(R.id.ques_recycler);
        btn_addques = findViewById(R.id.btn_add_ques);
        btn_addques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        quesView.setLayoutManager(layoutManager);
        firestore = FirebaseFirestore.getInstance();
       // loadQuestions();
    }
//    private void loadQuestions()
//    {
//        quesList.clear();
//        quesList.add(new QuestionModel("1","Q1","A","B","C","D",2));
//        quesList.add(new QuestionModel("2","Q2","A","B","C","D",2));
//        quesList.add(new QuestionModel("3","Q3","A","B","C","D",2));
//        quesList.add(new QuestionModel("4","Q4","A","B","C","D",2));
//        adapter = new QuestionAdapter(quesList);
//        quesView.setAdapter(adapter);
//
//
//    }
}