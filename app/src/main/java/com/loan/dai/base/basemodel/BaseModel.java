package com.loan.dai.base.basemodel;


import android.os.Parcel;
import android.os.Parcelable;

public class BaseModel<T> implements IModel, Parcelable {

    public String message;
    public int status;
    public long timestamp;
    public T object;


    protected BaseModel(Parcel in) {
        message = in.readString();
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
    }
}
