package eu.iums.fitatwoerk;

import static eu.iums.fitatwoerk.R.drawable.ic_baseline_pause_24;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Locale;

public class UebungActivity extends AppCompatActivity {
    Toolbar toolbar;

    //TIMER
    private static final long START_TIME_IN_MILLIS = 90000;        //Individuelle Zeit eingeben
    private TextView mTextViewCountDown;
    private FloatingActionButton mButtonStartPause;
    private FloatingActionButton mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebung);

        mAuth = FirebaseAuth.getInstance();

        FloatingActionButton fabBeschreibung = findViewById(R.id.fabBeschreibung);
        FloatingActionButton fabset = findViewById(R.id.fabSet);
        ImageSlider imageSlider = findViewById(R.id.image_slider);


        // anzeigen der passenden Bilder
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("KEY");
        ArrayList<SlideModel> slideModelList = new ArrayList<>();

        fabset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        switch (value) {
            case "uebung1":
                slideModelList.add(new SlideModel (R.drawable.f5, null));
                slideModelList.add(new SlideModel (R.drawable.f3, null));
                slideModelList.add(new SlideModel (R.drawable.f1, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" -Kopf nach unten neigen\n" +
                                "- Kopf langsam nach oben neigen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung2":
                slideModelList.add(new SlideModel (R.drawable.f6, null));
                slideModelList.add(new SlideModel (R.drawable.f4, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf Richtung Schulter neigen, bis Dehngef??hl im Bereich der gegen??berliegenden Kopf-Nackenpartie entsteht\n" +
                                "- Dann direkt zur anderen Seite neigen\n" +
                                "- Kopf nicht in der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung3":
                slideModelList.add(new SlideModel (R.drawable.f2, null));

                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf zur Seite drehen bis ein Dehngef??hl entsteht\n" +
                                "- Kopf zur anderen Seite drehen\n" +
                                "- Kopf nicht in der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung4":
                slideModelList.add(new SlideModel (R.drawable.f10, null));
                slideModelList.add(new SlideModel (R.drawable.f11, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf Richtung Schulter neigen, bis ein Dehngef??hl im gegen??berliegenden Kopf-Nacken-Bereich entsteht\n" +
                                "- Kopf vorsichtig weiter zur Seite neigen\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung5":

                slideModelList.add(new SlideModel (R.drawable.f9, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf nach vorne neigen bis ein Dehngef??hl im Nacken entsteht\n" +
                                "- Kopf vorsichtig mit beiden H??nden weiter neigen\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung6":
                slideModelList.add(new SlideModel (R.drawable.f8, null));
                slideModelList.add(new SlideModel (R.drawable.f7, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Schultern vorw??rts oder r??ckw??rts kreisen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung7":
                slideModelList.add(new SlideModel (R.drawable.f14, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit aufrechtem R??cken auf einen Stuhl setzen, so dass keine Lehne am\n" +
                                "R??cken ist\n" +
                                "- Schulterbl??tter zusammenziehen (mit den Armen hinter dem R??cken die\n" +
                                "Handinnenfl??che nach au??en und die Daumen nach innen drehen)\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung8":
                slideModelList.add(new SlideModel (R.drawable.f15, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- H??nde zusammenfalten und die Arme vor dem K??rper ausstrecken\n" +
                                "- Schulter und Arme nach vorne unten sto??en, dabei das Kinn in Richtung\n" +
                                "Nacken geschoben halten\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung9":
                slideModelList.add(new SlideModel (R.drawable.f12, null));
                slideModelList.add(new SlideModel (R.drawable.f13, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Ausfallschritt parallel zur Wand Aufstellen und mit einem Arm an der\n" +
                                "Wand abst??tzen\n" +
                                "- Oberk??rper vorsichtig von dem aufgest??tzten Arm wegdrehen bis ein\n" +
                                "Dehngef??hl in der Brustmuskulatur entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung10":
                slideModelList.add(new SlideModel (R.drawable.f18, null));
                slideModelList.add(new SlideModel (R.drawable.f16, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Ellbogen des zu dehnenden Armes beugen\n" +
                                "- Arm neben den Kopf hochheben\n" +
                                "- Mit anderer Hand den Ellbogen fassen und hinter dem Kopf nach unten\n" +
                                "sto??en, bis ein Dehngef??hl am hinteren Teil der Schulter und des Oberarms entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung11":
                slideModelList.add(new SlideModel (R.drawable.f16, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Ellbogen des zu dehnenden Armes von hinten fassen und vor dem K??rper zur entgegengesetzten Schulter hin ziehen\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung12":
                slideModelList.add(new SlideModel (R.drawable.f24, null));
                slideModelList.add(new SlideModel (R.drawable.f17, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Zu dehnender Unterarm vor dem K??rper gestreckt im Ellbogen halten\n" +
                                "- Mit Hilfe der anderen Hand zu dehnende Hand langsam nach unten biegen, bis ein Dehngef??hl im Unterarm entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung13":
                slideModelList.add(new SlideModel (R.drawable.f25, null));

                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit flacher Hand auf dem Tisch abst??tzen (Finger zum K??rper, Ellbogen\n" +
                                "gestreckt)\n" +
                                "- K??rpergewicht nach hinten verlagern, bis ein Dehngef??hl an den Innenseiten der Unterarme entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung14":
                slideModelList.add(new SlideModel (R.drawable.f20, null));
                slideModelList.add(new SlideModel (R.drawable.f19, null));
                slideModelList.add(new SlideModel (R.drawable.f21, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Eine Hand st??tzt auf dem Tisch, anderer Arm h??ngt entspannt und pendelt kreisf??rmig\n" +
                                "- Immer wieder die Kreisrichtung wechseln ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung15":
                slideModelList.add(new SlideModel (R.drawable.f22, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Sitzen Oberk??rper und Kopf zwischen die Knie senken, sodass der R??cken m??glichst rund wird\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung16":

                slideModelList.add(new SlideModel (R.drawable.f29, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Die ??bung findet im Sitzen statt\n" +
                                "- Kinn zur Brust hinbewegen, Oberk??rper einrollen\n" +
                                "- Kopf und Schultern bleiben locker, das Ges???? hebt sich nicht von der\n" +
                                "Sitzfl??che ab\n" +
                                "- Die Endpositon nicht halten, mit beiden H??nden den Nacken fassen,\n" +
                                "Oberk??rper aufrichten/strecken und das Brustbein zur Decke heben (Blick\n" +
                                "zur Decke)\n" +
                                "- Wenn eine R??ckenlehne vorhanden ist, kann man sich auch anlehnen\n" +
                                "- Endposition nicht halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung17":
                slideModelList.add(new SlideModel (R.drawable.f28, null));

                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("  H??nde seitlich auf den Schultern\n" +
                                "- Rumpf seitlich nach links und rechts neigen, ohne nach vorne/hinten\n" +
                                "auszuweichen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung18":
                slideModelList.add(new SlideModel (R.drawable.f30, null));
                slideModelList.add(new SlideModel (R.drawable.f33, null));
                slideModelList.add(new SlideModel (R.drawable.f38, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Die ??bung findet im Sitzen statt\n" +
                                "- Die Arme ??ber dem Brustkorb kreuzen und die Fingerspitzen auf die\n" +
                                "Schultern legen\n" +
                                "- Den Oberk??rper nach rechts und links drehen, der Kopf folgt der Bewegung\n ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung19":
                slideModelList.add(new SlideModel (R.drawable.f47, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- An einer offenen T??r an den Griffen festhalten\n" +
                                "- In die Hocke gehen und dabei den R??cken dehnen\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung20":
                slideModelList.add(new SlideModel (R.drawable.f40, null));
                slideModelList.add(new SlideModel (R.drawable.f37, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Stehen K??rper zur Seite neigen und Arm schr??g nach oben strecken\n" +
                                "- Das Becken bleibt ruhig\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung21":

                slideModelList.add(new SlideModel (R.drawable.f39, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit dem R??cken gegen die Wand stellen, Schultern und H??nde gegen\n" +
                                "die Wand dr??cken\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung22":
                slideModelList.add(new SlideModel (R.drawable.f30, null));
                slideModelList.add(new SlideModel (R.drawable.f41, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Die ??bung findet im Sitzen statt\n" +
                                "- Arme vor der Brust verschr??nken und die Schultern nach vorne zusammenziehen\n" +
                                "- Oberk??rper nach vorne beugen, gleichzeitig drehen und seitw??rts in dieselben Richtung neigen" +
                                " - Mit dem Blick der Bewegung folgen\n" +
                                "- W??hrend der Bewegung ausatmen, dann zur??ck zur Ausgangsstellung\n" +
                                "und dasselbe in die andere Richtung wiederholen").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung23":
                slideModelList.add(new SlideModel (R.drawable.f26, null));
                slideModelList.add(new SlideModel (R.drawable.f23, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Sitzen den R??cken nach hinten einsinken lassen und ihn danach mit\n" +
                                "Hilfe der R??ckenmuskulatur wieder strecken\n" +
                                "- Kein zu starkes Hohlkreuz machen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung24":
                slideModelList.add(new SlideModel (R.drawable.f31, null));
                slideModelList.add(new SlideModel (R.drawable.f32, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Stehen das Becken rechts/links zur Seite schieben und darauf achten,\n" +
                                "dass der Rumpf weder nach vorne noch nach hinten kippt\n ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung25":
                slideModelList.add(new SlideModel (R.drawable.f43, null));
                slideModelList.add(new SlideModel (R.drawable.f36, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Im Sitzen ein Bein an den Oberk??rper ziehen und anwinkeln\n" +
                                "- Mit den Armen das gebeugte Knie weiter Richtung gegenseitiger Schulter ziehen\n" +
                                "- Ein Dehngef??hl entsteht an der hinteren Oberschenkelmuskulatur und\n" +
                                "im Ges????\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung26":
                slideModelList.add(new SlideModel (R.drawable.f48, null));

                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Sich an Wand/Stuhl festhalten\n" +
                                "- Ein Fu??gelenk mit der Hand hinten fassen, Knie zeigt in Richtung Boden\n" +
                                "- Fu?? Richtung Ges???? ziehen, ohne ein zu starkes Hohlkreuz zuzulassen,\n" +
                                "bis Dehngef??hl am vorderen Oberschenkel entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung27":
                slideModelList.add(new SlideModel (R.drawable.f44, null));
                slideModelList.add(new SlideModel (R.drawable.f42, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Zu dehnendes Bein mit der Ferse auf einen Stuhl\n" +
                                "- K??rper aufrichten\n" +
                                "- Knie strecken und Fu??spitzen in Richtung Kniescheibe hochziehen\n" +
                                "- Sollte die Dehnung nicht ausreichen, den Oberk??rper gerade nach vorne\n" +
                                "neigen, bis eine Dehnung gesp??rt wird\n" +
                                "- In der Endposition halten  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung28":
                slideModelList.add(new SlideModel (R.drawable.f44, null));
                slideModelList.add(new SlideModel (R.drawable.f42, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Seitlich neben einen Stuhl stellen und das zu dehnende Bein mit der\n" +
                                "Ferse auf den Stuhl\n" +
                                "- Oberk??rper zur Seite ??ber das Bein neigen, bis ein Dehngef??hl an der Innenseite des Oberschenkels entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung29":
                slideModelList.add(new SlideModel (R.drawable.f49, null));
                slideModelList.add(new SlideModel (R.drawable.f55, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Auf Stuhl setzen und ein Bein auf dem anderen gebeugt ablegen\n" +
                                "- Bei geradem, vorgeneigtem R??cken das Knie sanft Richtung Boden\n" +
                                "schieben, bis ein Dehngef??hl tief im Ges???? und an der Oberschenkelau??enseite entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung30":
                slideModelList.add(new SlideModel (R.drawable.f46, null));
                slideModelList.add(new SlideModel (R.drawable.f53, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit gestreckten Armen und geradem R??cken gegen eine Wand st??tzen,\n" +
                                "F????e zusammen\n" +
                                "- K??rper zur Wand sinken lassen, Fu??sohlen bleiben auf dem Boden\n" +
                                "- Die Dehnung ist in den Waden zu sp??ren ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung31":
                slideModelList.add(new SlideModel (R.drawable.f61, null));
                slideModelList.add(new SlideModel (R.drawable.f54, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("  - In Ausfallschritt aufstellen\n" +
                                "- Mit den H??nden das Knie des vorderen Beines abst??tzen, das andere\n" +
                                "Knie gestreckt halten\n" +
                                "- Becken nach vorne unten dr??cken, bis ein Dehngef??hl an der Vorderseite des Oberschenkels und in der Leistengegend entsteht\n" +
                                "- R??cken aufrecht halten\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung32":
                slideModelList.add(new SlideModel (R.drawable.f47, null));
                slideModelList.add(new SlideModel (R.drawable.f35, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Leicht an Stuhl/Wand abst??tzen\n" +
                                "- In den Zehenstand hochstemmen und langsam zur??ck ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung33":
                slideModelList.add(new SlideModel (R.drawable.f47, null));
                slideModelList.add(new SlideModel (R.drawable.f35, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Seitlich auf eine Treppenstufe stellen und mit den H??nden an Wand/Gel??nder festhalten\n" +
                                "- Ein Bein ??ber die Kante h??ngen lassen\n" +
                                "- Bein vorw??rts und r??ckw??rts pendeln lassen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung34":
                slideModelList.add(new SlideModel (R.drawable.f34, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Beine schulterbreit aufstellen, Knie beugen, Knie und Fu??spitzen zeigen\n" +
                                "nach au??en\n" +
                                "- Beine strecken, wobei R??cken gerade und Becken aufgerichtet bleiben  ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung35":
                slideModelList.add(new SlideModel (R.drawable.f52, null));
                slideModelList.add(new SlideModel (R.drawable.f58, null));
                slideModelList.add(new SlideModel (R.drawable.f56, null));
                slideModelList.add(new SlideModel (R.drawable.f59, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Auf Stuhl setzen und Bein waagrecht zur Sitzfl??che austrecken\n" +
                                "- Zehnspitzen hochziehen, die vordere Oberschenkelmuskulatur anspannen und das Knie strecken\n" +
                                "- Fu?? wieder absetzen und dasselbe mit der anderen Seite wiederholen ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung36":
                slideModelList.add(new SlideModel (R.drawable.f60, null));
                slideModelList.add(new SlideModel (R.drawable.f57, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Schulterbreit vor einen Stuhl stellen und mit beiden H??nden auf dem\n" +
                                "Stuhl abst??tzen\n" +
                                "- F????e langsam zur Seite rutschen lassen, bis ein Dehngef??hl an der Innenseite der Oberschenkel entsteht\n" +
                                "- In der Dehnung halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

            case "uebung37":
                slideModelList.add(new SlideModel (R.drawable.f50, null));
                slideModelList.add(new SlideModel (R.drawable.f51, null));
                imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);
                fabBeschreibung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Zu dehnendes Bein nach hinten strecken, das andere Bein nach vorne\n" +
                                "beugen\n" +
                                "- Mit den H??nden an der Wand oder auf einem Stuhl abst??tzen\n" +
                                "- K??rper nach vorne abw??rts verlagern, bis eine Dehngef??hl in der Wade\n" +
                                "des hinteren Beines entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausf??hrung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                        alertDialog.show();


                    }
                });
                break;

        }


        imageSlider.setImageList(slideModelList, ScaleTypes.CENTER_INSIDE);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("??bungen");

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


        //TIMER
        mTextViewCountDown = findViewById(R.id.countdownView);

        mButtonStartPause = findViewById(R.id.StartPauseKnopf);
        mButtonStartPause.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.start_exercise));  //Austauschen des Icons
        //Braucht es reset?

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning){
                    pauseTimer();
                    mButtonStartPause.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.start_exercise));  //Austauschen des Icons

                } else {
                    startTimer();
                    mButtonStartPause.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), ic_baseline_pause_24));  //Austauschen des Icons

                }
            }
        });




    }






    //TIMER
    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                //mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);

                Toast.makeText(mTextViewCountDown.getContext(), "Geschafft!", Toast.LENGTH_LONG).show();

            }
        }.start();

        mTimerRunning = true;
        //mButtonStartPause.setText("pause");
        //
    }

    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        //mButtonStartPause.setText("Start");
        //
    }

    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        //updateCountDownText();
        //
        //
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000)/60;
        int seconds = (int) (mTimeLeftInMillis/1000)%60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText((timeLeftFormatted));
    }



}
