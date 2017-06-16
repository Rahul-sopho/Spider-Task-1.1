package com.example.rahul.spidertask11;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView L1;
    EditText E1, E2;
    String itemName;
    int i=0,pos;
    Button addB, removeB;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addB = (Button) findViewById(R.id.add);
        removeB = (Button) findViewById(R.id.remove);
        L1 = (ListView) findViewById(R.id.list);
        E1=(EditText)findViewById(R.id.edit);
        E2=(EditText)findViewById(R.id.edit1);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_list, arrayList);
        L1.setAdapter(arrayAdapter);

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem();
            }
        });

        removeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItem();
            }
        });

        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("item",arrayList.get(position));
                startActivity(intent);



            }
        });



    }

    public void addItem()
    {
            itemName = E1.getText().toString();
            if (itemName.length() > 0) {
                arrayList.add(itemName);
                arrayAdapter.notifyDataSetChanged();
                i++;
                E1.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Please Enter the task", Toast.LENGTH_LONG).show();
            }
    }




    public void removeItem()
    {
        if(E2.getText().toString().length()>0) {
            pos = Integer.parseInt(E2.getText().toString());
            if (pos <= i && pos > 0) {
                arrayList.remove(pos - 1);
                arrayAdapter.notifyDataSetChanged();
                i--;
                E2.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Please enter correct position", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please enter the position",Toast.LENGTH_LONG).show();
        }


    }
}

