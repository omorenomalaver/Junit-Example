public class TestRunner {
    public static void main(String[] args) {
      expectingValues();
   }
    /**
     * this function call CheckExpectValues to verifier measure converter 
     */
    private static void expectingValues()
    {
      Result result = JUnitCore.runClasses(CheckExpectValues.class);
      
      for (Failure failure : result.getFailures()) {   
         System.out.println(failure.toString());
      }
      System.out.println("Test result was :" + result.wasSuccessful());
    }
}
