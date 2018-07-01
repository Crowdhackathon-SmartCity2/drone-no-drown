package hello;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class visualrec {


	public static void main(String[] args) {


		VisualRecognition service = new VisualRecognition("2018-03-19");
		service.setEndPoint("https://gateway.watsonplatform.net/visual-recognition/api");

		IamOptions options = new IamOptions.Builder().apiKey("54oqYUVOPL0QJWcCXzt1a8R_nTmHX3vlrUFCMwBhyo7D")
		service.setIamCredentials(options);

		InputStream imagesStream = new FileInputStream("./fruitbowl.jpg");
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
			.imagesFile(imagesStream)
			.imagesFilename("fruitbowl.jpg")
			.threshold((float) 0.6)
			.classifierIds(Arrays.asList("testBeachGarbage_507907870"))
			.build();
		ClassifiedImages result = service.classify(classifyOptions).execute();
		System.out.println(result);



	}


}
