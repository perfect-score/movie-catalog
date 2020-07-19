package com.movie.app.model;

import lombok.Data;

/**
 * Enum containing the REST response outcome success/failure values.
 */
enum ResponsetOutcome {
   SUCCESS("Success"), FAILURE("Failure");

   private String status;

   public String getOutcome() {
      return this.status;
   }

   private ResponsetOutcome(String status) {
      this.status = status;
   }
}


/**
 * Provide support for setting the generic REST response.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Data
public class RestResponse {

   private String status;
   private Object data;

   public RestResponse(boolean success, Object obj) {
      status = success ? ResponsetOutcome.SUCCESS.getOutcome() : ResponsetOutcome.FAILURE.getOutcome();
      data = obj;
   }

}
