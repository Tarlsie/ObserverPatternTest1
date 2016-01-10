package com.dst.danielt.observertestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ObserverTest} interface
 * to handle interaction events.
 * Use the {@link ObserverTest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObserverTest extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

  //  ObserverSetData ods;
    public int observerTest;
    public int observAbleTest;

    private List<ObserverClass> observers;


  //  public ArrayList observers;
  //  IObserverUpdater ob;
 //   private OnFragmentInteractionListener mListener;

    public ObserverTest() {
        // Required empty public constructor
    //    observers = new ArrayList();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    ButtonDataSubject subObs;
    //@Bind(R.id.btnObservAble)
    Button btnObservAble;
    //@Bind(R.id.btnObserver)
     Button btnObserver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_observer_test, container, false);
       // ButterKnife.bind(this,v);
       // observers = new ArrayList<ObserverClass>();
        observAbleTest=0;
        observAbleTest=0;
        btnObservAble = (Button)v.findViewById(R.id.btnObservAble);
        btnObserver = (Button)v.findViewById(R.id.btnObserver);
         subObs= new ButtonDataSubject();
        ObserverResults obsRes =   new ObserverResults();
        obsRes.onObserverResultsSetObserver(subObs);
        Log.i("Observer Click " , "initial value - "+observerTest+ " "+ observAbleTest);

        btnObserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Observer Click " , "value - "+observerTest);
                observerTest++;
                subObs.setMeasurements(observerTest,1);
            }
        });

        btnObservAble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ObservAble Click " , "value - "+observAbleTest);
                observAbleTest++;
                subObs.setMeasurements(0,observAbleTest);
            }
        });

        return v;
    }

    @OnClick(R.id.btnObserver)
    void observerClick(){
        Log.i("Observer Click " , "value - "+observerTest);
        observerTest++;
        subObs.setMeasurements(observerTest,1);
        //subObs.notifyObservers(observerTest,0);


    }

    @OnClick(R.id.btnObservAble)
    void observAbleClick(){
        Log.i("ObservAble Click " , "value - "+observAbleTest);
        observAbleTest++;
        subObs.setMeasurements(0,observAbleTest);
     //   subObs.notifyObservers(observerTest, observAbleTest);

    }

    // TODO: Rename method, update argument and hook method into UI event
  //  public void onButtonPressed(String text) {
  //      if (mListener != null) {
   //         mListener.onFragmentInteraction(text);
   //     }
  //  }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

////////////////////////////////////
    //observable Subject class
    /////////////////////////////
/*
    public int getState(){
        return observAbleTest;
    }


    public void notifyObservers(){
        Log.i("ObservAble Click " , "notifyobservers function");
        for(ObserverClass obs:observers){
            obs.update(observAbleTest);
        }
    }

    public void attach(ObserverClass observer){
        Log.i("ObservAble Click " , "attach function");
        observers.add(observer);

    }

    /** @Override
    public void onFragmentInteraction(String text) {
        Log.i("onfragment interaction", text);
    }


     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text);
    } */



}
