package com.paradoxclient.paradox.presenter;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preference {

    private Context context = null;
    public final String prefName = "Eutigo";
    private String profileImageURL;
    private String appName;

    public Preference(Context context) {
        this.context = context;
    }

    public String getString(String key, String def) {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        String s = prefs.getString(key, def);
        return s;
    }

    public void setString(String key, String val) {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = prefs.edit();
        e.putString(key, val);
        e.commit();
    }

    public void setBoolean(String key, boolean val){
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = prefs.edit();
        e.putBoolean(key, val);
        e.commit();
    }

    public boolean getBoolean(String key){
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        boolean s = prefs.getBoolean(key, false);
        return s;
    }


    public  void clearData(){
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = prefs.edit();
        e.clear();
        e.commit();


    }

    public void setUserId(String UserId) {
        setString("UserId", UserId);
    }

    public String getUserId() {
        return getString("UserId", null);
    }

    public void setPermissionId(String PermissionId) {
        setString("PermissionId", PermissionId);
    }

    public String getPermissionId() {
        return getString("PermissionId", null);
    }

    public void setUserName(String UserName) {
        setString("getUserName", UserName);
    }

    public String getUserName() {
        return getString("getUserName", null);
    }

    public void setAndroidDeviceToken(String AndroidDeviceToken) {
        setString("AndroidDeviceToken", AndroidDeviceToken);
    }

    public String getAndroidDeviceToken() {
        return getString("AndroidDeviceToken", null);
    }

    public void setPaymetVerified(String isVerified) {
        setString("setPaymetVerified", isVerified);
    }

    public String getPaymetVerified() {
        return getString("setPaymetVerified", null);
    }

    public void setAccessToken(String AccessToken) {
        setString("AccessToken", AccessToken);
    }

    public String getAccessToken() {
        return getString("AccessToken", null);
    }

    public void setIsProUser(String ispro) {
        setString("proUser", ispro);
    }

    public String getIsProUser() {
        return getString("proUser", "");
    }

    public void setName(String Name) {
        setString("Name", Name);
    }

    public String getName() {
        return getString("Name", "");
    }
    public void setReferralCode(String Name) {
        setString("referralCode", Name);
    }

    public String getReferralCode() {
        return getString("referralCode", "");
    }
    public void setInstallreferr(String Name) {
        setString("setInstallreferr", Name);
    }

    public String getInstallreferr() {
        return getString("setInstallreferr", "");
    }

    public void setTheme(int themeCode) {
        setString("theme", ""+themeCode);
    }

    public String getTheme() {
        return getString("theme", "");
    }

    public void setEmail(String Email) {
        setString("Email", Email);
    }

    public String getEmail() {
        return getString("Email", "");
    }

    public void setRecipientID(String Email) {
        setString("rec_id", Email);
    }

    public String getRecipientID() {
        return getString("rec_id", "");
    }

    public void setUserType(String UserType) {
        setString("usertype", UserType);
    }

    public String getUserType() {
        return getString("usertype", "");
    }

    public void setPhone(String Phone) {
        setString("Phone", Phone);
    }

    public String getPhone() {
        return getString("Phone", "");
    }
    public void setIsAdmin(String Phone) {
        setString("isAdmin", Phone);
    }

    public String getIsAdmin() {
        return getString("isAdmin", "");
    }

    public void setProfImage(String ProfImage) {
        setString("ProfImage", ProfImage);
    }

    public String getProfImage() {
        return getString("ProfImage", "");
    }

 public void setCartItems(String CartItems) {
        setString("CartItems", CartItems);
    }

    public String getCartItems() {
        return getString("CartItems", "");
    }



    public void setUserStatus(String setUserStatus) {
        setString("UserStatus", setUserStatus);
    }

    public String getUserStatus() {
        return getString("UserStatus", "");
    }

    public void setApiToken(String ApiToken){
        setString("ApiToken",ApiToken);
    }

    public String getApiToken() {
        return getString("ApiToken", "");
    }

    public void setFirebaseToken(String ApiToken){
        setString("Firebase",ApiToken);
    }

    public String getFirebaseToken() {
        return getString("Firebase", "");
    }

    public void setClientId(String ClientId){
        setString("ClientId",ClientId);
    }

    public String getClientId() {
        return getString("ClientId", "");
    }

    public void setSyc_sessionId(String sessionId){
        setString("sessionId",sessionId);
    }

    public String getSyc_sessionId() {
        return getString("sessionId", "");
    }

    public void setFlName(String FlName){
        setString("FlName",FlName);
    }

    public String getFlName() {
        return getString("FlName", "");
    }

    public void setRoleId(String RoleId) {
        setString("RoleId", RoleId);
    }

    public String getRoleId() {
        return getString("RoleId", "");
    }

    public void setRoleType(String RoleType) {
        setString("RoleType", RoleType);
    }

    public String getRoleType() {
        return getString("RoleType", "");
    }

    public void setLat(String lat) {
        setString("lat", lat);
    }

    public String getLat() {
        return getString("lat", "");
    }

    public void setLng(String lng) {
        setString("lng", lng);
    }

    public String getLng() {
        return getString("lng", "");
    }
    public void setDeviceToken(String DeviceToken) {
        setString("DeviceId", DeviceToken);
    }

    public String getDeviceToken() {
        return getString("DeviceId", "");
    }

    public boolean isOTPVerified() {
        return getBoolean("isOtpVerified");
    }

    public void setOTPVerified(Boolean flag) {
        setBoolean("isOtpVerified", flag);
    }

    public void setGender(String gender) {
        setString("gender", gender);
    }

    public String getGender(){
        return getString("gender", "");
    }

    public void setAge(String age) {
        setString("age", age);
    }

    public String getAge(){
        return getString("age", "");
    }

    public void setWeightInKg(String weightInKg) {
        setString("weightInKg", weightInKg);
    }

    public String getWeightInKg(){
        return getString("weightInKg", "");
    }

    public void setWeightInLbs(String weightInLbs) {
        setString("weightInLbs", weightInLbs);
    }

    public String getWeightInLbs() {
        return getString("weightInLbs", "");
    }

    public void setHeightInCm(String heightInCm) {
        setString("heightInCm", heightInCm);
    }

    public String getHeightInCm() {
        return getString("heightInCm", "");
    }

    public void setHeightInFt(String heightInFt) {
        setString("heightInFt", heightInFt);
    }

    public String getHeightInFt() {
        return getString("heightInFt", "");
    }

    public void setBodyFatPercentage(String bodyfat) {
        setString("bodyfat", bodyfat);
    }

    public String getBodyFatPercentage() {
        return getString("bodyfat", "");
    }
    public void setTargetBodyFatPercentage(String targetfat) {
        setString("targetfat", targetfat);
    }

    public String getTargetBodyFatPercentage() {
        return getString("targetfat", "");
    }
    public void setGoal(String goal) {
        setString("getGoal", goal);
    }

    public String getGoal() {
        return getString("getGoal", "");
    }

    public void setWorkoutList(String workList) {
        setString("workoutList", workList);
    }

    public String getWorkoutList() {
        return getString("workoutList", "");
    }

    public void setPremiumMenber(boolean status) {
        setBoolean("isPremiumMenber", status);
    }

    public boolean isPremiumMenber() {
        return getBoolean("isPremiumMenber");
    }


    public void setContactInfo(String ContactInfo) {
        setString("ContactInfo", ContactInfo);
    }

    public String getContactInfo() {
        return getString("ContactInfo", "");
    }



    public void setAcademic(String Academic) {
        setString("Academic", Academic);
    }

    public String getAcademic() {
        return getString("Academic", "");
    }

    public String getResumeName() {
        return getString("ResumeName", "");
    }
    public void setResumeName(String ResumeName) {
        setString("ResumeName", ResumeName);
    }

    public String getTempletId() {
        return getString("TempletId", "");
    }
    public void setTempletId(String TempletId) {
        setString("TempletId", TempletId);
    }


    public String getResumeBuilder() {
        return getString("ResumeBuilder", "");
    }

    public void setResumeBuilder(String ResumeBuilder) {
        setString("ResumeBuilder", ResumeBuilder);
    }

    public void setWorkingExp(String WorkingExp) {
        setString("WorkingExp", WorkingExp);
    }

    public String getWorkingExp() {
        return getString("WorkingExp", "");
    }



    public void setProject(String Project) {
        setString("Project", Project);
    }

    public String getProject() {
        return getString("Project", "");
    }



    public void setReference(String Reference) {
        setString("Reference", Reference);
    }

    public String getReference() {
        return getString("Reference", "");
    }


    public void setCareerObj(String CareerObj) {
        setString("CareerObj", CareerObj);
    }

    public String getCareerObj() {
        return getString("CareerObj", "");
    }


    public void setCoverLetter(String CoverLetter) {
        setString("CoverLetter", CoverLetter);
    }

    public String getCoverLetter() {
        return getString("CoverLetter", "");
    }

    public void setSkills(String Skills) {
        setString("Skills", Skills);
    }

    public String getSkills() {
        return getString("Skills", "");
    }

    public void setAchievements(String Achievements) {
        setString("Achievements", Achievements);
    }

    public String getAchievements() {
        return getString("Achievements", "");
    }


    public void setResumeImage(String ResumeImage) {
        setString("ResumeImage", ResumeImage);
    }

    public String getResumeImage() {
        return getString("ResumeImage", "");
    }

    public void setResumeId(String ResumeId) {
        setString("ResumeId", ResumeId);
    }

    public String getResumeId() {
        return getString("ResumeId", "");
    }

    public void setAppDownloadLink(String AppDownloadLink) {
        setString("getAppDownloadLink", AppDownloadLink);
    }

    public String getAppDownloadLink() {
        return getString("getAppDownloadLink", "");
    }


    public void setParentReferralCode(String Name) {
        setString("parent_referralCode", Name);
    }

    public String getParentReferralCode() {
        return getString("parent_referralCode", "");
    }




















    /*--ProviderState--*//*
    public void setProviderState(String ProviderState) {
        setString("ProviderState", ProviderState);
    }

    public String getProviderState() {
        return getString("ProviderState", "");
    }


    *//*--DeviceId--*//*
    public void setDeviceId(String DeviceId) {
        setString("DeviceId", DeviceId);
    }

    public String getDeviceId() {
        return getString("DeviceId", "");
    }


    *//*--Latitude--*//*
    public void setLatitude(Double Latitude) {
        setString("Latitude", String.valueOf(Latitude));
    }

    public Double getLatitude() {
//        return Double.parseDouble(getString("Latitude", "0.0"));
        String latitude = getString("Latitude", null);
        if (latitude != null) {
            return Double.parseDouble(latitude);
        }else{
            return null;
        }
    }

    *//*--Longitude--*//*
    public void setLongitude(Double Longitude) {
        setString("Longitude", String.valueOf(Longitude));
    }

    public Double getLongitude() {
        String longitude = getString("Longitude", null);
        if (longitude != null) {
            return Double.parseDouble(longitude);
        }else{
            return null;
        }
    }

    *//*--CustId--*//*
    public void setUserId(String UserId) {
        setString("UserId", UserId);
    }

    public String getUserId() {
        return getString("UserId", null);
    }
    public void setUserType(String UserId) {
        setString("user_type", UserId);
    }

    public String getUserType() {
        return getString("user_type", null);
    }





    public void setLoginType(String UserId) {
        setString("login_type", UserId);
    }

    public String getLoginType() {
        return getString("login_type", null);
    }


    *//*--SessionToken--*//*
    public void setSessionToken(String SessionToken) {
        setString("SessionToken", SessionToken);
    }

    public String getSessionToken() {
        return getString("SessionToken", null);
    }

    *//*--Email--*//*
    public void setEmail(String Email) {
        setString("Email", Email);
    }

    public String getEmail() {
        return getString("Email", "");
    }


    *//*--Name--*//*
    public void setName(String Name) {
        setString("Name", Name);
    }

    public String getName() {
        return getString("Name", "");
    }

    *//*CustAddress*//*
    public void setCustAddress(String CustAddress) {
        setString("CustAddress", CustAddress);
    }

    public String getCustAddress() {
        return getString("CustAddress", "");
    }

    *//*--CustDrivingLincese--*//*
    public void setCustDrivingLincese(String CustDrivingLincese) {
        setString("CustDrivingLincese", CustDrivingLincese);
    }

    public String getCustDrivingLincese() {
        return getString("CustDrivingLincese", "");
    }

    *//*--CustDrivingLincese--*//*
    public void setCustDrivingLinceseNo(String CustDrivingLinceseNo) {
        setString("CustDrivingLinceseNo", CustDrivingLinceseNo);
    }

    public String getCustDrivingLinceseNo() {
        return getString("CustDrivingLinceseNo", "");
    }


    *//*--CustImage--*//*
    public void setCustImage(String CustImage) {
        setString("CustImage", CustImage);
    }

    public String getCustImage() {
        return getString("CustImage", "");
    }

    *//*--CustPhNo--*//*
    public void setCustPhNo(String CustPhNo) {
        setString("CustPhNo", CustPhNo);
    }

    public String getCustPhNo() {
        return getString("CustPhNo", "");
    }

    *//*--SocialUser--*//*
    public void setIsSocialUser(String IsSocialUser) {
        setString("IsSocialUser", IsSocialUser);
    }

    public String getIsSocialUser() {
        return getString("IsSocialUser", "");
    }


    *//*--StartTime--*//*
    public void setStartTime(String StartTime) {
        setString("StartTime", StartTime);
    }

    public String getStartTime() {
        return getString("StartTime", "");
    }


    *//*--EndTime--*//*
    public void setEndTime(String EndTime) {
        setString("EndTime", EndTime);
    }

    public String getEndTime() {
        return getString("EndTime", "");
    }

    *//*--PinCode--*//*
    public void setPinCode(String PinCode) {
        setString("PinCode", PinCode);
    }

    public String getPinCode() {
        return getString("PinCode", "");
    }


    *//*--Date Of Birth--*//*
    public void setDOB(String DOB) {
        setString("DOB", DOB);
    }

    public String getDOB() {
        return getString("DOB", "");
    }


    *//*--Date Of Birth--*//*
    public void setPremiumMenber(boolean status) {
        setBoolean("HomeDelivery", status);
    }

    public boolean isPremiumMenber() {
        return getBoolean("HomeDelivery");
    }


    *//*--DeviceId--*//*
    public void setProfileImageURL(String profileImageURL) {
        setString("ImageURL", profileImageURL);
    }

    public String getProfileImageURL() {
        return getString("ImageURL", "");
    }

    public void setFullName(String volume) {
        setString("full_name", volume);
    }

    public String getFullName() {
        return getString("full_name", "");
    }
    public void setVolumeLavel(String volume) {
        setString("volume_level", volume);
    }

    public String getVolumeLavel() {
        return getString("volume_level", "");
    }


    public void setAppName(String appName) {
        setString("app_name", appName);
    }
    public String getAppName() {
        return getString("app_name", "");
    }

    public void setDeviceToken(String deviceToken) {
        setString("device_token", deviceToken);
    }
    public String getDeviceToken() {
        return getString("device_token", "");
    }*/
}

