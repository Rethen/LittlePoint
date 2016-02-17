package com.then.littlepoint.model.item.data;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.then.littlepoint.model.item.ModelAdapter;
import com.then.littlepoint.model.item.view.ListViewModel;

/**
 * Created by 42524 on 2015/9/7.
 */
public class Student extends ModelAdapter implements Parcelable {

    @Bindable
    @SerializedName("k_name")
    private  String name;

    @Bindable
    private  int age;

    @Bindable
    private ListViewModel viewModel;

    public  Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public  Student(String name,int age,int viewType){
        this.name=name;
        this.age=age;
        this.viewType=viewType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ListViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };


}
