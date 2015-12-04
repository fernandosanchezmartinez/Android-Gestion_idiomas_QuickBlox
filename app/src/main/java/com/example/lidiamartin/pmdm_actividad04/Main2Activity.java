package com.example.lidiamartin.pmdm_actividad04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lidiamartin.pmdm_lib.QBAdmin.TasksAdmin;
import com.example.lidiamartin.pmdm_lib.QBAdmin.TasksAdminListener;

public class Main2Activity extends AppCompatActivity implements TasksAdminListener{
    private TasksAdmin task;
    private Main2AcivityUI maUI;
    private ImageView iv1;
    private ImageView iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);

        maUI = new Main2AcivityUI(this);
        task = new TasksAdmin(5000,2);
        task.setTasksAdminListener(this);
        task.startTasks();
    }

    @Override
    public void taskCycleFinished(int iNumOfCycles) {
        Log.v("taskCycleFinished", "cambio de imagen");
        runOnUiThread(maUI);
        /*if (iNumOfCycles%2==0){
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.GONE);
        }else{
            iv2.setVisibility(View.VISIBLE);
            iv1.setVisibility(View.GONE);
        }*/
    }

    @Override
    public void taskCycleFinishedAll() {
        Log.v("taskFinished", "cambio de activity");
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
    public ImageView getIv1() {
        return iv1;
    }

    public void setIv1(ImageView iv1) {
        this.iv1 = iv1;
    }

    public ImageView getIv2() {
        return iv2;
    }

    public void setIv2(ImageView iv2) {
        this.iv2 = iv2;
    }
}
