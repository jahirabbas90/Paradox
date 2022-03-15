package com.paradoxclient.paradox.presenter.restService;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpPostAsyncTask extends AsyncTask<String, Void, Void> {
      RequestType type;
      APICallback callback;
    // This is the JSON body of the post
    JSONObject postData;
    private String TAG="HTTP---REQUIEST";

    // This is a constructor that allows you to pass in the JSON body
    public HttpPostAsyncTask(Map<String, String> postData, RequestType type, APICallback callback) {
        if (postData != null) {
            this.postData = new JSONObject(postData);
            this.type = type;
            this.callback = callback;
        }
    }

    // This is a function that we are overriding from AsyncTask. It takes Strings as parameters because that is what we defined for the parameters of our async task
    @Override
    protected Void doInBackground(String... params) {

        try {
            // This is getting the url from the string we passed in
            URL url = new URL(params[0]);
            HttpURLConnection http = null;
            // Create the urlConnection
           // HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (url.getProtocol().toLowerCase().equals("https")) {
                trustAllHosts();
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setHostnameVerifier(DO_NOT_VERIFY);
                http = urlConnection;
            } else {
                http = (HttpURLConnection) url.openConnection();
            }

            http.setDoInput(true);
            http.setDoOutput(true);

            http.setRequestProperty("Content-Type", "application/json");

            http.setRequestMethod("POST");


            // OPTIONAL - Sets an authorization header
            http.setRequestProperty("ApiKey", "0a2b8d7f9243305f2a4700e1870f673b");

            // Send the post body
            if (this.postData != null) {
                OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
                writer.write(postData.toString());
                writer.flush();
            }

            int statusCode = http.getResponseCode();

            if (statusCode ==  200) {

                InputStream inputStream = new BufferedInputStream(http.getInputStream());

                String response = convertInputStreamToString(inputStream);

                switch (type) {
                    case REQUEST_TYPE_1:
                        // Use the response to create the object you need
                        callback.completionHandler(true, type, response);
                        break;
                    case REQUEST_TYPE_2:
                        // Do something
                        break;
                    default:
                        break;
                }
                // From here you can convert the string to JSON with whatever JSON parser you like to use
                // After converting the string to JSON, I call my custom callback. You can follow this process too, or you can implement the onPostExecute(Result) method
            } else {
                // Status code is not 200
                // Do something to handle the error
            }

        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage());
        }
        return null;
    }



    private String convertInputStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    /**
     * Trust every server - dont check for any certificate
     */
    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}