package inc.plo.ha.haplo6;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class levels1 extends AppCompatActivity {

    private Button back;

    /**
    *Boolean values correspond to each of 16 buttons (c2r4 means column 2, row 4)
    *these values correspond to the on or off of each button (default is on)
    **/
    private boolean c1r1x;
    private boolean c1r2x;
    private boolean c1r3x;
    private boolean c1r4x;
    private boolean c2r1x;
    private boolean c2r2x;
    private boolean c2r3x;
    private boolean c2r4x;
    private boolean c3r1x;
    private boolean c3r2x;
    private boolean c3r3x;
    private boolean c3r4x;
    private boolean c4r1x;
    private boolean c4r2x;
    private boolean c4r3x;
    private boolean c4r4x;

    /**
    *declaring the textviews corresponding to each parent haplotype
    *dom corresponds to the dominance relationship of alleles
    **/
    TextView haplotype1, haplotype2, haplotype3, haplotype4, dom;
    /**
    *setDominance determines the dominance relationship of alleles 
    * 1 is A domiant to B, 2 is B dominant to A
    *this value is returned
    **/
    public int setDominance() {
        Random random = new Random();
        int dominant = random.nextInt(2);
        return dominant;
    }

    /**
    *the progeny method generates the genotypes and winning sequence of the parents
    **/
    public int[] progeny() {
    /**
    *the progeny array corresponds to the 4 parents
    **/
        int[] progeny = new int[4];
    /**
    *the gagnant array corresponds to the possible crosses of the parents
    **/    
        int[] gagnant = new int[16];
        int k = 0;
        Random rand = new Random();
    /**
    *each element of the progeny array is assigned to a value
    *the value corresponds to a genotype
    **/ 
        for (int p = 0; p < progeny.length; p++) {
            progeny[p] = (rand.nextInt(3)) + 1;
        }
    /**
    *each progeny is crossed with each other (4 progeny, 16 crosses)
    *2nd number of multiplication (y-axis) is +10 the genotype value to ensure each cross has a unique value
    *gagnant sequence comprised of cross values is returned
    **/     
        for (int q = 0; q < progeny.length; q++) {
            int qPrime = progeny[q] + 10;
            for (int j = 0; j < progeny.length; j++) {
                int g = progeny[j] * qPrime;
                gagnant[k] = g;
                k++;
            }
        }
        return gagnant;
    }

    /**
    *bProgeny method converts each element of gagnant to a 1 or 0
    *this is used to compare to the sequence generated by button clicks
    **/
    public int[] bProgeny() {
        /**
        *binary progeny array is same size as gagnant array
        *the scores in the if() statement correspond to compatible crosses
        *if the element of the gagnant array is one of the compatible value,
        *the corresponding element in the binaryProgeny array will equal 0
        *and correspond to an on button
        *note: the compatible values differ depending on which allele is dominant
        *the binary progeny array is returned
        **/
        int[] binaryProgeny = new int[16];
        for (int r = 0; r < gagnant.length; r++) {
            if (dominant == 0) {
                if (gagnant[r] == 13 | gagnant[r] == 26 | gagnant[r] == 33) {
                    binaryProgeny[r] = 0;
                } else {
                    binaryProgeny[r] = 1;
                }
            } else if (dominant == 1) {
                if (gagnant[r] == 13 | gagnant[r] == 22 | gagnant[r] == 33) {
                    binaryProgeny[r] = 0;
                } else {
                    binaryProgeny[r] = 1;
                }
            }
        }
        return binaryProgeny;
    }

    /**
    *the setDominance method is called and assigned to the integer dominant
    **/
    public int dominant = setDominance();
    /**
    *the sequence array elements will be 0 or 1 according to the corresponding button on/off click  
    *i.e. if button is on, sequence[element] will equal zero and will presume compatibility of cross
    **/
    public int[] sequence = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    /**
    *assigning integer arrays and calling the progeny and bProgeny methods
    **/
    public int[] gagnant = progeny();
    public int[] binaryProgeny = bProgeny();

    /**
    *if a button is clicked, the associated boolean value declared at the top is switched
    *and the corresponding element of the sequence is set to 0 or 1
    **/
    public void c1r1Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c1r1x == FALSE) {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.nobeet);
            sequence[0] = 1;
            c1r1x = TRUE;
        } else {
            findViewById(R.id.c1r1).setBackgroundResource(R.drawable.yesbeet);
            sequence[0] = 0;
            c1r1x = FALSE;
        }
    }

    public void c2r1Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c2r1x == FALSE) {
            findViewById(R.id.c2r1).setBackgroundResource(R.drawable.nobeet);
            sequence[1] = 1;
            c2r1x = TRUE;
        } else {
            findViewById(R.id.c2r1).setBackgroundResource(R.drawable.yesbeet);
            sequence[1] = 0;
            c2r1x = FALSE;
        }
    }

    public void c3r1Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c3r1x == FALSE) {
            findViewById(R.id.c3r1).setBackgroundResource(R.drawable.nobeet);
            sequence[2] = 1;
            c3r1x = TRUE;
        } else {
            findViewById(R.id.c3r1).setBackgroundResource(R.drawable.yesbeet);
            sequence[2] = 0;
            c3r1x = FALSE;
        }
    }

    public void c4r1Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c4r1x == FALSE) {
            findViewById(R.id.c4r1).setBackgroundResource(R.drawable.nobeet);
            sequence[3] = 1;
            c4r1x = TRUE;
        } else {
            findViewById(R.id.c4r1).setBackgroundResource(R.drawable.yesbeet);
            sequence[3] = 0;
            c4r1x = FALSE;
        }
    }

    public void c1r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c1r2x == FALSE) {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.nobeet);
            sequence[4] = 1;
            c1r2x = TRUE;
        } else {
            findViewById(R.id.c1r2).setBackgroundResource(R.drawable.yesbeet);
            sequence[4] = 0;
            c1r2x = FALSE;
        }
    }

    public void c2r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c2r2x == FALSE) {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.nobeet);
            sequence[5] = 1;
            c2r2x = TRUE;
        } else {
            findViewById(R.id.c2r2).setBackgroundResource(R.drawable.yesbeet);
            sequence[5] = 0;
            c2r2x = FALSE;
        }
    }

    public void c3r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c3r2x == FALSE) {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.nobeet);
            sequence[6] = 1;
            c3r2x = TRUE;
        } else {
            findViewById(R.id.c3r2).setBackgroundResource(R.drawable.yesbeet);
            sequence[6] = 0;
            c3r2x = FALSE;
        }
    }

    public void c4r2Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c4r2x == FALSE) {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.nobeet);
            sequence[7] = 1;
            c4r2x = TRUE;
        } else {
            findViewById(R.id.c4r2).setBackgroundResource(R.drawable.yesbeet);
            sequence[7] = 0;
            c4r2x = FALSE;
        }
    }

    public void c1r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c1r3x == FALSE) {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.nobeet);
            sequence[8] = 1;
            c1r3x = TRUE;
        } else {
            findViewById(R.id.c1r3).setBackgroundResource(R.drawable.yesbeet);
            sequence[8] = 0;
            c1r3x = FALSE;
        }
    }

    public void c2r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c2r3x == FALSE) {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.nobeet);
            sequence[9] = 1;
            c2r3x = TRUE;
        } else {
            findViewById(R.id.c2r3).setBackgroundResource(R.drawable.yesbeet);
            sequence[9] = 0;
            c2r3x = FALSE;
        }
    }

    public void c3r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c3r3x == FALSE) {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.nobeet);
            sequence[10] = 1;
            c3r3x = TRUE;
        } else {
            findViewById(R.id.c3r3).setBackgroundResource(R.drawable.yesbeet);
            sequence[10] = 0;
            c3r3x = FALSE;
        }
    }

    public void c4r3Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c4r3x == FALSE) {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.nobeet);
            sequence[11] = 1;
            c4r3x = TRUE;
        } else {
            findViewById(R.id.c4r3).setBackgroundResource(R.drawable.yesbeet);
            sequence[11] = 0;
            c4r3x = FALSE;
        }
    }

    public void c1r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c1r4x == FALSE) {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.nobeet);
            sequence[12] = 1;
            c1r4x = TRUE;
        } else {
            findViewById(R.id.c1r4).setBackgroundResource(R.drawable.yesbeet);
            sequence[12] = 0;
            c1r4x = FALSE;
        }
    }

    public void c2r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c2r4x == FALSE) {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.nobeet);
            sequence[13] = 1;
            c2r4x = TRUE;
        } else {
            findViewById(R.id.c2r4).setBackgroundResource(R.drawable.yesbeet);
            sequence[13] = 0;
            c2r4x = FALSE;
        }
    }

    public void c3r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c3r4x == FALSE) {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.nobeet);
            sequence[14] = 1;
            c3r4x = TRUE;
        } else {
            findViewById(R.id.c3r4).setBackgroundResource(R.drawable.yesbeet);
            sequence[14] = 0;
            c3r4x = FALSE;
        }
    }

    public void c4r4Click(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.cross);
        mp.start();
        if (c4r4x == FALSE) {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.nobeet);
            sequence[15] = 1;
            c4r4x = TRUE;
        } else {
            findViewById(R.id.c4r4).setBackgroundResource(R.drawable.yesbeet);
            sequence[15] = 0;
            c4r4x = FALSE;
        }
    }

    /**
    *when the submit button is clicked
    *the sequence and binary sequence arrays are made toString and compared
    *if they are equal, the player assigned the correct crosses as compatible/incompatible
    *if not equal, "nope, try again!"
    **/ 

    public void submitAnswer(View view) {
        String seq = Arrays.toString(sequence);
        String win = Arrays.toString(binaryProgeny);
        if (seq.equals(win)) {
            Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.tada);
            mp.start();
        } else {
            Toast.makeText(this, "Nope, try again!", Toast.LENGTH_LONG).show();
        }
    }

    /**
    *information button flashes a key that shows which genotypes are compatible
    **/
    public void information(View view) {
        Toast imageToast = new Toast(getBaseContext());
        LinearLayout toastLayout = new LinearLayout(getBaseContext());
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image = new ImageView(getBaseContext());
        if (dominant == 0) {
            image.setImageResource(R.drawable.sporodoms1);
        } else {
            image.setImageResource(R.drawable.sporodoms2);
        }
        toastLayout.addView(image);
        imageToast.setView(toastLayout);
        imageToast.setDuration(Toast.LENGTH_LONG);
        imageToast.show();
    }

    /**
    *reload button resets activity
    **/
    public void reload(View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane);
        mp.start();
        onRestart();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(levels1.this, levels1.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels1);

        /**
        *the dom value that represents dominant/recessive allele is shown to the playe in the textview dom
        **/ 
        dom = (TextView) findViewById(R.id.dominance);
        if (dominant == 0) {
            dom.setText("A > B");
        } else {
            dom.setText("A < B");
        }

        /**
        *each haplotype textview will show the user the haplotype of the parents
        *this is based on the first 4 elements of the gagnant array (0 corresponds to parent1, 1 to 2)
        *a color is associated with each genotype
        **/
        haplotype1 = (TextView) findViewById(R.id.haplotype1);
        if (gagnant[0] < 20) {
            haplotype1.setText("P1: AA");
            haplotype1.setTextColor(Color.MAGENTA);
        } else if (gagnant[0] > 30) {
            haplotype1.setText("P1: BB");
            haplotype1.setTextColor(Color.BLUE);
        } else if (gagnant[0] < 27 && gagnant[0] > 21) {
            haplotype1.setText("P1: AB");
            haplotype1.setTextColor(Color.RED);
        }
        haplotype2 = (TextView) findViewById(R.id.haplotype2);
        if (gagnant[1] < 20) {
            haplotype2.setText("P2: AA");
            haplotype2.setTextColor(Color.MAGENTA);
        } else if (gagnant[1] > 30) {
            haplotype2.setText("P2: BB");
            haplotype2.setTextColor(Color.BLUE);
        } else if (gagnant[1] < 27 && gagnant[1] > 21) {
            haplotype2.setText("P2: AB");
            haplotype2.setTextColor(Color.RED);
        }
        haplotype3 = (TextView) findViewById(R.id.haplotype3);
        if (gagnant[2] < 20) {
            haplotype3.setText("P3: AA");
            haplotype3.setTextColor(Color.MAGENTA);
        } else if (gagnant[2] > 30) {
            haplotype3.setText("P3: BB");
            haplotype3.setTextColor(Color.BLUE);
        } else if (gagnant[2] < 27 && gagnant[2] > 21) {
            haplotype3.setText("P3: AB");
            haplotype3.setTextColor(Color.RED);
        }
        haplotype4 = (TextView) findViewById(R.id.haplotype4);
        if (gagnant[3] < 20) {
            haplotype4.setText("P4: AA");
            haplotype4.setTextColor(Color.MAGENTA);
        } else if (gagnant[3] > 30) {
            haplotype4.setText("P4: BB");
            haplotype4.setTextColor(Color.BLUE);
        } else if (gagnant[3] < 27 && gagnant[3] > 21) {
            haplotype4.setText("P4: AB");
            haplotype4.setTextColor(Color.RED);
        }


        /**
        *the back button launches an activity that returns the the selfincompatibility home class
        **/ 

        back = (Button) findViewById(R.id.back2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, si.class);
        startActivity(intent);
    }
}