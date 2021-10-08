package com.example.lesson6android1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class GameFragment extends Fragment {
    GameModel model;
    TextView levelTv;
    ImageView firstIv;
    ImageView secondIv;
    ImageView thirdIv;
    ImageView fourthIv;
    Button tryBtn;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromLevel();
        initViews(view);
        setData();
        initClicker();

    }

    private void initClicker() {
        tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        if(editText.getText().toString().trim().equals(model.answer)){
            Toast.makeText(requireContext(), "Правильно", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(requireContext(), "Не правильно", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        levelTv.setText(model.level);
        Glide.with(requireContext()).load(model.imageAddressFirst).centerCrop().into(firstIv);
        Glide.with(requireContext()).load(model.imageAddressSecond).centerCrop().into(secondIv);
        Glide.with(requireContext()).load(model.imageAddressThird).centerCrop().into(thirdIv);
        Glide.with(requireContext()).load(model.imageAddressFourth).centerCrop().into(fourthIv);
    }


    private void getDataFromLevel() {
        model = (GameModel) getArguments().getSerializable("model");
    }

    private void initViews(View view) {
        levelTv = view.findViewById(R.id.level_tv);
        firstIv = view.findViewById(R.id.first_iv);
        secondIv = view.findViewById(R.id.second_iv);
        thirdIv = view.findViewById(R.id.third_iv);
        fourthIv = view.findViewById(R.id.fourth_iv);
        tryBtn = view.findViewById(R.id.try_btn);
        editText= view.findViewById(R.id.input_name_ed);
    }
}