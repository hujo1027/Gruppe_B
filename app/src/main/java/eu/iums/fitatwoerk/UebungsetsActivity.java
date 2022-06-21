package eu.iums.fitatwoerk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UebungsetsActivity extends AppCompatActivity {
    Toolbar toolbar;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> uebungssets;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebungsets);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Übungssets");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Benutzername anzeigen
        if(mAuth.getCurrentUser() != null) {
            TextView userNameToolbar = findViewById(R.id.name);
            userNameToolbar.setText(mAuth.getCurrentUser().getDisplayName());
            TextView userNameNavigationheader = findViewById(R.id.nameNavigation);
            userNameNavigationheader.setText(mAuth.getCurrentUser().getDisplayName());
        } else {
            TextView userNameToolbar = findViewById(R.id.name);
            userNameToolbar.setText("Nutzername");
            TextView userNameNavigationheader = findViewById(R.id.nameNavigation);
            userNameNavigationheader.setText("Nutzername");
        }

        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.expanlistview);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, uebungssets);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && i != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View v, int i, int i1, long l) {

                if (i==0 & i1==0){

                    Intent intentu1 = new Intent(v.getContext(), UebungActivity.class);
                    intentu1.putExtra("KEY", "uebung1");
                    startActivity(intentu1);

                } else if (i==0 &i1==1){

                    Intent intentu8 = new Intent(v.getContext(), UebungActivity.class);
                    intentu8.putExtra("KEY", "uebung8");
                    startActivity(intentu8);

                } else if (i==0 &i1==2){

                    Intent intentu12 = new Intent(v.getContext(), UebungActivity.class);
                    intentu12.putExtra("KEY", "uebung12");
                    startActivity(intentu12);

                } else if (i==0 &i1==3){

                    Intent intentu17 = new Intent(v.getContext(), UebungActivity.class);
                    intentu17.putExtra("KEY", "uebung17");
                    startActivity(intentu17);

                } else if (i==0 &i1==4){

                    Intent intentu24 = new Intent(v.getContext(), UebungActivity.class);
                    intentu24.putExtra("KEY", "uebung24");
                    startActivity(intentu24);

                } else if (i==0 &i1==5){

                    Intent intentu37 = new Intent(v.getContext(), UebungActivity.class);
                    intentu37.putExtra("KEY", "uebung37");
                    startActivity(intentu37);

                } else if (i==1 & i1==0){

                    Intent intentu2 = new Intent(v.getContext(), UebungActivity.class);
                    intentu2.putExtra("KEY", "uebung2");
                    startActivity(intentu2);

                } else if (i==1 & i1==1){

                    Intent intentu8 = new Intent(v.getContext(), UebungActivity.class);
                    intentu8.putExtra("KEY", "uebung8");
                    startActivity(intentu8);

                } else if (i==1 & i1==2){

                    Intent intentu12 = new Intent(v.getContext(), UebungActivity.class);
                    intentu12.putExtra("KEY", "uebung12");
                    startActivity(intentu12);

                } else if (i==1 & i1==3){

                    Intent intentu18 = new Intent(v.getContext(), UebungActivity.class);
                    intentu18.putExtra("KEY", "uebung18");
                    startActivity(intentu18);

                } else if (i==1 & i1==4){

                    Intent intentu29 = new Intent(v.getContext(), UebungActivity.class);
                    intentu29.putExtra("KEY", "uebung29");
                    startActivity(intentu29);

                } else if (i==1 & i1==5){

                    Intent intentu37 = new Intent(v.getContext(), UebungActivity.class);
                    intentu37.putExtra("KEY", "uebung37");
                    startActivity(intentu37);

                } else if (i==2 & i1==0){

                    Intent intentu3 = new Intent(v.getContext(), UebungActivity.class);
                    intentu3.putExtra("KEY", "uebung3");
                    startActivity(intentu3);

                } else if (i==2 & i1==1){

                    Intent intentu8 = new Intent(v.getContext(), UebungActivity.class);
                    intentu8.putExtra("KEY", "uebung8");
                    startActivity(intentu8);

                } else if (i==2 & i1==2){

                    Intent intentu12 = new Intent(v.getContext(), UebungActivity.class);
                    intentu12.putExtra("KEY", "uebung12");
                    startActivity(intentu12);

                } else if (i==2 & i1==3){

                    Intent intentu21 = new Intent(v.getContext(), UebungActivity.class);
                    intentu21.putExtra("KEY", "uebung21");
                    startActivity(intentu21);

                } else if (i==2 & i1==4){

                    Intent intentu34 = new Intent(v.getContext(), UebungActivity.class);
                    intentu34.putExtra("KEY", "uebung34");
                    startActivity(intentu34);

                } else if (i==2 & i1==5){

                    Intent intentu37 = new Intent(v.getContext(), UebungActivity.class);
                    intentu37.putExtra("KEY", "uebung37");
                    startActivity(intentu37);

                } else if (i==3 & i1==0){

                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);

                } else if (i==3 & i1==1){

                    Intent intentu6 = new Intent(v.getContext(), UebungActivity.class);
                    intentu6.putExtra("KEY", "uebung6");
                    startActivity(intentu6);

                } else if (i==3 & i1==2){

                    Intent intentu10 = new Intent(v.getContext(), UebungActivity.class);
                    intentu10.putExtra("KEY", "uebung10");
                    startActivity(intentu10);

                } else if (i==3 & i1==3){

                    Intent intentu15 = new Intent(v.getContext(), UebungActivity.class);
                    intentu15.putExtra("KEY", "uebung15");
                    startActivity(intentu15);

                } else if (i==3 & i1==4){

                    Intent intentu30 = new Intent(v.getContext(), UebungActivity.class);
                    intentu30.putExtra("KEY", "uebung30");
                    startActivity(intentu30);

                } else if (i==3 & i1==5){

                    Intent intentu35 = new Intent(v.getContext(), UebungActivity.class);
                    intentu35.putExtra("KEY", "uebung35");
                    startActivity(intentu35);

                } else if (i==4 & i1==0){

                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);

                } else if (i==4 & i1==1){

                    Intent intentu6 = new Intent(v.getContext(), UebungActivity.class);
                    intentu6.putExtra("KEY", "uebung6");
                    startActivity(intentu6);

                } else if (i==4 & i1==2){

                    Intent intentu14 = new Intent(v.getContext(), UebungActivity.class);
                    intentu14.putExtra("KEY", "uebung14");
                    startActivity(intentu14);

                } else if (i==4 & i1==3){

                    Intent intentu16 = new Intent(v.getContext(), UebungActivity.class);
                    intentu16.putExtra("KEY", "uebung16");
                    startActivity(intentu16);

                } else if (i==4 & i1==4){

                    Intent intentu31 = new Intent(v.getContext(), UebungActivity.class);
                    intentu31.putExtra("KEY", "uebung31");
                    startActivity(intentu31);

                } else if (i==4 & i1==5){

                    Intent intentu35 = new Intent(v.getContext(), UebungActivity.class);
                    intentu35.putExtra("KEY", "uebung35");
                    startActivity(intentu35);


                } else if (i==5 & i1==0){

                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);

                } else if (i==5 & i1==1){

                    Intent intentu7 = new Intent(v.getContext(), UebungActivity.class);
                    intentu7.putExtra("KEY", "uebung7");
                    startActivity(intentu7);

                } else if (i==5 & i1==2){

                    Intent intentu9 = new Intent(v.getContext(), UebungActivity.class);
                    intentu9.putExtra("KEY", "uebung9");
                    startActivity(intentu9);

                } else if (i==5 & i1==3){

                    Intent intentu19 = new Intent(v.getContext(), UebungActivity.class);
                    intentu19.putExtra("KEY", "uebung19");
                    startActivity(intentu19);

                } else if (i==5 & i1==4){

                    Intent intentu27 = new Intent(v.getContext(), UebungActivity.class);
                    intentu27.putExtra("KEY", "uebung27");
                    startActivity(intentu27);

                } else if (i==5 & i1==5){

                    Intent intentu36 = new Intent(v.getContext(), UebungActivity.class);
                    intentu36.putExtra("KEY", "uebung36");
                    startActivity(intentu36);

                } else if (i==6 & i1==0){

                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);

                } else if (i==6 & i1==1){

                    Intent intentu7 = new Intent(v.getContext(), UebungActivity.class);
                    intentu7.putExtra("KEY", "uebung7");
                    startActivity(intentu7);

                } else if (i==6 & i1==2){

                    Intent intentu9 = new Intent(v.getContext(), UebungActivity.class);
                    intentu9.putExtra("KEY", "uebung9");
                    startActivity(intentu9);

                } else if (i==6 & i1==3){

                    Intent intentu19 = new Intent(v.getContext(), UebungActivity.class);
                    intentu19.putExtra("KEY", "uebung19");
                    startActivity(intentu19);

                } else if (i==6 & i1==4){

                    Intent intentu28 = new Intent(v.getContext(), UebungActivity.class);
                    intentu28.putExtra("KEY", "uebung28");
                    startActivity(intentu28);

                } else if (i==6 & i1==5){

                    Intent intentu36 = new Intent(v.getContext(), UebungActivity.class);
                    intentu36.putExtra("KEY", "uebung36");
                    startActivity(intentu36);

                } else if (i==7 & i1==0){

                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);

                } else if (i==7 & i1==1){

                    Intent intentu7 = new Intent(v.getContext(), UebungActivity.class);
                    intentu7.putExtra("KEY", "uebung7");
                    startActivity(intentu7);

                } else if (i==7 & i1==2){

                    Intent intentu13 = new Intent(v.getContext(), UebungActivity.class);
                    intentu13.putExtra("KEY", "uebung13");
                    startActivity(intentu13);

                } else if (i==7 & i1==3){

                    Intent intentu19 = new Intent(v.getContext(), UebungActivity.class);
                    intentu19.putExtra("KEY", "uebung19");
                    startActivity(intentu19);

                } else if (i==7 & i1==4){

                    Intent intentu33 = new Intent(v.getContext(), UebungActivity.class);
                    intentu33.putExtra("KEY", "uebung33");
                    startActivity(intentu33);

                } else if (i==7 & i1==5){

                    Intent intentu36 = new Intent(v.getContext(), UebungActivity.class);
                    intentu36.putExtra("KEY", "uebung36");
                    startActivity(intentu36);

                }





                return true;
            }
        });
    }


    private void createCollection() {
        String[] einfach1 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] einfach2 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] einfach3 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] mittel1 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] mittel2 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] schwer1 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] schwer2 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};
        String[] schwer3 = {"Kopf", "Nacken / Arme",
                "Arme", "Torso", "Becken / Beine", "Beine"};


        uebungssets = new HashMap<String, List<String>>();
        for(String group : groupList){
            if (group.equals("Leicht # 1")){
                loadChild(einfach1);
            } else if (group.equals("Leicht # 2"))
                loadChild(einfach2);
            else if (group.equals("Leicht # 3"))
                loadChild(einfach3);
            else if (group.equals("Mittel # 1"))
                loadChild(mittel1);
            else if (group.equals("Mittel # 2"))
                loadChild(mittel2);
            else if (group.equals("Schwer # 1"))
                loadChild(schwer1);
            else if (group.equals("Schwer # 2"))
                loadChild(schwer2);
            else if (group.equals("Schwer # 3"))
                loadChild(schwer3);
            uebungssets.put(group, childList);
        }
    }

    private void loadChild(String[] mobileModels) {
        childList = new ArrayList<>();
        for(String model : mobileModels){
            childList.add(model);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Leicht # 1");
        groupList.add("Leicht # 2");
        groupList.add("Leicht # 3");
        groupList.add("Mittel # 1");
        groupList.add("Mittel # 2");
        groupList.add("Schwer # 1");
        groupList.add("Schwer # 2");
        groupList.add("Schwer # 3");
    }
}


