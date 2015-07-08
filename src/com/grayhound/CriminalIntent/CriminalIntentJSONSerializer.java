package com.grayhound.CriminalIntent;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by admin on 08.07.2015.
 */
public class CriminalIntentJSONSerializer  {
    private Context mContext;
    private String mFilename;

    public CriminalIntentJSONSerializer( Context c, String f){
        mContext = c;
        mFilename = f;
    }

    public ArrayList<Crime> loadCrimes() throws IOException, JSONException {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        BufferedReader reader = null;
        try {
            //open and read file in StreamBuilder
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                //Line breacks are omitted and irrelevant
                jsonString.append(line);
            }
            // dismantle string
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // create array
            for (int i = 0; i < array.length(); i++) {
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        }catch (FileNotFoundException e) {
             //dont bother
        } finally {
            if (reader != null)
            reader.close();
            }
            return crimes;
        }


    public void saveCrimes(ArrayList<Crime> crimes)
        throws JSONException, IOException {
        //Build array in JSON
        JSONArray array = new JSONArray();
        for (Crime c : crimes)
            array.put(c.toJSON());

        //write file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
