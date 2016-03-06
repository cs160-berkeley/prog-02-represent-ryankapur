package com.cs160.ryykap.represent_final;

import android.content.Context;
import android.support.wearable.view.GridPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SampleGridPageAdapter extends GridPagerAdapter {

    private final Context mContext;
    private List mRows;
    Page [][] pages;


    public SampleGridPageAdapter(Context ctx) {
        mContext = ctx;
        pages = new Page[3][1];
        instantiatePages();
    }

    //Simple container for static data in each page
    private static class Page {
        // static resources
        String name;
        int image;
        String type;
        String party;
    }

    public class ViewHolder {
        TextView name;
        ImageView image;
        TextView type;
        TextView party;
    }

    Data.Rep rep;
    public void instantiatePages() {
        String [] ppl = {"jeff", "john", "suzanne" };
        for (int i = 0; i < 3; i++) {
            Page p = new Page();
            if (i == 0 ){
                rep = DummyData.jeff;
                p.image = R.drawable.merkley;
            } else if (i == 1 ){
                rep = DummyData.john;
                p.image = R.drawable.wyden;
            } else if (i == 2) {
                rep = DummyData.suzanne;
                p.image = R.drawable.s_bonamici;
            }
            p.name = rep.getName();
            p.image = R.drawable.merkley;
            p.type = rep.getType();
            p.party = rep.getParty();
            pages[i][0] = p;
        }
    }

    @Override
    public int getRowCount() {
        return pages.length;
    }

    @Override
    public int getColumnCount(int i) {
        return pages[i].length;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int row, int col) {
        View v = View.inflate(mContext, R.layout.page, null);

        //my viewHolder object
        ViewHolder h = new ViewHolder();

        //initialize views
        h.image = (ImageView) v.findViewById(R.id.img);
        h.name = (TextView) v.findViewById(R.id.name);
        h.type = (TextView) v.findViewById(R.id.type);
        h.party = (TextView) v.findViewById(R.id.party);

        //set info
        h.image.setImageResource(pages[row][col].image);
        h.name.setText(pages[row][col].name);
        h.type.setText(pages[row][col].type);
        h.party.setText(pages[row][col].party);

        viewGroup.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, int i1, Object o) {
        viewGroup.removeView((View) o);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view.equals(o);
    }




}




