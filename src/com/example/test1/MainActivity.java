package com.example.test1;



import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
Button btn1;

	EditText et1,et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.button1);
		et2=(EditText)findViewById(R.id.editText2);
		et1=(EditText)findViewById(R.id.editText1);

    btn1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String host=et1.getText().toString();
		if(host!=null&&host!=""){
	
		et2.setText(GetInetAddress(host));
		}else{
			Toast.makeText(MainActivity.this, "别点了，都还没输入域名呢", Toast.LENGTH_LONG).show();
		}
	}
  });
		
}

	public String GetInetAddress(String  host){
		String IPAddress = ""; 
		InetAddress ReturnStr1 = null;
		try {
			ReturnStr1 = java.net.InetAddress.getByName(host);
			IPAddress = ReturnStr1.getHostAddress();
			System.out.println(IPAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  IPAddress;
		}
		return IPAddress;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
