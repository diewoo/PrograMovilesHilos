package com.bignerdranch.android.multitarea;

import android.os.AsyncTask;

/**
 * Created by Diego Renteria on 19/09/2016.
 */
public class TareaCompletaTask  extends AsyncTask<String ,Integer,String>{


    @Override
    protected String doInBackground(String... strings) {
        // en el hilo alterno
        return null;
    }

    @Override
    protected void onPreExecute() {
        //en el hilo principal MainThread

    }

    @Override
    protected void onPostExecute(String s) {
        //en el hilo principal MainThread

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //en el hilo principal MainThread

    }
}
