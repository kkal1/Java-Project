package inc.plo.ha.haplo6;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class epistasis2 extends AppCompatActivity {
    /**
     * Assign variables as a string or an integer and also assign the combo of 0 and 1 that result in a specific colour (output)
     */
    private Button back;
    String[] alleles = new String[5];
    int[] epistasis = new int[5];
    int[] r = new int[5];
    int[] winning = new int[5];
    int[] sequence = new int[5];
    private int[] bleu = {1, 1, 1, 0, 0};
    private int[] rouge = {1, 0, 1, 1, 0};
    private int[] jaune = {1, 1, 0, 0, 1};
    private int[] orang = {1, 1, 0, 1, 1};
    private int[] mauve = {1, 1, 1, 1, 0};
    private int[] vert = {1, 1, 1, 0, 1};
    private int[] brun = {1, 1, 1, 1, 1};
    private int[] gris = {0, 0, 0, 0, 0};
    //grey if [0] == 0, blue if [0] == 1, [1] == 1, [2] ==0


    /**
     * Create the layout for the information window showing the examples and description of how to complete the level. 
     */

    public void info (View view) {
        Toast imageToast = new Toast(getBaseContext());
        LinearLayout toastLayout = new LinearLayout(getBaseContext());
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image = new ImageView(getBaseContext());
        image.setImageResource(R.drawable.colorcombo);
        toastLayout.addView(image);
        imageToast.setView(toastLayout);
        imageToast.setDuration(Toast.LENGTH_LONG);
        imageToast.show();
        Toast imageToast2 = new Toast(getBaseContext());
        LinearLayout toastLayout2 = new LinearLayout(getBaseContext());
        toastLayout2.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image2 = new ImageView(getBaseContext());
        toastLayout2.addView(image2);
        image2.setImageResource(R.drawable.epitwopic);
        imageToast2.setView(toastLayout2);
        imageToast2.setDuration(Toast.LENGTH_LONG);
        imageToast2.show();
    }


    /**
     * Assign a string variable to the 3 different alleles for each parent haplotype
     */
    public void genotype() {
        Random rand = new Random();
        String[] AA = new String[]{"AA", "Aa", "aa"};
        String[] BB = new String[]{"BB", "Bb", "bb"};
        String[] CC = new String[]{"Cc", "Cc", "cc"};
        String[] DD = new String[]{"DD", "Dd", "dd"};
        String[] EE = new String[]{"EE", "Ee", "ee"};
        /**
     * Create a for loop where for every 3 random integers generated, assign an allele type to each string variable
     */
        for (int i = 0; i < r.length; i++) {
            r[i] = rand.nextInt(3);
        }
        alleles[0] = AA[r[0]];
        alleles[1] = BB[r[1]];
        alleles[2] = CC[r[2]];
        alleles[3] = DD[r[3]];
        alleles[4] = EE[r[4]];
        Button theButton = (Button) findViewById(R.id.submit);
        String leGenotype = alleles[0]+alleles[1]+alleles[2]+alleles[3]+alleles[4];
        theButton.setText(leGenotype);

    /**
     * create a for loop to output specific colours when the epistatic allele is either a 0 or 1. When it is 0, the result is grey. When it is 1, the output is blue. 
     */
        for(int k=0; k<epistasis.length; k++) {
            if (r[k] == 2) {
                epistasis[k] = 0;
            } else {
                epistasis[k] = 1;
            }
        }if(epistasis[0] == 0){
            epistasis = gris;
        }if(epistasis[1] == 0 && epistasis[2] ==1){
            epistasis = bleu;
        }if(epistasis[1] == 0 && epistasis[2] ==0){
            epistasis = gris;
        }
        winning = epistasis;
    }

    /**
     * Assign a button a colour when it is clicked 
     */
    public void red (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.redd));
        sequence = rouge;
    }
    public void blue (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.bluee));
        sequence = bleu;
    }
    public void yellow (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.yelloww));
        sequence = jaune;
    }
    public void green (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.greenn));
        sequence = vert;
    }
    public void purple (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.purplee));
        sequence = mauve;
    }
    public void orange (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.orangee));
        sequence = orang;
    }
    public void brown (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.brownn));
        sequence = brun;
    }
    public void grey (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        Button theButton = (Button) findViewById(R.id.submit);
        theButton.setTextColor(getResources().getColor(R.color.greyy));
        sequence[0] = 0;
        sequence = gris;
    }


    /**
     * Create the output of when submit is clicked. If the clicked sequence of colours is equal to the winning combination of numbers and colours, type  "you got it" or type "try again"
     */
    public void submit (View view){
        String theSequence = Arrays.toString(sequence);
        String theWinning = Arrays.toString(winning);
        if(theSequence.equals(theWinning)){
            Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.tada);
            mp.start();
        }else{
            Toast.makeText(this, "Nope, try again!" +theSequence+theWinning, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Restart the game if the refresh button is clicked. 
     */
    public void refresh (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane);
        mp.start();
        onRestart();
    }
    @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(epistasis2.this, epistasis2.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epistasis2);

        genotype();
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
