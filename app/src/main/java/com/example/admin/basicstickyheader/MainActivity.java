package com.example.admin.basicstickyheader;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

import static com.example.admin.basicstickyheader.R.*;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    StickyHeaderViewAdapter adapter;
    Random random = new Random(System.currentTimeMillis());

    private ArrayList<DataBean> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        initView();
        userList = new ArrayList<>();
        GenerateUserList();
        adapter = new StickyHeaderViewAdapter(userList)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
    }

    /*private void initData() {
        Gson gson = new Gson();
        Result result = gson.fromJson(User.dataSource, Result.class);
        Log.d("JsonData", User.dataSource);

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareToIgnoreCase(o2.getLogin());
            }
        });
        List<DataBean> userListBak = new ArrayList<>();
        String currentPrefix = userList.get(0).getLogin().substring(0, 1).toUpperCase();
        userListBak.add(new ItemHeader(currentPrefix));
        for (User user : userList) {
            if (currentPrefix.compareToIgnoreCase(user.getLogin().substring(0, 1)) == 0)
                userListBak.add(user);
            else {
                currentPrefix = user.getLogin().substring(0, 1).toUpperCase();
                userListBak.add(new ItemHeader(currentPrefix));
                userListBak.add(user);
            }
        }
        adapter = new StickyHeaderViewAdapter(userListBak)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
    }*/

    private void initView() {
        rv = (RecyclerView) findViewById(id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_add_view:
//                User user = new User("Sticky View", 123, "https://avatars.githubusercontent.com/u/15800681?v=3");
//                user.setShouldSticky(random.nextBoolean());
//                adapter.append(user);
//                break;
//            case R.id.action_clear_all:
//                adapter.clear(rv);
//                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void GenerateUserList() {
        userList.add(new ItemHeader("h1"));
        userList.add(new User("r1"));
        userList.add(new User("r2"));
        userList.add(new User("r3"));
        userList.add(new User("r4"));
        userList.add(new User("r5"));
        userList.add(new User("r6"));
        userList.add(new User("r7"));
        userList.add(new User("r8"));
        userList.add(new User("r9"));
        userList.add(new User("r10"));
        userList.add(new User("r12"));
        userList.add(new User("r13"));
        userList.add(new User("r14"));
       /* userList.add(new User("login69", 1, "http://www.something.com"));
        userList.add(new User("login610", 1, "http://www.something.com"));
        userList.add(new User("login611", 1, "http://www.something.com"));*/
        userList.add(new ItemHeader("h2"));
        userList.add(new User("r1"));
        userList.add(new User("r2"));
        userList.add(new User("r3"));
        userList.add(new User("r4"));
        userList.add(new User("r5"));
        userList.add(new User("6"));
        userList.add(new User("r7"));
        userList.add(new User("r8"));
        userList.add(new User("r9"));
        userList.add(new User("r10"));
        userList.add(new User("r12"));
        userList.add(new User("r13"));
        userList.add(new User("r14"));
       /* userList.add(new User("name3", 2, "http://www.something.com"));
        userList.add(new User("name4", 2, "http://www.something.com"));
        userList.add(new User("name5", 2, "http://www.something.com"));
        userList.add(new User("name6", 2, "http://www.something.com"));
        userList.add(new User("name7", 2, "http://www.something.com"));
        userList.add(new User("qqqqq", 33,"http://www.something.com"));*/
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            rv.setLayoutManager(layoutManager);
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setAdapter(adapter);

            GenerateUserList();

        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

            ((GridLayoutManager)layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    Log.d("layoutManager",adapter.getItemViewType(position)+"");
                    switch(adapter.getItemViewType(position)){
                        case (R.layout.header):
                            return 2;
                        case(layout.item_user):
                            return 1;
                        default:
                            return -1;
                    }
                }
            });
            rv.setLayoutManager(layoutManager);
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setAdapter(adapter);

            GenerateUserList();
        }
    }

}
