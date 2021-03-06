package eu.iums.fitatwoerk;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hilfesupportActivity extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseAuth mAuth;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> fragen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilfesupport);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hilfe und Support");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView userNameToolbar = findViewById(R.id.name);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // User is Login
            userNameToolbar.setText("Online ");
        }

        else {
            userNameToolbar.setText("Offline ");
        }




        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.expanlistview2);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, fragen);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });

    }
    private void createCollection() {
        String[] frage1 = {"Fit@Work ist eine App, die darauf spezialisiert ist, ihrem Nutzer oder ihrer Nutzerin w??hrend der Arbeit fit zu halten."};
        String[] frage2 = {"Fit@Work ist auf einem einfach Prinzip aufgebaut: Es werden zahlreiche ??bungen sowie ??bungssets zur Verf??gung gestellt aus denen sich der Nutzer / die Nutzerin passende ??bungen f??r ihr Workout aussuchen kann."};
        String[] frage3 = {"Zu jeder ??bung gibt es passende Bilder sowie einen Erkl??rungstext die den Nutzer / die Nutzerin anleitet."};
        String[] frage4 = {"Wir arbeiten derzeit daran, ein Score-System zu implementieren, der ihre Leistungen bewertet und ihnen ein besseres Bild von ihrem Fortschritt gibt."};
        String[] frage5 = {"All ihre Daten werden von uns mit besten Vorkehrungen gesch??tzt und werden nicht an Drittparteien weitergegeben."};
        String[] frage6 = {"Wenn sie Fragen oder Anmerkungen an uns haben sollten k??nnen sie uns selbstverst??ndlich jederzeit eine E-Mail an folgende Adresse schreiben: info@fitatwork.com "};

        fragen = new HashMap<String, List<String>>();
        for(String group : groupList){
            if (group.equals("Was ist Fit@Work?")){
                loadChild(frage1);
            }
            else if (group.equals("Wie funktioniert Fit@Work?"))
                loadChild(frage2);
            else if (group.equals("Wie f??hre ich die ??bungen aus?"))
                loadChild(frage3);
            else if (group.equals("Wof??r steht der Score?"))
                loadChild(frage4);
            else if (group.equals("Wie sicher sind meine Daten?"))
                loadChild(frage5);
            else if (group.equals("Wie kann ich mit Ihnen in Kontakt treten?"))
                loadChild(frage6);

            fragen.put(group, childList);
        }
    }

    private void loadChild (String[] allefragen) {
        childList = new ArrayList<>();
        for(String frage : allefragen){
            childList.add(frage);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Was ist Fit@Work?");
        groupList.add("Wie funktioniert Fit@Work?");
        groupList.add("Wie f??hre ich die ??bungen aus?");
        groupList.add("Wof??r steht der Score?");
        groupList.add("Wie sicher sind meine Daten?");
        groupList.add("Wie kann ich mit Ihnen in Kontakt treten?");
    }


}
