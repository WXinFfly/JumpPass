package com.example.jumppass.bean;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

//Serializable传值只需要实现接口 Serializable
public class Person implements Parcelable {
	
	public Person(Parcel in) {
		super();
		name=in.readString();
		password=in.readString();
		sex=in.readString();
		age=in.readInt();
	}
	public Person(String name, String password, String sex, int age) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}
	private String name;
	private String password;
	private String sex;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int describeContents() {
		return 0;
	}
	//输出参数
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(password);
		dest.writeString(sex);
		dest.writeInt(age);
	}
	//Parcelable方式传值
	public static Parcelable.Creator<Person> CREATOR=new Creator<Person>() {
		
		public Person[] newArray(int size) {
			return new Person[size];
		}
		
		public Person createFromParcel(Parcel in) {
			return new Person(in);
		}
	};
	
}
