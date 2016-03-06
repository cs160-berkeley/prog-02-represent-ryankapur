//package com.cs160.ryykap.represent_final;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//class CustomAdapter extends ArrayAdapter<String> {
//
//    //Declarations
//    String[] names = {};
//
//    CustomAdapter(Context context, String[] foods) {
//        super(context, R.layout.custom_row ,foods);
//    }
//
//    public class ViewHolder {
//        TextView name;
//        TextView twitter;
//        ImageView img;
//
//    }
//
////    @Override
////    //Cited source: https://thenewboston.com/forum/topic.php?id=3686
////    public View getView(int position, View convertView, ViewGroup parent) {
////        LayoutInflater myInflater = LayoutInflater.from(getContext());
////        View customView = myInflater.inflate(R.layout.custom_row, parent, false);
////
////        String singleName = getItem(position);
////        TextView cText = (TextView) customView.findViewById(R.id.name);
////        ImageView cImage = (ImageView) customView.findViewById(R.id.imageView);
////
////        cText.setText(singleName);
////        cImage.setImageResource(R.drawable.merkley);
////        return customView;
////    }
//}