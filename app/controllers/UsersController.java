package controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

import models.DistrictsEntity;
import models.UsersDistrictsEntity;
import models.UsersEntity;
import models.VillagesEntity;
import org.apache.commons.mail.DefaultAuthenticator;
import play.Configuration;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.mail.internet.InternetAddress;
import javax.persistence.Query;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.mvc.Controller.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class UsersController {
    private static final String ALGO = "AES";
    @Inject
    protected Configuration configuration;
    private static final byte[] keyValue =
            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
                    'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};


    @SuppressWarnings("Duplicates")
    //
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result login() {//login apo ton pinaka me tous users
        try {
            ObjectMapper ow = new ObjectMapper();
            ObjectNode result = Json.newObject();
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String email = json.findPath("email").asText();
                String pwd = json.findPath("pwd").asText();
                if (email == null || pwd == null || pwd.equalsIgnoreCase("")) {
                    result.put("status", "invalidCredentials");
                    result.put("message", "Παρακαλώ καταχωρήστε ορθά στοιχεία.");
                    return ok(result);
                }
                String checkCredentials = "SELECT u FROM UsersEntity u where u.email = '" + email + "'";
                Query qUsers = JPA.em().createQuery(checkCredentials);
                List<UsersEntity> usList = qUsers.getResultList();
                boolean emailExist = false;
                boolean pwdExist = false;
                if (usList.size() > 0) {
                    UsersEntity findUserByEmail = usList.get(0);
                    emailExist = true;
                    if(findUserByEmail.getPassword().equalsIgnoreCase(pwd)){
                        pwdExist=true;
                    }
                }
                if(emailExist==true && pwdExist==true){
                    result.put("status", "ok");
                    result.put("id",  usList.get(0).getId());
                    result.put("email",  usList.get(0).getEmail());
                    result.put("password",  usList.get(0).getPassword());
                    result.put("role", usList.get(0).getRole());
                    result.put("fullName", usList.get(0).getName()+" "+usList.get(0).getLastName());
                    result.put("message", "Success login!");
                    return ok(result);
                }else if (emailExist==true && pwdExist==false ){
                    result.put("status", "error");
                    result.put("message", "Incorrect password");
                    return ok(result);
                }else {
                    result.put("status", "error");
                    result.put("message", "The system cannot find user with this email and password");
                    return ok(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά ττην επαλήθευση των στοιχείων.");
            return ok(result);
        }
    }

    //editUser



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getUsers() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = Http.Context.Implicit.request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String userId = json.findPath("userId").asText();
                String name = json.findPath("name").asText();
                String sqlQuery = "select * from users where 1=1";
                if(userId!=null && !userId.equalsIgnoreCase("")){
                    sqlQuery+=" and users.id="+userId;
                }
                if(name!=null && !name.equalsIgnoreCase("")){
                    sqlQuery+=" and users.name like  '%"+  name+"%'" +" or users.last_name  like '%"+name+"%'"+" or users.email like '%"+name+"%' or users.role like '%"+name+"%'";
                }
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                Query q = JPA.em().createNativeQuery(sqlQuery, UsersEntity.class);
                List<UsersEntity> usersEntityList = q.getResultList();

                ObjectMapper ow = new ObjectMapper();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (UsersEntity d: usersEntityList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("name", d.getName());
                    roadObject.put("lastname", d.getLastName());
                    roadObject.put("fullName", d.getName()+" "+d.getLastName());
                    roadObject.put("username", d.getUsername());
                    roadObject.put("creationDate", d.getCreationDate());
                    roadObject.put("role", d.getRole());
                    roadObject.put("password", d.getPassword());
                    roadObject.put("email", d.getEmail());
                    String userDistricts= "select * from users_districts ud where ud.user_id="+ d.getId();
                    List<UsersDistrictsEntity> udList =  JPA.em().createNativeQuery(userDistricts,UsersDistrictsEntity.class).getResultList();
                    String [] userDistrictsArray = new  String[udList.size()];
                    for(int i =0;i<udList.size();i++){
                        userDistrictsArray[i]=udList.get(i).getDistrictName();
                    }
                    roadObject.put("selectedDistricts", userDistrictsArray);
                    roadObject.put("creationDate", d.getCreationDate());
                    finalRoadsList.add(roadObject);
                }

                returnList.put("data", finalRoadsList);
                returnList.put("total", total.intValue());
                returnList.put("status", "ok");
                DateFormat myDateFormat = new SimpleDateFormat("M/d/Y");
                ow.setDateFormat(myDateFormat);
                try {
                    jsonResult = ow.writeValueAsString(returnList);
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("status", "error");
                    result.put("message", "Problem in fetch data process,communicate with the administrator");
                    return ok(result);
                }
                return ok(jsonResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Problem in fetch data process,communicate with the administrator");
            return ok(result);
        }
    }



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result register() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String email = json.findPath("email").asText();
                String password = json.findPath("password").asText();
                UsersEntity user = new UsersEntity();
                user.setEmail(email);
                user.setPassword(password);
                String emailUnique = "select * from users u where u.email='" + user.getEmail() + "'";
                Query qemail = JPA.em().createNativeQuery(emailUnique, UsersEntity.class);
                List<UsersEntity> usersListEmail = qemail.getResultList();
                if (usersListEmail.size() > 0) {
                    result.put("status", "error");
                    result.put("message", "The email you provided already exists.");
                    return ok(result);
                } else {
                    user.setEmail(email);
                }
                user.setCreationDate(new Date());
                JPA.em().persist(user);
                result.put("status", "ok");
                result.put("message", "Registration was successful");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while creation new user");
            return ok(result);
        }
    }

    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result editUser() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String email = json.findPath("email").asText();
                Integer userId = json.findPath("userId").asInt();
                String emailUnique = "select * from users u where u.email='" + email + "'" + "and  u.id != "+userId;
                Query qemail = JPA.em().createNativeQuery(emailUnique, UsersEntity.class);
                List<UsersEntity> usersListEmail = qemail.getResultList();
                if (usersListEmail.size() > 0) {
                    result.put("status", "error");
                    result.put("message", "The email you provided already exists.");
                    return ok(result);
                }
                String password = json.findPath("password").asText();
                String name = json.findPath("name").asText();
                String lastname = json.findPath("lastname").asText();
                String username = json.findPath("username").asText();
                String role = json.findPath("role").asText();
                UsersEntity user = JPA.em().find(UsersEntity.class,userId);
                if(password!=null && !password.equalsIgnoreCase("")){
                    user.setPassword(password);
                }
                if(name!=null && !name.equalsIgnoreCase("")){
                    user.setName(name);
                }
                if(lastname!=null && !lastname.equalsIgnoreCase("")){
                    user.setLastName(lastname);
                }
                if(username!=null && !username.equalsIgnoreCase("")){
                    user.setUsername(username);
                }
                if(role!=null && !role.equalsIgnoreCase("")){
                    user.setRole(role);
                }
                user.setUpdateDate(new Date());
                JPA.em().merge(user);
                JsonNode selectedDistricts = json.findPath("selectedDistricts");
                if(selectedDistricts.size()>0){
                    String userDistricts= "select * from users_districts ud where ud.user_id="+ userId;
                    List<UsersDistrictsEntity> udList =  JPA.em().createNativeQuery(userDistricts,UsersDistrictsEntity.class).getResultList();
                    for(UsersDistrictsEntity ud : udList ){
                        JPA.em().remove(ud);
                    }
                    for(int i = 0;i<selectedDistricts.size();i++){
                        UsersDistrictsEntity userDistrictEntry = new UsersDistrictsEntity();
                        userDistrictEntry.setDistrictName(selectedDistricts.get(i).asText());
                        userDistrictEntry.setUserId(user.getId());
                        userDistrictEntry.setCreationDate(new Date());
                        JPA.em().persist(userDistrictEntry);
                    }
                }
                result.put("status", "ok");
                result.put("message", "Update was successful");
                result.put("fullName", user.getName()+" "+user.getLastName());
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while creation new user");
            return ok(result);
        }
    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteUser() {
        try {
            JsonNode json = Http.Context.Implicit.request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                UsersEntity user = JPA.em().find(UsersEntity.class,json.findPath("id").asInt());
                JPA.em().remove(user);

                String userDistricts= "select * from users_districts ud where ud.user_id="+json.findPath("id").asInt();
                List<UsersDistrictsEntity> udList =  JPA.em().createNativeQuery(userDistricts,UsersDistrictsEntity.class).getResultList();
                for(UsersDistrictsEntity ud : udList ){
                    JPA.em().remove(ud);
                }
                result.put("status", "ok");
                result.put("message", "User has been deleted succesfully!");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while commiting,please contact with administrator and report the problem");
            return ok(result);
        }
    }




    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result addUser() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String email = json.findPath("email").asText();
                String password = json.findPath("password").asText();
                String name = json.findPath("name").asText();
                String lastname = json.findPath("lastname").asText();
                String username = json.findPath("username").asText();
                String role = json.findPath("role").asText();
                UsersEntity user = new UsersEntity();
                user.setName(name);
                user.setLastName(lastname);
                user.setUsername(username);
                user.setRole(role);
                user.setEmail(email);
                user.setPassword(password);
                String emailUnique = "select * from users u where u.email='" + user.getEmail() + "'";
                Query qemail = JPA.em().createNativeQuery(emailUnique, UsersEntity.class);
                List<UsersEntity> usersListEmail = qemail.getResultList();
                if (usersListEmail.size() > 0) {
                    result.put("status", "error");
                    result.put("message", "The email you provided already exists.");
                    return ok(result);
                } else {
                    user.setEmail(email);
                }
                user.setCreationDate(new Date());
                 JPA.em().persist(user);
                JsonNode selectedDistricts = json.findPath("selectedDistricts");
                for(int i = 0;i<selectedDistricts.size();i++){
                    UsersDistrictsEntity userDistrictEntry = new UsersDistrictsEntity();
                    userDistrictEntry.setDistrictName(selectedDistricts.get(i).asText());
                    userDistrictEntry.setUserId(user.getId());
                    userDistrictEntry.setCreationDate(new Date());
                    JPA.em().persist(userDistrictEntry);
                }
                result.put("status", "ok");
                result.put("message", "Registration was successful");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while creation new user");
            return ok(result);
        }
    }





    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result forgotPwd() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String email = json.findPath("email").asText();
                UsersEntity user = new UsersEntity();
                String emailUnique = "select * from users u where u.email='" + email + "'";
                Query qemail = JPA.em().createNativeQuery(emailUnique, UsersEntity.class);
                List<UsersEntity> usersListEmail = qemail.getResultList();
                if (usersListEmail.size() > 0) {
                    String subject = "Forgot Password";
                    String message = "Your password is:" + usersListEmail.get(0).getPassword();
                    sendMail(email, subject, message);
                    result.put("status", "error");
                    result.put("message", "We send you an email with your forgotten password");
                    return ok(result);
                } else {
                    result.put("status", "error");
                    result.put("message", "No User found with this email");
                    return ok(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error ");
            return ok(result);
        }
    }


    public Result sendMail(String recipient, String subject, String message) {
        ObjectNode result = Json.newObject();
        String hostName = "mail.synergic.gr";
        String hostUsername = "ibebis@synergic.gr";
        String hostPassword = "D](j#N~Xwi5}";
        Integer smtpPort = 25;
        Boolean sslOn = false;
        Boolean emailAuthentication = true;
        try {
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", hostName);
            props.put("mail.smtp.port", smtpPort);
            try {
                Email email = new SimpleEmail();
                email.setBounceAddress(hostUsername);
                email.setHostName(hostName);
                if (emailAuthentication) {
                    email.setAuthenticator(new DefaultAuthenticator(hostUsername, hostPassword));
                }
                email.setSmtpPort(smtpPort);
                email.setFrom(String.valueOf(new InternetAddress(hostUsername, "Qgis webapplication")));
                email.addTo(recipient);
                email.setSSLOnConnect(sslOn);
                email.setSubject(subject);
                email.setMsg(message);
                email.send();
                result.put("status", "ok");
                result.put("message", "Email sent");
            } catch (Exception e) {
                result.put("status", "error");
                result.put("message", e.getMessage());
                e.printStackTrace();
            }
        } catch (Throwable t) {
            result.put("status", "error");
            result.put("message", t.getMessage());
            t.printStackTrace();
        }
        return ok(result);
    }


    @SuppressWarnings("Duplicates")
    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    @SuppressWarnings("Duplicates")
    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }


    @SuppressWarnings("Duplicates")
    //encryption password user
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}
