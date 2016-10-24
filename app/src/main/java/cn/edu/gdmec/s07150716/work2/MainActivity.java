package cn.edu.gdmec.s07150716.work2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;

    private  int num1 ,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv1.setText("在oncreate方法中赋值");
        tv2.setText("在oncreate方法中赋值");
        num1=0;
        num2=0;
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv1.setText("触发onrestart，显示view1");
        tv2.setText("触发onrestart，显示view2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        num1++;
        num2++;
        outState.putString("tv1","onsaveinstancestate保存的数值为"+num1);
        outState.putString("tv2",String.valueOf(num2));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText("savedInstanceState保存的数值为"+savedInstanceState.getString("tv2"));
        num2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }

}
