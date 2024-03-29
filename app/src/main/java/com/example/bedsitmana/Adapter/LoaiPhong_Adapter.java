package com.example.bedsitmana.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bedsitmana.Activity.loaiPhong_Activity;
import com.example.bedsitmana.Dao.LoaiPhongDao;
import com.example.bedsitmana.R;
import com.example.bedsitmana.model.LoaiPhong;

import java.util.ArrayList;
import java.util.List;

public class LoaiPhong_Adapter extends ArrayAdapter<LoaiPhong> {
    TextView txtLoaiPhong,txtPhiDV,txtGiaDien,txtGiaNuoc;
    ImageView btnXoa;
private  Context context;
private  ArrayList<LoaiPhong> list;

    LoaiPhongDao loaiPhongDao;
loaiPhong_Activity loaiphong_activity;



    public LoaiPhong_Adapter(@NonNull Context context, ArrayList<LoaiPhong> list, loaiPhong_Activity loaiphong_activity) {
        super(context,0 ,list);
        this.context = context;
        this.list = list;
        this.loaiphong_activity = loaiphong_activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            v=inflater.inflate(R.layout.item_loaiphong,null);
        }
        final LoaiPhong lp = list.get(position);
        if(lp!=null){
            txtLoaiPhong = v.findViewById(R.id.txtLoaiPhong);
            txtPhiDV = v.findViewById(R.id.txtPhiDichVu);
            txtGiaDien = v.findViewById(R.id.txtGiaDien);
            txtGiaNuoc = v.findViewById(R.id.txtGiaNuoc);
            btnXoa = v.findViewById(R.id.btnDelete);

            txtLoaiPhong.setText("Loại Phòng: "+lp.getTenLoaiPhong());
            txtPhiDV.setText("Phí dịch vụ: "+lp.getPhiDichVu()+"/người");
            txtGiaDien.setText("Giá điện: "+lp.getGiaDien()+"/số");
            txtGiaNuoc.setText("Giá nước: "+lp.getGiaNuoc()+"/người");
            loaiPhongDao=new LoaiPhongDao(context);


            btnXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loaiphong_activity.xoa(String.valueOf(lp.getMaLoaiPhong()));
                }
            });
        }
        return v;
    }

}
