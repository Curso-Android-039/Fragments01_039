package com.example.fragments01_039;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.fragments01_039.databinding.FragmentQuestionBinding;


public class QuestionFragment extends Fragment {

 // tengo que una referencia ViewBinding
    private FragmentQuestionBinding mBinding;

    public QuestionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_question, container, false);
        mBinding = FragmentQuestionBinding.inflate(inflater, container, false);
        return  mBinding.getRoot();


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       mBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {


               int index = mBinding.radiogroup.indexOfChild(mBinding.radiogroup.findViewById(i));

               switch ( index){

                   case 0:
                       mBinding.TextviewRes.setText("Si lo conozco");
                       break;

                   case 1: mBinding.TextviewRes.setText("no lo conozco");
                   break;

                   default:
                  break;




               }




           }
       });


    }
}