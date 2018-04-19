package inc.plo.ha.haplo6;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.PatternSyntaxException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class mutation3 extends AppCompatActivity {
    /**
     * Makes the text view and the buttons as well as the possible characters to be used as "DNA" bases
     */
    private TextView tv, tv1, tv2, tv3;
    private Button b1, b2, b3;
    private Button back;
    String[] alphabet = {"A","C","D","E","F","G","H","I","K","L","M","N","P","Q","R","S","T","V","W","X","Y"};
    String[] tvs = new String[]{"", "", "", ""};

    int[] winning = new int[3];
    int[] sequence = new int[3];

    int[] rando = randomNum();

    /**
     * randomly generates the different sequences based on
     * @return
     */
    public int[] randomNum() {
        int[] randomSequence = new int[3];
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        int i=0;
        while (numbers.size() < 3) {
            int random = (randomGenerator.nextInt(3)+1);
            if (!numbers.contains(random)) {
                numbers.add(random);
                randomSequence[i] = random;
                i++;
            }
        }return randomSequence;
    }

    /**
     * This makes the original sequence that the others are descended from. It is the first correct answer
     * It takes a randomly generated letters and puts them into the string.
     */

    public void progenitorSequence() {
        String[] proseq = new String[8];
        Random rand = new Random();
        for (int i = 0; i < proseq.length; i++) {
            int base = rand.nextInt(21);
            proseq[i] = alphabet[base];
        }
        String b = proseq[0] + proseq[1] + proseq[2] + proseq[3] + proseq[4] + proseq[5] + proseq[6] + proseq[7];
        int num = rando[0];
        if (num == 1) {
            tv = (TextView) findViewById(R.id.tv1);
            winning[0] = 1;
        } else if (num == 2) {
            tv = (TextView) findViewById(R.id.tv2);
            winning[0] = 2;
        } else if (num == 3) {
            tv = (TextView) findViewById(R.id.tv3);
            winning[0] = 3;
        }
        tv.setText(b);
        nextSequence(b);
        tvs[0] = "NOPE";
        tvs[num] = b;

    }
    /**
     * This one makes the next sequence based on the original one and a constant mutation rate.
     **/
    public void nextSequence(String cp ){
        String[] cp2 = cp.split("(?!^)");
        Random rand = new Random();
        int r1 = rand.nextInt(8);
        int r2 = rand.nextInt(21);
        cp2[r1] = alphabet[r2];
        int r3 = rand.nextInt(8);
        int r4 = rand.nextInt(21);
        cp2[r3] = alphabet[r4];
        String b = cp2[0]+cp2[1]+cp2[2]+cp2[3]+cp2[4]+cp2[5]+cp2[6]+cp2[7];
        int num = rando[1];
        if(num==1){
            tv = (TextView) findViewById(R.id.tv1);
            winning[1] = 1;
        }else if(num==2){
            tv = (TextView) findViewById(R.id.tv2);
            winning[1] = 2;
        }else if(num==3){
            tv = (TextView) findViewById(R.id.tv3);
            winning[1] = 3;
        }
        tv.setText(b);
        nextSequence2(b);
        tvs[num] = b;
    }

    /**
     * This takes the previous sequence mutates it and gets the third one
     * @param cp
     */

    public void nextSequence2(String cp ){
        String[] cp2 = cp.split("(?!^)");
        Random rand = new Random();
        int r1 = rand.nextInt(8);
        int r2 = rand.nextInt(21);
        cp2[r1] = alphabet[r2];
        int r3 = rand.nextInt(8);
        int r4 = rand.nextInt(21);
        cp2[r3] = alphabet[r4];
        String b = cp2[0]+cp2[1]+cp2[2]+cp2[3]+cp2[4]+cp2[5]+cp2[6]+cp2[7];
        int num = rando[2];
        if(num==1){
            tv = (TextView) findViewById(R.id.tv1);
            winning[2] = 1;
        }else if(num==2){
            tv = (TextView) findViewById(R.id.tv2);
            winning[2] = 2;
        }else if(num==3){
            tv = (TextView) findViewById(R.id.tv3);
            winning[2] = 3;
        }
        tv.setText(b);
        tvs[num] = b;
    }

    /**
     * Sounds
     * @param v
     */


    public void b1 (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        b1.setText("");
        sequence[0] = 0;
    }
    public void b2 (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        b2.setText("");
        sequence[1] = 0;
    }
    public void b3 (View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gun);
        mp.start();
        b3.setText("");
        sequence[2] = 0;
    }

    /**
     * This is for submitting your answer
     * @param view
     */
    public void submit (View view){
        String seq = Arrays.toString(sequence);
        String win = Arrays.toString(winning);
        if(seq.equals(win)){
            Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.tada);
            mp.start();
        }else{
            Toast.makeText(this, "Nope, try again!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This is for refreshing the page
     * @param view
     */
    public void refresh (View view){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane);
        mp.start();
        onRestart();
    }

    /**
     * Generates a "new" problem when you restart
     */
    @Override
    protected void onRestart() {

        super.onRestart();
        Intent i = new Intent(mutation3.this, mutation3.class);
        startActivity(i);
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutation3);
/**
 * Initialises the game and makes the buttons the receivers of the drag and the text view the source
 */
        progenitorSequence();

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        tv1.setOnLongClickListener(longClickListener);
        tv2.setOnLongClickListener(longClickListener);
        tv3.setOnLongClickListener(longClickListener);
        b1.setOnDragListener(dragListener);
        b2.setOnDragListener(dragListener2);
        b3.setOnDragListener(dragListener3);

        back = (Button)

                findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                launchActivityBack();
            }
        });

    }

    /**
     * new variable longClickListener assigned to method View.OnLongClickListener
     */

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data= ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };
    /**
     * This accepts you dragging and dropping your answer
     */
    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.tv1){
                        b1.setText(tvs[1]);
                        sequence[0] = 1;
                    }else if(view.getId() == R.id.tv2){
                        b1.setText(tvs[2]);
                        sequence[0] = 2;
                    }else if(view.getId() == R.id.tv3){
                        b1.setText(tvs[3]);
                        sequence[0] = 3;
                    }
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dragListener2 = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.tv1){
                        b2.setText(tvs[1]);
                        sequence[1] = 1;
                    }else if(view.getId() == R.id.tv2){
                        b2.setText(tvs[2]);
                        sequence[1] = 2;
                    }else if(view.getId() == R.id.tv3){
                        b2.setText(tvs[3]);
                        sequence[1] = 3;
                    }
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dragListener3 = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.tv1){
                        b3.setText(tvs[1]);
                        sequence[2] = 1;
                    }else if(view.getId() == R.id.tv2){
                        b3.setText(tvs[2]);
                        sequence[2] = 2;
                    }else if(view.getId() == R.id.tv3){
                        b3.setText(tvs[3]);
                        sequence[2] = 3;
                    }
                    break;
            }
            return true;
        }
    };

    private void launchActivityBack() {
        Intent intent = new Intent(this, mutationhome.class);
        startActivity(intent);
    }
}