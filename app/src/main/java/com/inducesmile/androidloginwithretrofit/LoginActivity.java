package com.inducesmile.androidloginwithretrofit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";

    public static final String BASE_URL ="http://start4me.com/";

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView failedLoginMessage;

    View focusView = null;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        failedLoginMessage = (TextView)findViewById(R.id.failed_login);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                failedLoginMessage.setText("");
                attemptLogin();
            }
        });

        Button registrationButton = (Button)findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptRegistration(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            showProfile(email, password);
        }
    }

    private void attemptLogin(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            loginProcessWithRetrofit(email, password);
        }
    }

    private boolean loginValidation() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();

        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }
        return cancel;
    }

    private void populateAutoComplete(){
        String[] countries = getResources().getStringArray(R.array.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        mEmailView.setAdapter(adapter);
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private ApiInterface getInterfaceService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }

    private void loginProcessWithRetrofit(final String email, String password){

        ApiInterface mApiService = this.getInterfaceService();
        Call<Login> call = mApiService.post("login",email,password);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                Login mLoginObject = response.body();

                String returnedResponse = mLoginObject.getError_msg();
                boolean error=mLoginObject.getError();
                if(!error) {
                    String type = mLoginObject.getType();
                    String uid = mLoginObject.getUid();
                    String email = mLoginObject.getProperties().getEmail();
                    String fname = mLoginObject.getProperties().getFirstname();
                    String lname = mLoginObject.getProperties().getLastname();
                }
                Toast.makeText(LoginActivity.this,returnedResponse, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void registrationProcessWithRetrofit(final String email, String password){

        ApiInterface mApiService = this.getInterfaceService();
        Call<Register> mService = mApiService.register("register",email, password,"","","User");
        mService.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {

                Register mLoginObject = response.body();
                String returnedResponse = mLoginObject.getError_msg();
                boolean error=mLoginObject.getError();
                if(!error) {
                    String type = mLoginObject.getProperties().getType();
                    String uid = mLoginObject.getUid();
                    String email = mLoginObject.getProperties().getEmail();
                    String fname = mLoginObject.getProperties().getFirstname();
                    String lname = mLoginObject.getProperties().getLastname();
                }

                Toast.makeText(LoginActivity.this,returnedResponse, Toast.LENGTH_LONG).show();
                //showProgress(false);

            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void Updatepicture(final String email, String password){
        File sdcard = Environment.getExternalStorageDirectory();
       File profileimage=new File(sdcard,"ondemand.txt");
        ApiInterface mApiService = this.getInterfaceService();
        RequestBody method = RequestBody.create(MediaType.parse("text/plain"),"updateuserprofile");
        RequestBody uid = RequestBody.create(MediaType.parse("text/plain"),"58b65ff7be6219.20589480");
        RequestBody firstname = RequestBody.create(MediaType.parse("text/plain"),"Suresh");
        RequestBody lastname = RequestBody.create(MediaType.parse("text/plain"),"p");
        RequestBody number = RequestBody.create(MediaType.parse("text/plain"),"7795170844");
        RequestBody lat = RequestBody.create(MediaType.parse("text/plain"),"12.8552");
        RequestBody long1 = RequestBody.create(MediaType.parse("text/plain"),"77.5869");
        RequestBody address = RequestBody.create(MediaType.parse("text/plain"),"Gottigere");
        RequestBody profileimage1 = RequestBody.create(MediaType.parse("image/jpeg"),profileimage);
        Call<Update> mService = mApiService.update(method,uid,firstname,lastname,number,lat,long1,address,profileimage1);
        mService.enqueue(new Callback<Update>() {
            @Override
            public void onResponse(Call<Update> call, Response<Update> response) {

                Update mLoginObject = response.body();
                String returnedResponse = mLoginObject.getError_msg();
                boolean error=mLoginObject.getError();


                Toast.makeText(LoginActivity.this,returnedResponse, Toast.LENGTH_LONG).show();
                //showProgress(false);

            }

            @Override
            public void onFailure(Call<Update> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void showProfile(final String email, String password){

        ApiInterface mApiService = this.getInterfaceService();
        Call<ShowProfile> mService = mApiService.showprofile("showuserprofile","58c91dd7c05302.89097743");
        mService.enqueue(new Callback<ShowProfile>() {
            @Override
            public void onResponse(Call<ShowProfile> call, Response<ShowProfile> response) {

                ShowProfile mLoginObject = response.body();
                String returnedResponse = mLoginObject.getError_msg();
                boolean error=mLoginObject.getError();
                if(!error) {
                    String type = mLoginObject.getUser().getType();
                    Toast.makeText(LoginActivity.this,""+mLoginObject.getUser().getLat(), Toast.LENGTH_LONG).show();

                }

                Toast.makeText(LoginActivity.this,returnedResponse, Toast.LENGTH_LONG).show();
                //showProgress(false);

            }

            @Override
            public void onFailure(Call<ShowProfile> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }



}

