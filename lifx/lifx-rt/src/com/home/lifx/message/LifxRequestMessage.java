/**
 * Copyright 2013 - All Rights Reserved.
 */
package com.home.lifx.message;

import java.io.*;
import java.net.ProtocolException;

import com.tridium.ndriver.comm.*;
//import com.tridium.ndriver.io.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridium.ndriver.io.TypedOutputStream;

/**
 *  LifxRequestMessage is super class for all lifx messages
 *
 *  @author   Aaron D'souza
 *  @creation 05-Jun-16 
 */
public abstract class LifxRequestMessage
  extends LifxMessage
{
  public LifxRequestMessage(BAddress address)
  {
    super(address);
  }

  // Override for outgoing messages
  public boolean toOutputStream(OutputStream out)
    throws Exception
  {
    // Write the header
    TypedOutputStream to = new TypedOutputStream();

    // Frame
    to.writeUnsigned16(swap((short)size));
    int twoBytes = (origin << 14 | (tagged?1:0) << 13 | addressable << 12 | protocol);
    to.writeUnsigned16(swap((short)twoBytes));
    to.writeUnsigned32(source);

    // Frame address
    to.writeSigned64(target);
    to.writeUnsigned32(reserved1);
    to.writeUnsigned16((int) reserved1);
    int mrk = to.setBitFieldMark();
    to.writeBit(reserved2, 0, 2, 6);
    to.writeBooleanBit(ackRequired, 0, 1, 1);
    to.writeBooleanBit(responseRequired, 0, 0, 1);
    to.writeUnsigned8(sequence);
    to.resetBitFieldMark(mrk);

    // Protocol Header
    to.writeSigned64(reserved3);
    to.writeUnsigned16(swap((short)messageType));
    to.writeUnsigned16(reserved4);

    writePayload(to);
    to.toOutputStream(out);
    return false;
  }

//  public abstract int getSize();
//  public abstract int getTagged();
//  public abstract long getTargetDeviceAddress();
//  public abstract int getMessageType();
  public abstract void writePayload(TypedOutputStream out);

  //   Typical overrides
  public Object getTag() { return nullTag; }
  public boolean isResponse() { return false; }
  public boolean isFragmentable() { return false; }
  public int getResponseTimeOut() { return 25000; }

  public String toTraceString()
  {
    return "??";
  }


}
