package com.example.mvvm_livedata34.View;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract class base_ACT <T extends ViewBinding,V extends ViewModel> extends AppCompatActivity implements View.OnClickListener {
    T binding ; 
    V viewModel  ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(getClassVM()) ;
        initViews() ;
    }

    protected abstract void initViews();

    protected abstract Class<V> getClassVM() ;

    protected abstract T initViewBinding();

    @Override
    public void onClick(View view) {
        //do nothing
    }
}
