/*
 *
 *  * Created by Murillo Comino on 17/09/19 17:12
 *  * Github: github.com/MurilloComino
 *  * StackOverFlow: pt.stackoverflow.com/users/128573
 *  * Email: murillo_comino@hotmail.com
 *  *
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 17/09/19 16:13
 *
 */

package com.onimus.smarttablayouticon;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.titleA, DemoFragment.class)
                .add(R.string.titleB, DemoFragment.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab);

        final LayoutInflater inflater = LayoutInflater.from(this);
        final Resources res = getResources();

        viewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {

                ImageView icon = (ImageView) inflater.inflate(R.layout.custom_tab_icon, container,
                        false);
                switch (position) {
                    case 0:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_pie_chart_black_24dp, null));
                        break;
                    case 1:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_poll_black_24dp, null));
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }

                return icon;
            }
        });

        viewPagerTab.setViewPager(viewPager);


    }
}
