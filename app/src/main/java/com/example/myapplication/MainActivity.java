package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;

    TextView tvAdd;

    TextView tvReplace;

    TextView tvAddStack;

    TextView tvReplaceStack;


    int tvAddCount = 0;

    int tvReplaceCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.frag_container);
        tvAdd = findViewById(R.id.add);
        tvReplace = findViewById(R.id.replace);
        tvAddStack = findViewById(R.id.add_stack);
        tvReplaceStack = findViewById(R.id.replace_stack);

        tvAdd.setOnClickListener(v -> {
            if (tvAddCount == 0) {
                FragmentA fragmentA = new FragmentA();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frag_container, fragmentA);
//                transaction.addToBackStack(null);
                transaction.commit();
            } else if (tvAddCount == 1) {
                FragmentB fragmentB = new FragmentB();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frag_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            tvAddCount++;
        });

        tvReplace.setOnClickListener(v -> {
            if (tvReplaceCount == 0) {
                FragmentA fragmentA = new FragmentA();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frag_container, fragmentA);

                transaction.commit();
            } else if (tvReplaceCount == 1) {
                FragmentB fragmentB = new FragmentB();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frag_container, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
            tvReplaceCount++;
        });
    }
}