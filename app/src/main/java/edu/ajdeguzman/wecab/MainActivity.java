package edu.ajdeguzman.wecab;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.parse.Parse;
import com.parse.ParseUser;

import edu.ajdeguzman.parseui.ParseLoginBuilder;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parse.initialize(this, getResources().getString(R.string.parse_app_id),getResources().getString(R.string.parse_client_key));
        /*FacebookSdk.sdkInitialize(this);
        ParseFacebookUtils.initialize(this);*/

        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }*/
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment fHymn = new FragmentUCUHymn();
        Fragment fMap = new FragmentCampusMap();
        Fragment fhandbook= new FragmentSearchCab();
        Fragment fcontactUs = new FragmentContactUs();
        Fragment fstudOrg = new FragmentStudentOrg();
        Fragment fCourses = new FragmentCabsNearby();
        Fragment fHome = new FragmentNewsFeed();
        FragmentSearchCab fOrgChart = new FragmentSearchCab();
        FragmentTransaction t = getFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                t.replace(R.id.container, fHome);
                t.addToBackStack(null);
                t.commit();
                break;
            case 1:
                t.replace(R.id.container, fhandbook);
                t.addToBackStack(null);
                t.commit();
                break;
            case 2:
                t.replace(R.id.container, fCourses);
                t.addToBackStack(null);
                t.commit();
                break;
            case 3:
                t.replace(R.id.container, fOrgChart);
                t.addToBackStack(null);
                t.commit();
                break;
            case 4:
                t.replace(R.id.container, fstudOrg);
                t.addToBackStack(null);
                t.commit();
                break;
            case 5:
                t.replace(R.id.container, fHymn);
                t.addToBackStack(null);
                t.commit();
                break;
            case 6:
                t.replace(R.id.container, fMap);
                t.addToBackStack(null);
                t.commit();
                break;
            case 7:
               open();
                break;
        }
    }
    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                ParseUser.logOut();
                ParseLoginBuilder builder = new ParseLoginBuilder(getApplicationContext());
                startActivityForResult(builder.build(), 0);
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }

}
