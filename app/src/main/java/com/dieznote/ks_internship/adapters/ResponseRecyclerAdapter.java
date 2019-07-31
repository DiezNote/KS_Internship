package com.dieznote.ks_internship.adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.dieznote.ks_internship.Listeners.OnTaskRecyclerItemClickListener;
import com.dieznote.ks_internship.R;
import com.dieznote.ks_internship.models.NetResponse;
import com.dieznote.ks_internship.models.PokeForms;
import com.dieznote.ks_internship.models.PokeType;
import com.dieznote.ks_internship.models.PokeTypes;
import com.dieznote.ks_internship.utils.Consts;

import java.util.ArrayList;
import java.util.List;

public class ResponseRecyclerAdapter extends CursorRecyclerViewAdapter<ResponseRecyclerAdapter.ViewHolder> {

    private Context ctx;
    private OnTaskRecyclerItemClickListener listener;

    public ResponseRecyclerAdapter(Cursor cursor, Context ctx) {
        super(ctx, cursor);
        this.ctx = ctx;
    }

    public ResponseRecyclerAdapter(Cursor cursor, Context ctx, OnTaskRecyclerItemClickListener listener) {
        super(ctx, cursor);
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public ResponseRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);//todo: исправить
        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(view, viewHolder.getAdapterPosition(), getItem(viewHolder.getAdapterPosition()).getId());
                }
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResponseRecyclerAdapter.ViewHolder holder, Cursor cursor) {
        holder.description.setText("type: " + cursor.getString(cursor.getColumnIndex(Consts.DB_COL_POKE_TYPE)));
        holder.name.setText(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_NAME)));
        Glide.with(holder.avatar).load(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_POKE_AVATAR))).placeholder(R.drawable.ic_account_multiple_grey600_24dp).into(holder.avatar);

    }

    public NetResponse getItem(int position) {

        List<PokeTypes> pt = new ArrayList<PokeTypes>();
        List<PokeForms> pf = new ArrayList<PokeForms>();
        Cursor cursor = getCursor();
        NetResponse item = new NetResponse();

        if (cursor.moveToPosition(position)) {
            item.setId(cursor.getInt(cursor.getColumnIndex(Consts.DB_COL_ID)));
            item.setName(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_NAME)));
            item.setPokeSpecies(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_SPECIES)));
            item.setWeight(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_WEIGHT)));
            item.setHeight(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_HEIGHT)));

            pf.add(new PokeForms(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_URL))));
            item.setPokeForms(pf);
            item.setPokeSprites((cursor.getString(cursor.getColumnIndex(Consts.DB_COL_POKE_AVATAR))));
            pt.add(new PokeTypes(new PokeType(cursor.getString(cursor.getColumnIndex(Consts.DB_COL_POKE_TYPE)))));
            item.setPokeTypes(pt);

        }

        return item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        AppCompatImageView avatar;

        public ViewHolder(View itemView) {
            super(itemView);

            Log.e("TaskRecyclerAdapter", "finding views!");

            description = itemView.findViewById(R.id.tv_desc);
            name = itemView.findViewById(R.id.tv_name);
            avatar = itemView.findViewById(R.id.iv_poke_avatar);

        }
    }

}
