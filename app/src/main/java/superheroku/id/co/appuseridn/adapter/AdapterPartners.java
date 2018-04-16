package superheroku.id.co.appuseridn.adapter;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import superheroku.id.co.appuseridn.R;
import superheroku.id.co.appuseridn.helper.MyConstant;
import superheroku.id.co.appuseridn.model.RssGet164Partners.DataItem164Partners;

//ini class untuk memindahkan data ke recylerview dan juga custom recylerview
public class AdapterPartners extends RecyclerView.Adapter<AdapterPartners.MyHolder> implements ListAdapter {

    List<DataItem164Partners> data;
    FragmentActivity c;



    public AdapterPartners(List<DataItem164Partners> data, FragmentActivity c) {
        this.data = data;
        this.c = c;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(c).inflate(R.layout.item_partners, parent, false);

        return new MyHolder(inflater);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.txJudul.setText(data.get(position).getNamaPartners());
//        holder.txHarga.setText("Rp. " + data.get(position).getHargaAwalLelang());
//
//
        Glide.with(c)
                .load(MyConstant.IMAGE_URL + data.get(position).getIconPartners())
                .placeholder(R.drawable.no_image)
                .override(125, 125)
                .error(R.drawable.no_image)
                .into(holder.imgGambar);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        TextView txJudul, txHarga, tvAlamat;
        CardView card ;
        ImageView imgGambar;

        public MyHolder(View itemView) {
            super(itemView);

            txJudul = (TextView) itemView.findViewById(R.id.grid_item_title);
//            txHarga = (TextView) itemView.findViewById(R.id.harga);
//            tvAlamat = (TextView) itemView.findViewById(R.id.tvItemVolunter);
            imgGambar = (ImageView) itemView.findViewById(R.id.grid_item_image);
//
            card = itemView.findViewById(R.id.card_view);



        }
    }


}
