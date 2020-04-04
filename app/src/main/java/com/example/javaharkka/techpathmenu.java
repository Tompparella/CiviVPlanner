package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class techpathmenu extends AppCompatActivity implements View.OnClickListener {

    private Plan plan;
    private TextView counter;

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

        findButtons();
        setListeners();

        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan.printTechs();
                finish();
                Intent intent = new Intent(techpathmenu.this,techpath.class);
                intent.putExtra("plan", plan);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.potteryBtn:
                System.out.println("Pottery");
                plan.addTech("Pottery");
                break;
            case R.id.anihusbBtn:
                System.out.println("Animal Husbandry");
                plan.addTech("Animal Husbandry");
                break;
            case R.id.archeryBtn:
                System.out.println("Archery");
                plan.addTech("Archery");
                break;
            case R.id.bronzeBtn:
                System.out.println("Bronze Working");
                plan.addTech("Bronze Working");
                break;
            case R.id.calenBtn:
                System.out.println("Calendar");
                plan.addTech("Calendar");
                break;
            case R.id.masonBtn:
                System.out.println("Masonry");
                plan.addTech("Masonry");
                break;
            case R.id.miningBtn:
                System.out.println("Mining");
                plan.addTech("Mining");
                break;
            case R.id.sailBtn:
                System.out.println("Sailing");
                plan.addTech("Sailing");
                break;
            case R.id.wheelBtn:
                System.out.println("The Wheel");
                plan.addTech("The Wheel");
                break;
            case R.id.trapBtn:
                System.out.println("Trapping");
                plan.addTech("Trapping");
                break;
            case R.id.writingBtn:
                System.out.println("Writing");
                plan.addTech("Writing");
                break;
            case R.id.constBtn:
                System.out.println("Construction");
                plan.addTech("Construction");
                break;
            case R.id.currencyBtn:
                System.out.println("Currency");
                plan.addTech("Currency");
                break;
            case R.id.dramaBtn:
                System.out.println("Drama and poetry");
                plan.addTech("Drama and poetry");
                break;
            case R.id.engiBtn:
                System.out.println("Engineering");
                plan.addTech("Engineering");
                break;
            case R.id.horseBtn:
                System.out.println("Horseback riding");
                plan.addTech("Horseback riding");
                break;
            case R.id.ironBtn:
                System.out.println("Iron working");
                plan.addTech("Iron working");
                break;
            case R.id.mathBtn:
                System.out.println("Mathematics");
                plan.addTech("Mathematics");
                break;
            case R.id.opticBtn:
                System.out.println("Optics");
                plan.addTech("Optics");
                break;
            case R.id.philoBtn:
                System.out.println("Philosophy");
                plan.addTech("Philosophy");
                break;
            case R.id.chivBtn:
                System.out.println("Chivalry");
                plan.addTech("Chivalry");
                break;
            case R.id.civilBtn:
                System.out.println("Civil service");
                plan.addTech("Civil service");
                break;
            case R.id.compassBtn:
                System.out.println("Compass");
                plan.addTech("Compass");
                break;
            case R.id.eduBtn:
                System.out.println("Education");
                plan.addTech("Education");
                break;
            case R.id.guildBtn:
                System.out.println("Guilds");
                plan.addTech("Guilds");
                break;
            case R.id.machiBtn:
                System.out.println("Machinery");
                plan.addTech("Machinery");
                break;
            case R.id.metalBtn:
                System.out.println("Metal casting");
                plan.addTech("Metal casting");
                break;
            case R.id.physicsBtn:
                System.out.println("Physics");
                plan.addTech("Physics");
                break;
            case R.id.steelBtn:
                System.out.println("Steel");
                plan.addTech("Steel");
                break;
            case R.id.theoBtn:
                System.out.println("Theology");
                plan.addTech("Theology");
                break;
            case R.id.acousticBtn:
                System.out.println("Acoustics");
                plan.addTech("Acoustics");
                break;
            case R.id.architectBtn:
                System.out.println("Architecture");
                plan.addTech("Architecture");
                break;
            case R.id.astroBtn:
                System.out.println("Astronomy");
                plan.addTech("Astronomy");
                break;
            case R.id.bankBtn:
                System.out.println("Banking");
                plan.addTech("Banking");
                break;
            case R.id.chemiBtn:
                System.out.println("Chemistry");
                plan.addTech("Chemistry");
                break;
            case R.id.economyBtn:
                System.out.println("Economics");
                plan.addTech("Economics");
                break;
            case R.id.gunBtn:
                System.out.println("Gunpowder");
                plan.addTech("Gunpowder");
                break;
            case R.id.metallurgyBtn:
                System.out.println("Metallurgy");
                plan.addTech("Metallurgy");
                break;
            case R.id.naviBtn:
                System.out.println("Navigation");
                plan.addTech("Navigation");
                break;
            case R.id.printBtn:
                System.out.println("Printing press");
                plan.addTech("Printing press");
                break;
            case R.id.archeologyBtn:
                System.out.println("Archeology");
                plan.addTech("Archeology");
                break;
            case R.id.biologyBtn:
                System.out.println("Biology");
                plan.addTech("Biology");
                break;
            case R.id.dynamiteBtn:
                System.out.println("Dynamite");
                plan.addTech("Dynamite");
                break;
            case R.id.electriBtn:
                System.out.println("Electricity");
                plan.addTech("Electricity");
                break;
            case R.id.fertilizerBtn:
                System.out.println("Fertilizer");
                plan.addTech("Fertilizer");
                break;
            case R.id.industrialBtn:
                System.out.println("Industialization");
                plan.addTech("Industialization");
                break;
            case R.id.militaryBtn:
                System.out.println("Military Science");
                plan.addTech("Military Science");
                break;
            case R.id.riflingBtn:
                System.out.println("Rifling");
                plan.addTech("Rifling");
                break;
            case R.id.scientificBtn:
                System.out.println("Scientific theory");
                plan.addTech("Scientific theory");
                break;
            case R.id.steamBtn:
                System.out.println("Steam power");
                plan.addTech("Steam power");
                break;
            case R.id.ballisticBtn:
                System.out.println("Ballistics");
                plan.addTech("Ballistics");
                break;
            case R.id.combustionBtn:
                System.out.println("Combustion");
                plan.addTech("Combustion");
                break;
            case R.id.electronicBtn:
                System.out.println("Electornics");
                plan.addTech("Electornics");
                break;
            case R.id.flightBtn:
                System.out.println("Flight");
                plan.addTech("Flight");
                break;
            case R.id.plasticsBtn:
                System.out.println("Plastics");
                plan.addTech("Plastics");
                break;
            case R.id.radioBtn:
                System.out.println("Radio");
                plan.addTech("Radio");
                break;
            case R.id.railBtn:
                System.out.println("Railroad");
                plan.addTech("Railroad");
                break;
            case R.id.refrigBtn:
                System.out.println("Refrigeration");
                plan.addTech("Refrigeration");
                break;
            case R.id.replacableBtn:
                System.out.println("Replaceable parts");
                plan.addTech("Replaceable parts");
                break;
            case R.id.atomicBtn:
                System.out.println("Atomic theory");
                plan.addTech("Atomic theory");
                break;
            case R.id.combinedBtn:
                System.out.println("Combined arms");
                plan.addTech("Combined arms");
                break;
            case R.id.computerBtn:
                System.out.println("Computers");
                plan.addTech("Computers");
                break;
            case R.id.ecologyBtn:
                System.out.println("Ecology");
                plan.addTech("Ecology");
                break;
            case R.id.nuclearBtn:
                System.out.println("Nuclear fission");
                plan.addTech("Nuclear fission");
                break;
            case R.id.penicillinBtn:
                System.out.println("Penicillin");
                plan.addTech("Penicillin");
                break;
            case R.id.radarBtn:
                System.out.println("Radar");
                plan.addTech("Radar");
                break;
            case R.id.rocketryBtn:
                System.out.println("Rocketry");
                plan.addTech("Rocketry");
                break;
            case R.id.advancedBtn:
                System.out.println("Advanced ballistics");
                plan.addTech("Advanced ballistics");
                break;
            case R.id.futureBtn:
                System.out.println("Future tech");
                plan.addTech("Future tech");
                break;
            case R.id.globalBtn:
                System.out.println("Globalization");
                plan.addTech("Globalization");
                break;
            case R.id.laserBtn:
                System.out.println("Lasers");
                plan.addTech("Lasers");
                break;
            case R.id.mobileBtn:
                System.out.println("Mobile tactics");
                plan.addTech("Mobile tactics");
                break;
            case R.id.nanotechBtn:
                System.out.println("Nanotechnology");
                plan.addTech("Nanotechnology");
                break;
            case R.id.nuclearfusionBtn:
                System.out.println("Nuclear fusion");
                plan.addTech("Nuclear fusion");
                break;
            case R.id.particleBtn:
                System.out.println("Particle physics");
                plan.addTech("Particle physics");
                break;
            case R.id.roboticBtn:
                System.out.println("Robotics");
                plan.addTech("Robotics");
                break;
            case R.id.satelliteBtn:
                System.out.println("Satellites");
                plan.addTech("Satellites");
                break;
            case R.id.stealthBtn:
                System.out.println("Stealth");
                plan.addTech("Stealth");
                break;
            case R.id.telecomBtn:
                System.out.println("Telecommunications");
                plan.addTech("Telecommunications");
                break;
            case R.id.internetBtn:
                System.out.println("Internet");
                plan.addTech("Internet");
                break;
        }
        int count = Integer.parseInt(counter.getText().toString());
        count++;
        counter.setText(String.valueOf(count));
        Toast.makeText(techpathmenu.this, "Added a tech!", Toast.LENGTH_SHORT).show();
    }

    // Function that finds all the buttons in the UI and assigns them references
    public void findButtons(){
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

    // Function that sets listeners to all said buttonss
    public void setListeners(){
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

}
