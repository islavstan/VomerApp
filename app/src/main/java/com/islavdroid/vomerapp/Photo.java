package com.islavdroid.vomerapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {
    private int photo;

    public Photo(int photo) {
        this.photo = photo;
    }

    protected Photo(Parcel in) {
        photo = in.readInt();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
    }
}
