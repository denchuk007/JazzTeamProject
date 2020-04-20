package requests;

import java.net.URL;

public class Constants {

    public static final String FILES_URL = "https://www.googleapis.com/drive/v3/files";
    public static final String API_KEY = "?key=AIzaSyCkXwO5ehWPp4LL_Pmym05M--aFbKdkMS4";
    public static final String ACCESS_TOKEN_DATA = "client_secret=Uq-N8UbQbVWUmNTLFuaLrxyL&grant_type=refresh_token&" +
            "refresh_token=1%2F%2F04vvRLIU_EjavCgYIARAAGAQSNwF-L9Ira_hlUmSf2BDGp_acaoAmaGG_fyFlP4rfvNScitKnwem-Bu6b5" +
            "HztVyB4VB2yrpTbFJ8&client_id=78185137426-0bfvhfeg8rj8bssd9nasabdki375593n.apps.googleusercontent.com";
    public static final String ACCESS_TOKEN_URL = "https://oauth2.googleapis.com/token";
    public static final String FILES_API_KEY_URL = FILES_URL + API_KEY;
}