package com.paradoxclient.paradox.presenter;

import android.net.Uri;

//import com.bumptech.glide.Glide;

public class Constants {

    public static String REFERRAL_CODE = "";
    public static String ApiKey="0a2b8d7f9243305f2a4700e1870f673b";
    public static final String CHANNEL_ID = "my_channel_01";
    public static final String CHANNEL_NAME = "Simplified Coding Notification";
    public static final String CHANNEL_DESCRIPTION = "www.simplifiedcoding.net";

    public enum ENVIRONMENT{
        STAGING,DEVELOPMENT, PRODUCTION
    }
//    public static final ENVIRONMENT environment = ENVIRONMENT.PRODUCTION;

    public static final ENVIRONMENT environment = ENVIRONMENT.STAGING;

    public static final String KEY_CATEGORY_ID = "subcription_id";
    public static final String PAYTM_CHANNEL_ID = "WAP";
    public static final String KEY_SUBSCRIPTION_ID = "package_id";
    public static final String KEY_AMOUNT = "price";
    public static final String KEY_PACKAGE_DETAILS = "pack_details";
    public static final String MY_PREFS_NAME = "eutigo_pref";
    public static final String FCM_TOKEN = "fcm_token";
    public static Uri ImageURI;
    private static String getBaseURL() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            //return "https://relateme.co.in/api/";
            return "https://admin.relateme.in/";
        } else if (environment == ENVIRONMENT.STAGING) {
            //return "https://relateme.co.in/api/";
            return "https://admin.relateme.in/";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            //return "https://relateme.co.in/api/";
            return "https://admin.relateme.in/";
        }
        return null;

    }

    private static String getWebsite() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "APPPROD";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "APPSTAGING";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "APPPROD";
        }
        return null;

    } private static String getIndustryType() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "Retail109";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "Retail";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "Retail109";
        }
        return null;

    } private static String getCallbackUrl() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=";
        }
        return null;

    } private static String getPaytmMarchentKey() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "21#etFB2ZKDYCZOo";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "cxLIg0p727n2J58K";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "21#etFB2ZKDYCZOo";
        }
        return null;

    }
    private static String getGetPaytmMarchentID() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "Firstc21303538879613";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "XHLBvv80703977592043";
        }else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "Firstc21303538879613";
        }
        return null;

    }

    private static Long getInmobiInstantialPlacement() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return  1554913226136L;
        }else if (environment == ENVIRONMENT.STAGING) {
            return  1552536619060L;
        } else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return  1552536619060L;
        }
        return null;
    }
    private static String getS3BucketBaseURL() {
        if (environment == ENVIRONMENT.PRODUCTION) {
            return "https://s3.ap-south-1.amazonaws.com/eutigo-prod/";
        } else if (environment == ENVIRONMENT.STAGING) {
            return "https://s3.ap-south-1.amazonaws.com/eutigo-staging/";
        } else if (environment == ENVIRONMENT.DEVELOPMENT) {
            return "https://s3.ap-south-1.amazonaws.com/eutigo-staging/";
        }
        return null;

    }

    public static String BASE_URL =getBaseURL();
    public static final String CANCELLATION_POLICY_URL = BASE_URL+"returns-refunds-policy-app";
    public static final String CONTACT_US_URL =  BASE_URL+"contact-app";
    public static final String ABOUT_US_URL =  BASE_URL+"about-app";
    public static String S3_BUCKET_BASE_PATH =getS3BucketBaseURL();
    public static final Long INMOBI_INSANSTATIAL_PLACEMENT_ID = getInmobiInstantialPlacement();
    public static int ADS_SHOW_MULTIPIER = 0;
    public static int ADS_FREQUENCY  = 3;
    public static final String PAYTM_MID = getGetPaytmMarchentID();
    public static final String MARCHENT_KEY = getPaytmMarchentKey();
    public static final String PAYTM_CALLBACK_URL = getCallbackUrl();
    public static final String PAYTM_INDUSTRY_TYPE_ID = getIndustryType();
    public static final String PAYTM_WEBSITE =getWebsite() ;//live

    public static final String ABOUT_US="<h2>ABOUT US</h2>\n" +
            "\t\t\t<p>PSJ gives you expanded the features by including jewellery and gold coin ordering and delivery in Kolkata</p>\n" +
            "\t\t\t<p>You can buy many categories of jewellery that include Anniversaries, Birthdays, Kids, Party, and Friendship and love.</p>\n" +
            "\t\t\t<p>We are giving best quality of gold at minimum making charges.</p>\n" +
            "\t\t\t<p>PSJ app can deliver your order at one day if product is available in PSJ store";

}
