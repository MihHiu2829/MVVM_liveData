package com.example.mvvm_livedata34.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.mvvm_livedata34.R;
import com.example.mvvm_livedata34.ViewModel.m001_VM;
import com.example.mvvm_livedata34.databinding.ActivityMainBinding;

public class MainActivity extends base_ACT<ActivityMainBinding, m001_VM> {


    @Override
    protected void initViews() {
        viewModel.getTimedata().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.progressTime.setProgress(integer);
                binding.tcCountDown.setText(String.format("%s",integer));
            }
        });
        binding.progressTime.setMax(10);
        binding.btStart.setOnClickListener(v -> startCountDown());

    }

    private void startCountDown() {
        viewModel.startCountDown() ;

    }

    @Override
    protected Class<m001_VM> getClassVM() {
        return m001_VM.class;
    }

    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}