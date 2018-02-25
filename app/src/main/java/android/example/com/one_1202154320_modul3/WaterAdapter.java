package android.example.com.one_1202154320_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by One Tika Suryati on 2/24/2018.
 */

class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable; //inisialisasi drawabel
    private ArrayList<Water> mWaterData; //inisialisasi array
    private Context mContext; //inisialisasi context

    /**
     * Constructor that passes in the sports data and the context
     * @param waterData ArrayList containing the sports data
     * @param context Context of the application
     */
    WaterAdapter(Context context, ArrayList<Water> waterData) {
        this.mWaterData = waterData; //ambil nilai water data dari kelas ini
        this.mContext = context; //ambil nilai context dari kelas ini

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext, R.drawable.aqua);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View is added after it is
     *               bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create SportsViewHolder.
     */
    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.daftar_air, parent, false), mGradientDrawable); //mengoper data dari adapter
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {

        //Get the current water
        Water currentWater = mWaterData.get(position);

        //Bind the data to the views
        holder.bindTo(currentWater);
        Glide.with(mContext).load(currentWater.getImageResource()).into(holder.mWaterImage);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mWaterData.size();
    } //get item count dari water data array


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class WaterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //inisialisasi seluruh variabel
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWaterImage;
        private Context mContext;
        private Water mCurrentWater;
        private GradientDrawable mGradientDrawable;

        WaterViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.newsTitle);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mWaterImage = (ImageView)itemView.findViewById(R.id.waterImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater){
            //Populate the textviews with data
            mTitleText.setText(currentWater.getTitle());
            mInfoText.setText(currentWater.getInfo());

            //Get the current water
            mCurrentWater = currentWater;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentWater.
                    getImageResource()).placeholder(mGradientDrawable).into(mWaterImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Water.starter(mContext, mCurrentWater.getTitle(),
                    mCurrentWater.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
