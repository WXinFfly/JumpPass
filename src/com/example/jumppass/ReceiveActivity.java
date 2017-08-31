package com.example.jumppass;

import java.io.Serializable;

import com.example.jumppass.bean.Person;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ReceiveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receive);
		Intent intent = getIntent();
		//Parcelable获取序列化对象
		Person  p= (Person) intent.getParcelableExtra("p");
		//Serializable获取序列化对象
//		Person  p= (Person) intent.getSerializableExtra("p");
		
		//普通传值
		/*String name = intent.getStringExtra("name");
		String password = intent.getStringExtra("password");
		String age = intent.getStringExtra("age");
		String sex = intent.getStringExtra("sex");*/
		TextView tv_content = (TextView) findViewById(R.id.tv_content);
		tv_content.setText("姓名："+p.getName()+"\n密码："+p.getPassword()+"\n年龄："+p.getAge()+"\n性别："+p.getSex());
	}
}
