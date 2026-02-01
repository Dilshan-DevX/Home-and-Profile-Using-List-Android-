package com.example.practical5.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical5.R;
import com.example.practical5.adapter.UserAdapter;
import com.example.practical5.entity.User;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Window window = getWindow();
        View decoView = window.getDecorView();

        WindowInsetsControllerCompat controler = new WindowInsetsControllerCompat(window,decoView);
        controler.setAppearanceLightStatusBars(true);

        userList.add(new User("John Doe","New York"));
        userList.add(new User("Jack Smith","Los Angeles"));
        userList.add(new User("Bob Johnson","Chicago"));
        userList.add(new User("Alice Brown","Houston"));
        userList.add(new User("Tom Wilson","Philadelphia"));
        userList.add(new User("Emily Davis","San Francisco"));
        userList.add(new User("David Lee","Seattle"));
        userList.add(new User("Sarah Garcia","Miami"));
        userList.add(new User("Michael Martinez","Dallas"));
        userList.add(new User("Jessica Hernandez","Boston"));




        RecyclerView recyclerView = findViewById(R.id.rectcleView);

        LinearLayoutManager m = new LinearLayoutManager(HomeActivity.this);
        m.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(m);

        UserAdapter userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);



    }
}