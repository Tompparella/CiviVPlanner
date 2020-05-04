/*
CiviVPlanner; Android Studio; Tommi Kunnari; Techpathmenu.class;

This is the activity that allows the user to easily add more techs to
the plan. It also introduces a counter for already added plans as well as
color changing buttons. It's one big scrollable view with a lot of buttons.
I didn't find a better way to build the views, which is the reason for the
following mess. It works, but it's horrible. I'm sorry.
*/

package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Techpathmenu extends AppCompatActivity implements View.OnClickListener {

    private Plan plan;
    private TextView counter;
    private String techName;
    private EntryItem tech;

    private Button pottery,anihusb,archery,bronze,calendar,masonry,mining,sailing,wheel,trapping,writing,construction,
            currency,drama,engineering,horseback,iron,math,optics,philosophy,chivalry,civil,compass,education,guilds
            ,machinery,metal,physics,steel,theology,acoustics,architecture,astronomy,banking,chemistry,economics,gunpowder
            ,metallurgy,navigation,printing,archeology,biology,dynamite,electricity,fertilizer,industrial,military,rifling
            ,scientific,steam,ballistics,combustion,electronics,flight,plastics,radio,railroad,refrigeration,replacable
            ,atomic, combined,computers,ecology,nuclearfission,penicillin,radar,rocketry,advanced,future,globalization
            ,lasers, mobile, nanotech,nuclearfusion,particle,robotics,satellites,stealth,telecom,internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techpathmenu);

        counter = (TextView) findViewById(R.id.txtCounter);

        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");
        counter.setText(String.valueOf(plan.techOrder.size()));

        findButtons();
        setListeners();

        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan.printTechs();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("plan", plan);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {   // Oh god
        switch (v.getId()){
            case R.id.potteryBtn:
                techName = ("Pottery");
                break;
            case R.id.anihusbBtn:
                techName = ("Animal Husbandry");
                break;
            case R.id.archeryBtn:
                techName = ("Archery");
                break;
            case R.id.bronzeBtn:
                techName = ("Bronze Working");
                break;
            case R.id.calenBtn:
                techName = ("Calendar");
                break;
            case R.id.masonBtn:
                techName = ("Masonry");
                break;
            case R.id.miningBtn:
                techName = ("Mining");
                break;
            case R.id.sailBtn:
                techName = ("Sailing");
                break;
            case R.id.wheelBtn:
                techName = ("The Wheel");
                break;
            case R.id.trapBtn:
                techName = ("Trapping");
                break;
            case R.id.writingBtn:
                techName = ("Writing");
                break;
            case R.id.constBtn:
                techName = ("Construction");
                break;
            case R.id.currencyBtn:
                techName = ("Currency");
                break;
            case R.id.dramaBtn:
                techName = ("Drama and poetry");
                break;
            case R.id.engiBtn:
                techName = ("Engineering");
                break;
            case R.id.horseBtn:
                techName = ("Horseback riding");
                break;
            case R.id.ironBtn:
                techName = ("Iron working");
                break;
            case R.id.mathBtn:
                techName = ("Mathematics");
                break;
            case R.id.opticBtn:
                techName = ("Optics");
                break;
            case R.id.philoBtn:
                techName = ("Philosophy");
                break;
            case R.id.chivBtn:
                techName = ("Chivalry");
                break;
            case R.id.civilBtn:
                techName = ("Civil service");
                break;
            case R.id.compassBtn:
                techName = ("Compass");
                break;
            case R.id.eduBtn:
                techName = ("Education");
                break;
            case R.id.guildBtn:
                techName = ("Guilds");
                break;
            case R.id.machiBtn:
                techName = ("Machinery");
                break;
            case R.id.metalBtn:
                techName = ("Metal casting");
                break;
            case R.id.physicsBtn:
                techName = ("Physics");
                break;
            case R.id.steelBtn:
                techName = ("Steel");
                break;
            case R.id.theoBtn:
                techName = ("Theology");
                break;
            case R.id.acousticBtn:
                techName = ("Acoustics");
                break;
            case R.id.architectBtn:
                techName = ("Architecture");
                break;
            case R.id.astroBtn:
                techName = ("Astronomy");
                break;
            case R.id.bankBtn:
                techName = ("Banking");
                break;
            case R.id.chemiBtn:
                techName = ("Chemistry");
                break;
            case R.id.economyBtn:
                techName = ("Economics");
                break;
            case R.id.gunBtn:
                techName = ("Gunpowder");
                break;
            case R.id.metallurgyBtn:
                techName = ("Metallurgy");
                break;
            case R.id.naviBtn:
                techName = ("Navigation");
                break;
            case R.id.printBtn:
                techName = ("Printing press");
                break;
            case R.id.archeologyBtn:
                techName = ("Archeology");
                break;
            case R.id.biologyBtn:
                techName = ("Biology");
                break;
            case R.id.dynamiteBtn:
                techName = ("Dynamite");
                break;
            case R.id.electriBtn:
                techName = ("Electricity");
                break;
            case R.id.fertilizerBtn:
                techName = ("Fertilizer");
                break;
            case R.id.industrialBtn:
                techName = ("Industialization");
                break;
            case R.id.militaryBtn:
                techName = ("Military Science");
                break;
            case R.id.riflingBtn:
                techName = ("Rifling");
                break;
            case R.id.scientificBtn:
                techName = ("Scientific theory");
                break;
            case R.id.steamBtn:
                techName = ("Steam power");
                break;
            case R.id.ballisticBtn:
                techName = ("Ballistics");
                break;
            case R.id.combustionBtn:
                techName = ("Combustion");
                break;
            case R.id.electronicBtn:
                techName = ("Electronics");
                break;
            case R.id.flightBtn:
                techName = ("Flight");
                break;
            case R.id.plasticsBtn:
                techName = ("Plastics");
                break;
            case R.id.radioBtn:
                techName = ("Radio");
                break;
            case R.id.railBtn:
                techName = ("Railroad");
                break;
            case R.id.refrigBtn:
                techName = ("Refrigeration");
                break;
            case R.id.replacableBtn:
                techName = ("Replaceable parts");
                break;
            case R.id.atomicBtn:
                techName = ("Atomic theory");
                break;
            case R.id.combinedBtn:
                techName = ("Combined arms");
                break;
            case R.id.computerBtn:
                techName = ("Computers");
                break;
            case R.id.ecologyBtn:
                techName = ("Ecology");
                break;
            case R.id.nuclearBtn:
                techName = ("Nuclear fission");
                break;
            case R.id.penicillinBtn:
                techName = ("Penicillin");
                break;
            case R.id.radarBtn:
                techName = ("Radar");
                break;
            case R.id.rocketryBtn:
                techName = ("Rocketry");
                break;
            case R.id.advancedBtn:
                techName = ("Advanced ballistics");
                break;
            case R.id.futureBtn:
                techName = ("Future tech");
                break;
            case R.id.globalBtn:
                techName = ("Globalization");   // It just keeps on going
                break;
            case R.id.laserBtn:
                techName = ("Lasers");
                break;
            case R.id.mobileBtn:
                techName = ("Mobile tactics");
                break;
            case R.id.nanotechBtn:
                techName = ("Nanotechnology");
                break;
            case R.id.nuclearfusionBtn:
                techName = ("Nuclear fusion");
                break;
            case R.id.particleBtn:
                techName = ("Particle physics");
                break;
            case R.id.roboticBtn:
                techName = ("Robotics");
                break;
            case R.id.satelliteBtn:
                techName = ("Satellites");
                break;
            case R.id.stealthBtn:
                techName = ("Stealth");
                break;
            case R.id.telecomBtn:
                techName = ("Telecommunications");
                break;
            case R.id.internetBtn:
                techName = ("The Internet");
                break;
        }
        Button temp = (Button) findViewById(v.getId());
        tech = new EntryItem(techName,plan.techOrder.size() + 1);

        addTech(tech);

        temp.setBackgroundColor(Color.parseColor("#5122FF00"));
        temp.setEnabled(false);
    }

    // Function that finds all the buttons in the UI and assigns them references
    private void findButtons(){
        // Finding all the tech buttons from the activity
        pottery = (Button) findViewById(R.id.potteryBtn);
        anihusb = (Button) findViewById(R.id.anihusbBtn);
        archery = (Button) findViewById(R.id.archeryBtn);
        bronze = (Button) findViewById(R.id.bronzeBtn);
        calendar = (Button) findViewById(R.id.calenBtn);
        masonry = (Button) findViewById(R.id.masonBtn);
        mining = (Button) findViewById(R.id.miningBtn);
        sailing = (Button) findViewById(R.id.sailBtn);
        wheel = (Button) findViewById(R.id.wheelBtn);
        trapping = (Button) findViewById(R.id.trapBtn);
        writing = (Button) findViewById(R.id.writingBtn);
        construction = (Button) findViewById(R.id.constBtn);
        currency = (Button) findViewById(R.id.currencyBtn);
        drama = (Button) findViewById(R.id.dramaBtn);
        engineering = (Button) findViewById(R.id.engiBtn);
        horseback = (Button) findViewById(R.id.horseBtn);
        iron = (Button) findViewById(R.id.ironBtn);
        math = (Button) findViewById(R.id.mathBtn);
        optics = (Button) findViewById(R.id.opticBtn);
        philosophy = (Button) findViewById(R.id.philoBtn);
        chivalry = (Button) findViewById(R.id.chivBtn);
        civil = (Button) findViewById(R.id.civilBtn);
        compass = (Button) findViewById(R.id.compassBtn);
        education = (Button) findViewById(R.id.eduBtn);
        guilds = (Button) findViewById(R.id.guildBtn);
        machinery = (Button) findViewById(R.id.machiBtn);
        metal = (Button) findViewById(R.id.metalBtn);
        physics = (Button) findViewById(R.id.physicsBtn);
        steel = (Button) findViewById(R.id.steelBtn);
        theology = (Button) findViewById(R.id.theoBtn);
        acoustics = (Button) findViewById(R.id.acousticBtn);
        architecture = (Button) findViewById(R.id.architectBtn);
        astronomy = (Button) findViewById(R.id.astroBtn);
        banking = (Button) findViewById(R.id.bankBtn);
        chemistry = (Button) findViewById(R.id.chemiBtn);
        economics = (Button) findViewById(R.id.economyBtn);
        gunpowder = (Button) findViewById(R.id.gunBtn);
        metallurgy = (Button) findViewById(R.id.metallurgyBtn);
        navigation = (Button) findViewById(R.id.naviBtn);
        printing = (Button) findViewById(R.id.printBtn);
        archeology = (Button) findViewById(R.id.archeologyBtn);
        biology = (Button) findViewById(R.id.biologyBtn);
        dynamite = (Button) findViewById(R.id.dynamiteBtn);
        electricity = (Button) findViewById(R.id.electriBtn);
        fertilizer = (Button) findViewById(R.id.fertilizerBtn);
        industrial = (Button) findViewById(R.id.industrialBtn);
        military = (Button) findViewById(R.id.militaryBtn);
        rifling = (Button) findViewById(R.id.riflingBtn);
        scientific = (Button) findViewById(R.id.scientificBtn);
        steam = (Button) findViewById(R.id.steamBtn);
        ballistics = (Button) findViewById(R.id.ballisticBtn);
        combustion = (Button) findViewById(R.id.combustionBtn);
        electronics = (Button) findViewById(R.id.electronicBtn);
        flight = (Button) findViewById(R.id.flightBtn);
        plastics = (Button) findViewById(R.id.plasticsBtn);
        radio = (Button) findViewById(R.id.radioBtn);
        railroad = (Button) findViewById(R.id.railBtn);
        refrigeration = (Button) findViewById(R.id.refrigBtn);
        replacable = (Button) findViewById(R.id.replacableBtn);
        atomic = (Button) findViewById(R.id.atomicBtn);
        combined = (Button) findViewById(R.id.combinedBtn);
        computers = (Button) findViewById(R.id.computerBtn);
        ecology = (Button) findViewById(R.id.ecologyBtn);
        nuclearfission = (Button) findViewById(R.id.nuclearBtn);
        penicillin = (Button) findViewById(R.id.penicillinBtn);
        radar = (Button) findViewById(R.id.radarBtn);
        rocketry = (Button) findViewById(R.id.rocketryBtn);
        advanced = (Button) findViewById(R.id.advancedBtn);
        future = (Button) findViewById(R.id.futureBtn);
        globalization = (Button) findViewById(R.id.globalBtn);
        lasers = (Button) findViewById(R.id.laserBtn);
        mobile = (Button) findViewById(R.id.mobileBtn);
        nanotech = (Button) findViewById(R.id.nanotechBtn);
        nuclearfusion = (Button) findViewById(R.id.nuclearfusionBtn);
        particle = (Button) findViewById(R.id.particleBtn);
        robotics = (Button) findViewById(R.id.roboticBtn);
        satellites = (Button) findViewById(R.id.satelliteBtn);
        stealth = (Button) findViewById(R.id.stealthBtn);
        telecom = (Button) findViewById(R.id.telecomBtn);
        internet = (Button) findViewById(R.id.internetBtn);


    }

    // Function that sets listeners to all said buttons
    private void setListeners(){
        pottery.setOnClickListener(this);
        anihusb.setOnClickListener(this);
        archery.setOnClickListener(this);
        bronze.setOnClickListener(this);
        calendar.setOnClickListener(this);
        masonry.setOnClickListener(this);
        mining.setOnClickListener(this);
        sailing.setOnClickListener(this);
        wheel.setOnClickListener(this);
        trapping.setOnClickListener(this);
        writing.setOnClickListener(this);
        construction.setOnClickListener(this);
        currency.setOnClickListener(this);
        drama.setOnClickListener(this);
        engineering.setOnClickListener(this);
        horseback.setOnClickListener(this);
        iron.setOnClickListener(this);
        math.setOnClickListener(this);
        optics.setOnClickListener(this);
        philosophy.setOnClickListener(this);
        chivalry.setOnClickListener(this);
        civil.setOnClickListener(this);
        compass.setOnClickListener(this);
        education.setOnClickListener(this);
        guilds.setOnClickListener(this);
        machinery.setOnClickListener(this);
        metal.setOnClickListener(this);
        physics.setOnClickListener(this);
        steel.setOnClickListener(this);
        theology.setOnClickListener(this);
        acoustics.setOnClickListener(this);
        architecture.setOnClickListener(this);
        astronomy.setOnClickListener(this);
        banking.setOnClickListener(this);
        chemistry.setOnClickListener(this);
        economics.setOnClickListener(this);
        gunpowder.setOnClickListener(this);
        metallurgy.setOnClickListener(this);
        navigation.setOnClickListener(this);
        printing.setOnClickListener(this);
        archeology.setOnClickListener(this);
        biology.setOnClickListener(this);
        dynamite.setOnClickListener(this);
        electricity.setOnClickListener(this);
        fertilizer.setOnClickListener(this);
        industrial.setOnClickListener(this);
        military.setOnClickListener(this);
        rifling.setOnClickListener(this);
        scientific.setOnClickListener(this);
        steam.setOnClickListener(this);
        ballistics.setOnClickListener(this);
        combustion.setOnClickListener(this);
        electronics.setOnClickListener(this);
        flight.setOnClickListener(this);
        plastics.setOnClickListener(this);
        radio.setOnClickListener(this);
        railroad.setOnClickListener(this);
        refrigeration.setOnClickListener(this);
        replacable.setOnClickListener(this);
        atomic.setOnClickListener(this);
        combined.setOnClickListener(this);
        computers.setOnClickListener(this);
        ecology.setOnClickListener(this);
        nuclearfission.setOnClickListener(this);
        penicillin.setOnClickListener(this);
        radar.setOnClickListener(this);
        rocketry.setOnClickListener(this);
        advanced.setOnClickListener(this);
        future.setOnClickListener(this);
        globalization.setOnClickListener(this);
        lasers.setOnClickListener(this);
        mobile.setOnClickListener(this);
        nanotech.setOnClickListener(this);
        nuclearfusion.setOnClickListener(this);
        particle.setOnClickListener(this);
        robotics.setOnClickListener(this);
        satellites.setOnClickListener(this);
        stealth.setOnClickListener(this);
        telecom.setOnClickListener(this);
        internet.setOnClickListener(this);
    }

    private void addTech(EntryItem tech){
        plan.addTech(tech);
        counter.setText(String.valueOf(plan.techOrder.size()));
        Toast.makeText(Techpathmenu.this, "Added " + techName, Toast.LENGTH_SHORT).show();
    }
}
