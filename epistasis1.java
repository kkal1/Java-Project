package inc.plo.ha.haplo6;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Random;

/**
 * declare variable that allows for color change when button is pressed (cycles between 0-3)
 */
public class epistasis1 extends AppCompatActivity {

    private int c1r1x =0;
    private int c1r2x =0;
    private int c1r3x =0;
    private int c1r4x =0;
    private int c2r1x =0;
    private int c2r2x =0;
    private int c2r3x =0;
    private int c2r4x =0;
    private int c3r1x =0;
    private int c3r2x =0;
    private int c3r3x =0;
    private int c3r4x =0;
    private int c4r1x =0;
    private int c4r2x =0;
    private int c4r3x =0;
    private int c4r4x =0;
    private Button back;
    /**
     * declare genotype textviews (e.g. AB, Bc)
     */
    TextView b1, b2, b3, b4, b5, b6, b7, b8;
    public int lock;

    /**
     * declare new random variable to be passed to the Random method
     */
    Random rand = new Random();
    /**
     * picks which allele combinations to examine
     */
    int alleles = rand.nextInt(6);

    /**
     * Proper sequence for A and B cross is the sequence in the array AB.
     * The same goes for the rest of the private int's below
     */
    private int[] AB = {0,0,0,0,0,1,0,1,0,0,2,2,0,1,2,3};
    private int[] ACAD = {0,0,0,0,0,3,0,3,0,0,2,2,0,3,2,3};
    private int[] BCBD = {0,0,0,0,0,3,0,3,0,0,1,1,0,3,1,3};
    private int[] CD = {0,0,0,0,0,3,0,3,0,0,3,3,0,3,3,3};

    /**
     * associates alleles to genotype (e.g. alleles 0 assigns to array AB)
     */
    public int[] finalCross(){
        int[] cross = new int[16];
        if(alleles == 0){
            cross = AB;
        }else if(alleles == 1| alleles == 2){
            cross = ACAD;
        }else if(alleles == 3| alleles == 4){
            cross = BCBD;
        }else{
            cross = CD;
        }return cross;
    }

    /**
     * calls final cross method and assigns to a variable "theCross"
     */
    public int[] theCross = finalCross();

    /**
     * the empty array that you build by clicking (e.g. click first button once, sequence[0]=1;
     */
    int[] sequence = new int[16];

    /**
     *c1r1Click will set the first number in the array in AB,ACAD,BCBD or CD to 0,1,2 or 3
     * depending on how many times the user clicks on the indexed flower. So, if the user clicks
     * on the first flower in the AB thing 2 times, the AB array would be set to {2,0,0,0,0,0,0,
     * 0,0,0,0,0,0,0,0}
     * Also, the colour of the flower is set to grey, red, blue or purple depending on
     * how many times the user clicks on the flower (e.g. 2 clicks sets the colour to grey).
     * The same formula is used for the next 15 methods (up until c4r4Click)
     */
    public void c1r1Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c1r1x == 0) {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.redflower);
            sequence[0] = 1;
            c1r1x = 1;
        } else if (c1r1x == 1) {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.blueflower);
            sequence[0] = 2;
            c1r1x = 2;
        } else if (c1r1x == 2) {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.greyflower);
            sequence[0] = 3;
            c1r1x = 3;
        } else if (c1r1x == 3) {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.purpleflower);
            sequence[0] = 0;
            c1r1x = 0;
            }
        }
    public void c2r1Click(View v) {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
            mp.start();
            if (c2r1x == 0) {
                findViewById(R.id.c2r1).setBackgroundResource(R.drawable.redflower);
                sequence[1] = 1;
                c2r1x = 1;
            } else if (c2r1x == 1) {
                findViewById(R.id.c2r1).setBackgroundResource(R.drawable.blueflower);
                sequence[1] = 2;
                c2r1x = 2;
            } else if (c2r1x == 2) {
                findViewById(R.id.c2r1).setBackgroundResource(R.drawable.greyflower);
                sequence[1] = 3;
                c2r1x = 3;
            }else if (c2r1x == 3) {
                findViewById(R.id.c2r1).setBackgroundResource(R.drawable.purpleflower);
                sequence[1] = 0;
                c2r1x = 0;
            }
        }
        public void c3r1Click(View v) {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
            mp.start();
            if (c3r1x == 0) {
                findViewById(R.id.c3r1).setBackgroundResource(R.drawable.redflower);
                sequence[2] = 1;
                c3r1x = 1;
            } else if (c3r1x == 1) {
                findViewById(R.id.c3r1).setBackgroundResource(R.drawable.blueflower);
                sequence[2] = 2;
                c3r1x = 2;
            } else if (c3r1x == 2) {
                findViewById(R.id.c3r1).setBackgroundResource(R.drawable.greyflower);
                sequence[2] = 3;
                c3r1x = 3;
            }else if (c3r1x == 3) {
                findViewById(R.id.c3r1).setBackgroundResource(R.drawable.purpleflower);
                sequence[2] = 0;
                c3r1x = 0;
            }
        }
        public void c4r1Click(View v) {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
            mp.start();
            if (c4r1x == 0) {
                findViewById(R.id.c4r1).setBackgroundResource(R.drawable.redflower);
                sequence[3] = 1;
                c4r1x = 1;
            } else if (c4r1x == 1) {
                findViewById(R.id.c4r1).setBackgroundResource(R.drawable.blueflower);
                sequence[3] = 2;
                c4r1x = 2;
            } else if (c4r1x == 2) {
                findViewById(R.id.c4r1).setBackgroundResource(R.drawable.greyflower);
                sequence[3] = 3;
                c4r1x = 3;
            }else if (c4r1x == 3) {
                findViewById(R.id.c4r1).setBackgroundResource(R.drawable.purpleflower);
                sequence[3] = 0;
                c4r1x = 0;
            }
        }
        public void c1r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c1r2x == 0) {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.redflower);
            sequence[4] = 1;
            c1r2x = 1;
        } else if (c1r2x == 1) {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.blueflower);
            sequence[4] = 2;
            c1r2x = 2;
        } else if (c1r2x == 2) {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.greyflower);
            sequence[4] = 3;
            c1r2x = 3;
        } else if (c1r2x == 3) {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.purpleflower);
            sequence[4] = 0;
            c1r2x = 0;
        }
    }
    public void c2r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c2r2x == 0) {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.redflower);
            sequence[5] = 1;
            c2r2x = 1;
        } else if (c2r2x == 1) {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.blueflower);
            sequence[5] = 2;
            c2r2x = 2;
        } else if (c2r2x == 2) {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.greyflower);
            sequence[5] = 3;
            c2r2x = 3;
        }else if (c2r2x == 3) {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.purpleflower);
            sequence[5] = 0;
            c2r2x = 0;
        }
    }
    public void c3r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c3r2x == 0) {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.redflower);
            sequence[6] = 1;
            c3r2x = 1;
        } else if (c3r2x == 1) {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.blueflower);
            sequence[6] = 2;
            c3r2x = 2;
        } else if (c3r2x == 2) {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.greyflower);
            sequence[6] = 3;
            c3r2x = 3;
        }else if (c3r2x == 3) {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.purpleflower);
            sequence[6] = 0;
            c3r2x = 0;
        }
    }
    public void c4r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c4r2x == 0) {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.redflower);
            sequence[7] = 1;
            c4r2x = 1;
        } else if (c4r2x == 1) {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.blueflower);
            sequence[7] = 2;
            c4r2x = 2;
        } else if (c4r2x == 2) {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.greyflower);
            sequence[7] = 3;
            c4r2x = 3;
        }else if (c4r2x == 3) {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.purpleflower);
            sequence[7] = 0;
            c4r2x = 0;
        }
    }public void c1r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c1r3x == 0) {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.redflower);
            sequence[8] = 1;
            c1r3x = 1;
        } else if (c1r3x == 1) {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.blueflower);
            sequence[8] = 2;
            c1r3x = 2;
        } else if (c1r3x == 2) {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.greyflower);
            sequence[8] = 3;
            c1r3x = 3;
        } else if (c1r3x == 3) {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.purpleflower);
            sequence[8] = 0;
            c1r3x = 0;
        }
    }public void c2r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c2r3x == 0) {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.redflower);
            sequence[9] = 1;
            c2r3x = 1;
        } else if (c2r3x == 1) {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.blueflower);
            sequence[9] = 2;
            c2r3x = 2;
        } else if (c2r3x == 2) {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.greyflower);
            sequence[9] = 3;
            c2r3x = 3;
        }else if (c2r3x == 3) {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.purpleflower);
            sequence[9] = 0;
            c2r3x = 0;
        }
    }
    public void c3r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c3r3x == 0) {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.redflower);
            sequence[10] = 1;
            c3r3x = 1;
        } else if (c3r3x == 1) {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.blueflower);
            sequence[10] = 2;
            c3r3x = 2;
        } else if (c3r3x == 2) {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.greyflower);
            sequence[10] = 3;
            c3r3x = 3;
        }else if (c3r3x == 3) {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.purpleflower);
            sequence[10] = 0;
            c3r3x = 0;
        }
    }
    public void c4r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c4r3x == 0) {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.redflower);
            sequence[11] = 1;
            c4r3x = 1;
        } else if (c4r3x == 1) {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.blueflower);
            sequence[11] = 2;
            c4r3x = 2;
        } else if (c4r3x == 2) {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.greyflower);
            sequence[11] = 3;
            c4r3x = 3;
        }else if (c4r3x == 3) {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.purpleflower);
            sequence[11] = 0;
            c4r3x = 0;
        }
    }public void c1r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c1r4x == 0) {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.redflower);
            sequence[12] = 1;
            c1r4x = 1;
        } else if (c1r4x == 1) {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.blueflower);
            sequence[12] = 2;
            c1r4x = 2;
        } else if (c1r4x == 2) {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.greyflower);
            sequence[12] = 3;
            c1r4x = 3;
        } else if (c1r4x == 3) {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.purpleflower);
            sequence[12] = 0;
            c1r4x = 0;
        }
    }public void c2r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c2r4x == 0) {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.redflower);
            sequence[13] = 1;
            c2r4x = 1;
        } else if (c2r4x == 1) {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.blueflower);
            sequence[13] = 2;
            c2r4x = 2;
        } else if (c2r4x == 2) {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.greyflower);
            sequence[13] = 3;
            c2r4x = 3;
        }else if (c2r4x == 3) {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.purpleflower);
            sequence[13] = 0;
            c2r4x = 0;
        }
    }
    public void c3r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c3r4x == 0) {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.redflower);
            sequence[14] = 1;
            c3r4x = 1;
        } else if (c3r4x == 1) {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.blueflower);
            sequence[14] = 2;
            c3r4x = 2;
        } else if (c3r4x == 2) {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.greyflower);
            sequence[14] = 3;
            c3r4x = 3;
        }else if (c3r4x == 3) {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.purpleflower);
            sequence[14] = 0;
            c3r4x = 0;
        }
    }
    public void c4r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        if (c4r4x == 0) {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.redflower);
            sequence[15] = 1;
            c4r4x = 1;
        } else if (c4r4x == 1) {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.blueflower);
            sequence[15] = 2;
            c4r4x = 2;
        } else if (c4r4x == 2) {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.greyflower);
            sequence[15] = 3;
            c4r4x = 3;
        }else if (c4r4x == 3) {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.purpleflower);
            sequence[15] = 0;
            c4r4x = 0;
        }
    }

    /**
     *restarts the activity and generates a new random genotype
     */
    public void toRefresh (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane);
        mp.start();
        onRestart();
    }

    /**
     *toInfo generates the info button that contains an explanation of the game. 'I' button.
     */
    public void toInfo (View view) {
        Toast imageToast = new Toast(getBaseContext());
        LinearLayout toastLayout = new LinearLayout(getBaseContext());
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image = new ImageView(getBaseContext());
        image.setImageResource(R.drawable.pathone);
        toastLayout.addView(image);
        imageToast.setView(toastLayout);
        imageToast.setDuration(Toast.LENGTH_LONG);
        imageToast.show();
        Toast imageToast2 = new Toast(getBaseContext());
        LinearLayout toastLayout2 = new LinearLayout(getBaseContext());
        toastLayout2.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image2 = new ImageView(getBaseContext());
        toastLayout2.addView(image2);
        image2.setImageResource(R.drawable.epionepic);
        imageToast2.setView(toastLayout2);
        imageToast2.setDuration(Toast.LENGTH_LONG);
        imageToast2.show();
    }


    /**
     *submit converts the 'sequence' and 'theCross' arrays into strings and then compares them.
     * If they match then the user wins the game and the app prints out "You got it!" and
     * plays a victory tune.
     */
    public void submit (View view){
        String seq = Arrays.toString(sequence);
        String win = Arrays.toString(theCross);
        if(seq.equals(win)){
            Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.tada);
            mp.start();
            lock++;
        }else{
            Toast.makeText(this, "Nope, try again!", Toast.LENGTH_LONG).show();
        }
    }
    @Override

    /**
     *onRestart restarts the game. It is called in the toRefresh method.
     */
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(epistasis1.this, epistasis1.class);
        startActivity(i);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epistasis1);

        /**
         * The int alleles variable will be randomly set to a numeric value from 0 to 5 above. Then
         * the finalCross method will set the 'cross' variable to the appropriate genotype (e.g.
         * if alleles == 1 then finalCross will set 'cross' to ACAD.
         */

        b1 = (TextView) findViewById(R.id.homodom);
        b2 = (TextView) findViewById(R.id.homodomx);
        b3 = (TextView) findViewById(R.id.het1);
        b4 = (TextView) findViewById(R.id.het1x);
        b5 = (TextView) findViewById(R.id.het2);
        b6 = (TextView) findViewById(R.id.het2x);
        b7 = (TextView) findViewById(R.id.homorec);
        b8 = (TextView) findViewById(R.id.homorecx);
        if (alleles == 0) {
            b1.setText("AB");
            b2.setText("AB");
            b3.setText("Ab");
            b4.setText("Ab");
            b5.setText("aB");
            b6.setText("aB");
            b7.setText("ab");
            b8.setText("ab");
        } else if (alleles == 1) {
            b1.setText("AC");
            b2.setText("AC");
            b3.setText("Ac");
            b4.setText("Ac");
            b5.setText("aC");
            b6.setText("aC");
            b7.setText("ac");
            b8.setText("ac");
        } else if (alleles == 2) {
            b1.setText("AD");
            b2.setText("AD");
            b3.setText("Ad");
            b4.setText("Ad");
            b5.setText("aD");
            b6.setText("aD");
            b7.setText("ad");
            b8.setText("ad");
        } else if (alleles == 3) {
            b1.setText("BC");
            b2.setText("BC");
            b3.setText("Bc");
            b4.setText("Bc");
            b5.setText("bC");
            b6.setText("bC");
            b7.setText("bc");
            b8.setText("bc");
        } else if (alleles == 4) {
            b1.setText("BD");
            b2.setText("BD");
            b3.setText("Bd");
            b4.setText("Bd");
            b5.setText("bD");
            b6.setText("bD");
            b7.setText("bd");
            b8.setText("bd");
        } else if (alleles == 5) {
            b1.setText("CD");
            b2.setText("CD");
            b3.setText("Cd");
            b4.setText("Cd");
            b5.setText("cD");
            b6.setText("cD");
            b7.setText("cd");
            b8.setText("cd");
        }

        	/**
        	*back button finished activity, returns to epistasis main screen
        	**/
            back = (Button) findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

