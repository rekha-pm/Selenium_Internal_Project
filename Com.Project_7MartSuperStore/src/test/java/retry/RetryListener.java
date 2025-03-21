package retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class RetryListener implements IAnnotationTransformer{
	
  @Override  
  public void transform(ITestAnnotation annotation,Class testclass,Constructor testConstructor,Method testMethod) {
	  
	  annotation.setRetryAnalyzer(RetryAnalyzer.class);
	  
	  //ITestAnnotation --- to represent @Test annotations
	  //Class --- to represent Test Classes
	  //Constructor  -- to represent Test Constructor (optional, null)
	  //Method -- to get the details of Test Methods
	  //IAnnotationTransformer -  TestNG Listener which is used to apply automatic retry mechanism globally
	}
	
  
}
