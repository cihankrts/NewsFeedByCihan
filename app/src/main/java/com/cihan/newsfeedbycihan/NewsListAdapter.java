package com.cihan.newsfeedbycihan;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class NewsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mTitle;
    private List<String> mLinks;
    private List<String> mImages;

    public NewsListAdapter() {
    }

    public NewsListAdapter(Context mContext, List<String> mTitle, List<String> mLinks, List<String> mImages) {
        this.mContext = mContext;
        this.mTitle = mTitle;
        this.mLinks = mLinks;
        this.mImages = mImages;
    }

    @Override
    public int getCount() {
        return mTitle.size();
    }

    @Override
    public Object getItem(int position) {
        return mTitle.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.news_layout,null);
        TextView mNewsTitle = (TextView)v.findViewById(R.id.txtTitle);
        ImageView mImg = (ImageView)v.findViewById(R.id.img);

        mNewsTitle.setText(mTitle.get(position));
       //  Uri uri = Uri.parse(mImages.get(position));
        // Bitmap bitmap = null;
        //try {
      //      bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
     //   } catch (IOException e) {
      //      e.printStackTrace();
      //  }

       // mImg.setImageBitmap(bitmap);

       // v.setTag(mLinks.get(position));

        return v;
    }
}
