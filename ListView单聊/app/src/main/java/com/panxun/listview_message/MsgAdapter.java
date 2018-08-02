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
		Msg msg=getItem(position);
		View v;
		ViewHolder vh;
		if(convertView==null)
		{
			v=LayoutInflater.from(getContext()).inflate(resourceid,null);
			vh=new ViewHolder();
			vh.leftlayout=(LinearLayout) v.findViewById(R.id.left_layout);
			vh.rightlayout=(LinearLayout) v.findViewById(R.id.right_layout);
			vh.leftmsg=(TextView) v.findViewById(R.id.left_msg);
			vh.rightmsg=(TextView) v.findViewById(R.id.right_msg);
			
			v.setTag(vh);
		}
		else
		{
			v=convertView;
			vh=(MsgAdapter.ViewHolder) v.getTag();
		}
		//如果是收到的消息，显示左边，隐藏右边
		if(msg.getType()==Msg.TYPE_RECEIVED)
		{
			vh.leftlayout.setVisibility(View.VISIBLE);
			vh.rightlayout.setVisibility(View.GONE);
			vh.leftmsg.setText(msg.getContent());
		}
		//如果是发出的，显示左边，隐藏左边
		else if(msg.getType()==Msg.TYPE_SENT)
		{
			vh.rightlayout.setVisibility(View.VISIBLE);
			vh.leftlayout.setVisibility(View.GONE);
			vh.rightmsg.setText(msg.getContent());
		}
		
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
