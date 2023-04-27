package com.example.harjoitusty_arttu_korpela;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentUpdater extends ViewModel {
    MutableLiveData<Integer> change = new MutableLiveData<Integer>(1);


    public void update(){
        if (change.getValue() != 1) {change.setValue(1);}
        else {change.setValue(2);}
    }

    public MutableLiveData<Integer> getValue(){return change;}
}
