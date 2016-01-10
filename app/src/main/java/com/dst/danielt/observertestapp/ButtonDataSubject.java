package com.dst.danielt.observertestapp;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielT on 09/01/2016.
 */
public class ButtonDataSubject implements ISubjectObs {

    private ArrayList observers;
    private int buttonData1;
    private int buttonData2;

    public ButtonDataSubject(){
        Log.i("ButtonDataSubject", "constructor");
        observers = new ArrayList<>();
    }

    public void setMeasurements(int btn1, int btn2){
        buttonData1 = btn1;
        buttonData2 = btn2;
        measurementsChanged();
    }

    public void measurementsChanged(){
        notifyObservers(buttonData1,buttonData2);
    }

    @Override
    public void register(IObserverUpdater o) {
        Log.i("ButtonDataSubject", "register observer");
        observers.add(o);
    }

    @Override
    public void unRegister(IObserverUpdater o) {
        Log.i("ButtonDataSubject", "unregister observer");
        //observers.remove(o);
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers(int data1, int data2) {
        Log.i("ButtonDataSubject", "notify observer");
        for(int i =0; i<observers.size();i++){
            IObserverUpdater observer = (IObserverUpdater)observers.get(i);
            observer.update(data1, data2);
        }

    }
}
