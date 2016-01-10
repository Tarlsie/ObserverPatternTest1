package com.dst.danielt.observertestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.security.auth.Subject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ObserverResults extends Fragment implements IObserverUpdater {

    View view;
    //@Bind(R.id.txtVObserableResult)
    TextView txtVObservAbleResult;
   // @Bind(R.id.txtVObserverResult)
    TextView txtVObserverResult;

    private ButtonDataSubject iSub;
    public ObserverResults() {
        // Required empty public constructor
    }

    public void onObserverResultsSetObserver(ButtonDataSubject iSub ) {
        Log.i("Observer Results " ,"onObserverResultsSetObserver register observer in fragment");
        this.iSub = iSub;
        iSub.register(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_observer_results, container, false);
        Log.i("Observer Results " , "initial fragment");
      //  ButterKnife.bind(this,v);
        txtVObservAbleResult = (TextView)view.findViewById(R.id.txtVObsResult1);
        txtVObservAbleResult.setText("Simple tester");
        txtVObserverResult = (TextView)view.findViewById(R.id.txtVObsRes2);
        txtVObserverResult.setText("Setting text");

        changeTxtVText();


        return view;


    }

    public void changeTxtVText(){
        txtVObserverResult.setText("The text has been changed again");
        txtVObservAbleResult.setText("So has this one");
    }

    public void changeTxtVText(int n){
        txtVObserverResult.setText(n);
                txtVObservAbleResult.setText(n);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void update(int num1, int num2) {
        Log.i("Observer Results " , "fragment display function "+num1);
        view = getView();
        if(view==null){
           Log.i("Observer Results " , "fragment display function v is null ");
          // v =inflater.inflate(R.layout.fragment_observer_results, container, false);
       }
        changeTxtVText(num1);
//        txtVObserverResult= (TextView)view.findViewById(R.id.txtVObsResult1);
       // txtVObserverResult.setText( "10");
       // txtVObservAbleResult.setText("20");
    }


}




