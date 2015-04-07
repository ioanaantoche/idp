package ipd.prototype;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	private List<String> tempMessages = new ArrayList<String>();

	private class ButtonListeners implements Button.OnClickListener {

		private void addTempMessage() {
			String messageToSend = 
					((EditText) findViewById(R.id.userMessage)).toString().trim();
			if (messageToSend == null || messageToSend.length() == 0) {
				Toast.makeText(getApplicationContext(),
						"cannot add an empty message",Toast.LENGTH_LONG).show();
				return;
			}
			if (tempMessages.contains(messageToSend)) {
				Toast.makeText(getApplicationContext(),
						"duplicate message",Toast.LENGTH_LONG).show();
				return;
			}
			tempMessages.add(messageToSend);
			Toast.makeText(getApplicationContext(),
					"message added",Toast.LENGTH_LONG).show();
			return;
		}
		
		private void generateRandomMessage() {
			
		}
		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.sendMessage) {
				addTempMessage();
			}
			if (v.getId() == R.id.generateMessage) {
				generateRandomMessage();
			}
			
		}
		
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button sendMessageButton = (Button) findViewById(R.id.sendMessage);
        sendMessageButton.setOnClickListener(new ButtonListeners());
        Button generateMessageButton = (Button) findViewById(R.id.generateMessage);
        generateMessageButton.setOnClickListener(new ButtonListeners());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
