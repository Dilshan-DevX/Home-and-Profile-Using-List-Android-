package com.example.practical5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical5.R;
import com.example.practical5.activity.ProfileActivity;
import com.example.practical5.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter <UserAdapter.ViewHolder> {

    List<User> userList;
    Context context;

    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
       return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTxt.setText(user.getName());
        holder.cityTxt.setText(user.getCity());

        holder.userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("index",position);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder{
            TextView nameTxt;
            TextView cityTxt;
            Button userBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.userNameTxt);
            cityTxt = itemView.findViewById(R.id.userCityTxt);
            userBtn = itemView.findViewById(R.id.button);

        }
    }
}
