package com.torerov.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2015-10-08.
 */
public class MyPagerAdapter extends PagerAdapter {

    List<View> scrappedView = new ArrayList<View>();

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        View view = View.inflate(container.getContext(), R.layout.view_item)
        View view;
        if (scrappedView.size() > 0){
            view = scrappedView.remove(0);
        }else {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_item, container, false);
        }
        TextView tv = (TextView)view.findViewById(R.id.text_number);
        tv.setText("num : " + position);
        container.addView(view);
        return view;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.5f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object); //슈퍼 호출하면 안됨
        View view = (View)object;
        container.removeView(view);
        scrappedView.add(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
