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
		//��ʼ���ҿؼ�
		Button bt_zhuce = (Button) findViewById(R.id.bt_zhuce);
		final EditText et_name = (EditText) findViewById(R.id.et_name);
		final EditText et_password = (EditText) findViewById(R.id.et_password);
		final EditText et_age = (EditText) findViewById(R.id.et_age);
		final RadioGroup rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
		//ע�ᰴť�ĵ���¼�
		bt_zhuce.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				//��ȡ�ı�
				String name = et_name.getText().toString().trim();
				String password = et_password.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				int rg_id = rg_sex.getCheckedRadioButtonId();
				String sex="";
				//ͨ��id�ж�ѡ����Ա�
				switch (rg_id) {
				case R.id.rd_man:
					sex="��";
					break;
				case R.id.rd_woman:
					sex="Ů";
					break;

				default:
					break;
				}
				//�ǿ���֤
				if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)||TextUtils.isEmpty(age)||sex.equals("")){
					Toast.makeText(MainActivity.this, "�벹��������Ϣ��", Toast.LENGTH_SHORT).show();
					return;
				}
				//������ͼ
				Intent intent=new Intent(MainActivity.this, ReceiveActivity.class);
/*				//д�����--��ͨ��ֵ
				intent.putExtra("name", name);
				intent.putExtra("password", password);
				intent.putExtra("age", age);
				intent.putExtra("sex", sex);*/
				
				//Serializable��Parcelable��ֵ���л�����
				 Person p = new Person(name, password, sex, Integer.parseInt(age));
				intent.putExtra("p",p);
				//ִ����ת
				startActivity(intent);
			}
		});
	}
}
