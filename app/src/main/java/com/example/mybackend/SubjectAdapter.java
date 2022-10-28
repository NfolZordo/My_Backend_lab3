package com.example.mybackend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter  extends ArrayAdapter<Subject> {
    List<Subject> contactList;
    Context       context;
    private LayoutInflater mInflater;

    // Constructors
    public SubjectAdapter(Context context, List<Subject> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public Subject getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Subject item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewTeacherName.setText(item.getFacultyName());
//        Picasso.get().load(item.getTeacherName()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final TextView       textViewName;
        public final TextView       textViewFacultyName;
        public final TextView       textViewTeacherName;

        private ViewHolder(RelativeLayout rootView, TextView textViewName, TextView textViewFacultyName, TextView textViewTeacherName) {
            this.rootView = rootView;
            this.textViewName = textViewName;
            this.textViewFacultyName = textViewFacultyName;
            this.textViewTeacherName = textViewTeacherName;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewFacultyName = (TextView) rootView.findViewById(R.id.textViewFacultyName);
            TextView textViewTeacherName = (TextView) rootView.findViewById(R.id.textViewTeacherName);
            return new ViewHolder(rootView, textViewName, textViewFacultyName, textViewTeacherName);
        }
    }
}
