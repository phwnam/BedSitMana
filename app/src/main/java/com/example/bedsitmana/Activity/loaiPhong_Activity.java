package com.example.bedsitmana.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bedsitmana.Adapter.LoaiPhong_Adapter;
import com.example.bedsitmana.Dao.LoaiPhongDao;
import com.example.bedsitmana.R;
import com.example.bedsitmana.model.LoaiPhong;

import java.util.ArrayList;

public class loaiPhong_Activity extends AppCompatActivity {
    ListView lstLoaiPhong;
    ArrayList<LoaiPhong> list;
    LoaiPhong_Adapter adapter;
    LoaiPhong item;
    LoaiPhongDao dao;
    ImageView btnAdd;
    EditText edtmaLoai, edttenLoai, edtPhidv, edtTienDien, edtTienNuoc;
    Button btnHuy, btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_phong);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Loại Phòng");

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lstLoaiPhong = findViewById(R.id.lstLoaiPhong);
        dao = new LoaiPhongDao(loaiPhong_Activity.this);
        capNhatLv();
        btnAdd = findViewById(R.id.btnadd_toolbar);
        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          opendialog(loaiPhong_Activity.this, 0);
                                      }
                                  }
        );
        lstLoaiPhong.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = list.get(i);
                opendialog(loaiPhong_Activity.this, 1);
                return false;
            }
        });

    }

    public void opendialog(Context context, int type) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_loai_phong);
        edtmaLoai = dialog.findViewById(R.id.edtMaLoaiPhong);
        edttenLoai = dialog.findViewById(R.id.edtTenLoaiPhong);
        edtPhidv = dialog.findViewById(R.id.edtPhiDichVu);
        edtTienDien = dialog.findViewById(R.id.edtTienDien);
        edtTienNuoc = dialog.findViewById(R.id.edtTienNuoc);
        btnHuy = dialog.findViewById(R.id.btnHuy);
        btnXacNhan = dialog.findViewById(R.id.btnXacNhan);
        edtmaLoai.setEnabled(false);
        if (type != 0) {
            edtmaLoai.setText(item.getMaLoaiPhong() + "");
            edttenLoai.setText(item.getTenLoaiPhong());
            edtPhidv.setText(item.getPhiDichVu() + "");
            edtTienDien.setText(item.getGiaDien() + "");
            edtTienNuoc.setText(item.getGiaNuoc() + "");
        }
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edttenLoai.getText().toString()) || TextUtils.isEmpty(edtPhidv.getText().toString()) || TextUtils.isEmpty(edtTienNuoc.getText().toString()) || TextUtils.isEmpty(edtTienNuoc.getText().toString())) {
                    Toast.makeText(context, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int pdv = Integer.parseInt(edtPhidv.getText().toString());
                    if (pdv <= 0) {
                        Toast.makeText(context, "Phí dịch vụ phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "Phí dịch vụ phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int dien = Integer.parseInt(edtTienDien.getText().toString());
                    if (dien <= 0) {
                        Toast.makeText(context, "Tiền điện phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "Tiền điện phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int nuoc = Integer.parseInt(edtTienNuoc.getText().toString());
                    if (nuoc <= 0) {
                        Toast.makeText(context, "Tiền nước phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "Tiền nước phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }
                item = new LoaiPhong();
                item.setTenLoaiPhong(edtPhidv.getText().toString());
                item.setPhiDichVu(Integer.parseInt(edtPhidv.getText().toString()));
                item.setGiaDien(Integer.parseInt(edtTienDien.getText().toString()));
                item.setGiaNuoc(Integer.parseInt(edtTienNuoc.getText().toString()));
                if (type == 0) {
                    if (dao.insert(item) > 0) {
                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    item.setMaLoaiPhong(Integer.parseInt(edtmaLoai.getText().toString()));
                    if (dao.update(item) > 0) {
                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

                capNhatLv();
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public void xoa(String Id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cảnh báo");
        builder.setIcon(R.drawable.baseline_warning_24);
        builder.setMessage("Bạn có chắc chắn muốn xoá");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dao.delete(Id);
                capNhatLv();
                dialogInterface.cancel();
                Toast.makeText(loaiPhong_Activity.this, "Xóa thành công ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        builder.show();
    }

    public void capNhatLv() {
        list = (ArrayList<LoaiPhong>) dao.getAll();
        adapter = new LoaiPhong_Adapter(loaiPhong_Activity.this, list, this);
        lstLoaiPhong.setAdapter(adapter);
    }
}