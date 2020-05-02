package com.example.javaharkka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanReview extends AppCompatActivity {

    private Plan entry;
    private TextView planName, creator, score, description;
    private ImageView ideologyImg, victoryImg;
    private ImageButton likeBtn, dislikeBtn, returnBtn;
    private Button techPathBtn, policyPathBtn, deleteBtn;

    private FirebaseAuth fbAuth;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        try {
            fbAuth = FirebaseAuth.getInstance();
            fbData = FirebaseDatabase.getInstance();
            dbRef = fbData.getReference("Plans");
            System.out.println("Toimii");
        } catch (Exception e){
            Toast.makeText(PlanReview.this,"Error connecting to database", Toast.LENGTH_SHORT).show();
            Log.wtf("Database error: ",e);;
            finish();
        }

        Intent intent = getIntent();
        entry = (Plan) intent.getSerializableExtra("entry");
        findViews();
        setTextViews();
        setImages();
        setListeners();

    }
    private void findViews(){
        planName = (TextView) findViewById(R.id.planNameTxt);
        score = (TextView) findViewById(R.id.scoreTxt);
        creator = (TextView) findViewById(R.id.creatorTxt);
        description = (TextView) findViewById(R.id.descriptionTxt);
        ideologyImg = (ImageView) findViewById(R.id.idelogyImg);
        victoryImg = (ImageView) findViewById(R.id.victoryImg);
        likeBtn = (ImageButton) findViewById(R.id.likeBtn);
        dislikeBtn = (ImageButton) findViewById(R.id.dislikeBtn);
        techPathBtn = (Button) findViewById(R.id.techBtn);
        policyPathBtn = (Button) findViewById(R.id.policyBtn);
        returnBtn = (ImageButton) findViewById(R.id.returnBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
    }

    private void setTextViews(){
        planName.setText(entry.planName);
        creator.setText("By: " + entry.creator);
        score.setText(((int) entry.score) + "%");
        if (entry.score < 51){          //If he plan's score is less than 51, it's color changes from green to red.
            score.setTextColor(Color.parseColor("#FA6337"));
        }
        description.setText(entry.description);
    }

    private void setImages(){   // Sets the plan's victory type- and ideology images accordingly
        switch (entry.orientation){
            case "Culture":
                victoryImg.setImageResource(R.drawable.culture_icon);
                break;
            case "Technology":
                victoryImg.setImageResource(R.drawable.science_icon);
                break;
            case "Diplomacy":
                victoryImg.setImageResource(R.drawable.diplmacy_icon);
                break;
            case "Conquest":
                victoryImg.setImageResource(R.drawable.conquest_icon);
                break;
            default:
                victoryImg.setImageResource(R.drawable.ic_delete);
                break;
        }
        switch (entry.ideology){
            case "Autocracy":
                ideologyImg.setImageResource(R.drawable.fascism_icon);
                break;
            case "Order":
                ideologyImg.setImageResource(R.drawable.communist_icon);
                break;
            case "Freedom":
                ideologyImg.setImageResource(R.drawable.freedom_icon);
                break;
            default:
                ideologyImg.setImageResource(R.drawable.ic_delete);
                break;
        }
    }

    private void setListeners(){
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVoted(entry.planName)) {
                    like();
                    writeVoteFile();
                    Toast.makeText(PlanReview.this,"Vote saved!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PlanReview.this,"You've already voted this plan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dislikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVoted(entry.planName)) {
                    dislike();
                    writeVoteFile();
                    Toast.makeText(PlanReview.this,"Vote saved!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PlanReview.this,"You've already voted this plan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        techPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanReview.this, ReviewPath.class);
                intent.putExtra("techs", entry.techOrder);
                intent.putExtra("bool", true);
                startActivity(intent);

            }
        });
        policyPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanReview.this, ReviewPath.class);
                intent.putExtra("pols", entry.policyOrder);
                intent.putExtra("bool", false);
                startActivity(intent);
            }
        });
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() { // Making the delete button show a popup which asks the user to confirm the deletion of the plan.
            @Override
            public void onClick(View v) {
                if (fbAuth.getUid().equals(entry.creatorId)) { // Checking whether the user is the plan's creator.
                    AlertDialog.Builder builder = new AlertDialog.Builder(PlanReview.this);
                    builder.setMessage("Are you sure you want to delete this plan?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dbRef.child(entry.planName).setValue(null);
                                    finish();
                                    Toast.makeText(PlanReview.this, "Plan deleted", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    Toast.makeText(PlanReview.this,"Only the plan's creator can delete it.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void updateScore(){
        score.setText(((int) entry.score) + "%");
        if (entry.score < 51){
            score.setTextColor(Color.parseColor("#FA6337"));
        } else {
            score.setTextColor(Color.parseColor("#1DD500"));
        }
        dbRef.child(entry.planName).child("score").setValue(entry.score);
        dbRef.child(entry.planName).child("votes").setValue(entry.votes);
        dbRef.child(entry.planName).child("upvotes").setValue(entry.upvotes);
    }

    private void like(){
        entry.upVote();
        updateScore();
    }
    private void dislike(){
        entry.downVote();
        updateScore();
    }

    /*
    These next two methods are used to read and write to our previously created userInfo file.
    The third is used in checking whether the user has already voted the plan during the ongoing session.
    */

    private void writeVoteFile() {
        FileOutputStream fs;
        String info_to_be_written = (readUserData() + entry.planName + ";");
        try {
            fs = openFileOutput("userInfo.txt", MODE_PRIVATE);
            fs.write(info_to_be_written.getBytes());
            fs.close();
        } catch (FileNotFoundException e) {
            Log.wtf("FileNotFound error: ",e);
            finish();
        } catch (IOException e) {
            Log.wtf("File IO error: ",e);
            finish();
        }
    }
    private String readUserData(){
        try {
            FileInputStream fs = openFileInput("userInfo.txt");
            InputStreamReader isr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            String[] info = line.split(",");
            String uId = info[0];
            String userName = info[1];
            String voted = info[2];
            String userData = (uId + "," + userName + "," + voted);
            fs.close();
            return userData;

        } catch (IOException e) {
            Log.wtf("PlanReview", "Error reading file.");
            Log.wtf("File IO error: ",e);
            return "error, error,";
        }
    }
    private boolean checkVoted(String plan){
        String[] voted_plans;
        boolean vote = true;
        try {
            FileInputStream fs = openFileInput("userInfo.txt");
            InputStreamReader isr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            System.out.println(line);
            String[] info = line.split(",");
            voted_plans = info[2].split(";");
            for (int i=0;i<voted_plans.length;i++){
                if (voted_plans[i].trim().equals(plan.trim())){
                    vote = false;
                }
            }
            fs.close();
            return vote;

        } catch (IOException e) {
            Log.wtf("PlanReview", "Error reading file.");
            Log.wtf("File IO error: ",e);
            return false;
        }
    }


    // A method to check whether the file was created successfully. Used in debugging, which is why it's commented out.

    /* private void testRead() {
        String text = "";
        try {
            FileInputStream fs = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            System.out.println(sb.toString());
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            return;
        }
    }       private void writeVoted(String planName){
                FileOutputStream fs = null;
                try {
                    fs = openFileOutput(fileName, MODE_PRIVATE);
                    fs.write(text.getBytes());
                    fs.close();
                } catch (FileNotFoundException e){
                    System.out.println(e);
                    finish();
                } catch (IOException e){
                    System.out.println(e);
                    finish();
        }
    }*/
}