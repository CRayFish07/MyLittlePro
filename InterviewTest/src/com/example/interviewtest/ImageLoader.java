package com.example.interviewtest;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class ImageLoader implements IImageLoader{

	
	private ImageCache<String, Bitmap> imgCache;
	
	private  ImageLoader() {
		
	}
	
	private static class SingleTon{
		public static final ImageLoader  INSTANCE=new ImageLoader();
	}

	public static final ImageLoader getInstance(){
		return SingleTon.INSTANCE;
	}
	
	public void setConfig(Config config){
		this.imgCache=config.imgCache;
	}
	/**
	 * ����һ��ͼƬ
	 * @param view
	 * @param url
	 */
	@Override
	public void loadImage(ImageView view,String url){
		if(imgCache==null){
			return;
		}
		if(view==null){
			throw new NullPointerException("ImageView is null");
		}
		
		if(url==null){
			throw new NullPointerException("url is null");
		}
		
		Bitmap bitmap=imgCache.get(url);
		if(bitmap==null){
			
			Bitmap bitmap2=getBitmapFromServer(url);
			
			imgCache.put(url, bitmap2);
		}else{
			view.setImageBitmap(bitmap);
		}
	}
	
	/**
	 * ���ض��ͼƬ
	 * @param start
	 * @param end
	 */
	@Override
	public void loadImages(int start,int end){
		// TODO Auto-generated method stub
	}
	
	/**
	 * ȡ�����м�������
	 */

	@Override
	public void cancelAllLoaders() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * �������Ӧ�÷������߳�ִ�У��ص����
	 * @param url
	 * @return
	 */
	public Bitmap getBitmapFromServer(final String url){
		try {
			InputStream stream=HttpService.getInstance().requestByAsny(url);
			return BitmapFactory.decodeStream(stream);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return null;
	}
}
