/**
 * Copyright 2013 - All Rights Reserved.
 */
package  com.tridium.spherobb8.message;

import java.io.*;

import com.tridium.ndriver.comm.*;
//import com.tridium.ndriver.io.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.io.TypedInputStream;

/**
 *  SpheroBB8Message is super class for all spherobb8 messages
 *
 *  @author   Aaron D'souza
 *  @creation 24-May-16 
 */
public class SpheroBB8Message
  extends NMessage
{


  
  // Override for outgoing messages
//  public boolean toOutputStream(OutputStream out) 
//    throws Exception
//  {
//    // Use typed stream for more readable code.   
//    TypedOutputStream to = new TypedOutputStream();
//  
//    to.toOutputStream(out);
//    return false;
//  }
    
  //   Override for incoming messages
//  public void fromInputStream(InputStream in) 
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    // Note: messageFactory must have created TypedInputStream
//    TypedInputStream ti = (TypedInputStream)in;
//  }
    
  //   Typical overrides  
//  public Object getTag() { return nullTag; }
//  public boolean isResponse() { return false; }
//  public boolean isFragmentable() { return false; }
//  public int getResponseTimeOut() { return 2500; }
    
//  public String toTraceString()
//  {
//    return "??";
//  }

}
