package mcoppola.trainingbuddy;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeScreen extends ActionBarActivity implements View.OnClickListener
{
    ListView m_goalListView;
    ArrayAdapter<String> m_goalListAdapter;
    ArrayList<String> m_goalList;
    Button m_addToListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        m_addToListButton = (Button) findViewById(R.id.toastButton);
        m_addToListButton.setOnClickListener(this);

        m_goalList = new ArrayList<String>();
        m_goalList.add("First List Item");

        m_goalListView = (ListView) findViewById(R.id.goalListView);
        m_goalListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, m_goalList);
        m_goalListView.setAdapter(m_goalListAdapter);
        setListListener();
    }

    public void onClick(View view)
    {
        m_goalListAdapter.add("My New Entity");
    }

    private void setListListener()
    {
        m_goalListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // view parameter is the underlying TextView Object
                ((TextView) view).setText("Hey, I've just been tapped on!");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_addGoal)
        {
            /*
            Intent intent = new Intent(this, AddViewEdit.class);
            startActivity(intent);*/
            return true;
        }
        else if(id == R.id.action_historyNavBtn)
        {
            Intent intent = new Intent(this, History.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
