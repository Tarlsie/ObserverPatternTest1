package com.dst.danielt.observertestapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielT on 07/01/2016.
 */
public class SubjectObs {

    private int state;
    private List<ObserverClass> obsClass = new ArrayList<>();

    public SubjectObs(){

    }

    public void setState(int state){
        this.state = state;
        notifyObservers();
    }

    public int getState(){
        return state;
    }


    public void notifyObservers(){
        for(ObserverClass obs:obsClass){
            obs.update(getState());
        }
    }

    public void attach(ObserverClass observer){
        obsClass.add(observer);

    }

}
