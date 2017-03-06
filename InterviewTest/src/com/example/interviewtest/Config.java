package com.example.interviewtest;

import android.graphics.Bitmap;

public class Config {
	
	ImageCache<String, Bitmap> imgCache;
	
	

	public Config(Builder builder) {
		super();
		this.imgCache = builder.imgCache;
	}



	public void setImgCache(ImageCache<String, Bitmap> imgCache) {
		this.imgCache = imgCache;
	}



	static class Builder{
	
		ImageCache<String, Bitmap> imgCache;

		public Builder setImgCache(ImageCache<String, Bitmap> imgCache) {
			this.imgCache = imgCache;
			
			return this;
		}
		
		public Config buid(){
			return new Config(this);
		}
	}

}
