package sg.edu.rp.c346.id20022678.ourndpsongs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStar = rowView.findViewById(R.id.textViewStars);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);

        Song currentSong = songList.get(position);

        ImageView imageView = rowView.findViewById(R.id.imageViewNew);
        if(currentSong.getYearReleased() >= 2019) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.d);
        }
        else {
            imageView.setVisibility(View.INVISIBLE);
        }

        tvTitle.setText(currentSong.getTitle());
        tvTitle.setTextColor(R.color.purple);
        String strYear = String.valueOf(currentSong.getYearReleased());
        tvYear.setText(" " + strYear + " ");
        if (currentSong.getStars() == 1){
            tvStar.setText("*");
        }
        else if (currentSong.getStars() == 2){
            tvStar.setText("**");
        }
        else if (currentSong.getStars() == 3){
            tvStar.setText("***");
        }
        else if (currentSong.getStars() == 4){
            tvStar.setText("****");
        }
        else if (currentSong.getStars() == 5){
            tvStar.setText("*****");
        }
        tvStar.setTextColor(Color.RED);
        tvSinger.setText(currentSong.getSingers());

        return rowView;
    }

}
