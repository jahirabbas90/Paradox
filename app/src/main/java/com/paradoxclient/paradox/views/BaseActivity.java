package com.paradoxclient.paradox.views;

import android.Manifest;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.paradoxclient.paradox.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressDialog mProgressDialog;
    public Preference preference=null;
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;
    public static boolean isCategoryView=false;
    String email ;
    public static int height,width;
    public ArrayList<String> mainMenuitems;
    public ArrayList<String> streamList;
    private int actionBarHeight;
    public static boolean flag=true;
    private ProgressDialog mProgressDialog2;
    public static int clickCoun=0;
    public HashMap<Integer, Boolean> workoutStatusMap;
    public static Bitmap croppedImage;
    public static String userName;
    private Dialog dialog;
    public static final int READ_WRITE_STORAGE = 52;
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;

    private String TAG="Inmobi ADS";
    public static SharedPreferences sharedpreferences;
    private String dateSelected;
    private String firstFourChars;
    int onStartCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onStartCount = 1;
        if (savedInstanceState == null){
            this.overridePendingTransition(R.anim.enter_from_left,R.anim.exit_to_right);
        } else {
            onStartCount = 2;
        }

        sharedpreferences = getSharedPreferences("RatingPreferance", Context.MODE_PRIVATE);

        JSONObject consent = new JSONObject();

        workoutStatusMap = new HashMap<>();
        preference = new Preference(BaseActivity.this);
        Display display = getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();
        //  setDefaultExceptionHandler();
        //Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        setDefaultExceptionHandler();
        //changeTheme();


      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/




        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        String str = Build.BRAND;
        System.out.print("" + str);
        mainMenuitems = new ArrayList<>();
        streamList = new ArrayList<>();
        mainMenuitems.add("STREAM");
        mainMenuitems.add("QR-CODE");
        mainMenuitems.add("GROUPS");
        mainMenuitems.add("CONTACTS");
        mainMenuitems.add("PROFILE");
        mainMenuitems.add("SETTINGS");
        mainMenuitems.add("BACKUP");
        streamList.add("NEW CATEGORY");
        streamList.add("STREAM SETTINGS");


    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        if (onStartCount > 1) {
            this.overridePendingTransition(R.anim.enter_from_right,
                    R.anim.exit_to_left);

        } else if (onStartCount == 1) {
            onStartCount++;
        }

    }


    public Integer getCurrenyyear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        String datef = sdf.format(timestamp);
        if (datef.length() > 4)
        {
            firstFourChars = datef.substring(0, 4);
        }
        else
        {
            firstFourChars = firstFourChars;
        }
        return Integer.parseInt(firstFourChars);
    }

    public void isPermissionGranted(boolean isGranted, String permission) {

    }

    public void makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case READ_WRITE_STORAGE:
                isPermissionGranted(grantResults[0] == PackageManager.PERMISSION_GRANTED, permissions[0]);
                break;
        }
    }

    public boolean requestPermission(String permission) {
        boolean isGranted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        if (!isGranted) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{permission},
                    READ_WRITE_STORAGE);
        }
        return isGranted;
    }

    public boolean isNetworkConnected() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec
                =(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
            //Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        }else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  ) {
          //  Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;


    }


    private void setDefaultExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                Log.e("BaseActivity", "Default Exception Handler : ");

                final String DOUBLE_LINE_SEP = "\r\n\r\n";
                final String SINGLE_LINE_SEP = "\r\n";
                StackTraceElement[] arr = e.getStackTrace();
                final StringBuffer report = new StringBuffer(e.toString());
                final String lineSeparator = "-------------------------------\n\n";
                report.append(DOUBLE_LINE_SEP);
                report.append("--------- Stack trace ---------\n\n");
                for (int i = 0; i < arr.length; i++) {
                    report.append("    ");
                    report.append(arr[i].toString());
                    report.append(SINGLE_LINE_SEP);
                }

                // If the exception was thrown in removeWishlistItemRequest background thread inside
                // AsyncTask, then the actual exception can be found with
                // getCause
                Throwable cause = e.getCause();
                if (cause != null) {
                    report.append(lineSeparator);
                    report.append("--------- Cause ---------\n\n");
                    report.append(cause.toString());
                    report.append(DOUBLE_LINE_SEP);
                    arr = cause.getStackTrace();
                    for (int i = 0; i < arr.length; i++) {
                        report.append("    ");
                        report.append(arr[i].toString());
                        report.append(SINGLE_LINE_SEP);
                    }
                }

                //  System.err.println(report.toString());

                // Getting the Device brand,model and sdk version details.
                report.append(lineSeparator);
                report.append("--------- Device ---------\n\n");
                report.append("Brand: ");
                report.append(Build.BRAND);
                report.append(SINGLE_LINE_SEP);
                report.append("Device: ");
                report.append(Build.DEVICE);
                report.append(SINGLE_LINE_SEP);
                report.append("Model: ");
                report.append(Build.MODEL);
                report.append(SINGLE_LINE_SEP);
                report.append("Metric: ");

                int density = getResources().getDisplayMetrics().densityDpi;

                switch (density) {
                    case DisplayMetrics.DENSITY_LOW:
                        report.append("LDPI ");
                        break;
                    case DisplayMetrics.DENSITY_MEDIUM:
                        report.append("MDPI ");
                        break;
                    case DisplayMetrics.DENSITY_HIGH:
                        report.append("HDPI ");
                        break;
                    case DisplayMetrics.DENSITY_XHIGH:
                        report.append("XHDPI ");
                        break;
                }

                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);

                report.append(String.valueOf(dm.widthPixels) + "x" + String.valueOf(dm.heightPixels) + "  " + String.valueOf(dm.densityDpi) + "dpi");
                report.append(SINGLE_LINE_SEP);
                report.append("Id: ");
                report.append(Build.ID);
                report.append(SINGLE_LINE_SEP);
                report.append("Product: ");
                report.append(Build.PRODUCT);
                report.append(SINGLE_LINE_SEP);
                report.append(lineSeparator);
                report.append("--------- Firmware ---------\n\n");
                report.append("SDK: ");
                report.append(Build.VERSION.SDK);
                report.append(SINGLE_LINE_SEP);
                report.append("Release: ");
                report.append(Build.VERSION.RELEASE);
                report.append(SINGLE_LINE_SEP);
                report.append("Incremental: ");
                report.append(Build.VERSION.INCREMENTAL);
                report.append(SINGLE_LINE_SEP);
                report.append(lineSeparator);

                //Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(BaseActivity.this));

                /*Intent crashedIntent = new Intent(BaseActivity.this, CrashActivity.class);
                crashedIntent.putExtra("stacktrace", report.toString());
                crashedIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                crashedIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(crashedIntent);
                System.exit(0);*/
            }

        });
    }




    protected boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    public void hideKeyBoard(ViewPager et) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    public void showKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void showDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setMessage("Loading..");
            mProgressDialog.setCancelable(false);
        }

        if(mProgressDialog.isShowing())
            mProgressDialog.dismiss();

        mProgressDialog.show();
    }


    public void hideDialog() {
        if (mProgressDialog!= null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    public void showMsg(String msg) {
        Toast toast= Toast.makeText(this,msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
//        displayDialog(msg);
    }

    protected void showBackArrow() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
    }
    public int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    // A method to find height of the status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    TypedValue tv = new TypedValue();
    public int actionBarHeiht(){
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }


    protected void hideSoftKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void toogleDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            drawerLayout.openDrawer(GravityCompat.START);
    }

    public void showToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }


    protected String getUserID(){
        mPref=getSharedPreferences("Stripe_Data",MODE_PRIVATE);
        return String.valueOf(mPref.getInt("_id",0));
    }

    public SpannableString underlineText(String text){

        SpannableString str_underline = new SpannableString(text);

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        str_underline.setSpan(new UnderlineSpan(), 0, str_underline.length(), flag);

        return str_underline;

    }

    public boolean validateEmail(String thisname) {
        String regexStrforEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(!thisname.matches(regexStrforEmail))
            return false;

        return true;
    }

    public static void alertDialog(Context con, String msg , String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(con);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage(msg)
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                /*.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });*/

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(title);
        alert.show();
    }

    public static void alertDialogWithClick(Context con, String msg , String title, final SuccessListener _callback){
        AlertDialog.Builder builder = new AlertDialog.Builder(con);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        _callback.onYesClick();
                    }
                });
                /*.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });*/

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(title);
        alert.show();
    }


    public interface SuccessListener  {
        void onYesClick();
    }

    public interface ForgetPasswordListener{
        void onYesClick(String email);
    }



    protected View view;

    private final int maxLines = 4;
    private final String[] permissions = new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE };








    protected void hideViews() {}

    public void setView(View view) {
        this.view = view;
    }



    static double PI_RAD = Math.PI / 180.0;

    /**
     * Use Great Circle distance formula to calculate distance between 2 coordinates in meters.
     */
    /*double greatCircleInFeet(LatLng latLng1, LatLng latLng2) {
        return greatCircleInKilometers(latLng1.latitude, latLng1.longitude, latLng2.latitude,
                latLng2.longitude) * 3280.84;
    }

    *//**
     * Use Great Circle distance formula to calculate distance between 2 coordinates in meters.
     *//*
    public double greatCircleInMeters(LatLng latLng1, LatLng latLng2) {
        return greatCircleInKilometers(latLng1.latitude, latLng1.longitude, latLng2.latitude,
                latLng2.longitude) * 1000;
    }*/

    /**
     * Use Great Circle distance formula to calculate distance between 2 coordinates in kilometers.
     * https://software.intel.com/en-us/blogs/2012/11/25/calculating-geographic-distances-in-location-aware-apps
     */



    public Bitmap getThumbFromVideo(String videoPath) throws Throwable {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 19)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);

            bitmap = mediaMetadataRetriever.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Throwable(
                    "Exception in retriveVideoFrameFromVideo(String videoPath)"
                            + e.getMessage());

        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }


    public Date getdate(String date){
        String[] parts = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2]),10,20,20);

        return calendar.getTime();
    }
    public String getdateMounth(String date){
        String[] parts = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2]),10,20,20);
        String date1 =calendar.getTime().getDate()+"/"+(calendar.getTime().getMonth()+1);
        return date1;
    }
    public void clearSurface(Surface surface) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay display = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl.eglInitialize(display, null);

        int[] attribList = {
                EGL10.EGL_RED_SIZE, 8,
                EGL10.EGL_GREEN_SIZE, 8,
                EGL10.EGL_BLUE_SIZE, 8,
                EGL10.EGL_ALPHA_SIZE, 8,
                EGL10.EGL_RENDERABLE_TYPE, EGL14.EGL_OPENGL_ES2_BIT,
                EGL10.EGL_NONE, 0,      // placeholder for recordable [@-3]
                EGL10.EGL_NONE
        };
        EGLConfig[] configs = new EGLConfig[1];
        int[] numConfigs = new int[1];
        egl.eglChooseConfig(display, attribList, configs, configs.length, numConfigs);
        EGLConfig config = configs[0];
        EGLContext context = egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, new int[]{
                EGL14.EGL_CONTEXT_CLIENT_VERSION, 2,
                EGL10.EGL_NONE
        });
        EGLSurface eglSurface = egl.eglCreateWindowSurface(display, config, surface,
                new int[]{
                        EGL14.EGL_NONE
                });

        egl.eglMakeCurrent(display, eglSurface, eglSurface, context);
        GLES20.glClearColor(0, 0, 0, 1);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        egl.eglSwapBuffers(display, eglSurface);
        egl.eglDestroySurface(display, eglSurface);
        egl.eglMakeCurrent(display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                EGL10.EGL_NO_CONTEXT);
        egl.eglDestroyContext(display, context);
        egl.eglTerminate(display);
    }

    public void setWorkoutStatus(Integer position, Boolean status){

        workoutStatusMap.put(position, status);
        Log.d("STATUS", position+": " + getWorkoutStatus().get(position));
        System.out.println("PRINT "+position+": " + getWorkoutStatus().get(position));

    }

    public HashMap<Integer, Boolean> getWorkoutStatus() {
        return workoutStatusMap;
    }
    /** Returns the consumer friendly device name */
    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    public String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    public static boolean isCardValid(String cardNumber){
        int sum = 0 ;
        boolean even = false;
        String cardType = null;

        int firstDigit = getDigit(cardNumber,1);
        switch (firstDigit){
            case 4:
                cardType = "Visa";
                break;
            case 3:
                if (getDigit(cardNumber,2)==7) {
                    cardType= "American Express";
                } else {
                    return false;
                }
            case 5:
                cardType = "Master Card";
                break;
            case 6:
                cardType = "Discover";
                break;
        } //end card type switch

        int secondDigit = getDigit(cardNumber, 2);

        //loops through digits in reverse order right to left
        for (int i = cardNumber.length();i>0; i--){
            int digit = getDigit(cardNumber, i);

            //double every other digit
            if (even)
                digit += digit;

            even = ! even;

            //if result is greater than 9 then subtract 9
            if (digit > 9)
                digit = digit - 9;

            sum += digit;
        } //end of loop

        if (sum % 10 == 0)
        {
            System.out.println(cardNumber+" is valid");
            System.out.println("Card Type: "+cardType);
            return true;
        }
        else {
            System.out.println(cardNumber+ " is invalid");
            System.out.println("Card Type: Invalid");
            return false;
        }
    } //end of isValid class

    //gets digit at specified position
    private static int getDigit(String digitString, int position){
        String characterAtPosition = digitString.substring(position - 1, position);
        return Integer.parseInt(characterAtPosition);
    }
    boolean validateCardExpiryDate(String expiryDate) {
        return expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
    }
    public String vidDurSec(Uri uriOfFile){
        MediaPlayer mp = MediaPlayer.create(this,uriOfFile);
        long duration = mp.getDuration();
        long sec=(duration/1000)/60;
        mp.release();
        /*convert millis to appropriate time*/
        return String.valueOf(sec);
    }


    public boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }

    /**
     * Hide alert dialog if any.
     */
    @Override
    protected void onStop() {
        super.onStop();

    }






    public void showSnackBar(CoordinatorLayout coordinatorLayout, String message ){
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.white_700));
        //TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        //textView.setTextColor(Color.RED);
        snackbar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void getDate(final EditText editTextq){
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        int month= monthOfYear + 1;
                        String monthStr="";
                        switch (month){
                            case 1:
                                monthStr= "Jan";
                                break;
                            case 2:
                                monthStr= "Feb";
                                break;
                            case 3:
                                monthStr= "Mar";
                                break;
                            case 4:
                                monthStr= "Apr";
                                break;
                            case 5:
                                monthStr= "May";
                                break;
                            case 6:
                                monthStr= "Jun";
                                break;
                            case 7:
                                monthStr= "Jul";
                                break;
                            case 8:
                                monthStr= "Aug";
                                break;
                            case 9:
                                monthStr= "Sep";
                                break;
                            case 10:
                                monthStr= "Oct";
                                break;
                            case 11:
                                monthStr= "Nov";
                                break;
                            case 12:
                                monthStr= "Dec";
                                break;
                        }


                        dateSelected=dayOfMonth + "-"+monthStr+"-" + year;
                        editTextq.setText(dateSelected);




                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }
    public void getFromDate(final EditText editText){
        // Get Current Date
        final Calendar c = Calendar.getInstance();

      /*  c.set(Calendar.YEAR, 1990);

        c.set(Calendar.MONTH, 10);

        c.set(Calendar.DAY_OF_MONTH, 02);
*/

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        int month= monthOfYear + 1;


                        String monthStr="";
                        switch (month){
                            case 1:
                                monthStr= "Jan";
                                break;
                            case 2:
                                monthStr= "Feb";
                                break;
                            case 3:
                                monthStr= "Mar";
                                break;
                            case 4:
                                monthStr= "Apr";
                                break;
                            case 5:
                                monthStr= "May";
                                break;
                            case 6:
                                monthStr= "Jun";
                                break;
                            case 7:
                                monthStr= "Jul";
                                break;
                            case 8:
                                monthStr= "Aug";
                                break;
                            case 9:
                                monthStr= "Sep";
                                break;
                            case 10:
                                monthStr= "Oct";
                                break;
                            case 11:
                                monthStr= "Nov";
                                break;
                            case 12:
                                monthStr= "Dec";
                                break;
                        }

                        dateSelected=dayOfMonth + "-"+monthStr+"-" + year;
                        editText.setText(dateSelected);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }

    public void getToDate(final EditText editText){
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        int month= monthOfYear + 1;
                        String monthStr="";
                        switch (month){
                            case 1:
                                monthStr= "Jan";
                                break;
                            case 2:
                                monthStr= "Feb";
                                break;
                            case 3:
                                monthStr= "Mar";
                                break;
                            case 4:
                                monthStr= "Apr";
                                break;
                            case 5:
                                monthStr= "May";
                                break;
                            case 6:
                                monthStr= "Jun";
                                break;
                            case 7:
                                monthStr= "Jul";
                                break;
                            case 8:
                                monthStr= "Aug";
                                break;
                            case 9:
                                monthStr= "Sep";
                                break;
                            case 10:
                                monthStr= "Oct";
                                break;
                            case 11:
                                monthStr= "Nov";
                                break;
                            case 12:
                                monthStr= "Dec";
                                break;
                        }


                        dateSelected=dayOfMonth + "-"+monthStr+"-" + year;
                        editText.setText(dateSelected);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }

    public void mandatoryField(EditText editText){
        //TextView text = (TextView)findViewById(R.id.text);

        String simple = "";
        String colored = "*";
        SpannableStringBuilder builder = new SpannableStringBuilder();

        builder.append(simple);
        int start = builder.length();
        builder.append(colored);
        int end = builder.length();

        builder.setSpan(new ForegroundColorSpan(Color.RED), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        editText.setHint(builder);
    }


}
