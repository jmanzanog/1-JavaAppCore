package clientRest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Dago Manzano on 23/12/2016.
 */
public class ClientRestApache {
    private static final Logger log = Logger.getLogger(ClientRestApache.class);
    private String URL;
    private String BODY;
    private static JSONArray jsonArray;
    private StringEntity entity;
    private HttpResponse response;
    private String result;
    private CloseableHttpClient httpClient;
    private HttpEntityEnclosingRequestBase httpRequestBase;
    //comit test

    public static void main(String[] args) {
        ClientRestApache clientRestApache = new ClientRestApache(HttpPost.METHOD_NAME,ContentType.TEXT_PLAIN);
    }
    public ClientRestApache(String method,ContentType contentType) {
        if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)){
            loadInit(method,contentType);
            try {
                entity = new StringEntity(BODY);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                log.error(e);
            }
            httpRequestBase.setEntity(entity);
            try {
                response = httpClient.execute(httpRequestBase);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("ERROR on execute method: ",e);
            }
            try {
                result = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e);
            }
            try {
               // jsonArray = new JSONArray(result);
                jsonArray = new JSONArray("["+result+"]");
            } catch (JSONException e) {
                e.printStackTrace();
                log.error(e);
            }
        }
    }

    public void loadInit(String methodName,ContentType contentType){
        Properties prop = new Properties();
        InputStream input =  getClass().getClassLoader().getResourceAsStream("config.properties");
        httpClient = HttpClientBuilder.create().build();

        if (HttpPost.METHOD_NAME.equalsIgnoreCase(methodName)){
            try {
                prop.load(input);
                URL = prop.getProperty("url.test.post.request");
                BODY=prop.getProperty("body.test.post.request");
                httpRequestBase = new HttpPost(URL);
                httpRequestBase.setHeader("Content-Type", contentType.getMimeType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
