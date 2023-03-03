package com.example.lab1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lab1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {
    String firstNumber;
    String operator;
    Boolean isNew = true;
    EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        //Screen checking
       /*DisplayMetrics display = getResources().getDisplayMetrics();
        boolean stop = true;
        if((display.heightPixels >= 1920 & display.widthPixels >= 1080) |
                (display.heightPixels >=1080 & display.widthPixels >= 1920)) {
            stop = false;
        }
        if(stop) {
            android.os.Process.killProcess((android.os.Process.myPid()));
            System.exit(1);
        }*/
    }

    public void clickNumber(View view) {

        if(isNew)
            editText.setText("");
        isNew=false;

        String number = editText.getText().toString();
        switch(view.getId()){
            case R.id.Button1: number =  number+"1" ; break;
            case R.id.Button2: number =  number+"2" ; break;
            case R.id.Button3: number =  number+"3" ; break;
            case R.id.Button4: number =  number+"4" ; break;
            case R.id.Button5: number =  number+"5" ; break;
            case R.id.Button6: number =  number+"6" ; break;
            case R.id.Button7: number =  number+"7" ; break;
            case R.id.Button8: number =  number+"8" ; break;
            case R.id.Button9: number =  number+"9" ; break;
            case R.id.ButtonZero: number =  number+"0" ; break;
            case R.id.ButtonDot: number =  number+"." ; break;
            case R.id.ButtonPlusMinus: number =  "-"+number ; break;
        }
        editText.setText(number);
    }

    public void clickOperation(View view) {
        isNew = true;
        firstNumber = editText.getText().toString();

        switch(view.getId()){
            case R.id.ButtonMinus: operator="-"; break;
            case R.id.ButtonPlus: operator="+"; break;
            case R.id.ButtonDivide: operator="/"; break;
            case R.id.ButtonMultiply: operator="*"; break;
        }
    }

    public void clickEquals(View view) {
        String secondNumber = editText.getText().toString();
        Double result = 0.0;
        switch(operator){
            case "-": result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber); break;
            case "+": result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber); break;
            case "/": result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber); break;
            case "*": result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber); break;
        }
        Double newData = new Double(result);
        int value = newData.intValue();
        editText.setText(value+"");
    }

    public void clickAC(View view) {
        editText.setText("0");
        isNew = true;
    }
}