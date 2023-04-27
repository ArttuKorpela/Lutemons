/*
----------------------------------------------------------------------------------------------------
This Activity is to animate and allow the battle between lutemons to happen.

Methods that only affect visuals:
    - setUpBattle()
    - updateHealth()
    - attackEffect(ImageView imageView)
    - defendEffect(ImageView imageView)
OnClickListeners:
    - listener
    - dummyListener
Methods to generate popUp views
    - createNewDialog(boolean isWin)
Methods that affect button's visuals and behaviour
    - turnButtonsOff()
    - turnButtonsOn()
Methods for losing and winning a battle:
    - youWin()
    - youLose()
Method that dictates the opponents behaviour:
    - enemyAi()
----------------------------------------------------------------------------------------------------
*/

package com.example.harjoitusty_arttu_korpela.Activitys;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.harjoitusty_arttu_korpela.Battle;
import com.example.harjoitusty_arttu_korpela.Counter;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;

public class BattleActivity extends AppCompatActivity {

    AlertDialog.Builder dialogBuilder;

    AlertDialog dialog;

    ImageView lutemonHome, lutemonAway, effectHome, effectAway;
    TextView battleText, healthHome, healthAway;
    Button attack_set, attack_rng, defence, continueButton;

    Intent intent;

    Lutemon fighterHome, fighterAway;

    Battle currentBattle;
    int ShieldUses = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        intent = getIntent();
        currentBattle = new Battle();
        lutemonHome = findViewById(R.id.imgLutemonHome);
        lutemonAway = findViewById(R.id.imgLutemonAway);
        effectHome = findViewById(R.id.imgEffectHome);
        effectAway = findViewById(R.id.imgEffectAway);
        battleText = findViewById(R.id.txtBattle);
        healthHome = findViewById(R.id.txtHealthHome);
        healthAway = findViewById(R.id.txtHealthAway);
        attack_set = findViewById(R.id.btnAttack_set);
        attack_rng = findViewById(R.id.btnAttack_rng);
        defence = findViewById(R.id.btnDefense);

        //Set on clickListeners to the buttons
        attack_set.setOnClickListener(listener);
        attack_rng.setOnClickListener(listener);
        defence.setOnClickListener(listener);

        //set the button colors
        attack_set.setBackgroundColor(getResources().getColor(R.color.cluster_red));
        attack_rng.setBackgroundColor(getResources().getColor(R.color.cluster_red));
        defence.setBackgroundColor(getResources().getColor(R.color.pelletti_green));

        //Get's your chosen from storage, with the position on the ArrayList
        fighterHome = (Lutemon) intent.getSerializableExtra("lutemonKey");
        //Get's your enemy with the getEnemy method, only the level of your pokemon is provided to get a fair opponent
        fighterAway = currentBattle.getEnemy(fighterHome.getLevel());

        //Set's up the View to match the lutemons (ImageViews, textViews, buttons)
        setUpBattle();







    }

    //This method is responssible of setting up all the imageViews and TextViews at the beginning of the match
    public void setUpBattle() {
        lutemonHome.setImageResource(fighterHome.getImage());
        lutemonHome.setVisibility(View.VISIBLE);
        lutemonAway.setImageResource(fighterAway.getImage());
        lutemonAway.setVisibility(View.VISIBLE);
        healthHome.setText("Health: " + fighterHome.getHealth() + "/" +  fighterHome.getMax_health());
        healthAway.setText("Health: " + fighterAway.getHealth() + "/" +  fighterAway.getMax_health());
        effectHome.setVisibility(View.GONE);
        effectAway.setVisibility(View.GONE);
        battleText.setText(fighterHome.getNickname() + " VS " + fighterAway.getNickname());
        attack_set.setText(fighterHome.getAttack().getAmmmount() + " DAMAGE");
        attack_rng.setText(fighterHome.getAttack_rng().getAmmmount_min() +" OR " + fighterHome.getAttack_rng().getAmmmount_max() + " DAMAGE");
        defence.setText(fighterHome.getDefense().getAmmmount() + " DEF");
    }

    //Update health is used during the battle to update the healthBar textViews
    public void updateHealth() {
        healthHome.setText("Health: " + fighterHome.getHealth() + "/" +  fighterHome.getMax_health());
        healthAway.setText("Health: " + fighterAway.getHealth() + "/" +  fighterAway.getMax_health());
    }



    //Attack effect takes an imageView and sets an attack effect on it for a second using the Handler class's postDelaayed method
    public void attackEffect(ImageView imageView) {
        imageView.setImageResource(R.drawable.attak);
        imageView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.GONE);
            }
        }, 1000);
    }

    //DefendEffect does the sameThing as attackEffect only changes the picture (With little tweaking these could only be one method)
    //TODO: Merge effect methods to one and change the onClick to support
    public void defendEffect(ImageView imageView) {
        imageView.setImageResource(R.drawable.shield);
        imageView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.GONE);
            }
        }, 1000);
    }

    //youWin and you lose open the losing and winning dialogs
    public void youWin(){
        Counter counter = new Counter();
        counter.addWin();
        createNewDialog(true);
    }

    public void youLose(){
        Counter counter = new Counter();
        counter.addLoss();
        createNewDialog(false);
    }

    //The listener class is used to start every confrontation and defense
    //The player presses any of the three buttons and the move is made
    //After the move is done, it's checked if the enemy has died and after that the enemy reacts
    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //The boolean that is updated based on if the confrontation kills the lutemon
            Boolean awayAlive = true;

            setUpBattle();
            //Switch to see witch of the buttons was pressed
            switch (view.getId()) {
                case R.id.btnAttack_set:
                    //Use the Battle classes confrontation method to do damage
                    //The confrontation method returns a true if the second lutemon parameter is alive
                    awayAlive = currentBattle.confrontation(fighterHome,fighterAway,fighterHome.getAttack().getAmmmount());
                    //Update the view
                    battleText.setText(fighterHome.getNickname() + " used "+ fighterHome.getAttack().getName());
                    attackEffect(effectAway);
                    break;
                case R.id.btnAttack_rng:
                    awayAlive = currentBattle.confrontation(fighterHome,fighterAway,fighterHome.getAttack_rng().getAmmmountRng());
                    //Update the view
                    battleText.setText(fighterHome.getNickname() + " used "+ fighterHome.getAttack_rng().getName());
                    attackEffect(effectAway);
                    break;
                case R.id.btnDefense:
                    //Defend only gives the lutemon a health buffer so no boolean needed
                    currentBattle.defendLutemon(fighterHome);
                    battleText.setText(fighterHome.getNickname() + " used "+ fighterHome.getDefense().getName());
                    defendEffect(effectHome);
                    awayAlive = true;
                    break;

            }
            //After the player has made his move the health bars are updated and the button get turned of till the opponent has made his move
            updateHealth();
            turnButtonsOff();

            //If the opponent is not alive you win
            if (!awayAlive) {
                youWin();
                //If the opponent is still alive the handler delays his move by 3 seconds, after which the enemy AI method is done
            } else {new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!enemyAI()) {
                        //If the enemyAI returns false the player has lost
                        youLose();
                    }
                    //Otherwise the health is updated and the buttons are turned on
                    updateHealth();
                    turnButtonsOn();
                }
            }, 3000);
            }
        }
    };

    public Boolean enemyAI(){


        //Enemy only defends near certain death
         if (fighterHome.getHealth() <= fighterAway.getAttack().getAmmmount()) {
             //Enemy only attacks with the quaranteed attack when it's going to kill
             battleText.setText(fighterAway.getNickname() + " used " + fighterAway.getAttack_rng().getName());
             attackEffect(effectHome);
             return currentBattle.confrontation(fighterAway, fighterHome, fighterAway.getAttack().getAmmmount());

         } else if (fighterAway.getHealth() <= fighterHome.getAttack().getAmmmount()) {

             if (ShieldUses <3) {
                 battleText.setText(fighterAway.getNickname() + " used "+ fighterAway.getDefense().getName());
                 defendEffect(effectAway);
                 currentBattle.defendLutemon(fighterAway);
                 ShieldUses++;
                 return true;
             } else {   //If it's not near death or going for the kill it uses the random attack
                 battleText.setText(fighterAway.getNickname() + " used "+ fighterAway.getAttack().getName());
                 attackEffect(effectHome);
                 return currentBattle.confrontation(fighterAway,fighterHome,fighterAway.getAttack_rng().getAmmmountRng());
             }

        } else{
            //If it's not near death or going for the kill it uses the random attack
            battleText.setText(fighterAway.getNickname() + " used "+ fighterAway.getAttack().getName());
            attackEffect(effectHome);
            return currentBattle.confrontation(fighterAway,fighterHome,fighterAway.getAttack_rng().getAmmmountRng());
        }

    }

    //The popup's for the win and loss. Parameter true gives the win popup and false the loss
    public void createNewDialog(boolean isWin) {
        dialogBuilder = new AlertDialog.Builder(this);
        View popupView;
        if (isWin) {
            popupView = getLayoutInflater().inflate(R.layout.you_won_popup, null);
            continueButton = (Button) popupView.findViewById(R.id.btnWinContinue);
        } else {
            popupView = getLayoutInflater().inflate(R.layout.you_lost_popup, null);
            continueButton = (Button) popupView.findViewById(R.id.btnLoseContinue);
        }

        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();
        //Continue button on the popups either gives the winning treatment or losing treatment
        continueButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if (isWin) {
                    //The players lutemons position in the storage is passed from the intent
                    LutemonStorage.getInstance().winnerTreatment(fighterHome);
                } else {
                    LutemonStorage.getInstance().loserTreatment(fighterHome);
                }

                Intent backToMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backToMainActivity);
            }
        });
    }

    //The turnButtons of changes the color of the buttons to gray and gives them the dummy listener
    public void turnButtonsOff(){

        attack_set.setBackgroundColor(Color.GRAY);
        attack_rng.setBackgroundColor(Color.GRAY);
        defence.setBackgroundColor(Color.GRAY);

        //set the dummy listener to prevent the user attacking on the enemy's turn
        attack_set.setOnClickListener(dummyListener);
        attack_rng.setOnClickListener(dummyListener);
        defence.setOnClickListener(dummyListener);

    }

    public void turnButtonsOn(){
        //reset the button color
        attack_set.setBackgroundColor(getResources().getColor(R.color.cluster_red));
        attack_rng.setBackgroundColor(getResources().getColor(R.color.cluster_red));
        defence.setBackgroundColor(getResources().getColor(R.color.pelletti_green));

        //Set back the listener to allow the player to attack
        attack_set.setOnClickListener(listener);
        attack_rng.setOnClickListener(listener);
        defence.setOnClickListener(listener);
    }

    //DummyListener is just a listener that does nothing
    private final View.OnClickListener dummyListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Do nothing
        }
    };


}