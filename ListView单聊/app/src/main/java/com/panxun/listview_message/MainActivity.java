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
	private List<Msg> msgList=new ArrayList<>();
	ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		actionBar=getActionBar();
		actionBar.setSubtitle("手机在线-5G");
		initData();
		msgAdapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.mainEditText1);
		send = (Button) findViewById(R.id.mainButtonsend);
		msgListView = (ListView) findViewById(R.id.mainListView1);
		msgListView.setAdapter(msgAdapter);
		send.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					String cont=inputText.getText().toString();
					//如果空不等于编辑框的内容
					if (!"".equals(cont))
					{
						Msg m=new Msg(cont, Msg.TYPE_SENT);
						msgList.add(m);
						msgAdapter.notifyDataSetChanged();//新消息来时刷新
						msgListView.setSelection(msgList.size());
						inputText.setText("");//设置为空
						//inputText.setHint("对方正在输入...");
						actionBar.setSubtitle("对方正在输入...");
						new Thread()
						{
							@Override
							public void run()
							{
								try
								{
									sleep(1500);
									runOnUiThread(new Runnable(){

											@Override
											public void run()
											{
												// TODO: Implement this method
												//inputText.setHint("");
												actionBar.setSubtitle("");
												msgList.add(new Msg("快给我连接服务器",Msg.TYPE_RECEIVED));
												msgAdapter.notifyDataSetChanged();
												msgListView.setSelection(msgList.size());
											}
										});
									
								}
								catch(Exception e)
								{}
							}
						}.start();
					}
				}
			});
    }
	void initData()
	{
		Msg s=new Msg("Hello，gay佬", Msg.TYPE_RECEIVED);
		msgList.add(s);


	}

}
