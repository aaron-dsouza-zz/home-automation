/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.spherobb8.comm;

import java.io.InputStream;

import com.tridium.ndriver.comm.LinkMessage;

/**
 * SpheroBB8TcpLinkMessage streams data to and from a byte array representation.
 *
 * @author   Aaron D'souza
 * @creation 24-May-16 
 */
public class SpheroBB8TcpLinkMessage
  extends LinkMessage
{
  public SpheroBB8TcpLinkMessage(int maxLen)  { super(maxLen); }
  
  /** 
   * Get byte data from inputStream.
   *  return true if complete message received 
   */
  public boolean receive(InputStream in)
    throws Exception
  {
    //
    // TODO add code to detect beginning and end of message in serial stream.
    //
    // read characters from stream 
    // after start byte detected write following bytes to buffer[] until
    //  end of message
    return false;
  }
  
////////////////////////////////////////////////////////////////
//Handle outgoing messages
////////////////////////////////////////////////////////////////

// TODO customize handling of outgoing messages if needed
//  /** Translate data from app message to link message representation */
//  public boolean setMessage(NMessage msg)
//    throws Exception
//  {
//
//  }

}