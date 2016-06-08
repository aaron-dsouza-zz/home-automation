/**
 * Copyright 2013 - All Rights Reserved.
 */
package  com.tridium.lifx.message;

import java.io.*;

import com.tridium.ndriver.comm.*;
//import com.tridium.ndriver.io.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridium.ndriver.io.TypedOutputStream;

/**
 *  LifxMessage is super class for all lifx messages
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
public class LifxMessage
  extends NMessage
{


  private static final int RASPBERRY_PI_ZERO = 0xAAAAAAAA;

  public LifxMessage (BAddress address)
  {
    super(address);
  }

  
  // Override for outgoing messages
  public boolean toOutputStream(OutputStream out)
    throws Exception
  {
    // Write the header
    TypedOutputStream to = new TypedOutputStream();

    to.toOutputStream(out);
    return false;
  }
    
  //   Override for incoming messages
  public void fromInputStream(InputStream in)
    throws Exception
  {
    // Use typed stream for more readable code.
    // Note: messageFactory must have created TypedInputStream
    TypedInputStream ti = (TypedInputStream)in;
  }
    
  //   Typical overrides  
  public Object getTag() { return nullTag; }
  public boolean isResponse() { return false; }
  public boolean isFragmentable() { return false; }
  public int getResponseTimeOut() { return 2500; }
    
  public String toTraceString()
  {
    return "??";
  }

  /*Header*/
  // Frame
  public int size = 0; // 16 bits. Size of entire message in bytes including this field
  public int origin = 0; // 2 bits. Message origin indicator: Must be 0
  public int tagged = 0; // 1 bit. Determines usage of Frame Address target field
  public int addressable = 1; // 1 bit. Message includes a target address: must be one (1)
  public int decimal = 1024; // 12 bits. Protocol number: must be 1024 (decimal)
  public int source = RASPBERRY_PI_ZERO; // 32 bits. Source identifier: unique value set by the client, used by responses

  // Frame Address
  public long target = 0L; // 64 bits. 6 byte device address (MAC address) or zero (0) means all devices
  public long reserved1 = 0L; // 48 bits. Array of bytes; length 6. Must all be zero (0)
  public int reserved2 = 0; // 6 bits. Reserved
  public int ackRequired = 0; // 1 bit. Acknowledgement message required
  public int responseRequired = 0; // 1 bit. Response message required
  public int sequence = 0; // 8 bits. Wrap around message sequence number

  // Protocol Header
  public long reserved3 = 0; // 64 bits. Reserved
  public int type = 0; // 16 bits. Message type determines the payload being used
  public int reserved4 = 0; // 16 bits. Reserved
}
