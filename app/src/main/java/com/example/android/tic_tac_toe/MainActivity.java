package com.example.android.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Spinner opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

int player_no =1;
    ArrayList<Integer> plr1 = new ArrayList<Integer>();
    ArrayList<Integer> plr2 = new ArrayList<Integer>();



    public void Clickbt(View view) {
        opt = (Spinner)findViewById(R.id.opt);
        opt.setEnabled(false);
        Button buSelected = (Button) view;
        if(opt.getSelectedItem().toString().equals("Single")){
        PlayGame(buSelected);

            autoplay();
        }
        else{
            PlayGame(buSelected);
        }
    }

    void PlayGame(Button buSelected){
        int val = 0;
        switch (buSelected.getId()){
            case R.id.bt1:val=1;
                break;
            case R.id.bt2:val=2;
                break;
            case R.id.bt3:val=3;
                break;
            case R.id.bt4:val = 4;
                break;
            case R.id.bt5:val =5;
                break;
            case R.id.bt6:val=6;
                break;
            case R.id.bt7:val=7;
                break;
            case R.id.bt8:val=8;
                break;
            case R.id.bt9:val =9;
                break;

        }

        if(player_no ==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.RED);
            plr1.add(val);
            buSelected.setEnabled(false);
            if(Checkwinner()==1){
                Toast.makeText(MainActivity.this,"Player 1 you are the winner",Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
            player_no=2;
        }else{
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.GREEN);
            plr2.add(val);
            buSelected.setEnabled(false);
            if(Checkwinner()==2){
                Toast.makeText(MainActivity.this,"Player 2 you are the winner",Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
            player_no=1;
        }
    }

    int Checkwinner(){
        int winner =-1;
        if(plr1.contains(1)&&plr1.contains(2)&&plr1.contains(3)){
        winner=1;
    }else if(plr2.contains(1)&&plr2.contains(2)&&plr2.contains(3)){
            winner=2;
        }else if(plr1.contains(4)&&plr1.contains(5)&&plr1.contains(6)){
            winner=1;
        }else if(plr2.contains(4)&&plr2.contains(5)&&plr2.contains(6)){
            winner=2;
        }else if(plr1.contains(7)&&plr1.contains(8)&&plr1.contains(9)){
            winner=1;
        }else if(plr2.contains(7)&&plr2.contains(8)&&plr2.contains(9)){
            winner=2;
        }else if(plr1.contains(1)&&plr1.contains(4)&&plr1.contains(7)){
            winner=1;
        }else if(plr2.contains(1)&&plr2.contains(4)&&plr2.contains(7)){
            winner=2;
        }else if(plr1.contains(2)&&plr1.contains(5)&&plr1.contains(8)){
            winner=1;
        }else if(plr2.contains(2)&&plr2.contains(5)&&plr2.contains(8)){
            winner=2;
        }else if(plr1.contains(6)&&plr1.contains(9)&&plr1.contains(3)){
            winner=1;
        }else if(plr2.contains(6)&&plr2.contains(9)&&plr2.contains(3)){
            winner=2;
        }else if(plr1.contains(1)&&plr1.contains(5)&&plr1.contains(9)){
            winner=1;
        }else if(plr2.contains(1)&&plr2.contains(5)&&plr2.contains(9)){
            winner=2;
        }else if(plr1.contains(5)&&plr1.contains(7)&&plr1.contains(3)){
            winner=1;
        }else if(plr2.contains(5)&&plr2.contains(7)&&plr2.contains(3)){
            winner=2;
        }
        return winner;
    }
    void autoplay(){
        ArrayList<Integer> items = new ArrayList<Integer>();
        for(int i=1;i<10;i++){
            if(!plr1.contains(i)&&!plr2.contains(i)){
                items.add(i);
            }
        }
        if(items.isEmpty()){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        Button select;

        Random r = new Random();
        if(items.size()>0){
        int index = r.nextInt(items.size()-0)+0;

        index = items.get(index);
        switch (index){
            case 1:select=(Button)findViewById(R.id.bt1);
                break;
            case 2:select=(Button)findViewById(R.id.bt2);
                break;
            case 3:select=(Button)findViewById(R.id.bt3);
                break;
            case 4: select=(Button)findViewById(R.id.bt4);
                break;
            case 5: select=(Button)findViewById(R.id.bt5);
                break;
            case 6: select=(Button)findViewById(R.id.bt6);
                break;
            case 7: select=(Button)findViewById(R.id.bt7);
                break;
            case 8:select=(Button)findViewById(R.id.bt8);
                break;
            case 9:select=(Button)findViewById(R.id.bt9);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        plr2.add(index);
        PlayGame(select);}
        else{
            Toast.makeText(MainActivity.this,"GAME OVER",Toast.LENGTH_LONG).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }

}