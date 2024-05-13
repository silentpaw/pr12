package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button gson_test;
    private TextView gson_fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson_test=findViewById(R.id.gson_btn);
        gson_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createJsonUsingGson();
                parseJsonArrayUsingGson();

            }
        });
    }

    public void parseJsonUsingGson() {
        String jsonStr = "{\"name\":\"Vasiliy\", \"age\":19,\"email\":\"vasilij.sovarenko@bk.ru\"}";
        Gson gson = new Gson();

        User user = gson.fromJson(jsonStr, User.class);

        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
        System.out.println("Email: " + user.email);
    }
    public String createJsonUsingGson() {
        User user = new User();
        user.name = "Sonya";
        user.age = 20;
        user.email = "sonyahz@takjehz.com";

        Gson gson = new Gson();
        String gsonTextView= gson.toJson(user);
        gson_fields = findViewById(R.id.gson_fields);
        gson_fields.setText(gsonTextView);
        return gsonTextView;
    }
    public void parseJsonArrayUsingGson() {
        String jsonArrayStr = "[{\"name\":\"Vasya\", \"age\":19,\"email\":\"vasilij.sovarenko@bk.ru\"}," +
                "{\"name\":\"Sonya\", \"age\":20,\"email\":\"sonyahz@takjehz.com\"}]";
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<User>>(){}.getType();

        List<User> users = gson.fromJson(jsonArrayStr, userListType);

        for (User user : users) {
            System.out.println("Name: " + user.name);
            System.out.println("Age: " + user.age);
            System.out.println("Email: " + user.email);
        }
    }




}