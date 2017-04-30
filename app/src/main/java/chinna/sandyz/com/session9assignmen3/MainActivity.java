package chinna.sandyz.com.session9assignmen3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save_btn= (Button)findViewById(R.id.save_file);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = "MyFile";
                String content = "hello world";
                FileOutputStream outputStream = null;
                try {
                    outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                    Toast.makeText(MainActivity.this, "File Saved !!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Button chk_btn= (Button)findViewById(R.id.check_file);
        chk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path=getFilesDir().getAbsolutePath()+"/MyFile";
                File file = new File ( path );

                if ( file.exists() )
                {
                    // Toast File is exists
                    Toast.makeText(MainActivity.this, "File exist !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Toast File is not exists
                    Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


