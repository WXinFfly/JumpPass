package com.example.jumppass;

import com.example.jumppass.bean.Person;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化找控件
		Button bt_zhuce = (Button) findViewById(R.id.bt_zhuce);
		final EditText et_name = (EditText) findViewById(R.id.et_name);
		final EditText et_password = (EditText) findViewById(R.id.et_password);
		final EditText et_age = (EditText) findViewById(R.id.et_age);
		final RadioGroup rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
		//注册按钮的点击事件
		bt_zhuce.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				//获取文本
				String name = et_name.getText().toString().trim();
				String password = et_password.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				int rg_id = rg_sex.getCheckedRadioButtonId();
				String sex="";
				//通过id判断选择的性别
				switch (rg_id) {
				case R.id.rd_man:
					sex="男";
					break;
				case R.id.rd_woman:
					sex="女";
					break;

				default:
					break;
				}
				//非空验证
				if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)||TextUtils.isEmpty(age)||sex.equals("")){
					Toast.makeText(MainActivity.this, "请补充完整信息！", Toast.LENGTH_SHORT).show();
					return;
				}
				//构建意图
				Intent intent=new Intent(MainActivity.this, ReceiveActivity.class);
/*				//写入参数--普通传值
				intent.putExtra("name", name);
				intent.putExtra("password", password);
				intent.putExtra("age", age);
				intent.putExtra("sex", sex);*/
				
				//Serializable和Parcelable传值序列化对象
				 Person p = new Person(name, password, sex, Integer.parseInt(age));
				intent.putExtra("p",p);
				//执行跳转
				startActivity(intent);
			}
		});
	}
}
