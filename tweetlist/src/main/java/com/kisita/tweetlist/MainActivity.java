package com.kisita.tweetlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private TextView pseudo;
    //private TextView comment;
    //private ImageView avatar;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.my_list);
        List<Tweet> tweets = genererTweets();
        TweetAdapter adapter = new TweetAdapter(MainActivity.this, tweets);
        mListView.setAdapter(adapter);
    }

    private List<Tweet> genererTweets() {
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
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




    class TweetViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
    }
        class Tweet {
        private int color;
        private String pseudo;
        private String text;

        public Tweet(int color, String pseudo, String text) {
            this.color = color;
            this.pseudo = pseudo;
            this.text = text;
        }

        public int getColor() {
            return color;
        }

        public String getPseudo() {
            return pseudo;
        }

        public String getText() {
            return text;
        }

        public void setPseudo(String pseudo) {
            this.pseudo = pseudo;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public void setText(String text) {
            this.text = text;
        }
        //...setters
    }
    public class TweetAdapter extends ArrayAdapter<Tweet> {

        //tweets est la liste des models à afficher
        public TweetAdapter(Context context, List<Tweet> tweets) {
            super(context, 0, tweets);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tweet,parent, false);
            }

            TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new TweetViewHolder();
                viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
                viewHolder.text = (TextView) convertView.findViewById(R.id.comment);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            Tweet tweet = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.pseudo.setText(tweet.getPseudo());
            viewHolder.text.setText(tweet.getText());
            viewHolder.avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));

            return convertView;
        }

        private class TweetViewHolder{
            public TextView pseudo;
            public TextView text;
            public ImageView avatar;
        }
    }
}
