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
                                "- Kopf langsam nach oben neigen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf Richtung Schulter neigen, bis Dehngefühl im Bereich der gegenüberliegenden Kopf-Nackenpartie entsteht\n" +
                                "- Dann direkt zur anderen Seite neigen\n" +
                                "- Kopf nicht in der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf zur Seite drehen bis ein Dehngefühl entsteht\n" +
                                "- Kopf zur anderen Seite drehen\n" +
                                "- Kopf nicht in der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf Richtung Schulter neigen, bis ein Dehngefühl im gegenüberliegenden Kopf-Nacken-Bereich entsteht\n" +
                                "- Kopf vorsichtig weiter zur Seite neigen\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Kopf nach vorne neigen bis ein Dehngefühl im Nacken entsteht\n" +
                                "- Kopf vorsichtig mit beiden Händen weiter neigen\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Schultern vorwärts oder rückwärts kreisen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit aufrechtem Rücken auf einen Stuhl setzen, so dass keine Lehne am\n" +
                                "Rücken ist\n" +
                                "- Schulterblätter zusammenziehen (mit den Armen hinter dem Rücken die\n" +
                                "Handinnenfläche nach außen und die Daumen nach innen drehen)\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Hände zusammenfalten und die Arme vor dem Körper ausstrecken\n" +
                                "- Schulter und Arme nach vorne unten stoßen, dabei das Kinn in Richtung\n" +
                                "Nacken geschoben halten\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "Wand abstützen\n" +
                                "- Oberkörper vorsichtig von dem aufgestützten Arm wegdrehen bis ein\n" +
                                "Dehngefühl in der Brustmuskulatur entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "stoßen, bis ein Dehngefühl am hinteren Teil der Schulter und des Oberarms entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Ellbogen des zu dehnenden Armes von hinten fassen und vor dem Körper zur entgegengesetzten Schulter hin ziehen\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Zu dehnender Unterarm vor dem Körper gestreckt im Ellbogen halten\n" +
                                "- Mit Hilfe der anderen Hand zu dehnende Hand langsam nach unten biegen, bis ein Dehngefühl im Unterarm entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit flacher Hand auf dem Tisch abstützen (Finger zum Körper, Ellbogen\n" +
                                "gestreckt)\n" +
                                "- Körpergewicht nach hinten verlagern, bis ein Dehngefühl an den Innenseiten der Unterarme entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Eine Hand stützt auf dem Tisch, anderer Arm hängt entspannt und pendelt kreisförmig\n" +
                                "- Immer wieder die Kreisrichtung wechseln ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Sitzen Oberkörper und Kopf zwischen die Knie senken, sodass der Rücken möglichst rund wird\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Die Übung findet im Sitzen statt\n" +
                                "- Kinn zur Brust hinbewegen, Oberkörper einrollen\n" +
                                "- Kopf und Schultern bleiben locker, das Gesäß hebt sich nicht von der\n" +
                                "Sitzfläche ab\n" +
                                "- Die Endpositon nicht halten, mit beiden Händen den Nacken fassen,\n" +
                                "Oberkörper aufrichten/strecken und das Brustbein zur Decke heben (Blick\n" +
                                "zur Decke)\n" +
                                "- Wenn eine Rückenlehne vorhanden ist, kann man sich auch anlehnen\n" +
                                "- Endposition nicht halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("  Hände seitlich auf den Schultern\n" +
                                "- Rumpf seitlich nach links und rechts neigen, ohne nach vorne/hinten\n" +
                                "auszuweichen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Die Übung findet im Sitzen statt\n" +
                                "- Die Arme über dem Brustkorb kreuzen und die Fingerspitzen auf die\n" +
                                "Schultern legen\n" +
                                "- Den Oberkörper nach rechts und links drehen, der Kopf folgt der Bewegung\n ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- An einer offenen Tür an den Griffen festhalten\n" +
                                "- In die Hocke gehen und dabei den Rücken dehnen\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Stehen Körper zur Seite neigen und Arm schräg nach oben strecken\n" +
                                "- Das Becken bleibt ruhig\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit dem Rücken gegen die Wand stellen, Schultern und Hände gegen\n" +
                                "die Wand drücken\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Die Übung findet im Sitzen statt\n" +
                                "- Arme vor der Brust verschränken und die Schultern nach vorne zusammenziehen\n" +
                                "- Oberkörper nach vorne beugen, gleichzeitig drehen und seitwärts in dieselben Richtung neigen" +
                                " - Mit dem Blick der Bewegung folgen\n" +
                                "- Während der Bewegung ausatmen, dann zurück zur Ausgangsstellung\n" +
                                "und dasselbe in die andere Richtung wiederholen").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Im Sitzen den Rücken nach hinten einsinken lassen und ihn danach mit\n" +
                                "Hilfe der Rückenmuskulatur wieder strecken\n" +
                                "- Kein zu starkes Hohlkreuz machen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "dass der Rumpf weder nach vorne noch nach hinten kippt\n ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Im Sitzen ein Bein an den Oberkörper ziehen und anwinkeln\n" +
                                "- Mit den Armen das gebeugte Knie weiter Richtung gegenseitiger Schulter ziehen\n" +
                                "- Ein Dehngefühl entsteht an der hinteren Oberschenkelmuskulatur und\n" +
                                "im Gesäß\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Ein Fußgelenk mit der Hand hinten fassen, Knie zeigt in Richtung Boden\n" +
                                "- Fuß Richtung Gesäß ziehen, ohne ein zu starkes Hohlkreuz zuzulassen,\n" +
                                "bis Dehngefühl am vorderen Oberschenkel entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Körper aufrichten\n" +
                                "- Knie strecken und Fußspitzen in Richtung Kniescheibe hochziehen\n" +
                                "- Sollte die Dehnung nicht ausreichen, den Oberkörper gerade nach vorne\n" +
                                "neigen, bis eine Dehnung gespürt wird\n" +
                                "- In der Endposition halten  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Oberkörper zur Seite über das Bein neigen, bis ein Dehngefühl an der Innenseite des Oberschenkels entsteht\n" +
                                "- In der Endposition halten\n ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Bei geradem, vorgeneigtem Rücken das Knie sanft Richtung Boden\n" +
                                "schieben, bis ein Dehngefühl tief im Gesäß und an der Oberschenkelaußenseite entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Mit gestreckten Armen und geradem Rücken gegen eine Wand stützen,\n" +
                                "Füße zusammen\n" +
                                "- Körper zur Wand sinken lassen, Fußsohlen bleiben auf dem Boden\n" +
                                "- Die Dehnung ist in den Waden zu spüren ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Mit den Händen das Knie des vorderen Beines abstützen, das andere\n" +
                                "Knie gestreckt halten\n" +
                                "- Becken nach vorne unten drücken, bis ein Dehngefühl an der Vorderseite des Oberschenkels und in der Leistengegend entsteht\n" +
                                "- Rücken aufrecht halten\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Leicht an Stuhl/Wand abstützen\n" +
                                "- In den Zehenstand hochstemmen und langsam zurück ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Seitlich auf eine Treppenstufe stellen und mit den Händen an Wand/Geländer festhalten\n" +
                                "- Ein Bein über die Kante hängen lassen\n" +
                                "- Bein vorwärts und rückwärts pendeln lassen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage("- Beine schulterbreit aufstellen, Knie beugen, Knie und Fußspitzen zeigen\n" +
                                "nach außen\n" +
                                "- Beine strecken, wobei Rücken gerade und Becken aufgerichtet bleiben  ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Auf Stuhl setzen und Bein waagrecht zur Sitzfläche austrecken\n" +
                                "- Zehnspitzen hochziehen, die vordere Oberschenkelmuskulatur anspannen und das Knie strecken\n" +
                                "- Fuß wieder absetzen und dasselbe mit der anderen Seite wiederholen ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

                        AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).setMessage(" - Schulterbreit vor einen Stuhl stellen und mit beiden Händen auf dem\n" +
                                "Stuhl abstützen\n" +
                                "- Füße langsam zur Seite rutschen lassen, bis ein Dehngefühl an der Innenseite der Oberschenkel entsteht\n" +
                                "- In der Dehnung halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
                                "- Mit den Händen an der Wand oder auf einem Stuhl abstützen\n" +
                                "- Körper nach vorne abwärts verlagern, bis eine Dehngefühl in der Wade\n" +
                                "des hinteren Beines entsteht\n" +
                                "- In der Endposition halten ").setTitle("Ausführung").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
        getSupportActionBar().setTitle("Übungen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
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


         */


        fabset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UebungsetsActivity.class);
                startActivity(intent);
            }
        });


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
