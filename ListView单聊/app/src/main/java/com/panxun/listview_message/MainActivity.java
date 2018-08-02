package com.panxun.listview_message;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends Activity 
{
	private ListView msgListView;
	private EditText inputText;
	private Button send;
	private MsgAdapter msgAdapter;
	private List<Msg> msgList=new ArrayList<Msg>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		msgAdapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
		inputText=(EditText) findViewById(R.id.mainEditText1);
		send=(Button) findViewById(R.id.mainButtonsend);
		msgListView=(ListView) findViewById(R.id.mainListView1);
		msgListView.setAdapter(msgAdapter);
		send.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					String cont=inputText.getText().toString();
					//如果空不等于编辑框的内容
					if(!"".equals(cont))
					{
						Msg m=new Msg(cont,Msg.TYPE_SENT);
						msgList.add(m);
						msgAdapter.notifyDataSetChanged();//新消息来时刷新
						msgListView.setSelection(msgList.size());
						inputText.setText("");//设置为空
					}
				}
			});
    }
	
}
