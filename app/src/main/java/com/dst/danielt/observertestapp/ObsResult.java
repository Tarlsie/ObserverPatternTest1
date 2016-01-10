package com.dst.danielt.observertestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.Bind;



public class ObsResult extends ObserverClass{

    public DisplayResultsToView updateFrag;
    private SubjectObs obsTest;

    public ObsResult(SubjectObs obsTest){
        this.obsTest = obsTest;
        obsTest.attach(this);

    }


    @Override
    public void update(int value) {
        updateFrag.display(value);
        Log.i("ObserverResult Fragment", "ObservAble update Value is " + 6);
    }

    public interface DisplayResultsToView {
        void display(int num);
    }


    //  public interface UpdateAndroidFragment{   void fragmentupdate(int value);    }
}
