package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public FragmentB() {
    }


    public static FragmentB newInstance(String param1, String param2) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FragmentB", "onCreate");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FragmentB", "onCreateView");
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("FragmentB", "onAttach");
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FragmentB", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FragmentB", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentB", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentB", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentB", "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentB", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentB", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FragmentB", "onDetach");
    }
}