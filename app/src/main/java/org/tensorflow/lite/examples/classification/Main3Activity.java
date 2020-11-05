package org.tensorflow.lite.examples.classification;
        import android.content.Intent;
        import android.speech.RecognizerIntent;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.ArrayList;
        import java.util.Locale;

public class Main3Activity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000 ;
    //views from activity
    TextView mTextTv;
    String k11;
    ImageButton mVoiceBtn;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mTextTv = findViewById(R.id.textTv);
        mVoiceBtn=findViewById(R.id.voiceBtn);
        //button click to show speech to text dialog
        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        button3=(Button)findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("s1", k11);
                i.putExtra("s2", "");
                i.putExtra("s3", "");
                i.putExtra("case1", 1);
                startActivity(i);
            }
        });

    }

    private void speak() {
        //intent to show speech to text
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something!" );

        //start intent
        try {
            //in there was no error
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        }
        catch (Exception e){
            //if some error
            //get messsage of error and show
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();


        }
    }
    //receive voice input and handle it

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    //get text array from voice intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //set to text view
                    k11=result.get(0);
                    k11 = k11.substring(0, 1).toUpperCase() + k11.substring(1);
                    mTextTv.setText(k11);


                }
                break;
            }
        }
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this,ClassifierActivity.class));
        //getActivity().finish();
        //this.finishAffinity();
    }

}
