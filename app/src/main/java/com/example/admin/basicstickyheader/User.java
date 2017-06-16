package com.example.admin.basicstickyheader;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class User extends DataBean {
    private String login;
   // private int id;
   // private String avatar_url;
    private boolean shouldSticky;


    public User(String r1) {
        this.login = r1;
     //   this.id = id;
       // this.avatar_url = avatar_url;
    }

   /* public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.item_user;
    }

    public void setShouldSticky(boolean shouldSticky) {
        this.shouldSticky = shouldSticky;
    }

    @Override
    public boolean shouldSticky() {
        return shouldSticky;
    }




}