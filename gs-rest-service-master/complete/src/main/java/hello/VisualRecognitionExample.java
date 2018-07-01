package hello;


import java.io.File;

//import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
//import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
//import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
//import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
//import com.ibm.watson.developer_cloud.visual_recognition.v3.model.UpdateClassifierOptions;

public class VisualRecognitionExample {

//  public static void main(String[] args) {
//    VisualRecognition service = new VisualRecognition("2016-05-20");
//    service.setApiKey("<api-key>");
//
//    System.out.println("Classify an image");
//    ClassifyOptions options = new ClassifyOptions.Builder()
//        .imagesFile(new File("src/test/resources/visual_recognition/car.png"))
//        .imagesFilename("car.png")
//        .build();
//    ClassifiedImages result = service.classify(options).execute();
//    System.out.println(result);
//
//
//    System.out.println("Create a classifier with positive and negative images");
//    CreateClassifierOptions createOptions = new CreateClassifierOptions.Builder()
//        .name("foo")
//        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
//        .addClass("baseball", new File("src/test/resources/visual_recognition/baseball_positive.zip"))
//        .negativeExamples(new File("src/test/resources/visual_recognition/negative.zip"))
//        .build();
//    Classifier foo = service.createClassifier(createOptions).execute();
//    System.out.println(foo);
//
//    System.out.println("Classify using the 'Car' classifier");
//    options = new ClassifyOptions.Builder()
//        .imagesFile(new File("src/test/resources/visual_recognition/car.png"))
//        .imagesFilename("car.png")
//        .addClassifierId(foo.getClassifierId())
//        .build();
//    result = service.classify(options).execute();
//    System.out.println(result);
//
//    System.out.println("Update a classifier with more positive images");
//    UpdateClassifierOptions updateOptions = new UpdateClassifierOptions.Builder()
//        .classifierId(foo.getClassifierId())
//        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
//        .build();
//    Classifier updatedFoo = service.updateClassifier(updateOptions).execute();
//    System.out.println(updatedFoo);
//  }
}