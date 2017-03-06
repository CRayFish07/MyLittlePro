package com.example.interviewtest;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCache implements ImageCache<String, Bitmap>{

	private LruCache<String, Bitmap> mCaches;

	@SuppressLint("NewApi") public MemoryCache(){
		//�����ǽ�������
        int maxMemory = (int) Runtime.getRuntime().maxMemory();  //����ʱ����ڴ�
        int cacheSize = maxMemory/4;
        mCaches = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
	}
	
	@Override
	public void put(String k, Bitmap v) {
		mCaches.put(k, v);
	}

	@Override
	public Bitmap get(String k) {
		return mCaches.get(k);
	}

}
