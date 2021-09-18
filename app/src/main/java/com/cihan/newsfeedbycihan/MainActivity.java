package com.cihan.newsfeedbycihan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewsListAdapter newsListAdapter;

    String msite;

    ListView LvRss;
    List<String> titles;
    List<String> links;
    List<String> images;
    ImageView img;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        msite = intent.getStringExtra("site");
        


        LvRss = (ListView) findViewById(R.id.LvRss);
        titles = new ArrayList<>();
        links = new ArrayList<>();
        images = new ArrayList<>();

       //  LayoutInflater layoutInflater =
         //       (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  view = layoutInflater.inflate(android.R.layout.simple_list_item_1,null);
      //  txtTitle = (TextView) view.findViewById(R.id.txtTitle);
       // img = (ImageView) view.findViewById(R.id.img);



        LvRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent1 = new Intent(MainActivity.this, NewsScreenActivity.class);
                intent1.putExtra("mlink", links.get(position));
                startActivity(intent1);




               // Uri uri = Uri.parse(links.get(position));
              //  Intent intent = new Intent(Intent.ACTION_VIEW,uri);
              //  startActivity(intent);

            }
        });

        new ProcessInBackground().execute();
    }

    public InputStream getInputStream(URL url)
    {
        try
        {
          return url.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public class ProcessInBackground extends AsyncTask<Integer,Integer,Exception>
    {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        Exception exception=null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           progressDialog.setMessage("Lütfen biraz bekleyiniz...");
           progressDialog.show();
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);

          //  newsListAdapter = new NewsListAdapter(getApplicationContext(), titles,links,images);
          //  LvRss.setAdapter(newsListAdapter);


           ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                   android.R.layout.simple_list_item_1,titles);
            LvRss.setAdapter(adapter);


            progressDialog.dismiss();
        }

        @Override
        protected Exception doInBackground(Integer... integers) {
            try
            {
               URL url = new URL(msite);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(getInputStream(url),"UTF_8");
                boolean insideItem = false;
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT)
                {
                   if(eventType==XmlPullParser.START_TAG)
                   {
                       if(xpp.getName().equalsIgnoreCase("item"))
                       {
                         insideItem=true;
                       }
                      // else if(xpp.getName().equalsIgnoreCase("image"))
                      // {
                          // if (insideItem)
                          // {
                              // images.add(xpp.nextText());
                              // URL myurl = new URL(images.toString());
                              // Bitmap bmp =
                               //        BitmapFactory.decodeStream(myurl.openConnection()
                               //      .getInputStream());
                             //ImageView imageView = new ImageView(MainActivity.this);
                             // img.setImageBitmap(bmp);

                         //  }
                      // }
                       else if(xpp.getName().equalsIgnoreCase("title"))
                       {
                           if (insideItem)
                           {

                              titles.add(xpp.nextText());
                              // txtTitle.setText(titles.toString());
                           }
                       }
                       else if(xpp.getName().equalsIgnoreCase("link"))
                       {
                           if (insideItem)
                           {
                               links.add(xpp.nextText());
                           }
                       }
                   }
                   else if(eventType== XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase(
                           "item"))
                   {
                     insideItem=false;
                   }

                   eventType = xpp.next();
                }


            }
            catch (MalformedURLException e) {
               exception = e;
            }
            catch (XmlPullParserException e)
            {
                exception = e;
            }
            catch (IOException e)
            {
                exception = e;
            }
            
            return exception;
        }
    }
    

}