package com.example.interviewtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HttpService {
	
	private HttpService(){
		//TODO init
	}
	private static final class SigleTon{
		public static final HttpService INSTANCE=new HttpService();
	}

	public static final HttpService getInstance(){
		return SigleTon.INSTANCE;
	}

	public InputStream requestByAsny(String url) throws FileNotFoundException{
		
		return new FileInputStream(url);
		
	}
}
