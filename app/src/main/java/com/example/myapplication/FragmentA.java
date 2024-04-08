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

import com.jd.dtil.CacheUtil;



public class FragmentA extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmentA() {

    }

    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("FragmentA", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FragmentA", "onCreateView");
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FragmentA", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FragmentA", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentA", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentA", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        CacheUtil.getCacheString();
        Log.d("FragmentA", "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentA", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentA", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FragmentA", "onDetach");
    }
}