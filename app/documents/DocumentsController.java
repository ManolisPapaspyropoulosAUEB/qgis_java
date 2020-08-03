package documents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.ConfigFactory;

import models.DocumentsEntity;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import sun.misc.BASE64Decoder;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;
public class DocumentsController {
    /**
     * created by mpapaspyropoulos
     */
    final static String uploadPath = "D:/development/New folder (8)/digital-assets/uploadedFiles/";
    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public Result uploadFile() {
        ObjectNode result = Json.newObject();
        try {
            Http.MultipartFormData<File> body = request().body().asMultipartFormData();
            String roadId = body.asFormUrlEncoded().get("roadId")[0].trim();
            String districtId = body.asFormUrlEncoded().get("districtId")[0].trim();
            List<Http.MultipartFormData.FilePart<File>> fileList;
            fileList = body.getFiles();
            String extension = "";
            Random rand = new Random();
            for (Http.MultipartFormData.FilePart d : fileList) {
                String[] fileNameArr = d.getFilename().split("\\.");
                String fileName;
                String originalFileName;
                extension = fileNameArr[fileNameArr.length - 1];
                originalFileName = fileNameArr[fileNameArr.length - 2];
                fileName = fileNameArr[fileNameArr.length - 2] + "_" + rand.nextInt(1000);
                File filed = (File) d.getFile();
                String fullPath = districtId + "/" + roadId + "/" + fileName + "." + extension;
                File uploadsDir = new File(ConfigFactory.load().getString("uploads_dir") + districtId + "/" + roadId);
                if (!uploadsDir.exists()){
                    uploadsDir.mkdirs();
                }
                File dest = new File(uploadsDir.getPath() + "/" + fileName + "." + extension);
                copyFileUsingFileStreams(filed, dest);
                DocumentsEntity newDoc = new DocumentsEntity();
                newDoc.setName(fileName);
                newDoc.setOriginalFilename(originalFileName);
                newDoc.setExtension(extension);
                newDoc.setUploadDate(new Date());
                newDoc.setName(fileName + "." + extension);
                newDoc.setRoadId(Integer.valueOf(roadId));
                newDoc.setFullPath(fullPath);
                JPA.em().persist(newDoc);
                result.put("docId", newDoc.getId());
                result.put("status", "ok");
                result.put("message", "your photo has been uploaded ");
                return ok(result);
            }
            result.put("status", "error");
            result.put("message", "No image selected");
            return ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά το ανέβασμα αρχείου διαγραφή .");
            return ok(result);
        }
    }

    //
//
    @play.db.jpa.Transactional

    public static void copyFileUsingFileStreams(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[2048];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    public Result downloadDocument() {
        ObjectNode result = Json.newObject();
        String id = request().getQueryString("id");
        String sql = "select * from documents d where d.id=  " + id;
        Query qsql = JPA.em().createNativeQuery(sql, DocumentsEntity.class);
        List<DocumentsEntity> docsList = qsql.getResultList();
        try {
            File previewFile = new File(ConfigFactory.load().getString("uploads_dir") + docsList.get(0).getFullPath());
            return ok(previewFile);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", e.getMessage());
        }
        return ok(result);
    }

    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteImage() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            Integer imgId = json.findPath("id").asInt();  //doc id apo ton pinaka docsTaassks
            if (imgId == 0 || imgId == null) {
                return badRequest("Expecting docId ");
            } else {
                try {
                    DocumentsEntity doc = JPA.em().find(DocumentsEntity.class,imgId);
                    File dest = new File(ConfigFactory.load().getString("uploads_dir").concat(doc.getFullPath()));
                    dest.delete();
                    JPA.em().remove(doc);
                    result.put("status", "ok");
                    result.put("message", "your image was succesfully deleted");
                    return ok(result);
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("status", "error");
                    result.put("message", e.getMessage());
                }
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά την εισαγωγή .");
            return ok(result);
        }
    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getPhotoByRoadId() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = Controller.request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {

                if (json == null) {
                    result.put("status", "error");
                    result.put("message", "Ανεπιτυχής.");
                    return ok(result);
                } else {
                    String sql = "select * from documents d where d.road_id=" + json.findPath("id").asText() +" order by d.upload_date desc";
                    Query qsql = JPA.em().createNativeQuery(sql, DocumentsEntity.class);
                    List<DocumentsEntity> docsList = qsql.getResultList();
                    ObjectMapper ow = new ObjectMapper();
                    HashMap<String, Object> returnList = new HashMap<String, Object>();
                    String jsonResult = "";
                    List<HashMap<String, Object>> serversList = new ArrayList<HashMap<String, Object>>();
                    for (DocumentsEntity j : docsList) {
                        HashMap<String, Object> sHmpam = new HashMap<String, Object>();
                        sHmpam.put("id", j.getId());
                        sHmpam.put("srcUrl", j.getFullPath());
                        sHmpam.put("previewUrl", j.getFullPath());
                        sHmpam.put("previewFile", new File(j.getFullPath()));
                        sHmpam.put("extension", j.getExtension());
                        sHmpam.put("getUrl", new File(j.getFullPath()));
                        sHmpam.put("originalName", j.getOriginalFilename().concat(".").concat(j.getExtension()));
                        sHmpam.put("uploadDate", j.getUploadDate());
                        serversList.add(sHmpam);
                    }
                    returnList.put("data", serversList);
                    returnList.put("status", "ok");
                    returnList.put("message", "success");
                    DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    ow.setDateFormat(myDateFormat);
                    try {
                        jsonResult = ow.writeValueAsString(returnList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        result.put("status", "error");
                        result.put("message", "Πρόβλημα κατά την ανάγνωση των στοιχείων ");
                        return ok(result);
                    }
                    return ok(jsonResult);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά την ανάγνωση των στοιχείων");
            return ok(result);
        }
    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result uploadPhotoTest() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String base64String = json.findPath("base64String").asText().trim();
                String name = json.findPath("name").asText();
                String district = json.findPath("district").asText().trim();
                Integer roadId = json.findPath("roadId").asInt();
                String[] strings = base64String.split(",");
                String extension;
                System.out.println((strings[0]));
                switch (strings[0]) {//check image's extension
                    case "data:image/jpeg;base64":
                        extension = "jpeg";
                        break;
                    case "data:image/png;base64":
                        extension = "png";
                        break;
                    default://should write cases for more images types
                        extension = "jpg";
                        break;
                }
                byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
                System.out.println(data);
                String path = "C:\\developm\\qgis_angular\\bckp\\assets\\photoGallery\\" + district + "\\" + name;
                String pathDaved = "../assets/photoGallery/" + district + "/" + name;
                File file = new File(path);
                try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                    outputStream.write(data);
                    DocumentsEntity d = new DocumentsEntity();
                    d.setExtension(extension);
                    d.setUploadDate(new Date());
                    d.setName(name);
                    System.out.println(pathDaved);
                    d.setFullPath(pathDaved);
                    d.setRoadId(roadId);
                    JPA.em().persist(d);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                result.put("status", "ok");
                result.put("message", "your photo has been uploaded");
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
    public Result downloadFile() {
        ObjectNode result = Json.newObject();
        String docId = request().getQueryString("docId");
        String sql = "select * from documents d where d.id=  " + docId;
        Query qsql = JPA.em().createNativeQuery(sql, DocumentsEntity.class);
        List<DocumentsEntity> docsList = qsql.getResultList();
        try {
            File previewFile = new File(ConfigFactory.load().getString("uploads_dir") + docsList.get(0).getFullPath());
            return ok(previewFile);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", e.getMessage());
        }
        return ok(result);
    }


}
