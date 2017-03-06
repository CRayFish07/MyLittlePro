package com.example.interviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NewAdapter extends BaseAdapter implements OnScrollListener{

	List<String> strs;
	Context context;
	ListView listView;
	LayoutInflater inflater;
	
	int start,end;
	
	public NewAdapter(List<String> strs, Context context) {
		super();
		this.strs = strs;
		this.context = context;
		inflater=LayoutInflater.from(context);
	}

	
	public void setListView(ListView listView){
		this.listView=listView;
	}
	
	@Override
	public int getCount() {
		return strs==null?0:strs.size();
	}

	@Override
	public Object getItem(int arg0) {
		return strs==null?null:strs.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder;
		if(arg1==null){
			arg1=inflater.inflate(R.layout.item_list, arg2);
			viewHolder=new ViewHolder();
			viewHolder.avater=(ImageView) arg1.findViewById(R.id.img);
			viewHolder.title=(TextView) arg1.findViewById(R.id.title);
			viewHolder.desc=(TextView) arg1.findViewById(R.id.desc);
			
			if(listView!=null){
				listView.setOnScrollListener(this);
			}
			
			arg1.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) arg1.getTag();
		}
		String url=strs.get(arg0);
		
//		ImageLoader.getInstance().loadImage(viewHolder.avater, url);
		
		viewHolder.avater.setTag(url);
		viewHolder.title.setText("title"+arg0);
		viewHolder.desc.setText("desc"+arg0);
		
		return arg1;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		
		start=firstVisibleItem;
		end=firstVisibleItem+visibleItemCount;
		
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		switch (scrollState) {
		case SCROLL_STATE_IDLE:
			ImageLoader.getInstance().loadImages(start, end);
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			ImageLoader.getInstance().cancelAllLoaders();
			break;
		case SCROLL_STATE_FLING:
			//TODO
			break;
		default:
			break;
		}
		
	}

	static class ViewHolder{
		ImageView avater;
		TextView title;
		TextView desc;
	}
}
