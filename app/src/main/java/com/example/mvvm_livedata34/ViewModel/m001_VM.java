package com.example.mvvm_livedata34.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
    private Thread th ;
    private MutableLiveData<Integer> timedata = new MutableLiveData<>(0) ;

    public MutableLiveData<Integer> getTimedata() {
        return timedata;
    }


    public void startCountDown() {
        if(th == null || !th.isAlive())
        {
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=10;i>=0;i--)
                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return ;
                        }
                        timedata.postValue(i);
                    }
                }
            });
                    th.start();
        }
    }
}
