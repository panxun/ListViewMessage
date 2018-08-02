package com.panxun.listview_message;
import android.widget.*;
import android.content.*;
import java.util.*;
import android.view.*;

public class MsgAdapter extends ArrayAdapter<Msg>
{
	private int resourceid;
	public MsgAdapter(Context c,int i,List<Msg> obj)
	{
		super(c,i,obj);
		resourceid=i;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO: Implement this method
		//在这里进行判断，如果是收到的消息则显示左边信息。如果是发出，则显示右边信息。
		
		return super.getView(position, convertView, parent);
	}
	//内部类
	class ViewHolder
	{
		LinearLayout leftlayout;
		LinearLayout rightlayout;
		TextView leftmsg;
		TextView rightmsg;
	}
}
