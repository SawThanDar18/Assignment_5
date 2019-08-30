package com.padcmyanmar.padc9.assignment_5.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.assignment_5.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgentImpl implements EventsDataAgent{

    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl(){

    }

    public static HttpUrlConnectionDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private GetEventsFromNetworkDelegate newsResponseDelegate;

        public GetEventsTask(GetEventsFromNetworkDelegate delegate) {
            this.newsResponseDelegate = delegate;
        }


        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            URL url;
            BufferedReader bufferedReader = null;
            StringBuilder stringBuilder;

            try {
                url = new URL(EventsConstants.BASE_URL + EventsConstants.GET_EVENTS);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");

                //give it 15seconds to respond
                connection.setReadTimeout(15 * 1000);

                connection.setDoInput(true);
                connection.setDoOutput(true);

                //put the request parameter into NameValuePair list.
                /*List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(EventsConstants.PARAM_ACCESS_TOKEN, accessToken));

                //write the parameter into NameValuePair list into connection object.
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();*/

                connection.connect();

                //read the output from the server
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }

                String responseString = stringBuilder.toString();

                GetEventsResponse response = new Gson().fromJson(responseString, GetEventsResponse.class);

                return response;

            } catch (Exception e){

            }finally {
                //close the reader; this can throw an exception too, so
                //wrap it in another try/catch block.
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }
            return null;
        }

        /*private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            for(NameValuePair pair : params){
                if (first){
                    first = false;
                }else {
                    result.append("&");
                }

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }
            return result.toString();
        }*/

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if(eventsResponse != null){

            }
        }
    }

}
