package com.example.interviewtest;

import android.widget.ImageView;

public interface IImageLoader {

	void loadImage(ImageView view,String url);
	
	void loadImages(int start,int end);
	
	void cancelAllLoaders();
	
}
