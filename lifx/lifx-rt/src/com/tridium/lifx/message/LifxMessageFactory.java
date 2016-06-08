/**
 * Copyright 2016 Tridium, Inc. All Rights Reserved.
 */
package com.tridium.lifx.message;

import com.tridium.ndriver.comm.*;


/**
 * LifxMessageFactory implementation of IMessageFactory.
 *
 * @author   Aaron D'souza
 * @creation 05-Jun-16 
 */
public class LifxMessageFactory
  implements IMessageFactory
{
  
  public LifxMessageFactory() {}
  
  public NMessage makeMessage(LinkMessage lm) 
      throws Exception
  {
    //
    // TODO - convert linkMessage driver specific NMessage
    return null;
  }

}
