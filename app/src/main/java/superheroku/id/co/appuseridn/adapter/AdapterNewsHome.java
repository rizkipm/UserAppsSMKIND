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

import superheroku.id.co.appuseridn.model.Rss134NewsHome.DataItemJ134NewsHome;


//ini class untuk memindahkan data ke recylerview dan juga custom recylerview
public class AdapterNewsHome extends RecyclerView.Adapter<AdapterNewsHome.MyHolder> implements ListAdapter {

    List<DataItemJ134NewsHome> data;
    FragmentActivity c;



    public AdapterNewsHome(List<DataItemJ134NewsHome> data, FragmentActivity c) {
        this.data = data;
        this.c = c;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(c).inflate(R.layout.item_pimpinan, parent, false);

        return new MyHolder(inflater);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.txtNama.setText(data.get(position).getNama());
        holder.txtTtl.setText("TTL : " + data.get(position).getTempatLahir() + " / " + data.get(position).getTahunLahir());
        holder.txtPendidikan.setText("Pendidikan : " + data.get(position).getPendidikan());
        holder.txtAlamat.setText("Alamat : " + data.get(position).getAlamat());
        holder.txtJabatan.setText("Jabatan : " + data.get(position).getJabatan());
        holder.txtNamaIstri.setText("Istri : " + data.get(position).getIstri());
        holder.txtPeriode.setText("Periode : " + data.get(position).getPeriode());

        Glide.with(c)
                .load(MyConstant.IMAGE_PIMPINAN + data.get(position).getFoto())
                .placeholder(R.drawable.bannerkolakakab1)
                .override(125, 125)
                .error(R.drawable.bannerkolakakab1)
                .into(holder.imgPimpinan);


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a1 = new Intent(c, BarActivityIndikator.class);
                a1.putExtra("posisi",position);
                c.startActivity(a1);




//
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


        TextView txtNama, txtTtl, txtPendidikan,txtAlamat,txtNamaIstri,txtJabatan,txtPeriode;
        CardView card ;
        ImageView imgPimpinan;

        public MyHolder(View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtTtl = (TextView) itemView.findViewById(R.id.txtTtl);
            txtPendidikan = (TextView) itemView.findViewById(R.id.txtPendidikan);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
            txtNamaIstri = (TextView) itemView.findViewById(R.id.txtNamaIstri);
            txtJabatan = (TextView) itemView.findViewById(R.id.txtJabatan);
            txtPeriode = (TextView) itemView.findViewById(R.id.txtPeriode);
            imgPimpinan = (ImageView) itemView.findViewById(R.id.imgPimpinan);
//
            card = itemView.findViewById(R.id.card_view);



        }
    }


}
