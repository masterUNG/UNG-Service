package appewtc.masterung.ungservice;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);

    }   // Main Method

    //Create Inner Class
    private class SynchronizeUser extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private String myUserString, myPasswordString;

        public SynchronizeUser(Context context,
                               String myUserString,
                               String myPasswordString) {
            this.context = context;
            this.myUserString = myUserString;
            this.myPasswordString = myPasswordString;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {



            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return null;
        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }   // onPost

    }   // SynUser Class


    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 3, "Have Space", "Please Fill All Every Blank");
        } else {

            //Call SynUser
            SynchronizeUser synchronizeUser = new SynchronizeUser(this, userString, passwordString);
            synchronizeUser.execute();

        }

    }   // clickSignIn




    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   // Main Class
