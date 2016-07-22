package com.kisita.braiderlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Article> articles = new ArrayList<Article>();
    ArrayAdapter<Article> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView)findViewById(R.id.my_list);

        adapter = new ArrayAdapter<Article>(this,android.R.layout.simple_list_item_1,articles);

        list.setAdapter(adapter);
    }

    public void onClick(View view)
    {
        //System.out.println("Button pressed");
        Article item = new Article();

        EditText article = (EditText)findViewById(R.id.article);
        EditText price = (EditText)findViewById(R.id.price);

        if(article.getText().toString().matches("") || price.getText().toString().matches(""))
        {
            Toast.makeText(this, "Pas de nom d'article ou de prix", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            item.setName(article.getText().toString());
            item.setPrix(price.getText().toString());
        }

        adapter.add(item);

        article.setText("");
        price.setText("");

        //System.out.println(item.getName().toString() + " " + item.getPrix().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Article{
        private String Name;
        private String prix;
        private String Quantité;

        public String getPrix() {
            return prix;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public void setPrix(String prix) {
            this.prix = prix;
        }

        public String toString()
        {
            return getName();
        }
    }
}
