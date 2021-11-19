package com.example.move;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.RecyclerViewHolders>{

    private ArrayList<Movie> mMovieList;
    private LayoutInflater mInflate;
    private Context mContext;

    //constructor
    public MyRecyclerViewAdapter(Context context, ArrayList<Movie> itemList) {
        this.mContext = context;
        this.mInflate = LayoutInflater.from(context);
        this.mMovieList = itemList;
    }

    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.list_item, parent, false);
        RecyclerViewHolders viewHolder = new RecyclerViewHolders(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders holder, @SuppressLint("RecyclerView") final int position) {

        String url ="https://image.tmdb.org/t/p/w500"+mMovieList.get(position).getPoster_path();
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
        String title2= mMovieList.get(position).getTitle();
        holder.titleView.setText(title2);
        String release2=mMovieList.get(position).getRelease_date();
        holder.releaseView.setText("개봉일 :\n"+release2);
        String average= mMovieList.get(position).getVote_average();
        holder.voteView.setText("평점 : "+average);

        //각 아이템 클릭 이벤트
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("title", mMovieList.get(position).getTitle());
                intent.putExtra("original_title", mMovieList.get(position).getOriginal_title());
                intent.putExtra("poster_path", "https://image.tmdb.org/t/p/w500"+mMovieList.get(position).getPoster_path());
                intent.putExtra("overview", mMovieList.get(position).getOverview());
                intent.putExtra("release_date", mMovieList.get(position).getRelease_date());
                mContext.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return this.mMovieList.size();
    }


    //뷰홀더 - 따로 클래스 파일로 만들어도 된다.
    public static class RecyclerViewHolders extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleView;
        public TextView releaseView;
        public TextView voteView;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleView=(TextView)itemView.findViewById(R.id.t_title);
            releaseView=(TextView)itemView.findViewById(R.id.t_release_date);
            voteView=(TextView) itemView.findViewById(R.id.t_vote_average);
        }
    }

}
