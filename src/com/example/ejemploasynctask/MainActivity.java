package com.example.ejemploasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	Button btn1;
	EditText eText;
	TextView text;
	asinc2 asink2=new asinc2();
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LevantarXML();
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String StringEntrada=eText.getText().toString();
				asinc myAsinc =new asinc();
				myAsinc.execute(StringEntrada);
				
			}
		});
        
        
        
    }


    private void LevantarXML() {
		btn1=(Button) findViewById(R.id.button1);
		eText=(EditText) findViewById(R.id.editText1);
		text=(TextView) findViewById(R.id.textView1);
		
    }
    


	private class asinc extends AsyncTask<String, Void, String>
    {
    	
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		Log.d("asinc", "onPreExecute");
    		
    	}

		@Override
		protected String doInBackground(String... params) {
			String[] cadena=null;
			// TODO Auto-generated method stub
			Log.d("asinc", "doInBackground");
			
			cadena=params;
			return cadena[0];
		}
    	
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			Log.d("asinc", "onProgressUpdate");
			
		}
		
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		Log.d("asinc", "onPostExecute "+result);
    		//text.setText(result);
    		
    		//asinc2= new asinc2();
    		asinc2 asink2=new asinc2();
    		
    		asink2.execute(result);
			}

		
    	
    	
    }
	
	public class asinc2 extends AsyncTask<String, Void, String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			Log.d("asinc2", "onPreExecute");
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			
			String salida=params[0];
			
			Log.d("asinc2", "doinbackground");	
			
			return salida;
	
			
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			Log.d("asinc2", "onProgressUpdate");
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String fin=result;
			
			text.setText(fin);
			Log.d("asinc2", "onPostExecute");
			
		}
		
		
	}
	
	
}
