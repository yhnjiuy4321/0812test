package com.example.todoapp0812;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //輸入標題與內容後，按下儲存，標題與內容會顯示在TODOLIST頁面上
    public void save(View view){
        EditText title = findViewById(R.id.inpTitle);
        TextInputLayout content = findViewById(R.id.inpTODO);
        LinearLayout todolist = findViewById(R.id.listbox);

        //新增一個TextView
        TextView todo = new TextView(this);
        todo.setText(title.getText().toString() + "\n" + content.getEditText().getText().toString());
        todolist.addView(todo);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確定新增?").setMessage("確定內容並儲存?");
        builder.setPositiveButton("確定", null);
        builder.setNeutralButton("取消", null);
        builder.show();

    }
    //按下返回，回到TODOLIST頁面，跳出alter，按下確定會到TODOLIST，按下取消會回到MainActivity
    public void back(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確定放棄?").setMessage("確定放棄並返回主頁面?");
        builder.setPositiveButton("確定", null);
        builder.setNeutralButton("取消", null);
        builder.show();
    }
}