package com.paradoxclient.paradox.presenter.restService;

import com.paradoxclient.paradox.presenter.Constants;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestInterface {
    String BASE_URL = Constants.BASE_URL+"api/";

    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> login(
                             @Field("email") String mobile,
                             @Field("password") String password,
                             @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> contact(@Query("page") int page,
                               @Header("Authorization") String token,
                               @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> favouriteContact(@Query("page") int page,
                               @Query("custom_universe") String universe,
                               @Header("Authorization") String token,
                               @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> universeMeetcontact(@Query("universe_meet") String universe_meet,
                               @Query("page") String page,
                               @Header("Authorization") String token,
                               @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> universeCallcontact(@Query("universe_call") String universe_call,
                                       @Query("page") String page,
                                       @Header("Authorization") String token,
                                       @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> universecontact(@Query("universe_call") String universe_call,
                                       @Query("universe_meet") String universe_meet,
                                       @Query("page") String page,
                                       @Header("Authorization") String token,
                                       @Header("Accept") String name);

    @GET("contacts")
    Call<ResponseBody> actualcontact(@Query("universe") String universe,
                                       @Query("page") String page,
                                       @Header("Authorization") String token,
                                       @Header("Accept") String name);

    @GET("dashboard")
    Call<ResponseBody> getDashBoardData(@Query("device_token") String device_token,
                                        @Header("Authorization") String token,
                                        @Header("Accept") String name);

    @GET("contacts/{id}")
    Call<ResponseBody> contactDetails(@Path("id") String id,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String name);

    //All groups Request
    @GET("groups")
    Call<ResponseBody> groups(@Header("Authorization") String token,
                               @Header("Accept") String name);

    @GET("groups/{id}")
    Call<ResponseBody> groupDetails(@Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @GET("institutes/{id}")
    Call<ResponseBody> collegeDetails(@Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @DELETE("groups/{id}")
    Call<ResponseBody> deleteGroup(@Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);
    @DELETE("lables/{id}")
    Call<ResponseBody> deleteLabel(@Path("id") String id,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @DELETE("activities/{id}")
    Call<ResponseBody> deleteActivity(@Path("id") String id,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @DELETE("organisation-groups/{id}")
    Call<ResponseBody> deleteOrganisationGroup(@Path("id") String id,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String name);

    @DELETE("organisations/{id}")
    Call<ResponseBody> deleteOrganisation(@Path("id") String id,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @DELETE("events/{id}")
    Call<ResponseBody> deleteEvent(@Path("id") String id,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @POST("influencer/delete/{id}")
    Call<ResponseBody> deleteInfluencer(@Path("id") String id,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);

    @POST("groups")
    @FormUrlEncoded
    Call<ResponseBody> addGroup(@Field("group_name") String group_name,
                                @Field("description") String description,
                                @Header("Authorization") String token,
                                @Header("Accept") String name);

    @POST("institutes")
    @FormUrlEncoded
    Call<ResponseBody> addEducation(@Field("name") String name,
                                @Field("type") String type,
                                @Field("sub_type") String sub_type,
                                @Field("address_line_1") String address_line_1,
                                @Field("address_line_2") String address_line_2,
                                @Field("addr_area") String addr_area,
                                @Field("addr_city") String addr_city,
                                @Field("addr_state") String addr_state,
                                @Field("addr_country_name") String addr_country_name,
                                @Field("website") String website,
                                @Header("Authorization") String token,
                                @Header("Accept") String accept);

    @PUT("institutes/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateEducation(@Path("id") String id,
                                       @Field("name") String name,
                                    @Field("type") String type,
                                    @Field("sub_type") String sub_type,
                                    @Field("address_line_1") String address_line_1,
                                    @Field("address_line_2") String address_line_2,
                                    @Field("addr_area") String addr_area,
                                    @Field("addr_city") String addr_city,
                                    @Field("addr_state") String addr_state,
                                    @Field("addr_country_name") String addr_country_name,
                                    @Field("website") String website,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String accept);

    @PUT("groups/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateGroup(@Path("id") String id,
                                @Field("group_name") String group_name,
                                @Field("description") String description,
                                @Header("Authorization") String token,
                                @Header("Accept") String name);

    @POST("contacts/transfer")
    @FormUrlEncoded
    Call<ResponseBody> transferGroup(@Field("form_group") String form_group,
                                @Field("to_group") String to_group,
                                @Header("Authorization") String token,
                                @Header("Accept") String name);

    @PUT("groups/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addContactToGroup(@Path("id") String id,
                                         @Field("contacts") String idList,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    @POST("contacts/transfer")
    @FormUrlEncoded
    Call<ResponseBody> contactTransfer(@Field("form_group") String group_name,
                                @Field("to_group") String description,
                                @Header("Authorization") String token,
                                @Header("Accept") String name);

    //All Labels Request
    @GET("lables")
    Call<ResponseBody> labels(@Query("device_token") String device_token,
                              @Header("Authorization") String token,
                              @Header("Accept") String name);

    @GET("lables/{id}")
    Call<ResponseBody> labelsDetails(@Path("id") String label_id ,
                                     @Header("Authorization") String token,
                              @Header("Accept") String name);

    @POST("lables")
    @FormUrlEncoded
    Call<ResponseBody> addNewLabel(@Field("label_name") String label_name,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);


    //String idList="1,7,8,9";

    @PUT("lables/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addContactToLabel(@Path("id") String id,
                                       @Field("contacts") String idList,
                                       @Field("label_name") String label_name,
                                       @Header("Authorization") String token,
                                       @Header("Accept") String name);

    @POST("add/group/to/organisations")
    @FormUrlEncoded
    Call<ResponseBody> addOrganisationtoGroup(@Field("id") String id,
                                         @Field("organisations_ids") String idList,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    //All Events Request
    @GET("events")
    Call<ResponseBody> allEvents(@Header("Authorization") String token,
                              @Header("Accept") String name);

    @GET("events/{id}")
    Call<ResponseBody> eventDetails(@Path("id") String id,
                                 @Header("Authorization") String token,
                                 @Header("Accept") String name);

    @POST("events")
    @FormUrlEncoded
    Call<ResponseBody> createEvents(@Field("start_date_time") String start_date_time,
                                       @Field("end_date_time") String end_date_time,
                                       @Field("venue") String venue,
                                       @Field("decription") String decription,
                                       @Field("event_title") String event_title,
                                       @Field("event_type") String event_type,
                                       @Field("is_online") String is_online,
                                       @Field("is_recurring") String is_recurring,
                                       @Field("is_recurring_occurance") String is_recurring_occurance,
                                       @Header("Authorization") String token,
                                       @Header("Accept") String name);

    @PUT("events/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateEvents(@Path("id") String id ,
                                    @Field("start_date_time") String start_date_time,
                                    @Field("end_date_time") String end_date_time,
                                    @Field("venue") String venue,
                                    @Field("decription") String decription,
                                    @Field("event_title") String event_title,
                                    @Field("event_type") String event_type,
                                    @Field("is_online") String is_online,
                                    @Field("is_recurring") String is_recurring,
                                    @Field("is_recurring_occurance") String is_recurring_occurance,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);


    //He Knows Request
    @GET("contact-knows/{id}")
    Call<ResponseBody>heKnows(@Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @GET("relations")
    Call<ResponseBody> relationShip(@Header("Authorization") String token,
                                    @Header("Accept") String name);

    @GET("contact-knows")
    Call<ResponseBody>heKnowsList(@Query("page") String page,
                                  @Query("contact_id") String contact_id,
                                  @Header("Authorization") String token,
                                  @Header("Accept") String name);

    @POST("contact-knows")
    @FormUrlEncoded
    Call<ResponseBody> addContactToHeKnows(
                                         @Field("follower_ids") String idList,
                                         @Field("contact_id") String contact_id,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    @POST("contact-knows")
    @FormUrlEncoded
    Call<ResponseBody> addRElationToHeKnows(
            @Field("follower_ids") String idList,
            @Field("contact_id") String contact_id,
            @Field("relation") String relations_id,
            @Header("Authorization") String token,
            @Header("Accept") String name);



    //All Organization Request
    @GET("organisations")
    Call<ResponseBody> organization(@Query("page") int page,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @GET("all-organisations")
    Call<ResponseBody> allOrganization(@Header("Authorization") String token,
                                       @Header("Accept") String name);

    @GET("all-colleges")
    Call<ResponseBody> allColleges(@Header("Authorization") String token,
                                       @Header("Accept") String name);

    @GET("institutes")
    Call<ResponseBody> allEducationColleges(@Query("page") int page,
                                            @Header("Authorization") String token,
                                            @Header("Accept") String name);

    @GET("organisations")
    Call<ResponseBody> searchOrganization(@Query("page") int page,
                                          @Query("srch_all") String search_string,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);

    @GET("organisations/{id}")
    Call<ResponseBody> organisationDetails(@Path("id") String id,
                                           @Query("name") String org_name,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @PUT("organisations/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addmembertoGroup(@Path("id") String id,
                                     @Field("organisation_group_id") String organisation_group_id,
                                     @Header("Authorization") String token,
                                     @Header("Accept") String name);


    @POST("organisations")
    @FormUrlEncoded
    Call<ResponseBody> createOrganization(
                                           @Field("name") String org_name,
                                           @Field("full_address") String address,
                                           @Field("client_id") String client_id,
                                           @Field("cafirm") String cafirm,
                                           @Field("cafirm_number") String cafirm_number,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);


    @PUT("organisations/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateOrganization(@Path("id") String id,
            @Field("name") String org_name,
            @Field("full_address") String address,
            @Field("client_id") String client_id,
            @Field("cafirm") String cafirm,
            @Field("cafirm_number") String cafirm_number,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @PUT("organisations/{id}")
    @FormUrlEncoded
    Call<ResponseBody> deleteOrganizationAddress(@Path("id") String id,
                                          @Field("full_address") String address,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);


    @GET("organisation-groups")
    Call<ResponseBody> organizationGroup(@Header("Authorization") String token,
                                    @Header("Accept") String name);

    @GET("organisation-groups/{id}")
    Call<ResponseBody> addorganizationList(@Path("id") String id,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);

    @GET("organisation-groups/{id}")
    Call<ResponseBody> getorganizationInGroup(
                                    @Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @POST("organisation-groups")
    @FormUrlEncoded
    Call<ResponseBody> addOrgaizationGroup(@Field("name") String org_name,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);

    @PUT("organisation-groups/{id}")
    @FormUrlEncoded
    Call<ResponseBody> editOrgaizationGroup(@Path("id") String id,
                                            @Field("name") String org_group_name,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);


    //ActivityList Request
    @GET("activities")
    Call<ResponseBody> activityList(@Query("id") String id,
                                 @Header("Authorization") String token,
                                 @Header("Accept") String name);

    @GET("activities/{id}")
    Call<ResponseBody> activityDetails(@Path("id") String id,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @POST("activities")
    @FormUrlEncoded
    Call<ResponseBody> createActivity(@Field("activity_time") String activity_time,
                                    @Field("activity_date") String activity_date,
                                    @Field("name") String activity_name,
                                    @Field("description") String description,
                                    @Field("follow_up_date") String follow_up_date,
                                    @Field("refference") String refference,
                                    @Field("venue") String venue,
                                      @Field("state") String state,
                                      @Field("city") String city,
                                      @Field("location") String location,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);

    @PUT("activities/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateActivity(@Path("id") String activity_id,
                                      @Field("activity_time") String activity_time,
                                      @Field("activity_date") String activity_date,
                                      @Field("name") String activity_name,
                                      @Field("description") String description,
                                      @Field("follow_up_date") String follow_up_date,
                                      @Field("refference") String refference,
                                      @Field("venue") String venue,
                                      @Field("state") String state,
                                      @Field("city") String city,
                                      @Field("location") String location,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String name);


    //Verify OTP Request
    /*@POST("verify_otp")
    Call<ResponseBody> verifyOTP(@Body VerifyOTPRequest params);*/

    @POST("forgot/password")
    @FormUrlEncoded
    Call<ResponseBody> sendOtp(@Field("email") String email);

    @POST("reset/password")
    @FormUrlEncoded
    Call<ResponseBody> resetPassword(
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation,
            @Field("token") String token,
            @Header("Accept") String accept);



    @POST("all-states-cities")
    //@FormUrlEncoded
    Call<ResponseBody> getState(@Header("Authorization") String token,
                                @Header("Accept") String name);

    @POST("state/{id}/city")
    Call<ResponseBody> getCity(@Path("id") String id,
                               @Header("Authorization") String token,
                                @Header("Accept") String name);

    //Coordinator List
    @GET("sub-users")
    Call<ResponseBody> getCoordinator(@Header("Authorization") String token,
                                    @Header("Accept") String name);

    @POST("sub-users")
    @FormUrlEncoded
    Call<ResponseBody> addSubUser(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("mobile") String mobile,
                                @Field("role_id") String role_id,
                                @Header("Authorization") String token,
                                @Header("Accept") String accept);

    @POST("change-password")
    @FormUrlEncoded
    Call<ResponseBody> updatePassword(@Field("old_password") String old_password,
                                      @Field("new_password") String password,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String accept);


    @PUT("sub-users/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateSubUser(
                                  @Path("id") String id,
                                  @Field("name") String name,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("mobile") String mobile,
                                  @Field("role_id") String role_id,
                                  @Header("Authorization") String token,
                                  @Header("Accept") String accept);


    @PUT("sub-users/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateSubUserStatus(@Path("id") String id,
                                           @Field("status") String status,
                                           @Field("name") String name,
                                           @Field("email") String email,
                                           @Field("mobile") String mobile,
                                           @Field("role_id") String role_id,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String accept);

    @DELETE("sub-users/{id}")
    Call<ResponseBody> deleteUser(
            @Path("id") String id,
            @Header("Authorization") String token,
            @Header("Accept") String accept);


    @PUT("groups/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addCoordinatorToGroup(
            @Path("id") String id,
            @Field("cordinators") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @PUT("events/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addCoordinatorToEvent(
            @Path("id") String id,
            @Field("event_cordinators") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @PUT("activities/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addCoordinatorToActivity(
            @Path("id") String id,
            @Field("activity_members") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @PUT("events/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addmemberToEvent(
            @Path("id") String id,
            @Field("event_guests") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @POST("add/organisation/to/contacts")
    @FormUrlEncoded
    Call<ResponseBody> addmemberToOrganisation(
            @Field("id") String id,
            @Field("contacts") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @PUT("activities/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addContactToActivity(
            @Path("id") String id,
            @Field("activity_particiants") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @POST("add/institute/to/contacts")
    @FormUrlEncoded
    Call<ResponseBody> addContactToEducation(
            @Field("id") String id,
            @Field("contacts") String idList,
            @Header("Authorization") String token,
            @Header("Accept") String name);



    //All Influencer List Request
    @POST("add/edit-influencer/{id}")
    @FormUrlEncoded
    Call<ResponseBody> createInfluencer(
                                    @Path("id") String contact_id,
                                    @Field("type") String type,
                                    @Field("icai") String icai,
                                    @Field("from") String from,
                                    @Field("to") String to,
                                    @Field("desc") String desc,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String name);


    @GET("contacts")
    Call<ResponseBody>getInfluencer(@Query("influencer") String influencers,
                               @Header("Authorization") String token,
                               @Header("Accept") String name);

    //Advance Search

    @GET("contacts")
    Call<ResponseBody>advanceSearch(@Query("page") int page,
                                    @Query("name") String name,
                                    @Query("institutes") String institutes,
                                    @Query("male") String male,
                                    @Query("female") String female,
                                    @Query("phone") String phone,
                                    @Query("email") String email,
                                    @Query("state") String state,
                                    @Query("meet") String meet,
                                    @Query("non_meet") String non_meet,
                                    @Query("city") String city,
                                    @Query("pin") String pin,
                                    @Query("group") String group,
                                    @Query("member_no") String member_no,
                                    @Query("organisation_name") String organisation_name,
                                    @Query("dnd") String dnd,
                                    @Query("influencers") String influencers,
                                    @Query("non_influencer") String non_influencers,
                                    @Query("client_group") String client_group,
                                    @Query("client_label") String client_label,
                                    @Query("name_start_with") String name_start_with,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String application_req);

    @GET("institutes")
    Call<ResponseBody>educationSearch(@Query("page") int page,
                                    @Query("name") String name,
                                    @Query("board") String board,
                                    @Query("state") String state,
                                    @Query("city") String city,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String application_req);


    @GET("contacts")
    Call<ResponseBody> contactsSearch(@Query("page") int page,
                                      @Query("srch_all") String name,
                                     @Header("Authorization") String token,
                                     @Header("Accept") String application_req);

    @GET("contacts")
    Call<ResponseBody> todayEventSearch(@Query("universe_call") String universe_call,
                                            @Query("universe_meet") String universe_meet,
                                        @Query("today_dob") String dob,
                                        @Query("sync") String sync,
                                        @Query("device_token") String device_token,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String application_req);

    @GET("contacts")
    Call<ResponseBody> todaysyncContactSearch(@Query("page") int page,
                                              @Query("universe_call") String universe_call,
                                              @Query("universe_meet") String universe_meet,
                                              @Query("today_dob") String dob,
                                              @Query("sync") String sync,
                                              @Query("device_token") String device_token,
                                              @Header("Authorization") String token,
                                              @Header("Accept") String application_req);

    @GET("contacts")
    Call<ResponseBody> dndSearch(@Query("universe_call") String universe_call,
                                        @Query("universe_meet") String universe_meet,
                                        @Query("today_dob") String dob,
                                        @Query("sync") String sync,
                                        @Query("device_token") String device_token,
                                        @Query("dnd") String dnd,
                                        @Header("Authorization") String token,
                                        @Header("Accept") String application_req);


    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactPhone(@Path("id") String id,
                                  @Field("phone_numbers") String group_name,
                                  @Header("Authorization") String token,
                                  @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactEmail(@Path("id") String id,
                                         @Field("emails") String group_name,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactEducation(@Path("id") String id,
                                         @Field("education_history") String group_name,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactOrganisation(@Path("id") String id,
                                             @Field("work_history") String group_name,
                                             @Header("Authorization") String token,
                                             @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactPersonalAddress(@Path("id") String id,
                                                @Field("full_address") String group_name,
                                                @Header("Authorization") String token,
                                                @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactNotes(@Path("id") String id,
                                         @Field("notes") String group_name,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactSocial(@Path("id") String id,
                                         @Field("social_link") String group_name,
                                         @Header("Authorization") String token,
                                         @Header("Accept") String name);
    @Multipart
    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactImage(@Path("id") String id,
                                          @Field("image") String imageName,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);

    @Multipart
    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactImageFile(@Path("id") String id,
                                             @Field("image") RequestBody image,
                                             @Header("Authorization") String token,
                                             @Header("Accept") String name);

    @Multipart
    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> updateProfile(@Part("id") RequestBody id,
                                           @Part("image") RequestBody fullName,
                                           @Part MultipartBody.Part image,
                                           @Header("Authorization") String token,
                                           @Header("Accept") String name);




    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactGeneralinfo(@Path("id") String id,
                                          @Field("name") String contact_name,
                                          @Field("dob") String dob,
                                          @Field("cap_status") String cap_status,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addToDnd(@Path("id") String id,
                                @Field("dnd") String dnd,
                                @Header("Authorization") String token,
                                @Header("Accept") String name);

/*    @Multipart
    @PUT("contacts/{id}")
    Call<ResponseBody> updateUserImage(
            @Part("Authorization") RequestBody ApiKey,
            @Part("id") RequestBody user_id,
            @Part("image") RequestBody image,
            @Part("Accept") RequestBody Accept,
            @Part MultipartBody.Part files
    );*/

    @Multipart
    @PUT("contacts/{id}")
    Call<ResponseBody> updateUserImage(
            @Part("id") RequestBody user_id,
            //@Part("image") RequestBody image,
            @HeaderMap Map<String, String> token,
            @Part("image") MultipartBody.Part files
    );

    @Multipart
    @POST ("contact-upload-image")
    Call<ResponseBody> updateImage (@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("contact-upload-image/{id}")
    Call<ResponseBody> uploadPhoto(@Path("id") String id,
                                   @Header("Authorization") String token,
                                   @Part MultipartBody.Part file);

    @POST("contact-upload-image/{id}")
    @FormUrlEncoded
    Call<ResponseBody> deletePhoto(@Path("id") String id,
                                   @Field("image") String image,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> addFavourte(@Path("id") String id,
                                   @Field("custom_universe") String universe,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @POST("make-universe")
    @FormUrlEncoded
    Call<ResponseBody> myUniverse(
            @Field("universe") String universe,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @POST("set/preference")
    @FormUrlEncoded
    Call<ResponseBody> myPreference(
            @Field("preference") String preference,
            @Header("Authorization") String token,
            @Header("Accept") String name);

    @POST("expected/votes/")
    @FormUrlEncoded
    Call<ResponseBody> setCityWiseData(
            @Field("expectedVotes") String expectedVotes,
            @Header("Authorization") String token,
            @Header("Accept") String name);




    @GET("goals/1")
    Call<ResponseBody> goalSettings(@Header("Authorization") String token,
                                    @Header("Accept") String application_req);

    @PUT("goals/1")
    @FormUrlEncoded
    Call<ResponseBody> addgoalSettingsPhaseOne(@Field("expected_counts") String expected_counts,
                                               @Field("voters_to_call") String voters_to_call,
                                               @Field("voters_to_meet") String voters_to_meet,
                                               @Field("postal_voters") String postal_voters,
                                               @Header("Authorization") String token,
                                               @Header("Accept") String name);

    @PUT("goals/1")
    @FormUrlEncoded
    Call<ResponseBody> addgoalSettingsPhaseTwo(@Field("yet_to_define") String yet_to_define,
                                               @Field("first_preferrence") String first_preferrence,
                                               @Field("second_preferrence") String second_preferrence,
                                               @Field("third_preferrence") String third_preferrence,
                                               @Field("other_preferrence") String other_preferrence,
                                               @Header("Authorization") String token,
                                               @Header("Accept") String name);


    @POST("sync-contacts")
    @FormUrlEncoded
    Call<ResponseBody> syncContact(@Field("contacts") String idList,
                                   @Field("device_token") String device_token,
                                   @Header("Authorization") String token,
                                   @Header("Accept") String name);

    @GET("sync-contacts")
    Call<ResponseBody> synccontactsList(@Query("device_token") String device_token,
                                        @Header("Authorization") String token,
                                        @Header("Accept") String application_req);

    @POST("send-email")
    @FormUrlEncoded
    Call<ResponseBody> sendEmailLabel(@Field("type") String email,
                                 @Field("label_id") String label_id,
                                 @Field("message") String message,
                                 @Field("subject") String subject,
                                 @Header("Authorization") String token,
                                 @Header("Accept") String application_req);

    @POST("send-email")
    @FormUrlEncoded
    Call<ResponseBody> sendEmailGroup(@Field("type") String email,
                                      @Field("group_id") String label_id,
                                      @Field("message") String message,
                                      @Field("subject") String subject,
                                      @Header("Authorization") String token,
                                      @Header("Accept") String application_req);

    @POST("send-sms")
    @FormUrlEncoded
    Call<ResponseBody> sendSmsLabel(@Field("type") String email,
                                    @Field("label_id") String label_id,
                                    @Field("message") String message,
                               @Header("Authorization") String token,
                               @Header("Accept") String application_req);

    @POST("send-sms")
    @FormUrlEncoded
    Call<ResponseBody> sendSmsGroup(@Field("type") String email,
                                    @Field("group_id") String group_id,
                                    @Field("message") String message,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String application_req);


    @POST("add/contactto/groups")
    @FormUrlEncoded
    Call<ResponseBody> addContactToMultipleGroups(@Field("groups") String groups,
                                    @Field("contacts") String contacts,
                                    @Header("Authorization") String token,
                                    @Header("Accept") String application_req);

    @POST("add/contactto/labels")
    @FormUrlEncoded
    Call<ResponseBody> addContactToMultipleLabels(@Field("labels") String groups,
                                                  @Field("contacts") String contacts,
                                                  @Header("Authorization") String token,
                                                  @Header("Accept") String application_req);


    @PUT("contacts/{id}")
    @FormUrlEncoded
    Call<ResponseBody> udateContactStatus(@Path("id") String id,
                                          @Field("status") String status,
                                          @Header("Authorization") String token,
                                          @Header("Accept") String name);


   /* @GET("app-version")
    Call<ResponseBody> getVersionCode(@Query("ver")String version,
                                      @Header("Authorization") String token,
                                    @Header("Accept") String application_req);*/
   @GET("version-check")
   Call<ResponseBody> getVersionCode(@Query("ver")String version,
                                     @Header("Authorization") String token,
                                     @Header("Accept") String application_req);


    @DELETE("contact-knows/{id}")
    Call<ResponseBody> deleteHeKnows(
            @Path("id") String id,
            @Header("Authorization") String token,
            @Header("Accept") String accept);





}
