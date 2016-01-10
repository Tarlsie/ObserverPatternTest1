package com.dst.danielt.observertestapp;

/**
 * Created by danielT on 09/01/2016.
 */
public interface ISubjectObs {

    void register( IObserverUpdater o); //not sure this should be observerclass
    void unRegister(IObserverUpdater o);
    void notifyObservers(int data1, int data2);


}
