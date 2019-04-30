package com.zic.diemdanhapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.model.NguoiDung;

import java.util.List;


public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.MyViewHolder> {


    private Context mContext;
    private List<NguoiDung> mData;


    public NguoiDungAdapter(Context mContext, List<NguoiDung> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.single_item,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textMa.setText(mData.get(position).getManguoidung());
        holder.textTen.setText(mData.get(position).getTennguoidung());
        holder.textHinh.setText(mData.get(position).getHinh());
        holder.textNgaySinh.setText(mData.get(position).getNgaysinh());
        holder.textGioiTinh.setText(mData.get(position).getGioitinh());
        holder.textTenLop.setText(mData.get(position).getTenlop());
        holder.textTrinhDo.setText(mData.get(position).getTrinhdo());
        holder.textChucVu.setText(mData.get(position).getChucvu());
        holder.textTenKhoa.setText(mData.get(position).getTenkhoa());
        holder.textMatKhau.setText(mData.get(position).getMatkhau());
        holder.textStatus.setText(mData.get(position).getStat());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textMa;
        TextView textTen;
        TextView textHinh;
        TextView textNgaySinh;
        TextView textGioiTinh;
        TextView textTenLop;
        TextView textTrinhDo;
        TextView textChucVu;
        TextView textTenKhoa;
        TextView textMatKhau;
        TextView textStatus;


        public MyViewHolder(View itemView) {
            super(itemView);

            textMa = itemView.findViewById(R.id.main_ma);
            textTen = itemView.findViewById(R.id.main_ten);
            textHinh = itemView.findViewById(R.id.main_hinh);
            textNgaySinh = itemView.findViewById(R.id.main_ngaysinh);
            textGioiTinh = itemView.findViewById(R.id.main_gioitinh);
            textTenLop = itemView.findViewById(R.id.main_tenlop);
            textTrinhDo = itemView.findViewById(R.id.main_trinhdo);
            textChucVu = itemView.findViewById(R.id.main_chucvu);
            textTenKhoa = itemView.findViewById(R.id.main_tenkhoa);
            textMatKhau = itemView.findViewById(R.id.main_matkhau);
            textStatus = itemView.findViewById(R.id.main_status);
        }
    }
}
