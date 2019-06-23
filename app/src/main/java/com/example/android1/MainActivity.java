package com.example.android1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.android1.base.BaseActivity;
import com.example.android1.fragmeenter.AboutFragment;
import com.example.android1.fragmeenter.CollectFragment;
import com.example.android1.fragmeenter.FragmentUtils;
import com.example.android1.fragmeenter.GankFragment;
import com.example.android1.fragmeenter.GoldFragment;
import com.example.android1.fragmeenter.SettingFragment;
import com.example.android1.fragmeenter.SreachFragment;
import com.example.android1.fragmeenter.V2EXFragment;
import com.example.android1.fragmeenter.WeCharFragment;
import com.example.android1.fragmeenter.ZhihuFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.Tool)
    Toolbar mTool;
    @BindView(R.id.Frame)
    FrameLayout mFrame;
    @BindView(R.id.Nv)
    NavigationView mNv;
    @BindView(R.id.Dreaw)
    DrawerLayout mDreaw;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;

    private ArrayList<Fragment> fm;
    private ArrayList<Integer> title;
    private FragmentManager fram;
    private int last = 0;
    private MenuItem mSearchViewItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        initTitle();
        initTool();
        initFragment();
        fram = getSupportFragmentManager();
    }

    private void initTitle() {
        title = new ArrayList<>();
        title.add(R.string.zhihu);
        title.add(R.string.wechat);
        title.add(R.string.gank);
        title.add(R.string.gold);
        title.add(R.string.v2ex);
        title.add(R.string.collection);
        title.add(R.string.setting);
        title.add(R.string.about);
    }

    private void initTool() {
        mTool.setTitle(title.get(0));
        setSupportActionBar(mTool);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDreaw, mTool, R.string.app_name, R.string.app_name);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDreaw.addDrawerListener(toggle);
        toggle.syncState();

    }

    private void initFragment() {
        fm = new ArrayList<>();
        fm.add(new ZhihuFragment());
        fm.add(new WeCharFragment());
        fm.add(new GankFragment());
        fm.add(new GoldFragment());
        fm.add(new V2EXFragment());
        fm.add(new CollectFragment());
        fm.add(new SettingFragment());
        fm.add(new AboutFragment());
    }

    @Override
    protected void initlistener() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //设置当前条目为选中状态
                item.setChecked(true);
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.zhihu:
                        initTiao(0);
                        FragmentUtils.addFragment(fram,ZhihuFragment.class,R.id.Frame);
                        break;
                    case R.id.wechat:

                        initTiao(1);
                        FragmentUtils.addFragment(fram,WeCharFragment.class,R.id.Frame);
                        break;
                    case R.id.gank:
                        initTiao(2);
                        FragmentUtils.addFragment(fram,GankFragment.class,R.id.Frame);
                        break;
                    case R.id.gold:
                        initTiao(3);
                        FragmentUtils.addFragment(fram,GoldFragment.class,R.id.Frame);
                        break;
                    case R.id.v2ex:
                        initTiao(4);
                        FragmentUtils.addFragment(fram,V2EXFragment.class,R.id.Frame);
                        break;
                    case R.id.collection:
                        initTiao(5);
                        FragmentUtils.addFragment(fram,CollectFragment.class,R.id.Frame);
                        break;
                    case R.id.setting:
                        initTiao(6);
                        FragmentUtils.addFragment(fram,SettingFragment.class,R.id.Frame);
                        break;
                    case R.id.about:
                        initTiao(7);
                        FragmentUtils.addFragment(fram,AboutFragment.class,R.id.Frame);
                        break;
                }
                //侧滑关闭
                mDreaw.closeDrawer(Gravity.LEFT);
                return false;
            }

            private void initTiao(int type) {
               /* FragmentTransaction t1 = fram.beginTransaction();
                //判断是否已经添加过
                Fragment fragment = fm.get(type);
                if (!fragment.isAdded()) {
                    t1.add(R.id.Frame, fragment);
                }
                //上个页面
                Fragment fragment1 = fm.get(last);
                t1.hide(fragment1);
                t1.show(fragment);
                t1.commit();*/
                //记录上个页面对应的索引位置
                //显示相应位置的搜索
                if (type == 1 || type == 2){
                    mSearchViewItem.setVisible(true);
                }else {
                    mSearchViewItem.setVisible(false);
                }

                last = type;
                //ToolBar切换
                mTool.setTitle(title.get(type));
            }
        });

        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展开
                Toast.makeText(MainActivity.this, "搜索框展开", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框折叠
                Toast.makeText(MainActivity.this, "搜索框折叠", Toast.LENGTH_SHORT).show();
                //关闭退回站
                fram.popBackStack();
            }
        });

        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                final Bundle bundle = new Bundle();
                bundle.putString("abc",query);

                if (last == 1 ){
                    FragmentUtils.addFragment(fram,SreachFragment.class,R.id.Frame,bundle,true);
                }else if (last==2){
                    FragmentUtils.addFragment(fram,GankFragment.class,R.id.Frame,bundle,true);
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_layout,menu);
        mSearchViewItem = menu.findItem(R.id.search);
        //隐藏menu,搜索框就不见了,想要搜索框不见只能使用mSearchViewItem
        mSearchViewItem.setVisible(false);
        mSearchView.setMenuItem(mSearchViewItem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()){
            mSearchView.closeSearch();
        }else {
            super.onBackPressed();
        }

    }
}
