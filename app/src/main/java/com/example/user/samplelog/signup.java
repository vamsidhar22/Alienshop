package com.example.user.samplelog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.samplelog.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {
    EditText editText,editpassword,edtname;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editText=(EditText)findViewById(R.id.edtphone);
        editpassword=(EditText)findViewById(R.id.edtpssd);
        edtname=(EditText)findViewById(R.id.edtname);
        signup=(Button)findViewById(R.id.signup);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("user");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(signup.this);
                mDialog.setMessage("please wait loading.....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(editText.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(signup.this, " NUMBER ALREADY EXISTS !!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            User user=new User(editText.getText().toString(),editpassword.getText().toString());
                            table_user.child(editText.getText().toString()).setValue(user);
                            Toast.makeText(signup.this, "sign up  succesfull !!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }
        });
    }
}
