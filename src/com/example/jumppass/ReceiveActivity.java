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
		//Parcelable��ȡ���л�����
		Person  p= (Person) intent.getParcelableExtra("p");
		//Serializable��ȡ���л�����
//		Person  p= (Person) intent.getSerializableExtra("p");
		
		//��ͨ��ֵ
		/*String name = intent.getStringExtra("name");
		String password = intent.getStringExtra("password");
		String age = intent.getStringExtra("age");
		String sex = intent.getStringExtra("sex");*/
		TextView tv_content = (TextView) findViewById(R.id.tv_content);
		tv_content.setText("������"+p.getName()+"\n���룺"+p.getPassword()+"\n���䣺"+p.getAge()+"\n�Ա�"+p.getSex());
	}
}
