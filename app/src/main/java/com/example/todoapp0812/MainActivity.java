package com.example.todoapp0812;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

        //檢查標題和內容是否為空
        if (title == null || content == null || title.getText().toString().isEmpty() || content.getEditText().getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("錯誤").setMessage("標題和內容不能為空");
            builder.setPositiveButton("確定", null);
            builder.show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確定新增?").setMessage("確定內容並儲存?");
        //按下確定會到TODOLIST
        builder.setPositiveButton("確定", (dialog, which) -> {
            // 跳轉到 TODOLIST 頁面並傳遞數據
            Intent intent = new Intent(this, TODOLIST.class);
            intent.putExtra("title", title.getText().toString());
            intent.putExtra("content", content.getEditText().getText().toString());
            startActivity(intent);
        });
        builder.setNeutralButton("取消", null);
        builder.show();
    }

    //按下返回，回到TODOLIST頁面，跳出alter，按下確定會到TODOLIST，按下取消會回到MainActivity
    public void back(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確定放棄?").setMessage("確定放棄並返回主頁面?");
        //按下確定會到TODOLIST
        builder.setPositiveButton("確定", (dialog, which) -> {
            // 跳轉到 TODOLIST 頁面
            Intent intent = new Intent(this, TODOLIST.class);
            startActivity(intent);
        });
        builder.setNeutralButton("取消", null);
        builder.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //輸入標題與內容後，按下儲存，標題與內容會顯示在TODOLIST的listview上
        EditText title = findViewById(R.id.inpTitle);
        TextInputLayout content = findViewById(R.id.inpTODO);

        //檢查標題和內容是否為空
        if (title == null || content == null || title.getText().toString().isEmpty() || content.getEditText().getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("錯誤").setMessage("標題和內容不能為空");
            builder.setPositiveButton("確定", null);
            builder.show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確定新增?").setMessage("確定內容並儲存?");
        //按下確定會到TODOLIST
        builder.setPositiveButton("確定", (dialog, which) -> {
            // 跳轉到 TODOLIST 頁面
            Intent intent = new Intent(this, TODOLIST.class);
            intent.putExtra("title", title.getText().toString());
            intent.putExtra("content", content.getEditText().getText().toString());
            startActivity(intent);
        });
        builder.setNeutralButton("取消", null);
        builder.show();
    }
}