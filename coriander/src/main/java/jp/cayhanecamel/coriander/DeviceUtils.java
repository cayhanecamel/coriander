package jp.cayhanecamel.coriander;


import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.DisplayMetrics;

public class DeviceUtils {


    /**
     * return the width DisplayMetrics
     *
     * @param activity
     */
    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    /**
     * return the width pixel size
     *
     * @param activity
     * @return
     */
    public static int getWidthPx(Activity activity) {
        DisplayMetrics metrics = getDisplayMetrics(activity);
        return metrics.widthPixels;
    }

    /**
     * return the height pixel size
     *
     * @param activity
     * @return
     */
    public static int getHeightPx(Activity activity) {
        DisplayMetrics metrics = getDisplayMetrics(activity);
        return metrics.heightPixels;
    }

    /**
     * return the height dpi (xdpi) size
     *
     * @param activity
     * @return
     */
    public static float getWidthDpi(Activity activity) {
        DisplayMetrics metrics = getDisplayMetrics(activity);
        return metrics.xdpi;
    }

    /**
     * return the height dpi (ydpi) size
     *
     * @param activity
     * @return
     */
    public static float getHeightDpi(Activity activity) {
        DisplayMetrics metrics = getDisplayMetrics(activity);
        return metrics.ydpi;
    }

    /**
     * return the width inch
     *
     * @param activity
     * @return
     */
    public static float getWidthInch(Activity activity) {
        return getWidthPx(activity) / getWidthDpi(activity);
    }

    /**
     * return the height inch
     *
     * @param activity
     * @return
     */
    public static float getHeightInch(Activity activity) {
        return getHeightPx(activity) / getHeightDpi(activity);
    }

    /**
     * return the display inch size
     *
     * @param activity
     * @return
     */
    public static double getScreenInch(Activity activity) {
        float widthIn = getWidthInch(activity);
        float heightIn = getHeightInch(activity);

        return Math.sqrt(widthIn * widthIn + heightIn * heightIn);
    }

    /**
     * return the display rotate
     *
     * @return
     */
    public static boolean isSystemAutoRotate(Context context) {
        return Settings.System.
                getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0) == 1;
    }

}
