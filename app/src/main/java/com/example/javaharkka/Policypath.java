/*
CiviVPlanner; Android Studio; Tommi Kunnari; Policypath.class;

This activity class handles creating the plan's policy path. It creates
a list of PolicyItems which the user can then append by clicking elements
in the UI, which is why there are so many buttons initiated. This could have
probably been done a lot better, but I couldn't find anything about it. Regardless,
this solution works, though I'm not exactly proud of it.
*/

package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Policypath extends AppCompatActivity implements View.OnClickListener {

    private int count = 0, pType; // Count visualises the user the order in which the path is being made.
    private Plan plan;
    private String policyName;
    private Button tradition, aristo, olig, legal, monar, landed, liberty, repub, citiz, collect, merito, repre,
            honor, warrior, disci, milicas, miltrad, prof, piety, orgre, mand, theo, relitol, reform, patronage, philan,
            consul, scholas, culdip, mercon, aesthetics, culce, fine, flour, artist, cultur, commerce, wagon, mercar, entre,
            mercant, protect, exploration, mariinf, navtrad, navischo, mernavy, trefle, rationalism, secul, humanism, free,
            sover, scienre;
    private Button freedomBtn, autocracyBtn,orderBtn;
    private PolicyItem item;

    private View.OnClickListener listener = new View.OnClickListener() {    // Add a listener for the ideology buttons. Also proceeds to the next activity.
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.freedomBtn:
                    plan.ideology = "Freedom";
                    break;
                case R.id.autocracyBtn:
                    plan.ideology = "Autocracy";
                    break;
                case R.id.orderBtn:
                    plan.ideology = "Order";
                    break;
            }
            System.out.println(plan.ideology);
            openNext();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policypath);

        buildButtons();
        setListeners();

        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");
    }

    private void openNext() {
        if(plan.policyOrder.size() < 5){
            Toast.makeText(this,"Please choose at least 5 policies",Toast.LENGTH_SHORT).show();
        } else {
            plan.printTechs();
            Intent intent = new Intent(this, Description.class);
            intent.putExtra("plan", plan);
            finish();
            startActivity(intent);
        }
    }

    private void buildButtons() {
        findPolicyButtons();
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan.policyOrder.clear();
                Intent intent = new Intent(Policypath.this, Techpath.class);
                intent.putExtra("plan", plan);
                finish();
                startActivity(intent);
            }
        });

        ImageButton redoButton = (ImageButton) findViewById(R.id.redoBtn);          // Initiate a button that let's the user refresh the activity and clear the policypath list.
        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan.policyOrder.clear();
                Intent intent = new Intent(Policypath.this, Policypath.class);
                intent.putExtra("plan", plan);
                finish();
                startActivity(intent);

            }
        });

        freedomBtn = (Button) findViewById(R.id.freedomBtn);
        autocracyBtn = (Button) findViewById(R.id.autocracyBtn);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        freedomBtn.setOnClickListener(listener);
        autocracyBtn.setOnClickListener(listener);
        orderBtn.setOnClickListener(listener);

    }

    private void findPolicyButtons() {          // I'm sorry
        tradition = (Button) findViewById(R.id.btnTradition);
        aristo = (Button) findViewById(R.id.btnAristo);
        olig = (Button) findViewById(R.id.btnOlig);
        legal = (Button) findViewById(R.id.btnLegal);
        monar = (Button) findViewById(R.id.btnMonar);
        landed = (Button) findViewById(R.id.btnLand);
        liberty = (Button) findViewById(R.id.btnLiberty);
        repub = (Button) findViewById(R.id.btnRepu);
        citiz = (Button) findViewById(R.id.btnCit);
        collect = (Button) findViewById(R.id.btnCol);
        merito = (Button) findViewById(R.id.btnMerit);
        repre = (Button) findViewById(R.id.btnRep);
        honor = (Button) findViewById(R.id.btnHonor);
        warrior = (Button) findViewById(R.id.btnWar);
        disci = (Button) findViewById(R.id.btnDisci);
        milicas = (Button) findViewById(R.id.btnmilcas);
        miltrad = (Button) findViewById(R.id.btnMiltra);
        prof = (Button) findViewById(R.id.btnProf);
        piety = (Button) findViewById(R.id.btnPiety);
        orgre = (Button) findViewById(R.id.btnOrg);
        mand = (Button) findViewById(R.id.btnMand);
        theo = (Button) findViewById(R.id.btnTheo);
        relitol = (Button) findViewById(R.id.btnRelitor);
        reform = (Button) findViewById(R.id.btnReform);
        patronage = (Button) findViewById(R.id.btnPatronage);
        philan = (Button) findViewById(R.id.btnPhila);
        consul = (Button) findViewById(R.id.btnConsul);
        scholas = (Button) findViewById(R.id.btnScholas);
        culdip = (Button) findViewById(R.id.btnCuldip);
        mercon = (Button) findViewById(R.id.btnMercon);
        aesthetics = (Button) findViewById(R.id.btnAesthetics);
        culce = (Button) findViewById(R.id.btnCultur);
        fine = (Button) findViewById(R.id.btnFine);
        flour = (Button) findViewById(R.id.btnFlour);
        artist = (Button) findViewById(R.id.btnArtist);
        cultur = (Button) findViewById(R.id.btnCulex);
        commerce = (Button) findViewById(R.id.btnCommerce);
        wagon = (Button) findViewById(R.id.btnWagon);
        mercar = (Button) findViewById(R.id.btnMercen);
        entre = (Button) findViewById(R.id.btnEntre);
        mercant = (Button) findViewById(R.id.btnMercant);
        protect = (Button) findViewById(R.id.btnProtect);
        exploration = (Button) findViewById(R.id.btnExploration);
        mariinf = (Button) findViewById(R.id.btnMaritime);
        navtrad = (Button) findViewById(R.id.btnNaval);
        navischo = (Button) findViewById(R.id.btnNavig);
        mernavy = (Button) findViewById(R.id.btnMernavy);
        trefle = (Button) findViewById(R.id.btnTreasure);
        rationalism = (Button) findViewById(R.id.btnRationalism);
        secul = (Button) findViewById(R.id.btnSecul);
        humanism = (Button) findViewById(R.id.btnHuman);
        free = (Button) findViewById(R.id.btnFree);
        sover = (Button) findViewById(R.id.btnSover);
        scienre = (Button) findViewById(R.id.btnScien);
    }

    private void setListeners() {   // ...so sorry
        tradition.setOnClickListener(this);
        aristo.setOnClickListener(this);
        olig.setOnClickListener(this);
        legal.setOnClickListener(this);
        monar.setOnClickListener(this);
        landed.setOnClickListener(this);
        liberty.setOnClickListener(this);
        repub.setOnClickListener(this);
        citiz.setOnClickListener(this);
        collect.setOnClickListener(this);
        merito.setOnClickListener(this);
        repre.setOnClickListener(this);
        honor.setOnClickListener(this);
        warrior.setOnClickListener(this);
        disci.setOnClickListener(this);
        milicas.setOnClickListener(this);
        miltrad.setOnClickListener(this);
        prof.setOnClickListener(this);
        piety.setOnClickListener(this);
        orgre.setOnClickListener(this);
        mand.setOnClickListener(this);
        theo.setOnClickListener(this);
        relitol.setOnClickListener(this);
        reform.setOnClickListener(this);
        patronage.setOnClickListener(this);
        philan.setOnClickListener(this);
        consul.setOnClickListener(this);
        scholas.setOnClickListener(this);
        culdip.setOnClickListener(this);
        mercon.setOnClickListener(this);
        aesthetics.setOnClickListener(this);
        culce.setOnClickListener(this);
        fine.setOnClickListener(this);
        flour.setOnClickListener(this);
        artist.setOnClickListener(this);
        cultur.setOnClickListener(this);
        commerce.setOnClickListener(this);
        wagon.setOnClickListener(this);
        mercar.setOnClickListener(this);
        entre.setOnClickListener(this);
        mercant.setOnClickListener(this);
        protect.setOnClickListener(this);
        exploration.setOnClickListener(this);
        mariinf.setOnClickListener(this);
        navtrad.setOnClickListener(this);
        navischo.setOnClickListener(this);
        mernavy.setOnClickListener(this);
        trefle.setOnClickListener(this);
        rationalism.setOnClickListener(this);
        secul.setOnClickListener(this);
        humanism.setOnClickListener(this);
        free.setOnClickListener(this);
        sover.setOnClickListener(this);
        scienre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {       // Please don't hate me
        count++;
        switch (v.getId()) {
            case R.id.btnTradition:
                policyName = ("Open Tradition");
                pType = 1;
                break;
            case R.id.btnAristo:
                policyName = ("Aristocracy");
                pType = 1;
                break;
            case R.id.btnOlig:
                policyName = ("Oligarchy");
                pType = 1;
                break;
            case R.id.btnLegal:
                policyName = ("Legalism");
                pType = 1;
                break;
            case R.id.btnMonar:
                policyName = ("Monarchy");
                pType = 1;
                break;
            case R.id.btnLand:
                policyName = ("Landed elite");
                pType = 1;
                break;
            case R.id.btnLiberty:
                policyName = ("Open Liberty");
                pType = 2;
                break;
            case R.id.btnRepu:
                policyName = ("Republic");
                pType = 2;
                break;
            case R.id.btnCit:
                policyName = ("Citizenship");
                pType = 2;
                break;
            case R.id.btnCol:
                policyName = ("Collective rule");
                pType = 2;
                break;
            case R.id.btnMerit:
                policyName = ("Meritocracy");
                pType = 2;
                break;
            case R.id.btnRep:
                policyName = ("Representation");
                pType = 2;
                break;
            case R.id.btnHonor:
                policyName = ("Open Honor");
                pType = 3;
                break;
            case R.id.btnWar:
                policyName = ("Warrior code");
                pType = 3;
                break;
            case R.id.btnDisci:
                policyName = ("Discipline");
                pType = 3;
                break;
            case R.id.btnmilcas:
                policyName = ("Military caste");
                pType = 3;
                break;
            case R.id.btnMiltra:
                policyName = ("Military tradition");
                pType = 3;
                break;
            case R.id.btnProf:
                policyName = ("Professional army");
                pType = 3;
                break;
            case R.id.btnPiety:
                policyName = ("Open Piety");
                pType = 4;
                break;
            case R.id.btnOrg:
                policyName = ("Organized religion");
                pType = 4;
                break;
            case R.id.btnMand:
                policyName = ("Mandate of heaven");
                pType = 4;
                break;
            case R.id.btnTheo:
                policyName = ("Theocracy");
                pType = 4;
                break;
            case R.id.btnRelitor:
                policyName = ("Religious tolerance");
                pType = 4;
                break;
            case R.id.btnReform:
                policyName = ("Reformation");
                pType = 4;
                break;
            case R.id.btnPatronage:
                policyName = ("Open Patronage");
                pType = 5;
                break;
            case R.id.btnPhila:
                policyName = ("Philanthropy");
                pType = 5;
                break;
            case R.id.btnConsul:
                policyName = ("Consulates");
                pType = 5;
                break;
            case R.id.btnScholas:
                policyName = ("Scholasticism");
                pType = 5;
                break;
            case R.id.btnCuldip:
                policyName = ("Cultural diplomacy");
                pType = 5;
                break;
            case R.id.btnMercon:
                policyName = ("Merchant confederacy");
                pType = 5;
                break;
            case R.id.btnAesthetics:
                policyName = ("Open Aesthetics");
                pType = 6;
                break;
            case R.id.btnCultur:
                policyName = ("Cultural centers");
                pType = 6;
                break;
            case R.id.btnFine:
                policyName = ("Fine arts");
                pType = 6;
                break;
            case R.id.btnFlour:
                policyName = ("Flourishing arts");
                pType = 6;
                break;
            case R.id.btnArtist:
                policyName = ("Artistic genius");
                pType = 6;
                break;
            case R.id.btnCulex:
                policyName = ("Cultural exchange");
                pType = 6;
                break;
            case R.id.btnCommerce:
                policyName = ("Open Commerce");
                pType = 7;
                break;
            case R.id.btnWagon:
                policyName = ("Wagon trains");
                pType = 7;
                break;
            case R.id.btnMercen:
                policyName = ("Mercenary army");
                pType = 7;
                break;
            case R.id.btnEntre:
                policyName = ("Entrepreneurship");
                pType = 7;
                break;
            case R.id.btnMercant:
                policyName = ("Mercantilism");
                pType = 7;
                break;
            case R.id.btnProtect:
                policyName = ("Protectionism");
                pType = 7;
                break;
            case R.id.btnExploration:
                policyName = ("Open Exploration");
                pType = 8;
                break;
            case R.id.btnMaritime:
                policyName = ("Maritime infrastructure");
                pType = 8;
                break;
            case R.id.btnNaval:
                policyName = ("Naval tradition");
                pType = 8;
                break;
            case R.id.btnNavig:
                policyName = ("Navigation school");
                pType = 8;
                break;
            case R.id.btnMernavy:
                policyName = ("Merchant navy");
                pType = 8;
                break;
            case R.id.btnTreasure:
                policyName = ("Treasure fleets");
                pType = 8;
                break;
            case R.id.btnRationalism:
                policyName = ("Open Rationalism");
                pType = 9;
                break;
            case R.id.btnSecul:
                policyName = ("Secularism");
                pType = 9;
                break;
            case R.id.btnHuman:
                policyName = ("Humanism");
                pType = 9;
                break;
            case R.id.btnFree:
                policyName = ("Free thought");
                pType = 9;
                break;
            case R.id.btnSover:
                policyName = ("Sovereignty");
                pType = 9;
                break;
            case R.id.btnScien:
                policyName = ("Scientific revolution");
                pType = 9;
                break;
        }
        Button temp = (Button) findViewById(v.getId());
        temp.setText(String.valueOf(count));
        temp.setBackgroundColor(Color.parseColor("#5122FF00"));     // The policy is added to the list and the entry is colored to signal this.
        item = new PolicyItem(policyName,count,pType);

        addPolicy(item);

        temp.setClickable(false);
    }
    private void addPolicy(PolicyItem item){     // Adds policy to the list
        plan.addPolicy(item);
        Toast.makeText(Policypath.this, "Added " + policyName, Toast.LENGTH_SHORT).show();
    }
}
