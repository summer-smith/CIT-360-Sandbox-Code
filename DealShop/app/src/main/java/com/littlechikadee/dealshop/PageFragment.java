package com.littlechikadee.dealshop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.nio.BufferUnderflowException;


/**
 * A simple {@link Fragment} subclass.

 */
public class PageFragment extends android.support.v4.app.Fragment {
    TextView textView;

    public PageFragment() {
        //Empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.page_fragment_layout,container,false);
        textView = (TextView)view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        textView.setText("This is the " + message + " Swipe View Page.");
        return view;
    }
}
