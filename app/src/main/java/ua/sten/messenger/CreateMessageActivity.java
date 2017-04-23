package ua.sten.messenger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        final EditText message = (EditText) findViewById(R.id.edit_message);

        Button sendMessage = (Button) findViewById(R.id.send);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), ReceiveMessageActivity.class);
                //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, message.getText().toString());
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser));
                startActivity(chosenIntent);
            }
        });
    }
}
