/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.home.lifx.message;

import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;

import java.nio.ByteBuffer;


/**
 * LifxMessageFactory implementation of IMessageFactory.
 *
 * @author   Aaron D'souza
 * @creation 05-Jun-16 
 */
public class LifxMessageFactory
  implements IMessageFactory
{

  public static final int STATE_SERVICE_MSG_TYPE = 3;

  public LifxMessageFactory() {}
  
  public NMessage makeMessage(LinkMessage lm) 
      throws Exception
  {
    byte[] bytes = lm.getByteArray();
    ByteBuffer convertor = ByteBuffer.wrap(new byte[]{bytes[33], bytes[32]});
    int messageType = convertor.getShort();
    switch(messageType) {
      case STATE_SERVICE_MSG_TYPE:
        LifxStateService lifxStateService = new LifxStateService((BAddress) lm.address);
        lifxStateService.fromInputStream(new TypedInputStream(lm.getByteArray(),0, lm.getByteArray().length));
        return lifxStateService;
    }
    return null;
  }
}
