package com.islavdroid.vomerapp;



public class Users {

        private String name;
        private String message;
        private int photo;
        public Users(){}
        public Users(String name,String message,int photo){
            this.name=name;
            this.message=message;
            this.photo = photo;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}

