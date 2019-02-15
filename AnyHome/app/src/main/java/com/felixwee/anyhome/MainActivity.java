package com.felixwee.anyhome;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private List<ResolveInfo> mApps;
    private GridView mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadApps();
        setContentView(R.layout.activity_main);
        mGrid = (GridView) findViewById(R.id.apps_list);
        mGrid.setAdapter(new AppsAdapter());

        mGrid.setOnItemClickListener(listener);
    }

    private OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            ResolveInfo info = mApps.get(position);

            //该应用的包名
            String pkg = info.activityInfo.packageName;
            //应用的主activity类
            String cls = info.activityInfo.name;

            ComponentName componet = new ComponentName(pkg, cls);

            Intent i = new Intent();
            i.setComponent(componet);
            startActivity(i);
        }

    };


    private void loadApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        mApps = getPackageManager().queryIntentActivities(mainIntent, 0);
    }



    public class AppsAdapter extends BaseAdapter {
        public AppsAdapter() {
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i;


            if (convertView == null) {
                i = new ImageView(MainActivity.this);
                i.setScaleType(ImageView.ScaleType.FIT_CENTER);
                i.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            } else {
                i = (ImageView) convertView;
            }

            ResolveInfo info = mApps.get(position);
            i.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));

            return i;
        }

        public final int getCount() {
            return mApps.size();
        }

        public final Object getItem(int position) {
            return mApps.get(position);
        }

        public final long getItemId(int position) {
            return position;
        }
    }

}
