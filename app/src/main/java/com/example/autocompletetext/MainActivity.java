package com.example.autocompletetext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private AutoCompleteTextView text1;
    private MultiAutoCompleteTextView text2;
    private String[] list;
    private Button colorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.autoCompleteTextView);
        text2 = findViewById(R.id.multiAutoCompleteTextView);
        colorBtn = findViewById(R.id.btnColor);
        list = getResources().getStringArray(R.array.auto);
        text1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));
        text2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));
        text1.addTextChangedListener(this);
        text2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        text2.addTextChangedListener(this);
        registerForContextMenu(colorBtn);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mfile:
                Toast.makeText(MainActivity.this, "Select file",Toast.LENGTH_LONG).show();
                break;
            case R.id.mphone:
                Toast.makeText(MainActivity.this,"Select phone", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                Toast.makeText(MainActivity.this, "Select file",Toast.LENGTH_LONG).show();
                break;
            case R.id.green:
                Toast.makeText(MainActivity.this,"Select phone", Toast.LENGTH_LONG).show();
                break;
            case R.id.blue:
                System.exit(0);
        }
        return super.onContextItemSelected(item);
    }
}