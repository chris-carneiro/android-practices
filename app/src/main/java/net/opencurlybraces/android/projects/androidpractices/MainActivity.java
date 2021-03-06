package net.opencurlybraces.android.projects.androidpractices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {


    @InjectView (R.id.hello_text)
    TextView mHelloText;

    @InjectView (R.id.image_chooser)
    Button mImageChooserButton;

    //Identifies the way the user picks an image
    private static final int PICK_FROM_FILE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Apply butterknife views injection when annotated, no need to call any findViewById()
         * or so..
         */
        ButterKnife.inject(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

        /** Here check battery charging status, modify data update rate,
         resources usage etc... accordingly **/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @OnClick (R.id.image_chooser)
    void onClick() {
        chooseImage();
    }

    private void chooseImage() {
        Intent intent = new Intent();

        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent, "Complete action using"),
                PICK_FROM_FILE);
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);


        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                //release UI Resources here

            case TRIM_MEMORY_RUNNING_MODERATE:
                /**
                 *  app is running and not considered killable, but the device is running
                 *  low on memory and the system is actively killing processes in the LRU cache.
                 */
            case TRIM_MEMORY_RUNNING_LOW:
                /**
                 * Your app is running and not considered killable, but the device is running much
                 * lower on memory so you should release unused resources to improve system
                 * performance (which directly impacts your app's performance). */
            case TRIM_MEMORY_RUNNING_CRITICAL:
                /**
                 * Your app is still running, but the system has already killed most of the
                 * processes in the LRU cache, so you should release all non-critical resources
                 * now. If the system cannot reclaim sufficient amounts of RAM,
                 * it will clear all of the LRU cache and begin killing processes that the system
                 * prefers to keep alive, such as those hosting a running service.
                 */

            case TRIM_MEMORY_BACKGROUND:
                /**
                 * The system is running low on memory and your process is near the beginning of
                 * the LRU list. Although your app process is not at a high risk of being killed,
                 * the system may already be killing processes in the LRU cache. You should
                 * release resources that are easy to recover so your process will remain in the
                 * list and resume quickly when the user returns to your app.
                 */

            case TRIM_MEMORY_MODERATE:
                /**
                 * The system is running low on memory and your process is near the middle of the
                 * LRU list. If the system becomes further constrained for memory,
                 * there's a chance your process will be killed.
                 */

            case TRIM_MEMORY_COMPLETE:
                /**
                 * The system is running low on memory and your process is one of the first to be
                 * killed if the system does not recover memory now. You should release
                 * everything that's not critical to resuming your app state.
                 */
            default:
                // should not happen

        }
    }

}